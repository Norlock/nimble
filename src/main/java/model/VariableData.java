package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * In couple class for varType and variable, so String variables will only accept Strings.
 */
public class VariableData extends BaseValue {

    private final int varType, varIndex;
    public VariableData(ParserRuleContext ctx, int varType, int variableIndex) {
        super(ctx);
        this.varType = varType;
        this.varIndex = variableIndex;

        String prefix = JasminConstants.Prefix.getPrefixBasedOnType(varType).toString();
        if(0 <= variableIndex && variableIndex <= 3) {
            addCommand(prefix + JasminConstants.LOAD_VAL_SMALL + variableIndex);
        } else {
            addCommand(prefix + JasminConstants.LOAD_VAL + variableIndex);
        }
    }

    public int getVarIndex() {
        return varIndex;
    }

    @Override
    public int getDataType() {
        return varType;
    }
}
