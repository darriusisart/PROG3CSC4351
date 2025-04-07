package Absyn;
import java.lang.reflect.Array;
import java.util.ArrayList;

import Symbol.Symbol;
public class Typedef extends Decl{
  public Type type;
  public String name;
  public Typedef(int p, Type t, String n) {
      pos = p;
      type = t;
      name = n;
  }
}
