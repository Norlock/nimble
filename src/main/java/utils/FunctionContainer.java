package utils;

import generated.NimbleParser;

public class FunctionContainer {

    private int variableIndex = 1, returnType;
    private String constructorParams = "";

    public void appendConstructorParam(int varType) {
        constructorParams += JasminConstants.DataType.getDataType(varType);
    }

    public void appendConstructorParam(String dataType) {
        constructorParams += dataType;
    }

    protected void updateVariableIndex(int varType) {
        if(varType == NimbleParser.INTEGER_TYPE
                || varType == NimbleParser.BOOLEAN_TYPE
                || varType == NimbleParser.STRING_TYPE) {
            variableIndex = variableIndex+1;
        } else if(varType == NimbleParser.DOUBLE_TYPE) {
            variableIndex = variableIndex+2;
        } else {
            throw new RuntimeException("Unknown type");
        }
    }

    public void setReturnType(int returnType) {
        this.returnType = returnType;
    }

    public int getVariableIndex() {
        return variableIndex;
    }

    public String getReturnTypeStr() {
        return JasminConstants.DataType.getDataType(returnType).toString();
    }

    public int getReturnType() {
        return returnType;
    }

    public String getConstructorParams() {
        return constructorParams;
    }
}
