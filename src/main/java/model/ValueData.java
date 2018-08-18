package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;

public class ValueData extends BaseValue {

    private String valueStr = "";
    private boolean valueBool = false;
    private double valueDouble = 0.0;
    private int valueInt = 0;

    private final int type;

    public ValueData(int type, ParserRuleContext ctx) {
        super(ctx);
        this.type = type;
        loadDataOntoStack();
    }

    public ValueData(ParserRuleContext ctx, String value) {
        this(NimbleParser.STRING_TYPE, ctx);
        this.valueStr = value;
    }

    public ValueData(ParserRuleContext ctx, boolean value) {
        this(NimbleParser.BOOLEAN_TYPE, ctx);
        this.valueBool = value;
    }

    public ValueData(ParserRuleContext ctx, double value) {
        this(NimbleParser.DOUBLE_TYPE, ctx);
        this.valueDouble = value;
    }

    public ValueData(ParserRuleContext ctx, int value) {
        this(NimbleParser.INTEGER_TYPE, ctx);
        this.valueInt = value;
    }

    public double getValueDouble() {
        return valueDouble;
    }

    public int getValueInt() {
        return valueInt;
    }

    public boolean getValueBool() {
        return valueBool;
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

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void loadDataOntoStack() {
        loadDataOntoStack(type);
    }

    @Override
    public void loadDataOntoStack(int asType) {
        emptyCode();
        switch (asType) {
            case NimbleParser.STRING_TYPE:
                loadStringOntoStack(toString());
                break;
            case NimbleParser.INTEGER_TYPE:
                loadIntegerOntoStack(valueInt);
                break;
            case NimbleParser.DOUBLE_TYPE:
                if(type == NimbleParser.INTEGER_TYPE) {
                    loadIntegerOntoStack(valueInt);
                    addCommand(JasminConstants.INT_TO_DOUBLE);
                } else
                    loadDoubleOntoStack(valueDouble);
                break;
            case NimbleParser.BOOLEAN_TYPE:
                loadBooleanOnStack(valueBool);
                break;
            default:
                throwError("Unknown type");
        }
    }
}
