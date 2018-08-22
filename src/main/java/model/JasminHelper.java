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

    private static int incrementDoubleVariableIndex(){
        return variableIndex += 2; // Double needs two spots
    }

    private static int incrementVariableIndex() {
        return variableIndex++;
    }

    public static void updateVariableIndex(int type) {
        if(type == NimbleParser.INTEGER_TYPE
                || type == NimbleParser.BOOLEAN_TYPE
                || type == NimbleParser.STRING_TYPE) {
            incrementVariableIndex();
        } else if(type == NimbleParser.DOUBLE_TYPE) {
            incrementDoubleVariableIndex();
        } else {
            throw new RuntimeException("Unknown type");
        }
    }

    public static boolean castToDouble(int valueType, int resultType) {
        return (valueType == NimbleParser.INTEGER_TYPE && resultType == NimbleParser.DOUBLE_TYPE);
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
                "    .super java/lang/Object\n\n" +
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
                "        .limit locals " + varAndParamsCount + "\n";
    }
}
