package Absyn;
import java.lang.reflect.Array;
import java.util.ArrayList;

import Symbol.Symbol;
public class FunctionDeclaration extends Decl{

  public Bitfield bitfield;
  public Type type;
  public String name;
  public ParameterTypeList paramtypes;
  public boolean leaf = true;

  public FunctionDeclaration(int p, Bitfield bf, Type t, String n, ParameterTypeList tl) {
    pos = p;
    bitfield = bf;
    type=t;
    name=n;
    paramtypes=tl;
    leaf = true;
  }
}
