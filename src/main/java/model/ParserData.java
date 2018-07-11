package model;

import generated.NimbleParser;

import java.util.ArrayList;

public class ParserData extends Data {

    private String label;

    public ParserData() {
    }

    public ParserData(ArrayList<String> code) {
        jasminCode.addAll(code);
    }

    public String getGoToLabel() {
        return label;
    }

    /**
     *
     * @param valueLeft
     * @param valueRight
     * @param equalOperator
     * @return generated label
     */
    public void setIntegerCompare(final int valueLeft, final int valueRight, final int equalOperator) {
        setIntegerValues(valueLeft, valueRight);
        label = JasminHelper.getNewLabel();
        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_INTEGER_COMPARE_NOT_EQUAL + label);
        } else {
            jasminCode.add(JasminConstants.IF_INTEGER_COMPARE_EQUAL + label);
        }
    }

    public void setBooleanCompare(final boolean valueLeft, final boolean valueRight, final int equalOperator) {
        int intLeft = valueLeft ? 1 : 0;
        int intRight = valueRight ? 1 : 0;
        setIntegerCompare(intLeft, intRight, equalOperator);
    }

    public void setDoubleCompare(final double valueLeft, final double valueRight, final int equalOperator) {
        setDoubleValues(valueLeft, valueRight);
        jasminCode.add(JasminConstants.COMPARE_DOUBLE);
        label = JasminHelper.getNewLabel();
        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_NOT_EQUAL + label);
        } else {
            jasminCode.add(JasminConstants.IF_EQUAL + label);
        }
    }

    public void setStringCompare(final String valueLeft, final String valueRight, final int equalOperator) {
        setStringValues(valueLeft, valueRight);
        jasminCode.add(JasminConstants.COMPARE_STRING);

        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_NOT_EQUAL + label);
        } else {
            jasminCode.add(JasminConstants.IF_EQUAL + label);
        }
    }

    private void setStringValues(final String valueLeft, final String valueRight) {
        loadStringOntoStack(valueLeft);
        int varIndexLeft = JasminHelper.incrementVariableIndex();
        loadStringOntoStack(valueRight);
        int varIndexRight = JasminHelper.incrementVariableIndex();
        setLoad(JasminConstants.Prefix.STRING, varIndexLeft);
        setLoad(JasminConstants.Prefix.STRING, varIndexRight);
    }

    private void setDoubleValues(final double valueLeft, final double valueRight) {
        loadDoubleOntoStack(valueLeft);
        int varIndexLeft = JasminHelper.incrementDoubleVariableIndex();
        loadDoubleOntoStack(valueRight);
        int varIndexRight = JasminHelper.incrementDoubleVariableIndex();
        setLoad(JasminConstants.Prefix.DOUBLE, varIndexLeft);
        setLoad(JasminConstants.Prefix.DOUBLE, varIndexRight);
    }

    private void setIntegerValues(final int valueLeft, final int valueRight) {
        loadIntegerOntoStack(valueLeft);
        int varIndexLeft = JasminHelper.incrementVariableIndex();
        loadIntegerOntoStack(valueRight);
        int varIndexRight = JasminHelper.incrementVariableIndex();
        setLoad(JasminConstants.Prefix.INTEGER_OR_BOOLEAN, varIndexLeft);
        setLoad(JasminConstants.Prefix.INTEGER_OR_BOOLEAN, varIndexRight);
    }

    private void setBooleanValues(final boolean valueLeft, final boolean valueRight) {
        loadBooleanOnStack(valueLeft);
        int varIndexLeft = JasminHelper.incrementVariableIndex();
        loadBooleanOnStack(valueRight);
        int varIndexRight = JasminHelper.incrementVariableIndex();
        setLoad(JasminConstants.Prefix.INTEGER_OR_BOOLEAN, varIndexLeft);
        setLoad(JasminConstants.Prefix.INTEGER_OR_BOOLEAN, varIndexRight);
    }

    public void setAdditiveExpressionDouble(final double valueLeft, final double valueRight, final int additiveOperator) {
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

    public void print(ValueData valueData) {
        jasminCode.add(JasminConstants.LOAD_SYSO_ONTO_STACK);
        if(valueData.isInteger()) {
            loadIntegerOntoStack(valueData.getValueInt());
        } else if(valueData.isDouble()) {
            loadDoubleOntoStack(valueData.getValueDouble());
        } else if(valueData.isBoolean()) {
            loadBooleanOnStack(valueData.getValueBool());
        } else  if (valueData.isString()) {
            loadStringOntoStack(valueData.getValueStr());
        } else {
            throw new RuntimeException("Not implemented");
        }
        jasminCode.add(JasminConstants.PRINT);
    }

    public void print(ArrayList<String> code) {
        jasminCode.add(JasminConstants.LOAD_SYSO_ONTO_STACK);
        jasminCode.addAll(code);
        jasminCode.add(JasminConstants.PRINT);
    }

    /**
     * Loads numeric type on stack (e.g. iconst_3;
     * @param value
     * @return
     */
    public void loadIntegerOntoStack(int value) {
        if (0 <= value && value <= 5) {
            jasminCode.add(JasminConstants.INTEGER_CONST + value);
        } else if (value == -1) {
            jasminCode.add(JasminConstants.INTEGER_CONST + "m1");
        } else {
            jasminCode.add(JasminConstants.INTEGER_ADD + value);
        }
    }

    public void loadBooleanOnStack(boolean value) {
        if(value)
            jasminCode.add(JasminConstants.INTEGER_CONST + JasminConstants.TRUE);
        else
            jasminCode.add(JasminConstants.INTEGER_CONST + JasminConstants.FALSE);
    }

    public void loadDoubleOntoStack(double value) {
        jasminCode.add(JasminConstants.DOUBLE_ADD + value);
    }

    public void loadStringOntoStack(String value) {
        jasminCode.add(JasminConstants.STRING_ADD + value);
    }

    /**
     *
     * @param prefix (i/a/d)
     * @param storeIndex
     * @return
     */
    public void setStore(JasminConstants.Prefix prefix, int storeIndex) {
        if(0 <= storeIndex && storeIndex <= 3) {
            jasminCode.add(prefix.toString() + JasminConstants.STORE_VAl_SMALL + storeIndex);
        } else {
            jasminCode.add(prefix.toString() + JasminConstants.STORE_VAL + storeIndex);
        }
    }

    public void setLoad(JasminConstants.Prefix prefix, int storeIndex) {
        if(0 <= storeIndex && storeIndex <= 3) {
            jasminCode.add(prefix.toString() + JasminConstants.LOAD_VAL_SMALL + storeIndex);
        } else {
            jasminCode.add(prefix.toString() + JasminConstants.LOAD_VAL + storeIndex);
        }
    }
}
