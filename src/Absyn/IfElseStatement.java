package Absyn;
public class IfElseStatement extends Statement{
  public Exp expression;
  public Statement if_statement;
  public Statement else_statement;
  public IfElseStatement(int p, Exp e, Statement if_s, Statement else_s) {
    pos=p; 
    expression = e; 
    if_statement = if_s; 
    else_statement = else_s;
  }
}

