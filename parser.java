
//----------------------------------------------------
// The following code was generated by CUP v0.10g
// Mon Apr 07 14:03:34 CDT 2025
//----------------------------------------------------

package Parse;

import java_cup.runtime.*;
import Absyn.*;
import Symbol.Symbol;
import java.util.ArrayList;

public class parser extends java_cup.runtime.lr_parser {

  /** constructor */
  public parser() {super();}

  /** production table */
  protected static final short _production_table[][] = {
        {1, 2},     {0, 2},     {1, 1},     {4, 3},     {4, 1}, 
        {6, 6},     {2, 3},     {2, 1},     {2, 0},     {5, 2}, 
        {7, 3},     {3, 2},     {3, 0},     {8, 2},     {8, 3}, 
        {8, 5},     {8, 5},     {8, 1},     {9, 1},     {9, 1}, 
        {9, 3},     {9, 3},     {9, 3},     {9, 3},     {9, 4}, 
        {10, 1}  };

  /** access to production table */
  public short[][] production_table() {return _production_table;}

  /** parse action table */
  protected static final short[][] _action_table = {
    /*0*/{23,4,-1,0},
    /*1*/{0,-5,23,-5,-1,0},
    /*2*/{0,51,23,4,-1,0},
    /*3*/{31,6,-1,0},
    /*4*/{0,-3,23,-3,-1,0},
    /*5*/{3,7,4,8,-1,0},
    /*6*/{0,-4,23,-4,-1,0},
    /*7*/{2,-9,5,-9,23,10,-1,0},
    /*8*/{2,13,5,14,-1,0},
    /*9*/{31,12,-1,0},
    /*10*/{2,-8,5,-8,-1,0},
    /*11*/{2,-10,5,-10,-1,0},
    /*12*/{23,10,-1,0},
    /*13*/{6,15,-1,0},
    /*14*/{6,-13,7,-13,26,-13,27,-13,29,-13,31,-13,33,-13,-1,0},
    /*15*/{0,-6,23,-6,-1,0},
    /*16*/{6,15,7,27,26,26,27,22,29,19,31,24,33,18,-1,0},
    /*17*/{3,-19,5,-19,10,-19,11,-19,12,-19,13,-19,-1,0},
    /*18*/{4,46,-1,0},
    /*19*/{3,-20,5,-20,10,-20,11,-20,12,-20,13,-20,-1,0},
    /*20*/{6,-18,7,-18,26,-18,27,-18,29,-18,31,-18,33,-18,-1,0},
    /*21*/{4,42,-1,0},
    /*22*/{3,41,10,30,11,31,12,33,13,32,-1,0},
    /*23*/{3,-26,4,38,5,-26,10,-26,11,-26,12,-26,13,-26,-1,0},
    /*24*/{6,-12,7,-12,26,-12,27,-12,29,-12,31,-12,33,-12,-1,0},
    /*25*/{31,24,33,18,-1,0},
    /*26*/{0,-11,6,-11,7,-11,23,-11,26,-11,27,-11,29,-11,31,-11,33,-11,-1,0},
    /*27*/{3,29,10,30,11,31,12,33,13,32,-1,0},
    /*28*/{6,-15,7,-15,26,-15,27,-15,29,-15,31,-15,33,-15,-1,0},
    /*29*/{31,24,33,18,-1,0},
    /*30*/{31,24,33,18,-1,0},
    /*31*/{31,24,33,18,-1,0},
    /*32*/{31,24,33,18,-1,0},
    /*33*/{3,-23,5,-23,10,-23,11,-23,12,-23,13,-23,-1,0},
    /*34*/{3,-24,5,-24,10,-24,11,-24,12,-24,13,-24,-1,0},
    /*35*/{3,-22,5,-22,10,-22,11,-22,12,33,13,32,-1,0},
    /*36*/{3,-21,5,-21,10,-21,11,-21,12,33,13,32,-1,0},
    /*37*/{31,24,33,18,-1,0},
    /*38*/{5,40,10,30,11,31,12,33,13,32,-1,0},
    /*39*/{3,-25,5,-25,10,-25,11,-25,12,-25,13,-25,-1,0},
    /*40*/{6,-14,7,-14,26,-14,27,-14,29,-14,31,-14,33,-14,-1,0},
    /*41*/{31,24,33,18,-1,0},
    /*42*/{5,44,10,30,11,31,12,33,13,32,-1,0},
    /*43*/{6,15,26,26,27,22,29,19,31,24,33,18,-1,0},
    /*44*/{6,-16,7,-16,26,-16,27,-16,29,-16,31,-16,33,-16,-1,0},
    /*45*/{31,24,33,18,-1,0},
    /*46*/{5,48,10,30,11,31,12,33,13,32,-1,0},
    /*47*/{6,15,26,26,27,22,29,19,31,24,33,18,-1,0},
    /*48*/{6,-17,7,-17,26,-17,27,-17,29,-17,31,-17,33,-17,-1,0},
    /*49*/{2,-7,5,-7,-1,0},
    /*50*/{0,-2,-1,0},
    /*51*/{0,-1,23,-1,-1,0},
  };

