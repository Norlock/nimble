package model;

import generated.NimbleParser;

import java.util.ArrayList;

// Import static methods to safe space
import static model.JasminHelper.*;

public class ParserData extends Data {

    private String label;

    public ParserData() {
    }

    public ParserData(ArrayList<String> code) {
        jasminCode.addAll(code);
    }

    protected ArrayList<String> jasminCode = new ArrayList<>();

    public ArrayList<String> getJasminCode() {
        return jasminCode;
    }

    public String getGoToLabel() {
        return label;
    }

    public void setVariableAssignment(ValueData value, int storeIndex) {
        if(value.isInteger()) {
            jasminCode.add(loadIntegerValueOntoStack(value.getValueInt()));
        } else if(value.isDouble()) {
            jasminCode.add(loadDoubleValueOntoStack(value.getValueDouble()));
        }
        jasminCode.add(storeVariableReference(value.getType(), storeIndex));
    }

    /**
     *
     * @param valueLeft
     * @param valueRight
     * @param equalOperator
     * @return generated label
     */
    public void setIntegerCompare(final int valueLeft, final int valueRight, final int equalOperator) {
        jasminCode.add(loadIntegerValueOntoStack(valueLeft));
        int varIndexLeft = JasminHelper.incrementVariableIndex();
        jasminCode.add(storeVariableReference(NimbleParser.INTEGER_TYPE, varIndexLeft));
        jasminCode.add(loadIntegerValueOntoStack(valueRight));
        int varIndexRight = JasminHelper.incrementVariableIndex();
        jasminCode.add(storeVariableReference(NimbleParser.INTEGER_TYPE, varIndexRight));
        jasminCode.add(loadValueFromVariable(NimbleParser.INTEGER_TYPE, varIndexLeft));
        jasminCode.add(loadValueFromVariable(NimbleParser.INTEGER_TYPE, varIndexRight));
        label = JasminHelper.getNewLabel();
        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_INTEGER_COMPARE_NOT_EQUAL + label);
        } else {
            jasminCode.add(JasminConstants.IF_INTEGER_COMPARE_EQUAL + label);
        }
    }

    public void setDoubleCompare(final double valueLeft, final double valueRight, final int equalOperator) {
        jasminCode.add(loadDoubleValueOntoStack(valueLeft));
        int varIndexLeft = JasminHelper.incrementDoubleVariableIndex();
        jasminCode.add(storeVariableReference(NimbleParser.DOUBLE_TYPE, varIndexLeft));
        jasminCode.add(loadDoubleValueOntoStack(valueRight));
        int varIndexRight = JasminHelper.incrementDoubleVariableIndex();
        jasminCode.add(storeVariableReference(NimbleParser.DOUBLE_TYPE, varIndexRight));
        jasminCode.add(loadValueFromVariable(NimbleParser.DOUBLE_TYPE, varIndexLeft));
        jasminCode.add(loadValueFromVariable(NimbleParser.DOUBLE_TYPE, varIndexRight));
        label = JasminHelper.getNewLabel();
        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_NOT_EQUAL + label);
        } else {
            jasminCode.add(JasminConstants.IF_EQUAL + label);
        }
    }

    public void print(ValueData valueData) {
        jasminCode.add(JasminConstants.LOAD_SYSO_ONTO_STACK);
        if(valueData.isInteger()) {
            jasminCode.add(loadIntegerValueOntoStack(valueData.getValueInt()));
        } else if(valueData.isDouble()) {
            jasminCode.add(loadDoubleValueOntoStack(valueData.getValueDouble()));
        } else if(valueData.isBoolean()) {
            jasminCode.add(loadBooleanOnStack(valueData.getValueBool()));
        } else  if (valueData.isString()) {
            jasminCode.add(loadStringValueOntoStack(valueData.getValueStr()));
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
