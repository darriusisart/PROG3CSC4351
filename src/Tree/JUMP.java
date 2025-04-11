package Tree;

public class JUMP extends Stm {
    public Exp exp;

    public JUMP(Exp e) {
        exp = e;
    }

    public ExpList kids() {
        return new ExpList(exp, null);
    }

    public Stm build(ExpList kids) {
        return new JUMP(kids.head);
    }
} 