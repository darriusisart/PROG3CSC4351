package Absyn;

public class VarExp extends Exp {
    public Var var;

    public VarExp(Var v) {
        var = v;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 