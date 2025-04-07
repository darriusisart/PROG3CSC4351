package Absyn;
import Symbol.Symbol;
public class DoStatement extends Statement{
  public Exp expression;
  public Statement statement;
  public DoStatement(int p, Exp e, Statement s) {
    pos = p;
    expression = e;
    statement = s;
  }
}
