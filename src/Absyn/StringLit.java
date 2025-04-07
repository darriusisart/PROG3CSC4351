package Absyn;
import Symbol.Symbol;

public class StringLit extends Exp {
    public String value;

    public StringLit(String v) {
        value = v;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
