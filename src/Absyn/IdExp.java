package Absyn;
import Symbol.Symbol;

public class IdExp extends Exp {
    public Symbol name;

    public IdExp(Symbol n) {
        name = n;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
