package Absyn;
import Symbol.Symbol;

public class FunctionDec extends Dec {
    public Symbol name;
    public FieldList params;
    public Symbol result;
    public Exp body;
    public boolean leaf;

    public FunctionDec(int p, Symbol n, FieldList f, Symbol r, Exp b) {
        super(p);
        name = n;
        params = f;
        result = r;
        body = b;
        leaf = true;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 