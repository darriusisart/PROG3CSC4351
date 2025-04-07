package Absyn;
import java.util.List;
import java.util.ArrayList;

public class CallExp extends Exp {
    public Exp func;
    public List<Exp> args;

    public CallExp(Exp f, List<Exp> a) {
        func = f;
        args = a;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 