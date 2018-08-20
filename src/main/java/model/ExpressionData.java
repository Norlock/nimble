package model;

import generated.NimbleParser;
import main.ParseException;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * ExpressionData is validated,
 */
public class ExpressionData extends BaseValue {

    private final BaseValue left;
    private final BaseValue right;
    private int resultType;
    private String label;

    public boolean isBooleanExpression() {
        return resultType == NimbleParser.BOOLEAN_TYPE;
    }

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

    public void setRelationalExpression(int operatorType) {
        if(left.getDataType() != right.getDataType()) {
            throwError("Types are not equal");
        } else if(left.isType(NimbleParser.STRING_TYPE) || left.isType(NimbleParser.BOOLEAN_TYPE)) {
            throwError("This type is not suitable for relation expressions");
        } else {
            loadDataOntoStack(NimbleParser.BOOLEAN_TYPE);
            label = JasminHelper.getNewLabel();

            // Javabytecode uses opposistion
            switch (operatorType) {
                case NimbleParser.LEFT_GREATER: // x > x
                    addCommand(JasminConstants.IF_INTEGER_LEFT_IS_LESSER_OR_EQUAL + label);
                    break;
                case NimbleParser.LEFT_GREATER_OR_EQUAL: // x >= x
                    addCommand(JasminConstants.IF_INTEGER_LEFT_IS_LESSER + label);
                    break;
                case NimbleParser.LEFT_LESSER: // x < x
                    addCommand(JasminConstants.IF_INTEGER_LEFT_GREATER_OR_EQUAL + label);
                    break;
                case NimbleParser.LEFT_LESSER_OR_EQUAL: // x <= x
                    addCommand(JasminConstants.IF_INTEGER_LEFT_IS_GREATER + label);
                    break;
            }

            finalizeBooleanExpression();
        }
    }

    public void setAddExpression() {
        if (left.isType(NimbleParser.STRING_TYPE)) {
            setAdditiveExpressionString(); // toString gebruiken om ook andere types te gebruiken
        } else if (left.isType(NimbleParser.BOOLEAN_TYPE) || right.isType(NimbleParser.BOOLEAN_TYPE)) {
            throwError("Can't add with a boolean");
        } else if (right.isType(NimbleParser.STRING_TYPE)) {
            throwError("Can't add with a string");
        } else if (left.isType(NimbleParser.DOUBLE_TYPE)) {
            if (right.isType(NimbleParser.DOUBLE_TYPE) || right.isType(NimbleParser.INTEGER_TYPE)) {
                setAdditiveExpressionDouble();
            } else {
                throwError("Can't add this type with a double");
            }
        } else if (left.isType(NimbleParser.INTEGER_TYPE)) {
            if(right.isType(NimbleParser.DOUBLE_TYPE)) {
                setAdditiveExpressionDouble();
            } else if (right.isType(NimbleParser.INTEGER_TYPE)) {
                setAdditiveExpressionInteger();
            }
        }
    }

    public void setSubtractExpression() {
        if(left.isType(NimbleParser.STRING_TYPE) || right.isType(NimbleParser.STRING_TYPE))
            throw new ParseException(getCtx(), "Can't subtract from a String");
        else if (left.isType(NimbleParser.BOOLEAN_TYPE) || right.isType(NimbleParser.BOOLEAN_TYPE))
            throw new ParseException(getCtx(), "Can't subtract from a boolean");
        else if (left.isType(NimbleParser.DOUBLE_TYPE)) {
            if(right.isType(NimbleParser.DOUBLE_TYPE) || right.isType(NimbleParser.INTEGER_TYPE)) {
                setSubtractExpressionDouble();
            } else {
                throwError("Can't subtract this type with a double");
            }
        } else {
            if(right.isType(NimbleParser.INTEGER_TYPE)) {
                setSubtractExpressionInteger();
            } else if(right.isType(NimbleParser.DOUBLE_TYPE)) {
                setSubtractExpressionDouble();
            }
        }
    }

    /**
     * Compares two values
     * @param operatorType (is equal / not equal)
     */
    public void setCompareExpression(int operatorType) {
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

        finalizeBooleanExpression();
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
        addCommand(JasminConstants.APPEND_STRING_BUILDER);
        appendCode(right);
        addCommand(JasminConstants.APPEND_STRING_BUILDER);
        addCommand(JasminConstants.STRING_BUILDER_TO_STRING);
    }

    private void compareIntegers(boolean isEqualOperator, String label) {
        if(isEqualOperator) {
            addCommand(JasminConstants.IF_INTEGER_COMPARE_NOT_EQUAL + label);
        } else {
            addCommand(JasminConstants.IF_INTEGER_COMPARE_EQUAL + label);
        }
    }

    private void compareDoubles(boolean isEqualOperator, String label) {
        addCommand(JasminConstants.COMPARE_DOUBLE);
        if(isEqualOperator) { // Jasmin uses opposition.
            addCommand(JasminConstants.IF_NOT_EQUAL + label);
        } else {
            addCommand(JasminConstants.IF_EQUAL + label);
        }
    }

    private void compareStrings(boolean isEqualOperator, String label) {
        addCommand(JasminConstants.COMPARE_STRING);
        if(isEqualOperator) { // Jasmin uses opposition.
            addCommand(JasminConstants.IF_NOT_EQUAL + label);
        } else {
            addCommand(JasminConstants.IF_EQUAL + label);
        }
    }

    private void finalizeBooleanExpression() {
        // If this is relational expression for a variable it needs to return the correct value
        // For if statements it won't return any value
        if(getCtx().getParent() instanceof NimbleParser.VariableDeclarationContext
                || getCtx().getParent() instanceof  NimbleParser.VariableAssignmentContext
                || getCtx().getParent() instanceof  NimbleParser.PrintStatementContext) {
            String labelGoto = JasminHelper.getNewLabel();

            loadBooleanOnStack(true);
            gotoLabel(labelGoto);
            setLabel(label);
            loadBooleanOnStack(false);
            setLabel(labelGoto);
        }
    }

    public String getLabel() {
        return label;
    }

    @Override
    public int getDataType() {
        return resultType;
    }

    /**
     * Helper method, not to use as public. Will load the left and right side onto stack.
     */
    private void loadDataOntoStack(int resultType) {
        this.resultType = resultType;
        appendCode(left);
        if(JasminHelper.castToDouble(left.getDataType(), resultType))
            addCommand(JasminConstants.INT_TO_DOUBLE);

        appendCode(right);
        if(JasminHelper.castToDouble(right.getDataType(), resultType))
            addCommand(JasminConstants.INT_TO_DOUBLE);
    }
}
