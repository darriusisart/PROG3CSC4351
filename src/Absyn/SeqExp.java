package Absyn;
import java.util.List;
import java.util.ArrayList;

public class SeqExp extends Exp {
    public List<Exp> list;

    public SeqExp(List<Exp> l) {
        list = l;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 