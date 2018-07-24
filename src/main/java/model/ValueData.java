package model;

import generated.NimbleParser;

public class ValueData extends Data {

    protected String valueStr;
    protected boolean valueBool;
    protected double valueDouble;
    protected int valueInt;

    protected int type;

    protected ValueData() {
    }

    /**
     * Constructor for string
     * @param value
     */
    public ValueData(String value) {
        this.valueStr = value;
        this.type = NimbleParser.STRING_TYPE;
        loadStringOntoStack(valueStr);
    }

    public ValueData(boolean value) {
        this.valueBool = value;
        this.type = NimbleParser.BOOLEAN_TYPE;
        loadBooleanOnStack(valueBool);
    }

    public ValueData(double value) {
        this.valueDouble = value;
        this.type = NimbleParser.DOUBLE_TYPE;
        loadDoubleOntoStack(valueDouble);
    }

    public ValueData(int value) {
        this.valueInt = value;
        this.type = NimbleParser.INTEGER_TYPE;
        loadIntegerOntoStack(valueInt);
    }

    public int getType() {
        return type;
    }

    public double getValueDouble() {
        return valueDouble;
    }

    public int getValueInt() {
        return valueInt;
    }

    public String getValueStr() {
        return valueStr;
    }

    public boolean getValueBool() {
        return valueBool;
    }

    public boolean isInteger() {
        return type == NimbleParser.INTEGER_TYPE;
    }

    public boolean isDouble() {
        return type == NimbleParser.DOUBLE_TYPE;
    }

    public boolean isString() {
        return type == NimbleParser.STRING_TYPE;
    }

    public boolean isBoolean() {
        return type == NimbleParser.BOOLEAN_TYPE;
    }

    @Override
    public String toString() {
        switch (type) {
            case NimbleParser.INTEGER_TYPE:
                return "" + valueInt;
            case NimbleParser.DOUBLE_TYPE:
                return "" + valueDouble;
            case NimbleParser.BOOLEAN_TYPE:
                return "" + valueBool;
            case NimbleParser.STRING_TYPE:
                return valueStr;
                default:
                    throw new RuntimeException("Token: "
                            + NimbleParser.VOCABULARY.getLiteralName(type)
                            + " is not recognised");
        }
    }
}
