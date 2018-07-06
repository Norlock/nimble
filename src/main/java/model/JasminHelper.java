package model;

import generated.NimbleParser;

public final class JasminHelper {
    private static int variableIndex = 1, labelIndex = 1;

    public static String getNewLabel() {
        return "label" + labelIndex++;
    }

    public static int getVariableIndex() {
        return variableIndex;
    }

    public static int incrementDoubleVariableIndex() {
        return variableIndex += 2; // Double needs to spots
    }

    public static int incrementVariableIndex() {
        return variableIndex++;
    }

    public static String loadBooleanOnStack(boolean value) {
        if(value)
            return JasminConstants.INTEGER_CONST + JasminConstants.TRUE;
        else
            return JasminConstants.INTEGER_CONST + JasminConstants.FALSE;
    }

    public static String loadDoubleValueOntoStack(double value) {
        return JasminConstants.DOUBLE_ADD + value;
    }

    public static String loadStringValueOntoStack(String value) {
        return JasminConstants.STRING_ADD + value;
    }

    public static String getStore(int storeIndex) {
        if(0 <= storeIndex && storeIndex <= 3) {
            return JasminConstants.STORE_VAl_SMALL + storeIndex;
        } else {
            return JasminConstants.STORE_VAL + storeIndex;
        }
    }

    public static String getLoad(int storeIndex) {
        if(0 <= storeIndex && storeIndex <= 3) {
            return JasminConstants.LOAD_VAL_SMALL + storeIndex;
        } else {
            return JasminConstants.LOAD_VAL + storeIndex;
        }
    }

    /**
     *
     * @param tokenType (Integer / Double / String)
     * @param storeIndex (
     * @return
     */
    public static String storeVariableReference(int tokenType, int storeIndex) {
        if(storeIndex < 1) {
            throw new IndexOutOfBoundsException("Store position 1 and higher");
        }
        if(tokenType == NimbleParser.INTEGER_TYPE) {
            return JasminConstants.INTEGER + getStore(storeIndex);
        } else if (tokenType == NimbleParser.DOUBLE_TYPE) {
            return  JasminConstants.DOUBLE + getStore(storeIndex);
        }
        return "";
    }

    /**
     *
     * @param tokenType
     * @param storeIndex
     * @return
     */
    public static String loadValueFromVariable(int tokenType, int storeIndex) {
        if(tokenType == NimbleParser.INTEGER_TYPE) {
            return JasminConstants.INTEGER + getLoad(storeIndex);
        } else if (tokenType == NimbleParser.DOUBLE_TYPE) {
            return  JasminConstants.DOUBLE + getLoad(storeIndex);
        }
        return "";
    }

    /**
     * Loads numeric type on stack (e.g. iconst_3;
     * @param value
     * @return
     */
    public static String loadIntegerValueOntoStack(int value) {
        if (0 <= value && value <= 5) {
            return JasminConstants.INTEGER_CONST + value;
        } else if (value == -1) {
            return JasminConstants.INTEGER_CONST + "m1";
        } else {
            return JasminConstants.INTEGER_ADD + value;
        }
    }

    public static String getFileFooter() {
        return  "        return\n" +
                "    .end method";
    }

    public static String getFileHeader(int stackSize, int varAndParamsCount) {
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
