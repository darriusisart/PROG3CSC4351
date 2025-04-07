package Absyn;
import Symbol.Symbol;

public class Id extends Exp {
    public Symbol name;

    public Id(Symbol n) {
        name = n;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