  /** access to parse action table */
  public short[][] action_table() {return _action_table;}

  /** reduce_goto table */
  protected static final short[][] _reduce_table = {
    /*0*/{1,2,4,4,6,1,-1,-1},
    /*1*/{-1,-1},
    /*2*/{4,51,6,1,-1,-1},
    /*3*/{-1,-1},
    /*4*/{-1,-1},
    /*5*/{-1,-1},
    /*6*/{-1,-1},
    /*7*/{2,8,5,10,-1,-1},
    /*8*/{-1,-1},
    /*9*/{-1,-1},
    /*10*/{-1,-1},
    /*11*/{-1,-1},
    /*12*/{5,49,-1,-1},
    /*13*/{7,15,-1,-1},
    /*14*/{3,16,-1,-1},
    /*15*/{-1,-1},
    /*16*/{7,20,8,24,9,22,10,19,-1,-1},
    /*17*/{-1,-1},
    /*18*/{-1,-1},
    /*19*/{-1,-1},
    /*20*/{-1,-1},
    /*21*/{-1,-1},
    /*22*/{-1,-1},
    /*23*/{-1,-1},
    /*24*/{-1,-1},
    /*25*/{9,27,10,19,-1,-1},
    /*26*/{-1,-1},
    /*27*/{-1,-1},
    /*28*/{-1,-1},
    /*29*/{9,36,10,19,-1,-1},
    /*30*/{9,35,10,19,-1,-1},
    /*31*/{9,34,10,19,-1,-1},
    /*32*/{9,33,10,19,-1,-1},
    /*33*/{-1,-1},
    /*34*/{-1,-1},
    /*35*/{-1,-1},
    /*36*/{-1,-1},
    /*37*/{9,38,10,19,-1,-1},
    /*38*/{-1,-1},
    /*39*/{-1,-1},
    /*40*/{-1,-1},
    /*41*/{9,42,10,19,-1,-1},
    /*42*/{-1,-1},
    /*43*/{7,20,8,44,9,22,10,19,-1,-1},
    /*44*/{-1,-1},
    /*45*/{9,46,10,19,-1,-1},
    /*46*/{-1,-1},
    /*47*/{7,20,8,48,9,22,10,19,-1,-1},
    /*48*/{-1,-1},
    /*49*/{-1,-1},
    /*50*/{-1,-1},
    /*51*/{-1,-1},
  };

  /** access to reduce_goto table */
  public short[][] reduce_table() {return _reduce_table;}

  /** instance of action encapsulation class */
  protected CUP$parser$actions action_obj;

  /** action encapsulation object initializer */
  protected void init_actions()
    {
      action_obj = new CUP$parser$actions();
    }

  /** invoke a user supplied parse action */
  public java_cup.runtime.Symbol do_action(
    int                        act_num,
    java_cup.runtime.lr_parser parser,
    java.util.Stack            stack,
    int                        top)
    throws java.lang.Exception
  {
    /* call code in generated class */
    return action_obj.CUP$parser$do_action(act_num, parser, stack, top);
  }

