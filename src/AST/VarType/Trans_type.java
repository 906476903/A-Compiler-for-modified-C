package AST.VarType;

import AST.AST_VISIT.visit_zero;
import Error_handle.Error_msg;

/**
 * Created by xsc on 2016/3/31.
 */
public class Trans_type {
    public static Object transform(boolean is_func, String ss, int dim, int line_num) {
        return transform(is_func,ss ,dim ,line_num ,true );
    }

    public static Object transform(boolean is_func, String ss, int dim, int line_num, boolean func_lv){
        String s = ss.intern();

        if(dim == 0){
            if(is_func && s=="void"){
                return new Void_type();
            }
            if(s == "int"){
                return new Integer_type(func_lv);
            }
            else if(s == "string"){
                return new String_type(func_lv);
            }
            else if(s == "bool"){
                return new Bool_type(func_lv);
            }
            else if(visit_zero.class_table.contains(s)){
                Class_type v = visit_zero.class_table.lookup(s);
                if(!func_lv) v.is_lvalue = func_lv;
                return v;
            }
            else{
                    Error_msg Err = new Error_msg();
                    Err.complain("Line: "+line_num+' '+"this type hasn't defined.");
            }
        }
        else{
            if(s == "int"){
                return new Array_type(new Integer_type(func_lv),dim);
            }
            else if(s == "string"){
                return new Array_type(new String_type(func_lv),dim);
            }
            else if(s == "bool"){
                return new Array_type(new Bool_type(func_lv),dim);
            }
            else if(visit_zero.class_table.contains(s)){
                Class_type v = visit_zero.class_table.lookup(s);
                if(!func_lv) v.is_lvalue = func_lv;
                return new Array_type(v,dim);
            }
            else{
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+line_num+' '+"this type hasn't defined.");
            }
        }

        return null;
    }

    public static Object create_lvalue_type(boolean lvalue,Object s){//s lvalue?
        if(s instanceof Integer_type){
            return new Integer_type(lvalue);
        }
        else if(s instanceof Bool_type){
            return new Bool_type(lvalue);
        }
        else if(s instanceof String_type){
            return new String_type(lvalue);
        }
        else if(s instanceof Class_type){
            Class_type tmp = Class_type.clone((Class_type)s);
            tmp.is_lvalue = lvalue;
            return tmp;
        }

        return s;
    }
}
