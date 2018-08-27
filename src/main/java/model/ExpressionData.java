package model;

import generated.NimbleParser;
import model.commands.BranchOffCommand;
import model.commands.BranchOffType;
import model.commands.JavaByteCommand;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.JasminConstants;
import utils.JasminHelper;

/**
 * ExpressionData is validated,
 */
public class ExpressionData extends BaseExpression {

    private final BaseValue left;
    private final BaseValue right;

    /**
     *
     * @param ctx context
     * @param left left side value
     * @param right right side value
     */
    public ExpressionData(ParserRuleContext ctx, final BaseValue left, final BaseValue right) {
        super(ctx);
        this.left = left;
        this.right = right;
    }

    public final void setAndExpression() {
        if(!left.isBoolean() && !right.isBoolean()) {
            throwError("And expressions can only contain boolean expressions.");
        } else {
            // This label will overwrite the other ones.
            label = JasminHelper.getNewLabel();
            JavaByteCommand leftCmd = left.getLastCmdCopy();
            JavaByteCommand rightCmd = right.getLastCmdCopy();

            if(leftCmd.isBranchOffCommand()) {
                leftCmd.cast().setLabel(label);
            } else {
                left.addCommand(BranchOffType.IF_EQUAL, label); // Value or Variable
            }
            if(rightCmd.isBranchOffCommand()) {
                rightCmd.cast().setLabel(label);
            } else {
                right.addCommand(BranchOffType.IF_EQUAL, label); // Value or Variable
            }

            loadDataOntoStack(NimbleParser.BOOLEAN_TYPE);
        }
    }

    public final void setOrExpression() {
        if(!left.isBoolean() && !right.isBoolean()) {
            throwError("Or expressions can only contain boolean expressions.");
        } else {
            // This label will overwrite the other ones. So the left and right side have the same branch off label.
            String gotoLabel = JasminHelper.getNewLabel();
            label = JasminHelper.getNewLabel();
            JavaByteCommand leftCmd = left.getLastCmdCopy();
            JavaByteCommand rightCmd = right.getLastCmdCopy();

            // Or expressions inverts the left side and goes to block immediately
            if(leftCmd.isBranchOffCommand()) {
                BranchOffCommand cmd = leftCmd.cast();
                cmd.invertType();
                cmd.setLabel(gotoLabel);
                left.updateLastCmd(leftCmd);
            } else {
                left.addCommand(BranchOffType.IF_NOT_EQUAL, gotoLabel);
            }

            // Right side is normal
            if(rightCmd.isBranchOffCommand()) {
                rightCmd.cast().setLabel(label);
            } else {
                right.addCommand(BranchOffType.IF_EQUAL, label); // Value or Variable
            }

            right.setLabel(gotoLabel);

            loadDataOntoStack(NimbleParser.BOOLEAN_TYPE);
        }
    }

    public final void setMultiplicationExpression(int operatorType) {
        if(!left.isNumber() && !right.isNumber())
            throwError("Multiplication expressions can only contain integers or doubles");
        else if(left.isType(NimbleParser.INTEGER_TYPE) && right.isType(NimbleParser.INTEGER_TYPE))
            loadDataOntoStack(NimbleParser.INTEGER_TYPE);
        else
            loadDataOntoStack(NimbleParser.DOUBLE_TYPE);

        if (operatorType == NimbleParser.MULTIPLY)
            addCommand(JasminConstants.Prefix.getPrefix(resultType) + JasminConstants.MULTIPLY);
        else if (operatorType == NimbleParser.DIVIDE)
            addCommand(JasminConstants.Prefix.getPrefix(resultType) + JasminConstants.DIVIDE);
        else
            addCommand(JasminConstants.Prefix.getPrefix(resultType) + JasminConstants.MODULO);

    }

