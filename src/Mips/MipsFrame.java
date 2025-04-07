package Mips;

import Frame.*;
import Temp.*;
import Tree.*;
import Util.BoolList;
import java.util.ArrayList;
import java.util.List;

public class MipsFrame extends Frame {
    public static final int wordSize = 4;
    public static final int maxArgsInRegs = 4;
    public static final int maxRegs = 8;
    private int offset = 0;

    public MipsFrame(Label name, List<Boolean> formals) {
        this.name = name;
        // Allocate space for saved registers
        offset = -maxRegs * wordSize;
        this.formals = allocFormals(0, formals);
    }

    private AccessList allocFormals(int offset, List<Boolean> formals) {
        if (formals == null || formals.isEmpty()) return null;
        Access a;
        if (formals.get(0)) {
            // If the formal escapes, allocate it in the frame
            a = new InFrame(offset);
        } else {
            // Try to allocate in a register if possible
            if (offset < maxArgsInRegs * wordSize) {
                a = new InReg(new Temp());
            } else {
                a = new InFrame(offset);
            }
        }
        return new AccessList(a, allocFormals(offset + wordSize, formals.subList(1, formals.size())));
    }

    public Access allocLocal(boolean escape) {
        if (escape) {
            // Allocate in frame
            offset -= wordSize;
            return new InFrame(offset);
        } else {
            // Allocate in register
            return new InReg(new Temp());
        }
    }

    public Access allocFormal(int i, boolean escape) {
        if (i < maxArgsInRegs) {
            // Pass in register
            return new InReg(new Temp());
        } else {
            // Pass in frame
            int frameOffset = (i - maxArgsInRegs) * wordSize;
            return new InFrame(frameOffset);
        }
    }

    public Exp externalCall(String func, ExpList args) {
        return new Tree.CALL(new Tree.NAME(Temp.namedLabel(func)), args);
    }

    public String string(Label lab, String str) {
        return lab + ":\n" +
               ".asciiz \"" + str + "\"\n" +
               ".align 2\n";
    }

    public Stm procEntryExit1(Stm body) {
        return body;
    }

    public String procEntryExit2(String body) {
        return body;
    }

    public String procEntryExit3(String body) {
        return body;
    }

    public static class InFrame extends Access {
        int offset;

        InFrame(int o) {
            offset = o;
        }

        public Exp exp(Exp fp) {
            return new MEM(new BINOP(BINOP.PLUS, fp, new CONST(offset)));
        }
    }

    public static class InReg extends Access {
        Temp temp;

        InReg(Temp t) {
            temp = t;
        }

        public Exp exp(Exp fp) {
            return new TEMP(temp);
        }
    }
} 