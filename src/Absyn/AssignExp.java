package Absyn;

public class AssignExp extends Exp {
    public Var var;
    public Exp exp;

    public AssignExp(Var v, Exp e) {
        var = v;
        exp = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 