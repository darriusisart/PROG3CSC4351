package Tree;

public class SEQ extends Stm {
    public Stm left;
    public Stm right;

    public SEQ(Stm l, Stm r) {
        left = l;
        right = r;
    }

    public ExpList kids() {
        return null;
    }

    public Stm build(ExpList kids) {
        return this;
    }
} 