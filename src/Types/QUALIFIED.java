package Types;

public class QUALIFIED extends Type {
    public Type type;
    public boolean isVolatile;
    public boolean isConst;

    public QUALIFIED(Type t, boolean isVolatile, boolean isConst) {
        this.type = t;
        this.isVolatile = isVolatile;
        this.isConst = isConst;
    }

    public boolean coerceTo(Type t) {
        if (t instanceof QUALIFIED) {
            QUALIFIED other = (QUALIFIED)t;
            // A non-const type can be assigned to a const type, but not vice versa
            if (other.isConst && !this.isConst) return false;
            return type.coerceTo(other.type);
        }
        return type.coerceTo(t);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        if (isVolatile) sb.append("volatile ");
        if (isConst) sb.append("const ");
        sb.append(type.toString());
        return sb.toString();
    }
} 