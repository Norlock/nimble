package model;

import generated.NimbleParser;
import main.ParseException;
import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.misc.Pair;

import java.util.ArrayList;

/**
 * This class doesn't check for errors, but only adds Jasmin code!
 * Checks needs to happen in the value data and variable data.
 */
public class ParserData {

    private final ParserRuleContext ctx;
    private final ArrayList<JavaByteCommand> code = new ArrayList<>();

    public ParserData(ParserRuleContext ctx) {
        this.ctx = ctx;
    }

    public void throwError(String errorMsg) {
        throw new ParseException(ctx, errorMsg);
    }

    public ArrayList<JavaByteCommand> getCode() {
        return code;
    }

    public ParserRuleContext getCtx() {
        return ctx;
    }

    public void appendCode(ParserData parserData) {
        code.addAll(parserData.getCode());
    }


    public void addCommand(String command) {
        code.add(new JavaByteCommand(command));
    }

    protected void prependCommand(String command) {
        code.add(0, new JavaByteCommand(command));
    }

    public void addCommand(BranchOffType type, String label) {
        code.add(new BranchOffCommand(type, label));
    }

    public void setLabel(String label) {
        code.add(new JavaByteCommand(label + JasminConstants.COLON));
    }

    public void setGotoRedirection(String label) {
        code.add(new JavaByteCommand(JasminConstants.GO_TO + label));
    }

    public JavaByteCommand getLastCmd() {
        return code.get(getCode().size() - 1);
    }

//    public void print(ValueData valueData) {
//        jasminCode.add(JasminConstants.LOAD_SYSO_ONTO_STACK);
//        if(valueData.isInteger()) {
//            loadIntegerOntoStack(valueData.getValueInt());
//        } else if(valueData.isDouble()) {
//            loadDoubleOntoStack(valueData.getValueDouble());
//        } else if(valueData.isBoolean()) {
//            loadBooleanOnStack(valueData.getValueBool());
//        } else  if (valueData.isString()) {
//            loadStringOntoStack(valueData.toString());
//        } else {
//            throw new RuntimeException("Not implemented");
//        }
//        jasminCode.add(JasminConstants.PRINT);
//    }

}
