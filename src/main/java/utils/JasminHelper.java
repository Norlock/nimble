package utils;

import generated.NimbleParser;
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

    // String = method identifier, FunctionContainer holds the variable index and returnType.
    private static Map<String, FunctionContainer> functionContainers = new HashMap<>();

    // String = field identifier
    private static Map<String, FieldData> fields = new HashMap<>();

    public static String getNewLabel() {
        return "label" + labelIndex++;
    }

    public static String className = "";

    public static int getVariableIndex(ParserRuleContext ctx) {
        String identifier = getFunctionIdentifier(ctx);
        if(identifier == null)
            throw new ParseException(ctx, "Something unexpected has occured");

        return functionContainers.get(identifier).getVariableIndex();
    }

    /**
     * Updates the variable index.
     * @param ctx context of the caller
     * @param varType type of variable
     */
    private static void updateVariableIndex(ParserRuleContext ctx, int varType) {
        String identifier = getFunctionIdentifier(ctx);
        if(identifier == null)
            throw new ParseException(ctx, "Something unexpected has occured");

        functionContainers.get(identifier).updateVariableIndex(varType);
    }

    /**
     * Haalt de root context op, rootcontext is bijvoorbeeld de functie context of main context.
     * @param ctx
     * @return
     */
    private static ParserRuleContext getRootContext(ParserRuleContext ctx) {
        if(ctx instanceof NimbleParser.FunctionContext || ctx instanceof NimbleParser.MainContext)
            return ctx;
        else if(ctx.invokingState == -1)
            return null;
        else
            return getRootContext(ctx.getParent());
    }

    private static VariableData getVariable(String identifier, ParserRuleContext ctx) {
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

    public static String getFunctionIdentifier(ParserRuleContext ctx) {
        ParserRuleContext rootContext = getRootContext(ctx);
        if(rootContext instanceof NimbleParser.MainContext) {
            NimbleParser.MainContext mainContext = (NimbleParser.MainContext) rootContext;
            return mainContext.MAIN().getText();
        } else {
            NimbleParser.FunctionContext functionContext = (NimbleParser.FunctionContext) rootContext;
            return functionContext.IDENTIFIER().getText();
        }
    }

    /**
     * Initializes a new block for variables.
     * @param ctx block or function context.
     */
    public static void setVariableBlock(NimbleParser.BlockContext ctx) {
        String identifier = getFunctionIdentifier(ctx);
        if(!functionContainers.containsKey(identifier))
            functionContainers.put(identifier, new FunctionContainer(identifier));

        // After variable indexes are set, set var container.
        variables.put(ctx.hashCode(), new VariableContainer());
    }

    public static FunctionContainer getFunctionContainer(ParserRuleContext ctx) {
        return functionContainers.get(getFunctionIdentifier(ctx));
    }

    public static FunctionContainer getFunctionContainer(String identifier) {
        return functionContainers.get(identifier);
    }

    /**
     * Initializes a new block for variables.
     * @param ctx block or function context.
     */
    public static void setVariableBlock(NimbleParser.FunctionContext ctx) {
        String identifier = getFunctionIdentifier(ctx);
        functionContainers.put(identifier, new FunctionContainer(identifier)); // 0 is this.

        // After variable indexes are set, set var container.
        variables.put(ctx.hashCode(), new VariableContainer());
    }

    public static void setVariable(ParserRuleContext ctx, String identifier, VariableData variable) {
        int hashCode = getEncapsulatingBlockHashCode(ctx);
        VariableContainer varContainer = variables.get(hashCode);
        varContainer.put(identifier, variable);
        updateVariableIndex(ctx, variable.getDataType());
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
        } else if(ctx instanceof  NimbleParser.BlockContext || ctx instanceof NimbleParser.FunctionContext) {
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
        field.addCommand(JasminConstants.PUT_STATIC + staticField + " " + JasminConstants.DataType.getDataType(varType));
        return field;
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

    public static ParserData getReturnAssignment(ParserRuleContext ctx) {
        FunctionContainer container = JasminHelper.getFunctionContainer(ctx);
        if(!container.setReturnStatementAndValidate(NimbleParser.VOID))
            throw new ParseException(ctx, "Invalid return statement");

        ParserData returnData = new ParserData(ctx);
        returnData.addCommand(JasminConstants.RETURN);
        return returnData;
    }

    public static ParserData getReturnAssignment(ParserRuleContext ctx, BaseValue value) {
        FunctionContainer container = JasminHelper.getFunctionContainer(ctx);
        if(!container.setReturnStatementAndValidate(value.getDataType()))
            throw new ParseException(ctx, "Invalid return statement");

        int returnType = container.getReturnType();
        ParserData returnData = getDataAssignment(ctx, returnType, value);
        returnData.addCommand(JasminConstants.Prefix.getPrefix(returnType) + JasminConstants.RETURN);
        return returnData;
    }

    public static ParserData getPrintAssignment(ParserRuleContext ctx, BaseValue value) {
        ParserData print = new ParserData(ctx);
        print.addCommand(JasminConstants.LOAD_SYSO_ONTO_STACK);

        print.appendCode(getDataAssignment(ctx, value.getDataType(), value));

        // Call println
        print.addCommand(JasminConstants.INVOKE_VIRTUAL + "java/io/PrintStream/println("
                + JasminConstants.DataType.getDataType(value.getDataType()) + ")V");

        return print;
    }

    private static ParserData getDataAssignment(ParserRuleContext ctx, int varType, BaseValue value) {
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

    public static Map<String, FieldData> getFields() {
        return fields;
    }
}
