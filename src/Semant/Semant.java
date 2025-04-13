package Semant;

import Absyn.*;
import Temp.Label;
import Translate.Level;
import Types.Type;
import FindEscape.FindEscape;
import java.util.ArrayList;
import Symbol.Symbol;
import Symbol.Table;
import Types.NAME;
import Types.RECORD;



public class Semant {
    Env env;
    Level root_level;

    public Semant(ErrorMsg.ErrorMsg err) {
        this(new Env(err));
    }

    Semant(Env e) {
        env = e;
    }

    public void transProg(Absyn tree_head) {
        FindEscape escaping = new FindEscape();
        escaping.findEscape((Exp)tree_head);

        root_level = Level.newLevel(null, new Label("Root"), new ArrayList<>());
        // formals is list of booleans where 'true' -> variable escapes
        transExp((Exp)tree_head);
    }

    private void error(int pos, String msg) {
        env.errorMsg.error(pos, msg);
    }

    static final Types.VOID VOID = new Types.VOID();
    static final Types.INT INT = new Types.INT();
    static final Types.STRING STRING = new Types.STRING();
    static final Types.NIL NIL = new Types.NIL();

    private Translate.Exp checkInt(ExpTy et, int pos) {
        if (!INT.coerceTo(et.ty)) {
            error(pos, "integer required");
            return null;
        }
        return et.exp;
    }

    private Translate.Exp checkComparable(ExpTy et, int pos){
        Type exp = et.ty.actual();
        if (!(exp instanceof Types.INT || exp instanceof Types.STRING || exp instanceof Types.NIL)) {
            error(pos, "CompError");
        }

        return et.exp;
    }

    private Translate.Exp checkOrderable(ExpTy et, int pos) {
        Type exp = et.ty.actual();
        if(!(exp instanceof Types.INT || exp instanceof Types.STRING)){
            error(pos,"OrderError");
        }
        return et.exp;
    }

    public ExpTy transExp(Exp e) {
        ExpTy result;
        System.out.println(e == null ? "null" : e.getClass());
        switch (e) {
            case ArrayExp arrayExp -> result = transExp(arrayExp);
            case AssignExp assignExp -> result = transExp(assignExp);
            case CallExp callExp -> result = transExp(callExp);
            case CommaExpression commaExpression -> result = transExp(commaExpression);
            case EmptyExpression emptyExpression -> result = transExp(emptyExpression);
            case ForExp forExp -> result = transExp(forExp);
            case FuncExpression funcExpression -> result = transExp(funcExpression);
            case IdExp idExp -> result = transExp(idExp);
            case IfExp ifExp -> result = transExp(ifExp);
            case IntExp intExp -> result = transExp(intExp);
            case LetExp letExp -> result = transExp(letExp);
            case MinusMinusExpression minusMinusExpression -> result = transExp(minusMinusExpression);
            case OpExp opExp -> result = transExp(opExp);
            case ParenExpression parenExpression -> result = transExp(parenExpression);
            case PlusPlusExpression plusPlusExpression -> result = transExp(plusPlusExpression);
            case RecordExp recordExp -> result = transExp(recordExp);
            case SeqExp seqExp -> result = transExp(seqExp);
            case SizeofExpression sizeofExpression -> result = transExp(sizeofExpression);
            case StringLit stringLit -> result = transExp(stringLit);
            case UnaryExpression unaryExpression -> result = transExp(unaryExpression);
            case VarExp varExp -> result = transExp(varExp);
            case WhileExp whileExp -> result = transExp(whileExp);
            case null, default -> {
                result = null;
                System.out.println("Error :(");
            }
        }
        return result;
    }

    public ExpTy transExp(ArrayExp e) {
        Types.Type arrayType = (Types.Type) env.tenv.get(e.typ);

        if (arrayType == null || !(arrayType instanceof Types.ARRAY)) {
            error(e.pos, "Undefined or invalid array type: " + e.typ);
            return new ExpTy(null, NIL);
        }

        ExpTy sizeExp = transExp(e.size);
        checkInt(sizeExp, e.size.pos);

        ExpTy initExp = transExp(e.init);
        Types.Type elementType = ((Types.ARRAY) arrayType).element;
        if (!initExp.ty.coerceTo(elementType)) {
            error(e.init.pos, "Array initialization type mismatch");
        }

        return new ExpTy(null, arrayType);
    }

    public ExpTy transExp(AssignExp e) {
        ExpTy varExp = transVar(e.var);
        ExpTy exp = transExp(e.exp);

        if (!exp.ty.coerceTo(varExp.ty)) {
            error(e.pos, "Type mismatch in assignment");
        }

        return new ExpTy(null, VOID);
    }

