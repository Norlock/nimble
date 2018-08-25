package utils;

public class CustomStringBuilder {
    private StringBuilder sb;

    public CustomStringBuilder(){
        sb = new StringBuilder();
    }

    public void append(String str) {
        sb.append(str != null ? str : "");
    }

    public void appendLine() {
        sb.append(System.lineSeparator());
    }

    public void appendLine(String str) {
        sb.append(str != null ? str : "").append(System.lineSeparator());
    }

    public String toString() {
        return sb.toString();
    }
}
