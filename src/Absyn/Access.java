package Absyn;
import Symbol.Symbol;

public class Access extends Postfix {
    public Access(Exp e, int o) {
        super(e, o);
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public final static int PERIOD=0, ARROW=1;
}
