package Absyn;
import Symbol.Symbol;
public class ExpressionStatement extends Statement{
  public Exp expression;
  public ExpressionStatement(int p, Exp e) {
    pos = p;
    expression = e;
  }
}
