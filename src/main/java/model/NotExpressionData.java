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
        loadDataOntoStack(NimbleParser.BOOLEAN_TYPE);

        if(value.getDataType() != NimbleParser.BOOLEAN_TYPE) {
            throwError("Not expression only allowed for boolean types");
        } else if (value instanceof ExpressionData) {
            JavaByteCommand cmd = getLastCmd();
            if(cmd.isBranchOffCommand()) {
                BranchOffCommand branchOffCommand = cmd.cast();
                branchOffCommand.invertType();
                label = branchOffCommand.getLabel();
            } else {
                throw new ParseException(ctx, "Invalid expression.");
            }
        } else {
            label = JasminHelper.getNewLabel();
            addCommand(BranchOffType.IF_NOT_EQUAL, label);
        }

    }

    @Override
    protected void loadDataOntoStack(int resultType) {
        super.loadDataOntoStack(resultType);
        appendCode(value);
    }
}
