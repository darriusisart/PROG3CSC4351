package Absyn;
import java.lang.reflect.Array;
import java.util.ArrayList;
import Symbol.Symbol;

public class StructDeclaration extends Decl{

    public Bitfield bitfield;
    public int kind;
    public String name;
    public ArrayList<StructMember> body;

    public StructDeclaration(int p, Bitfield bf, int k, String n, ArrayList<StructMember> b) {
      pos = p;
      bitfield = bf;
      name=n;
      body=b;
      kind=k;
  }

   public final static int STRUCT=0, UNION=1;
}
