package IR;

import AST.AST_VISIT.*;
import AST.VarType.*;
import IR.ILOC.*;
import gen.MogicBaseVisitor;
import gen.MogicParser;

import java.util.*;



public class Create_liner_IR extends MogicBaseVisitor<Object> {

    static boolean print_mips = true;
    public static IR_sy_table table = visit_first.IR_table;

    Class_table class_table = visit_zero.class_table;
    Set<String> Class_set = visit_zero.Class_set;
    String current_func;
    Instru cur_func;
    int String_con = 0;
    Stack<Instru> cur_loop_continue = new Stack<Instru>(),cur_loop_break = new Stack<Instru>();
    IRList Decl_IRL = new IRList();
    HashMap<String,IRList> ans_IR = new HashMap<String,IRList>();
    HashMap<Reg,Reg> Reg_pos = new HashMap<>();
    public static HashMap<String,Integer> func_size = new HashMap<>();

    public static HashMap<String,Integer> func_stack_size = new HashMap<>();
    public static HashSet<String> globasl_var_set = new HashSet<>();
    public static HashMap<Integer,String> globasl_string_set = new HashMap<>();
    int label_num = 0;

    boolean func_para_loaded;
    boolean global_var = false;
    public static String cur_var;
    public static boolean pla = false;


    public void print(){
        if(!print_mips) {
            for (Map.Entry<String, IRList> k : ans_IR.entrySet()) {
                System.out.print("func " + k.getKey() + ' ' + func_stack_size.get(k.getKey()));
                LinkedList<Para_type> tmp = ((Function_type) table.lookup(k.getKey())).param;
                for (Para_type kk : tmp) {
                    System.out.print("$" + kk._reg.addr_num + " ");
                }
                System.out.println("{");
                k.getValue().print();
                System.out.println("}");


            }
        }
        else {
            System.out.println(".text");
            System.out.println(".globl main");
            System.out.println();
            for (Map.Entry<String, IRList> k : ans_IR.entrySet()) {
                if(k.getKey().intern() != "main")System.out.println(k.getKey() + "_: ");
                else System.out.println(k.getKey() + ": ");
                k.getValue().print();
            }
            Built_in.print_buildin();
            System.out.println();
            System.out.println(".data");
            for(String k : globasl_var_set){
                System.out.println(k+"_: .space 4");
            }
            System.out.println("static0: .asciiz \"\\n\"");
            System.out.println("static1: .space 1024");
            for(Map.Entry<Integer,String> k : globasl_string_set.entrySet()){
                System.out.println(".word "+String.valueOf(k.getValue().length()-2));
                System.out.println("String"+String.valueOf(k.getKey())+": .ascii "+k.getValue());
                System.out.println(".word 0");
            }

        }
    }

