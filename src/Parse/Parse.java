package Parse;

import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import ErrorMsg.ErrorMsg;
import Absyn.Exp;
import java_cup.runtime.Symbol;

public class Parse {
    public ErrorMsg errorMsg;
    public Exp absyn;
    private Grm parser;

    public Parse(String filename) {
        errorMsg = new ErrorMsg(filename);
        java.io.InputStream inp;
        try {
            inp = new java.io.FileInputStream(filename);
        } catch (java.io.FileNotFoundException e) {
            throw new Error("File not found: " + filename);
        }
        Yylex lexer = new Yylex(new java.io.InputStreamReader(inp), errorMsg);
        try {
            parser = new Grm(lexer, errorMsg);
            absyn = parse();
        } catch (Exception e) {
            throw new Error("Parser creation failed");
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            new Parse(args[0]);
        } else {
            System.err.println("Please provide a filename to parse");
        }
    }

    public Exp parse() {
        try {
            Symbol result = parser.parse();
            return (Exp) result.value;
        } catch (Exception e) {
            return null;
        }
    }
}
