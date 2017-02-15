package IR.ILOC;

import IR.Create_liner_IR;
import IR.IRList;

import java.util.HashMap;

/**
 * Created by xsc on 2016/4/13.
 */
public class Reg extends Ins_expr{
    public int addr;
    public String type;
    public boolean imm, global = false;
    public String gl_var;
    public int imm_num;
    public int addr_num = 0;
    public static int addr_num_total = 0;
    public static int cur_addr = 0;
    public boolean is_tmp_reg = false;
    public int tmp_reg;
    public static boolean[] a = new boolean[10];
    public static HashMap<Integer,Reg> assign_reg = new HashMap<>();
    Reg(){}

    public static Reg NextRes(String tmp){//
        Reg p = new Reg();
        p.addr_num = ++addr_num_total;
        p.type = tmp.intern();
        p.imm = false;
        p.addr = (addr_num_total - cur_addr)*4 ;
        p.is_tmp_reg = false;
        return p;
    }

    public static Reg NextimmRes(String tmp,int imm_p){
        Reg p = new Reg();
        p.type = tmp.intern();
        p.imm = true;
        p.imm_num = imm_p;
        p.is_tmp_reg = false;
        return p;
    }

    static int i = 0;
/*
    public static IRList TranstmpRes(Reg p){
        IRList ans = new IRList();
        if(p.is_tmp_reg) return ans;
        p.imm = false;
        p.is_tmp_reg = true;
        int k = 0;
        while (k<10)
        {
            ++k;
            i = (i+1)%10;
            if (a[i]) {
                p.tmp_reg = i;
                a[i] = false;
                assign_reg.put(i, p);
                break;
            }
            else if(k == 10){
                Reg l = assign_reg.get(i);
                ans.addLast(Create_liner_IR._save(l));
                assign_reg.remove(i);
                p.tmp_reg = i;
                assign_reg.put(i, p);
            }
        }
        return ans;
    }
*/
    public static IR_node NexttmpRes(String tmp){
        IRList ans = new IRList();
        Reg p = new Reg();
        p.type = tmp.intern();
        p.imm = false;
        p.is_tmp_reg = true;
        int k = 0;
        while (k<10)
        {
            ++k;
            i = (i+1)%10;
            if (a[i]) {
                p.tmp_reg = i;
                a[i] = false;
                assign_reg.put(i, p);
                break;
            }
            else if(k == 10){
                Reg l = assign_reg.get(i);
                ans.addLast(Create_liner_IR._save(l));
                assign_reg.remove(i);
                p.tmp_reg = i;
                assign_reg.put(i, p);
            }
        }
        p.addr_num = ++addr_num_total;
        p.addr = (addr_num_total - cur_addr)*4 ;
        return new IR_node(ans,p);
    }

    public static void Release(Reg s){
        if(!s.is_tmp_reg) return;
        a[s.tmp_reg] = true;
        assign_reg.remove(s.tmp_reg);
    }

    public String toReg(){
        if(tmp_reg == 0) return "$t3";
        if(tmp_reg == 1) return "$t4";
        if(tmp_reg == 2) return "$t5";
        if(tmp_reg == 3) return "$t6";
        if(tmp_reg == 4) return "$t7";
        if(tmp_reg == 5) return "$s2";
        if(tmp_reg == 6) return "$s3";
        if(tmp_reg == 7) return "$s4";
        if(tmp_reg == 8) return "$s5";
        if(tmp_reg == 9) return "$s6";
        return "$s7";
    }
    public static Reg String_reg(String ss){
        return NextRes("string");
    }

    public String addrl(){
        if(global) {
            return gl_var+"_";
        }
        else return String.valueOf(addr)+"($sp)";
    }
}
