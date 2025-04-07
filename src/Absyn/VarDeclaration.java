package Absyn;
import Symbol.Symbol;
public class VarDeclaration extends Decl{
    public Bitfield bitfield;
    public Type type;
    public String name;
    public Exp init;
    public boolean escape = false;

    public VarDeclaration(int p, Bitfield bf, Type t, String n, Exp i) {
        pos=p;
        bitfield = bf;
        type = t;
        name = n;
        init = i;
        escape = false;
    }

}
