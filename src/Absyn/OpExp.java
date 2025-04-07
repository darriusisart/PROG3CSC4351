package Absyn;

public class OpExp extends Exp {
    public Exp left;
    public Exp right;
    public int oper;

    public static final int PLUS = 0;
    public static final int MINUS = 1;
    public static final int TIMES = 2;
    public static final int DIVIDE = 3;
    public static final int EQ = 4;
    public static final int NEQ = 5;
    public static final int LT = 6;
    public static final int LE = 7;
    public static final int GT = 8;
    public static final int GE = 9;

    public OpExp(Exp l, int o, Exp r) {
        left = l;
        oper = o;
        right = r;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 