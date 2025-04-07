package Absyn;
import Symbol.Symbol;

abstract public class Exp extends Absyn {
    abstract public void accept(Visitor v);
}
