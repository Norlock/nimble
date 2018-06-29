public class Value {

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
        return (Integer) value;
    }

    public String asString() {
        return String.valueOf(value);
    }

    public boolean isDouble() {
        return value instanceof Double;
    }

    @Override
    public int hashCode() {

        if(value == null) {
            return 0;
        }

        return this.value.hashCode();
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
