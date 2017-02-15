package IR;

import AST.VarType.*;
import Error_handle.Error_msg;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;


@SuppressWarnings( "unchecked ")
public class IR_sy_table {
    LinkedList< HashMap<String,Object> > env;

    public IR_sy_table(){
        env = new LinkedList< HashMap<String,Object> >();
        env.addFirst( new HashMap<String,Object>() );
        insert("int","int");
        insert("bool","bool");
        insert("void","void");
        insert("string","string");


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
        insert("print",s1);
        insert("println",s2);
        insert("getString",s3);
        insert("getInt",s4);
        insert("toString",s5);

    }

    public void add_depth(){
        //tem.out.println("Enter a block!");
        env.addFirst( new HashMap<String,Object>() );
    }

    public void dec_depth(){
        //System.out.println("exit a block!");
        env.removeFirst();
    }

    public void insert(String ss,Object l){
        String s = ss.intern();
        HashMap<String,Object> m = env.getFirst();
        m.put(s,l);

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