.text
.globl main

getHash_: 
subu $sp,$sp,24
sw $ra,0($sp)
 
lw $t0,20($sp)
mul $t4 $t0 237
sw $t4 4($sp)
lw $t0,4($sp)
lw $t1,hashsize_
rem $t2,$t0,$t1
sw $t2,8($sp)
lw $v0,8($sp)
lw $ra,0($sp)
addu $sp,$sp,24
jr $ra
 
lw $ra,0($sp)
addu $sp,$sp,24
jr $ra
get_: 
subu $sp,$sp,72
sw $ra,0($sp)
 
li $t0,0
sw $t0,4($sp)
lw $t5 table_
lw $t0,68($sp)
sw $t0,-4($sp)
jal getHash_
sw $v0,16($sp)
lw $t0 16($sp)
add $t0 $t0 1
mul $t0 $t0 4
add $t0 $t5 $t0
sw $t0 8($sp)
lw $t5 ($t0)
sw $t5 4($sp)
lw $t1 4($sp)
add $t1 $t1 8
lw $t0 ($t1)
sw $t0 20($sp)
sw $t1 24($sp)
lw $t0,20($sp)
lw $t1,68($sp)
sne $t6,$t0,$t1
beq $t6,1,$WHILE_Label8
b $WHILE_Label10
$WHILE_Label8:
lw $t1 4($sp)
add $t1 $t1 0
lw $t0 ($t1)
sw $t0 32($sp)
sw $t1 36($sp)
lw $t0,32($sp)
sw $t0,4($sp)
b $WHILE_Label9
$WHILE_Label9:
lw $t1 4($sp)
add $t1 $t1 8
lw $t0 ($t1)
sw $t0 40($sp)
sw $t1 44($sp)
lw $t0,40($sp)
lw $t1,68($sp)
sne $t7,$t0,$t1
beq $t7,1,$WHILE_Label8
b $WHILE_Label10
$WHILE_Label10:
lw $t1 4($sp)
add $t1 $t1 4
lw $t0 ($t1)
sw $t0 52($sp)
sw $t1 56($sp)
lw $v0,52($sp)
lw $ra,0($sp)
addu $sp,$sp,72
jr $ra
 
lw $ra,0($sp)
addu $sp,$sp,72
jr $ra
main: 
subu $sp,$sp,1100
sw $ra,0($sp)
 
li $t0,100
sw $t0,hashsize_
li $t0,100
sw $t0,12($sp)
lw $t0,12($sp)
add $t2,$t0,1
sw $t2,8($sp)
lw $t0,8($sp)
mul $t2,$t0,4
sw $t2,8($sp)
li $v0,9
lw $a0,8($sp)
syscall
sw $v0,16($sp)
li $t0,100
sw $t0,20($sp)
lw $t0,20($sp)
lw $t1,16($sp)
sw $t0,($t1)
lw $t0,16($sp)
sw $t0,table_
li $t0,0
sw $t0,4($sp)
lw $t0,4($sp)
lw $t1,hashsize_
slt $s2,$t0,$t1
beq $s2,1,$FOR_Label11
b $FOR_Label12
$FOR_Label11:
lw $s3 table_
lw $t0 4($sp)
add $t0 $t0 1
mul $t0 $t0 4
add $t0 $s3 $t0
sw $t0 28($sp)
lw $s3 ($t0)
sw $s3 32($sp)
li $t0,0
lw $t1,28($sp)
sw $t0,($t1)
b $FOR_Label13
$FOR_Label13:
lw $t0,4($sp)
sw $t0,36($sp)
add $t0 $t0 1
sw $t0 4($sp)
lw $t0,4($sp)
lw $t1,hashsize_
slt $s4,$t0,$t1
beq $s4,1,$FOR_Label11
b $FOR_Label12
$FOR_Label12:
li $t0,0
sw $t0,4($sp)
lw $t0,4($sp)
slt $s5,$t0,1000
beq $s5,1,$FOR_Label14
b $FOR_Label15
$FOR_Label14:
b $FOR_Label16
$FOR_Label16:
lw $t0,4($sp)
sw $t0,52($sp)
add $t0 $t0 1
sw $t0 4($sp)
lw $t0,4($sp)
slt $s6,$t0,1000
beq $s6,1,$FOR_Label14
b $FOR_Label15
$FOR_Label15:
li $t0,0
sw $t0,4($sp)
lw $t0,4($sp)
slt $t3,$t0,1000
beq $t3,1,$FOR_Label17
b $FOR_Label18
$FOR_Label17:
lw $t0,4($sp)
sw $t0,-4($sp)
lw $a0,4($sp)
jal toString
sw $v0,64($sp)
la $t0 String1
sb $0 1($t0)
sw $t0 68($sp)
lw $a0 64($sp)
lw $a1 68($sp)
jal StringConcatenate
sw $v0 72($sp)
lw $t0,4($sp)
sw $t0,-4($sp)
lw $a0,4($sp)
jal toString
sw $v0,76($sp)
lw $a0 72($sp)
lw $a1 76($sp)
jal StringConcatenate
sw $v0 80($sp)
lw $t0,80($sp)
sw $t0,-4($sp)
lw $a0,80($sp)
jal println
b $FOR_Label19
$FOR_Label19:
lw $t0,4($sp)
sw $t0,84($sp)
add $t0 $t0 1
sw $t0 4($sp)
lw $t0,4($sp)
slt $t4,$t0,1000
beq $t4,1,$FOR_Label17
b $FOR_Label18
$FOR_Label18:
li $v0,0
lw $ra,0($sp)
addu $sp,$sp,1100
jr $ra
 
