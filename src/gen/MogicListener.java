// Generated from C:/Users/xsc/IdeaProjects/compiler2016/src\Mogic.g4 by ANTLR 4.5.1
package gen;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link MogicParser}.
 */
public interface MogicListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link MogicParser#mogic_pro}.
	 * @param ctx the parse tree
	 */
	void enterMogic_pro(MogicParser.Mogic_proContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#mogic_pro}.
	 * @param ctx the parse tree
	 */
	void exitMogic_pro(MogicParser.Mogic_proContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#program}.
	 * @param ctx the parse tree
	 */
	void enterProgram(MogicParser.ProgramContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#program}.
	 * @param ctx the parse tree
	 */
	void exitProgram(MogicParser.ProgramContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void enterClass_decl(MogicParser.Class_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#class_decl}.
	 * @param ctx the parse tree
	 */
	void exitClass_decl(MogicParser.Class_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#member_decl_list}.
	 * @param ctx the parse tree
	 */
	void enterMember_decl_list(MogicParser.Member_decl_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#member_decl_list}.
	 * @param ctx the parse tree
	 */
	void exitMember_decl_list(MogicParser.Member_decl_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#member_decl}.
	 * @param ctx the parse tree
	 */
	void enterMember_decl(MogicParser.Member_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#member_decl}.
	 * @param ctx the parse tree
	 */
	void exitMember_decl(MogicParser.Member_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void enterFunc_decl(MogicParser.Func_declContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#func_decl}.
	 * @param ctx the parse tree
	 */
	void exitFunc_decl(MogicParser.Func_declContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void enterParameter_list(MogicParser.Parameter_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#parameter_list}.
	 * @param ctx the parse tree
	 */
	void exitParameter_list(MogicParser.Parameter_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#type}.
	 * @param ctx the parse tree
	 */
	void enterType(MogicParser.TypeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#type}.
	 * @param ctx the parse tree
	 */
	void exitType(MogicParser.TypeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#dim_SQ}.
	 * @param ctx the parse tree
	 */
	void enterDim_SQ(MogicParser.Dim_SQContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#dim_SQ}.
	 * @param ctx the parse tree
	 */
	void exitDim_SQ(MogicParser.Dim_SQContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(MogicParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(MogicParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#logic_or_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogic_or_expr(MogicParser.Logic_or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#logic_or_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogic_or_expr(MogicParser.Logic_or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#logic_and_expr}.
	 * @param ctx the parse tree
	 */
	void enterLogic_and_expr(MogicParser.Logic_and_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#logic_and_expr}.
	 * @param ctx the parse tree
	 */
	void exitLogic_and_expr(MogicParser.Logic_and_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#inclusive_or_expr}.
	 * @param ctx the parse tree
	 */
	void enterInclusive_or_expr(MogicParser.Inclusive_or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#inclusive_or_expr}.
	 * @param ctx the parse tree
	 */
	void exitInclusive_or_expr(MogicParser.Inclusive_or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#exclusive_or_expr}.
	 * @param ctx the parse tree
	 */
	void enterExclusive_or_expr(MogicParser.Exclusive_or_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#exclusive_or_expr}.
	 * @param ctx the parse tree
	 */
	void exitExclusive_or_expr(MogicParser.Exclusive_or_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void enterAnd_expr(MogicParser.And_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#and_expr}.
	 * @param ctx the parse tree
	 */
	void exitAnd_expr(MogicParser.And_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#equ_expr}.
	 * @param ctx the parse tree
	 */
	void enterEqu_expr(MogicParser.Equ_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#equ_expr}.
	 * @param ctx the parse tree
	 */
	void exitEqu_expr(MogicParser.Equ_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#relational_expr}.
	 * @param ctx the parse tree
	 */
	void enterRelational_expr(MogicParser.Relational_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#relational_expr}.
	 * @param ctx the parse tree
	 */
	void exitRelational_expr(MogicParser.Relational_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#shift_expr}.
	 * @param ctx the parse tree
	 */
	void enterShift_expr(MogicParser.Shift_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#shift_expr}.
	 * @param ctx the parse tree
	 */
	void exitShift_expr(MogicParser.Shift_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#additive_expr}.
	 * @param ctx the parse tree
	 */
	void enterAdditive_expr(MogicParser.Additive_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#additive_expr}.
	 * @param ctx the parse tree
	 */
	void exitAdditive_expr(MogicParser.Additive_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#muly_expr}.
	 * @param ctx the parse tree
	 */
	void enterMuly_expr(MogicParser.Muly_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#muly_expr}.
	 * @param ctx the parse tree
	 */
	void exitMuly_expr(MogicParser.Muly_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void enterUnary_expr(MogicParser.Unary_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#unary_expr}.
	 * @param ctx the parse tree
	 */
	void exitUnary_expr(MogicParser.Unary_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#constructor_call}.
	 * @param ctx the parse tree
	 */
	void enterConstructor_call(MogicParser.Constructor_callContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#constructor_call}.
	 * @param ctx the parse tree
	 */
	void exitConstructor_call(MogicParser.Constructor_callContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#dim_expr}.
	 * @param ctx the parse tree
	 */
	void enterDim_expr(MogicParser.Dim_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#dim_expr}.
	 * @param ctx the parse tree
	 */
	void exitDim_expr(MogicParser.Dim_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#arr_arg_suffix}.
	 * @param ctx the parse tree
	 */
	void enterArr_arg_suffix(MogicParser.Arr_arg_suffixContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#arr_arg_suffix}.
	 * @param ctx the parse tree
	 */
	void exitArr_arg_suffix(MogicParser.Arr_arg_suffixContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#argument_expr_list}.
	 * @param ctx the parse tree
	 */
	void enterArgument_expr_list(MogicParser.Argument_expr_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#argument_expr_list}.
	 * @param ctx the parse tree
	 */
	void exitArgument_expr_list(MogicParser.Argument_expr_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#assignment_expr}.
	 * @param ctx the parse tree
	 */
	void enterAssignment_expr(MogicParser.Assignment_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#assignment_expr}.
	 * @param ctx the parse tree
	 */
	void exitAssignment_expr(MogicParser.Assignment_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void enterPostfix_expr(MogicParser.Postfix_exprContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#postfix_expr}.
	 * @param ctx the parse tree
	 */
	void exitPostfix_expr(MogicParser.Postfix_exprContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void enterUnary_operator(MogicParser.Unary_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#unary_operator}.
	 * @param ctx the parse tree
	 */
	void exitUnary_operator(MogicParser.Unary_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#constant}.
	 * @param ctx the parse tree
	 */
	void enterConstant(MogicParser.ConstantContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#constant}.
	 * @param ctx the parse tree
	 */
	void exitConstant(MogicParser.ConstantContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#stmt}.
	 * @param ctx the parse tree
	 */
	void enterStmt(MogicParser.StmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#stmt}.
	 * @param ctx the parse tree
	 */
	void exitStmt(MogicParser.StmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#block_stmt}.
	 * @param ctx the parse tree
	 */
	void enterBlock_stmt(MogicParser.Block_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#block_stmt}.
	 * @param ctx the parse tree
	 */
	void exitBlock_stmt(MogicParser.Block_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void enterStmt_list(MogicParser.Stmt_listContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#stmt_list}.
	 * @param ctx the parse tree
	 */
	void exitStmt_list(MogicParser.Stmt_listContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void enterExpr_stmt(MogicParser.Expr_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#expr_stmt}.
	 * @param ctx the parse tree
	 */
	void exitExpr_stmt(MogicParser.Expr_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void enterJump_stmt(MogicParser.Jump_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#jump_stmt}.
	 * @param ctx the parse tree
	 */
	void exitJump_stmt(MogicParser.Jump_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#selection_stmt}.
	 * @param ctx the parse tree
	 */
	void enterSelection_stmt(MogicParser.Selection_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#selection_stmt}.
	 * @param ctx the parse tree
	 */
	void exitSelection_stmt(MogicParser.Selection_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#iteration_stmt}.
	 * @param ctx the parse tree
	 */
	void enterIteration_stmt(MogicParser.Iteration_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#iteration_stmt}.
	 * @param ctx the parse tree
	 */
	void exitIteration_stmt(MogicParser.Iteration_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#expr0}.
	 * @param ctx the parse tree
	 */
	void enterExpr0(MogicParser.Expr0Context ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#expr0}.
	 * @param ctx the parse tree
	 */
	void exitExpr0(MogicParser.Expr0Context ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#expr1}.
	 * @param ctx the parse tree
	 */
	void enterExpr1(MogicParser.Expr1Context ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#expr1}.
	 * @param ctx the parse tree
	 */
	void exitExpr1(MogicParser.Expr1Context ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#var_decl_stmt}.
	 * @param ctx the parse tree
	 */
	void enterVar_decl_stmt(MogicParser.Var_decl_stmtContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#var_decl_stmt}.
	 * @param ctx the parse tree
	 */
	void exitVar_decl_stmt(MogicParser.Var_decl_stmtContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void enterPrimitive_type(MogicParser.Primitive_typeContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#primitive_type}.
	 * @param ctx the parse tree
	 */
	void exitPrimitive_type(MogicParser.Primitive_typeContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void enterBool_literal(MogicParser.Bool_literalContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#bool_literal}.
	 * @param ctx the parse tree
	 */
	void exitBool_literal(MogicParser.Bool_literalContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void enterEquality_operator(MogicParser.Equality_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#equality_operator}.
	 * @param ctx the parse tree
	 */
	void exitEquality_operator(MogicParser.Equality_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#comparsion_operator}.
	 * @param ctx the parse tree
	 */
	void enterComparsion_operator(MogicParser.Comparsion_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#comparsion_operator}.
	 * @param ctx the parse tree
	 */
	void exitComparsion_operator(MogicParser.Comparsion_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#shift_operator}.
	 * @param ctx the parse tree
	 */
	void enterShift_operator(MogicParser.Shift_operatorContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#shift_operator}.
	 * @param ctx the parse tree
	 */
	void exitShift_operator(MogicParser.Shift_operatorContext ctx);
	/**
	 * Enter a parse tree produced by {@link MogicParser#id}.
	 * @param ctx the parse tree
	 */
	void enterId(MogicParser.IdContext ctx);
	/**
	 * Exit a parse tree produced by {@link MogicParser#id}.
	 * @param ctx the parse tree
	 */
	void exitId(MogicParser.IdContext ctx);
}