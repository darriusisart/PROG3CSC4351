package Types;

import java.util.HashMap;
import java.util.Map;

public class STRUCT extends Type {
    public String name;
    public boolean isUnion;
    public Map<String, Field> fields;
    public int size;
    public int alignment;

    public static class Field {
        public Type type;
        public String name;
        public int offset;
        public int bitWidth; 

        public Field(Type t, String n, int o, int bw) {
            type = t;
            name = n;
            offset = o;
            bitWidth = bw;
        }
    }

    public STRUCT(String n, boolean isUnion) {
        this.name = n;
        this.isUnion = isUnion;
        this.fields = new HashMap<>();
        this.size = 0;
        this.alignment = 0;
    }

    public void addField(String name, Type type, int bitWidth) {
        int fieldSize = type instanceof REF ? 4 : 4; 
        int fieldAlignment = type instanceof REF ? 4 : 4; 

        if (isUnion) {
            // unions - all fields start at offset 0
            fields.put(name, new Field(type, name, 0, bitWidth));
            size = Math.max(size, fieldSize);
        } else {
            // structs - align the current size to the field's alignment
            int alignedSize = (size + fieldAlignment - 1) & ~(fieldAlignment - 1);
            fields.put(name, new Field(type, name, alignedSize, bitWidth));
            size = alignedSize + fieldSize;
        }
        alignment = Math.max(alignment, fieldAlignment);
    }

    public boolean coerceTo(Type t) {
        if (t instanceof STRUCT) {
            STRUCT other = (STRUCT)t;
            if (!name.equals(other.name)) return false;
            if (isUnion != other.isUnion) return false;
            for (Map.Entry<String, Field> entry : fields.entrySet()) {
                Field otherField = other.fields.get(entry.getKey());
                if (otherField == null) return false;
                if (!entry.getValue().type.coerceTo(otherField.type)) return false;
            }
            return true;
        }
        return false;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(isUnion ? "union " : "struct ");
        if (name != null) sb.append(name);
        sb.append(" {");
        for (Field f : fields.values()) {
            sb.append("\n  ");
            sb.append(f.type.toString());
            sb.append(" ");
            sb.append(f.name);
            if (f.bitWidth >= 0) {
                sb.append(" : ");
                sb.append(f.bitWidth);
            }
            sb.append(";");
        }
        sb.append("\n}");
        return sb.toString();
    }
} 