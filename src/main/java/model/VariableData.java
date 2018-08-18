package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * In couple class for varType and variable, so String variables will only accept Strings.
 */
public class VariableData extends BaseValue {

    private final int variableIndex, varType;

    public VariableData(ParserRuleContext ctx, int varType) {
        this(ctx, varType, new ValueData(ctx, varType));
    }

    public VariableData(ParserRuleContext ctx, int varType, BaseValue baseValue) {
        super(ctx);
        this.varType = varType;
        this.variableIndex = JasminHelper.getVariableIndex();

        validate(baseValue.getVarType());

        baseValue.setIntToDoubleIfNeeded(varType);
        appendCode(baseValue);

        String prefix = JasminConstants.Prefix.getPrefixBasedOnType(varType).toString();
        if(0 <= variableIndex && variableIndex <= 3) {
            addCommand(prefix + JasminConstants.STORE_VAl_SMALL + variableIndex);
        } else {
            addCommand(prefix + JasminConstants.STORE_VAL + variableIndex);
        }

        JasminHelper.updateVariableIndex(varType);
    }

    public VariableData(ParserRuleContext ctx, int varType, VariableData variableData) {
        super(ctx);
        this.varType = varType;
        this.variableIndex = JasminHelper.getVariableIndex();

        validate(variableData.getVarType());


        variableData.setIntToDoubleIfNeeded(varType);
        appendCode(baseValue);

        String prefix = JasminConstants.Prefix.getPrefixBasedOnType(varType).toString();
        if(0 <= variableIndex && variableIndex <= 3) {
            addCommand(prefix + JasminConstants.STORE_VAl_SMALL + variableIndex);
        } else {
            addCommand(prefix + JasminConstants.STORE_VAL + variableIndex);
        }

        JasminHelper.updateVariableIndex(varType);
    }

    /**
     * Throws exception if for example integer is assigned to a string
     */
    private void validate(int valueType) {
        // If statement for readability
        if(varType == valueType || (varType == NimbleParser.DOUBLE_TYPE && valueType == NimbleParser.INTEGER_TYPE))
            return;
        else {
            String errorMsg = "Cannot assign variable"
                    + " to varType " + NimbleParser.VOCABULARY.getLiteralName(valueType).replace("'","")
                    + " for identifier ";

            throwError(errorMsg);
        }
    }

    @Override
    public int getVarType() {
        return varType;
    }

    protected void loadVariableOntoStack() {
        emptyCode(); // Once a variable is set it needs clean for load
        String prefix = JasminConstants.Prefix.getPrefixBasedOnType(varType).toString();
        if(0 <= variableIndex && variableIndex <= 3) {
            addCommand(prefix + JasminConstants.LOAD_VAL_SMALL + variableIndex);
        } else {
            addCommand(prefix + JasminConstants.LOAD_VAL + variableIndex);
        }
    }

}
