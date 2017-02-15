package AST.VarType;

/**
 * Created by xsc on 2016/4/2.
 */
public class Constant_construct {
    public static Object constant_make(String ss,Object p){
        String s = ss.intern();
        if(s == "null"){
            return new Null_type();
        }
        else if(s == "int"){
            return new Integer_type(false);
        }
        else if(s == "bool"){
            return new Bool_type(false);
        }
        else if(s == "string"){
            return new String_type(false);
        }
        return null;
    }
}
