package Absyn;
import java.util.ArrayList;

import Symbol.Symbol;
public class ArrayType extends Decl{
    // Can either be empty
    public Exp size;
    public ArrayType(int p, Exp s) {
        pos=p;
        size=s;
    }

}
