package model;

import generated.NimbleParser;

public class ValueData extends Data {

    private String valueStr;
    private boolean valueBool;
    private double valueDouble;
    private int valueInt;

    private final int typeToken;

    /**
     * Constructor for string
     * @param value
     */
    public ValueData(String value) {
        this.valueStr = value;
        this.typeToken = NimbleParser.STRING_TYPE;
    }

    /**
     * Boolean constructor
     * @param value
     */
    public ValueData(boolean value) {
        this.valueBool = value;
        this.typeToken = NimbleParser.BOOLEAN_TYPE;
    }

    public ValueData(double value) {
        this.valueDouble = value;
        this.typeToken = NimbleParser.DOUBLE_TYPE;
    }

    public ValueData(int value) {
        this.valueInt = value;
        this.typeToken = NimbleParser.INTEGER_TYPE;
    }

    public int getTypeToken() {
        return typeToken;
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
}
