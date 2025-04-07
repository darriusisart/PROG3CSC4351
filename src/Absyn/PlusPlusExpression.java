package Absyn;
import Symbol.Symbol;

public class PlusPlusExpression extends Postfix {
    public PlusPlusExpression(Exp e) {
        super(e, Postfix.PLUS_PLUS);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
