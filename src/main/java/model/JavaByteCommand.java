package model;

public class JavaByteCommand {
    private String command;

    protected JavaByteCommand() {}

    public JavaByteCommand(String command) {
        this.command = command;
    }

    public void setCommand(String command) {
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
