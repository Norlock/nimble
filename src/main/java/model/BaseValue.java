package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;

public abstract class BaseValue extends ParserData {


    protected BaseValue(ParserRuleContext ctx) {
        super(ctx);
    }

    public abstract int getVarType();
    protected abstract void loadDataOntoStack();

    public boolean isType(int type) {
        return type == getVarType();
    }

    /**
     * Only converts integer to double if needed
     */
    public void setIntToDoubleIfNeeded(int resultType) {
        if(getVarType() == NimbleParser.INTEGER_TYPE && resultType == NimbleParser.DOUBLE_TYPE)
            addCommand(JasminConstants.INT_TO_DOUBLE);
    }
}
