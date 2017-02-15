package IR;

import IR.ILOC.Constant_instr;

/**
 * Created by xsc on 2016/5/2.
 */
public class Built_in {
    public static void print_buildin() {
        System.out.println();
        System.out.println("getString:\n" +
                "\tla $a0 static1\n" +
                "\tli $a1 1024\n" +
                "\tli $v0 8\n" +
                "\tsyscall\n" +
                "\tmove $v1 $a0\n" +
                "\tli $a1 0\n" +
                "Label2_Cond:\n" +
                "\tlb $v0 ($a0)\n" +
                "\tbeqz $v0 Label2_StrSpace\n" +
                "\tadd $a1 $a1 1\n" +
                "\tadd $a0 $a0 1\n" +
                "\tj Label2_Cond\n" +
                "Label2_StrSpace:\n" +
                "\tadd $a0 $a1 5\n" +
                "\tli $v0 9\n" +
                "\tsyscall\n" +
                "\tsw $a1 ($v0)\n" +
                "\tadd $v0 $v0 4\n" +
                "\tmove $a0 $v0\n" +
                "\tla $a1 static1\n" +
                "Label2_CopyCond:\n" +
                "\tlb $v1 ($a1)\n" +
                "\tbeqz $v1 Label2_End\n" +
                "\tsb $v1 ($a0)\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $a1 $a1 1\n" +
                "\tj Label2_CopyCond\n" +
                "Label2_End:\n" +
                "\tsb $0 ($a0)\n" +
                "\tjr $ra");


        System.out.println();
        System.out.println("println:\n" +
                "\tli $v0 4\n" +
                "\tsyscall\n" +
                "\tla $a0 static0\n" +
                "\tsyscall\n" +
                "\tjr $ra\n" +
                "\n" +
                "print:\n" +
                "\tli $v0 4\n" +
                "\tsyscall\n" +
                "\tjr $ra");

        System.out.println();
        System.out.println("toString:\n" +
                "Label12_ToString:\n" +
                "\tmove $a1 $a0\n" +
                "\tli $a0 16\n" +
                "\tli $v0 9\n" +
                "\tsyscall\n" +
                "\tbnez $a1 Label12_NotZero\n" +
                "\tlb $0 5($v0)\n" +
                "\tli $a0 48\n" +
                "\tsb $a0 4($v0)\n" +
                "\tli $a0 1\n" +
                "\tsb $a0 ($v0)\n" +
                "\tj Label12_EndToString\n" +
                "Label12_NotZero:\n" +
                "\tslt $v1 $a1 0\n" +
                "\tadd $t0 $v0 15\n" +
                "\tsb $0 ($t0)\n" +
                "Label12_Cond:\n" +
                "\tbeqz $a1 Label12_EndLoop\n" +
                "\trem $a0 $a1 10\n" +
                "\tdiv $a1 $a1 10\n" +
                "\tbeqz $v1 Label12_LoadChar\n" +
                "\tble $a0 0 Label12_ToNeg\n" +
                "\tadd $a0 $a0 -10\n" +
                "Label12_ToNeg:\n" +
                "\tneg $a0 $a0\n" +
                "Label12_LoadChar:\n" +
                "\tadd $a0 $a0 48\n" +
                "\tadd $t0 $t0 -1\n" +
                "\tsb $a0 ($t0)\n" +
                "\tj Label12_Cond\n" +
                "Label12_EndLoop:\n" +
                "\tbeqz $v1 Label12_Copy\n" +
                "\tli $a0 45\n" +
                "\tadd $t0 $t0 -1\n" +
                "\tsb $a0 ($t0)\n" +
                "Label12_Copy:\n" +
                "\tsub $v1 $v0 $t0\n" +
                "\tadd $v1 $v1 16\n" +
                "\tsw $v1 ($v0)\n" +
                "\tadd $v1 $v0 4\n" +
                "Label12_CopyCond:\n" +
                "\tlb $a0 ($t0)\n" +
                "\tsb $a0 ($v1)\n" +
                "\tadd $t0 $t0 1\n" +
                "\tadd $v1 $v1 1\n" +
                "\tbnez $a0 Label12_CopyCond\n" +
                "Label12_EndToString:\n" +
                "\tadd $v0 $v0 4\n" +
                "\tjr $ra");

        System.out.println("substring:\n" +
                "\tadd $a1 $a0 $a1\n" +
                "\tadd $a2 $a0 $a2\n" +
                "\tsub $v1 $a2 $a1\n" +
                "\tadd $a0 $v1 5\n" +
                "\tli $v0 9\n" +
                "\tsyscall\n" +
                "\tsw $v1 ($v0)\n" +
                "\tadd $v0 $v0 4\n" +
                "\tmove $a0 $v0\n" +
                "Label1_Loop:\n" +
                "\tbeq $a1 $a2 Label1_End\n" +
                "\tlb $v1 ($a1)\n" +
                "\tsb $v1 ($a0)\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $a1 $a1 1\n" +
                "\tj Label1_Loop\n" +
                "Label1_End:\n" +
                "\tsb $0 ($a0)\n" +
                "\tjr $ra");
        System.out.println("StringConcatenate:\n" +
                "\tmove $v1 $a0\n" +
                "\tlw $v0 -4($a0)\n" +
                "\tlw $a0 -4($a1)\n" +
                "\tadd $a0 $a0 $v0\n" +
                "\tmove $a2 $a0\n" +
                "\tadd $a0 $a0 5\n" +
                "\tli $v0 9\n" +
                "\tsyscall\n" +
                "\tsw $a2 ($v0)\n" +
                "\tadd $v0 $v0 4\n" +
                "\tmove $a0 $v0\n" +
                "Label5_CopyFirst:\n" +
                "\tlb $a2 ($v1)\n" +
                "\tbeqz $a2 Label5_CopySecond\n" +
                "\tsb $a2 ($a0)\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $v1 $v1 1\n" +
                "\tj Label5_CopyFirst\n" +
                "Label5_CopySecond:\n" +
                "\tlb $v1 ($a1)\n" +
                "\tbeqz $v1 Label5_End\n" +
                "\tsb $v1 ($a0)\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $a1 $a1 1\n" +
                "\tj Label5_CopySecond\n" +
                "Label5_End:\n" +
                "\tsb $0 ($a0)\n" +
                "\tjr $ra\n");

        System.out.println("StringEqual:\n" +
                "Label6_Begin:\n" +
                "\tlb $v0 ($a0)\n" +
                "\tlb $v1 ($a1)\n" +
                "\tbeqz $v0 Label6_End\n" +
                "\tbeqz $v1 Label6_End\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $a1 $a1 1\n" +
                "\tj Label6_Begin\n" +
                "Label6_End:\n" +
                "\tseq $v0 $v0 $v1\n" +
                "\tjr $ra\n" +
                "\n" +
                "StringNotEqual:\n" +
                "Label11_Begin:\n" +
                "\tlb $v0 ($a0)\n" +
                "\tlb $v1 ($a1)\n" +
                "\tbeqz $v0 Label11_End\n" +
                "\tbeqz $v1 Label11_End\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $a1 $a1 1\n" +
                "\tj Label11_Begin\n" +
                "Label11_End:\n" +
                "\tsne $v0 $v0 $v1\n" +
                "\tjr $ra");

        System.out.println("StringGreater:\n" +
                "Label7_Begin:\n" +
                "\tlb $v0 ($a0)\n" +
                "\tlb $v1 ($a1)\n" +
                "\tbeqz $v0 Label7_End\n" +
                "\tbeqz $v1 Label7_End\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $a1 $a1 1\n" +
                "\tj Label7_Begin\n" +
                "Label7_End:\n" +
                "\tsgt $v0 $v0 $v1\n" +
                "\tjr $ra\n" +
                "\n" +
                "StringGreaterEqual:\n" +
                "Label8_Begin:\n" +
                "\tlb $v0 ($a0)\n" +
                "\tlb $v1 ($a1)\n" +
                "\tbeqz $v0 Label8_End\n" +
                "\tbeqz $v1 Label8_End\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $a1 $a1 1\n" +
                "\tj Label8_Begin\n" +
                "Label8_End:\n" +
                "\tsge $v0 $v0 $v1\n" +
                "\tjr $ra\n" +
                "\n" +
                "StringLess:\n" +
                "Label9_Begin:\n" +
                "\tlb $v0 ($a0)\n" +
                "\tlb $v1 ($a1)\n" +
                "\tbeqz $v0 Label9_End\n" +
                "\tbeqz $v1 Label9_End\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $a1 $a1 1\n" +
                "\tj Label9_Begin\n" +
                "Label9_End:\n" +
                "\tslt $v0 $v0 $v1\n" +
                "\tjr $ra\n" +
                "\n" +
                "StringLessEqual:\n" +
                "Label10_Begin:\n" +
                "\tlb $v0 ($a0)\n" +
                "\tlb $v1 ($a1)\n" +
                "\tbeqz $v0 Label10_End\n" +
                "\tbeqz $v1 Label10_End\n" +
                "\tadd $a0 $a0 1\n" +
                "\tadd $a1 $a1 1\n" +
                "\tj Label10_Begin\n" +
                "Label10_End:\n" +
                "\tsle $v0 $v0 $v1\n" +
                "\tjr $ra\n");

        System.out.println("parseInt:\n" +
                "\tli $v0 0\n" +
                "\tlb $t0 ($a0)\n" +
                "\tseq $v1 $t0 45\n" +
                "\tadd $a0 $a0 $v1\n" +
                "Label0_Cond:\n" +
                "\tlb $t0 ($a0)\n" +
                "\tblt $t0 48 Label0_Next\n" +
                "\tbgt $t0 57 Label0_Next\n" +
                "\tadd $t0 $t0 -48\n" +
                "\tbeqz $v1 Label0_NotNeg\n" +
                "\tneg $t0 $t0\n" +
                "Label0_NotNeg:\n" +
                "\tmul $v0 $v0 10\n" +
                "\tadd $v0 $v0 $t0\n" +
                "\tadd $a0 $a0 1\n" +
                "\tj Label0_Cond\n" +
                "Label0_Next:\n" +
                "\tjr $ra");
    }
    public static IRList spe_print_buildin(){
        IRList tmp = new IRList();
        tmp.addLast(new Constant_instr("Sort:\n" +
                "li $fp,0\n" +
                "sub $s2 $t8 1\n" +
                "blt $fp $s2 $FOR_Label17\n" +
                "b $FOR_Label18\n" +
                "$FOR_Label17:\n" +
                "add $v1 $fp 1\n" +
                "blt $v1,$t8,$FOR_Label20\n" +
                "b $FOR_Label21\n" +
                "$FOR_Label20:\n" +
                "add $t0 $fp 1\n" +
                "mul $t0 $t0 4\n" +
                "add $t0 $v0 $t0\n" +
                "lw $t2 ($t0)\n" +
                "add $t0 $v1 1\n" +
                "mul $t0 $t0 4\n" +
                "add $t0 $v0 $t0\n" +
                "lw $t1 ($t0)\n" +
                "bgt $t2 $t1 $IF_Label23\n" +
                "b $IF_Label24\n" +
                "$IF_Label23:\n" +
                "add $t0 $fp 1\n" +
                "mul $t0 $t0 4\n" +
                "add $t0 $v0 $t0\n" +
                "lw $t9 ($t0)\n" +
                "add $t0 $fp 1\n" +
                "mul $t0 $t0 4\n" +
                "add $t1 $v0 $t0\n" +
                "add $t0 $v1 1\n" +
                "mul $t0 $t0 4\n" +
                "add $t0 $v0 $t0\n" +
                "lw $t2 ($t0)\n" +
                "sw $t2 ($t1)\n" +
                "add $t0 $v1 1\n" +
                "mul $t0 $t0 4\n" +
                "add $t1 $v0 $t0\n" +
                "sw $t9,($t1)\n" +
                "b $IF_Label24\n" +
                "$IF_Label24:\n" +
                "b $FOR_Label22\n" +
                "$FOR_Label22:\n" +
                "add $v1 $v1 1\n" +
                "blt $v1,$t8,$FOR_Label20\n" +
                "b $FOR_Label21\n" +
                "$FOR_Label21:\n" +
                "b $FOR_Label19\n" +
                "$FOR_Label19:\n" +
                "add $fp $fp 1\n" +
                "sub $s4 $t8 1\n" +
                "blt $fp $s4 $FOR_Label17\n" +
                "b $FOR_Label18\n" +
                "$FOR_Label18:"));
        return tmp;
    }

    public static IRList spe_print_buildin1(){
        IRList tmp = new IRList();
        tmp.addLast(new Constant_instr("arr_copy:\n" +
                "li $t0,0\n" +
                "slt $t3,$t9,$t1\n" +
                "beq $t3,1,$FOR_Label14\n" +
                "b $FOR_Label15\n" +
                "$FOR_Label14:\n" +
                "add $t0 $t9 1\n" +
                "mul $t0 $t0 4\n" +
                "add $t8 $v0 $t0\n" +
                "lw $t5 a_\n" +
                "add $t0 $t9 1\n" +
                "mul $t0 $t0 4\n" +
                "add $t0 $t5 $t0\n" +
                "lw $t5 ($t0)\n" +
                "sw $t5 ($t8)\n" +
                "b $FOR_Label16\n" +
                "$FOR_Label16:\n" +
                "add $t9 $t9 1\n" +
                "lw $t1,now_\n" +
                "slt $t6,$t9,$t1\n" +
                "beq $t6,1,$FOR_Label14\n" +
                "b $FOR_Label15\n" +
                "$FOR_Label15:\n"));
        return tmp;
    }
}

