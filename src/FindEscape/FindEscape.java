package FindEscape;

import Absyn.*;
import Symbol.Symbol;
import Symbol.Table;
import Absyn.Exp;
import Absyn.Var;
import Absyn.Dec;
import Absyn.VarExp;
import Absyn.CallExp;
import Absyn.OpExp;
import Absyn.RecordExp;
import Absyn.SeqExp;
import Absyn.AssignExp;
import Absyn.IfExp;
import Absyn.WhileExp;
import Absyn.ForExp;
import Absyn.LetExp;
import Absyn.ArrayExp;
import Absyn.SimpleVar;
import Absyn.FieldVar;
import Absyn.SubscriptVar;
import Absyn.VarDec;
import Absyn.FunctionDec;
import Absyn.FieldList;
import Absyn.Efield;
import Absyn.UnaryExpression;

public class FindEscape {
    private Table varEscape;
    private int depth;

    public FindEscape() {
        varEscape = new Table();
        depth = 0;
    }

    public void findEscape(Exp exp) {
        traverseExp(depth, exp);
    }

    private void traverseExp(int depth, Exp exp) {
        if (exp == null) return;

        if (exp instanceof VarExp) {
            traverseVar(depth, ((VarExp)exp).var);
        } else if (exp instanceof CallExp) {
            CallExp call = (CallExp)exp;
            for (Exp arg : call.args) {
                traverseExp(depth, arg);
            }
        } else if (exp instanceof OpExp) {
            OpExp op = (OpExp)exp;
            traverseExp(depth, op.left);
            traverseExp(depth, op.right);
        } else if (exp instanceof UnaryExpression) {
            UnaryExpression unary = (UnaryExpression)exp;
            if (unary.op == UnaryExpression.ADDRESS_OF) {
                if (unary.exp instanceof VarExp) {
                    Var var = ((VarExp)unary.exp).var;
                    if (var instanceof SimpleVar) {
                        SimpleVar simple = (SimpleVar)var;
                        VarEscape ve = (VarEscape)varEscape.get(simple.name);
                        if (ve != null) {
                            ve.escape = true;
                            ve.var.escape = true;
                        }
                    }
                }
            }
            traverseExp(depth, unary.exp);
        } else if (exp instanceof RecordExp) {
            RecordExp rec = (RecordExp)exp;
            for (Efield field : rec.fields) {
                traverseExp(depth, field.exp);
            }
        } else if (exp instanceof SeqExp) {
            SeqExp seq = (SeqExp)exp;
            for (Exp e : seq.list) {
                traverseExp(depth, e);
            }
        } else if (exp instanceof AssignExp) {
            AssignExp assign = (AssignExp)exp;
            traverseVar(depth, assign.var);
            traverseExp(depth, assign.exp);
        } else if (exp instanceof IfExp) {
            IfExp ifExp = (IfExp)exp;
            traverseExp(depth, ifExp.test);
            traverseExp(depth, ifExp.thenclause);
            if (ifExp.elseclause != null) {
                traverseExp(depth, ifExp.elseclause);
            }
        } else if (exp instanceof WhileExp) {
            WhileExp whileExp = (WhileExp)exp;
            traverseExp(depth, whileExp.test);
            traverseExp(depth, whileExp.body);
        } else if (exp instanceof ForExp) {
            ForExp forExp = (ForExp)exp;
            traverseExp(depth, forExp.lo);
            traverseExp(depth, forExp.hi);
            traverseExp(depth, forExp.body);
        } else if (exp instanceof LetExp) {
            LetExp let = (LetExp)exp;
            varEscape.beginScope();
            for (Dec dec : let.decs) {
                traverseDec(depth, dec);
            }
            traverseExp(depth, let.body);
            varEscape.endScope();
        } else if (exp instanceof ArrayExp) {
            ArrayExp array = (ArrayExp)exp;
            traverseExp(depth, array.size);
            traverseExp(depth, array.init);
        }
    }

    private void traverseVar(int depth, Var var) {
        if (var == null) return;

        if (var instanceof SimpleVar) {
            SimpleVar simple = (SimpleVar)var;
            VarEscape ve = (VarEscape)varEscape.get(simple.name);
            if (ve != null) {
                ve.escape = true;
                ve.var.escape = true;
            }
        } else if (var instanceof FieldVar) {
            FieldVar field = (FieldVar)var;
            traverseVar(depth, field.var);
        } else if (var instanceof SubscriptVar) {
            SubscriptVar sub = (SubscriptVar)var;
            traverseVar(depth, sub.var);
            traverseExp(depth, sub.index);
        }
    }

    private void traverseDec(int depth, Dec dec) {
        if (dec == null) return;

        if (dec instanceof VarDec) {
            VarDec varDec = (VarDec)dec;
            if (varDec.typ != null && varDec.typ.toString().contains("volatile")) {
                varDec.escape = true;
            } else {
                varDec.escape = false;
            }
            varEscape.put(varDec.name, new VarEscape(depth, varDec));
            traverseExp(depth, varDec.init);
        } else if (dec instanceof FunctionDec) {
            FunctionDec funcDec = (FunctionDec)dec;
            varEscape.beginScope();
            
            for (FieldList params = funcDec.params; params != null; params = params.tail) {
                params.escape = false;
                varEscape.put(params.name, new VarEscape(depth, null));
            }
            
            traverseExp(depth, funcDec.body);
            
            varEscape.endScope();
        }
    }

    private static class VarEscape {
        int depth;
        boolean escape;
        VarDec var;

        VarEscape(int d, VarDec v) {
            depth = d;
            escape = false;
            var = v;
        }
    }
} 