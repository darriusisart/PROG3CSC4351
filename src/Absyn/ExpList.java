package Absyn;
import java.util.ArrayList;
import Symbol.Symbol;

public class ExpList extends Exp{
    public ArrayList<Exp> exps;

    public ExpList(int p) {
        pos=p;
        this.exps = new ArrayList<Exp>();
    }

    public void add(Exp e) {
        this.exps.add(e);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
