package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.JasminConstants;


public abstract class BaseValue extends ParserData {

    protected BaseValue(ParserRuleContext ctx) {
        super(ctx);
    }

    public abstract int getDataType();

    public boolean isType(int type) {
        return type == getDataType();
    }

    public boolean isBoolean() {
        return getDataType() == NimbleParser.BOOLEAN_TYPE;
    }

    public boolean isNumber() {
        return getDataType() == NimbleParser.INTEGER_TYPE ||
                getDataType() == NimbleParser.DOUBLE_TYPE;
    }

    /**
     * Simple check method that can easily be expanded with more auto casts
     * @param resultType
     * @return
     */
    public boolean isAutoCastable(int resultType) {
        switch (resultType) {
            case NimbleParser.DOUBLE_TYPE:
                return isCastableToDouble();
            default: return false;
        }
    }

    private boolean isCastableToDouble() {
        return isType(NimbleParser.INTEGER_TYPE);
    }

    /**
     * Method to retrieve cast command. This method will not set the command since it's not necessary part
     * of each basevalue (variables might not always need to be casted).
     * @param resultType type to cast to
     * @return cast command
     */
    public String getCastCommand(int resultType) {
        // In the future more auto casts can be implemented
        if(!isAutoCastable(resultType)) {
            throwError("Can't auto cast this value.");
        } else if(resultType == NimbleParser.DOUBLE_TYPE && isType(NimbleParser.INTEGER_TYPE))
            return JasminConstants.INT_TO_DOUBLE;

        return null;
    }

    protected void loadIntegerOntoStack(int value) {
        if (0 <= value && value <= 5) {
            addCommand(JasminConstants.INTEGER_CONST + value);
        } else if (value == -1) {
            addCommand(JasminConstants.INTEGER_CONST + "m1");
        } else {
            addCommand(JasminConstants.INTEGER_ADD + value);
        }
    }

    public void loadBooleanOnStack(boolean value) {
        addCommand(JasminConstants.INTEGER_CONST + (value ? JasminConstants.TRUE : JasminConstants.FALSE));
    }

    protected void loadDoubleOntoStack(double value) {
        addCommand(JasminConstants.DOUBLE_ADD + value);
    }

    protected void loadStringOntoStack(String value) {
        addCommand(JasminConstants.STRING_ADD + value);
    }

    protected String getAppendString() {
        StringBuilder sb = new StringBuilder(JasminConstants.INVOKE_VIRTUAL);
        sb.append(JasminConstants.STRING_BUILDER_CLASS);
        sb.append("/append(");

        if(isType(NimbleParser.STRING_TYPE)) {
            sb.append("Ljava/lang/String;");
        } else if(isType(NimbleParser.INTEGER_TYPE)) {
            sb.append("I");
        } else if(isType(NimbleParser.DOUBLE_TYPE)) {
            sb.append("D");
        } else {
            sb.append("Z");
        }

        sb.append(")Ljava/lang/StringBuilder;");

        return sb.toString();
    }
}
