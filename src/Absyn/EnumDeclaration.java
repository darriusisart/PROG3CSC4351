package Absyn;
import java.util.ArrayList;

import Symbol.Symbol;
public class EnumDeclaration extends Decl{
    public String enumName;
    public ArrayList<Enumerator> body;

    public EnumDeclaration(int p, String n, ArrayList<Enumerator> b) {
        pos=p;
        enumName=n;
        body=b;
    }

}
