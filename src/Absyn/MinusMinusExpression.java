package Absyn;
import Symbol.Symbol;

public class MinusMinusExpression extends Postfix {
    public MinusMinusExpression(Exp e) {
        super(e, Postfix.MINUS_MINUS);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
