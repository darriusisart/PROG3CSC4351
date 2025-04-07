package Absyn;
import Symbol.Symbol;
public class CompoundStatement extends Statement{
  public Decl decl_list;
  public Statement stmt_list;
  public CompoundStatement(int p, Decl dl, Statement sl) {
    pos = p;
    decl_list = dl;
    stmt_list = sl;
  }
}
