package Semant;
import Symbol.Table;
import Symbol.Symbol;
import Types.Type;
import Types.RECORD;
import Types.NAME;
import Frame.Frame;
import Temp.Label;

class Env {
  Table venv;			// value environment
  Table tenv;			// type environment
  ErrorMsg.ErrorMsg errorMsg;

  private static Symbol sym(String s) {
    return Symbol.symbol(s);
  }

  private static final Types.VOID VOID = Semant.VOID;
  private static final Types.INT INT = Semant.INT;
  private static final Types.STRING STRING = Semant.STRING;

  private static FunEntry FunEntry(Type result) {
    return new FunEntry(result, new Mips.MipsFrame(new Label("std_lib"), null));
  }

  Env(ErrorMsg.ErrorMsg err) {
    errorMsg = err;
    venv = new Table();
    tenv = new Table();

    // initialize tenv and venv with predefined identifiers
    NAME INT = new NAME(sym("int"));
    INT.bind(Semant.INT);
    tenv.put(sym("int"), INT);

    NAME STRING = new NAME(sym("string"));
    STRING.bind(Semant.STRING);
    tenv.put(sym("string"), STRING);

    // C standard library functions
    venv.put(sym("printf"),   FunEntry(VOID));
    venv.put(sym("scanf"),    FunEntry(INT));
    venv.put(sym("malloc"),   FunEntry(new Types.REF(VOID)));
    venv.put(sym("free"),     FunEntry(VOID));
    venv.put(sym("exit"),     FunEntry(VOID));
    venv.put(sym("strlen"),   FunEntry(INT));
    venv.put(sym("strcpy"),   FunEntry(new Types.REF(STRING)));
    venv.put(sym("strcat"),   FunEntry(new Types.REF(STRING)));
    venv.put(sym("strcmp"),   FunEntry(INT));
  }
}
