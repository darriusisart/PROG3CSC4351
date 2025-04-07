package Absyn;
import java.util.ArrayList;
import Symbol.Symbol;

public class ParameterList extends Decl {
    public ArrayList<Parameter> params;
    public boolean elipses;
    public ParameterList(int p, boolean e, ArrayList<Parameter> l) {
        pos=p;
        elipses = e;
        params = l;
    }
}
