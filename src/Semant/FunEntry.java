package Semant;
import Types.Type;
import Frame.Frame;

public class FunEntry extends Entry {
    public Type result;
    public Frame frame;

    public FunEntry(Type result, Frame frame) {
        this.result = result;
        this.frame = frame;
    }
}
