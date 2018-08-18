package model;

import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

public abstract class BaseValue extends ParserData {


    protected BaseValue(ParserRuleContext ctx) {
        super(ctx);
    }


    protected BaseValue(ParserRuleContext ctx, ArrayList<String> jasminCode) {
        super(ctx, jasminCode);
    }

    public abstract int getType();
    protected abstract void loadDataOntoStack();
    protected abstract void loadDataOntoStack(int asType);

    public boolean isType(int type) {
        return type == getType();
    }

    /**
     * Loads numeric type on stack (e.g. iconst_3;
     * @param value
     * @return
     */
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

    protected void setSub(JasminConstants.Prefix prefix) {
        addCommand(prefix.toString() + JasminConstants.SUB);
    }

    protected void setAdd(JasminConstants.Prefix prefix) {
        addCommand(prefix.toString() + JasminConstants.ADD);
    }

}