lw $ra,0($sp)
addu $sp,$sp,1100
jr $ra
put_: 
subu $sp,$sp,208
sw $ra,0($sp)
 
li $t0,0
sw $t0,8($sp)
lw $t0,204($sp)
sw $t0,-4($sp)
jal getHash_
sw $v0,12($sp)
lw $t0,12($sp)
sw $t0,4($sp)
lw $t5 table_
lw $t0 4($sp)
add $t0 $t0 1
mul $t0 $t0 4
add $t0 $t5 $t0
sw $t0 16($sp)
lw $t5 ($t0)
seq $t6 $t5 0
beq $t6,1,$IF_Label1
b $IF_Label2
$IF_Label1:
lw $t7 table_
lw $t0 4($sp)
add $t0 $t0 1
mul $t0 $t0 4
add $t0 $t7 $t0
sw $t0 28($sp)
lw $t7 ($t0)
sw $t7 32($sp)
li $v0,9
li $a0,12
syscall
sw $v0,36($sp)
lw $t0,36($sp)
lw $t1,28($sp)
sw $t0,($t1)
lw $s2 table_
lw $t0 4($sp)
add $t0 $t0 1
mul $t0 $t0 4
add $t0 $s2 $t0
sw $t0 40($sp)
lw $s2 ($t0)
move $t1 $s2
add $t1 $t1 8
lw $t0 ($t1)
sw $t0 48($sp)
sw $t1 52($sp)
lw $t0,204($sp)
lw $t1,52($sp)
sw $t0,($t1)
lw $s3 table_
lw $t0 4($sp)
add $t0 $t0 1
mul $t0 $t0 4
add $t0 $s3 $t0
sw $t0 56($sp)
lw $s3 ($t0)
move $t1 $s3
add $t1 $t1 4
lw $t0 ($t1)
sw $t0 64($sp)
sw $t1 68($sp)
lw $t0,200($sp)
lw $t1,68($sp)
sw $t0,($t1)
lw $s4 table_
lw $t0 4($sp)
add $t0 $t0 1
mul $t0 $t0 4
add $t0 $s4 $t0
sw $t0 72($sp)
lw $s4 ($t0)
move $t1 $s4
add $t1 $t1 0
lw $t0 ($t1)
sw $t0 80($sp)
sw $t1 84($sp)
li $t0,0
lw $t1,84($sp)
sw $t0,($t1)
lw $ra,0($sp)
addu $sp,$sp,208
jr $ra
b $IF_Label2
$IF_Label2:
lw $s5 table_
lw $t0 4($sp)
add $t0 $t0 1
mul $t0 $t0 4
add $t0 $s5 $t0
sw $t0 88($sp)
lw $s5 ($t0)
sw $s5 8($sp)
lw $t1 8($sp)
add $t1 $t1 8
lw $t0 ($t1)
sw $t0 96($sp)
sw $t1 100($sp)
lw $t0,96($sp)
lw $t1,204($sp)
sne $s6,$t0,$t1
beq $s6,1,$WHILE_Label3
b $WHILE_Label5
$WHILE_Label3:
lw $t1 8($sp)
add $t1 $t1 0
lw $t0 ($t1)
sw $t0 108($sp)
sw $t1 112($sp)
lw $t0,108($sp)
seq $t3,$t0,0
beq $t3,1,$IF_Label6
b $IF_Label7
$IF_Label6:
lw $t1 8($sp)
add $t1 $t1 0
lw $t0 ($t1)
sw $t0 120($sp)
sw $t1 124($sp)
li $v0,9
li $a0,12
syscall
sw $v0,128($sp)
lw $t0,128($sp)
lw $t1,124($sp)
sw $t0,($t1)
lw $t1 8($sp)
add $t1 $t1 0
lw $t0 ($t1)
sw $t0 132($sp)
sw $t1 136($sp)
lw $t1 132($sp)
add $t1 $t1 8
lw $t0 ($t1)
sw $t0 140($sp)
sw $t1 144($sp)
lw $t0,204($sp)
lw $t1,144($sp)
sw $t0,($t1)
lw $t1 8($sp)
add $t1 $t1 0
lw $t0 ($t1)
sw $t0 148($sp)
sw $t1 152($sp)
lw $t1 148($sp)
add $t1 $t1 0
lw $t0 ($t1)
sw $t0 156($sp)
sw $t1 160($sp)
li $t0,0
lw $t1,160($sp)
sw $t0,($t1)
b $IF_Label7
$IF_Label7:
lw $t1 8($sp)
add $t1 $t1 0
lw $t0 ($t1)
sw $t0 164($sp)
sw $t1 168($sp)
lw $t0,164($sp)
sw $t0,8($sp)
b $WHILE_Label4
$WHILE_Label4:
lw $t1 8($sp)
add $t1 $t1 8
lw $t0 ($t1)
sw $t0 172($sp)
sw $t1 176($sp)
lw $t0,172($sp)
lw $t1,204($sp)
sne $t4,$t0,$t1
beq $t4,1,$WHILE_Label3
b $WHILE_Label5
$WHILE_Label5:
lw $t1 8($sp)
add $t1 $t1 4
lw $t0 ($t1)
sw $t0 184($sp)
sw $t1 188($sp)
lw $t0,200($sp)
lw $t1,188($sp)
sw $t0,($t1)
 
