package model;

public final class JasminConstants {


    // For reading purpose
    private static final String SPACE = " ";

    // Put before the commands
    public static final String INTEGER = "i", DOUBLE = "d";

    // Boolean values
    public static final String TRUE = "1", FALSE = "0";

    // (int/double) + Instructions
    public static final String ADD = "add", SUB = "sub", MULTIPLY = "mul", DIVIDE = "div";

    // Store / load a variable
    public static final String STORE_VAl_SMALL = "store_", LOAD_VAL_SMALL = "load_";
    public static final String STORE_VAL = "store" + SPACE, LOAD_VAL = "load" + SPACE;

    // Used to add integers bellow 5 (e.g. iconst_3) and -1 above (e.g. iconst_m1)
    public static final String INTEGER_CONST = "iconst_";

    // Load integer, String or double onto the stack
    public static final String INTEGER_ADD = "ldc" + SPACE,
            STRING_ADD = "ldc" + SPACE,
            DOUBLE_ADD = "ldc2_w" + SPACE;

    public static final String INTEGER_INCREMENT = "iinc";

    // Compares doubles
    public static final String COMPARE_DOUBLE = "dcmpl" // + IF_EQUAL || IF LESS
            , COMPARE_DOUBLE_RIGHT_GREATER = "dcmpg" // + IF_GREATER
            , COMPARE_DOUBLE_RIGHT_LESSER = "dmpl"; // + IF_EQ || IF LESS

    // Jasmin will use opposition
    public static final String IF_EQUAL = "ifeq" + SPACE;
    public static final String IF_NOT_EQUAL = "ifne" + SPACE;

    // Jasmin will use opposition
    // if( i < 3 ) --> IF_LEFT_IS_GREATER_OR_EQUAL goto ...
    public static final String IF_LEFT_IS_GREATER = "ifgt" + SPACE;
    public static final String IF_LEFT_IS_GREATER_OR_EQUAL = "ifge" + SPACE;

    // Jasmin will use opposition
    // if( i > 3.2 ) --> IF_LEFT_IS_LESSER_OR_EQUAL goto ...
    public static final String IF_LEFT_IS_LESSER = "iflt" + SPACE;
    public static final String IF_LEFT_IS_LESSER_OR_EQUAL = "ifle" + SPACE;

    // Jasmin will use opposition
    public static final String IF_INTEGER_COMPARE_EQUAL = "if_icmpeq" + SPACE;
    public static final String IF_INTEGER_COMPARE_NOT_EQUAL = "if_icmpne" + SPACE;

    // Jasmin will use opposition
    public static final String IF_INTEGER_LEFT_IS_GREATER = "if_icmpgt" + SPACE;
    public static final String IF_INTEGER_LEFT_GREATER_OR_EQUAL = "if_icmpge" + SPACE;

    // Jasmin will use opposition
    public static final String IF_INTEGER_LEFT_IS_LESSER = "if_icmplt" + SPACE;
    public static final String IF_INTEGER_LEFT_IS_LESSER_OR_EQUAL = "if_icmple" + SPACE;

    // Return method
    public static final String END_METHOD_RETURN = "return";

    //Invoke methods that are not bound to this class
    public static final String INVOKE_SPECIAL = "invokespecial" + SPACE;

    //Invoke methods that are not bound to this class
    public static final String INVOKE_VIRTUAL = "invokevirtual" + SPACE;

    public static final String INVOKE_STATIC = "invokestatic" + SPACE;
    public static final String GET_STATIC = "getstatic" + SPACE;

    // push System.out onto the stack
    public static final String LOAD_SYSO_ONTO_STACK = GET_STATIC + "java/lang/System/out Ljava/io/PrintStream";
    // Call println
    public static final String PRINT = INVOKE_VIRTUAL + "java/io/PrintStream/println(Ljava/lang/String;)V";

    // Go to (+ label)
    public static final String GO_TO = "goto" + SPACE;
}
