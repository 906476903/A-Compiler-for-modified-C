// Generated from C:/Users/xsc/IdeaProjects/compiler2016/src\Mogic.g4 by ANTLR 4.5.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link MogicParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface MogicVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link MogicParser#mogic_pro}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMogic_pro(MogicParser.Mogic_proContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#program}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProgram(MogicParser.ProgramContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#class_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClass_decl(MogicParser.Class_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#member_decl_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_decl_list(MogicParser.Member_decl_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#member_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMember_decl(MogicParser.Member_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#func_decl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunc_decl(MogicParser.Func_declContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#parameter_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter_list(MogicParser.Parameter_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(MogicParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#dim_SQ}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDim_SQ(MogicParser.Dim_SQContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(MogicParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#logic_or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_or_expr(MogicParser.Logic_or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#logic_and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic_and_expr(MogicParser.Logic_and_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#inclusive_or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInclusive_or_expr(MogicParser.Inclusive_or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#exclusive_or_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExclusive_or_expr(MogicParser.Exclusive_or_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#and_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnd_expr(MogicParser.And_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#equ_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqu_expr(MogicParser.Equ_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#relational_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelational_expr(MogicParser.Relational_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#shift_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_expr(MogicParser.Shift_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#additive_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditive_expr(MogicParser.Additive_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#muly_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMuly_expr(MogicParser.Muly_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#unary_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_expr(MogicParser.Unary_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#constructor_call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructor_call(MogicParser.Constructor_callContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#dim_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDim_expr(MogicParser.Dim_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#arr_arg_suffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArr_arg_suffix(MogicParser.Arr_arg_suffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#argument_expr_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument_expr_list(MogicParser.Argument_expr_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#assignment_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment_expr(MogicParser.Assignment_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#postfix_expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfix_expr(MogicParser.Postfix_exprContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#unary_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnary_operator(MogicParser.Unary_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#constant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstant(MogicParser.ConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt(MogicParser.StmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#block_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock_stmt(MogicParser.Block_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#stmt_list}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStmt_list(MogicParser.Stmt_listContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#expr_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr_stmt(MogicParser.Expr_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#jump_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJump_stmt(MogicParser.Jump_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#selection_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSelection_stmt(MogicParser.Selection_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#iteration_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIteration_stmt(MogicParser.Iteration_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#expr0}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr0(MogicParser.Expr0Context ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#expr1}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr1(MogicParser.Expr1Context ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#var_decl_stmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVar_decl_stmt(MogicParser.Var_decl_stmtContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#primitive_type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimitive_type(MogicParser.Primitive_typeContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#bool_literal}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBool_literal(MogicParser.Bool_literalContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#equality_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality_operator(MogicParser.Equality_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#comparsion_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparsion_operator(MogicParser.Comparsion_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#shift_operator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitShift_operator(MogicParser.Shift_operatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link MogicParser#id}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitId(MogicParser.IdContext ctx);
}