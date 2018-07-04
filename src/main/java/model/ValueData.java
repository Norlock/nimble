package model;

import generated.NimbleParser;

public class ValueData extends Data {

    private String valueStr;
    private boolean valueBool;
    private double valueDouble;
    private int valueInt;

    private final int type;

    /**
     * Constructor for string
     * @param value
     */
    public ValueData(String value) {
        this.valueStr = value;
        this.type = NimbleParser.STRING_TYPE;
    }

    /**
     * Boolean constructor
     * @param value
     */
    public ValueData(boolean value) {
        this.valueBool = value;
        this.type = NimbleParser.BOOLEAN_TYPE;
    }

    public ValueData(double value) {
        this.valueDouble = value;
        this.type = NimbleParser.DOUBLE_TYPE;
    }

    public ValueData(int value) {
        this.valueInt = value;
        this.type = NimbleParser.INTEGER_TYPE;
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
