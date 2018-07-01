public final class Constants {
    private Constants(){}

    public enum VarType {
        STRING("string"),
        INTEGER("int"),
        DOUBLE("double"),
        BOOLEAN("bool");

        private final String type;

        private VarType(String type) {
            this.type = type;
        }

        public static VarType findVarType(String type) {

            if(type.equals(STRING.toString())) {
                return STRING;
            } else if (type.equals(INTEGER.toString())) {
                return INTEGER;
            } else if (type.equals(BOOLEAN.toString())) {
                return BOOLEAN;
            } else {
                throw new RuntimeException("No such type of variable");
            }

        }

        @Override
        public String toString() {
            return this.type;
        }
    }

    /**
     * Loads numeric type on stack (e.g. iconst_3;
     * @param value
     * @return
     */
    public static String loadIntegerOnStack(int value) {

        if (0 <= value && value <= 5) {
            return JasminKeywords.INTEGER_CONST + value;
        } else if (value == -1) {
            return JasminKeywords.INTEGER_CONST + "m1";
        } else {
            return JasminKeywords.INTEGER_ADD + " " + value;
        }
    }

    public static String loadBooleanOnStack(boolean value) {
        if(value)
            return JasminKeywords.INTEGER_CONST;
    }

    public static String loadDoubleOnStack(double value) {
        return "TODO";
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

    public final class JasminKeywords {

        // Put before the commands
        public static final String INTEGER = "i", DOUBLE = "d", FLOAT = "f";

        // Boolean values
        public static final String TRUE = "1", FALSE = "0";

        // Used to add two integers on the stack
        public static final String ADD = "add", SUB = "sub", MULTIPLY = "mul", DIVIDE = "div";

        // Store / load a variable
        public static final String STORE_VAR = "store_", LOAD_VAR = "load_";

        // Used to add integers bellow 5 (e.g. iconst_3) and above -1 (e.g. iconst_m1)
        public static final String INTEGER_CONST = "iconst_";

        // Used for integers
        public static final String INTEGER_ADD = "ldc";

        // Return method
        public static final String RETURN = "return";

        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";
        public static final String INTEGER_ADD = "";

    }
}

