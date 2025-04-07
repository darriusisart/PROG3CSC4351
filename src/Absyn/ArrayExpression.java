package Absyn;
import Symbol.Symbol;

public class ArrayExpression extends Exp {
    public Exp size;
    public Exp init;

    public ArrayExpression(Exp s, Exp i) {
        size = s;
        init = i;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