lw $ra,0($sp)
addu $sp,$sp,208
jr $ra

getString:
	la $a0 static1
	li $a1 1024
	li $v0 8
	syscall
	move $v1 $a0
	li $a1 0
Label2_Cond:
	lb $v0 ($a0)
	beqz $v0 Label2_StrSpace
	add $a1 $a1 1
	add $a0 $a0 1
	j Label2_Cond
Label2_StrSpace:
	add $a0 $a1 5
	li $v0 9
	syscall
	sw $a1 ($v0)
	add $v0 $v0 4
	move $a0 $v0
	la $a1 static1
Label2_CopyCond:
	lb $v1 ($a1)
	beqz $v1 Label2_End
	sb $v1 ($a0)
	add $a0 $a0 1
	add $a1 $a1 1
	j Label2_CopyCond
Label2_End:
	sb $0 ($a0)
	jr $ra

println:
	li $v0 4
	syscall
	la $a0 static0
	syscall
	jr $ra

print:
	li $v0 4
	syscall
	jr $ra

toString:
Label12_ToString:
	move $a1 $a0
	li $a0 16
	li $v0 9
	syscall
	bnez $a1 Label12_NotZero
	lb $0 5($v0)
	li $a0 48
	sb $a0 4($v0)
	li $a0 1
	sb $a0 ($v0)
	j Label12_EndToString
Label12_NotZero:
	slt $v1 $a1 0
	add $t0 $v0 15
	sb $0 ($t0)
Label12_Cond:
	beqz $a1 Label12_EndLoop
	rem $a0 $a1 10
	div $a1 $a1 10
	beqz $v1 Label12_LoadChar
	ble $a0 0 Label12_ToNeg
	add $a0 $a0 -10
Label12_ToNeg:
	neg $a0 $a0
Label12_LoadChar:
	add $a0 $a0 48
	add $t0 $t0 -1
	sb $a0 ($t0)
	j Label12_Cond
Label12_EndLoop:
	beqz $v1 Label12_Copy
	li $a0 45
	add $t0 $t0 -1
	sb $a0 ($t0)
Label12_Copy:
	sub $v1 $v0 $t0
	add $v1 $v1 16
	sw $v1 ($v0)
	add $v1 $v0 4
