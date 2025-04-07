package Absyn;
import java.util.ArrayList;

import Symbol.Symbol;
public class Bitfield extends Decl{

    public boolean isConst=false;
    public boolean isExtern=false;
    public boolean isVolatile=false;
    public boolean isStatic=false;
    public boolean isAuto=false;
    public boolean isRegister=false;

    public final static int CONST=0, EXTERN=1, VOLATILE=2, STATIC=3, AUTO=4, REGISTER=5;

    public void update(int code){
        if (code==Bitfield.CONST) {
            this.isConst=true;
        } else if (code==Bitfield.EXTERN) {
            this.isExtern=true;
        } else if (code==Bitfield.VOLATILE) {
            this.isVolatile=true;
        } else if (code==Bitfield.STATIC) {
            this.isStatic=true;
        } else if (code==Bitfield.AUTO) {
            this.isAuto=true;
        } else if (code==Bitfield.STATIC) {
            this.isStatic=true;
        } else {
            //Error.. probably
        }

    }

}
