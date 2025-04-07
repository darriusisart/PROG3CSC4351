package Absyn;
import java.util.ArrayList;
import Symbol.Symbol;

public class StructMember extends Decl {
    public Type type;
    public String name;
    public StructMember(int p, Type t, String n) {
        pos=p;
        name = n;
        type = t;
    }
}
