package AST.VarType;

import IR.ILOC.Reg;

/**
 * Created by xsc on 2016/3/31.
 */
public class Integer_type {
    int val;
    public boolean is_lvalue;
    public Reg pl;
    public Integer_type(){}
    public Integer_type(boolean s){is_lvalue = s;}
    public Integer_type(Reg tmp){pl = tmp;}
}