    public final void setRelationalExpression(int operatorType) {
        if(!left.isNumber() || !right.isNumber()) {
            throwError("Relational expressions can only be number types (int, double).");
        } else {
            loadDataOntoStack(NimbleParser.BOOLEAN_TYPE);
            label = JasminHelper.getNewLabel();

            if(left.isType(NimbleParser.INTEGER_TYPE) && right.isType(NimbleParser.INTEGER_TYPE)) {
                setRelationalExpressionInteger(operatorType, label);
            } else if (left.isType(NimbleParser.DOUBLE_TYPE)) {
                setRelationalExpressionDouble(operatorType, label);
            }
        }
    }

    private void setRelationalExpressionInteger(int operatorType, String label) {
        // Javabytecode uses opposistion
        switch (operatorType) {
            case NimbleParser.LEFT_GREATER: // x > x
                addCommand(BranchOffType.IF_INTEGER_LEFT_IS_LESSER_OR_EQUAL, label);
                break;
            case NimbleParser.LEFT_GREATER_OR_EQUAL: // x >= x
                addCommand(BranchOffType.IF_INTEGER_LEFT_IS_LESS, label);
                break;
            case NimbleParser.LEFT_LESSER: // x < x
                addCommand(BranchOffType.IF_INTEGER_LEFT_GREATER_OR_EQUAL, label);
                break;
            case NimbleParser.LEFT_LESSER_OR_EQUAL: // x <= x
                addCommand(BranchOffType.IF_INTEGER_LEFT_IS_GREATER, label);
                break;
        }
    }

    private void setRelationalExpressionDouble(int operatorType, String label) {
        // Javabytecode uses opposistion
        switch (operatorType) {
            case NimbleParser.LEFT_GREATER: // x > x
                addCommand(JasminConstants.DOUBLE_COMPARE_IF_LEFT_IS_LESS);
                addCommand(BranchOffType.IF_LESS_OR_EQUAL, label);
                break;
            case NimbleParser.LEFT_GREATER_OR_EQUAL: // x >= x
                addCommand(JasminConstants.DOUBLE_COMPARE_IF_LEFT_IS_LESS);
                addCommand(BranchOffType.IF_LESS, label);
                break;
            case NimbleParser.LEFT_LESSER: // x < x
                addCommand(JasminConstants.DOUBLE_COMPARE_IF_LEFT_IS_GREATER);
                addCommand(BranchOffType.IF_GREATER_OR_EQUAL, label);
                break;
            case NimbleParser.LEFT_LESSER_OR_EQUAL: // x <= x
                addCommand(JasminConstants.DOUBLE_COMPARE_IF_LEFT_IS_GREATER);
                addCommand(BranchOffType.IF_GREATER, label);
                break;
        }
    }

    public final void setAddExpression() {
        if (left.isType(NimbleParser.STRING_TYPE) || right.isType(NimbleParser.STRING_TYPE)) {
            setAdditiveExpressionString();
        } else if (!left.isNumber() && !right.isNumber()) {
            throwError("Additive expressions can only contain numbers, or start with a string.");
        } else if(left.isType(NimbleParser.INTEGER_TYPE) && right.isType(NimbleParser.INTEGER_TYPE)) {
            setAdditiveExpressionInteger();
        } else {
            setAdditiveExpressionDouble();
        }
    }

    public final void setSubtractExpression() {
        if (!left.isNumber() && !right.isNumber()) {
            throwError("Subtract expressions can only contain numbers.");
        } else if(left.isType(NimbleParser.INTEGER_TYPE) && right.isType(NimbleParser.INTEGER_TYPE)) {
            setSubtractExpressionInteger();
        } else {
            setSubtractExpressionDouble();
        }
    }

