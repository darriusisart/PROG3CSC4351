package Absyn;
import Symbol.Symbol;

public class VarDec extends Dec {
    public Symbol name;
    public Symbol typ;
    public Exp init;
    public boolean escape;

    public VarDec(int p, Symbol n, Symbol t, Exp i) {
        super(p);
        name = n;
        typ = t;
        init = i;
        escape = false;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 