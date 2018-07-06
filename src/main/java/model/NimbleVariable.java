package model;

import generated.NimbleParser;
import main.Nimble;

/**
 * In couple class for type and variable, so String variables will only accept Strings.
 */
public class NimbleVariable {

    private ValueData valueData;
    private final String id;
    private final int type;
    private int storeIndex;

    public NimbleVariable(int tokenType, String id) {
        this.id = id;
        this.type = tokenType;
        setStoreIndex();
    }

    public NimbleVariable(int tokenType, ValueData valueData, String id) {
        this.type = tokenType;
        this.valueData = valueData;
        this.id = id;
        setStoreIndex();
        validate();
        writeJasminCode();
    }

    private void writeJasminCode() {

    }

    private void setStoreIndex() {
        if(type == NimbleParser.INTEGER_TYPE
                || type == NimbleParser.BOOLEAN_TYPE
                || type == NimbleParser.STRING_TYPE) {
            storeIndex = JasminHelper.incrementVariableIndex();
        } else if(type == NimbleParser.DOUBLE_TYPE) {
            storeIndex = JasminHelper.incrementDoubleVariableIndex();
        } else {
            throw new RuntimeException("Shit niet gemaakt nog");
        }
    }

    public int getStoreIndex() {
        return storeIndex;
    }

    public void setValueData(ValueData valueData) {
        this.valueData = valueData;
        validate();
        writeJasminCode();
    }

    public int getType() {
        return type;
    }

    public ValueData getValueData() {
        return valueData;
    }

    /**
     * Throws runtime exception if for example integer is assigned to a string
     */
    private void validate() {
        int valueToken = valueData.getType();

        if (valueToken != type) {
            String errorMsg = "\n\t\tCannot assign " + valueData.toString()
                    + " to type " + NimbleParser.VOCABULARY.getLiteralName(type).replace("'","")
                    + " for identifier " + id;


            throw new RuntimeException(errorMsg + "\n");
        }
    }
}
