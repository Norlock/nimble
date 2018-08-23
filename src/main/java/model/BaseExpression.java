package model;

import org.antlr.v4.runtime.ParserRuleContext;

public abstract class BaseExpression extends BaseValue {

    protected String label;
    protected int resultType;

    protected BaseExpression(ParserRuleContext ctx) {
        super(ctx);
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int getDataType() {
        return resultType;
    }

    /**
     * Will load the passed on value onto the stack.
     * @param resultType result type of this expression (e.g. bool string).
     */
    protected void loadDataOntoStack(int resultType) {
        this.resultType = resultType;
    }
}
