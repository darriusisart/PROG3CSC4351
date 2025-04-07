package Translate;

import Temp.*;
import Frame.*;
import Frame.Access.*;
import Util.BoolList;
import java.util.ArrayList;
import java.util.List;

public class Level {
    public Level parent;
    public Frame frame;
    public AccessList formals;

    public Level(Level parent, Frame frame, AccessList formals) {
        this.parent = parent;
        this.frame = frame;
        this.formals = formals;
    }

    public Access allocLocal(boolean escape) {
        return frame.allocLocal(escape);
    }

    public static Level newLevel(Level parent, Label name, List<Boolean> formals) {
        Frame frame = new Mips.MipsFrame(name, formals);
        AccessList formalAccesses = null;
        AccessList last = null;

        // Allocate formals
        for (int i = 0; i < formals.size(); i++) {
            Access a = ((Mips.MipsFrame)frame).allocFormal(i, formals.get(i));
            if (formalAccesses == null) {
                formalAccesses = new AccessList(a, null);
                last = formalAccesses;
            } else {
                last.tail = new AccessList(a, null);
                last = last.tail;
            }
        }

        return new Level(parent, frame, formalAccesses);
    }
} 