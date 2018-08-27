package model;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.JasminConstants;

/**
 * In couple class for varType and variable, so String variables will only accept Strings.
 */
public class VariableData extends BaseValue {

    private final int varType, varIndex;

    public VariableData(ParserRuleContext ctx, int varType, int variableIndex) {
        super(ctx);
        this.varType = varType;
        this.varIndex = variableIndex;

        String prefix = JasminConstants.Prefix.getPrefix(varType).toString();
        if(0 <= variableIndex && variableIndex <= 3) {
            addCommand(prefix + JasminConstants.LOAD_VAL_SMALL + variableIndex);
        } else {
            addCommand(prefix + JasminConstants.LOAD_VAL + variableIndex);
        }
    }

    /**
     * Copy constructor, needed for fields and variables since they can be reused.
     * @param variableData
     */
    public VariableData(VariableData variableData) {
        this(variableData.getCtx(), variableData.getDataType(), variableData.getVarIndex());
    }

    public int getVarIndex() {
        return varIndex;
    }

    @Override
    public int getDataType() {
        return varType;
    }
}
