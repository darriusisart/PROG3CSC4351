package Absyn;

public class SubscriptVar extends Var {
    public Var var;
    public Exp index;

    public SubscriptVar(Var v, Exp i) {
        var = v;
        index = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 