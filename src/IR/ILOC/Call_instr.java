package IR.ILOC;

import IR.ILOC.Instru;

import java.util.LinkedList;

/**
 * Created by xsc on 2016/4/28.
 */
public class Call_instr extends Instru{

    public String s;
    public LinkedList<Reg> para;
    public Reg re;

    public Call_instr(String ss, LinkedList<Reg> p, Reg l){
        s = ss.intern();
        para = p;
        re = l;
    }
}
