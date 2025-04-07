package Absyn;
import Symbol.Symbol;
import java.util.ArrayList;

public class FuncExpression extends Exp {
    public Exp func;
    public ArrayList<Exp> args;

    public FuncExpression(Exp f, ArrayList<Exp> a) {
        func = f;
        args = a;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
