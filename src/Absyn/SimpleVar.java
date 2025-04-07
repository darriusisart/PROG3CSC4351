package Absyn;
import Symbol.Symbol;

public class SimpleVar extends Var {
    public Symbol name;
    public boolean escape = false;

    public SimpleVar(Symbol n) {
        name = n;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 