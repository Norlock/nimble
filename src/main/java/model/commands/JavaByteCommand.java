package model.commands;

import model.commands.BranchOffCommand;

public class JavaByteCommand {
    private String command;

    protected JavaByteCommand() {}

    public JavaByteCommand(String command) {
        this.command = command;
    }

    public boolean isBranchOffCommand() {
        return this instanceof BranchOffCommand;
    }

    public BranchOffCommand cast() {
        return (BranchOffCommand) this;
    }

    @Override
    public String toString() {
        return command;
    }
}
