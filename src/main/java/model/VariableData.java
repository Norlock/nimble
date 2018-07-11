package model;

import generated.NimbleParser;

/**
 * In couple class for type and variable, so String variables will only accept Strings.
 */
public class VariableData extends ValueData {

    private final String id;
    private final int storeIndex;
    private boolean hasValue;

    public VariableData(int tokenType, String id) {
        this.type = tokenType;
        this.id = id;
        this.storeIndex = updateStoreIndex();
    }

    public VariableData(int tokenType, String id, ValueData valueData) {
        this.type = tokenType;
        this.id = id;
        validate(valueData);
        setValue(valueData);
        this.storeIndex = updateStoreIndex();
    }

    /**
     * Can be set by
     * @param tokenType
     * @param id
     * @param parserData doesn't need to be validated
     */
    public VariableData(int tokenType, String id, ParserData parserData) {
        this.type = tokenType;
        this.id = id;
        setValue(parserData);
        this.storeIndex = updateStoreIndex();
    }

    public void setValue(ParserData parserData) {
        this.parserData = parserData;
        parserData.setStore(JasminConstants.Prefix.getPrefixBasedOnType(type), storeIndex);
    }

    public void setValue(ValueData valueData) {
        validate(valueData);

        hasValue = true;
        switch (type) {
            case NimbleParser.STRING_TYPE:
                this.valueStr = valueData.valueStr;
                parserData.loadStringOntoStack(valueStr);
                parserData.setStore(JasminConstants.Prefix.STRING, storeIndex);
                break;
            case NimbleParser.BOOLEAN_TYPE:
                this.valueBool = valueData.valueBool;
                parserData.loadBooleanOnStack(valueBool);
                parserData.setStore(JasminConstants.Prefix.INTEGER_OR_BOOLEAN, storeIndex);
                break;
            case NimbleParser.INTEGER_TYPE:
                this.valueInt = valueData.valueInt;
                parserData.loadIntegerOntoStack(valueInt);
                parserData.setStore(JasminConstants.Prefix.INTEGER_OR_BOOLEAN, storeIndex);
                break;
            case NimbleParser.DOUBLE_TYPE:
                this.valueDouble = valueData.valueDouble;
                parserData.loadDoubleOntoStack(valueDouble);
                parserData.setStore(JasminConstants.Prefix.DOUBLE, storeIndex);
                break;
            default:
                throw new RuntimeException("Unknown type");
        }
    }

    public boolean hasValue() {
        return hasValue;
    }

    @Override
    public ParserData convertToParserData() {
        return parserData;
    }

    private int updateStoreIndex() {
        if(type == NimbleParser.INTEGER_TYPE
                || type == NimbleParser.BOOLEAN_TYPE
                || type == NimbleParser.STRING_TYPE) {
            return JasminHelper.incrementVariableIndex();
        } else if(type == NimbleParser.DOUBLE_TYPE) {
            return JasminHelper.incrementDoubleVariableIndex();
        } else {
            throw new RuntimeException("Not implemented");
        }
    }

    public int getStoreIndex() {
        return storeIndex;
    }

    /**
     * Throws runtime exception if for example integer is assigned to a string
     */
    private void validate(ValueData valueData) {
        int valueToken = valueData.getType();

        if (valueToken != type) {
            String errorMsg = "\n\t\tCannot assign " + valueData.toString()
                    + " to type " + NimbleParser.VOCABULARY.getLiteralName(type).replace("'","")
                    + " for identifier " + id;


            throw new RuntimeException(errorMsg + "\n");
        }
    }
}
