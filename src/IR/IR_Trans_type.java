package IR;

import AST.AST_VISIT.visit_zero;
import AST.VarType.*;
import Error_handle.Error_msg;
import IR.ILOC.IR_trans_node;
import IR.ILOC.Reg;

/**
 * Created by xsc on 2016/3/31.
 */
public class IR_Trans_type {


    public static IR_trans_node transform(boolean gl,String ss, int dim){
        String s = ss.intern();
        //
        if(dim == 0){
            if(s=="void"){
                return new IR_trans_node(new Void_type(),null);
            }
            if(s == "int"){
                Reg tmp = Reg.NextRes("int");
                tmp.global = gl;
                if(gl) tmp.gl_var = Create_liner_IR.cur_var;
                return new IR_trans_node(new Integer_type(tmp),tmp);
            }
            else if(s == "string"){
                Reg tmp = Reg.NextRes("string");
                tmp.global = gl;
                if(gl) tmp.gl_var = Create_liner_IR.cur_var;
                return new IR_trans_node(new String_type(tmp),tmp);
            }
            else if(s == "bool"){
                Reg tmp = Reg.NextRes("bool");
                tmp.global = gl;
                if(gl) tmp.gl_var = Create_liner_IR.cur_var;
                return new IR_trans_node(new Bool_type(tmp),tmp);
            }
            else if(visit_zero.class_table.contains(s)){
                Class_type v = visit_zero.class_table.lookup(s);
                //System.out.println(v.);
                Class_type vv = Class_type.Reg_clone(v);
                //System.out.println("++++++++");
                vv.pl.global = gl;
                if(gl) vv.pl.gl_var = Create_liner_IR.cur_var;
                return new IR_trans_node(vv,vv.pl);
            }

        }
        else{
            Reg tmp = Reg.NextRes("array");
            Object Type1;

            if(s == "int"){
                Type1 = new Integer_type(false);
            }
            else if(s == "bool"){
                Type1 = new Bool_type(false);
            }
            else if(visit_zero.class_table.contains(s)){
                Class_type v = visit_zero.class_table.lookup(s);
                Type1 = v;
            }
            else{
                Type1 = new String_type(false);
            }
            tmp.global = gl;
            if(gl) tmp.gl_var = Create_liner_IR.cur_var;
            return new IR_trans_node(new Array_type(Type1,dim,tmp),tmp);

        }

        return null;
    }


}
