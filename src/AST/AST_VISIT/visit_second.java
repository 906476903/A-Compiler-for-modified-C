package AST.AST_VISIT;

// Generated from C:/Users/xsc/IdeaProjects/Mogic\Mogic.g4 by ANTLR 4.5.1
import AST.VarType.*;
import Error_handle.Error_msg;
import gen.MogicBaseVisitor;
import gen.MogicParser;

import java.util.*;

public class visit_second extends MogicBaseVisitor<Object> {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    Table table = visit_zero.table;
    Class_table class_table = visit_zero.class_table;
    Set<String> Class_set = visit_zero.Class_set;
    String current_func;
    int is_in_loop;
    boolean func_para_loaded;



    @Override public Object visitMogic_pro(MogicParser.Mogic_proContext ctx) {

        visitChildren(ctx);

        Object s = table.lookup("main");
        if(s != null) {
            if (!(s instanceof Function_type)) {
                Error_msg Err = new Error_msg();
                Err.complain("Need main method.");
            } else if (!(((Function_type) s).Return_type instanceof Integer_type)) {
                Error_msg Err = new Error_msg();
                Err.complain("main method need int return type.");
            }
        }

        return null;
    }

    @Override public Object visitProgram(MogicParser.ProgramContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitClass_decl(MogicParser.Class_declContext ctx) {
        return visitChildren(ctx);
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
        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */


    @Override public Object visitFunc_decl(MogicParser.Func_declContext ctx) {
        current_func = ctx.id().getText();
        func_para_loaded = false;
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

        return visitChildren(ctx);
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

        Object l = visitLogic_or_expr(ctx.logic_or_expr());
        Object r = visitLogic_and_expr(ctx.logic_and_expr());
        Type_check.match_type("bool", l , r , ctx.getStart().getLine());

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

        Object l = visitLogic_and_expr(ctx.logic_and_expr());
        Object r = visitInclusive_or_expr(ctx.inclusive_or_expr());
        Type_check.match_type("bool", l , r , ctx.getStart().getLine());

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
        Object r = visitExclusive_or_expr(ctx.exclusive_or_expr());
        Type_check.match_type("int", l , r , ctx.getStart().getLine());

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
        Object r = visitAnd_expr(ctx.and_expr());
        Type_check.match_type("xor", l , r , ctx.getStart().getLine());

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
        Object r = visitEqu_expr(ctx.equ_expr());
        Type_check.match_type("int", l , r , ctx.getStart().getLine());

        return new Integer_type(false);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    public static String s1 = "put";
    public static String s2 = "get";
    @Override public Object visitEqu_expr(MogicParser.Equ_exprContext ctx) {
        if(ctx.equ_expr() == null){
            return visitRelational_expr(ctx.relational_expr());
        }

        Object l = visitEqu_expr(ctx.equ_expr());
        Object r = visitRelational_expr(ctx.relational_expr());
        Type_check.match_type("==", l , r , ctx.getStart().getLine());

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
        Object r = visitShift_expr(ctx.shift_expr());
        Type_check.match_type("<", l , r , ctx.getStart().getLine());

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
        Object r = visitAdditive_expr(ctx.additive_expr());
        Type_check.match_type("int", l , r , ctx.getStart().getLine());

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
        Object r = visitMuly_expr(ctx.muly_expr());
        if(ctx.MINUS() == null){
            Type_check.match_type("+", l , r , ctx.getStart().getLine());
            if(l instanceof Integer_type)
                return new Integer_type(false);
            else if(r instanceof String_type)
                return new String_type(false);
            return l;
        }
        else {
            Type_check.match_type("int", l , r , ctx.getStart().getLine());
            return new Integer_type(false);
        }


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
        Object r = visitUnary_expr(ctx.unary_expr());
        Type_check.match_type("int", l , r , ctx.getStart().getLine());

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
            Object tmp = visitPostfix_expr(ctx.postfix_expr());
            return tmp;
        }
        else if(ctx.constructor_call() != null){
            return visitConstructor_call(ctx.constructor_call());
        }
        Object tmp = visitUnary_expr(ctx.unary_expr());

        if(ctx.NOT() != null){
            Type_check.match_type("bool",new Bool_type(false),tmp,ctx.getStart().getLine());
        }
        else if(ctx.INCREMENT() != null || ctx.DECREMENT() != null){
            Type_check.match_type("=",tmp,new Integer_type(false),ctx.getStart().getLine());
        }
        else{
            Type_check.match_type("int",new Integer_type(false),tmp,ctx.getStart().getLine());
            return Trans_type.create_lvalue_type(false,tmp);
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
            Object tmp = visitPrimitive_type(ctx.primitive_type());
            Type_check.match_type("new",new Integer_type(false),tmp,ctx.getStart().getLine());
            return tmp;
        }
        else{
            visitDim_expr(ctx.dim_expr());
            return new Array_type(visitPrimitive_type(ctx.primitive_type()),ctx.getChildCount()-2);
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
        Type_check.match_type("int", new Integer_type(false),visitAssignment_expr(ctx.assignment_expr()),ctx.getStart().getLine());
        return visitChildren(ctx);
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
        Object r = visitExpr(ctx.expr());
        Type_check.match_type("=", l , r , ctx.getStart().getLine());
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
            if(ctx.constant().bool_literal() != null) return Constant_construct.constant_make("bool",ctx.constant().getText());
            if(ctx.constant().Int_literal() != null) return Constant_construct.constant_make("int",ctx.constant().getText());
            if(ctx.constant().String_literal() != null) return Constant_construct.constant_make("string",ctx.constant().getText());
            if(ctx.constant().NULL_LITERAL() != null) return Constant_construct.constant_make("null",ctx.constant().getText());

        }
        else if(ctx.INCREMENT() != null || ctx.DECREMENT() != null){
            Object tmp = visitPostfix_expr(ctx.postfix_expr());
            if(Type_check.match_type("=",tmp,new Integer_type(false),ctx.getStart().getLine()))
                return Trans_type.create_lvalue_type(false,tmp);
            else return tmp;
        }
        else if(! ctx.arr_arg_suffix().isEmpty()){
            Object arr = visitPostfix_expr(ctx.postfix_expr());

            if(!(arr instanceof Array_type)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"is not array type.");
                return arr;
            }
            Object use_arr = Array_type.Use_arr((Array_type) arr,ctx.arr_arg_suffix().size());
            if(use_arr == null){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"the dimension is error.");
                return arr;
            }
            for(MogicParser.Arr_arg_suffixContext p : ctx.arr_arg_suffix()){
                visitArr_arg_suffix(p);
            }
            return use_arr;
        }
        else if(ctx.SIZE() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            if(!(s instanceof Array_type)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"you can't refer to .size here.");
            }
            return new Integer_type(false);
        }
        else if(ctx.LENGTH() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            if(!(s instanceof String_type)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"you can't refer to .length here.");
            }
            return new Integer_type(false);
        }
        else if(ctx.SUBSTRING() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            if(!(s instanceof String_type)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"you can't refer to .length here.");
            }
            Object l = visitAssignment_expr(ctx.assignment_expr(0));
            Object r = visitAssignment_expr(ctx.assignment_expr(1));
            if((!(l instanceof Integer_type)) || (!(r instanceof Integer_type))){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"paras need int here.");
            }
            return new String_type(false);
        }
        else if(ctx.PARSEINT() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            if(!(s instanceof String_type)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"you can't refer to .length here.");
            }
            return new Integer_type(false);
        }
        else if(ctx.ORD() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            if(!(s instanceof String_type)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"you can't refer to .length here.");
            }
            Object l = visitAssignment_expr(ctx.assignment_expr(0));
            if(!(l instanceof Integer_type)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"paras need int here.");
            }
            return new Integer_type(false);
        }
        else if(ctx.DOT() != null && ctx.id() != null){
            Object s = visitPostfix_expr(ctx.postfix_expr());
            //System.out.println(s.getClass().getSimpleName());
            if(!(s instanceof Class_type)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"you can't use dot here.");
            }
            else{

                String ss = ctx.id().getText();
                Object p = ((Class_type)s).Class_asses(ss);

                if(p == null){
                    Error_msg Err = new Error_msg();
                    Err.complain("Line: "+ctx.getStart().getLine()+' '+"the class member is error.");
                    return s;
                }

                return p;

            }

        }
        else if(ctx.id() != null){
            //System.out.println(ctx.id().getText());
            Object s = table.lookup(ctx.id().getText());

            if(s instanceof String){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"you can't refer to variable name there.");
            }
            //if(s instanceof  Bool_type)System.out.println(((Bool_type)s).is_lvalue);
            if(s == null)System.out.println(ctx.id().getText());
            return s;
        }
        else {
            Object s = visitPostfix_expr(ctx.postfix_expr());
            if(!(s instanceof Function_type)){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"you can't refer to () here.");
                return s;
            }
            LinkedList p = new LinkedList();
            if(ctx.argument_expr_list()!=null)p = (LinkedList) visitArgument_expr_list(ctx.argument_expr_list());
            //System.out.print(((Function_type)s).Return_type.getClass().getSimpleName()+p.size()+"fhhjhchch");
            ((Function_type)s).fit_para(p,ctx.getStart().getLine());
            return ((Function_type)s).Return_type;
        }
            return visitChildren(ctx); }
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
    @Override public Object visitStmt(MogicParser.StmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitBlock_stmt(MogicParser.Block_stmtContext ctx) {
        table.add_depth();
        if(current_func.intern() == "main"){
            if(((Function_type)table.lookup(current_func)).param.size() != 0){
                Error_msg Err = new Error_msg();
                Err.complain("Line: "+ctx.getStart().getLine()+' '+"main func error.");
            }
        }
        if(!func_para_loaded && current_func.intern()!="main"){
            LinkedList<Para_type> tmp =((Function_type)table.lookup(current_func)).param;
            for(Para_type k : tmp){
                table.insert(k.key,k.Type,ctx.getStart().getLine());
            }
            func_para_loaded = true;
        }
        visitChildren(ctx);
        table.dec_depth();
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

        if(ctx.RETURN() != null){
            if(ctx.expr() == null)
            {
                if((((Function_type)table.lookup(current_func)).Return_type.getClass().getSimpleName().intern()) != "Void_type" ){
                    Error_msg Err = new Error_msg();
                    Err.complain("Line: "+ctx.getStart().getLine()+' '+"return type does not match.");
                }
            }
            else{
                Type_check.match_type("func",table.lookup(current_func),visitExpr(ctx.expr()),ctx.getStart().getLine());

            }
            return null;
        }
        else if(is_in_loop > 0){

            return null;
        }
        else {
            Error_msg Err = new Error_msg();
            Err.complain("Line: "+ctx.getStart().getLine()+' '+"not in loop.");
            return null;
        }
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSelection_stmt(MogicParser.Selection_stmtContext ctx) {
        if(ctx.getChildCount() > 10) return null;
        Type_check.match_type("bool",new Bool_type(false),visitExpr(ctx.expr()),ctx.getStart().getLine());
        table.add_depth();
        visitStmt(ctx.stmt(0));
        table.dec_depth();
        if(ctx.getChildCount() >= 6){
            table.add_depth();
            visitStmt(ctx.stmt(1));
            table.dec_depth();
        }

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
            Type_check.match_type("bool",new Bool_type(false),visitExpr(ctx.expr()),ctx.getStart().getLine());
            table.add_depth();
            visitStmt(ctx.stmt());
            table.dec_depth();
        }
        else{
            if(ctx.expr0() != null) visitExpr0(ctx.expr0());
            if(ctx.expr1() != null) Type_check.match_type("bool",new Bool_type(false),visitExpr1(ctx.expr1()),ctx.getStart().getLine());
            if(ctx.expr() != null) visitExpr(ctx.expr());
            table.add_depth();
            visitStmt(ctx.stmt());
            table.dec_depth();
        }
        is_in_loop--;
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

        Object p = Trans_type.transform(false,ctx.type().primitive_type().getText(),
                ctx.type().dim_SQ().size(),ctx.type().getStart().getLine());

        //if(p instanceof  Bool_type)System.out.println("varrrr"+((Bool_type)p).is_lvalue);
        if(ctx.id().getText().intern() == "table") IR.Create_liner_IR.pla = true;
        if(ctx.ASSIGN() == null){//non assign
            table.insert(ctx.id().getText(),p,ctx.type().getStart().getLine());

            return visitChildren(ctx);
        }
        else {
            Type_check.match_type("=" , p , visitExpr(ctx.expr()) , ctx.getStart().getLine());

            table.insert(ctx.id().getText(),p,ctx.type().getStart().getLine());
            return null;
        }
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