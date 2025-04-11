package Tree;

public class MOVE extends Stm {
    public Exp dst;
    public Exp src;

    public MOVE(Exp d, Exp s) {
        dst = d;
        src = s;
    }

    public ExpList kids() {
        return new ExpList(dst, new ExpList(src, null));
    }

    public Stm build(ExpList kids) {
        return new MOVE(kids.head, kids.tail.head);
    }
} 