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

}
