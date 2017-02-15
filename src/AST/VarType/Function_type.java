package AST.VarType;

import Error_handle.Error_msg;
import IR.ILOC.Reg;

import java.util.Iterator;
import java.util.LinkedList;

/**
 * Created by xsc on 2016/3/31.
 */
public class Function_type {
    public Object Return_type;
    public LinkedList<Para_type> param;

    public Function_type(Object s, LinkedList<Para_type> ss)
    {
        Return_type = s;
        param = ss;
    }
    Object p0,p1;

    public void fit_para(LinkedList p,int line_num){
        Iterator k0 = p.listIterator();
        Iterator k1 = param.listIterator();
        while(k0.hasNext() && k1.hasNext()){
            p0 = k0.next();

            p1 = ((Para_type)k1.next()).Type;

            //System.out.println(p1.getClass().getSimpleName());
            if(!type_fit(p0,p1)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+line_num+' '+"para not fit.");
            }
        }
        if(p.size() != param.size()){
            Error_msg Err = new Error_msg();
            Err.complain("Line: "+line_num+' '+"para not fit.");
        }
    }

    boolean type_fit(Object p1,Object p2){
        if((p1 instanceof Integer_type) && (p2 instanceof Integer_type)){
            return true;
        }
        else if((p1 instanceof Bool_type) && (p2 instanceof Bool_type)){
            return true;
        }
        else if((p1 instanceof String_type) && (p2 instanceof String_type)){
            return true;
        }
        else if((p1 instanceof Class_type) && (p2 instanceof Class_type)){
            return true;
        }
        else if((p1 instanceof Array_type) && (p2 instanceof Array_type) ){
            if(Array_type.Arr_match(false,(Array_type)p1,(Array_type)p2)) return true;
        }
        return false;
    }
}
