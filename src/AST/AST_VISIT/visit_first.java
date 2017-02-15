package AST.AST_VISIT;

// Generated from C:/Users/xsc/IdeaProjects/Mogic\Mogic.g4 by ANTLR 4.5.1
import AST.VarType.*;
import Error_handle.Error_msg;
import IR.IR_sy_table;
import gen.MogicBaseVisitor;
import gen.MogicParser;

import java.util.*;

public class visit_first extends MogicBaseVisitor<Object> {
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    Table table = visit_zero.table;
    public static IR_sy_table IR_table = new IR_sy_table();
    Class_table class_table = visit_zero.class_table;
    Set<String> Class_set = visit_zero.Class_set;

    @Override public Object visitMogic_pro(MogicParser.Mogic_proContext ctx) { return visitChildren(ctx); }

    @Override public Object visitProgram(MogicParser.ProgramContext ctx) {

        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    HashMap<String,Object> Member_decl_list_map = new HashMap<String,Object>();

    @Override public Object visitClass_decl(MogicParser.Class_declContext ctx) {
        String id = ctx.id().getText();

        Member_decl_list_map = new HashMap<String,Object>();


        if(class_table.env.containsKey(id)){
            Error_msg Err = new Error_msg();
            Err.complain("Line: "+ctx.getStart().getLine()+' '+"this class has existed.");
        }
        Class_type p = new Class_type(id,Member_decl_list_map,true);
        class_table.insert(id,p);

        visitChildren(ctx);
        p.Count();

        //class_table.insert(id,Member_decl_list_map,ctx.getStart().getLine());
        //System.out.println(Member_decl_list_map.size());
        //System.out.println("class"+' '+id);



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

        Object p = Trans_type.transform(false,ctx.type().primitive_type().getText(),
                ctx.type().dim_SQ().size(),ctx.type().getStart().getLine());
        if(Member_decl_list_map.containsKey(ctx.id().getText().intern())){
            Error_msg Err = new Error_msg();
            Err.complain("Line: "+ctx.getStart().getLine()+' '+"the variable has been defined.");
        }
        //System.out.println(ctx.id().getText()+(p==null));
        Member_decl_list_map.put( ctx.id().getText(), p );

        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    LinkedList<Para_type> visitFunc_decl_map;
    @Override public Object visitFunc_decl(MogicParser.Func_declContext ctx) {



        String id = ctx.id().getText();

        visitFunc_decl_map = new LinkedList<Para_type>();
        visitChildren(ctx);
        Object p = Trans_type.transform(true,ctx.type().primitive_type().getText(),
                ctx.type().dim_SQ().size(),ctx.type().getStart().getLine(),false);
        Function_type s = new Function_type(p,visitFunc_decl_map);
        //System.out.println("func"+' '+id);

        table.insert(id,s,ctx.type().getStart().getLine());
        IR_table.insert(id,s);
        return null;
        }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitParameter_list(MogicParser.Parameter_listContext ctx) {
        Object p = Trans_type.transform(false,ctx.type().primitive_type().getText(),
                ctx.type().dim_SQ().size(),ctx.type().getStart().getLine());

        Para_type tmp = new Para_type(ctx.id().getText(),p);
        visitFunc_decl_map.addLast(tmp);
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
    @Override public Object visitExpr(MogicParser.ExprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */

    @Override public Object visitLogic_or_expr(MogicParser.Logic_or_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitLogic_and_expr(MogicParser.Logic_and_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitInclusive_or_expr(MogicParser.Inclusive_or_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitExclusive_or_expr(MogicParser.Exclusive_or_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAnd_expr(MogicParser.And_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitEqu_expr(MogicParser.Equ_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitRelational_expr(MogicParser.Relational_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitShift_expr(MogicParser.Shift_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAdditive_expr(MogicParser.Additive_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitMuly_expr(MogicParser.Muly_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitUnary_expr(MogicParser.Unary_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitConstructor_call(MogicParser.Constructor_callContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitDim_expr(MogicParser.Dim_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitArr_arg_suffix(MogicParser.Arr_arg_suffixContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitArgument_expr_list(MogicParser.Argument_expr_listContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitAssignment_expr(MogicParser.Assignment_exprContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPostfix_expr(MogicParser.Postfix_exprContext ctx) { return visitChildren(ctx); }
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
    @Override public Object visitBlock_stmt(MogicParser.Block_stmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitStmt_list(MogicParser.Stmt_listContext ctx) { return visitChildren(ctx); }
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
    @Override public Object visitJump_stmt(MogicParser.Jump_stmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitSelection_stmt(MogicParser.Selection_stmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitIteration_stmt(MogicParser.Iteration_stmtContext ctx) { return visitChildren(ctx); }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitVar_decl_stmt(MogicParser.Var_decl_stmtContext ctx) {

        return visitChildren(ctx);
    }
    /**
     * {@inheritDoc}
     *
     * <p>The default implementation returns the result of calling
     * {@link #visitChildren} on {@code ctx}.</p>
     */
    @Override public Object visitPrimitive_type(MogicParser.Primitive_typeContext ctx) { return visitChildren(ctx); }
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