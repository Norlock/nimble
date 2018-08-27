package model.commands;

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

    public JavaByteCommand getCopy() {
        return new JavaByteCommand(command);
    }

    @Override
    public String toString() {
        return command;
    }
}
