package Types;

import java.util.HashMap;
import java.util.Map;

public class ENUM extends Type {
    public String name;
    public Map<String, Integer> values;
    public int nextValue;

    public ENUM(String n) {
        this.name = n;
        this.values = new HashMap<>();
        this.nextValue = 0;
    }

    public void addValue(String name, Integer value) {
        if (value == null) {
            value = nextValue++;
        } else {
            nextValue = value + 1;
        }
        values.put(name, value);
    }

    public boolean coerceTo(Type t) {
        if (t instanceof ENUM) {
            ENUM other = (ENUM)t;
            return name.equals(other.name);
        }
        return t instanceof INT;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("enum ");
        if (name != null) sb.append(name);
        sb.append(" {");
        for (Map.Entry<String, Integer> entry : values.entrySet()) {
            sb.append("\n  ");
            sb.append(entry.getKey());
            sb.append(" = ");
            sb.append(entry.getValue());
            sb.append(",");
        }
        sb.append("\n}");
        return sb.toString();
    }
} 