package model;

import org.antlr.v4.runtime.ParserRuleContext;
import utils.JasminConstants;
import utils.JasminHelper;

import java.nio.file.Paths;

public class FieldData extends BaseValue {

    private int fieldType;
    private String fieldNameFull;
    private String id;

    public FieldData(ParserRuleContext ctx, String id, int fieldType) {
        super(ctx);
        this.fieldType = fieldType;

        String getStatic = JasminConstants.GET_STATIC;
        this.id = id;
        fieldNameFull = Paths.get(JasminHelper.className, id).toString();

        addCommand(getStatic + fieldNameFull + " " + JasminConstants.DataType.getDataTypeStr(fieldType));
    }

    @Override
    public int getDataType() {
        return fieldType;
    }

    public String getFieldNameFull() {
        return fieldNameFull;
    }

    public String getIdentifier() {
        return id;
    }
}
