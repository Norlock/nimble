package model;

import generated.NimbleParser;

import java.util.ArrayList;

public class ParserData extends Data {

    private ArrayList<String> jasminCode = new ArrayList<>();
    private String label;

    public ParserData() {
    }

    public ParserData(ArrayList<String> code) {
        jasminCode.addAll(code);
    }

    public ArrayList<String> getJasminCode() {
        return jasminCode;
    }

    public String getGoToLabel() {
        return label;
    }

    /**
     *
     * @param tokenType (Integer / Double / String)
     * @param storePosition (
     * @return
     */
    private static String storeVariableReference(int tokenType, int storePosition) {
        if(storePosition < 1) {
            throw new IndexOutOfBoundsException("Store position 1 and higher");
        }
        if(tokenType == NimbleParser.INTEGER_TYPE) {
            if(0 <= storePosition && storePosition <= 3) {
                return JasminConstants.INTEGER + JasminConstants.STORE_VAl_SMALL + storePosition;
            } else {
                return JasminConstants.INTEGER + JasminConstants.STORE_VAL + " " + storePosition;
            }
        } else if (tokenType == NimbleParser.DOUBLE_TYPE) {

        }
        return "";
    }

    private static String loadValueFromVariable(int tokenType, int storePosition) {
        if(tokenType == NimbleParser.INTEGER_TYPE) {
            return JasminConstants.INTEGER + JasminConstants.LOAD_VAL_SMALL + storePosition;
        } else if (tokenType == NimbleParser.DOUBLE_TYPE) {
            return  JasminConstants.DOUBLE + JasminConstants.LOAD_VAL_SMALL + storePosition;
        }
        return "";
    }

    /**
     * Loads numeric type on stack (e.g. iconst_3;
     * @param value
     * @return
     */
    private static String loadIntegerValueOntoStack(int value) {
        if (0 <= value && value <= 5) {
            return JasminConstants.INTEGER_CONST + value;
        } else if (value == -1) {
            return JasminConstants.INTEGER_CONST + "m1";
        } else {
            return JasminConstants.INTEGER_ADD + " " + value;
        }
    }

    private static String loadDoubleValueOntoStack(double value) {
        return JasminConstants.DOUBLE_ADD + " " + value;
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
        int varIndexLeft = JasminConstants.incrementIntegerVariableIndex();
        jasminCode.add(storeVariableReference(NimbleParser.INTEGER_TYPE, varIndexLeft));
        jasminCode.add(loadIntegerValueOntoStack(valueRight));
        int varIndexRight = JasminConstants.incrementIntegerVariableIndex();
        jasminCode.add(storeVariableReference(NimbleParser.INTEGER_TYPE, varIndexRight));
        jasminCode.add(loadValueFromVariable(NimbleParser.INTEGER_TYPE, varIndexLeft));
        jasminCode.add(loadValueFromVariable(NimbleParser.INTEGER_TYPE, varIndexRight));
        label = JasminConstants.getNewLabel();
        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_INTEGER_COMPARE_NOT_EQUAL + " " + label);
        } else {
            jasminCode.add(JasminConstants.IF_INTEGER_COMPARE_EQUAL + " " + label);
        }
    }

    public void setDoubleCompare(final double valueLeft, final double valueRight, final int equalOperator) {
        jasminCode.add(loadDoubleValueOntoStack(valueLeft));
        int varIndexLeft = JasminConstants.incrementDoubleVariableIndex();
        jasminCode.add(storeVariableReference(NimbleParser.DOUBLE_TYPE, varIndexLeft));
        jasminCode.add(loadDoubleValueOntoStack(valueRight));
        int varIndexRight = JasminConstants.incrementDoubleVariableIndex();
        jasminCode.add(storeVariableReference(NimbleParser.DOUBLE_TYPE, varIndexRight));
        jasminCode.add(loadValueFromVariable(NimbleParser.DOUBLE_TYPE, varIndexLeft));
        jasminCode.add(loadValueFromVariable(NimbleParser.DOUBLE_TYPE, varIndexRight));
        label = JasminConstants.getNewLabel();
        if(equalOperator == NimbleParser.EQUAL) { // Jasmin uses opposition.
            jasminCode.add(JasminConstants.IF_NOT_EQUAL + " ");
            // TODO
        } else {
            // TODO
        }
    }

    public static String loadBooleanOnStack(boolean value) {
        if(value)
            return JasminConstants.INTEGER_CONST + JasminConstants.TRUE;
        else
            return JasminConstants.INTEGER_CONST + JasminConstants.FALSE;
    }

    private static String getFileFooter() {
        return  "        return\n" +
                "    .end method";
    }

    private static String getFileHeader(int stackSize, int varAndParamsCount) {
        if(stackSize == 0)
            stackSize = 99;
        if(varAndParamsCount == 0)
            varAndParamsCount = 99;

        return ".class public NimbleProject\n" +
                "    .super java/lang/Object\n" +
                "\n" +
                "    ; Default constructor (empty constructor)\n" +
                "    .method public <init>()V\n" +
                "        aload_0                                     ; Loads \"this\" on the stack\n" +
                "        invokenonvirtual java/lang/Object/<init>()V ; Call super constructor\n" +
                "        return                                      ; Terminate method\n" +
                "    .end method\n" +
                "    \n" +
                "    ; Method definition for public static void main(String[] args)\n" +
                "    .method public static main([Ljava/lang/String;)V\n" +
                "        .limit stack " + stackSize + "\n" +
                "        .limit locals " + varAndParamsCount + "\n\n";
    }
}
