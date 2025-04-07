package Absyn;
import Symbol.Symbol;

public class ParenExpression extends Exp {
    public Exp exp;

    public ParenExpression(Exp e) {
        exp = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
