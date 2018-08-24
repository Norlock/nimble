package model;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.JasminHelper;

public abstract class BaseExpression extends BaseValue {

    protected String label;
    protected int resultType;

    protected BaseExpression(ParserRuleContext ctx) {
        super(ctx);
    }

    public String getLabel() {
        return label;
    }

    public void setBooleanReturnValue() {
        String labelGoto = JasminHelper.getNewLabel();

        loadBooleanOnStack(true);
        setGotoRedirection(labelGoto);
        setLabel(getLabel());
        loadBooleanOnStack(false);
        setLabel(labelGoto);
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
