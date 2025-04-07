package Absyn;
import Symbol.Symbol;
import java.util.ArrayList;

public class FieldList {
    public Symbol name;
    public Symbol typ;
    public FieldList tail;
    public boolean escape;

    public FieldList() {
        name = null;
        typ = null;
        tail = null;
        escape = false;
    }

    public FieldList(Symbol n, Symbol t, FieldList x) {
        name = n;
        typ = t;
        tail = x;
        escape = false;
    }

    public void addAll(ArrayList<FieldList> list) {
        if (list.isEmpty()) return;
        
        FieldList current = this;
        for (FieldList field : list) {
            if (current.name == null) {
                current.name = field.name;
                current.typ = field.typ;
                current.tail = field.tail;
                current.escape = field.escape;
            } else {
                current.tail = field;
                current = current.tail;
            }
        }
    }
} 