import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.lang.reflect.Type;
import java.util.ArrayList;

public class ValueInfo {

    private final ArrayList<String> jasminCode = new ArrayList<>();

    private final String value;

    public ValueInfo(String value ) {
        this.value = value;
    }

    public Boolean asBoolean() {
        return Boolean.parseBoolean(value);
    }

    public Boolean isBoolean() {
        return value.equals("true") || value.equals("false");
    }

    public Integer asInteger() {
        return Integer.parseInt(value);
    }

    public Double asDouble() {
        return Double.parseDouble(value);
    }

    public String asString() {
        return value;
    }

    public void addToJasminCode(String code) {
        jasminCode.add(code);
    }

    public ArrayList<String> getJasminCode() {
        return jasminCode;
    }

    public static void Validate(String value, String type) {
        if(!value.equals(type)) {
            throw new RuntimeException("Variable: " + value);
        }
    }
}