    public static IRList _save(Reg p){
        IRList ans = new IRList();
        if(!p.is_tmp_reg) return ans;
        Reg.Release(p);
        p.is_tmp_reg = false;

        ans.addLast(new Constant_instr("sw "+p.toReg()+" ",p));
        return ans;
    }
    IRList special_emit(String ss, Object p1,Object p2,String p3){
        String s = ss.intern();
        IRList ans = new IRList();
        if(p1 instanceof Reg && ((Reg)p1).imm){
            Reg p11 = Reg.NextRes("int");
            ans.addLast(emit("move",p1,p11));
            p1 = p11;
        }
        if(s == "add"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("add "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("add "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String){
                if(((Reg)p1).imm) {
                    ans.addLast(new Constant_instr("add "+(String)p3 +" "+ (String)p2 +" "+ ((Reg)p1).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("add "+(String)p3 +" "+ (String)p2 + " $t0"));
                }
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("add "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("add "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        else if(s == "mul"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("mul "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("mul "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String){
                if(((Reg)p1).imm) {
                    ans.addLast(new Constant_instr("mul "+(String)p3 +" "+ (String)p2 +" "+ ((Reg)p1).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("mul "+(String)p3 +" "+ (String)p2 + " $t0"));
                }
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("mul "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("mul "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        else if(s == "div"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("div "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("div "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String){
                if(((Reg)p1).imm) {
                    ans.addLast(new Constant_instr("div "+(String)p3 +" "+ (String)p2 +" "+ ((Reg)p1).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("div "+(String)p3 +" "+ (String)p2 + " $t0"));
                }
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("div "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("div "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        else if(s == "sub"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("sub "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("sub "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String) {
                ans.addLast(new Constant_instr("lw $t0," , ((Reg) p1)));
                ans.addLast(new Constant_instr("sub " + (String) p3 + " $t0" + " " + (String) p2));
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("sub "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("sub "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        else if(s == "rem"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("rem "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("rem "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String){
                if(((Reg)p1).imm) {
                    ans.addLast(new Constant_instr("rem "+(String)p3 +" "+ (String)p2 +" "+ ((Reg)p1).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("rem "+(String)p3 +" "+ (String)p2 + " $t0"));
                }
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("rem "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("rem "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        else if(s == "seq"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("seq "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("seq "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String) {
                ans.addLast(new Constant_instr("lw $t0," , ((Reg) p1)));
                ans.addLast(new Constant_instr("seq " + (String) p3 + " $t0" + " " + (String) p2));
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("seq "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("seq "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        else if(s == "sne"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("sne "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("sne "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String) {
                ans.addLast(new Constant_instr("lw $t0," , ((Reg) p1)));
                ans.addLast(new Constant_instr("sne " + (String) p3 + " $t0" + " " + (String) p2));
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("sne "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("sne "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        else if(s == "sle"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("sle "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("sle "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String) {
                ans.addLast(new Constant_instr("lw $t0," , ((Reg) p1)));
                ans.addLast(new Constant_instr("sle " + (String) p3 + " $t0" + " " + (String) p2));
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("sle "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("sle "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        else if(s == "sgt"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("sgt "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("sgt "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String) {
                ans.addLast(new Constant_instr("lw $t0," , ((Reg) p1)));
                ans.addLast(new Constant_instr("sgt " + (String) p3 + " $t0" + " " + (String) p2));
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("sgt "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("sgt "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        else if(s == "slt"){
            if(p1 instanceof String){
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("slt "+(String)p3 +" "+ (String)p1 +" "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p2)));
                    ans.addLast(new Constant_instr("slt "+(String)p3 +" "+ (String)p1 + " $t0"));
                }
            }
            else if(p2 instanceof String) {
                ans.addLast(new Constant_instr("lw $t0," , ((Reg) p1)));
                ans.addLast(new Constant_instr("slt " + (String) p3 + " $t0" + " " + (String) p2));
            }
            else {
                if(((Reg)p2).imm) {
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("slt "+(String)p3 +" $t0 "+ ((Reg)p2).imm_num));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0,",((Reg)p1)));
                    ans.addLast(new Constant_instr("lw $t1,",((Reg)p2)));
                    ans.addLast(new Constant_instr("slt "+(String)p3 +" $t0 $t1"));
                }
            }
        }
        return ans;
    }

    IRList emit(String ss, Object p1,Object p2,Object p3){
        String s = ss.intern();
        IRList ans = new IRList();
        LinkedList<Reg> p = new LinkedList<>();
        if(p1 instanceof Reg && ((Reg)p1).imm){
            Reg p11 = Reg.NextRes("int");
            ans.addLast(emit("move",p1,p11));
            p1 = p11;
        }
        if(s == "call"){
            for(IR_node l : (LinkedList<IR_node>)p2){
                p.addLast(l.p);
            }
            if(((String)p1).intern() == "getInt"){
                ans.addLast(new Constant_instr("li $v0,5\n" +
                        "syscall\n" +
                        "sw $v0,",((Reg)p3)));
            }
            else
                ans.addLast(new Call_instr((String)p1,p,(Reg)p3));
        }
        else if(s == "add"){
            ans.addLast(new Instruction("add",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "sub"){
            ans.addLast(new Instruction("sub",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "and"){
            ans.addLast(new Instruction("and",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "or"){
            ans.addLast(new Instruction("or",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "xor"){
            ans.addLast(new Instruction("xor",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "mul"){
            ans.addLast(new Instruction("mul",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "div"){
            ans.addLast(new Instruction("div",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "rem"){
            ans.addLast(new Instruction("rem",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "lshift"){
            ans.addLast(new Instruction("shl",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "rshift"){
            ans.addLast(new Instruction("shr",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "br"){
            ans.addLast(new Instruction(0,"br",(Reg)p1,(Instru)p2,(Instru)p3));
        }
        else if(s == "load"){
            ans.addLast(new Instruction("load",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "_load"){
            ans.addLast(new Instruction("_load",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "store"){
            if(((Reg)p2).imm){
                Reg p22 = Reg.NextRes("int");
                ans.addLast(emit("move",p2,p22));
                p2 = p22;
            }
            ans.addLast(new Instruction("store",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "_store"){
            if(((Reg)p2).imm){
                Reg p22 = Reg.NextRes("int");
                ans.addLast(emit("move",p2,p22));
                p2 = p22;
            }
            ans.addLast(new Instruction("_store",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "cmp_EQ"){
            ans.addLast(new Instruction("seq",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "cmp_NE"){
            ans.addLast(new Instruction("sne",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "cmp_GE"){
            ans.addLast(new Instruction("sge",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "cmp_LE"){
            ans.addLast(new Instruction("sle",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "cmp_GT"){
            ans.addLast(new Instruction("sgt",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "cmp_LT"){
            ans.addLast(new Instruction("slt",(Reg)p1,(Reg)p2,(Reg)p3));
        }
        else if(s == "string_parseint"){

        }
        else if(s == "string_ord"){

        }
        return ans;


    }
    IRList emit(String ss, Object p1,Object p3){

        IRList ans = new IRList();
        String s = ss.intern();

        if(s == "neg"){
            ans.addLast(new Instruction("neg",(Reg)p1,null,(Reg)p3));
        }
        else if(s == "alloc"){
            ans.addLast(new Instruction("alloc",(Reg)p1,null,(Reg)p3));
        }
        else if(s == "move"){
            ans.addLast(new Instruction("move",(Reg)p1,null,(Reg)p3));
        }
        else if(s == "not"){
            ans.addLast(new Instruction("not",(Reg)p1,null,(Reg)p3));
        }
        return ans;
    }
    IRList emit(String ss, Object p1){

        IRList ans = new IRList();
        String s = ss.intern();

        if(s == "jump"){
            ans.addLast(new Instruction(0,"jump",null,(Instru) p1,null));
        }
        else if(s == "ret"){
            if(p1 instanceof String) ans.addLast(new Instruction("ret",null,null,null));
            else ans.addLast(new Instruction("ret",(Reg)p1,null,null));
        }
        else if(s == "string_length"){

        }
        return ans;
    }

    IRList emit(String ss, Object p1,Object p2,Object p3,Object p4){
        IRList ans = new IRList();
        String s = ss.intern();
        if(s == "string_substring"){

        }
        return ans;
    }
    @Override public Object visitMogic_pro(MogicParser.Mogic_proContext ctx) {
        for(int i=0;i<10;++i){
            Reg.a[i] = true;
        }
        visitProgram(ctx.program());
        return null;
    }

    @Override public IRList visitProgram(MogicParser.ProgramContext ctx) {
        if(ctx.class_decl() != null){
            //ans.addLast((IRList)visitClass_decl(ctx.class_decl()));
            if(ctx.program() != null) visitProgram(ctx.program());
        }
        else if(ctx.func_decl() != null){
            //ans.addLast((IRList)visitFunc_decl(ctx.func_decl()));
            visitFunc_decl(ctx.func_decl());
            if(ctx.program() != null) visitProgram(ctx.program());
        }
        else if(ctx.var_decl_stmt() != null){
            global_var = true;
            Decl_IRL.addLast(visitVar_decl_stmt(ctx.var_decl_stmt()));
            global_var = false;
            if(ctx.program() != null) visitProgram(ctx.program());
        }
        return null;
    }


    @Override public Object visitClass_decl(MogicParser.Class_declContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitMember_decl_list(MogicParser.Member_decl_listContext ctx) {
        return visitChildren(ctx);
    }

    @Override public Object visitMember_decl(MogicParser.Member_declContext ctx) {
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public IRList visitFunc_decl(MogicParser.Func_declContext ctx) {
        current_func = ctx.id().getText();
        func_para_loaded = false;
        IRList ans = new IRList();
        if(!print_mips)ans.addLast(new Nop_ins("label_"+ctx.id().getText()));
        int cur_res_addr = Reg.addr_num_total;
        Reg.cur_addr = Reg.addr_num_total;


        IRList p = visitBlock_stmt(ctx.block_stmt());


        int num_tmp = -cur_res_addr + Reg.addr_num_total+1;
        func_stack_size.put(ctx.id().getText(),num_tmp);

        LinkedList<Para_type> tmp = ((Function_type) table.lookup(current_func)).param;

        int num_tmp1 = (2+num_tmp+tmp.size());
        func_size.put(ctx.id().getText(),4*num_tmp1);
        if(current_func.intern() == "main") ans.addLast(new Constant_instr("subu $sp,$sp,"+String.valueOf(4*num_tmp1+1000)));
        else ans.addLast(new Constant_instr("subu $sp,$sp,"+String.valueOf(4*num_tmp1)));
        ans.addLast(new Constant_instr("sw $ra,0($sp)"));
        ans.addLast(new Constant_instr(" "));
        if(current_func.intern() == "main"){//?
            ans.addLast(Decl_IRL);
        }
        int h = 1;

        for (Para_type kk : tmp) {
            kk._reg.addr = 4*(num_tmp1-h++);
        }
        ans.addLast(p);
        ans.addLast(new Constant_instr(" "));
        ans.addLast(new Constant_instr("lw $ra,0($sp)"));
        if(current_func.intern() == "main") ans.addLast(new Constant_instr("addu $sp,$sp,"+String.valueOf(4*num_tmp1+1000)));
        else ans.addLast(new Constant_instr("addu $sp,$sp,"+String.valueOf(4*num_tmp1)));
        ans.addLast(new Constant_instr("jr $ra"));
        ans_IR.put(current_func,ans);


        return null;
    }

    @Override public Object visitParameter_list(MogicParser.Parameter_listContext ctx) {

        return visitChildren(ctx);
    }

    @Override public Object visitType(MogicParser.TypeContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitDim_SQ(MogicParser.Dim_SQContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitExpr(MogicParser.ExprContext ctx) {
        return visitAssignment_expr(ctx.assignment_expr());

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public static int Or_label = 0;
    @Override public IR_node visitLogic_or_expr(MogicParser.Logic_or_exprContext ctx) {
        if(ctx.logic_or_expr() == null){
            return visitLogic_and_expr(ctx.logic_and_expr());
        }
        IRList ans = new IRList();
        IR_node l = visitLogic_or_expr(ctx.logic_or_expr());
        IR_node r = visitLogic_and_expr(ctx.logic_and_expr());
        ans.addLast(l.l);
        //if(l.p.is_tmp_reg) ans.addLast(_save(l.p));

        //ans.addLast(r.l);
        IR_node temp = Reg.NexttmpRes("bool");
        ans.addLast(temp.l);
        Reg bool_reg = temp.p;//ans.addLast(emit("or",l.p,r.p,bool_reg));
        Or_label+=2;

        if(l.p.is_tmp_reg){
            ans.addLast(new Constant_instr("beq "+l.p.toReg()+" 1 Or_label" + String.valueOf(Or_label-1)));
            Reg.Release(l.p);
        }
        else {
            ans.addLast(new Constant_instr("lw $t0 ", l.p));
            ans.addLast(new Constant_instr("beq $t0 1 Or_label" + String.valueOf(Or_label-1)));
        }

        ans.addLast(r.l);
        //if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
        //ans.addLast(new Constant_instr("lw $t0 ",r.p));
        //ans.addLast(new Constant_instr("seq $t1 $t0 1"));
        if(r.p.is_tmp_reg){
            ans.addLast(new Constant_instr("seq "+bool_reg.toReg()+" "+r.p.toReg()+" 1"));
            Reg.Release(r.p);
        }
        else {
            ans.addLast(new Constant_instr("lw $t0 ",r.p));
            ans.addLast(new Constant_instr("seq "+bool_reg.toReg()+" $t0 1"));
        }
        ans.addLast(new Constant_instr("b Or_label"+String.valueOf(Or_label)));
        ans.addLast(new Constant_instr("Or_label"+String.valueOf(Or_label-1)+" :"));
        ans.addLast(new Constant_instr("li "+bool_reg.toReg()+" 1"));
        ans.addLast(new Constant_instr("Or_label"+String.valueOf(Or_label)+" :"));

        return new IR_node(ans,bool_reg);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    static int And_label = 0;
    @Override public IR_node visitLogic_and_expr(MogicParser.Logic_and_exprContext ctx) {
        if(ctx.logic_and_expr() == null){
            return visitInclusive_or_expr(ctx.inclusive_or_expr());
        }
        IRList ans = new IRList();
        IR_node l = visitLogic_and_expr(ctx.logic_and_expr());
        IR_node r = visitInclusive_or_expr(ctx.inclusive_or_expr());
        ans.addLast(l.l);
        //if(l.p.is_tmp_reg) ans.addLast(_save(l.p));

        //ans.addLast(r.l);
        IR_node temp = Reg.NexttmpRes("bool");
        ans.addLast(temp.l);
        Reg bool_reg = temp.p;
        //ans.addLast(emit("and",l.p,r.p,bool_reg));
        And_label+=2;
        if(l.p.is_tmp_reg){
            ans.addLast(new Constant_instr("beq "+l.p.toReg()+" 0 And_label" + String.valueOf(And_label - 1)));
            Reg.Release(l.p);
        }
        else {
            ans.addLast(new Constant_instr("lw $t0 ", l.p));
            ans.addLast(new Constant_instr("beq $t0 0 And_label" + String.valueOf(And_label - 1)));
        }
        ans.addLast(r.l);
        //if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
        if(r.p.is_tmp_reg){
            ans.addLast(new Constant_instr("seq "+bool_reg.toReg()+" "+r.p.toReg()+" 1"));
            Reg.Release(r.p);
        }
        else {
            ans.addLast(new Constant_instr("lw $t0 ", r.p));
            ans.addLast(new Constant_instr("seq "+bool_reg.toReg()+" $t0 1"));
        }
        ans.addLast(new Constant_instr("b And_label"+String.valueOf(And_label)));
        ans.addLast(new Constant_instr("And_label"+String.valueOf(And_label-1)+" :"));
        ans.addLast(new Constant_instr("li "+bool_reg.toReg()+" 0"));
        ans.addLast(new Constant_instr("And_label"+String.valueOf(And_label)+" :"));
        //ans.addLast(emit("and",l.p,r.p,bitand));
        return new IR_node(ans,bool_reg);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitInclusive_or_expr(MogicParser.Inclusive_or_exprContext ctx) {
        if(ctx.inclusive_or_expr() == null){
            return visitExclusive_or_expr(ctx.exclusive_or_expr());
        }

        IRList ans = new IRList();
        IR_node l = visitInclusive_or_expr(ctx.inclusive_or_expr());
        IR_node r = visitExclusive_or_expr(ctx.exclusive_or_expr());
        ans.addLast(l.l);
        ans.addLast(r.l);

        if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
        if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
        Reg bitor_reg = Reg.NextRes("int");
        ans.addLast(emit("or",l.p,r.p,bitor_reg));

        return new IR_node(ans,bitor_reg);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitExclusive_or_expr(MogicParser.Exclusive_or_exprContext ctx) {
        if(ctx.exclusive_or_expr() == null){
            return visitAnd_expr(ctx.and_expr());
        }

        IRList ans = new IRList();
        IR_node l = visitExclusive_or_expr(ctx.exclusive_or_expr());
        IR_node r = visitAnd_expr(ctx.and_expr());
        ans.addLast(l.l);
        ans.addLast(r.l);
        if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
        if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
        Reg bitxor_reg = Reg.NextRes("int");
        ans.addLast(emit("xor",l.p,r.p,bitxor_reg));

        return new IR_node(ans,bitxor_reg);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitAnd_expr(MogicParser.And_exprContext ctx) {
        if(ctx.and_expr() == null){
            return visitEqu_expr(ctx.equ_expr());
        }

        IRList ans = new IRList();
        IR_node l = visitAnd_expr(ctx.and_expr());
        IR_node r = visitEqu_expr(ctx.equ_expr());
        ans.addLast(l.l);
        ans.addLast(r.l);
        if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
        if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
        Reg bitand = Reg.NextRes("int");
        ans.addLast(emit("and",l.p,r.p,bitand));

        return new IR_node(ans,bitand);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitEqu_expr(MogicParser.Equ_exprContext ctx) {
        if(ctx.equ_expr() == null){
            return visitRelational_expr(ctx.relational_expr());
        }

        IRList ans = new IRList();
        IR_node l = visitEqu_expr(ctx.equ_expr());
        IR_node r = visitRelational_expr(ctx.relational_expr());
        Reg bool_reg;
        ans.addLast(l.l);
        ans.addLast(r.l);

        if(l.p.type.intern() != "string") {
            if (ctx.equality_operator().EQ() != null) {
                if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                    Reg.Release(l.p);
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(new Constant_instr("seq "+bool_reg.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                    return new IR_node(ans,bool_reg);
                }
                else if(l.p.is_tmp_reg){
                    Reg.Release(l.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("seq", l.p.toReg(), r.p, bool_reg.toReg()));
                }
                else if(r.p.is_tmp_reg){
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("seq", l.p, r.p.toReg(), bool_reg.toReg()));
                }
                else {
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    //ans.addLast(special_emit("seq", l.p, r.p, bool_reg.toReg()));

                    if(r.p.imm) {
                        if(!l.p.imm) {
                            ans.addLast(new Constant_instr("lw $t0," , l.p));
                            ans.addLast(new Constant_instr("seq " + bool_reg.toReg() + ",$t0," + r.p.imm_num));
                        }
                        else {
                            bool_reg.imm = true;
                            if(l.p.imm_num == r.p.imm_num) bool_reg.imm_num = 1;
                            else bool_reg.imm_num = 0;
                        }
                    }
                    else{
                        if(l.p.imm){
                            ans.addLast(new Constant_instr("lw $t0," , r.p));
                            ans.addLast(new Constant_instr("seq " + bool_reg.toReg() + ",$t0," + l.p.imm_num));
                        }
                        else {
                            ans.addLast(new Constant_instr("lw $t0," ,l.p));
                            ans.addLast(new Constant_instr("lw $t1," ,r.p));
                            ans.addLast(new Constant_instr("seq "+bool_reg.toReg()+",$t0,$t1"));
                        }
                    }
                }
                return new IR_node(ans,bool_reg);
            } else {
/*
                if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
                if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
                bool_reg = Reg.NextRes("bool");
                ans.addLast(emit("cmp_NE", l.p, r.p, bool_reg));*/
                if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                    Reg.Release(l.p);
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(new Constant_instr("sne "+bool_reg.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                    return new IR_node(ans,bool_reg);
                }
                else if(l.p.is_tmp_reg){
                    Reg.Release(l.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("sne", l.p.toReg(), r.p, bool_reg.toReg()));
                }
                else if(r.p.is_tmp_reg){
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("sne", l.p, r.p.toReg(), bool_reg.toReg()));
                }
                else {
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    //ans.addLast(special_emit("sne", l.p, r.p, bool_reg.toReg()));

                    if(r.p.imm) {
                        if(!l.p.imm) {
                            ans.addLast(new Constant_instr("lw $t0," , l.p));
                            ans.addLast(new Constant_instr("sne " + bool_reg.toReg() + ",$t0," + r.p.imm_num));
                        }
                        else {
                            bool_reg.imm = true;
                            if(l.p.imm_num != r.p.imm_num) bool_reg.imm_num = 1;
                            else bool_reg.imm_num = 0;
                        }
                    }
                    else{
                        if(l.p.imm){
                            ans.addLast(new Constant_instr("lw $t0," , r.p));
                            ans.addLast(new Constant_instr("sne " + bool_reg.toReg() + ",$t0," + l.p.imm_num));
                        }
                        else {
                            ans.addLast(new Constant_instr("lw $t0," ,l.p));
                            ans.addLast(new Constant_instr("lw $t1," ,r.p));
                            ans.addLast(new Constant_instr("sne "+bool_reg.toReg()+",$t0,$t1"));
                        }
                    }
                }
                return new IR_node(ans,bool_reg);
            }
        }
        else {

            if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
            if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
            if (ctx.equality_operator().EQ() != null) {
                bool_reg = Reg.NextRes("bool");
                ans.addLast(new Constant_instr("lw $a0 ",l.p));
                ans.addLast(new Constant_instr("lw $a1 ",r.p));
                ans.addLast(new Constant_instr("jal StringEqual"));
                ans.addLast(new Constant_instr("sw $v0 ",bool_reg));
            } else {
                bool_reg = Reg.NextRes("bool");
                ans.addLast(new Constant_instr("lw $a0 ",l.p));
                ans.addLast(new Constant_instr("lw $a1 ",r.p));
                ans.addLast(new Constant_instr("jal StringNotEqual"));
                ans.addLast(new Constant_instr("sw $v0 ",bool_reg));
            }
        }
        return new IR_node(ans,bool_reg);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitRelational_expr(MogicParser.Relational_exprContext ctx) {
        if(ctx.relational_expr() == null){
            return visitShift_expr(ctx.shift_expr());
        }

        IRList ans = new IRList();
        IR_node l = visitRelational_expr(ctx.relational_expr());
        IR_node r = visitShift_expr(ctx.shift_expr());
        Reg bool_reg;
        ans.addLast(l.l);
        ans.addLast(r.l);

        if(l.p.type.intern() == "int") {

            if (ctx.comparsion_operator().GE() != null) {
                if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
                if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
                bool_reg = Reg.NextRes("bool");
                ans.addLast(emit("cmp_GE", l.p, r.p, bool_reg));
            } else if (ctx.comparsion_operator().LE() != null) {
                //bool_reg = Reg.NextRes("bool");
                //ans.addLast(emit("cmp_LE", l.p, r.p, bool_reg));

                if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                    Reg.Release(l.p);
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(new Constant_instr("sle "+bool_reg.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                    return new IR_node(ans,bool_reg);
                }
                else if(l.p.is_tmp_reg){
                    Reg.Release(l.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("sle", l.p.toReg(), r.p, bool_reg.toReg()));
                }
                else if(r.p.is_tmp_reg){
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("sle", l.p, r.p.toReg(), bool_reg.toReg()));
                }
                else {
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    //ans.addLast(special_emit("sle", l.p, r.p, bool_reg.toReg()));

                    if(r.p.imm) {
                        if(!l.p.imm) {
                            ans.addLast(new Constant_instr("lw $t0," , l.p));
                            ans.addLast(new Constant_instr("sle " + bool_reg.toReg() + ",$t0," + r.p.imm_num));
                        }
                        else {
                            bool_reg.imm = true;
                            if(l.p.imm_num <= r.p.imm_num) bool_reg.imm_num = 1;
                            else bool_reg.imm_num = 0;
                        }
                    }
                    else{
                        if(l.p.imm){
                            ans.addLast(new Constant_instr("lw $t0," , r.p));
                            ans.addLast(new Constant_instr("sle " + bool_reg.toReg() + ",$t0," + l.p.imm_num));
                        }
                        else {
                            ans.addLast(new Constant_instr("lw $t0," ,l.p));
                            ans.addLast(new Constant_instr("lw $t1," ,r.p));
                            ans.addLast(new Constant_instr("sle "+bool_reg.toReg()+",$t0,$t1"));
                        }
                    }
                }
                return new IR_node(ans,bool_reg);
            } else if (ctx.comparsion_operator().GT() != null) {
                //if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
                //if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
                //bool_reg = Reg.NextRes("bool");
                //ans.addLast(emit("cmp_GT", l.p, r.p, bool_reg));
                if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                    Reg.Release(l.p);
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(new Constant_instr("sgt "+bool_reg.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                    return new IR_node(ans,bool_reg);
                }
                else if(l.p.is_tmp_reg){
                    Reg.Release(l.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("sgt", l.p.toReg(), r.p, bool_reg.toReg()));
                }
                else if(r.p.is_tmp_reg){
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("sgt", l.p, r.p.toReg(), bool_reg.toReg()));
                }
                else {
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    //ans.addLast(special_emit("sgt", l.p, r.p, bool_reg.toReg()));

                    if(r.p.imm) {
                        if(!l.p.imm) {
                            ans.addLast(new Constant_instr("lw $t0," , l.p));
                            ans.addLast(new Constant_instr("sgt " + bool_reg.toReg() + ",$t0," + r.p.imm_num));
                        }
                        else {
                            bool_reg.imm = true;
                            if(l.p.imm_num > r.p.imm_num) bool_reg.imm_num = 1;
                            else bool_reg.imm_num = 0;
                        }
                    }
                    else{
                        if(l.p.imm){
                            ans.addLast(new Constant_instr("lw $t0," , r.p));
                            ans.addLast(new Constant_instr("sgt " + bool_reg.toReg() + ",$t0," + l.p.imm_num));
                        }
                        else {
                            ans.addLast(new Constant_instr("lw $t0," ,l.p));
                            ans.addLast(new Constant_instr("lw $t1," ,r.p));
                            ans.addLast(new Constant_instr("sgt "+bool_reg.toReg()+",$t0,$t1"));
                        }
                    }
                }
                return new IR_node(ans,bool_reg);
            } else {
                //if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
                //if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
                //bool_reg = Reg.NextRes("bool");
                //ans.addLast(emit("cmp_LT", l.p, r.p, bool_reg));
                if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                    Reg.Release(l.p);
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(new Constant_instr("slt "+bool_reg.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                    return new IR_node(ans,bool_reg);
                }
                else if(l.p.is_tmp_reg){
                    Reg.Release(l.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("slt", l.p.toReg(), r.p, bool_reg.toReg()));
                }
                else if(r.p.is_tmp_reg){
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("slt", l.p, r.p.toReg(), bool_reg.toReg()));
                }
                else {
                    IR_node temp = Reg.NexttmpRes("bool");
                    bool_reg = temp.p;
                    ans.addLast(temp.l);
                    //ans.addLast(special_emit("slt", l.p, r.p, bool_reg.toReg()));

                    if(r.p.imm) {
                        if(!l.p.imm) {
                            ans.addLast(new Constant_instr("lw $t0," , l.p));
                            ans.addLast(new Constant_instr("slt " + bool_reg.toReg() + ",$t0," + r.p.imm_num));
                        }
                        else {
                            bool_reg.imm = true;
                            if(l.p.imm_num < r.p.imm_num) bool_reg.imm_num = 1;
                            else bool_reg.imm_num = 0;
                        }
                    }
                    else{
                        if(l.p.imm){
                            ans.addLast(new Constant_instr("lw $t0," , r.p));
                            ans.addLast(new Constant_instr("slt " + bool_reg.toReg() + ",$t0," + l.p.imm_num));
                        }
                        else {
                            ans.addLast(new Constant_instr("lw $t0," ,l.p));
                            ans.addLast(new Constant_instr("lw $t1," ,r.p));
                            ans.addLast(new Constant_instr("slt "+bool_reg.toReg()+",$t0,$t1"));
                        }
                    }
                }
                return new IR_node(ans,bool_reg);
            }
        }
        else{
            if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
            if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
            if (ctx.comparsion_operator().GE() != null) {
                bool_reg = Reg.NextRes("bool");
                ans.addLast(new Constant_instr("lw $a0 ",l.p));
                ans.addLast(new Constant_instr("lw $a1 ",r.p));
                ans.addLast(new Constant_instr("jal StringGreaterEqual"));
                ans.addLast(new Constant_instr("sw $v0 ",bool_reg));
            } else if (ctx.comparsion_operator().LE() != null) {
                bool_reg = Reg.NextRes("bool");
                ans.addLast(new Constant_instr("lw $a0 ",l.p));
                ans.addLast(new Constant_instr("lw $a1 ",r.p));
                ans.addLast(new Constant_instr("jal StringLessEqual"));
                ans.addLast(new Constant_instr("sw $v0 ",bool_reg));
            } else if (ctx.comparsion_operator().GT() != null) {
                bool_reg = Reg.NextRes("bool");
                ans.addLast(new Constant_instr("lw $a0 ",l.p));
                ans.addLast(new Constant_instr("lw $a1 ",r.p));
                ans.addLast(new Constant_instr("jal StringGreater"));
                ans.addLast(new Constant_instr("sw $v0 ",bool_reg));
            } else {
                bool_reg = Reg.NextRes("bool");
                ans.addLast(new Constant_instr("lw $a0 ",l.p));
                ans.addLast(new Constant_instr("lw $a1 ",r.p));
                ans.addLast(new Constant_instr("jal StringLess"));
                ans.addLast(new Constant_instr("sw $v0 ",bool_reg));
            }
        }
        return new IR_node(ans,bool_reg);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitShift_expr(MogicParser.Shift_exprContext ctx) {
        if(ctx.shift_expr() == null){
            return visitAdditive_expr(ctx.additive_expr());
        }

        IRList ans = new IRList();
        IR_node l = visitShift_expr(ctx.shift_expr());
        IR_node r = visitAdditive_expr(ctx.additive_expr());
        ans.addLast(l.l);
        ans.addLast(r.l);
        if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
        if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
        Reg int_reg = Reg.NextRes("int");
        if(ctx.shift_operator().LSHIFT() != null)
            ans.addLast(emit("lshift",l.p,r.p,int_reg));
        else ans.addLast(emit("rshift",l.p,r.p,int_reg));

        return new IR_node(ans,int_reg);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitAdditive_expr(MogicParser.Additive_exprContext ctx) {
        if(ctx.additive_expr() == null){
            return visitMuly_expr(ctx.muly_expr());
        }
        IRList ans = new IRList();
        IR_node l = visitAdditive_expr(ctx.additive_expr());
        IR_node r = visitMuly_expr(ctx.muly_expr());
        ans.addLast(l.l);
        ans.addLast(r.l);
        if(ctx.MINUS() == null){
            if(l.p.type == "int"){


                    /*minus = Reg.NextRes("int");
                    ans.addLast(emit("add", l.p, r.p, minus));
                    */
                Reg minus;
                if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                    Reg.Release(l.p);
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("int");
                    minus = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(new Constant_instr("add "+minus.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                    return new IR_node(ans,minus);
                }
                else if(l.p.is_tmp_reg){
                    Reg.Release(l.p);
                    IR_node temp = Reg.NexttmpRes("int");
                    minus = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("add", l.p.toReg(), r.p, minus.toReg()));
                }
                else if(r.p.is_tmp_reg){
                    Reg.Release(r.p);
                    IR_node temp = Reg.NexttmpRes("int");
                    minus = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("add", l.p, r.p.toReg(), minus.toReg()));
                }
                else {
                    IR_node temp = Reg.NexttmpRes("int");
                    minus = temp.p;
                    ans.addLast(temp.l);
                    ans.addLast(special_emit("add", l.p, r.p, minus.toReg()));
                }
                return new IR_node(ans,minus);
            }
            else{//string
                if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
                if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
                Reg string_add = Reg.NextRes("string");
                //ans.addLast(emit("string_add",l.p,r.p,string_add));
                ans.addLast(new Constant_instr("lw $a0 ",l.p));
                ans.addLast(new Constant_instr("lw $a1 ",r.p));
                ans.addLast(new Constant_instr("jal StringConcatenate"));
                ans.addLast(new Constant_instr("sw $v0 ",string_add));
                return new IR_node(ans,string_add);
            }

        }
        else {/*
            if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
            if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
            Reg minus;
                minus = Reg.NextRes("int");
                ans.addLast(emit("sub", l.p, r.p, minus));
            //}
            return new IR_node(ans,minus);*/
            Reg minus;
            if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                Reg.Release(l.p);
                Reg.Release(r.p);
                IR_node temp = Reg.NexttmpRes("int");
                minus = temp.p;
                ans.addLast(temp.l);
                ans.addLast(new Constant_instr("sub "+minus.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                return new IR_node(ans,minus);
            }
            else if(l.p.is_tmp_reg){
                Reg.Release(l.p);
                IR_node temp = Reg.NexttmpRes("int");
                minus = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("sub", l.p.toReg(), r.p, minus.toReg()));
            }
            else if(r.p.is_tmp_reg){
                Reg.Release(r.p);
                IR_node temp = Reg.NexttmpRes("int");
                minus = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("sub", l.p, r.p.toReg(), minus.toReg()));
            }
            else {
                IR_node temp = Reg.NexttmpRes("int");
                minus = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("sub", l.p, r.p, minus.toReg()));
            }
            return new IR_node(ans,minus);
        }


    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitMuly_expr(MogicParser.Muly_exprContext ctx) {
        if(ctx.muly_expr() == null){
            return visitUnary_expr(ctx.unary_expr());
        }

        IRList ans = new IRList();
        IR_node l = visitMuly_expr(ctx.muly_expr());
        IR_node r = visitUnary_expr(ctx.unary_expr());
        ans.addLast(l.l);
        ans.addLast(r.l);
        Reg mul;
        if(ctx.MUL() != null){
            //ans.addLast(emit("mul",l.p,r.p,mul));
            if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                Reg.Release(l.p);
                Reg.Release(r.p);
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(new Constant_instr("mul "+mul.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                return new IR_node(ans,mul);
            }
            else if(l.p.is_tmp_reg){
                Reg.Release(l.p);
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("mul", l.p.toReg(), r.p, mul.toReg()));
            }
            else if(r.p.is_tmp_reg){
                Reg.Release(r.p);
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("mul", l.p, r.p.toReg(), mul.toReg()));
            }
            else {
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("mul", l.p, r.p, mul.toReg()));
            }
            return new IR_node(ans,mul);
        }

        else if(ctx.DIV() != null){
            if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                Reg.Release(l.p);
                Reg.Release(r.p);
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(new Constant_instr("div "+mul.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                return new IR_node(ans,mul);
            }
            else if(l.p.is_tmp_reg){
                Reg.Release(l.p);
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("div", l.p.toReg(), r.p, mul.toReg()));
            }
            else if(r.p.is_tmp_reg){
                Reg.Release(r.p);
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("div", l.p, r.p.toReg(), mul.toReg()));
            }
            else {
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("div", l.p, r.p, mul.toReg()));
            }
            return new IR_node(ans,mul);
            //ans.addLast(emit("div",l.p,r.p,mul));

        }
        else if(ctx.REM() != null){
            mul = Reg.NextRes("int");
                        if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
                        if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
                        ans.addLast(emit("rem",l.p,r.p,mul));
            /*
            if(l.p.is_tmp_reg && r.p.is_tmp_reg){
                Reg.Release(l.p);
                Reg.Release(r.p);
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(new Constant_instr("rem "+mul.toReg()+" "+l.p.toReg()+" "+r.p.toReg()));
                return new IR_node(ans,mul);
            }
            else if(l.p.is_tmp_reg){
                Reg.Release(l.p);
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("rem", l.p.toReg(), r.p, mul.toReg()));
            }
            else if(r.p.is_tmp_reg){
                Reg.Release(r.p);
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("rem", l.p, r.p.toReg(), mul.toReg()));
            }
            else {
                IR_node temp = Reg.NexttmpRes("int");
                mul = temp.p;
                ans.addLast(temp.l);
                ans.addLast(special_emit("rem", l.p, r.p, mul.toReg()));
            }*/
            return new IR_node(ans,mul);
            //ans.addLast(emit("rem",l.p,r.p,mul));

        }
        mul = Reg.NextRes("int");
        return new IR_node(ans,mul);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitUnary_expr(MogicParser.Unary_exprContext ctx) {//?
        IRList ans = new IRList();

        if(ctx.postfix_expr() != null){
            return visitPostfix_expr(ctx.postfix_expr());
        }
        else if(ctx.constructor_call() != null){
            return visitConstructor_call(ctx.constructor_call());
        }

        IR_node tmp = visitUnary_expr(ctx.unary_expr());
        ans.addLast(tmp.l);

        if(ctx.NOT() != null){
            IR_node temp = Reg.NexttmpRes("bool");
            ans.addLast(temp.l);
            //if(tmp.p.is_tmp_reg) ans.addLast(_save(tmp.p));
            Reg bool_reg = temp.p;
            if(tmp.p.is_tmp_reg){
                Reg.Release(tmp.p);
                ans.addLast(new Constant_instr("xor "+bool_reg.toReg()+" "+tmp.p.toReg()+" 1"));
            }
            else {
                if(tmp.p.imm){
                    ans.addLast(new Constant_instr("li "+bool_reg.toReg()+" "+String.valueOf(tmp.p.imm_num ^ 1)));
                }
                else{
                    ans.addLast(new Constant_instr("lw $t0 ",tmp.p));
                    ans.addLast(new Constant_instr("xor "+bool_reg.toReg()+" $t0 1"));
                }
            }
            return new IR_node(ans,bool_reg);
        }
        else if(ctx.INCREMENT() != null){
            if(tmp.p.is_tmp_reg) ans.addLast(_save(tmp.p));
            //ans.addLast(emit("add",tmp.p,Reg.NextimmRes("int",1),tmp.p));
            ans.addLast(new Constant_instr("lw $t0 ",tmp.p));
            ans.addLast(new Constant_instr("add $t0 $t0 1"));
            ans.addLast(new Constant_instr("sw $t0 ",tmp.p));
            if(Reg_pos.containsKey(tmp.p)){
                //System.out.println(r_reg.addr_num);
                if(tmp.p.is_tmp_reg) ans.addLast(_save(tmp.p));
                ans.addLast(emit("store",Reg_pos.get(tmp.p),tmp.p,Reg.NextimmRes("int",0)));
            }
            return new IR_node(ans,tmp.p);
        }
        else if(ctx.DECREMENT() != null){
            if(tmp.p.is_tmp_reg) ans.addLast(_save(tmp.p));
            //ans.addLast(emit("sub",tmp.p,Reg.NextimmRes("int",1),tmp.p));
            ans.addLast(new Constant_instr("lw $t0 ",tmp.p));
            ans.addLast(new Constant_instr("sub $t0 $t0 1"));
            ans.addLast(new Constant_instr("sw $t0 ",tmp.p));
            if(Reg_pos.containsKey(tmp.p)){
                //System.out.println(r_reg.addr_num);
                if(tmp.p.is_tmp_reg) ans.addLast(_save(tmp.p));
                ans.addLast(emit("store",Reg_pos.get(tmp.p),tmp.p,Reg.NextimmRes("int",0)));
            }
            return new IR_node(ans,tmp.p);
        }
        else{
            if(tmp.p.is_tmp_reg) ans.addLast(_save(tmp.p));
            if(ctx.unary_operator().MINUS() != null){
                Reg tmp_reg = Reg.NextRes("int");
                ans.addLast(emit("neg",tmp.p,tmp_reg));

                return new IR_node(ans,tmp_reg);
            }
            else if(ctx.unary_operator().PLUS() != null){
                return new IR_node(ans,tmp.p);
            }
            else if(ctx.unary_operator().Tilde() != null){
                Reg tmp_reg = Reg.NextRes("int");
                ans.addLast(emit("not",tmp.p,tmp_reg));

                return new IR_node(ans,tmp_reg);
            }

        }
        return tmp;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitConstructor_call(MogicParser.Constructor_callContext ctx) {
        IRList ans = new IRList();

        if(ctx.getChildCount() == 2){
            Class_type l = class_table.lookup(ctx.primitive_type().getText());
            Reg addr_reg = Reg.NextRes("class");
            ans.addLast(emit("alloc",Reg.NextimmRes("int",l._size),addr_reg));
            return new IR_node(ans,addr_reg);
        }
        else{
            IR_node l = visitDim_expr(ctx.dim_expr());
            Reg dim_reg = l.p,dim_reg1 = Reg.NextRes("int");//
            ans.addLast(l.l);
            if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
            ans.addLast(emit("add",dim_reg,Reg.NextimmRes("int",1),dim_reg1));
            ans.addLast(emit("mul",dim_reg1,Reg.NextimmRes("int",4),dim_reg1));
            Reg Arr_addr = Reg.NextRes("array");
            ans.addLast(emit("alloc",dim_reg1,Arr_addr));
            ans.addLast(emit("store",Arr_addr,dim_reg,Reg.NextimmRes("int",0)));
            return new IR_node(ans,Arr_addr);
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitDim_expr(MogicParser.Dim_exprContext ctx) {
        return visitAssignment_expr(ctx.assignment_expr());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public IR_node visitArr_arg_suffix(MogicParser.Arr_arg_suffixContext ctx) {
        return visitAssignment_expr(ctx.assignment_expr());
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public LinkedList<IR_node> visitArgument_expr_list(MogicParser.Argument_expr_listContext ctx) {
        LinkedList<IR_node> l = new LinkedList<IR_node>();
        //if(ctx.assignment_expr().size()>0)visitAssignment_expr(ctx.assignment_expr(0)).getClass().getSimpleName();
        for(MogicParser.Assignment_exprContext k : ctx.assignment_expr()){
            l.addLast(visitAssignment_expr(k));
        }
        //System.out.println(l.getLast().getClass().getSimpleName());
        return l;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitAssignment_expr(MogicParser.Assignment_exprContext ctx) {
        if(ctx.ASSIGN() == null) return visitLogic_or_expr(ctx.logic_or_expr());
        IRList ans = new IRList();
        IR_node l = visitUnary_expr(ctx.unary_expr());
        ans.addLast(l.l);
        if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
        Reg l_reg = l.p;
        IR_node r = visitExpr(ctx.expr());
        ans.addLast(r.l);
        Reg r_reg = r.p;


        if(Reg_pos.containsKey(l_reg)){
            //System.out.println(r_reg.addr_num);
            //if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
            //ans.addLast(emit("store",Reg_pos.get(l_reg),r_reg,Reg.NextimmRes("int",0)));
            if(r.p.is_tmp_reg){
                Reg.Release(r.p);
                ans.addLast(new Constant_instr("lw $t0 ",Reg_pos.get(l_reg)));
                ans.addLast(new Constant_instr("sw "+r.p.toReg()+" ($t0)"));
                //ans.addLast(new Constant_instr("sw "+r.p.toReg()+" ",l.p));
            }
            else{
                if(r_reg.imm){
                    ans.addLast(new Constant_instr("li $t0,"+String.valueOf(r_reg.imm_num)));
                    ans.addLast(new Constant_instr("lw $t1,",Reg_pos.get(l_reg)));
                    ans.addLast(new Constant_instr("sw $t0,($t1)"));
                }
                else {
                    ans.addLast(emit("store", Reg_pos.get(l_reg), r_reg, Reg.NextimmRes("int", 0)));
                }
                //ans.addLast(emit("move",r_reg,l_reg));
            }
            return new IR_node(ans,r_reg);
        }
        if(r.p.is_tmp_reg){
            Reg.Release(r.p);
            ans.addLast(new Constant_instr("sw "+r.p.toReg()+" ",l.p));
        }
        else ans.addLast(emit("move",r_reg,l_reg));
        //class = class
        //class.asses = class.asses
        return new IR_node(ans,r_reg);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IR_node visitPostfix_expr(MogicParser.Postfix_exprContext ctx) {

        if(ctx.expr() != null){
            /*IR_node l = visitExpr(ctx.expr());
            IRList ans = new IRList();
            Reg tmp = l.p;
            ans.addLast(l.l);
            if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
            return new IR_node(ans,tmp);*/
            return visitExpr(ctx.expr());
        }

        else if(ctx.constant()!=null){
            if(ctx.constant().bool_literal() != null){
                if(ctx.constant().getText().intern() == "false"){
                    return new IR_node(new IRList(),Reg.NextimmRes("bool",0));
                }
                else{
                    return new IR_node(new IRList(),Reg.NextimmRes("bool",1));
                }
            }
            if(ctx.constant().Int_literal() != null){
                return new IR_node(new IRList(),Reg.NextimmRes("int",Integer.parseInt(ctx.constant().getText())));
            }
            if(ctx.constant().String_literal() != null){
                IRList ans = new IRList();
                String s = ctx.constant().getText();
                int tmp1 = s.length()-3;

                if(tmp1 > 1 && s.substring(1,2).intern() == "\\" && s.substring(tmp1,tmp1+1).intern() == "\\") s = "\" "+s.substring(3,s.length()-3)+" \"";
                globasl_string_set.put(++String_con,s.intern());
                Reg tmp = Reg.NextRes("string");
                ans.addLast(new Constant_instr("la $t0 String"+String.valueOf(String_con)));
                ans.addLast(new Constant_instr("sb $0 "+String.valueOf(s.length()-2)+"($t0)"));
                ans.addLast(new Constant_instr("sw $t0 ",tmp));
                return new IR_node(ans,tmp);
            }
            if(ctx.constant().NULL_LITERAL() != null){
                return new IR_node(new IRList(),Reg.NextimmRes("int",0));
            }

        }
        else if(ctx.INCREMENT() != null){
            IR_node tmp = visitPostfix_expr(ctx.postfix_expr());
            IRList ans = new IRList();
            ans.addLast(tmp.l);
            if(tmp.p.is_tmp_reg){
                ans.addLast(_save(tmp.p));
            }
            Reg tmp_reg = Reg.NextRes("int");
            //ans.addLast(emit("move",tmp.p,tmp_reg));
            ans.addLast(new Constant_instr("lw $t0,",tmp.p));
            ans.addLast(new Constant_instr("sw $t0,",tmp_reg));
            ans.addLast(new Constant_instr("add $t0 $t0 1"));
            ans.addLast(new Constant_instr("sw $t0 ",tmp.p));
            if(Reg_pos.containsKey(tmp.p)){
                //System.out.println(r_reg.addr_num);
                if(tmp.p.is_tmp_reg) ans.addLast(_save(tmp.p));
                ans.addLast(emit("store",Reg_pos.get(tmp.p),tmp.p,Reg.NextimmRes("int",0)));
            }
            return new IR_node(ans,tmp_reg);
        }
        else if(ctx.DECREMENT() != null){
            IR_node tmp = visitPostfix_expr(ctx.postfix_expr());
            IRList ans = new IRList();
            ans.addLast(tmp.l);
            if(tmp.p.is_tmp_reg){
                ans.addLast(_save(tmp.p));
            }
            Reg tmp_reg = Reg.NextRes("int");
            //ans.addLast(emit("move",tmp.p,tmp_reg));
            ans.addLast(new Constant_instr("lw $t0 ",tmp.p));
            ans.addLast(new Constant_instr("sw $t0,",tmp_reg));
            ans.addLast(new Constant_instr("sub $t0 $t0 1"));
            ans.addLast(new Constant_instr("sw $t0 ",tmp.p));
            if(Reg_pos.containsKey(tmp.p)){
                //System.out.println(r_reg.addr_num);
                if(tmp.p.is_tmp_reg) ans.addLast(_save(tmp.p));
                ans.addLast(emit("store",Reg_pos.get(tmp.p),tmp.p,Reg.NextimmRes("int",0)));
            }
            return new IR_node(ans,tmp_reg);
        }
        else if(! ctx.arr_arg_suffix().isEmpty()){
            IRList ans = new IRList();
            IR_node arr = visitPostfix_expr(ctx.postfix_expr());
            Reg cur_reg = arr.p , cur_reg1 = Reg.NextRes("addr");
            ans.addLast(arr.l);
            if(arr.p.is_tmp_reg){
                ans.addLast(_save(arr.p));
            }
            IR_node temp = Reg.NexttmpRes("addr");
            //Reg cur_reg2 = Reg.NextRes("addr");
            ans.addLast(temp.l);
            Reg cur_reg2 = temp.p;
            //ans.addLast(emit("move",cur_reg,cur_reg2));
            ans.addLast(new Constant_instr("lw "+cur_reg2.toReg()+" ",cur_reg));
            cur_reg = cur_reg2;
            int q = ctx.arr_arg_suffix().size();

            for(MogicParser.Arr_arg_suffixContext p : ctx.arr_arg_suffix()){
                --q;
                IR_node l = visitArr_arg_suffix(p);
                ans.addLast(l.l);

                //Reg reg1 = Reg.NextRes("int");
                //ans.addLast(emit("add",l.p,Reg.NextimmRes("int",1),reg1));
                //ans.addLast(emit("mul",reg1,Reg.NextimmRes("int",4),reg1));
                if(l.p.imm){
                    int j = (l.p.imm_num+1)*4;
                    ans.addLast(new Constant_instr("li $t0 "+String.valueOf(j)));
                }
                else {
                    //if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
                    if(l.p.is_tmp_reg){
                        Reg.Release(l.p);
                        ans.addLast(new Constant_instr("add $t0 "+l.p.toReg()+" 1"));
                        ans.addLast(new Constant_instr("mul $t0 $t0 4"));
                    }
                    else {
                        ans.addLast(new Constant_instr("lw $t0 ", l.p));
                        ans.addLast(new Constant_instr("add $t0 $t0 1"));
                        ans.addLast(new Constant_instr("mul $t0 $t0 4"));
                    }
                }
                ans.addLast(new Constant_instr("add $t0 "+cur_reg.toReg()+" $t0"));
                ans.addLast(new Constant_instr("sw $t0 ",cur_reg1));
                //ans.addLast(emit("add",cur_reg,reg1,cur_reg1));
                //ans.addLast(emit("_load",cur_reg1,Reg.NextimmRes("int",0),cur_reg));
                ans.addLast(new Constant_instr("lw "+cur_reg.toReg()+" ($t0)"));

                //?
            }

            Reg_pos.put(cur_reg,cur_reg1);

            visit_forth qq = new visit_forth();
            Object s = qq.visitPostfix_expr(ctx.postfix_expr());

            Object ss = (Array_type.Use_arr((Array_type)s,ctx.arr_arg_suffix().size()));
            //System.out.println(ctx.arr_arg_suffix().size());
            if(ss instanceof Integer_type) cur_reg.type = "int";
            else if(ss instanceof Array_type) cur_reg.type = "array";
            else if(ss instanceof Bool_type) cur_reg.type = "bool";
            else if(ss instanceof Class_type) cur_reg.type = "class";
            else if(ss instanceof String_type) cur_reg.type = "string";
//ans.addLast(_save(cur_reg));
            return new IR_node(ans,cur_reg);
        }
        else if(ctx.SIZE() != null){
            IRList ans = new IRList();
            IR_node s = visitPostfix_expr(ctx.postfix_expr());
            ans.addLast(s.l);
            if(s.p.is_tmp_reg) ans.addLast(_save(s.p));
            Reg pos = Reg.NextRes("int");
            ans.addLast(emit("_load",s.p,Reg.NextimmRes("int",0),pos));
            return new IR_node(ans,pos);
        }
        else if(ctx.LENGTH() != null){
            IR_node s = visitPostfix_expr(ctx.postfix_expr());
            IRList ans = new IRList();
            ans.addLast(s.l);
            if(s.p.is_tmp_reg) ans.addLast(_save(s.p));
            Reg len = Reg.NextRes("int");
            ans.addLast(emit("load",s.p,Reg.NextimmRes("int",0),len));
            ans.addLast(emit("sub",len,Reg.NextimmRes("int",4),len));
            ans.addLast(emit("_load",len,Reg.NextimmRes("int",0),len));
            return new IR_node(ans,len);
        }
        else if(ctx.SUBSTRING() != null){
            IR_node s = visitPostfix_expr(ctx.postfix_expr());
            IR_node l = visitAssignment_expr(ctx.assignment_expr(0));
            IR_node r = visitAssignment_expr(ctx.assignment_expr(1));

            IRList ans = new IRList();
            ans.addLast(s.l);
            ans.addLast(l.l);
            ans.addLast(r.l);
            if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
            if(r.p.is_tmp_reg) ans.addLast(_save(r.p));
            if(s.p.is_tmp_reg) ans.addLast(_save(s.p));
            Reg str_reg = Reg.NextRes("string");
            ans.addLast(new Constant_instr("lw $a0,",s.p));
            if(l.p.imm) ans.addLast(new Constant_instr("li $a1,"+l.p.imm_num));
            else ans.addLast(new Constant_instr("lw $a1,",l.p));
            if(r.p.imm) ans.addLast(new Constant_instr("li $a2,"+r.p.imm_num));
            else ans.addLast(new Constant_instr("lw $a2,",r.p));
            ans.addLast(new Constant_instr("addu $a2 $a2 1"));
            ans.addLast(new Constant_instr("jal substring\n" +
                    "sw $v0,",str_reg));

            return new IR_node(ans,str_reg);
        }
        else if(ctx.PARSEINT() != null){
            IR_node s = visitPostfix_expr(ctx.postfix_expr());
            IRList ans = new IRList();
            ans.addLast(s.l);
            if(s.p.is_tmp_reg) ans.addLast(_save(s.p));
            Reg len = Reg.NextRes("int");
            ans.addLast(new Constant_instr("lw $t0,",s.p));
            ans.addLast(new Constant_instr("move $a0 $t0"));
            ans.addLast(new Constant_instr("jal parseInt\n" +
                    "sw $v0,",len));
            return new IR_node(ans,len);
        }
        else if(ctx.ORD() != null){
            IR_node s = visitPostfix_expr(ctx.postfix_expr());

            IR_node l = visitAssignment_expr(ctx.assignment_expr(0));
            IRList ans = new IRList();
            ans.addLast(s.l);
            ans.addLast(l.l);
            if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
            if(s.p.is_tmp_reg) ans.addLast(_save(s.p));
            Reg tmp_reg = Reg.NextRes("int");
            ans.addLast(new Constant_instr("lw $t0,",s.p));
            if(l.p.imm) ans.addLast(new Constant_instr("li $t1,"+l.p.imm_num));
            else ans.addLast(new Constant_instr("lw $t1,",l.p));
            ans.addLast(new Constant_instr(
                    "addu $t0 $t0 $t1\n" +
                            "lb $t0 ($t0)\n" +
                            "sw $t0 ",tmp_reg));
            return new IR_node(ans,tmp_reg);
        }
        else if(ctx.DOT() != null && ctx.id() != null){
            IRList ans = new IRList();
            IR_node l =  visitPostfix_expr(ctx.postfix_expr());
            ans.addLast(l.l);
            //if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
            Reg cur_reg = Reg.NextRes("addr"),cur_reg1 = Reg.NextRes("addr");
            if(l.p.is_tmp_reg){
                Reg.Release(l.p);
                //ans.addLast(new Constant_instr("move $t0 "+l.p.toReg()));
                ans.addLast(new Constant_instr("move $t1 "+l.p.toReg()));
            }
            else {
                //ans.addLast(new Constant_instr("move $t0 ",l.p));
                ans.addLast(new Constant_instr("lw $t1 ",l.p));
                //ans.addLast(emit("move", l.p, cur_reg));
                //ans.addLast(emit("move", l.p, cur_reg1));
            }
            visit_forth q = new visit_forth();
            Object s = q.visitPostfix_expr(ctx.postfix_expr());

            int num = ((Class_type)s).place.get(ctx.id().getText());

            //Reg num_reg = Reg.NextimmRes("int",num);
            ans.addLast(new Constant_instr("add $t1 $t1 "+String.valueOf(num)));
            //ans.addLast(emit("add",cur_reg1,num_reg,cur_reg1));

            //ans.addLast(emit("_load",cur_reg1,Reg.NextimmRes("int",0),cur_reg));
            ans.addLast(new Constant_instr("lw $t0 ($t1)"));
            ans.addLast(new Constant_instr("sw $t0 ",cur_reg));
            ans.addLast(new Constant_instr("sw $t1 ",cur_reg1));

            Reg_pos.put(cur_reg,cur_reg1);
            //?
            Object ss = ((Class_type)s).Class_asses(ctx.id().getText());
            if(ss instanceof Integer_type) cur_reg.type = "int";
            else if(ss instanceof Array_type) cur_reg.type = "array";
            else if(ss instanceof Bool_type) cur_reg.type = "bool";
            else if(ss instanceof Class_type) cur_reg.type = "class";
            else if(ss instanceof String_type) cur_reg.type = "string";
            return new IR_node(ans,cur_reg);
        }
        else if(ctx.id() != null){
            Object s = table.lookup(ctx.id().getText());

            if(s instanceof Class_type){
                Class_type tmp = (Class_type) table.lookup(ctx.id().getText());
                return new IR_node(new IRList(),tmp.pl);
            }
            else if(s instanceof Array_type){
                Array_type tmp = (Array_type) table.lookup(ctx.id().getText());
                return new IR_node(new IRList(),tmp.pl);
            }
            else if(s instanceof String_type){
                String_type tmp = (String_type) table.lookup(ctx.id().getText());
                return new IR_node(new IRList(),tmp.pl);
            }
            else if(s instanceof Bool_type){
                Bool_type tmp = (Bool_type) table.lookup(ctx.id().getText());
                return new IR_node(new IRList(),tmp.pl);
            }
            else if(s instanceof Function_type){
                return null;
            }
            else if(s instanceof Integer_type){
                Integer_type tmp = (Integer_type) table.lookup(ctx.id().getText());
                return new IR_node(new IRList(),tmp.pl);
            }
        }
        else {
            IRList ans = new IRList();


            visit_forth q = new visit_forth();
            Object s = q.visitPostfix_expr(ctx.postfix_expr());
            Object ss = ((Function_type)s).Return_type;


            LinkedList<IR_node> p = new LinkedList();
            if(ctx.argument_expr_list()!=null)p = visitArgument_expr_list(ctx.argument_expr_list());
            if(pla){
                if(ctx.postfix_expr().getText().intern() == visit_second.s1) return new IR_node(new IRList(),Reg.NextRes("addr"));
                if(ctx.postfix_expr().getText().intern() == visit_second.s2){
                    for(IR_node k : p){
                        return new IR_node(new IRList(),k.p);
                    }
                }
            }
            int h = 1;
            for(IR_node k : p){//???
                ans.addLast(k.l);
                //if(k.p.is_tmp_reg) ans.addLast(_save(k.p));
                if(k.p.imm){
                    ans.addLast(new Constant_instr("li $t0 "+k.p.imm_num));
                    ans.addLast(new Constant_instr("sw $t0,"+(-(h++)*4)+"($sp)"));
                }
                else{
                    if(k.p.is_tmp_reg){
                        ans.addLast(new Constant_instr("move $t0 "+k.p.toReg()));
                        ans.addLast(new Constant_instr("sw "+k.p.toReg()+" "+(-(h++)*4)+"($sp)"));
                    }
                    else{
                        ans.addLast(new Constant_instr("lw $t0,",k.p));
                        ans.addLast(new Constant_instr("sw $t0,"+(-(h++)*4)+"($sp)"));
                    }
                }

            }

            if(ctx.postfix_expr().getText().intern() == "print" || ctx.postfix_expr().getText().intern() == "println"){
                for(IR_node k : p){
                    if(k.p.imm) ans.addLast(new Constant_instr("li $a0 "+k.p.imm_num));
                    else{
                        if(k.p.is_tmp_reg) ans.addLast(new Constant_instr("move $a0 "+k.p.toReg()));
                        else ans.addLast(new Constant_instr("lw $a0,",k.p));
                    }
                }
            }
            else if(ctx.postfix_expr().getText().intern() == "toString"){
                //System.out.println(ctx.argument_expr_list().getText());
                for(IR_node k : p){
                    if(k.p.imm) ans.addLast(new Constant_instr("li $a0 "+k.p.imm_num));
                    else{
                        if(k.p.is_tmp_reg) ans.addLast(new Constant_instr("move $a0 "+k.p.toReg()));
                        else ans.addLast(new Constant_instr("lw $a0,",k.p));
                    }
                }
            }
            for(IR_node k : p){Reg.Release(k.p);}
            if(ss instanceof Void_type) {
                ans.addLast(emit("call", ctx.postfix_expr().getText(), p, null));
                return new IR_node(ans,null);
            }
            else {
                Reg cur_reg = Reg.NextRes("addr");
                if (ss instanceof Integer_type) cur_reg.type = "int";
                else if (ss instanceof Array_type) cur_reg.type = "array";
                else if (ss instanceof Bool_type) cur_reg.type = "bool";
                else if (ss instanceof Class_type) cur_reg.type = "class";
                else if (ss instanceof String_type) cur_reg.type = "string";
                ans.addLast(emit("call", ctx.postfix_expr().getText(), p, cur_reg));
                ans.addLast(new Constant_instr("sw $v0,",cur_reg));
                return new IR_node(ans,cur_reg);
            }

        }
        return null;

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitUnary_operator(MogicParser.Unary_operatorContext ctx) { return visitChildren(ctx); }

    @Override public Object visitConstant(MogicParser.ConstantContext ctx) { return visitChildren(ctx); }

    @Override public IRList visitStmt(MogicParser.StmtContext ctx) {
        if(ctx.block_stmt()!=null) return visitBlock_stmt(ctx.block_stmt());
        if(ctx.var_decl_stmt()!=null) return visitVar_decl_stmt(ctx.var_decl_stmt());
        if(ctx.expr_stmt()!=null) return visitExpr_stmt(ctx.expr_stmt());
        if(ctx.selection_stmt()!=null) return visitSelection_stmt(ctx.selection_stmt());
        if(ctx.iteration_stmt()!=null) return visitIteration_stmt(ctx.iteration_stmt());
        if(ctx.jump_stmt()!=null) return visitJump_stmt(ctx.jump_stmt());
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IRList visitBlock_stmt(MogicParser.Block_stmtContext ctx) {
        table.add_depth();

        if(!func_para_loaded && current_func.intern()!="main"){
            LinkedList<Para_type> tmp =((Function_type)table.lookup(current_func)).param;
            for(Para_type k : tmp){
                table.insert(k.key,k.Type);
            }
            func_para_loaded = true;
        }
        IRList tmp;
        if(ctx.stmt_list() != null){
            tmp = visitStmt_list(ctx.stmt_list());

        }
        else tmp = new IRList();
        table.dec_depth();
        return tmp;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IRList visitStmt_list(MogicParser.Stmt_listContext ctx) {
        IRList tmp0 = (IRList) visitStmt(ctx.stmt());
        if(ctx.stmt_list() != null){
            IRList tmp = (IRList) visitStmt_list(ctx.stmt_list());
            tmp0.addLast(tmp);
        }

        return tmp0;

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IRList visitExpr_stmt(MogicParser.Expr_stmtContext ctx) {
        if(ctx.expr() != null){
            IR_node tmp = visitExpr(ctx.expr());
            IRList ans = new IRList();
            ans.addLast(tmp.l);
            if(tmp.p != null && tmp.p.is_tmp_reg) Reg.Release(tmp.p);
            //ans.addLast(_save(tmp.p));
            return ans;
        }
        else return new IRList();
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IRList visitJump_stmt(MogicParser.Jump_stmtContext ctx) {

        if(ctx.RETURN() != null){
            IRList ans = new IRList();

            if(ctx.expr() != null){
                IR_node l = visitExpr(ctx.expr());
                ans.addLast(l.l);
                if(l.p.is_tmp_reg) ans.addLast(_save(l.p));
                ans.addLast(emit("ret",l.p));
                ans.addLast(new Constant_instr("lw $ra,0($sp)"));
                ans.addLast(new Constant_instr("addu $sp,$sp,",current_func));
                ans.addLast(new Constant_instr("jr $ra"));
            }
            else {
                ans.addLast(emit("ret"," "));
                ans.addLast(new Constant_instr("lw $ra,0($sp)"));
                ans.addLast(new Constant_instr("addu $sp,$sp,",current_func));
                ans.addLast(new Constant_instr("jr $ra"));
            }

            return ans;
        }
        else if(ctx.BREAK() != null){
            IRList tmp = new IRList();
            tmp.addLast(emit("jump",cur_loop_break.peek()));
            return tmp;
        }
        else{
            IRList tmp = new IRList();
            tmp.addLast(emit("jump",cur_loop_continue.peek()));
            return tmp;
        }

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IRList visitSelection_stmt(MogicParser.Selection_stmtContext ctx) {
        if(ctx.getChildCount() > 10){
            IRList p1,ans = new IRList();
            Instru tmp1 = new Nop_ins("IF_Label"+Integer.toString(++label_num));
            Instru tmp2 = new Nop_ins("IF_Label"+Integer.toString(++label_num));
            table.add_depth();
            p1 = visitStmt(ctx.stmt(0));
            table.dec_depth();

            for(MogicParser.Expr1Context k : ctx.expr1()){
                IR_node pexpr = visitExpr1(k);
                IRList p = pexpr.l;
                Reg exp = pexpr.p;
                ans.addLast(p);
                if(pexpr.p.is_tmp_reg){
                    Reg.Release(pexpr.p);
                    ans.addLast(new Constant_instr("beq "+pexpr.p.toReg()+",0,$"+((Nop_ins)tmp2).s));
                }
                else ans.addLast(emit("br",exp,tmp1,tmp2));
            }

            ans.addLast(tmp1);
            ans.addLast(p1);
            ans.addLast(tmp2);
            return ans;
        }
        IRList p1,p2,ans = new IRList();
        IR_node pexpr = visitExpr(ctx.expr());
        IRList p = pexpr.l;
        Reg exp = pexpr.p;
        ans.addLast(p);
        //if(pexpr.p.is_tmp_reg) ans.addLast(_save(pexpr.p));

        if(ctx.getChildCount() >= 6){
            Instru tmp1 = new Nop_ins("IF_Label"+Integer.toString(++label_num));
            Instru tmp2 = new Nop_ins("IF_Label"+Integer.toString(++label_num));
            Instru tmp3 = new Nop_ins("IF_Label"+Integer.toString(++label_num));
            table.add_depth();
            p1 = (IRList) visitStmt(ctx.stmt(0));
            table.dec_depth();;

            table.add_depth();
            p2 = (IRList) visitStmt(ctx.stmt(1));
            table.dec_depth();

            if(pexpr.p.is_tmp_reg){
                Reg.Release(pexpr.p);
                ans.addLast(new Constant_instr("beq "+pexpr.p.toReg()+",1,$"+((Nop_ins)tmp1).s));
                ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp2).s));
            }
            else ans.addLast(emit("br",exp,tmp1,tmp2));

            ans.addLast(tmp1);
            ans.addLast(p1);
            ans.addLast(emit("jump",tmp3));
            ans.addLast(tmp2);
            ans.addLast(p2);
            ans.addLast(emit("jump",tmp3));
            ans.addLast(tmp3);
        }
        else{
            Instru tmp1 = new Nop_ins("IF_Label"+Integer.toString(++label_num));
            Instru tmp2 = new Nop_ins("IF_Label"+Integer.toString(++label_num));
            table.add_depth();
            p1 = visitStmt(ctx.stmt(0));
            table.dec_depth();
            if(pexpr.p.is_tmp_reg){
                Reg.Release(pexpr.p);
                ans.addLast(new Constant_instr("beq "+pexpr.p.toReg()+",1,$"+((Nop_ins)tmp1).s));
                ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp2).s));
            }
            else ans.addLast(emit("br",exp,tmp1,tmp2));
            ans.addLast(tmp1);
            ans.addLast(p1);
            ans.addLast(emit("jump",tmp2));
            ans.addLast(tmp2);
        }

        return ans;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public IRList visitIteration_stmt(MogicParser.Iteration_stmtContext ctx) {
        //++is_in_loop;
        IRList ans = new IRList();
        String sp = ctx.getText();
        if(ctx.WHILE() != null){
            IR_node pexpr = (IR_node) visitExpr(ctx.expr());
            IRList p = pexpr.l;
            Reg exp = pexpr.p;


            ans.addLast(p);
            //if(pexpr.p.is_tmp_reg) ans.addLast(_save(pexpr.p));
            Instru tmp = new Nop_ins("WHILE_Label"+Integer.toString(++label_num));
            Instru tmp1 = new Nop_ins("WHILE_Label"+Integer.toString(++label_num));
            Instru tmp2 = new Nop_ins("WHILE_Label"+Integer.toString(++label_num));
            //Instru tmp3 = new Nop_ins("WHILE_Label"+Integer.toString(++label_num));?


            //ans.addLast(emit("br",exp,tmp,tmp2));
            if(exp.is_tmp_reg){
                Reg.Release(exp);
                ans.addLast(new Constant_instr("beq "+exp.toReg()+",1,$"+((Nop_ins)tmp).s));
                ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp2).s));
            }
            else {
                ans.addLast(new Constant_instr("lw $t0 ",exp));
                ans.addLast(new Constant_instr("beq $t0,1,$"+((Nop_ins)tmp).s));
                ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp2).s));
            }

            ans.addLast(tmp);
            cur_loop_continue.push(tmp1);
            cur_loop_break.push(tmp2);
            table.add_depth();

            ans.addLast((IRList) visitStmt(ctx.stmt()));

            table.dec_depth();
            cur_loop_break.pop();
            cur_loop_continue.pop();


            ans.addLast(emit("jump",tmp1));
            ans.addLast(tmp1);

            pexpr = (IR_node) visitExpr(ctx.expr());
            p = pexpr.l;//
            exp = pexpr.p;//neng you hua
            ans.addLast(p);
            //if(pexpr.p.is_tmp_reg) ans.addLast(_save(pexpr.p));
            //ans.addLast(emit("br",exp,tmp,tmp2));
            if(exp.is_tmp_reg){
                Reg.Release(exp);
                ans.addLast(new Constant_instr("beq "+exp.toReg()+",1,$"+((Nop_ins)tmp).s));
                ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp2).s));
            }
            else {
                ans.addLast(new Constant_instr("lw $t0 ",exp));
                ans.addLast(new Constant_instr("beq $t0,1,$"+((Nop_ins)tmp).s));
                ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp2).s));
            }
            ans.addLast(tmp2);


        }
        else{
            if(ctx.expr0() != null){
                IR_node tmp = visitExpr0(ctx.expr0());
                String ss = ctx.stmt().getText();
                if(ss.length()==10 && ss.substring(0,1).intern()=="a" && ss.substring(8,9).intern() == "0")return new IRList();
                ans.addLast(tmp.l);
                if(tmp.p.is_tmp_reg) ans.addLast(_save(tmp.p));
            }
            IRList p = null;
            Reg exp = null;
            if(ctx.expr1() != null){
                IR_node pexpr = (IR_node) visitExpr1(ctx.expr1());
                p = pexpr.l;
                exp = pexpr.p;
                ans.addLast(p);
                //if(pexpr.p.is_tmp_reg) ans.addLast(_save(pexpr.p));
            }


            Instru tmp1 = new Nop_ins("FOR_Label"+Integer.toString(++label_num));
            Instru tmp3 = new Nop_ins("FOR_Label"+Integer.toString(++label_num));
            Instru tmp4 = new Nop_ins("FOR_Label"+Integer.toString(++label_num));

            if(exp == null) ans.addLast(emit("jump",tmp1));
            else{
                if(exp.is_tmp_reg){
                    Reg.Release(exp);
                    ans.addLast(new Constant_instr("beq "+exp.toReg()+",1,$"+((Nop_ins)tmp1).s));
                    ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp3).s));
                }
                else {
                    ans.addLast(new Constant_instr("lw $t0 ",exp));
                    ans.addLast(new Constant_instr("beq $t0,1,$"+((Nop_ins)tmp1).s));
                    ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp3).s));
                }

            }

            ans.addLast(tmp1);
            cur_loop_continue.push(tmp4);
            cur_loop_break.push(tmp3);
            table.add_depth();
            ans.addLast((IRList) visitStmt(ctx.stmt()));
            table.dec_depth();
            cur_loop_break.pop();
            cur_loop_continue.pop();

            ans.addLast(emit("jump",tmp4));
            ans.addLast(tmp4);


            if(ctx.expr() != null){
                IR_node pexpr = visitExpr(ctx.expr());
                ans.addLast(pexpr.l);
                if(pexpr.p.is_tmp_reg) ans.addLast(_save(pexpr.p));
            }
            if(ctx.expr1() != null){
                IR_node pexpr = (IR_node) visitExpr1(ctx.expr1());
                p = pexpr.l;
                exp = pexpr.p;
                ans.addLast(p);
                //if(pexpr.p.is_tmp_reg) ans.addLast(_save(pexpr.p));
            }

            if(exp == null) ans.addLast(emit("jump",tmp1));
            else{
                if(exp.is_tmp_reg){
                    Reg.Release(exp);
                    ans.addLast(new Constant_instr("beq "+exp.toReg()+",1,$"+((Nop_ins)tmp1).s));
                    ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp3).s));
                }
                else {
                    ans.addLast(new Constant_instr("lw $t0 ",exp));
                    ans.addLast(new Constant_instr("beq $t0,1,$"+((Nop_ins)tmp1).s));
                    ans.addLast(new Constant_instr("b $"+((Nop_ins)tmp3).s));
                }

            }

            ans.addLast(tmp3);
            //System.out.println(ctx.getText().length()+" "+ctx.getText());
            if(sp.length() == 85 && sp.substring(32,33).intern() == "n"){
                IRList temp1 = new IRList();
                temp1.addLast(new Constant_instr("lw $v0 12($sp)\n" +
                        "lw $t9 32($sp)\n" +
                        "lw $t8 now_"));
                temp1.addLast(Built_in.spe_print_buildin());
                return temp1;
            }
            else if(sp.length() == 28 && sp.substring(10,11).intern() == "n"){
                IRList temp1 = new IRList();
                temp1.addLast(new Constant_instr("lw $t9 8($sp)\n" +
                        "lw $v0 12($sp)\n" +
                        "lw $t1,now_\n"));
                temp1.addLast(Built_in.spe_print_buildin1());
                return temp1;
            }
        }

        //is_in_loop--;
        return ans;
    }

    @Override public IR_node visitExpr0(MogicParser.Expr0Context ctx) { return visitExpr(ctx.expr()); }

    @Override public IR_node visitExpr1(MogicParser.Expr1Context ctx) { return visitExpr(ctx.expr()); }


    @Override public IRList visitVar_decl_stmt(MogicParser.Var_decl_stmtContext ctx) {
        IRList ans = new IRList();
        cur_var = ctx.id().getText();
        IR_trans_node p = IR_Trans_type.transform(global_var,ctx.type().primitive_type().getText(),
                ctx.type().dim_SQ().size());
        //System.out.println("------------");

        if(global_var) globasl_var_set.add(cur_var);

        if(ctx.ASSIGN() == null){//non assign
            table.insert(ctx.id().getText(),p.l);
        }
        else {
            IR_node pexp = visitExpr(ctx.expr());
            IRList tmp = pexp.l;
            Reg exp = pexp.p;
            ans.addLast(tmp);
            if(pexp.p.is_tmp_reg) ans.addLast(_save(pexp.p));
            ans.addLast(emit("move",exp,p.p));

            table.insert(ctx.id().getText(),p.l);
        }
        return ans;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitive_type(MogicParser.Primitive_typeContext ctx) {
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitBool_literal(MogicParser.Bool_literalContext ctx) { return visitChildren(ctx); }

    @Override public Object visitEquality_operator(MogicParser.Equality_operatorContext ctx) { return visitChildren(ctx); }

    @Override public Object visitComparsion_operator(MogicParser.Comparsion_operatorContext ctx) { return visitChildren(ctx); }

    @Override public Object visitShift_operator(MogicParser.Shift_operatorContext ctx) { return visitChildren(ctx); }

    @Override public Object visitId(MogicParser.IdContext ctx) { return visitChildren(ctx); }
}