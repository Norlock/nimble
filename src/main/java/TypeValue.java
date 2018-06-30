public class TypeValue {
    private final String type;
    private ValueInfo valueInfo;

    public TypeValue(String type, ValueInfo valueInfo) {
        this.type = type;
        this.valueInfo = valueInfo;
    }

    public String getType() {
        return type;
    }

    public ValueInfo getValueInfo() {
        return valueInfo;
    }
}
