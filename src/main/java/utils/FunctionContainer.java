package utils;

import generated.NimbleParser;

import java.nio.file.Paths;
import java.util.ArrayList;

public class FunctionContainer {

    private int variableIndex, returnType;
    private String constructorParams = "";
    private boolean hasReturnStatement = false;
    private final String identifier;
    private final ArrayList<Integer> constructorTypes = new ArrayList<>();

    public FunctionContainer(String functionIdentifier) {
        this.identifier = functionIdentifier;

        // If Main function
        if(identifier.equals(JasminConstants.MAIN)) {
            returnType = NimbleParser.VOID;
            constructorParams = "[Ljava/lang/String;";
        }
    }

    public ArrayList<Integer> getConstructorTypes() {
        return constructorTypes;
    }

    public void appendConstructorParam(int varType) {
        constructorTypes.add(varType);
        constructorParams += JasminConstants.DataType.getDataType(varType);
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

    public boolean isVoid() {
        return returnType == NimbleParser.VOID;
    }

    public int getReturnType() {
        return returnType;
    }

    public String getConstructorParams() {
        return constructorParams;
    }

    public boolean hasReturnStatement() {
        return hasReturnStatement;
    }

    public boolean setReturnStatementAndValidate(int actualReturnType) {
        hasReturnStatement = true;
        return (this.returnType == actualReturnType);
    }

    public String getIdentifier() {
        return identifier;
    }

    public int getConstructorType(int paramIndex) {
        return constructorTypes.get(paramIndex);
    }

    public String getFunctionCallStr() {
        return JasminConstants.INVOKE_STATIC + Paths.get(JasminHelper.className, identifier)
                + "(" + constructorParams + ")" + getReturnTypeStr();
    }
}
