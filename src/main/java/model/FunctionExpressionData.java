package model;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.FunctionContainer;

public class FunctionExpressionData extends BaseExpression {

    private final FunctionContainer container;

    public FunctionExpressionData(ParserRuleContext ctx, FunctionContainer container) {
        super(ctx);
        this.container = container;
        this.resultType = container.getReturnType();
    }

    public void setFunctionCall() {
        addCommand(container.getFunctionCallStr());
    }
}
