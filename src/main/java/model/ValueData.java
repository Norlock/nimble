package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;

public class ValueData extends BaseValue {

    private final int type;

    public ValueData(int valueType, ParserRuleContext ctx) {
        super(ctx);
        this.type = valueType;

        switch (valueType) {
            case NimbleParser.INTEGER_TYPE:
                loadIntegerOntoStack(0);
                break;
            case NimbleParser.BOOLEAN_TYPE:
                loadBooleanOnStack(false);
                break;
            case NimbleParser.DOUBLE_TYPE:
                loadDoubleOntoStack(0);
                break;
            case NimbleParser.STRING_TYPE:
                loadStringOntoStack("");
        }
    }

    public ValueData(ParserRuleContext ctx, String value) {
        super(ctx);
        this.type = NimbleParser.STRING_TYPE;
        loadStringOntoStack(value);
    }

    public ValueData(ParserRuleContext ctx, boolean value) {
        super(ctx);
        this.type = NimbleParser.BOOLEAN_TYPE;
        loadBooleanOnStack(value);
    }

    public ValueData(ParserRuleContext ctx, double value) {
        super(ctx);
        this.type = NimbleParser.DOUBLE_TYPE;
        loadDoubleOntoStack(value);
    }

    public ValueData(ParserRuleContext ctx, int value) {
        super(ctx);
        this.type = NimbleParser.INTEGER_TYPE;
        loadIntegerOntoStack(value);
    }

//    @Override
//    public String toString() {
//        switch (type) {
//            case NimbleParser.INTEGER_TYPE:
//                return "" + valueInt;
//            case NimbleParser.DOUBLE_TYPE:
//                return "" + valueDouble;
//            case NimbleParser.BOOLEAN_TYPE:
//                return "" + valueBool;
//            case NimbleParser.STRING_TYPE:
//                return valueStr;
//                default:
//                    throw new RuntimeException("Token: "
//                            + NimbleParser.VOCABULARY.getLiteralName(type)
//                            + " is not recognised");
//        }
//    }

    @Override
    public int getDataType() {
        return type;
    }

}