    /**
     * Compares two values
     * @param operatorType (is equal / not equal)
     */
    public final void setCompareExpression(int operatorType) {
        boolean isEqualOperator = operatorType == NimbleParser.EQUAL;

        if(left.getDataType() != right.getDataType())
            throwError("Can't compare two different types of variables");

        label = JasminHelper.getNewLabel();
        loadDataOntoStack(NimbleParser.BOOLEAN_TYPE); // Compare == boolean

        switch (left.getDataType()) {
            case NimbleParser.INTEGER_TYPE:
            case NimbleParser.BOOLEAN_TYPE: // booleans are either 0 or 1
                compareIntegers(isEqualOperator, label);
                break;
            case NimbleParser.DOUBLE_TYPE:
                compareDoubles(isEqualOperator, label);
                break;
            case NimbleParser.STRING_TYPE:
                compareStrings(isEqualOperator, label);
                break;
            default:
                throwError("Unknown type");
        }
    }

    private void setSubtractExpressionInteger() {
        loadDataOntoStack(NimbleParser.INTEGER_TYPE);
        setSub(JasminConstants.Prefix.INTEGER_OR_BOOLEAN);
    }

    private void setAdditiveExpressionInteger() {
        loadDataOntoStack(NimbleParser.INTEGER_TYPE);
        setAdd(JasminConstants.Prefix.INTEGER_OR_BOOLEAN);
    }

    private void setSubtractExpressionDouble() {
        loadDataOntoStack(NimbleParser.DOUBLE_TYPE);
        setSub(JasminConstants.Prefix.DOUBLE);
    }

    private void setAdditiveExpressionDouble() {
        loadDataOntoStack(NimbleParser.DOUBLE_TYPE);
        setAdd(JasminConstants.Prefix.DOUBLE);
    }

    private void setSub(JasminConstants.Prefix prefix) {
        addCommand(prefix.toString() + JasminConstants.SUB);
    }

    private void setAdd(JasminConstants.Prefix prefix) {
        addCommand(prefix.toString() + JasminConstants.ADD);
    }

    private void setAdditiveExpressionString() {
        resultType = NimbleParser.STRING_TYPE;
        addCommand(JasminConstants.CONSTRUCT_STRING_BUILDER);
        addCommand(JasminConstants.DUPLICATE_VALUE_ONTOP_OF_STACK);
        addCommand(JasminConstants.INIT_STRING_BUILDER);
        appendCode(left);
        addCommand(left.getAppendString());
        appendCode(right);
        addCommand(right.getAppendString());
        addCommand(JasminConstants.STRING_BUILDER_TO_STRING);
    }

    private void compareIntegers(boolean isEqualOperator, String label) {
        if(isEqualOperator) {
            addCommand(BranchOffType.IF_INTEGER_COMPARE_NOT_EQUAL, label);
        } else {
            addCommand(BranchOffType.IF_INTEGER_COMPARE_EQUAL, label);
        }
    }

    private void compareDoubles(boolean isEqualOperator, String label) {
        addCommand(JasminConstants.COMPARE_DOUBLE);
        if(isEqualOperator) { // Jasmin uses opposition.
            addCommand(BranchOffType.IF_NOT_EQUAL, label);
        } else {
            addCommand(BranchOffType.IF_EQUAL, label);
        }
    }

    private void compareStrings(boolean isEqualOperator, String label) {
        addCommand(JasminConstants.COMPARE_STRING);
        if(isEqualOperator) { // Jasmin uses opposition.
            addCommand(BranchOffType.IF_NOT_EQUAL, label);
        } else {
            addCommand(BranchOffType.IF_EQUAL, label);
        }
    }

    @Override
    public int getDataType() {
        return resultType;
    }

    @Override
    protected void loadDataOntoStack(int resultType) {
        super.loadDataOntoStack(resultType);
        this.resultType = resultType;

        appendCode(left);
        boolean castToDouble = left.isNumber() && right.isNumber() && left.getDataType() != right.getDataType();
        if(!left.isType(NimbleParser.DOUBLE_TYPE) && castToDouble) {
            addCommand(left.getCastCommand(NimbleParser.DOUBLE_TYPE));
        }

        appendCode(right);
        if (!right.isType(NimbleParser.DOUBLE_TYPE) && castToDouble) {
            addCommand(right.getCastCommand(NimbleParser.DOUBLE_TYPE));
        }

    }
}
