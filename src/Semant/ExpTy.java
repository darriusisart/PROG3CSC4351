package Semant;

import Types.*;
import Translate.*;

public class ExpTy {
    public Exp exp;
    public Type ty;

    public ExpTy(Exp e, Type t) {
        exp = e;
        ty = t;
    }
}
