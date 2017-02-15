package AST.AST_VISIT;

import AST.VarType.*;
import Error_handle.Error_msg;

import java.util.*;


@SuppressWarnings( "unchecked ")
public class Table{
    LinkedList< HashMap<String,Object> > env;

    public Table(){
        env = new LinkedList< HashMap<String,Object> >();
        env.addFirst( new HashMap<String,Object>() );
        insert("int","int",0);
        insert("bool","bool",0);
        insert("void","void",0);
        insert("string","string",0);


        LinkedList<Para_type> p1 = new LinkedList<Para_type>();
        Object p0 = Trans_type.transform(false,"string",0,0);
        p1.addFirst(new Para_type("str",p0));
        Function_type s1 = new Function_type(new Void_type(),p1);

        LinkedList<Para_type> p2 = new LinkedList<Para_type>();
        Object p11 = Trans_type.transform(false,"string",0,0);
        p2.addFirst(new Para_type("str",p11));
        Function_type s2 = new Function_type(new Void_type(),p2);

        LinkedList<Para_type> p3 = new LinkedList<Para_type>();
        Function_type s3 = new Function_type(new String_type(false),p3);


        LinkedList<Para_type> p4 = new LinkedList<Para_type>();
        Function_type s4 = new Function_type(new Integer_type(false),p4);


        LinkedList<Para_type> p5 = new LinkedList<Para_type>();
        Object p111 = Trans_type.transform(false,"int",0,0);
        p5.addFirst(new Para_type("j",p111));
        Function_type s5 = new Function_type(new String_type(false),p5);
        //System.out.println(s5.Return_type.getClass().getSimpleName());
        insert("print",s1,0);
        insert("println",s2,0);
        insert("getString",s3,0);
        insert("getInt",s4,0);
        insert("toString",s5,0);

    }

    public void add_depth(){
        //tem.out.println("Enter a block!");
        env.addFirst( new HashMap<String,Object>() );
    }

    public void dec_depth(){
        //System.out.println("exit a block!");
        env.removeFirst();
    }

    public void insert(String ss,Object l,int line_num){
        String s = ss.intern();
        HashMap<String,Object> m = env.getFirst();
        if(m.containsKey(s)) {
            Error_msg Err = new Error_msg();
            Err.complain("Line: "+line_num+' '+"the variable has been defined.");
        }
        else{
            //System.out.println("show_var "+s);
            m.put(s,l);
        }

    }

    public Object lookup(String ss){
        String s =ss.intern();
        Object ans = null;
        Iterator<HashMap<String,Object> > iterator=env.iterator();
        HashMap<String,Object> m;

        while(iterator.hasNext()){
            m = iterator.next();
            if(m.containsKey(s)){
                ans = m.get(s);
                break;
            }
        }

        return ans;

    }


}