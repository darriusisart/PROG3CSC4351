package Absyn;
import Symbol.Symbol;
import java.util.ArrayList;

public class CommaExpression extends Exp {
    public ArrayList<Exp> expressions;

    public CommaExpression() {
        expressions = new ArrayList<Exp>();
    }

    public void add(Exp e) {
        expressions.add(e);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
