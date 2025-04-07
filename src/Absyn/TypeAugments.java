package Absyn;
import java.util.ArrayList;

import Symbol.Symbol;
public class TypeAugments{
    public int pointercount;
    public ArrayList<ArrayType> brackets;

    public TypeAugments(int p, int pc, ArrayList<ArrayType> b) {
        this.pointercount = pc;
        this.brackets = b;
    }

}
