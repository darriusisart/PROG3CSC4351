package Semant;
import Types.Type;
import Frame.Access;

public class VarEntry extends Entry {
    public Type type;
    public Access access;

    public VarEntry(Type t, Access a) {
        type = t;
        access = a;
    }
}
