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

    /**
     *
     * @param ctx
     * @param left
     * @param right
     */
    public ExpressionData(ParserRuleContext ctx, final BaseValue left, final BaseValue right) {
        super(ctx);
        this.left = left;
        this.right = right;
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
    public String setCompareExpression(int operatorType) {
        boolean isEqualOperator = operatorType == NimbleParser.EQUAL;

        if(!isEqualOperator && operatorType != NimbleParser.NOT_EQUAL)
            throwError("Unknown operator type");

        String label = JasminHelper.getNewLabel();

        resultType = NimbleParser.BOOLEAN_TYPE; // Compare == boolean
        left.loadDataOntoStack();
        right.loadDataOntoStack();

        switch (left.getType()) {
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
        return label;
    }

    private void setSubtractExpressionInteger() {
        resultType = NimbleParser.INTEGER_TYPE;
        left.loadDataOntoStack();
        right.loadDataOntoStack();

        setSub(JasminConstants.Prefix.DOUBLE);
    }

    private void setAdditiveExpressionInteger() {
        resultType = NimbleParser.INTEGER_TYPE;
        left.loadDataOntoStack();
        right.loadDataOntoStack();

        setAdd(JasminConstants.Prefix.DOUBLE);
    }

    private void setSubtractExpressionDouble() {
        resultType = NimbleParser.DOUBLE_TYPE;
        left.loadDataOntoStack(resultType);
        right.loadDataOntoStack(resultType);

        setSub(JasminConstants.Prefix.DOUBLE);
    }

    private void setAdditiveExpressionDouble() {
        resultType = NimbleParser.DOUBLE_TYPE;
        left.loadDataOntoStack(resultType);
        right.loadDataOntoStack(resultType);

        setAdd(JasminConstants.Prefix.DOUBLE);
    }

    private void setAdditiveExpressionString() {
        resultType = NimbleParser.STRING_TYPE;
        addCommand(JasminConstants.CONSTRUCT_STRING_BUILDER);
        addCommand(JasminConstants.DUPLICATE_VALUE_ONTOP_OF_STACK);
        addCommand(JasminConstants.INIT_STRING_BUILDER);
        loadStringOntoStack(left.toString());
        addCommand(JasminConstants.APPEND_STRING_BUILDER);
        loadStringOntoStack(right.toString());
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

    public void compareStrings(boolean isEqualOperator, String label) {
        addCommand(JasminConstants.COMPARE_STRING);
        if(isEqualOperator) { // Jasmin uses opposition.
            addCommand(JasminConstants.IF_NOT_EQUAL + label);
        } else {
            addCommand(JasminConstants.IF_EQUAL + label);
        }
    }

    @Override
    public int getType() {
        return resultType;
    }

    @Override
    public void loadDataOntoStack() {
    }

    @Override
    public void loadDataOntoStack(int asType) {
        //TODO?
    }
}
