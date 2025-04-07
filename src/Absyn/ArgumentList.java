package Absyn;
import java.util.List;
import Symbol.Symbol;
import java.util.ArrayList;

public class ArgumentList extends Exp {
    public ArrayList<Exp> args;

    public ArgumentList() {
        args = new ArrayList<Exp>();
    }

    public ArgumentList(int p, Exp as, Exp a) {
        pos = p;
        args = new ArrayList<Exp>();
        if (as instanceof ArgumentList) {
            args.addAll(((ArgumentList)as).args);
        } else if (as != null) {
            args.add(as);
        }
        if (a != null) {
            args.add(a);
        }
    }

    public void add(Exp e) {
        args.add(e);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
