package Absyn;
import Symbol.Symbol;

public class UnaryExpression extends Exp {
    public int op;
    public Exp exp;

    public UnaryExpression(int o, Exp e) {
        op = o;
        exp = e;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public final static int PLUS=0, MINUS=1, NOT=2, COMPLEMENT=3, SIZEOF=4, ADDRESS_OF=5;
}
