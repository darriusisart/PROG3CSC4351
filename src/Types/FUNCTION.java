package Types;

import java.util.List;
import java.util.ArrayList;

public class FUNCTION extends Type {
    public Type returnType;
    public List<Type> paramTypes;
    public boolean isVarargs;

    public FUNCTION(Type ret, List<Type> params, boolean varargs) {
        this.returnType = ret;
        this.paramTypes = params;
        this.isVarargs = varargs;
    }

    public boolean coerceTo(Type t) {
        if (t instanceof FUNCTION) {
            FUNCTION other = (FUNCTION)t;
            if (!returnType.coerceTo(other.returnType)) return false;
            if (paramTypes.size() != other.paramTypes.size()) return false;
            if (isVarargs != other.isVarargs) return false;
            for (int i = 0; i < paramTypes.size(); i++) {
                if (!paramTypes.get(i).coerceTo(other.paramTypes.get(i))) return false;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(returnType.toString());
        sb.append(" (*)(");
        for (int i = 0; i < paramTypes.size(); i++) {
            if (i > 0) sb.append(", ");
            sb.append(paramTypes.get(i).toString());
        }
        if (isVarargs) {
            if (paramTypes.size() > 0) sb.append(", ");
            sb.append("...");
        }
        sb.append(")");
        return sb.toString();
    }
} 