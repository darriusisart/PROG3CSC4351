package Mips;

import Frame.*;
import Temp.*;
import Tree.*;
import Tree.Stm.*;
import Tree.Exp.*;
import Util.BoolList;
import java.util.ArrayList;
import java.util.List;

public class MipsFrame extends Frame {
    public static final int wordSize = 4;
    public static final int maxArgsInRegs = 4;  // $a0-$a3
    public static final int maxRegs = 8;        // $s0-$s7
    public static final int frameHeaderSize = 4; 
    private int offset = 0;
    private int frameSize = 0;
    private List<Temp> usedRegs;
    private static final Temp FP;  // Frame pointer
    private static final Temp SP;  // Stack pointer
    private static final Temp RA;  // Return address

    static {
        FP = new Temp();
        SP = new Temp();
        RA = new Temp();
        try {
            java.lang.reflect.Field numField = Temp.class.getDeclaredField("num");
            numField.setAccessible(true);
            numField.set(FP, 30);  // $fp
            numField.set(SP, 29);  // $sp
            numField.set(RA, 31);  // $ra
        } catch (Exception e) {
            System.err.println("Failed to set register numbers: " + e.getMessage());
        }
    }

    public MipsFrame(Label name, List<Boolean> formals) {
        this.name = name;
        this.usedRegs = new ArrayList<>();
        // 1. Allocate space for saved registers ($s0-$s7)
        offset = -(maxRegs * wordSize);
        // 2. Allocate space for frame header (ra, fp)
        offset -= frameHeaderSize;
        // 3. Allocate space for outgoing arguments
        offset -= maxArgsInRegs * wordSize;
        this.formals = allocFormals(0, formals);
        frameSize = -offset; // Total frame size
    }

    private AccessList allocFormals(int offset, List<Boolean> formals) {
        if (formals == null || formals.isEmpty()) return null;
        Access a;
        if (formals.get(0)) {
            // If formal escapes, allocate it in the frame
            a = new InFrame(offset);
        } else {
            // allocate in a register if possible
            if (offset < maxArgsInRegs * wordSize) {
                Temp t = new Temp();
                usedRegs.add(t);
                a = new InReg(t);
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
            // allocate in register
            if (usedRegs.size() < maxRegs) {
                Temp t = new Temp();
                usedRegs.add(t);
                return new InReg(t);
            } else {
                // No registers, allocate in frame
                offset -= wordSize;
                return new InFrame(offset);
            }
        }
    }

    public Access allocFormal(int i, boolean escape) {
        if (i < maxArgsInRegs) {
            // Pass in register ($a0-$a3)
            Temp t = new Temp();
            usedRegs.add(t);
            return new InReg(t);
        } else {
            // Pass in frame (after $a3)
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
        List<Stm> prologue = new ArrayList<>();
        prologue.add(new MOVE(
            new MEM(new BINOP(BINOP.MINUS, new TEMP(FP), new CONST(frameHeaderSize))), 
            new TEMP(RA)));
        prologue.add(new MOVE(
            new MEM(new BINOP(BINOP.MINUS, new TEMP(FP), new CONST(frameHeaderSize + wordSize))), 
            new TEMP(FP)));        
        prologue.add(new MOVE(
            new TEMP(FP), 
            new BINOP(BINOP.MINUS, new TEMP(SP), new CONST(frameSize))));        
        for (int i = 0; i < usedRegs.size(); i++) {
            prologue.add(new MOVE(
                new MEM(new BINOP(BINOP.MINUS, new TEMP(FP), 
                                new CONST((i + 1) * wordSize))), 
                new TEMP(usedRegs.get(i))));
        }
        List<Stm> epilogue = new ArrayList<>();
        for (int i = 0; i < usedRegs.size(); i++) {
            epilogue.add(new MOVE(
                new TEMP(usedRegs.get(i)), 
                new MEM(new BINOP(BINOP.MINUS, new TEMP(FP), 
                                new CONST((i + 1) * wordSize)))));
        }      
        epilogue.add(new MOVE(
            new TEMP(FP), 
            new MEM(new BINOP(BINOP.MINUS, new TEMP(FP), 
                            new CONST(frameHeaderSize + wordSize)))));
        epilogue.add(new MOVE(
            new TEMP(RA), 
            new MEM(new BINOP(BINOP.MINUS, new TEMP(FP), 
                            new CONST(frameHeaderSize)))));   
        epilogue.add(new JUMP(new TEMP(RA)));
        Stm prologueStm = prologue.isEmpty() ? new SEQ(null, null) : 
                         prologue.size() == 1 ? prologue.get(0) :
                         new SEQ(prologue.get(0), new SEQ(prologue.get(1), null));      
        Stm epilogueStm = epilogue.isEmpty() ? new SEQ(null, null) :
                          epilogue.size() == 1 ? epilogue.get(0) :
                          new SEQ(epilogue.get(0), new SEQ(epilogue.get(1), null));
        
        return new SEQ(prologueStm, new SEQ(body, epilogueStm));
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