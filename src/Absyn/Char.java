package Absyn;
import Symbol.Symbol;

public class Char extends Exp {
    public char value;

    public Char(char v) {
        value = v;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
