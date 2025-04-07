package Absyn;

public class IntExp extends Exp {
    public int value;

    public IntExp(int v) {
        value = v;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
} 