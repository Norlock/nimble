package model;

import generated.NimbleParser;

import java.util.ArrayList;

public class ParserData extends Data {

    private ArrayList<String> jasminCode = new ArrayList<>();

    public ParserData() {
    }

    public ParserData(ArrayList<String> code) {
        jasminCode.addAll(code);
    }

    public ArrayList<String> getJasminCode() {
        return jasminCode;
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
        if(tokenType == NimbleParser.INTEGER) {
            return JasminConstants.INTEGER + JasminConstants.STORE_VAR + storePosition;
        }
        return "";
    }

    private static String loadValueFromVariable(int tokenType, int storePosition) {
        if(tokenType == NimbleParser.INTEGER) {
            return JasminConstants.INTEGER + JasminConstants.LOAD_VAR + storePosition;
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

    public ArrayList<String> getIntegerCompare(int valueLeft, int valueRight, boolean isEqualOperator, String label) {
        ArrayList<String> code = new ArrayList<>();
        code.add(loadIntegerValueOntoStack(valueLeft));
        code.add(storeVariableReference(NimbleParser.INTEGER, 1));
        code.add(loadIntegerValueOntoStack(valueRight));
        code.add(storeVariableReference(NimbleParser.INTEGER, 2));
        code.add(loadValueFromVariable(NimbleParser.INTEGER, 1));
        code.add(loadValueFromVariable(NimbleParser.INTEGER, 2));
        if(isEqualOperator) {
            code.add(JasminConstants.IF_INTEGER_COMPARE_NOT_EQUAL + " Label1"); //
        } else {
            code.add(JasminConstants.IF_INTEGER_COMPARE_EQUAL + " " + label);
        }

        return  code;
    }

    public static String loadBooleanOnStack(boolean value) {
        if(value)
            return JasminConstants.INTEGER_CONST + JasminConstants.TRUE;
        else
            return JasminConstants.INTEGER_CONST + JasminConstants.FALSE;
    }

    public static String loadDoubleOnStack(double value) {
        return JasminConstants.DOUBLE_ADD;
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
