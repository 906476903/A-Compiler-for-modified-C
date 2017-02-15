package IR.ILOC;

/**
 * Created by xsc on 2016/4/28.
 */
public class Instruction extends Instru{
    public String s;
    public Reg r1,r2,r3;
    public Nop_ins s1,s2;

    public Instruction(String ss,Reg l1,Reg l2,Reg l3){
        s = ss.intern();
        r1 = l1;r2 = l2;r3 = l3;
    }

    public Instruction(int q,String ss,Reg l0,Instru l1,Instru l2){
        s = ss.intern();
        r1 = l0;
        s1 = (Nop_ins) l1;
        s2 = (Nop_ins) l2;
    }
}
