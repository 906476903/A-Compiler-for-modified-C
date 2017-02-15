package AST.VarType;

import IR.ILOC.Reg;

/**
 * Created by xsc on 2016/3/31.
 */
public class Bool_type {
    public boolean bool;
    public boolean is_lvalue;
    public Reg pl;
    public Bool_type(){}
    public Bool_type(boolean s){is_lvalue = s;}
    public Bool_type(Reg tmp){pl = tmp;}
}
