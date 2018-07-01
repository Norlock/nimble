package model;

import generated.NimbleParser;

public class NimbleVariable {

    private TokenData tokenData;
    private ValueData valueData;

    public NimbleVariable(TokenData tokenData, ValueData valueData) {
        this.tokenData = tokenData;
        this.valueData = valueData;
    }

    public void setValueData(ValueData valueData) {
        this.valueData = valueData;
    }

    public TokenData getTokenData() {
        return tokenData;
    }

    public ValueData getValueData() {
        return valueData;
    }

    /**
     * Throws runtime exception if incorrect
     */
    public void validate() {
        int token = tokenData.getType();
        switch (token) {
            case NimbleParser.INTEGER_TYPE:
                valueData.asInteger();
                break;
            case NimbleParser.BOOLEAN_TYPE:
                valueData.asBoolean();
        }
    }
}
