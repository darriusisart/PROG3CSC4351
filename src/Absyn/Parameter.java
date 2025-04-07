package Absyn;
import java.util.ArrayList;

import Symbol.Symbol;
public class Parameter extends Decl {
    public Bitfield bitfield;
    public Type type;
    public String name;
    public boolean escape = false;

    public Parameter(int p, Bitfield bf, Type t, String n) {
        pos = p;
        bitfield = bf;
        type = t;
        name = n;
        escape = false;
    }
}