    public ExpTy transExp(CallExp e) {
        Entry funcall = (Entry) env.venv.get(((IdExp) e.func).name);
        if (funcall instanceof FunEntry) {
            FunEntry f = (FunEntry)funcall;
            Exp arg = e.args.get(0);
            int count = 0;
            while (arg != null) {
                ExpTy result = transExp(arg);
//                if (!(result.ty.coerceTo())) no arg list in funentry how do i get the args?
                count++;
                arg = e.args.get(count);
            }
            return new ExpTy(null, f.result);
        }
        error(0, "fun undeclared");
        return new ExpTy(null, VOID);
    }

    public ExpTy transExp(CommaExpression e) {
        ExpTy result = null;
        for (Exp exp : e.expressions) {
            result = transExp(exp);
        }
        return result;
    }

    public ExpTy transExp(EmptyExpression e) {
        return new ExpTy(null, NIL);
    }

    public ExpTy transExp(ForExp e) {
        ExpTy lowerExp = transExp(e.lo);
        if(checkInt(lowerExp, e.lo.pos) == null) {
            error(e.pos, "Lower bound not an integer");
            return new ExpTy(null, VOID);
        }

        ExpTy higherExp = transExp(e.hi);
        if(checkInt(lowerExp, e.hi.pos) == null) {
            error(e.pos, "Lower bound not an integer");
            return new ExpTy(null, VOID);
        }

        env.venv.beginScope();

        Frame.Access loopVarAccess = root_level.allocLocal(true);
        env.venv.put(e.var, new VarEntry(INT, loopVarAccess));

        ExpTy bodyExp = transExp(e.body);

        env.venv.endScope();

        return new ExpTy(null, VOID);
    }

    public ExpTy transExp(FuncExpression e) {
        return null;
    }

    public ExpTy intExp(IntExp e) {
        return new ExpTy(null, INT);
    }

    public ExpTy transExp(MinusMinusExpression e) {
        ExpTy exp = transExp(e.exp);
        if (!INT.coerceTo(exp.ty)) {
            error(e.pos, "Operand of '--' must be an integer");
            return new ExpTy(null, VOID);
        }
        return new ExpTy(null, INT);
    }

    public ExpTy transExp(StringLit e) {
        return new ExpTy(null, STRING);
    }

    public ExpTy transExp(OpExp e) {
        ExpTy left = transExp(e.left);
        ExpTy right = transExp(e.right);
        switch (e.oper) {
            case 0:
            case 1:
            case 2:
            case 3:
                checkInt(left, e.left.pos);
                checkInt(right, e.right.pos);
                return new ExpTy(null, INT);
            case 4:
            case 5:
                checkComparable(left, e.left.pos);
                checkComparable(right, e.right.pos);
                if (!left.ty.coerceTo(right.ty) && !right.ty.coerceTo(left.ty)) {
                    error(0, "Types are not the same, can't be compared");
                }
                return new ExpTy(null, INT);
            case 6:
            case 7:
            case 8:
            case 9:
                checkOrderable(left, e.left.pos);
                checkOrderable(right, e.right.pos);
                if (!left.ty.coerceTo(right.ty) && !right.ty.coerceTo(left.ty)) {
                    error(0, "Types are not the same, can't be ordered");
                }
                return new ExpTy(null, INT);
        }
        System.err.println("Something went wrong in OpExp switch statement");
        return null;
    }

    public ExpTy transExp(ParenExpression e) {
        return transExp(e.exp);
    }

    public ExpTy transExp(PlusPlusExpression e) {
        ExpTy exp = transExp(e.exp);
        if (!INT.coerceTo(exp.ty)) {
            error(e.pos, "Operand of '++' must be an integer");
            return new ExpTy(null, VOID);
        }
        return new ExpTy(null, INT);
    }

    public ExpTy transExp(RecordExp e) {
         NAME n = (NAME)env.tenv.get(e.typ);
         Type recordty = n.actual();

         if (recordty instanceof RECORD) {
             Efield field = e.fields.get(0);
             int count = 0;
             while (field != null) {
                ExpTy result = transExp(field.exp);
                if (!(result.ty.coerceTo(recordty))) {
                    error(0, "field didnt match record type");
                }
                count++;
                field = e.fields.get(count);
             }
             return new ExpTy(null, recordty);
         }
         error(e.pos, "soemthing went wrong with records");
         return new ExpTy(null, recordty);
    }

    public ExpTy transExp(SeqExp e) {
        ExpTy result = null;

        for (Exp exp : e.list) {
            result = transExp(exp);
        }

        return result != null ? result : new ExpTy(null, VOID);
    }

    public ExpTy transExp(SizeofExpression e) {
        ExpTy exp = transExp(e.exp);
        if (exp == null || exp.ty == null) {
            error(e.pos, "Invalid expression for sizeof");
            return new ExpTy(null, INT);
        }

        return new ExpTy(null, INT);
    }

