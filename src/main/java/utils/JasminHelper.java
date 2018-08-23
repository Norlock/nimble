package utils;

import generated.NimbleParser;

public final class JasminHelper {
    private static int variableIndex = 1, labelIndex = 1;

    public static String getNewLabel() {
        return "label" + labelIndex++;
    }

    public static int getVariableIndex() {
        return variableIndex;
    }

    private static int incrementDoubleVariableIndex(){
        return variableIndex += 2; // Double needs two spots
    }

    private static int incrementVariableIndex() {
        return variableIndex++;
    }

    public static void updateVariableIndex(int type) {
        if(type == NimbleParser.INTEGER_TYPE
                || type == NimbleParser.BOOLEAN_TYPE
                || type == NimbleParser.STRING_TYPE) {
            incrementVariableIndex();
        } else if(type == NimbleParser.DOUBLE_TYPE) {
            incrementDoubleVariableIndex();
        } else {
            throw new RuntimeException("Unknown type");
        }
    }
}