  /** start state */
  public int start_state() {return 0;}
  /** start production */
  public int start_production() {return 1;}

  /** EOF Symbol index */
  public int EOF_sym() {return 0;}

  /** error Symbol index */
  public int error_sym() {return 1;}



    public ErrorMsg.ErrorMsg errorMsg;

    public void syntax_error(Symbol token) {
        errorMsg.error(token.left, "Syntax error");
    }

    public parser(Yylex lex, ErrorMsg.ErrorMsg err) {
        this(lex);
        errorMsg = err;
    }

}

/** Cup generated class to encapsulate user supplied action code.*/
class CUP$parser$actions {

  /** Constructor */
  CUP$parser$actions() { }

  /** Method with the actual generated action code. */
  public final java_cup.runtime.Symbol CUP$parser$do_action(
    int                        CUP$parser$act_num,
    java_cup.runtime.lr_parser CUP$parser$parser,
    java.util.Stack            CUP$parser$stack,
    int                        CUP$parser$top)
    throws java.lang.Exception
    {
      /* Symbol object for return from actions */
      java_cup.runtime.Symbol CUP$parser$result;

      /* select the action based on the action number */
      switch (CUP$parser$act_num)
        {
          /*. . . . . . . . . . . . . . . . . . . .*/
          case 25: // variable ::= ID 
            {
              Var RESULT = null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new SimpleVar(Symbol.symbol(id)); 
              CUP$parser$result = new java_cup.runtime.Symbol(10/*variable*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 24: // expression ::= ID LPAREN expression RPAREN 
            {
              Exp RESULT = null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-3)).value;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 ArrayList<Exp> args = new ArrayList<Exp>(); args.add(e); RESULT = new CallExp(new VarExp(new SimpleVar(Symbol.symbol(id))), args); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*expression*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-3)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 23: // expression ::= expression DIVIDE expression 
            {
              Exp RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Exp e1 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Exp e2 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new OpExp(e1, OpExp.DIVIDE, e2); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*expression*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 22: // expression ::= expression TIMES expression 
            {
              Exp RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Exp e1 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Exp e2 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new OpExp(e1, OpExp.TIMES, e2); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*expression*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 21: // expression ::= expression MINUS expression 
            {
              Exp RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Exp e1 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Exp e2 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new OpExp(e1, OpExp.MINUS, e2); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*expression*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 20: // expression ::= expression PLUS expression 
            {
              Exp RESULT = null;
		int e1left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int e1right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Exp e1 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int e2left = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int e2right = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Exp e2 = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new OpExp(e1, OpExp.PLUS, e2); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*expression*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 19: // expression ::= variable 
            {
              Exp RESULT = null;
		int vleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int vright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Var v = (Var)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new VarExp(v); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*expression*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 18: // expression ::= INT 
            {
              Exp RESULT = null;
		int ileft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int iright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Integer i = (Integer)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new IntExp(i); 
              CUP$parser$result = new java_cup.runtime.Symbol(9/*expression*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 17: // statement ::= compound_statement 
            {
              Exp RESULT = null;
		int csleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int csright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Exp cs = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = cs; 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*statement*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 16: // statement ::= WHILE LPAREN expression RPAREN statement 
            {
              Exp RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Exp s = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new WhileExp(e, s); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*statement*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 15: // statement ::= IF LPAREN expression RPAREN statement 
            {
              Exp RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Exp s = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new IfExp(e, s, null); 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*statement*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 14: // statement ::= RETURN expression SEMICOLON 
            {
              Exp RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = e; 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*statement*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 13: // statement ::= expression SEMICOLON 
            {
              Exp RESULT = null;
		int eleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int eright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		Exp e = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = e; 
              CUP$parser$result = new java_cup.runtime.Symbol(8/*statement*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 12: // statement_list ::= 
            {
              ArrayList RESULT = null;
		 RESULT = new ArrayList(); 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*statement_list*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 11: // statement_list ::= statement_list statement 
            {
              ArrayList RESULT = null;
		int slleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int slright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ArrayList sl = (ArrayList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		int sleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int sright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Exp s = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = sl; 
              CUP$parser$result = new java_cup.runtime.Symbol(3/*statement_list*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 10: // compound_statement ::= LBRACE statement_list RBRACE 
            {
              Exp RESULT = null;
		int slleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int slright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ArrayList sl = (ArrayList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new SeqExp((ArrayList<Exp>)sl); 
              CUP$parser$result = new java_cup.runtime.Symbol(7/*compound_statement*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 9: // parameter ::= INT_TYPE ID 
            {
              FieldList RESULT = null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new FieldList(Symbol.symbol(id), null, null); 
              CUP$parser$result = new java_cup.runtime.Symbol(5/*parameter*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 8: // parameter_list ::= 
            {
              ArrayList RESULT = null;
		 RESULT = new ArrayList(); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*parameter_list*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 7: // parameter_list ::= parameter 
            {
              ArrayList RESULT = null;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		FieldList p = (FieldList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new ArrayList(); 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*parameter_list*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 6: // parameter_list ::= parameter_list COMMA parameter 
            {
              ArrayList RESULT = null;
		int plleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int plright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		ArrayList pl = (ArrayList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int pleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int pright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		FieldList p = (FieldList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = pl; 
              CUP$parser$result = new java_cup.runtime.Symbol(2/*parameter_list*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 5: // function_definition ::= INT_TYPE ID LPAREN parameter_list RPAREN compound_statement 
            {
              Dec RESULT = null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-4)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-4)).value;
		int plleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left;
		int plright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).right;
		ArrayList pl = (ArrayList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-2)).value;
		int csleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int csright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Exp cs = (Exp)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new FunctionDec(0, Symbol.symbol(id), (FieldList)pl, null, cs); 
              CUP$parser$result = new java_cup.runtime.Symbol(6/*function_definition*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-5)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 4: // declaration ::= function_definition 
            {
              Dec RESULT = null;
		int fdleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int fdright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Dec fd = (Dec)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = fd; 
              CUP$parser$result = new java_cup.runtime.Symbol(4/*declaration*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 3: // declaration ::= INT_TYPE ID SEMICOLON 
            {
              Dec RESULT = null;
		int idleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int idright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		String id = (String)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		 RESULT = new VarDec(0, Symbol.symbol(id), null, null); 
              CUP$parser$result = new java_cup.runtime.Symbol(4/*declaration*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-2)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 2: // declaration_list ::= declaration 
            {
              ArrayList RESULT = null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Dec d = (Dec)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new ArrayList(); 
              CUP$parser$result = new java_cup.runtime.Symbol(1/*declaration_list*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 1: // $START ::= declaration_list EOF 
            {
              Object RESULT = null;
		int start_valleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left;
		int start_valright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).right;
		ArrayList start_val = (ArrayList)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-1)).value;
		RESULT = start_val;
              CUP$parser$result = new java_cup.runtime.Symbol(0/*$START*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          /* ACCEPT */
          CUP$parser$parser.done_parsing();
          return CUP$parser$result;

          /*. . . . . . . . . . . . . . . . . . . .*/
          case 0: // declaration_list ::= declaration_list declaration 
            {
              ArrayList RESULT = null;
		int dleft = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).left;
		int dright = ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right;
		Dec d = (Dec)((java_cup.runtime.Symbol) CUP$parser$stack.elementAt(CUP$parser$top-0)).value;
		 RESULT = new ArrayList(); 
              CUP$parser$result = new java_cup.runtime.Symbol(1/*declaration_list*/, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-1)).left, ((java_cup.runtime.Symbol)CUP$parser$stack.elementAt(CUP$parser$top-0)).right, RESULT);
            }
          return CUP$parser$result;

          /* . . . . . .*/
          default:
            throw new Exception(
               "Invalid action number found in internal parse table");

        }
    }
}

