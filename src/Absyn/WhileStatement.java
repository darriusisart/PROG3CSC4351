package Absyn;
import Symbol.Symbol;
public class WhileStatement extends Statement{
  public Exp expression;
  public Statement statement;
  public WhileStatement(int p, Exp e, Statement s) {
    pos = p;
    expression = e;
    statement = s;
  }
}
