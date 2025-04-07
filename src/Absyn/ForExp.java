package Absyn;
import Symbol.Symbol;

public class ForExp extends Exp {
    public Symbol var;
    public Exp lo;
    public Exp hi;
    public Exp body;
    public boolean escape;

    public ForExp(Symbol v, Exp l, Exp h, Exp b) {
        var = v;
        lo = l;
        hi = h;
        body = b;
        escape = false;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 