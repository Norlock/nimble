package model;

public class BranchOffCommand extends JavaByteCommand {
    private BranchOffType type;
    private String label;

    public BranchOffCommand(BranchOffType branchOffType, String label) {
        this.type = branchOffType;
        this.label = label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    /**
     * Needed for 'or' expressions.
     */
    public void invertType() {
        type = type.invert();
    }

    public String getLabel() {
        return label;
    }

    public BranchOffType getType() {
        return type;
    }

    @Override
    public String toString() {
        return type + label;
    }
}
