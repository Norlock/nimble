package utils;

import generated.NimbleParser;
import model.VariableData;

import java.util.HashMap;
import java.util.Map;

public class VariableContainer {

    private Map<String, VariableData> variables = new HashMap<>();

    public boolean containsKey(String identifier) {
        return variables.containsKey(identifier);
    }

    public VariableData get(String identifier) {
        return variables.get(identifier);
    }

    public void put(String identifier, VariableData variableData) {
        variables.put(identifier, variableData);
    }
}
