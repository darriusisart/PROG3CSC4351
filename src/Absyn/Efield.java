package Absyn;
import Symbol.Symbol;

public class Efield {
    public Symbol name;
    public Exp exp;

    public Efield(Symbol n, Exp e) {
        name = n;
        exp = e;
    }
} 