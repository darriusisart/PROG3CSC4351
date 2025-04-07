package Absyn;
import Symbol.Symbol;

public class BinOp extends Exp {
    public Exp left;
    public int op;
    public Exp right;

    public BinOp(Exp l, int o, Exp r) {
        left = l;
        op = o;
        right = r;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public final static int PLUS=0, MINUS=1, MUL=2, DIV=3, MOD=4, AND=5, OR=6,
        LSHIFT=7, RSHIFT=8, BWISEAND=9, BWISEXOR=10, BWISEOR=11, LT=12, GT=13,
        LE=14, GE=15, EQ=16, NE=17;
}
