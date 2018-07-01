package model;

import generated.NimbleParser;

public class NimbleVariable {

    private TokenData tokenData;
    private ValueData valueData;
    private final String id;

    public NimbleVariable(TokenData tokenData, String id) {
        this.tokenData = tokenData;
        this.id = id;
    }

    public NimbleVariable(TokenData tokenData, ValueData valueData, String id) {
        this.tokenData = tokenData;
        this.valueData = valueData;
        this.id = id;
        validate();
    }

    public void setValueData(ValueData valueData) {
        this.valueData = valueData;
        validate();
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
    private void validate() {
        int valueToken = valueData.getTypeToken();
        int typeToken = tokenData.getTypeToken();

        if (valueToken != typeToken) {
            String errorMsg = "\n\t\tCannot assign " + valueData.toString()
                    + " to type " + NimbleParser.VOCABULARY.getLiteralName(typeToken).replace("'","")
                    + " for identifier " + id;


            throw new RuntimeException(errorMsg + "\n");
        }
    }
}
