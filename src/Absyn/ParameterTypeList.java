package Absyn;
import java.util.ArrayList;

import Symbol.Symbol;
public class ParameterTypeList extends Decl{
    public ArrayList<Type> params;
    public boolean elipses;
    public ParameterTypeList(int p, boolean e, ArrayList<Type> l) {
        pos=p;
        elipses = e;
        params = l;
    }
}
