package AST.VarType;

import IR.ILOC.Reg;

import java.util.Vector;

/**
 * Created by xsc on 2016/3/31.
 */
public class Array_type {
    public Object Type;
    public int dim;
    public Reg pl;
    //Vector<Array_type> content;

    public Array_type(){};

    public Array_type(Object typ,int dim1){
        Type = typ;dim = dim1;
    };

    public Array_type(Object typ,int dim1,Reg tmp){
        Type = typ;dim = dim1;pl = tmp;
    };


    public static Object Use_arr(Array_type p,int dim_use){
        if(p.dim - dim_use > 0){
            Array_type s = new Array_type(p.Type,p.dim - dim_use);
            return s;
        }
        else if(p.dim == dim_use){
            return p.Type;
        }
        else{
            return null;
        }

    }

    public static boolean Arr_match(boolean lv,Array_type p,Array_type p1){
        if(lv){
            if(p.Type instanceof Integer_type){
                //System.out.print("=====");
                if(!((Integer_type)p.Type).is_lvalue) return false;
            }
            else if(p.Type instanceof Bool_type){
                if(!((Bool_type)p.Type).is_lvalue) return false;
            }
            else if(p.Type instanceof String_type){
                if(!((String_type)p.Type).is_lvalue) return false;
            }
            else if(p.Type instanceof Class_type){
                if(!((Class_type)p.Type).is_lvalue) return false;
            }
        }
        if(p1.dim == p.dim && Type_check.match_type("arr_intern",p.Type,p1.Type,0)) return true;
        return false;
    }

}
