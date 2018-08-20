package model;

import org.antlr.v4.runtime.ParserRuleContext;


public abstract class BaseValue extends ParserData {

    protected BaseValue(ParserRuleContext ctx) {
        super(ctx);
    }

    public abstract int getDataType();
    public boolean isType(int type) {
        return type == getDataType();
    }

    protected void loadIntegerOntoStack(int value) {
        if (0 <= value && value <= 5) {
            addCommand(JasminConstants.INTEGER_CONST + value);
        } else if (value == -1) {
            addCommand(JasminConstants.INTEGER_CONST + "m1");
        } else {
            addCommand(JasminConstants.INTEGER_ADD + value);
        }
    }

    protected void loadBooleanOnStack(boolean value) {
        addCommand(JasminConstants.INTEGER_CONST + (value ? JasminConstants.TRUE : JasminConstants.FALSE));
    }

    protected void loadDoubleOntoStack(double value) {
        addCommand(JasminConstants.DOUBLE_ADD + value);
    }

    protected void loadStringOntoStack(String value) {
        addCommand(JasminConstants.STRING_ADD + value);
    }

}
