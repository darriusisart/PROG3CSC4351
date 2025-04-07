package Absyn;
import Symbol.Symbol;
public class StatementList extends Statement{
    public Statement list;
    public Statement stmt;
  public StatementList(int p, Statement l, Statement s) {
    pos = p;
    list = l;
    stmt = s;
  }
}
