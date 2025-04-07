package Absyn;
import Symbol.Symbol;
public class LabelStatement extends Statement{
    Id label;
    Statement stmt;
  public LabelStatement(int p, Id v, Statement s) {
    pos = p;
    label = v;
    stmt = s;
  }
}
