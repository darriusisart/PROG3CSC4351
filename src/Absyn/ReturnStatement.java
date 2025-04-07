package Absyn;
import Symbol.Symbol;
public class ReturnStatement extends Statement{
  public Exp expression;
  public ReturnStatement(int p, Exp e) {
    pos = p;
    expression = e;
  }
  public ReturnStatement(int p) {
    pos = p;
    expression = null;
  }
}
