package model;

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
    private ArrayList<ParserData> fields = new ArrayList<>();
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
        throwError("This method call is not allowed here.");
    }

    public void appendField(ParserData field) {
        fields.add(field);
    }

    public void appendFunction(FunctionData function) {
        functions.add(function);
    }

    public void appendMain(FunctionData main) {
        this.main = main;
    }

    private void appendFileHeader() {
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

    private void appendEndFunction() {
        sb.appendLine(".end method");
        sb.appendLine();
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
        appendFileHeader();

        for(ParserData parserData : fields) {
            for(JavaByteCommand command : parserData.getCode()) {
                sb.appendLine("\t" + command);
            }
        }

        for(JavaByteCommand command : main.getCode()) {
            sb.appendLine("\t" + command);
        }

        appendEndFunction();

        for(FunctionData functionData : functions) {
            appendFunctionHeader(functionData);
            for(JavaByteCommand command : functionData.getCode()) {
                sb.appendLine("\t" + command);
            }
            appendEndFunction();
        }

        return sb.toString();
    }
}
