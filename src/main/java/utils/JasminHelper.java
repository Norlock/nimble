package utils;

import generated.NimbleParser;
import main.Nimble;
import main.ParseException;
import model.*;
import org.antlr.v4.runtime.ParserRuleContext;

import java.nio.file.Paths;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public final class JasminHelper {
    private static int labelIndex = 1;

    // store variables Integer = hashcode.
    private static Map<Integer, VariableContainer> variables = new HashMap<>();

    // String = method identifier, integer is variable index.
    private static Map<String, Integer> variableIndexes = new HashMap<>();

    // String = field identifier
    private static Map<String, FieldData> fields = new HashMap<>();

    public static String getNewLabel() {
        return "label" + labelIndex++;
    }

    public static String className = "";

    public static int getVariableIndex(ParserRuleContext ctx) {
        ParserRuleContext rootContext = getRootContext(ctx);
        if(rootContext == null)
            throw new ParseException(ctx, "Something unexpected has occured");
        if(rootContext instanceof NimbleParser.MainContext) {
            NimbleParser.MainContext mainContext = (NimbleParser.MainContext) rootContext;
            return variableIndexes.get(mainContext.MAIN().getText());
        } else {
            NimbleParser.FunctionContext functionContext = (NimbleParser.FunctionContext) rootContext;
            return variableIndexes.get(functionContext.IDENTIFIER().getText());
        }
    }

    /**
     * Updates the variable index.
     * @param ctx context of the caller
     * @param type type of variable
     */
    public static void updateVariableIndex(ParserRuleContext ctx, int type) {
        String identifier;
        ParserRuleContext rootContext = getRootContext(ctx);

        if(rootContext == null)
            throw new ParseException(ctx, "Something unexpected has occured");
        if(rootContext instanceof NimbleParser.MainContext) {
            NimbleParser.MainContext mainContext = (NimbleParser.MainContext) rootContext;
            identifier = mainContext.MAIN().getText();
        } else {
            NimbleParser.FunctionContext functionContext = (NimbleParser.FunctionContext) rootContext;
            identifier = functionContext.IDENTIFIER().getText();
        }

        int index = variableIndexes.get(identifier);
        variableIndexes.put(identifier, getIncrementedVariableIndex(index, type));
    }

    private static int getIncrementedVariableIndex(int variableIndex, int type) {
        if(type == NimbleParser.INTEGER_TYPE
                || type == NimbleParser.BOOLEAN_TYPE
                || type == NimbleParser.STRING_TYPE) {
            return variableIndex+1;
        } else if(type == NimbleParser.DOUBLE_TYPE) {
            return variableIndex+2;
        } else {
            throw new RuntimeException("Unknown type");
        }
    }


    private static ParserRuleContext getRootContext(ParserRuleContext ctx) {
        if(ctx instanceof NimbleParser.FunctionContext || ctx instanceof NimbleParser.MainContext)
            return ctx;
        else if(ctx.invokingState == -1)
            return null;
        else
            return getRootContext(ctx.getParent());

    }

    public static VariableData getVariable(String identifier, ParserRuleContext ctx) {
        HashSet<Integer> hashCodes = getHashCodesRecursivelyUp(ctx, new HashSet<>());

        for (int hashCode : hashCodes) {
            VariableContainer variableContainer = variables.get(hashCode);
            if (variableContainer.containsKey(identifier)) {
                return variableContainer.get(identifier);
            }
        }

        return null;
    }

    public static BaseValue getFieldOrVariable(String identifier, ParserRuleContext ctx) {
        VariableData variable = getVariable(identifier, ctx);
        if(variable != null)
            return variable;
        else
            return fields.get(identifier);
    }

    public static void setVariableBlock(ParserRuleContext ctx) {
        ParserRuleContext rootContext = getRootContext(ctx);
        if(rootContext instanceof NimbleParser.MainContext) {
            NimbleParser.MainContext mainContext = (NimbleParser.MainContext) rootContext;
            variableIndexes.put(mainContext.MAIN().getText(), 1); // 0 is this.
        } else {
            NimbleParser.FunctionContext functionContext = (NimbleParser.FunctionContext) rootContext;
            variableIndexes.put(functionContext.IDENTIFIER().getText(), 1); // 0 is this.
        }

        // After variable indexes are set, set var container.
        variables.put(ctx.hashCode(), new VariableContainer());
    }

    public static void setVariable(ParserRuleContext ctx, String identifier, VariableData variable) {
        int hashCode = getEncapsulatingBlockHashCode(ctx);
        VariableContainer varContainer = variables.get(hashCode);
        varContainer.put(identifier, variable);
    }

    public static void setField(String identifier, FieldData fieldData) {
        fields.put(identifier, fieldData);
    }

    public static boolean isField(String id) {
        return fields.containsKey(id);
    }

    /**
     * Returns the hash codes for each block in the tree of context.
     *
     * @param ctx context of caller.
     * @return hash codes of the blocks.
     */
    private static HashSet<Integer> getHashCodesRecursivelyUp(ParserRuleContext ctx, HashSet<Integer> hashCodes) {
        if(ctx.invokingState == -1) {
            return hashCodes;
        } else if(ctx instanceof  NimbleParser.BlockContext
                || ctx instanceof NimbleParser.FunctionContext) {
            hashCodes.add(ctx.hashCode());
        }

        return getHashCodesRecursivelyUp(ctx.getParent(), hashCodes);
    }

    /**
     * Returns the hashcode of the first encapsulating block based upon the caller context.
     *
     * @param ctx context of caller.
     * @return
     */
    private static int getEncapsulatingBlockHashCode(ParserRuleContext ctx) {
        if(ctx.invokingState == -1) {
            throw new ParseException(ctx, "Something unexpected has occurred.");
        } else if(ctx instanceof  NimbleParser.BlockContext
                || ctx instanceof NimbleParser.FunctionContext) {
            return ctx.hashCode();
        } else {
            return getEncapsulatingBlockHashCode(ctx.getParent());
        }
    }

    public static ParserData getFieldAssignment(ParserRuleContext ctx, int varType, String id, BaseValue value) {
        ParserData field = getDataAssignment(ctx, varType, value);
        String staticField = Paths.get(JasminHelper.className, id).toString();
        field.addCommand(JasminConstants.PUT_STATIC + staticField + " " + JasminConstants.DataType.getDataTypeStr(varType));
        return field;
    }

    public static ParserData getDataAssignment(ParserRuleContext ctx, int varType, BaseValue value) {
        ParserData data = new ParserData(ctx);
        boolean castable = value.isAutoCastable(varType);
        int valueType = value.getDataType();

        if (varType != valueType && !castable) {
            data.throwError("Cannot assign this type of value to the variable.");
        }

        if (value instanceof BaseExpression && value.isBoolean()) {
            BaseExpression baseExpression = (BaseExpression) value;
            baseExpression.setBooleanReturnValue();
        }

        data.appendCode(value);
        if (castable)
            data.addCommand(value.getCastCommand(varType));

        return data;
    }

    public static ParserData getVariableAssignment(ParserRuleContext ctx, int varType, int varIndex, BaseValue value) {
        ParserData variable = getDataAssignment(ctx, varType, value);

        String prefix = JasminConstants.Prefix.getPrefix(varType).toString();
        if (0 <= varIndex && varIndex <= 3) {
            variable.addCommand(prefix + JasminConstants.STORE_VAl_SMALL + varIndex);
        } else {
            variable.addCommand(prefix + JasminConstants.STORE_VAL + varIndex);
        }

        return variable;
    }

    public static Map<String, FieldData> getFields() {
        return fields;
    }
}
