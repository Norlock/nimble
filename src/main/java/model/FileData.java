package model;

import generated.NimbleParser;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.CustomStringBuilder;
import utils.JasminConstants;
import utils.JasminHelper;

import java.util.ArrayList;
import java.util.Map;

public class FileData extends ParserData {

    private CustomStringBuilder sb = new CustomStringBuilder();
    private ArrayList<FunctionData> methods = new ArrayList<>();
    private static final int STACK_SIZE = 100;

    /**
     * Block context of MAIN
     * @param ctx
     */
    public FileData(ParserRuleContext ctx) {
        super(ctx);
    }

    @Override
    public void appendCode(ParserData parserData) {
        if(parserData instanceof FunctionData)
            methods.add((FunctionData) parserData);
        else
            super.appendCode(parserData);
    }

    private String getFileHeader(ParserRuleContext ctx) {
        int stackSize = 100; // Resize for bigger programs
        int varAndParamsCount = JasminHelper.getVariableIndex(ctx) + 1;

        sb.appendLine(".class public " + JasminHelper.className);
        sb.appendLine(".super java/lang/Object");
        sb.appendLine();
        setStaticFieldDeclarations();
        sb.appendLine();
        sb.appendLine(".method public <init>()V");
        sb.appendLine("\taload_0                                      ; Loads \"this\" on the stack");
        sb.appendLine("\tinvokenonvirtual java/lang/Object/<init>()V  ; Call super constructor");
        sb.appendLine("\treturn                                       ; Terminate method");
        sb.appendLine(".end method");
        sb.appendLine();
        sb.appendLine("; Method definition for public static void main(String[] args)");
        appendFunctionHeader(ctx);
        sb.appendLine(".method public static main([Ljava/lang/String;)V");
        sb.appendLine("\t.limit stack " + stackSize);
        sb.appendLine("\t.limit locals " + varAndParamsCount);
        return sb.toString();
    }

    private String getFileFooter() {
        return  "\treturn\n" + ".end method";
    }

    private void appendFunctionHeader(ParserRuleContext ctx) {
        sb.appendLine(".method public static main([Ljava/lang/String;)V");
        sb.appendLine("\t.limit stack " + STACK_SIZE);
        sb.appendLine("\t.limit locals " + JasminHelper.getVariableIndex(ctx));
    }

    public void setStaticFieldDeclarations() {
        // Set static variables
        Map<String, FieldData> fields = JasminHelper.getFields();
        for(String key : fields.keySet()) {
            FieldData fieldData = fields.get(key);
            int type = fieldData.getDataType();

            sb.appendLine(".field public static " + fieldData.getIdentifier() + " "
                    + JasminConstants.DataType.getDataTypeStr(type));
        }
    }

    @Override
    public String toString() {

        return super.toString();
    }
}
