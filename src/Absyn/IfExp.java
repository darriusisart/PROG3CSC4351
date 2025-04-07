package Absyn;

public class IfExp extends Exp {
    public Exp test;
    public Exp thenclause;
    public Exp elseclause;

    public IfExp(Exp t, Exp th, Exp el) {
        test = t;
        thenclause = th;
        elseclause = el;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 