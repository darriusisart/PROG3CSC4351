package Absyn;
import Symbol.Symbol;
public class ForStatement extends Statement{
  public Exp assignment;
  public Exp comparison;
  public Exp iteration;
  public Statement statement;
  public ForStatement(int p, Exp assign, Exp comp, Exp iter, Statement s) {
    pos = p; assignment = assign; comparison = comp; iteration = iter; statement = s;
  }
}
