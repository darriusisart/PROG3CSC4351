package Absyn;
import java.util.List;
import java.util.ArrayList;
import Symbol.Symbol;

public class RecordExp extends Exp {
    public Symbol typ;
    public List<Efield> fields;

    public RecordExp(Symbol t, List<Efield> f) {
        typ = t;
        fields = f;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 