package ErrorMsg;

public class ErrorMsg {
    private String filename;
    private int lineNum = 1;
    private java.io.PrintStream out;
    private boolean anyErrors;

    public ErrorMsg(String f) {
        filename = f;
        out = System.err;
        anyErrors = false;
    }

    public void newline(int n) {
        lineNum = n;
    }

    public void error(int pos, String msg) {
        anyErrors = true;
        out.println(filename + ":" + pos + ": " + msg);
    }

    public boolean anyErrors() {
        return anyErrors;
    }
} 