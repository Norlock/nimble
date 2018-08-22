package model;

public class JavaByteCommand {
    private String command, label;

    public JavaByteCommand(String command) {
        this.command = command;
    }

    public JavaByteCommand(String command, String label) {
        this.command = command;
        this.label = label;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public boolean hasLabel() {
        return label != null;
    }

    @Override
    public String toString() {
        return command + label;
    }
}
