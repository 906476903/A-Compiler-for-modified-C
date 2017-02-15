package AST.VarType;

import IR.ILOC.Reg;

/**
 * Created by xsc on 2016/4/3.
 */
public class Para_type {
    public String key;
    public Object Type;
    public Reg _reg;

    public Para_type(String p1, Object p2){
        key = p1.intern();
        Type = p2;

        if(p2 instanceof Integer_type){
            _reg = Reg.NextRes("int");
            ((Integer_type)p2).pl = _reg;
        }
        else if(p2 instanceof Bool_type){
            _reg = Reg.NextRes("bool");
            ((Bool_type)p2).pl = _reg;
        }
        else if(p2 instanceof String_type){
            _reg = Reg.NextRes("string");
            ((String_type)p2).pl = _reg;
        }
        else if(p2 instanceof Class_type){
            _reg = Reg.NextRes("class");
            ((Class_type)p2).pl = _reg;
        }
        else if(p2 instanceof Array_type) {
            _reg = Reg.NextRes("array");
            ((Array_type)p2).pl = _reg;
        }
    }
}
