import java.lang.reflect.Type;
import java.util.ArrayList;

public class JasminParser {

    private final ArrayList<String> jasminCode = new ArrayList<>();

    private final Object value;

    public JasminParser(Object value) {
        this.value = value;
    }

    public Boolean asBoolean() {
        return (Boolean)value;
    }

    public Integer asInteger() {
        return (Integer)value;
    }

    public Double asDouble() {
        return (Double)value;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }

    public void addToJasminCode(String code) {
        jasminCode.add(code);
    }

    public ArrayList<String> getJasminCode() {
        return jasminCode;
    }

    //TODO goed maken
    public static void Validate(String value, String type) {
        if(!value.equals(type)) {
            throw new RuntimeException("Variable: " + value);
        }
    }
}
