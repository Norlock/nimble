package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;

public class ValueData extends BaseValue {

    private final int type;

    private ValueData(int type, ParserRuleContext ctx) {
        super(ctx);
        this.type = type;
    }

    public ValueData(ParserRuleContext ctx, String value) {
        this(NimbleParser.STRING_TYPE, ctx);
        loadStringOntoStack(value);
    }

    public ValueData(ParserRuleContext ctx, boolean value) {
        this(NimbleParser.BOOLEAN_TYPE, ctx);
        loadBooleanOnStack(value);
    }

    public ValueData(ParserRuleContext ctx, double value) {
        this(NimbleParser.DOUBLE_TYPE, ctx);
        loadDoubleOntoStack(value);
    }

    public ValueData(ParserRuleContext ctx, int value) {
        this(NimbleParser.INTEGER_TYPE, ctx);
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

    /**
     * Loads numeric type on stack (e.g. iconst_3;
     * @param value
     * @return
     */
    private void loadIntegerOntoStack(int value) {
        if (0 <= value && value <= 5) {
            addCommand(JasminConstants.INTEGER_CONST + value);
        } else if (value == -1) {
            addCommand(JasminConstants.INTEGER_CONST + "m1");
        } else {
            addCommand(JasminConstants.INTEGER_ADD + value);
        }
    }

    private void loadBooleanOnStack(boolean value) {
        addCommand(JasminConstants.INTEGER_CONST + (value ? JasminConstants.TRUE : JasminConstants.FALSE));
    }

    private void loadDoubleOntoStack(double value) {
        addCommand(JasminConstants.DOUBLE_ADD + value);
    }

    private void loadStringOntoStack(String value) {
        addCommand(JasminConstants.STRING_ADD + value);
    }

    @Override
    public int getVarType() {
        return type;
    }

}
