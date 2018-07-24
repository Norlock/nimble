package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;

/**
 * In couple class for type and variable, so String variables will only accept Strings.
 */
public class VariableData extends ValueData {

    private final String id;
    private final int storeIndex;
    private final ParserRuleContext ctx;
    private boolean hasValue;

    public VariableData(ParserRuleContext ctx, int tokenType, String id) {
        this.ctx = ctx;
        this.type = tokenType;
        this.id = id;
        this.storeIndex = updateStoreIndex();
    }

    public VariableData(ParserRuleContext ctx, int tokenType, String id, ValueData valueData) {
        this.ctx = ctx;
        this.type = tokenType;
        this.id = id;
        validate(valueData);
        setValue(valueData);
        this.storeIndex = updateStoreIndex();
    }

    /**
     * Can be set by an expression like: int a = 3 + 2;
     * @param tokenType
     * @param id
     * @param expressionData doesn't need to be validated
     */
    public VariableData(ParserRuleContext ctx, int tokenType, String id, ExpressionData expressionData) {
        this.ctx = ctx;
        this.type = tokenType;
        this.id = id;
        validate(expressionData);
        setValue(expressionData);
        this.storeIndex = updateStoreIndex();
    }

    public void setValue(ExpressionData expressionData) {
        validate(expressionData);
    }

    public void setValue(ValueData valueData) {
        validate(valueData);
        hasValue = true;
        setStore(JasminConstants.Prefix.getPrefixBasedOnType(type), storeIndex);

    }

    public boolean hasValue() {
        return hasValue;
    }

    private int updateStoreIndex() {
        if(type == NimbleParser.INTEGER_TYPE
                || type == NimbleParser.BOOLEAN_TYPE
                || type == NimbleParser.STRING_TYPE) {
            return JasminHelper.incrementVariableIndex();
        } else if(type == NimbleParser.DOUBLE_TYPE) {
            return JasminHelper.incrementDoubleVariableIndex();
        } else {
            throw new RuntimeException("Unknown type");
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
