package Frame;

import Temp.Label;
import Temp.Temp;
import Tree.Exp;
import Tree.ExpList;
import Tree.Stm;
import Util.BoolList;

public abstract class Frame {
    public Label name;
    public AccessList formals;
    public abstract Access allocLocal(boolean escape);
    public abstract Exp externalCall(String func, ExpList args);
    public abstract Stm procEntryExit1(Stm body);
    public abstract String string(Label lab, String string);
} 