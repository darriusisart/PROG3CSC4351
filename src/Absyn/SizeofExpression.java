package Absyn;
import Symbol.Symbol;

public class SizeofExpression extends Exp {
    public Exp exp;
    Decl name;

    public SizeofExpression(int p, Exp e) {
        pos=p;
        exp=e;
        name=null;
    }
    public SizeofExpression(int p, Decl n) {
        name=n;
        pos=p;
        exp=null;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
