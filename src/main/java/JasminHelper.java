/**
 * Helps to generate Jasmin strings
 */
public final class JasminHelper {

//    public enum Operators {
//        EQUAL("=="),
//        NOT_EQUAL("!="),
//        LEFT_IS_GREATER(">"),
//        LEFT_IS_GREATER_OR_EQUAL(">="),
//        RIGHT_IS_GREATER("<"),
//        RIGHT_IS_GREATER_OR_EQUAL("<="),
//        AND("&&"),
//
//    }

    /**
     * Loads numeric type on stack (e.g. iconst_3;
     * @param value
     * @return
     */
    public static String loadIntegerOnStack(int value) {

        if (0 <= value && value <= 5) {
            return JasminConstants.INTEGER_CONST + value;
        } else if (value == -1) {
            return JasminConstants.INTEGER_CONST + "m1";
        } else {
            return JasminConstants.INTEGER_ADD + " " + value;
        }
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
