package Absyn;
import java.util.ArrayList;

import Symbol.Symbol;
public class TypeCode extends Decl{
    public int typecode;
    public String name;

    public TypeCode(int p, int ty, String n) {
        pos=p;
        this.typecode=ty;
        this.name=n;
    }

    public final static int VOID=0,CHAR=1,SHORT=2,INT=3,FLOAT=4,DOUBLE=5,ENUM=6,ID=7;
}
