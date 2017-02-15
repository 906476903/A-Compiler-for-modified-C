package AST.VarType;


import AST.AST_VISIT.Class_table;
import AST.AST_VISIT.visit_zero;
import IR.ILOC.Reg;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xsc on 2016/3/31.
 */
public class Class_type {


    public HashMap<String,Object> mem;
    public HashMap<String,Integer> place;
    public boolean is_lvalue;
    public String name;
    public Reg pl;
    public int _size;
    public void Count(){
        _size = 0;
        place = new HashMap<String,Integer>();
        for (Map.Entry<String,Object> entry : mem.entrySet()) {
            /*if(entry.getValue() instanceof Integer_type) _size+=4;
            else if(entry.getValue() instanceof Bool_type) _size+=4;
            else if(entry.getValue() instanceof String_type) _size+=4;
            else if(entry.getValue() instanceof Class_type) _size+=4;
            else if(entry.getValue() instanceof Array_type) _size+=4;*/

            place.put(entry.getKey(),_size);
            _size+=4;
        }

    }

    public Class_type(){}

    public Class_type(String ss,HashMap<String,Object> s,boolean func_lv){
        is_lvalue = func_lv;
        name = ss.intern();
        mem = s;
        if(mem.size() != 0 ) Count();
    }

    public Object Class_asses(String pp){
        String p = pp.intern();
        if(!mem.containsKey(p)) return null;
        if(mem.get(p) == null){
            Class_table class_table = visit_zero.class_table;
            System.out.println(p);
            return class_table.lookup(p);
        }
        return mem.get(p);
    }

    public static Class_type clone(Class_type p){
        Class_type tmp = new Class_type(p.name,p.mem,true);
        return tmp;
    }

    public static Class_type Reg_clone(Class_type p){
        //System.out.print(p._size);
        Class_type tmp = new Class_type(p.name,p.mem,true);
        tmp.pl = Reg.NextRes("class");

        return tmp;
    }
}
