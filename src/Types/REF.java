package Types;

public class REF extends Type {
    public Type type;

    public REF(Type t) {
        type = t;
    }

    public boolean coerceTo(Type t) {
        if (t instanceof REF) {
            return type.coerceTo(((REF)t).type);
        }
        return false;
    }

    public String toString() {
        return "ref(" + type + ")";
    }
} 