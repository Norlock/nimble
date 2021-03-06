package model;

import utils.ParseException;
import model.commands.BranchOffCommand;
import model.commands.BranchOffType;
import model.commands.JavaByteCommand;
import org.antlr.v4.runtime.ParserRuleContext;
import utils.JasminConstants;

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

    public void addCommand(BranchOffType type, String label) {
        code.add(new BranchOffCommand(type, label));
    }

    public void setLabel(String label) {
        code.add(new JavaByteCommand(label + JasminConstants.COLON));
    }

    public void setGotoRedirection(String label) {
        code.add(new JavaByteCommand(JasminConstants.GO_TO + label));
    }

    public JavaByteCommand getLastCmdCopy() {
        // Returns copy of last command so it doesn't use the same reference.
        return code.get(getCode().size() - 1).getCopy();
    }

    public void updateLastCmd(JavaByteCommand command) {
        code.set(code.size() - 1, command);
    }

}
