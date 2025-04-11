package Types;

public class REF extends Type {
    public Type type;
    public boolean isArray; 
    public int arraySize;   

    public REF(Type t, boolean isArray, int arraySize) {
        this.type = t;
        this.isArray = isArray;
        this.arraySize = arraySize;
    }

    public REF(Type t) {
        this(t, false, -1);
    }

    public boolean coerceTo(Type t) {
        if (t instanceof REF) {
            REF other = (REF)t;
            if (this.isArray && !other.isArray) {
                return type.coerceTo(other.type);
            }
            if (this.isArray != other.isArray) return false;
            if (this.isArray && this.arraySize >= 0 && other.arraySize >= 0 
                && this.arraySize != other.arraySize) return false;
            return type.coerceTo(other.type);
        }
        if (this.isArray && t instanceof REF) {
            REF other = (REF)t;
            return !other.isArray && type.coerceTo(other.type);
        }
        return false;
    }

    public String toString() {
        if (isArray) {
            return type.toString() + "[" + (arraySize >= 0 ? arraySize : "") + "]";
        }
        return type.toString() + "*";
    }
} 