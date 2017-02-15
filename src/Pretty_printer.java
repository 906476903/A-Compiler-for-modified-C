/**
 * Created by xsc on 2016/4/10.
 */
import AST.AST_VISIT.*;
import AST.VarType.*;
import Error_handle.Error_msg;
import gen.MogicBaseVisitor;
import gen.MogicParser;

import java.util.*;

public class Pretty_printer extends MogicBaseVisitor<Object> {




    Table table = visit_zero.table;
    Class_table class_table = visit_zero.class_table;
    Set<String> Class_set = visit_zero.Class_set;
    String current_func;
    int is_in_loop;
    boolean func_para_loaded;

    @Override public Object visitMogic_pro(MogicParser.Mogic_proContext ctx) {

        visitChildren(ctx);

        Object s = table.lookup("main");

        if(s == null || (!(s instanceof Function_type)) ){
            Error_msg Err = new Error_msg();
            Err.complain("Need main method.");
        }
        else if(!(((Function_type)s).Return_type instanceof Integer_type)){
            Error_msg Err = new Error_msg();
            Err.complain("main method need int return type.");
        }

        return null;
    }

    @Override public Object visitProgram(MogicParser.ProgramContext ctx) {
        if(ctx.class_decl() != null){
            visitClass_decl(ctx.class_decl());
            if(ctx.program() != null) visitProgram(ctx.program());
        }
        else if(ctx.func_decl() != null){
            //ans.addLast((IRList)visitFunc_decl(ctx.func_decl()));
            visitFunc_decl(ctx.func_decl());
            if(ctx.program() != null) visitProgram(ctx.program());
        }
        else if(ctx.var_decl_stmt() != null){
            visitVar_decl_stmt(ctx.var_decl_stmt());
            if(ctx.program() != null) visitProgram(ctx.program());
        }
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitClass_decl(MogicParser.Class_declContext ctx) {
        System.out.println("class "+ctx.id().getText()+" {");
        visitMember_decl_list(ctx.member_decl_list());
        System.out.println("}");
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitMember_decl_list(MogicParser.Member_decl_listContext ctx) {
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMember_decl(MogicParser.Member_declContext ctx) {
        System.out.println("    "+ctx.type().getText()+" "+ctx.id().getText()+";");
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitFunc_decl(MogicParser.Func_declContext ctx) {
        System.out.print(ctx.type().getText()+" "+ctx.id().getText()+"(");
        if(ctx.parameter_list()!=null) visitParameter_list(ctx.parameter_list());
        System.out.println(")");
        visitBlock_stmt(ctx.block_stmt());
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitParameter_list(MogicParser.Parameter_listContext ctx) {
        System.out.print(ctx.type().getText()+" "+ctx.id().getText());
        if(ctx.COMMA()!=null) System.out.println(",");
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
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
    @Override public Object visitExpr(MogicParser.ExprContext ctx) {
        return visitAssignment_expr(ctx.assignment_expr());

    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitLogic_or_expr(MogicParser.Logic_or_exprContext ctx) {
        if(ctx.logic_or_expr() == null){
            return visitLogic_and_expr(ctx.logic_and_expr());
        }

        visitLogic_or_expr(ctx.logic_or_expr());
        System.out.print(" || ");
        visitLogic_and_expr(ctx.logic_and_expr());

        return new Bool_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitLogic_and_expr(MogicParser.Logic_and_exprContext ctx) {
        if(ctx.logic_and_expr() == null){
            return visitInclusive_or_expr(ctx.inclusive_or_expr());
        }

        visitLogic_and_expr(ctx.logic_and_expr());
        System.out.print(" && ");
        visitInclusive_or_expr(ctx.inclusive_or_expr());

        return new Bool_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitInclusive_or_expr(MogicParser.Inclusive_or_exprContext ctx) {
        if(ctx.inclusive_or_expr() == null){
            return visitExclusive_or_expr(ctx.exclusive_or_expr());
        }

        Object l = visitInclusive_or_expr(ctx.inclusive_or_expr());
        System.out.print(" | ");
        Object r = visitExclusive_or_expr(ctx.exclusive_or_expr());

        return new Integer_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExclusive_or_expr(MogicParser.Exclusive_or_exprContext ctx) {
        if(ctx.exclusive_or_expr() == null){
            return visitAnd_expr(ctx.and_expr());
        }

        Object l = visitExclusive_or_expr(ctx.exclusive_or_expr());
        System.out.print(" ^ ");
        Object r = visitAnd_expr(ctx.and_expr());

        return new Integer_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAnd_expr(MogicParser.And_exprContext ctx) {
        if(ctx.and_expr() == null){
            return visitEqu_expr(ctx.equ_expr());
        }

        Object l = visitAnd_expr(ctx.and_expr());
        System.out.print(" & ");
        Object r = visitEqu_expr(ctx.equ_expr());

        return new Integer_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitEqu_expr(MogicParser.Equ_exprContext ctx) {
        if(ctx.equ_expr() == null){
            return visitRelational_expr(ctx.relational_expr());
        }

        Object l = visitEqu_expr(ctx.equ_expr());
        if(ctx.equality_operator().EQ() != null) System.out.print(" == ");
        else System.out.print(" != ");
        Object r = visitRelational_expr(ctx.relational_expr());

        return new Bool_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitRelational_expr(MogicParser.Relational_exprContext ctx) {
        if(ctx.relational_expr() == null){
            return visitShift_expr(ctx.shift_expr());
        }

        Object l = visitRelational_expr(ctx.relational_expr());
        System.out.print(ctx.comparsion_operator().getText());
        Object r = visitShift_expr(ctx.shift_expr());

        return new Bool_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitShift_expr(MogicParser.Shift_exprContext ctx) {
        if(ctx.shift_expr() == null){
            return visitAdditive_expr(ctx.additive_expr());
        }

        Object l = visitShift_expr(ctx.shift_expr());
        System.out.print(ctx.shift_operator().getText());
        Object r = visitAdditive_expr(ctx.additive_expr());

        return new Integer_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAdditive_expr(MogicParser.Additive_exprContext ctx) {
        if(ctx.additive_expr() == null){
            return visitMuly_expr(ctx.muly_expr());
        }

        Object l = visitAdditive_expr(ctx.additive_expr());
        if(ctx.MINUS()!=null) System.out.print(" - ");
        else System.out.print(" + ");
        Object r = visitMuly_expr(ctx.muly_expr());


    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMuly_expr(MogicParser.Muly_exprContext ctx) {
        if(ctx.muly_expr() == null){
            return visitUnary_expr(ctx.unary_expr());
        }

        Object l = visitMuly_expr(ctx.muly_expr());
        if(ctx.REM()!=null) System.out.print(" % ");
        if(ctx.DIV()!=null) System.out.print(" \\ ");
        if(ctx.MUL()!=null) System.out.print(" * ");
        Object r = visitUnary_expr(ctx.unary_expr());

        return new Integer_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitUnary_expr(MogicParser.Unary_exprContext ctx) {//?
        if(ctx.postfix_expr() != null){
            visitPostfix_expr(ctx.postfix_expr());
            return null;
        }
        else if(ctx.constructor_call() != null){
            return visitConstructor_call(ctx.constructor_call());
        }
        Object tmp = visitUnary_expr(ctx.unary_expr());

        if(ctx.NOT() != null){
            System.out.print("!");
            System.out.println(ctx.unary_expr().getText());
        }
        else if(ctx.INCREMENT() != null){
            System.out.print("++");
            System.out.println(ctx.unary_expr().getText());
        }
        else if(ctx.DECREMENT() != null){
            System.out.print("--");
            System.out.println(ctx.unary_expr().getText());
        }
        else{
            System.out.print("~");
            System.out.println(ctx.unary_expr().getText());
        }
        return tmp;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitConstructor_call(MogicParser.Constructor_callContext ctx) {
        if(ctx.getChildCount() == 2){
            System.out.print("new ");
            System.out.println(ctx.dim_expr().getText());
        }
        else{
            System.out.print("new ");
            System.out.print(ctx.primitive_type().getText());
            System.out.print(ctx.dim_expr().getText());
            for(int i = 0; i<ctx.dim_SQ().size(); ++i) System.out.print("[]");
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitDim_expr(MogicParser.Dim_exprContext ctx) {
        Type_check.match_type("int", new Integer_type(false) , visitAssignment_expr(ctx.assignment_expr()) , ctx.getStart().getLine());
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitArr_arg_suffix(MogicParser.Arr_arg_suffixContext ctx) {
        System.out.println(ctx.getText());
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitArgument_expr_list(MogicParser.Argument_expr_listContext ctx) {
        Object p;
        LinkedList l = new LinkedList();
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
    @Override public Object visitAssignment_expr(MogicParser.Assignment_exprContext ctx) {
        if(ctx.ASSIGN() == null) return visitLogic_or_expr(ctx.logic_or_expr());

        Object l = visitUnary_expr(ctx.unary_expr());
        System.out.print(" = ");
        Object r = visitExpr(ctx.expr());
        return l;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPostfix_expr(MogicParser.Postfix_exprContext ctx) {

        if(ctx.expr() != null){
            return visitExpr(ctx.expr());
        }

        else if(ctx.constant()!=null){
            System.out.print(ctx.constant().getText());
        }
        else if(ctx.INCREMENT() != null){
            visitPostfix_expr(ctx.postfix_expr());
            System.out.println("++");
        }
        else if(ctx.DECREMENT() != null){
            visitPostfix_expr(ctx.postfix_expr());
            System.out.println("++");
        }
        else if(! ctx.arr_arg_suffix().isEmpty()){
            visitChildren(ctx);
        }
        else if(ctx.SIZE() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            System.out.println(".size");
        }
        else if(ctx.LENGTH() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            System.out.println(".length");
        }
        else if(ctx.SUBSTRING() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            System.out.println(".substring");
        }
        else if(ctx.PARSEINT() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            System.out.println(".parseInt");
        }
        else if(ctx.ORD() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            System.out.println(".ord");
        }
        else if(ctx.DOT() != null && ctx.id() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            System.out.println("."+ctx.id().getText());

        }
        else if(ctx.id() != null){
            System.out.println(ctx.getText());
        }
        else {
            System.out.println(ctx.getText());
        }
        return null; }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitUnary_operator(MogicParser.Unary_operatorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitConstant(MogicParser.ConstantContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStmt(MogicParser.StmtContext ctx) {
        visitBlock_stmt(ctx.block_stmt());
        if(ctx.var_decl_stmt()!=null) visitVar_decl_stmt(ctx.var_decl_stmt());
        if(ctx.expr_stmt()!=null) visitExpr_stmt(ctx.expr_stmt());
        if(ctx.selection_stmt()!=null) visitSelection_stmt(ctx.selection_stmt());
        if(ctx.iteration_stmt()!=null) visitIteration_stmt(ctx.iteration_stmt());
        if(ctx.jump_stmt()!=null) System.out.println(ctx.jump_stmt().getText());
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitBlock_stmt(MogicParser.Block_stmtContext ctx) {
        System.out.println("{");
        visitStmt_list(ctx.stmt_list());
        System.out.println("}");
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStmt_list(MogicParser.Stmt_listContext ctx) {
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpr_stmt(MogicParser.Expr_stmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitJump_stmt(MogicParser.Jump_stmtContext ctx) {

        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSelection_stmt(MogicParser.Selection_stmtContext ctx) {
        System.out.print("if(");
        System.out.print(ctx.expr().getText());
        System.out.print(")");
        visitStmt(ctx.stmt(0));
        table.add_depth();
        if(ctx.getChildCount() >= 6){
            System.out.println("else ");
            table.add_depth();
            visitStmt(ctx.stmt(1));
            table.dec_depth();
        }
        table.dec_depth();
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIteration_stmt(MogicParser.Iteration_stmtContext ctx) {
        ++is_in_loop;
        if(ctx.WHILE() != null){
            System.out.print("while(");
            System.out.print(ctx.expr().getText());
            System.out.println(")");
            visitStmt(ctx.stmt());
        }
        else{
            System.out.print("for(");
            if(ctx.expr0() != null) System.out.println(ctx.expr0().getText());
            System.out.print(";");
            if(ctx.expr1() != null) System.out.println(ctx.expr1().getText());
            System.out.print(";");
            if(ctx.expr() != null) System.out.println(ctx.expr().getText());
            visitStmt(ctx.stmt());
        }
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitExpr0(MogicParser.Expr0Context ctx) { return visitExpr(ctx.expr()); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExpr1(MogicParser.Expr1Context ctx) { return visitExpr(ctx.expr()); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitVar_decl_stmt(MogicParser.Var_decl_stmtContext ctx) {
        System.out.println("    "+ctx.type().getText()+" "+ctx.id().getText()+";");
        return null;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitive_type(MogicParser.Primitive_typeContext ctx) {
        Object p = Trans_type.transform(false,ctx.getText(),0,ctx.getStart().getLine());
        return p;
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitBool_literal(MogicParser.Bool_literalContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitEquality_operator(MogicParser.Equality_operatorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitComparsion_operator(MogicParser.Comparsion_operatorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitShift_operator(MogicParser.Shift_operatorContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitId(MogicParser.IdContext ctx) { return visitChildren(ctx); }
}