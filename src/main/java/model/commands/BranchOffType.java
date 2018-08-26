package model.commands;

import utils.JasminConstants;

public enum BranchOffType {

    // Jasmin will use opposition
    IF_EQUAL("ifeq"),
    IF_NOT_EQUAL("ifne"),

    IF_GREATER("ifgt"),
    IF_GREATER_OR_EQUAL("ifge"),

    IF_LESS("iflt"),
    IF_LESS_OR_EQUAL("ifle"),

    IF_INTEGER_COMPARE_EQUAL("if_icmpeq"),
    IF_INTEGER_COMPARE_NOT_EQUAL("if_icmpne"),

    IF_INTEGER_LEFT_IS_GREATER("if_icmpgt"),
    IF_INTEGER_LEFT_GREATER_OR_EQUAL("if_icmpge"),

    IF_INTEGER_LEFT_IS_LESS("if_icmplt"),
    IF_INTEGER_LEFT_IS_LESSER_OR_EQUAL("if_icmple");

    private final String value;
    private boolean isInverted;

    BranchOffType(String value) {
        this.value = value;
    }

    public BranchOffType invert() {
        isInverted = !isInverted;
        switch (this) {
            case IF_EQUAL:
                return IF_NOT_EQUAL;
            case IF_NOT_EQUAL:
                return IF_EQUAL;
            case IF_GREATER:
                return IF_LESS_OR_EQUAL;
            case IF_GREATER_OR_EQUAL:
                return IF_LESS;
            case IF_LESS:
                return IF_GREATER_OR_EQUAL;
            case IF_LESS_OR_EQUAL:
                return IF_GREATER;
            case IF_INTEGER_COMPARE_EQUAL:
                return IF_INTEGER_COMPARE_NOT_EQUAL;
            case IF_INTEGER_COMPARE_NOT_EQUAL:
                return IF_INTEGER_COMPARE_EQUAL;
            case IF_INTEGER_LEFT_IS_LESS:
                return IF_INTEGER_LEFT_GREATER_OR_EQUAL;
            case IF_INTEGER_LEFT_IS_LESSER_OR_EQUAL:
                return IF_INTEGER_LEFT_IS_GREATER;
            case IF_INTEGER_LEFT_GREATER_OR_EQUAL:
                return IF_INTEGER_LEFT_IS_LESS;
            case IF_INTEGER_LEFT_IS_GREATER:
                return IF_INTEGER_LEFT_IS_LESSER_OR_EQUAL;
                default:
                    throw new RuntimeException("Incorrect type is inverted");
        }
    }

    public boolean isInverted() {
        return isInverted;
    }

    @Override
    public String toString() {
        return value + JasminConstants.SPACE;
    }
}