    public ExpTy transExp(UnaryExpression e) {
        ExpTy operand = transExp(e.exp);

        switch (e.op) {
            case UnaryExpression.PLUS:
            case UnaryExpression.MINUS:
                if (!INT.coerceTo(operand.ty)) {
                    error(e.pos, "Operand must be an integer");
                    return new ExpTy(null, VOID);
                }
                return new ExpTy(null, INT);

            case UnaryExpression.NOT:
            case UnaryExpression.COMPLEMENT:
                if (!INT.coerceTo(operand.ty)) {
                    error(e.pos, "Operand must be an integer");
                    return new ExpTy(null, VOID);
                }
                return new ExpTy(null, INT);
            case UnaryExpression.SIZEOF:
                return new ExpTy(null, INT);
            case UnaryExpression.ADDRESS_OF:
                return new ExpTy(null, VOID);
            default:
                error(e.pos, "Unknown unary operator");
                return new ExpTy(null, VOID);
        }
    }

    public ExpTy transExp(WhileExp e) {
        ExpTy condition = transExp(e.test);
        checkInt(condition, e.test.pos);

        env.venv.beginScope();
        ExpTy body = transExp(e.body);
        env.venv.endScope();

        return new ExpTy(null, VOID);
    }

    public ExpTy transExp(VarExp e) {
        return transVar(e.var);
    }

    public ExpTy transDec(Decl d) {
        ExpTy result;
        switch (d) {
            case FunctionDeclaration functionDeclaration -> result = transDec(functionDeclaration);
            case StructDeclaration structDeclaration -> result = transDec(structDeclaration);
            case VarDeclaration varDeclaration -> result = transDec(varDeclaration);
            case EnumDeclaration enumDeclaration -> result = transDec(enumDeclaration);
            case EmptyDeclaration emptyDeclaration -> result = transDec(emptyDeclaration);
            case null, default -> {
                result = null;
                System.err.println("transDec error;" + d.getClass());
            }
        }
        return result;
    }

    public ExpTy transDec(FunctionDeclaration d) {
//        Types.Type result = transTy(d.result);
//        Types.RECORD formals = transTypeFields(d.params);
//        env.venv.put(d.name, new FunEntry(formals.result));
//        env.venv.beginScope();
//        for(p=dec.params; p!=null; p=p.tail){
//            env.venv.put(p.name, new VarEntry((Types.Type)env.tenv.get(p.typ)));
//        }
//        transExp(d.body);
//        env.venv.endScope();

        return null;
    }

    public ExpTy transDec(StructDeclaration d) {
        //env.tenv.put(d.name, transTy(d.ty));
        return null;
    }

    public ExpTy transDec(VarDeclaration d) {
        ExpTy temp = transExp(d.init);
        Type type = null;

        return null;
    }

    public ExpTy transDec(EnumDeclaration d) {
        int val = 0;

        for (Enumerator enumerator : d.body) {
            Symbol constant = Symbol.symbol(enumerator.name);

            if (env.venv.get(constant) != null) {
                error(d.pos, "Duplicate enum constant: " + constant);
            } else {
                env.venv.put(constant, new VarEntry(INT, root_level.allocLocal(false)));
            }

            val++;
        }

        return new ExpTy(null, VOID);
    }

    public ExpTy transDec(EmptyDeclaration d) {
        return new ExpTy(null, VOID);
    }

    public ExpTy transVar(Var e) {
        ExpTy result;
        switch(e) {
            case FieldVar fieldVar -> result = transVar((FieldVar) e);
            case SimpleVar simpleVar -> result = transVar((SimpleVar) e);
            case SubscriptVar subscriptVar -> result = transVar((SubscriptVar) e);
            case null, default -> {
                result = null;
                System.err.println("transVar error;" + e.getClass());
            }
        }
        return result;
    }

    public ExpTy transVar(FieldVar e) {
        ExpTy varExp = transVar(e.var);

        if(!(varExp.ty.actual() instanceof Types.RECORD)) {
            error(e.pos, "Variable is not a record; transVar(FieldVar)");
            return new ExpTy(null, VOID);
        }

        Types.RECORD recordType = (Types.RECORD) varExp.ty.actual();

        for (Types.RECORD field = recordType; field != null; field = field.tail) {
            if (field.fieldName.equals(e.field)) {
                return new ExpTy(null, field.fieldType);
            }
        }

        error(e.pos, "Field not found; " + e.field);
        return new ExpTy(null, VOID);
    }



    public ExpTy transVar(SimpleVar e) {
        Entry x = (Entry) env.venv.get(e.name);
        if (x instanceof VarEntry) {
            VarEntry ent = (VarEntry)x;
            return new ExpTy(null, ent.type);
        }
        error(0, "simplevar messed up");
        return new ExpTy(null, INT);
    }

    public ExpTy transVar(SubscriptVar e) {
        ExpTy varExp = transVar(e.var);

        if(!(varExp.ty.actual() instanceof Types.ARRAY)) {
            error(e.pos, "Variable is not an array; transVar(SubscriptVar)");
            return new ExpTy(null, VOID);
        }

        ExpTy indExp = transExp(e.index);

        if(checkInt(indExp, e.index.pos) == null) {
            return new ExpTy(null, VOID);
        }

        return new ExpTy(null, (Types.ARRAY) varExp.ty.actual());
    }



}
