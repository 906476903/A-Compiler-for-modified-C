package AST.VarType;

import IR.ILOC.Reg;

/**
 * Created by xsc on 2016/3/31.
 */
public class String_type {
    public String s;
    public boolean is_lvalue;
    public Reg pl;

    public String_type(){}

    public String_type(boolean s){is_lvalue = s;}
    public String_type(Reg tmp){pl = tmp;}
}
