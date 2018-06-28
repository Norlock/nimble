public class Value {
    public static Value VOID = new Value(new Object());

    final Object value;

    public Value(Object value) {
        this.value = value;
    }

    public Boolean asBoolean() {
        return  (Boolean) value;
    }

    public Double asDouble() {
        return (Double) value;
    }

    public int asInteger() {
        return (int) value;
    }

    
}
