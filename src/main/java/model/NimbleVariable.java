package model;

import generated.NimbleParser;
import main.Nimble;

public class NimbleVariable {

    private VarTypeData varTypeData;
    private ValueData valueData;
    private final String id;
    private int storeIndex;

    public NimbleVariable(VarTypeData varTypeData, String id) {
        this.varTypeData = varTypeData;
        this.id = id;
        setStoreIndex();
    }

    public NimbleVariable(VarTypeData varTypeData, ValueData valueData, String id) {
        this.varTypeData = varTypeData;
        this.valueData = valueData;
        this.id = id;
        setStoreIndex();
        validate();
    }

    private void setStoreIndex() {
        if(varTypeData.getType() == NimbleParser.INTEGER_TYPE
                || varTypeData.getType() == NimbleParser.BOOLEAN_TYPE
                || varTypeData.getType() == NimbleParser.STRING_TYPE) {
            storeIndex = JasminHelper.incrementVariableIndex();
        } else if(varTypeData.getType() == NimbleParser.DOUBLE_TYPE) {
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
    }

    public VarTypeData getVarTypeData() {
        return varTypeData;
    }

    public ValueData getValueData() {
        return valueData;
    }

    /**
     * Throws runtime exception if for example integer is assigned to a string
     */
    private void validate() {
        int valueToken = valueData.getType();
        int typeToken = varTypeData.getType();

        if (valueToken != typeToken) {
            String errorMsg = "\n\t\tCannot assign " + valueData.toString()
                    + " to type " + NimbleParser.VOCABULARY.getLiteralName(typeToken).replace("'","")
                    + " for identifier " + id;


            throw new RuntimeException(errorMsg + "\n");
        }
    }
}