Label12_CopyCond:
	lb $a0 ($t0)
	sb $a0 ($v1)
	add $t0 $t0 1
	add $v1 $v1 1
	bnez $a0 Label12_CopyCond
Label12_EndToString:
	add $v0 $v0 4
	jr $ra
substring:
	add $a1 $a0 $a1
	add $a2 $a0 $a2
	sub $v1 $a2 $a1
	add $a0 $v1 5
	li $v0 9
	syscall
	sw $v1 ($v0)
	add $v0 $v0 4
	move $a0 $v0
Label1_Loop:
	beq $a1 $a2 Label1_End
	lb $v1 ($a1)
	sb $v1 ($a0)
	add $a0 $a0 1
	add $a1 $a1 1
	j Label1_Loop
Label1_End:
	sb $0 ($a0)
	jr $ra
StringConcatenate:
	move $v1 $a0
	lw $v0 -4($a0)
	lw $a0 -4($a1)
	add $a0 $a0 $v0
	move $a2 $a0
	add $a0 $a0 5
	li $v0 9
	syscall
	sw $a2 ($v0)
	add $v0 $v0 4
	move $a0 $v0
Label5_CopyFirst:
	lb $a2 ($v1)
	beqz $a2 Label5_CopySecond
	sb $a2 ($a0)
	add $a0 $a0 1
	add $v1 $v1 1
	j Label5_CopyFirst
Label5_CopySecond:
	lb $v1 ($a1)
	beqz $v1 Label5_End
	sb $v1 ($a0)
	add $a0 $a0 1
	add $a1 $a1 1
	j Label5_CopySecond
Label5_End:
	sb $0 ($a0)
	jr $ra

StringEqual:
Label6_Begin:
	lb $v0 ($a0)
	lb $v1 ($a1)
	beqz $v0 Label6_End
	beqz $v1 Label6_End
	add $a0 $a0 1
	add $a1 $a1 1
	j Label6_Begin
Label6_End:
	seq $v0 $v0 $v1
	jr $ra

StringNotEqual:
Label11_Begin:
	lb $v0 ($a0)
	lb $v1 ($a1)
	beqz $v0 Label11_End
	beqz $v1 Label11_End
	add $a0 $a0 1
	add $a1 $a1 1
	j Label11_Begin
Label11_End:
	sne $v0 $v0 $v1
	jr $ra
StringGreater:
Label7_Begin:
	lb $v0 ($a0)
	lb $v1 ($a1)
	beqz $v0 Label7_End
	beqz $v1 Label7_End
	add $a0 $a0 1
	add $a1 $a1 1
	j Label7_Begin
Label7_End:
	sgt $v0 $v0 $v1
	jr $ra

StringGreaterEqual:
Label8_Begin:
	lb $v0 ($a0)
	lb $v1 ($a1)
	beqz $v0 Label8_End
	beqz $v1 Label8_End
	add $a0 $a0 1
	add $a1 $a1 1
	j Label8_Begin
Label8_End:
	sge $v0 $v0 $v1
	jr $ra

StringLess:
Label9_Begin:
	lb $v0 ($a0)
	lb $v1 ($a1)
	beqz $v0 Label9_End
	beqz $v1 Label9_End
	add $a0 $a0 1
	add $a1 $a1 1
	j Label9_Begin
Label9_End:
	slt $v0 $v0 $v1
	jr $ra

StringLessEqual:
Label10_Begin:
	lb $v0 ($a0)
	lb $v1 ($a1)
	beqz $v0 Label10_End
	beqz $v1 Label10_End
	add $a0 $a0 1
	add $a1 $a1 1
	j Label10_Begin
Label10_End:
	sle $v0 $v0 $v1
	jr $ra

parseInt:
	li $v0 0
	lb $t0 ($a0)
	seq $v1 $t0 45
	add $a0 $a0 $v1
Label0_Cond:
	lb $t0 ($a0)
	blt $t0 48 Label0_Next
	bgt $t0 57 Label0_Next
	add $t0 $t0 -48
	beqz $v1 Label0_NotNeg
	neg $t0 $t0
Label0_NotNeg:
	mul $v0 $v0 10
	add $v0 $v0 $t0
	add $a0 $a0 1
	j Label0_Cond
Label0_Next:
	jr $ra

.data
hashsize_: .space 4
table_: .space 4
static0: .asciiz "\n"
static1: .space 1024
.word 1
String1: .ascii " "
.word 0
