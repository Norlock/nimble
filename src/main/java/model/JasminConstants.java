package model;

public final class JasminConstants {


    private static int integerVariableIndex = 1, doubleVariableIndex = 1, labelIndex = 1;

    public static String getNewLabel() {
        return "label" + labelIndex++;
    }

    public static int getIntegerVariableIndex() {
        return integerVariableIndex;
    }

    public static int getDoubleVariableIndex() {
        return doubleVariableIndex;
    }

    public static int incrementDoubleVariableIndex() {
            return doubleVariableIndex += 2; // Double needs to spots
    }

    public static int incrementIntegerVariableIndex() {
        return integerVariableIndex++;
    }

    // Put before the commands
    public static final String INTEGER = "i", DOUBLE = "d";

    // Boolean values
    public static final String TRUE = "1", FALSE = "0";

    // (int/double) + Instructions
    public static final String ADD = "add", SUB = "sub", MULTIPLY = "mul", DIVIDE = "div";

    // Store / load a variable
    public static final String STORE_VAl_SMALL = "store_", LOAD_VAL_SMALL = "load_";
    public static final String STORE_VAL = "store ", LOAD_VAL = "load ";

    // Used to add integers bellow 5 (e.g. iconst_3) and -1 above (e.g. iconst_m1)
    public static final String INTEGER_CONST = "iconst_";

    // Load integer, String or double onto the stack
    public static final String INTEGER_ADD = "ldc", STRING_ADD = "ldc", DOUBLE_ADD = "ldc2_w";

    public static final String INTEGER_INCREMENT = "iinc";

    // Compares doubles
    public static final String COMPARE_DOUBLE = "dcmpl" // + IF_EQUAL || IF LESS
            , COMPARE_DOUBLE_RIGHT_GREATER = "dcmpg" // + IF_GREATER
            , COMPARE_DOUBLE_RIGHT_LESSER = "dmpl"; // + IF_EQ || IF LESS

    // Jasmin will use opposition
    public static final String IF_EQUAL = "ifeq";
    public static final String IF_NOT_EQUAL = "ifne ";

    // Jasmin will use opposition
    // if( i < 3 ) --> IF_LEFT_IS_GREATER_OR_EQUAL goto ...
    public static final String IF_LEFT_IS_GREATER = "ifgt ";
    public static final String IF_LEFT_IS_GREATER_OR_EQUAL = "ifge ";

    // Jasmin will use opposition
    // if( i > 3.2 ) --> IF_LEFT_IS_LESSER_OR_EQUAL goto ...
    public static final String IF_LEFT_IS_LESSER = "iflt ";
    public static final String IF_LEFT_IS_LESSER_OR_EQUAL = "ifle ";

    // Jasmin will use opposition
    public static final String IF_INTEGER_COMPARE_EQUAL = "if_icmpeq ";
    public static final String IF_INTEGER_COMPARE_NOT_EQUAL = "if_icmpne ";

    // Jasmin will use opposition
    public static final String IF_INTEGER_LEFT_IS_GREATER = "if_icmpgt ";
    public static final String IF_INTEGER_LEFT_GREATER_OR_EQUAL = "if_icmpge ";

    // Jasmin will use opposition
    public static final String IF_INTEGER_LEFT_IS_LESSER = "if_icmplt ";
    public static final String IF_INTEGER_LEFT_IS_LESSER_OR_EQUAL = "if_icmple ";

    // Return method
    public static final String END_METHOD_RETURN = "return";

    //Invoke methods that are not bound to this class
    public static final String INVOKE_SPECIAL = "invokespecial";

    //Invoke methods that are not bound to this class
    public static final String INVOKE_VIRTUAL = "invokevirtual";

    public static final String INVOKE_STATIC = "invokestatic";

    // push System.out onto the stack
    public static final String LOAD_SYSO_ONTO_STACK = "getstatic java/lang/System/out Ljava/io/PrintStream";
    // Print
    public static final String PRINT = (INVOKE_VIRTUAL + " java/io/PrintStream/println(Ljava/lang/String;)V");

    // Go to (+ label)
    public static final String GO_TO = "goto";


}
