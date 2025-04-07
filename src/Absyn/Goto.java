package Absyn;
import Symbol.Symbol;
public class Goto extends Statement{
  public Id label;
  public Goto(int p, Id l) {
    pos = p;
    label = l;
  }
}
