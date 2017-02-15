package AST.AST_VISIT; /**
 * Created by xsc on 2016/3/30.
 */

import java.util.*;

import AST.VarType.Class_type;
import Error_handle.Error_msg;

public class Class_table {
    public HashMap<String,Class_type> env;

    public Class_table(){
        env = new HashMap<String,Class_type>();
    }

    public void insert(String ss,HashMap<String,Object> l,int line_num){
        String s = ss.intern();
        if(env.containsKey(s)){
            Error_msg Err = new Error_msg();
            Err.complain("Line: "+line_num+' '+"this class has existed.");
        }
        else{

            /*show
            System.out.println("show class" + " " + s);
            for (Map.Entry<String,Object> entry : l.entrySet()) {
                System.out.println(entry.getKey());
            }
            System.out.println("show end");
*/
            env.put(s, new Class_type(s,l,true));
        }
    }

    public void insert(String ss,Class_type l){
        String s = ss.intern();
        env.put(s, l);

    }

    public boolean contains(String ss){
        Set<String> Class_set = visit_zero.Class_set;
        String s = ss.intern();
        return (Class_set.contains(s));
    }

    public Class_type lookup(String ss){//
        String s = ss.intern();
        return (env.get(s));
    }

}
