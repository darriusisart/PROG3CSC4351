package Absyn;

abstract public class Dec extends Absyn {
    public int pos;

    public Dec(int p) {
        pos = p;
    }

    abstract public void accept(Visitor v);
} 