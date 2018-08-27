package model;

import generated.NimbleParser;
import model.commands.JavaByteCommand;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.CustomStringBuilder;
import utils.FunctionContainer;
import utils.JasminConstants;
import utils.JasminHelper;

import java.util.ArrayList;
import java.util.Map;

public class FileData extends ParserData {

    private CustomStringBuilder sb = new CustomStringBuilder();
    private ArrayList<FunctionData> functions = new ArrayList<>();
    private FunctionData main;
    private static final int STACK_SIZE = 100;

    /**
     * @param ctx context.
     */
    public FileData(ParserRuleContext ctx) {
        super(ctx);
    }

    @Override
    public void appendCode(ParserData parserData) {
        if(parserData instanceof FunctionData)
            functions.add((FunctionData) parserData);
        else
            super.appendCode(parserData); // Static fields + main block
    }

    public void appendMain(FunctionData main) {
        this.main = main;
    }

    private void setFileHeader() {
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
        appendFunctionHeader(main);
    }

    private void setMainFooter() {
        sb.appendLine("\treturn");
        sb.appendLine(".end method");
    }

    private void appendFunctionHeader(FunctionData functionData) {
        FunctionContainer container = functionData.getFunctionContainer();
        int variableIndex = container.getVariableIndex();
        String identifier = JasminHelper.getFunctionIdentifier(functionData.getCtx());
        sb.appendLine(".method public static " + identifier +
                "(" + container.getConstructorParams() + ")" + container.getReturnTypeStr());
        sb.appendLine("\t.limit stack " + STACK_SIZE);
        sb.appendLine("\t.limit locals " + variableIndex);
    }

    private void setStaticFieldDeclarations() {
        // Set static variables
        Map<String, FieldData> fields = JasminHelper.getFields();
        for(String key : fields.keySet()) {
            FieldData fieldData = fields.get(key);
            int type = fieldData.getDataType();

            sb.appendLine(".field public static " + fieldData.getIdentifier() + " "
                    + JasminConstants.DataType.getDataType(type));
        }
    }

    public String getFileStr() {
        setFileHeader();

        for(JavaByteCommand command : main.getCode()) {
            sb.appendLine("\t" + command);
        }

        setMainFooter();

        // TODO functies toevoegen, results van functions fixen.

        return sb.toString();
    }
}
