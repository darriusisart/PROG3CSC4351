package Absyn;

public class WhileExp extends Exp {
    public Exp test;
    public Exp body;

    public WhileExp(Exp t, Exp b) {
        test = t;
        body = b;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 