package Parse;

import java.io.Reader;
import java.io.IOException;
import ErrorMsg.ErrorMsg;
import java_cup.runtime.Symbol;
import java.util.HashMap;

public class Yylex implements java_cup.runtime.Scanner {
    private Reader reader;
    private int lineNum = 1;
    private ErrorMsg errorMsg;
    private StringBuilder currentToken = new StringBuilder();
    private int currentChar;
    private static final HashMap<String, Integer> keywords = new HashMap<>();

    static {
        keywords.put("int", sym.INT_TYPE);
        keywords.put("void", sym.VOID_TYPE);
        keywords.put("struct", sym.STRUCT);
        keywords.put("return", sym.RETURN);
        keywords.put("if", sym.IF);
        keywords.put("else", sym.ELSE);
        keywords.put("while", sym.WHILE);
        keywords.put("for", sym.FOR);
    }

    public Yylex(Reader r, ErrorMsg err) {
        reader = r;
        errorMsg = err;
        try {
            currentChar = reader.read();
        } catch (IOException e) {
            error("Error reading input: " + e.getMessage());
        }
    }

    private void advance() throws IOException {
        if (currentChar == '\n') {
            lineNum++;
        }
        currentChar = reader.read();
    }

    private void skipWhitespace() throws IOException {
        while (Character.isWhitespace(currentChar)) {
            advance();
        }
    }

    private Symbol token(int type) {
        return new Symbol(type, lineNum, lineNum);
    }

    private Symbol token(int type, Object value) {
        return new Symbol(type, lineNum, lineNum, value);
    }

    public Symbol next_token() throws IOException {
        skipWhitespace();
        
        if (currentChar == -1) {
            return token(sym.EOF);
        }

        if (Character.isLetter(currentChar) || currentChar == '_') {
            currentToken.setLength(0);
            while (Character.isLetterOrDigit(currentChar) || currentChar == '_') {
                currentToken.append((char)currentChar);
                advance();
            }
            String id = currentToken.toString();
            Integer keywordType = keywords.get(id);
            if (keywordType != null) {
                return token(keywordType);
            }
            return token(sym.ID, id);
        }

        if (Character.isDigit(currentChar)) {
            currentToken.setLength(0);
            while (Character.isDigit(currentChar)) {
                currentToken.append((char)currentChar);
                advance();
            }
            return token(sym.INT, Integer.parseInt(currentToken.toString()));
        }

        switch (currentChar) {
            case '+': advance(); return token(sym.PLUS);
            case '-': advance(); return token(sym.MINUS);
            case '*': advance(); return token(sym.TIMES);
            case '/': advance(); return token(sym.DIVIDE);
            case '=': advance(); return token(sym.ASSIGN);
            case ';': advance(); return token(sym.SEMICOLON);
            case ',': advance(); return token(sym.COMMA);
            case '(': advance(); return token(sym.LPAREN);
            case ')': advance(); return token(sym.RPAREN);
            case '{': advance(); return token(sym.LBRACE);
            case '}': advance(); return token(sym.RBRACE);
            case '[': advance(); return token(sym.LBRACK);
            case ']': advance(); return token(sym.RBRACK);
            case '&': advance(); return token(sym.AND);
            case '|': advance(); return token(sym.OR);
            case '<': advance(); return token(sym.LT);
            case '>': advance(); return token(sym.GT);
            case '!': advance(); return token(sym.NEQ);
            default:
                error("Illegal character: " + (char)currentChar);
                advance();
                return next_token();
        }
    }

    public void error(String msg) {
        errorMsg.error(lineNum, msg);
    }
} 