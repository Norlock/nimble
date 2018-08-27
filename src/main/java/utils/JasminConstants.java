package utils;

import generated.NimbleParser;

public final class JasminConstants {

    // For reading purpose
    public static final String SPACE = " ";

    public enum DataType {
        STRING("Ljava/lang/String;"),
        INTEGER("I"),
        DOUBLE("D"),
        BOOLEAN("Z"),
        VOID("V");

        private final String value;

        DataType(String value) {
            this.value = value;
        }

        public static DataType getDataType(int type) {
            switch (type) {
                case NimbleParser.INTEGER_TYPE:
                    return DataType.INTEGER;
                case NimbleParser.BOOLEAN_TYPE:
                    return DataType.BOOLEAN;
                case NimbleParser.DOUBLE_TYPE:
                    return DataType.DOUBLE;
                case NimbleParser.STRING_TYPE:
                    return DataType.STRING;
                case NimbleParser.VOID:
                    return DataType.VOID;
                default:
                    throw new RuntimeException("Unknown type");
            }
        }

        @Override
        public String toString() {
            return value;
        }
    }

    public enum Prefix {
        INTEGER_OR_BOOLEAN("i"),
        STRING("a"),
        DOUBLE("d");

        private final String value;

        Prefix(String value) {
            this.value = value;
        }

        public static Prefix getPrefix(int type) {
            switch (type) {
                case NimbleParser.INTEGER_TYPE:
                    return Prefix.INTEGER_OR_BOOLEAN;
                case NimbleParser.BOOLEAN_TYPE:
                    return Prefix.INTEGER_OR_BOOLEAN;
                case NimbleParser.DOUBLE_TYPE:
                    return Prefix.DOUBLE;
                case NimbleParser.STRING_TYPE:
                    return Prefix.STRING;
                default:
                    throw new RuntimeException("Unknown type");
            }
        }

        @Override
        public String toString() {
            return value;
        }
    }

    // Boolean values
    public static final String TRUE = "1", FALSE = "0";

    // (int/double) + Instructions
    public static final String ADD = "add", SUB = "sub", MULTIPLY = "mul", DIVIDE = "div", MODULO = "rem";

    // Store / load a variable
    public static final String STORE_VAl_SMALL = "store_", LOAD_VAL_SMALL = "load_";
    public static final String STORE_VAL = "store" + SPACE, LOAD_VAL = "load" + SPACE;

    // Used to add integers bellow 5 (e.g. iconst_3) and -1 above (e.g. iconst_m1)
    public static final String INTEGER_CONST = "iconst_";

    // Load integer, String or double onto the stack
    public static final String INTEGER_ADD = "ldc" + SPACE,
            STRING_ADD = "ldc" + SPACE,
            DOUBLE_ADD = "ldc2_w" + SPACE;

    // Compares doubles
    public static final String COMPARE_DOUBLE = "dcmpl"
            , DOUBLE_COMPARE_IF_LEFT_IS_GREATER = "dcmpg"
            , DOUBLE_COMPARE_IF_LEFT_IS_LESS  = "dcmpl" ;

    // Convert to double
    public static final String INT_TO_DOUBLE = "i2d" + SPACE;

    // Return method
    public static final String RETURN = "return" + SPACE;

    // Pop from stack
    public static final String POP = "pop";

    //Invoke methods that are not bound to this class
    public static final String INVOKE_SPECIAL = "invokespecial" + SPACE;

    //Invoke methods that are not bound to this class
    public static final String INVOKE_VIRTUAL = "invokevirtual" + SPACE;
    public static final String INVOKE_STATIC = "invokestatic" + SPACE;
    public static final String GET_STATIC = "getstatic" + SPACE;
    public static final String PUT_STATIC = "putstatic" + SPACE;

    // push System.out onto the stack
    public static final String LOAD_SYSO_ONTO_STACK = GET_STATIC + "java/lang/System.out Ljava/io/PrintStream;";

    public static final String COMPARE_STRING = INVOKE_VIRTUAL + "java/lang/String.equals:(Ljava/lang/Object;)Z";

    // Go to (+ label)
    public static final String GO_TO = "goto" + SPACE;

    public static final String NEW = "new" + SPACE;
    public static final String STRING_BUILDER_CLASS = "java/lang/StringBuilder";

    public static final String CONSTRUCT_STRING_BUILDER = NEW + STRING_BUILDER_CLASS;
    public static final String INIT_STRING_BUILDER = INVOKE_SPECIAL + STRING_BUILDER_CLASS + "/<init>()V";

    public static final String STRING_BUILDER_TO_STRING = INVOKE_VIRTUAL + STRING_BUILDER_CLASS +
            ".toString()Ljava/lang/String;";

    public static final String DUPLICATE_VALUE_ONTOP_OF_STACK = "dup";

    public static final String COLON = ":";
}
