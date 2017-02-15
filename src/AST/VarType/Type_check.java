package AST.VarType;

import Error_handle.Error_msg;
import java.util.*;

/**
 * Created by xsc on 2016/4/1.
 */
public class Type_check {
    public static boolean match_type(String para,Object s1,Object s2,int line_num){
        String s = para.intern();

        if(s == "bool"){
            if((s1 instanceof Bool_type) && (s2 instanceof Bool_type)){
                return true;
            }
        }
        else if(s == "="){
            if((s1 instanceof Integer_type) && (((Integer_type)s1).is_lvalue) && (s2 instanceof Integer_type)){
                return true;
            }
            else if((s1 instanceof Bool_type) && (((Bool_type)s1).is_lvalue) && (s2 instanceof Bool_type)){
                return true;
            }
            else if((s1 instanceof Class_type) && (((Class_type)s1).is_lvalue)){
                if(s2 instanceof Null_type) return true;
                else if(s2 instanceof Class_type){
                    Class_type l = (Class_type)s1;
                    Class_type r = (Class_type)s2;
                    if(l.name.intern() == r.name.intern()) return true;
                }
            }
            else if((s1 instanceof String_type) && (((String_type)s1).is_lvalue) && (s2 instanceof String_type)){
                return true;
            }
            else if((s1 instanceof Array_type) && (s2 instanceof Array_type)){
                if(Array_type.Arr_match(true,(Array_type)s1,(Array_type)s2))
                {
                    //System.out.print("grwsagas");
                    return true;
                }
            }
            else if((s1 instanceof Array_type) && (s2 instanceof Null_type)){
                return true;
            }

        }
        else if(s == "int"){
            if((s1 instanceof Integer_type) && (s2 instanceof Integer_type)){
                return true;
            }
        }
        else if(s == "=="){
            if((s1 instanceof Integer_type) && (s2 instanceof Integer_type)){
                return true;
            }
            else if((s1 instanceof Bool_type) && (s2 instanceof Bool_type)){
                return true;
            }
            else if((s1 instanceof String_type) && (s2 instanceof String_type)){
                return true;
            }
            else if((s1 instanceof Class_type)){

                    if(s2 instanceof Null_type) return true;
                }

        }
        else if(s == "<"){
            if((s1 instanceof Integer_type) && (s2 instanceof Integer_type)){
                return true;
            }
            else if((s1 instanceof String_type) && (s2 instanceof String_type)){
                return true;
            }
        }
        else if(s == "func"){
            if(s1 instanceof Function_type){
                if( (((Function_type)s1).Return_type instanceof Integer_type) && (s2 instanceof Integer_type)) return true;
                if( (((Function_type)s1).Return_type instanceof Class_type) && (s2 instanceof Class_type)) return true;
                if( (((Function_type)s1).Return_type instanceof Bool_type) && (s2 instanceof Bool_type)) return true;
                if( (((Function_type)s1).Return_type instanceof String_type) && (s2 instanceof String_type)) return true;

                if( (((Function_type)s1).Return_type instanceof Array_type) && (s2 instanceof Array_type)){
                    if(Array_type.Arr_match(false,(Array_type)(((Function_type)s1).Return_type),(Array_type)s2)) return true;
                }
            }
        }
        else if(s == "+"){
            if((s1 instanceof String_type) && (s2 instanceof String_type)){
                return true;
            }
            else if((s1 instanceof Integer_type) && (s2 instanceof Integer_type)){
                return true;
            }
        }
        else if(s == "xor"){
            if((s1 instanceof Bool_type) && (s2 instanceof Bool_type)){
                return true;
            }
            else if((s1 instanceof Integer_type) && (s2 instanceof Integer_type)){
                return true;
            }
        }
        else if(s == "arr_intern"){
            if((s1 instanceof Integer_type) && (s2 instanceof Integer_type)){
                return true;
            }
            else if((s1 instanceof Bool_type) && (s2 instanceof Bool_type)){
                return true;
            }
            else if((s1 instanceof String_type) && (s2 instanceof String_type)){
                return true;
            }
            else if((s1 instanceof Class_type) && (s2 instanceof Class_type)){
                if(((Class_type)s1).name == ((Class_type)s2).name) return true;
            }
        }
        else if(s == "new")
        {
            if(s2 instanceof Class_type){
                return true;
            }
            Error_msg Err = new Error_msg();
            Err.complain("Line: "+line_num+' '+"You can't call this.");
            return false;
        }
            Error_msg Err = new Error_msg();
            Err.complain("Line: "+line_num+' '+"Type does not match.");
        return false;
    }
//bool = int == < func +

}
