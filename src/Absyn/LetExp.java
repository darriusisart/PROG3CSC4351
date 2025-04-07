package Absyn;
import java.util.List;
import java.util.ArrayList;

public class LetExp extends Exp {
    public List<Dec> decs;
    public Exp body;

    public LetExp(List<Dec> d, Exp b) {
        decs = d;
        body = b;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 