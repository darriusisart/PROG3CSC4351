package Absyn;
import Symbol.Symbol;
public class JumpStatement extends Statement{
  int type;
  public JumpStatement(int p, int t) {
    pos = p;
    type = t;
  }

   public final static int CONTINUE=0,BREAK=1;
}
