package Absyn;
import Symbol.Symbol;

public class AssignmentExpression extends Exp {
    public Exp lhs;
    public Exp rhs;

    public AssignmentExpression(Exp l, Exp r) {
        lhs = l;
        rhs = r;
    }

    public void accept(Visitor v) {
        v.visit(this);
    }

    public final static int MULASS=0, DIVASS=1, MODASS=2, ADDASS=3, SUBASS=4, LSHIFTASS=5,
        RSHIFTASS=6, BWISEANDASS=7, BWISEXORASS=8, BWISEORASS=9, ASSIGN=10;
}
