package Absyn;
import java.util.ArrayList;

import Symbol.Symbol;
public class EmptyExpression extends Exp{

    public EmptyExpression(int p) {
        pos=p;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }
}
