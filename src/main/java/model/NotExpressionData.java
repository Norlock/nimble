package model;

import generated.NimbleParser;
import main.ParseException;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.JasminHelper;

public class NotExpressionData extends BaseExpression {

    private final BaseValue value;

    public NotExpressionData(ParserRuleContext ctx, BaseValue value) {
        super(ctx);
        this.value = value;

        if(value.getDataType() != NimbleParser.BOOLEAN_TYPE) {
            throwError("Not expression only allowed for boolean types");
        } else if (value instanceof ExpressionData) {
            loadDataOntoStack(NimbleParser.BOOLEAN_TYPE);
            JavaByteCommand cmd = getLastCmd();
            if(cmd.isBranchOffCommand()) {
                cmd.cast().invertType();
            } else {
                throw new ParseException(ctx, "Invalid expression.");
            }
        } else {
            loadDataOntoStack(NimbleParser.BOOLEAN_TYPE);
            addCommand(BranchOffType.IF_NOT_EQUAL, JasminHelper.getNewLabel());
        }

    }

    @Override
    protected void loadDataOntoStack(int resultType) {
        super.loadDataOntoStack(resultType);
        appendCode(value);
    }
}
