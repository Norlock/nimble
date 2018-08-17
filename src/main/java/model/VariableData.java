package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

/**
 * In couple class for type and variable, so String variables will only accept Strings.
 */
public class VariableData extends BaseValue {

    private final String id;
    private final int variableIndex, type;

    public VariableData(ParserRuleContext ctx, int type, String id) {
        this(ctx, type, id, new ValueData(ctx, type));
    }

    public VariableData(ParserRuleContext ctx, int type, String id, BaseValue baseValue) {
        super(ctx, baseValue.getCode());
        this.id = id;
        this.type = type;

        validate(baseValue.getType());
        variableIndex = JasminHelper.getVariableIndex();
        storeData();
        JasminHelper.updateVariableIndex(type);

    }

    public void updateData(BaseValue baseValue) {
        emptyCode();
        validate(baseValue.getType());
        addCode(baseValue.getCode());
        storeData();
    }

    /**
     * Throws runtime exception if for example integer is assigned to a string
     */
    private void validate(int valueType) {
        if (this.type != valueType) {
            String errorMsg = "\n\t\tCannot assign " + id
                    + " to type " + NimbleParser.VOCABULARY.getLiteralName(valueType).replace("'","")
                    + " for identifier " + id;

            throwError(errorMsg);
        }
    }

    /**
     * Stores the data so it can be loaded a different time
     */
    private void storeData() {
        String prefix = JasminConstants.Prefix.getPrefixBasedOnType(type).toString();
        if(0 <= variableIndex && variableIndex <= 3) {
            addCommand(prefix + JasminConstants.STORE_VAl_SMALL + variableIndex);
        } else {
            addCommand(prefix + JasminConstants.STORE_VAL + variableIndex);
        }
    }

    @Override
    public int getType() {
        return type;
    }

    @Override
    public void loadDataOntoStack() {
        loadDataOntoStack(type);
    }

    @Override
    public void loadDataOntoStack(int type) {
        emptyCode(); // Once a variable is set
        String prefix = JasminConstants.Prefix.getPrefixBasedOnType(type).toString();
        if(0 <= variableIndex && variableIndex <= 3) {
            addCommand(prefix + JasminConstants.LOAD_VAL_SMALL + variableIndex);
        } else {
            addCommand(prefix + JasminConstants.LOAD_VAL + variableIndex);
        }
    }

}
