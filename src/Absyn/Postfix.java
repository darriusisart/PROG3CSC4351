package Absyn;
import Symbol.Symbol;

public class Postfix extends Exp {
    public Exp exp;
    public int op;

    public Postfix(Exp e, int o) {
        exp = e;
        op = o;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public final static int MINUS_MINUS = 0;
    public final static int PLUS_PLUS = 1;
}
