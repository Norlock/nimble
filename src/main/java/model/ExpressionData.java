package model;

import generated.NimbleParser;
import main.Nimble;
import main.ParseException;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * ExpressionData is validated,
 */
public class ExpressionData extends ValueData {

    private final ParserRuleContext ctx;
    private final ValueData left;
    private final ValueData right;


    public ExpressionData(ParserRuleContext ctx, final ValueData left, final ValueData right) {
        this.ctx = ctx;
        this.left = left;
        this.right = right;
    }

    public void setAdditiveExpression() {
        NimbleParser.AdditiveExpressionContext aCtx = (NimbleParser.AdditiveExpressionContext) ctx;
        if(aCtx.op.getType() == NimbleParser.ADD) {
            setAddExpression();
        } else {
            setSubstractExpression();
        }
    }

    private void setAddExpression() {
        if (left.isString()) {
            setAdditiveExpressionString(left.getValueStr(), right.toString()); // toString gebruiken om ook andere types te gebruiken
        } else if (left.isBoolean() || right.isBoolean()) {
            throw new ParseException(ctx, "Can't add or substract from a boolean");
        } else if (right.isString()) {
            throw new ParseException(ctx, "Can't add or substract with a string");
        } else if (left.isDouble()) {
            if (right.isDouble()) {
                setAdditiveExpressionDouble(left.getValueDouble(), right.getValueDouble(), NimbleParser.ADD);
            } else if (right.isInteger()) {
                setAdditiveExpressionDouble(left.getValueDouble(), right.getValueInt(), NimbleParser.ADD);
            }
        } else if (left.isInteger()) {
            if(right.isDouble()) {
                setAdditiveExpressionDouble(left.getValueInt(), right.getValueDouble(), NimbleParser.ADD);
            } else if (right.isInteger()) {
                setAdditiveExpressionInteger();
            }
        }
    }

    private void setSubstractExpression() {
        if(left.isString() || right.isString())
            throw new ParseException(ctx, "Can't substract from a String");
        else if (left.isBoolean() || right.isBoolean())
            throw new ParseException(ctx, "Can't substract from a boolean");
        else if (left.isDouble()) {
            if(right.isDouble()) {
                return new ValueData(left.getValueDouble() - right.getValueDouble());
            } else if (right.isInteger()) {
                return new ValueData(left.getValueDouble() - right.getValueInt());
            }
        } else {
            if(right.isInteger()) {
                return new ValueData(left.getValueInt() - right.getValueInt());
            } else if(right.isDouble()) {
                return new ValueData(left.getValueInt() - right.getValueDouble());
            }
        }
    }

    private void setAdditiveExpressionDouble() {
        setDoubleValues(valueLeft, valueRight);
        if(additiveOperator == NimbleParser.ADD) {
            jasminCode.add(JasminConstants.Prefix.DOUBLE.toString() + JasminConstants.ADD);
        } else if(additiveOperator == NimbleParser.SUBSTRACT) {
            jasminCode.add(JasminConstants.Prefix.DOUBLE.toString() + JasminConstants.SUB);
        } else {
            throw new RuntimeException("TODO");
        }
    }

    public void setAdditiveExpressionString(final String valueLeft, final String valueRight) {
        jasminCode.add(JasminConstants.CONSTRUCT_STRING_BUILDER);
        jasminCode.add(JasminConstants.DUPLICATE_VALUE_ONTOP_OF_STACK);
        jasminCode.add(JasminConstants.INIT_STRING_BUILDER);
        loadStringOntoStack(valueLeft);
        jasminCode.add(JasminConstants.APPEND_STRING_BUILDER);
        loadStringOntoStack(valueRight);
        jasminCode.add(JasminConstants.APPEND_STRING_BUILDER);
        jasminCode.add(JasminConstants.STRING_BUILDER_TO_STRING);
    }

    public void setIntegerCompare() {
        type = NimbleParser.BOOLEAN_TYPE; // Compare == boolean
        setIntegerValues(valueLeft, valueRight);
        label = JasminHelper.getNewLabel();
        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_INTEGER_COMPARE_NOT_EQUAL + label);
        } else {
            jasminCode.add(JasminConstants.IF_INTEGER_COMPARE_EQUAL + label);
        }
    }

    public void setBooleanCompare() {
        type = NimbleParser.BOOLEAN_TYPE; // Compare == boolean
        int intLeft = left.getValueBool() ? 1 : 0;
        int intRight = right.getValueBool() ? 1 : 0;
        setIntegerCompare();
    }

    public void setDoubleCompare() {
        type = NimbleParser.BOOLEAN_TYPE; // Compare == boolean
        setDoubleValues(valueLeft, valueRight);
        jasminCode.add(JasminConstants.COMPARE_DOUBLE);
        label = JasminHelper.getNewLabel();
        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_NOT_EQUAL + label);
        } else {
            jasminCode.add(JasminConstants.IF_EQUAL + label);
        }
    }

    public void setStringCompare() {
        type = NimbleParser.BOOLEAN_TYPE; // Compare == boolean
        setStringValues(valueLeft, valueRight);
        jasminCode.add(JasminConstants.COMPARE_STRING);

        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_NOT_EQUAL + label);
        } else {
            jasminCode.add(JasminConstants.IF_EQUAL + label);
        }
    }
}
