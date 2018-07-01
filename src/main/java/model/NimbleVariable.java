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
        if(valueData.getTypeToken() != tokenData.getType())
            throw new RuntimeException("Value: " + valueData.toString());
    }
}
