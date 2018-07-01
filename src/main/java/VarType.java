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

