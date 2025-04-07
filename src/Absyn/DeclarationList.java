package Absyn;
import java.util.ArrayList;
import Symbol.Symbol;
public class DeclarationList extends Decl{
    public ArrayList<Decl> list;
  public DeclarationList(int p, ArrayList<Decl> l) {
    pos = p;
    list = l;
  }

}
