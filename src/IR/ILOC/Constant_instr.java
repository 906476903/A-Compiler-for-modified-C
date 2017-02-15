package IR.ILOC;

/**
 * Created by xsc on 2016/5/1.
 */
public class Constant_instr extends Instru{
    public String s;
    public boolean _func;
    public boolean _reg_;
    public String s1;
    public Reg _reg;
    public int pp = 0;
    public Constant_instr(String ss){
        s = ss.intern();
        _func = false;
        _reg_ = false;
        pp = 0;
    }
    public Constant_instr(String ss,String sss){
        s = ss.intern();
        s1 = sss.intern();
        _func = true;
        _reg_ = false;
        pp = 0;
    }
    public Constant_instr(String ss,Reg tmp){
        s = ss.intern();
        _func = false;
        _reg_ = true;
        _reg = tmp;
        pp = 0;
    }
    public Constant_instr(String ss,Reg tmp,String tmp1){
        s = ss.intern();
        _reg = tmp;
        s1 = tmp1.intern();
        _reg_ = false;
        _func = false;
        pp = 1;
    }
}
