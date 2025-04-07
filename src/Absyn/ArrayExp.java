package Absyn;
import Symbol.Symbol;

public class ArrayExp extends Exp {
    public Symbol typ;
    public Exp size;
    public Exp init;

    public ArrayExp(Symbol t, Exp s, Exp i) {
        typ = t;
        size = s;
        init = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 