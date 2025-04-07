package Absyn;
import Symbol.Symbol;
public class Enumerator extends Decl{
    public String name;
    public Exp val;

    public Enumerator(int p, String n, Exp v) {
        pos=p;
        name=n;
        val=v;
    }

}
