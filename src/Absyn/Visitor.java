package Absyn;

public interface Visitor {
    void visit(VarExp v);
    void visit(CallExp v);
    void visit(OpExp v);
    void visit(RecordExp v);
    void visit(SeqExp v);
    void visit(AssignExp v);
    void visit(IfExp v);
    void visit(WhileExp v);
    void visit(ForExp v);
    void visit(LetExp v);
    void visit(ArrayExp v);
    void visit(SimpleVar v);
    void visit(FieldVar v);
    void visit(SubscriptVar v);
    void visit(VarDec v);
    void visit(FunctionDec v);
    void visit(IntExp v);
    void visit(Postfix v);
    void visit(Id v);
    void visit(ArgumentList v);
    void visit(ArrayExpression v);
    void visit(AssignmentExpression v);
    void visit(BinOp v);
    void visit(Char v);
    void visit(CommaExpression v);
    void visit(EmptyExpression v);
    void visit(ExpList v);
    void visit(FuncExpression v);
    void visit(IdExp v);
    void visit(ParenExpression v);
    void visit(SizeofExpression v);
    void visit(StringLit v);
    void visit(UnaryExpression v);
} 