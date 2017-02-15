package IR;

import AST.Expression.Constant;
import IR.ILOC.*;

/**
 * Created by xsc on 2016/4/13.
 */


class node{

    Instru instr;
    node next, pre;

    node(){instr = null;next = null;pre = null;}

    node(Instru l,node u,node v){
        instr = l;
        next = v;
        pre = u;
    }
}

public class IRList {

    node head,tail;
    int length;


    public IRList(){
        head = new node();
        tail = new node();
        head.next = tail;
        tail.pre = head;
        length = 0;
    }

    public void addLast(IRList tmp){
        length+=tmp.length;
        tail.pre.next = tmp.head.next;
        tmp.head.next.pre = tail.pre;
        tail = tmp.tail;

    }

    public void addLast(Instru tmp){
        node p = new node(tmp,tail.pre,tail);
        tail.pre.next = p;
        tail.pre = p;
        ++length;
    }


    public void print(){
        if(Create_liner_IR.print_mips){
            print_CISC();
            return;
        }
        node cur_node = head;
        while(true){
            cur_node = cur_node.next;
            if(cur_node == tail) break;

            if(cur_node.instr instanceof Call_instr){
                System.out.print("    ");
                if(((Call_instr)cur_node.instr).re != null){
                    System.out.print("$"+((Call_instr)cur_node.instr).re.addr_num+" = ");
                }
                System.out.print("call "+(((Call_instr) (cur_node.instr)).s));
                for(Reg k : ((Call_instr) (cur_node.instr)).para){
                    System.out.print(" $"+k.addr_num);
                }
                System.out.println();
            }
            else if(cur_node.instr instanceof Instruction){


                System.out.print("    ");
                Instruction ss = (Instruction)cur_node.instr;
                String s = ss.s;
                if(s == "jump"){
                    System.out.println("jump %"+ss.s1.s);
                }
                else if(s == "br"){
                    System.out.println("br $"+ss.r1.addr_num+" %"+ss.s1.s+" %"+ss.s2.s);
                }


                if(s == "ret"){
                    if(ss.r1.imm)System.out.println("ret "+ss.r1.imm_num);
                    else System.out.println("ret $"+ss.r1.addr_num);
                }
                else if(s == "neg"){
                    if(ss.r1.imm)System.out.println("$"+ss.r3.addr_num+" = neg "+ss.r1.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = neg $"+ss.r1.addr_num);
                }
                else if(s == "alloc"){
                    if(ss.r1.imm)System.out.println("$"+ss.r3.addr_num+" = alloc "+ss.r1.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = alloc $"+ss.r1.addr_num);
                }
                else if(s == "move"){
                    if(ss.r1.imm)System.out.println("$"+ss.r3.addr_num+" = move "+ss.r1.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = move $"+ss.r1.addr_num);
                }
                else if(s == "add"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"add $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"add $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "sub"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"sub $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"sub $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "not"){
                    if(ss.r1.imm)System.out.println("$"+ss.r3.addr_num+" = "+"not "+ss.r1.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"not $"+ss.r1.addr_num);
                }
                else if(s == "and"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"and $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"and $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "or"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"or $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"or $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "xor"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"xor $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"xor $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "mul"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"mul $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"mul $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "div"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"div $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"div $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "rem"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"rem $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"rem $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "shl"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"shl $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"shl $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "shr"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"shr $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"shr $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "load"){
                    System.out.println("$"+ss.r3.addr_num+" = "+"load 4 $"+ss.r1.addr_num+" 0");
                }
                else if(s == "store"){
                    System.out.println("store 4 $"+ss.r1.addr_num+" $"+ss.r2.addr_num+" 0");
                }
                else if(s == "slt"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"slt $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"slt $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "sgt"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"sgt $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"sgt $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "sle"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"sle $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"sle $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "sge"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"sge $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"sge $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "seq"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"seq $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"seq $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
                else if(s == "sne"){
                    if(ss.r2.imm)System.out.println("$"+ss.r3.addr_num+" = "+"sne $"+ss.r1.addr_num+" "+ss.r2.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"sne $"+ss.r1.addr_num+" $"+ss.r2.addr_num);
                }
            }
            else if(cur_node.instr instanceof Nop_ins){
                System.out.println("%"+((Nop_ins)cur_node.instr).s+":");
            }
        }
    }
    public void print_CISC(){
        node cur_node = head;
        while(true){
            cur_node = cur_node.next;
            if(cur_node == tail) break;

            if(cur_node.instr instanceof Call_instr){
                //System.out.print("    ");
                if(((Call_instr)cur_node.instr).re != null){
                }
                if((((Call_instr) (cur_node.instr)).s).intern() == "getString"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "println"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "print"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "toString"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "substring"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "StringConcatenate"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "StringEqual"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "StringNotEqual"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "StringGreater"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "StringGreaterEqual"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "StringLess"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "StringLessEqual"||
                        (((Call_instr) (cur_node.instr)).s).intern() == "parseInt"
                        )System.out.println("jal "+(((Call_instr) (cur_node.instr)).s));
                else System.out.println("jal "+(((Call_instr) (cur_node.instr)).s)+"_");
            }
            else if(cur_node.instr instanceof Constant_instr){
                if(((Constant_instr)cur_node.instr)._func){
                    System.out.print(((Constant_instr)cur_node.instr).s);
                    if(((Constant_instr)cur_node.instr).s1.intern() == "main")
                        System.out.println(String.valueOf(Create_liner_IR.func_size.get(((Constant_instr)cur_node.instr).s1.intern())+1000));
                    else System.out.println(String.valueOf(Create_liner_IR.func_size.get(((Constant_instr)cur_node.instr).s1.intern())));
                }
                else{
                    if(((Constant_instr)cur_node.instr)._reg_){
                        System.out.println(((Constant_instr)cur_node.instr).s + ((Constant_instr)cur_node.instr)._reg.addrl());
                    }
                    else if(((Constant_instr)cur_node.instr).pp == 1){

                    }
                    else System.out.println(((Constant_instr)cur_node.instr).s);
                }
            }
            else if(cur_node.instr instanceof Instruction){


                //System.out.print("    ");
                Instruction ss = (Instruction)cur_node.instr;
                String s = ss.s;
                if(s == "jump"){//?
                    System.out.println("b $"+ss.s1.s);
                }
                else if(s == "br"){
                    //System.out.println("br $"+ss.r1.addr_num+" %"+ss.s1.s+" %"+ss.s2.s);
                    System.out.println("lw $t0,"+ss.r1.addrl());
                    System.out.println("beq $t0,1,$"+ss.s1.s);
                    System.out.println("b $"+ss.s2.s);
                }


                if(s == "ret"){//?
                    if(ss.r1 == null){

                    }
                    else if(ss.r1.imm){
                        System.out.println("li $v0,"+ss.r1.imm_num);
                        //System.out.println("jr $ra");
                    }
                    else{
                        System.out.println("lw $v0,"+ss.r1.addrl());
                        //System.out.println("jr $ra");
                    }
                }
                else if(s == "neg"){
                    if(ss.r1.imm){

                        System.out.println("li $t0,"+ss.r1.imm_num);
                        System.out.println("neg $t1,$t0");
                        System.out.println("sw $t1,"+ss.r3.addrl());
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("neg $t1,$t0");
                        System.out.println("sw $t1,"+ss.r3.addrl());
                    }
                }
                else if(s == "alloc"){
                    System.out.println("li $v0,9");
                    if(ss.r1.imm)System.out.println("li $a0,"+ss.r1.imm_num);
                    else System.out.println("lw $a0,"+ss.r1.addrl());
                    System.out.println("syscall");
                    System.out.println("sw $v0,"+ss.r3.addrl());

                }
                else if(s == "move"){
                    if(ss.r1.imm){
                        System.out.println("li $t0,"+ss.r1.imm_num);
                        System.out.println("sw $t0,"+ss.r3.addrl());
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("sw $t0,"+ss.r3.addrl());
                    }
                }
                else if(s == "add"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("add $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("add $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "sub"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("sub $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("sub $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "not"){
                    if(ss.r1.imm)System.out.println("$"+ss.r3.addr_num+" = "+"not "+ss.r1.imm_num);
                    else System.out.println("$"+ss.r3.addr_num+" = "+"not $"+ss.r1.addr_num);
                }
                else if(s == "and"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("and $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("and $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "or"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("or $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("or $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "xor"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("xor $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("xor $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "mul"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("mul $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("mul $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "div"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("div $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("div $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "rem"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("rem $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("rem $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "shl"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("sll $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("sll $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "shr"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("srl $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("srl $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "_load"){
                    System.out.println("lw $t0,"+ss.r1.addrl());
                    System.out.println("lw $t0,($t0)");
                    System.out.println("sw $t0,"+ss.r3.addrl());
                }
                else if(s == "load"){
                    System.out.println("lw $t0,"+ss.r1.addrl());
                    System.out.println("sw $t0,"+ss.r3.addrl());
                }
                else if(s == "store"){
                    System.out.println("lw $t0,"+ss.r2.addrl());
                    System.out.println("lw $t1,"+ss.r1.addrl());
                    System.out.println("sw $t0,($t1)");
                }
                else if(s == "slt"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("slt $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("slt $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "sgt"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("sgt $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("sgt $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "sle"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("sle $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("sle $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "sge"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("sge $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("sge $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "seq"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("seq $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("seq $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
                else if(s == "sne"){
                    if(ss.r2.imm) {
                        System.out.println("lw $t0," + ss.r1.addrl());
                        System.out.println("sne $t2,$t0," + ss.r2.imm_num);
                    }
                    else{
                        System.out.println("lw $t0,"+ss.r1.addrl());
                        System.out.println("lw $t1,"+ss.r2.addrl());
                        System.out.println("sne $t2,$t0,$t1");
                    }
                    System.out.println("sw $t2," + ss.r3.addrl());
                }
            }
            else if(cur_node.instr instanceof Nop_ins){
                System.out.println("$"+((Nop_ins)cur_node.instr).s+":");
            }
        }
    }

}
