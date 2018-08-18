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
        storeData();

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

    /**
     * Stores the data so it can be loaded a different time
     */
    private void storeData() {
        String prefix = JasminConstants.Prefix.getPrefixBasedOnType(varType).toString();
        if(0 <= variableIndex && variableIndex <= 3) {
            addCommand(prefix + JasminConstants.STORE_VAl_SMALL + variableIndex);
        } else {
            addCommand(prefix + JasminConstants.STORE_VAL + variableIndex);
        }
    }

    @Override
    public int getVarType() {
        return varType;
    }

    @Override
    protected void loadDataOntoStack() {
        emptyCode(); // Once a variable is set
        String prefix = JasminConstants.Prefix.getPrefixBasedOnType(varType).toString();
        if(0 <= variableIndex && variableIndex <= 3) {
            addCommand(prefix + JasminConstants.LOAD_VAL_SMALL + variableIndex);
        } else {
            addCommand(prefix + JasminConstants.LOAD_VAL + variableIndex);
        }
    }

}
