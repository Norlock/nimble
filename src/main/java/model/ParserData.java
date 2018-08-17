package model;

import generated.NimbleParser;
import main.ParseException;
import org.antlr.v4.runtime.ParserRuleContext;

import java.util.ArrayList;

/**
 * This class doesn't check for errors, but only adds Jasmin code!
 * Checks needs to happen in the value data and variable data.
 */
public class ParserData {

    private final ParserRuleContext ctx;
    private ArrayList<String> code = new ArrayList<>();

    public ParserData(ParserRuleContext ctx) {
        this.ctx = ctx;
    }

    public ParserData(ParserRuleContext ctx, ArrayList<String> code) {
        this(ctx);
        code.addAll(code);
    }

    public void throwError(String errorMsg) {
        throw new ParseException(ctx, errorMsg);
    }

    public ArrayList<String> getCode() {
        return code;
    }

    public ParserRuleContext getCtx() {
        return ctx;
    }

    /**
     * Get rid of old code
     */
    protected void emptyCode() {
        code = new ArrayList<>();
    }

    protected void addCode(ArrayList<String> code) {
        code.addAll(code);
    }


    public void addCommand(String command) {
        code.add(command);
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

    public void print(ArrayList<String> code) {
        code.add(JasminConstants.LOAD_SYSO_ONTO_STACK);
        code.addAll(code);
        code.add(JasminConstants.PRINT);
    }

}
