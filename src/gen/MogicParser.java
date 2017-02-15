// Generated from C:/Users/xsc/IdeaProjects/compiler2016/src\Mogic.g4 by ANTLR 4.5.1
package gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MogicParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.5.1", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Int_literal=1, IF=2, ELSE=3, FOR=4, WHILE=5, CONTINUE=6, BREAK=7, RETURN=8, 
		NEW=9, CLASS=10, NULL_LITERAL=11, SIZE=12, PRINT=13, PRINTLN=14, GETSTRING=15, 
		GETINT=16, TOSTRING=17, LENGTH=18, SUBSTRING=19, PARSEINT=20, ORD=21, 
		TRUE=22, FALSE=23, String_literal=24, EQ=25, NEQ=26, GT=27, LT=28, GE=29, 
		LE=30, LSHIFT=31, RSHIFT=32, INCREMENT=33, DECREMENT=34, SEMICOLON=35, 
		OPB_FIG=36, CLB_FIG=37, OPB_RND=38, CLB_RND=39, OPB_SQ=40, CLB_SQ=41, 
		DOUBLE_DOT=42, COMMA=43, DOT=44, ETC=45, PLUS=46, MINUS=47, MUL=48, DIV=49, 
		ASSIGN=50, BIT_AND=51, BIT_OR=52, BIT_XOR=53, Tilde=54, AND=55, OR=56, 
		QUESTION=57, REM=58, NOT=59, VOID=60, STRING=61, INT=62, BOOL=63, IDEN=64, 
		WS=65, COMMENT=66;
	public static final int
		RULE_mogic_pro = 0, RULE_program = 1, RULE_class_decl = 2, RULE_member_decl_list = 3, 
		RULE_member_decl = 4, RULE_func_decl = 5, RULE_parameter_list = 6, RULE_type = 7, 
		RULE_dim_SQ = 8, RULE_expr = 9, RULE_logic_or_expr = 10, RULE_logic_and_expr = 11, 
		RULE_inclusive_or_expr = 12, RULE_exclusive_or_expr = 13, RULE_and_expr = 14, 
		RULE_equ_expr = 15, RULE_relational_expr = 16, RULE_shift_expr = 17, RULE_additive_expr = 18, 
		RULE_muly_expr = 19, RULE_unary_expr = 20, RULE_constructor_call = 21, 
		RULE_dim_expr = 22, RULE_arr_arg_suffix = 23, RULE_argument_expr_list = 24, 
		RULE_assignment_expr = 25, RULE_postfix_expr = 26, RULE_unary_operator = 27, 
		RULE_constant = 28, RULE_stmt = 29, RULE_block_stmt = 30, RULE_stmt_list = 31, 
		RULE_expr_stmt = 32, RULE_jump_stmt = 33, RULE_selection_stmt = 34, RULE_iteration_stmt = 35, 
		RULE_expr0 = 36, RULE_expr1 = 37, RULE_var_decl_stmt = 38, RULE_primitive_type = 39, 
		RULE_bool_literal = 40, RULE_equality_operator = 41, RULE_comparsion_operator = 42, 
		RULE_shift_operator = 43, RULE_id = 44;
	public static final String[] ruleNames = {
		"mogic_pro", "program", "class_decl", "member_decl_list", "member_decl", 
		"func_decl", "parameter_list", "type", "dim_SQ", "expr", "logic_or_expr", 
		"logic_and_expr", "inclusive_or_expr", "exclusive_or_expr", "and_expr", 
		"equ_expr", "relational_expr", "shift_expr", "additive_expr", "muly_expr", 
		"unary_expr", "constructor_call", "dim_expr", "arr_arg_suffix", "argument_expr_list", 
		"assignment_expr", "postfix_expr", "unary_operator", "constant", "stmt", 
		"block_stmt", "stmt_list", "expr_stmt", "jump_stmt", "selection_stmt", 
		"iteration_stmt", "expr0", "expr1", "var_decl_stmt", "primitive_type", 
		"bool_literal", "equality_operator", "comparsion_operator", "shift_operator", 
		"id"
	};

	private static final String[] _LITERAL_NAMES = {
		null, null, "'if'", "'else'", "'for'", "'while'", "'continue'", "'break'", 
		"'return'", "'new'", "'class'", "'null'", "'size'", "'print'", "'println'", 
		"'getString'", "'getInt'", "'toString'", "'length'", "'substring'", "'parseInt'", 
		"'ord'", "'true'", "'false'", null, "'=='", "'!='", "'>'", "'<'", "'>='", 
		"'<='", "'<<'", "'>>'", "'++'", "'--'", "';'", "'{'", "'}'", "'('", "')'", 
		"'['", "']'", "':'", "','", "'.'", "'...'", "'+'", "'-'", "'*'", "'/'", 
		"'='", "'&'", "'|'", "'^'", "'~'", "'&&'", "'||'", "'?'", "'%'", "'!'", 
		"'void'", "'string'", "'int'", "'boolean'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, "Int_literal", "IF", "ELSE", "FOR", "WHILE", "CONTINUE", "BREAK", 
		"RETURN", "NEW", "CLASS", "NULL_LITERAL", "SIZE", "PRINT", "PRINTLN", 
		"GETSTRING", "GETINT", "TOSTRING", "LENGTH", "SUBSTRING", "PARSEINT", 
		"ORD", "TRUE", "FALSE", "String_literal", "EQ", "NEQ", "GT", "LT", "GE", 
		"LE", "LSHIFT", "RSHIFT", "INCREMENT", "DECREMENT", "SEMICOLON", "OPB_FIG", 
		"CLB_FIG", "OPB_RND", "CLB_RND", "OPB_SQ", "CLB_SQ", "DOUBLE_DOT", "COMMA", 
		"DOT", "ETC", "PLUS", "MINUS", "MUL", "DIV", "ASSIGN", "BIT_AND", "BIT_OR", 
		"BIT_XOR", "Tilde", "AND", "OR", "QUESTION", "REM", "NOT", "VOID", "STRING", 
		"INT", "BOOL", "IDEN", "WS", "COMMENT"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "Mogic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public MogicParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class Mogic_proContext extends ParserRuleContext {
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public Mogic_proContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_mogic_pro; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterMogic_pro(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitMogic_pro(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitMogic_pro(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Mogic_proContext mogic_pro() throws RecognitionException {
		Mogic_proContext _localctx = new Mogic_proContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_mogic_pro);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			program();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ProgramContext extends ParserRuleContext {
		public Class_declContext class_decl() {
			return getRuleContext(Class_declContext.class,0);
		}
		public ProgramContext program() {
			return getRuleContext(ProgramContext.class,0);
		}
		public Func_declContext func_decl() {
			return getRuleContext(Func_declContext.class,0);
		}
		public Var_decl_stmtContext var_decl_stmt() {
			return getRuleContext(Var_decl_stmtContext.class,0);
		}
		public ProgramContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_program; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterProgram(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitProgram(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitProgram(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgramContext program() throws RecognitionException {
		ProgramContext _localctx = new ProgramContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_program);
		int _la;
		try {
			setState(104);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(92);
				class_decl();
				setState(94);
				_la = _input.LA(1);
				if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (CLASS - 10)) | (1L << (SIZE - 10)) | (1L << (PRINT - 10)) | (1L << (PRINTLN - 10)) | (1L << (GETSTRING - 10)) | (1L << (GETINT - 10)) | (1L << (TOSTRING - 10)) | (1L << (LENGTH - 10)) | (1L << (SUBSTRING - 10)) | (1L << (PARSEINT - 10)) | (1L << (ORD - 10)) | (1L << (VOID - 10)) | (1L << (STRING - 10)) | (1L << (INT - 10)) | (1L << (BOOL - 10)) | (1L << (IDEN - 10)))) != 0)) {
					{
					setState(93);
					program();
					}
				}

				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				func_decl();
				setState(98);
				_la = _input.LA(1);
				if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (CLASS - 10)) | (1L << (SIZE - 10)) | (1L << (PRINT - 10)) | (1L << (PRINTLN - 10)) | (1L << (GETSTRING - 10)) | (1L << (GETINT - 10)) | (1L << (TOSTRING - 10)) | (1L << (LENGTH - 10)) | (1L << (SUBSTRING - 10)) | (1L << (PARSEINT - 10)) | (1L << (ORD - 10)) | (1L << (VOID - 10)) | (1L << (STRING - 10)) | (1L << (INT - 10)) | (1L << (BOOL - 10)) | (1L << (IDEN - 10)))) != 0)) {
					{
					setState(97);
					program();
					}
				}

				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(100);
				var_decl_stmt();
				setState(102);
				_la = _input.LA(1);
				if (((((_la - 10)) & ~0x3f) == 0 && ((1L << (_la - 10)) & ((1L << (CLASS - 10)) | (1L << (SIZE - 10)) | (1L << (PRINT - 10)) | (1L << (PRINTLN - 10)) | (1L << (GETSTRING - 10)) | (1L << (GETINT - 10)) | (1L << (TOSTRING - 10)) | (1L << (LENGTH - 10)) | (1L << (SUBSTRING - 10)) | (1L << (PARSEINT - 10)) | (1L << (ORD - 10)) | (1L << (VOID - 10)) | (1L << (STRING - 10)) | (1L << (INT - 10)) | (1L << (BOOL - 10)) | (1L << (IDEN - 10)))) != 0)) {
					{
					setState(101);
					program();
					}
				}

				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Class_declContext extends ParserRuleContext {
		public TerminalNode CLASS() { return getToken(MogicParser.CLASS, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode OPB_FIG() { return getToken(MogicParser.OPB_FIG, 0); }
		public Member_decl_listContext member_decl_list() {
			return getRuleContext(Member_decl_listContext.class,0);
		}
		public TerminalNode CLB_FIG() { return getToken(MogicParser.CLB_FIG, 0); }
		public Class_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_class_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterClass_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitClass_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitClass_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Class_declContext class_decl() throws RecognitionException {
		Class_declContext _localctx = new Class_declContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_class_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(CLASS);
			setState(107);
			id();
			setState(108);
			match(OPB_FIG);
			setState(109);
			member_decl_list();
			setState(110);
			match(CLB_FIG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_decl_listContext extends ParserRuleContext {
		public List<Member_declContext> member_decl() {
			return getRuleContexts(Member_declContext.class);
		}
		public Member_declContext member_decl(int i) {
			return getRuleContext(Member_declContext.class,i);
		}
		public Member_decl_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_decl_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterMember_decl_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitMember_decl_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitMember_decl_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_decl_listContext member_decl_list() throws RecognitionException {
		Member_decl_listContext _localctx = new Member_decl_listContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_member_decl_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				member_decl();
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (SIZE - 12)) | (1L << (PRINT - 12)) | (1L << (PRINTLN - 12)) | (1L << (GETSTRING - 12)) | (1L << (GETINT - 12)) | (1L << (TOSTRING - 12)) | (1L << (LENGTH - 12)) | (1L << (SUBSTRING - 12)) | (1L << (PARSEINT - 12)) | (1L << (ORD - 12)) | (1L << (VOID - 12)) | (1L << (STRING - 12)) | (1L << (INT - 12)) | (1L << (BOOL - 12)) | (1L << (IDEN - 12)))) != 0) );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Member_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MogicParser.SEMICOLON, 0); }
		public Member_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_member_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterMember_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitMember_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitMember_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Member_declContext member_decl() throws RecognitionException {
		Member_declContext _localctx = new Member_declContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_member_decl);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			type();
			setState(118);
			id();
			setState(119);
			match(SEMICOLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Func_declContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode OPB_RND() { return getToken(MogicParser.OPB_RND, 0); }
		public TerminalNode CLB_RND() { return getToken(MogicParser.CLB_RND, 0); }
		public Block_stmtContext block_stmt() {
			return getRuleContext(Block_stmtContext.class,0);
		}
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Func_declContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_func_decl; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterFunc_decl(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitFunc_decl(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitFunc_decl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Func_declContext func_decl() throws RecognitionException {
		Func_declContext _localctx = new Func_declContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_func_decl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(121);
			type();
			setState(122);
			id();
			setState(123);
			match(OPB_RND);
			setState(125);
			_la = _input.LA(1);
			if (((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (SIZE - 12)) | (1L << (PRINT - 12)) | (1L << (PRINTLN - 12)) | (1L << (GETSTRING - 12)) | (1L << (GETINT - 12)) | (1L << (TOSTRING - 12)) | (1L << (LENGTH - 12)) | (1L << (SUBSTRING - 12)) | (1L << (PARSEINT - 12)) | (1L << (ORD - 12)) | (1L << (VOID - 12)) | (1L << (STRING - 12)) | (1L << (INT - 12)) | (1L << (BOOL - 12)) | (1L << (IDEN - 12)))) != 0)) {
				{
				setState(124);
				parameter_list();
				}
			}

			setState(127);
			match(CLB_RND);
			setState(128);
			block_stmt();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Parameter_listContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(MogicParser.COMMA, 0); }
		public Parameter_listContext parameter_list() {
			return getRuleContext(Parameter_listContext.class,0);
		}
		public Parameter_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterParameter_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitParameter_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitParameter_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Parameter_listContext parameter_list() throws RecognitionException {
		Parameter_listContext _localctx = new Parameter_listContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_parameter_list);
		try {
			setState(138);
			switch ( getInterpreter().adaptivePredict(_input,6,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(130);
				type();
				setState(131);
				id();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(133);
				type();
				setState(134);
				id();
				setState(135);
				match(COMMA);
				setState(136);
				parameter_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeContext extends ParserRuleContext {
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public List<Dim_SQContext> dim_SQ() {
			return getRuleContexts(Dim_SQContext.class);
		}
		public Dim_SQContext dim_SQ(int i) {
			return getRuleContext(Dim_SQContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_type);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(140);
			primitive_type();
			setState(144);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==OPB_SQ) {
				{
				{
				setState(141);
				dim_SQ();
				}
				}
				setState(146);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dim_SQContext extends ParserRuleContext {
		public TerminalNode OPB_SQ() { return getToken(MogicParser.OPB_SQ, 0); }
		public TerminalNode CLB_SQ() { return getToken(MogicParser.CLB_SQ, 0); }
		public Dim_SQContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dim_SQ; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterDim_SQ(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitDim_SQ(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitDim_SQ(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dim_SQContext dim_SQ() throws RecognitionException {
		Dim_SQContext _localctx = new Dim_SQContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_dim_SQ);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(147);
			match(OPB_SQ);
			setState(148);
			match(CLB_SQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ExprContext extends ParserRuleContext {
		public Assignment_exprContext assignment_expr() {
			return getRuleContext(Assignment_exprContext.class,0);
		}
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		ExprContext _localctx = new ExprContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			assignment_expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Logic_or_exprContext extends ParserRuleContext {
		public Logic_and_exprContext logic_and_expr() {
			return getRuleContext(Logic_and_exprContext.class,0);
		}
		public Logic_or_exprContext logic_or_expr() {
			return getRuleContext(Logic_or_exprContext.class,0);
		}
		public TerminalNode OR() { return getToken(MogicParser.OR, 0); }
		public Logic_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterLogic_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitLogic_or_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitLogic_or_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_or_exprContext logic_or_expr() throws RecognitionException {
		return logic_or_expr(0);
	}

	private Logic_or_exprContext logic_or_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logic_or_exprContext _localctx = new Logic_or_exprContext(_ctx, _parentState);
		Logic_or_exprContext _prevctx = _localctx;
		int _startState = 20;
		enterRecursionRule(_localctx, 20, RULE_logic_or_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(153);
			logic_and_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(160);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Logic_or_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logic_or_expr);
					setState(155);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(156);
					match(OR);
					setState(157);
					logic_and_expr(0);
					}
					} 
				}
				setState(162);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Logic_and_exprContext extends ParserRuleContext {
		public Inclusive_or_exprContext inclusive_or_expr() {
			return getRuleContext(Inclusive_or_exprContext.class,0);
		}
		public Logic_and_exprContext logic_and_expr() {
			return getRuleContext(Logic_and_exprContext.class,0);
		}
		public TerminalNode AND() { return getToken(MogicParser.AND, 0); }
		public Logic_and_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterLogic_and_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitLogic_and_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitLogic_and_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Logic_and_exprContext logic_and_expr() throws RecognitionException {
		return logic_and_expr(0);
	}

	private Logic_and_exprContext logic_and_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Logic_and_exprContext _localctx = new Logic_and_exprContext(_ctx, _parentState);
		Logic_and_exprContext _prevctx = _localctx;
		int _startState = 22;
		enterRecursionRule(_localctx, 22, RULE_logic_and_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(164);
			inclusive_or_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(171);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Logic_and_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_logic_and_expr);
					setState(166);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(167);
					match(AND);
					setState(168);
					inclusive_or_expr(0);
					}
					} 
				}
				setState(173);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Inclusive_or_exprContext extends ParserRuleContext {
		public Exclusive_or_exprContext exclusive_or_expr() {
			return getRuleContext(Exclusive_or_exprContext.class,0);
		}
		public Inclusive_or_exprContext inclusive_or_expr() {
			return getRuleContext(Inclusive_or_exprContext.class,0);
		}
		public TerminalNode BIT_OR() { return getToken(MogicParser.BIT_OR, 0); }
		public Inclusive_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inclusive_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterInclusive_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitInclusive_or_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitInclusive_or_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Inclusive_or_exprContext inclusive_or_expr() throws RecognitionException {
		return inclusive_or_expr(0);
	}

	private Inclusive_or_exprContext inclusive_or_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Inclusive_or_exprContext _localctx = new Inclusive_or_exprContext(_ctx, _parentState);
		Inclusive_or_exprContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_inclusive_or_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(175);
			exclusive_or_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(182);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Inclusive_or_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_inclusive_or_expr);
					setState(177);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(178);
					match(BIT_OR);
					setState(179);
					exclusive_or_expr(0);
					}
					} 
				}
				setState(184);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Exclusive_or_exprContext extends ParserRuleContext {
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public Exclusive_or_exprContext exclusive_or_expr() {
			return getRuleContext(Exclusive_or_exprContext.class,0);
		}
		public TerminalNode BIT_XOR() { return getToken(MogicParser.BIT_XOR, 0); }
		public Exclusive_or_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_exclusive_or_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterExclusive_or_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitExclusive_or_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitExclusive_or_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Exclusive_or_exprContext exclusive_or_expr() throws RecognitionException {
		return exclusive_or_expr(0);
	}

	private Exclusive_or_exprContext exclusive_or_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Exclusive_or_exprContext _localctx = new Exclusive_or_exprContext(_ctx, _parentState);
		Exclusive_or_exprContext _prevctx = _localctx;
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_exclusive_or_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(186);
			and_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Exclusive_or_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_exclusive_or_expr);
					setState(188);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(189);
					match(BIT_XOR);
					setState(190);
					and_expr(0);
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class And_exprContext extends ParserRuleContext {
		public Equ_exprContext equ_expr() {
			return getRuleContext(Equ_exprContext.class,0);
		}
		public And_exprContext and_expr() {
			return getRuleContext(And_exprContext.class,0);
		}
		public TerminalNode BIT_AND() { return getToken(MogicParser.BIT_AND, 0); }
		public And_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_and_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterAnd_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitAnd_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitAnd_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final And_exprContext and_expr() throws RecognitionException {
		return and_expr(0);
	}

	private And_exprContext and_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		And_exprContext _localctx = new And_exprContext(_ctx, _parentState);
		And_exprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_and_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(197);
			equ_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(204);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new And_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_and_expr);
					setState(199);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(200);
					match(BIT_AND);
					setState(201);
					equ_expr(0);
					}
					} 
				}
				setState(206);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Equ_exprContext extends ParserRuleContext {
		public Relational_exprContext relational_expr() {
			return getRuleContext(Relational_exprContext.class,0);
		}
		public Equ_exprContext equ_expr() {
			return getRuleContext(Equ_exprContext.class,0);
		}
		public Equality_operatorContext equality_operator() {
			return getRuleContext(Equality_operatorContext.class,0);
		}
		public Equ_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equ_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterEqu_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitEqu_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitEqu_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equ_exprContext equ_expr() throws RecognitionException {
		return equ_expr(0);
	}

	private Equ_exprContext equ_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Equ_exprContext _localctx = new Equ_exprContext(_ctx, _parentState);
		Equ_exprContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_equ_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(208);
			relational_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Equ_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_equ_expr);
					setState(210);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(211);
					equality_operator();
					setState(212);
					relational_expr(0);
					}
					} 
				}
				setState(218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,13,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Relational_exprContext extends ParserRuleContext {
		public Shift_exprContext shift_expr() {
			return getRuleContext(Shift_exprContext.class,0);
		}
		public Relational_exprContext relational_expr() {
			return getRuleContext(Relational_exprContext.class,0);
		}
		public Comparsion_operatorContext comparsion_operator() {
			return getRuleContext(Comparsion_operatorContext.class,0);
		}
		public Relational_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_relational_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterRelational_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitRelational_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitRelational_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Relational_exprContext relational_expr() throws RecognitionException {
		return relational_expr(0);
	}

	private Relational_exprContext relational_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Relational_exprContext _localctx = new Relational_exprContext(_ctx, _parentState);
		Relational_exprContext _prevctx = _localctx;
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_relational_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(220);
			shift_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Relational_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_relational_expr);
					setState(222);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(223);
					comparsion_operator();
					setState(224);
					shift_expr(0);
					}
					} 
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,14,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Shift_exprContext extends ParserRuleContext {
		public Additive_exprContext additive_expr() {
			return getRuleContext(Additive_exprContext.class,0);
		}
		public Shift_exprContext shift_expr() {
			return getRuleContext(Shift_exprContext.class,0);
		}
		public Shift_operatorContext shift_operator() {
			return getRuleContext(Shift_operatorContext.class,0);
		}
		public Shift_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterShift_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitShift_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitShift_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_exprContext shift_expr() throws RecognitionException {
		return shift_expr(0);
	}

	private Shift_exprContext shift_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Shift_exprContext _localctx = new Shift_exprContext(_ctx, _parentState);
		Shift_exprContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_shift_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(232);
			additive_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(240);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new Shift_exprContext(_parentctx, _parentState);
					pushNewRecursionContext(_localctx, _startState, RULE_shift_expr);
					setState(234);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(235);
					shift_operator();
					setState(236);
					additive_expr(0);
					}
					} 
				}
				setState(242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,15,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Additive_exprContext extends ParserRuleContext {
		public Muly_exprContext muly_expr() {
			return getRuleContext(Muly_exprContext.class,0);
		}
		public Additive_exprContext additive_expr() {
			return getRuleContext(Additive_exprContext.class,0);
		}
		public TerminalNode PLUS() { return getToken(MogicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MogicParser.MINUS, 0); }
		public Additive_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additive_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterAdditive_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitAdditive_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitAdditive_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Additive_exprContext additive_expr() throws RecognitionException {
		return additive_expr(0);
	}

	private Additive_exprContext additive_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Additive_exprContext _localctx = new Additive_exprContext(_ctx, _parentState);
		Additive_exprContext _prevctx = _localctx;
		int _startState = 36;
		enterRecursionRule(_localctx, 36, RULE_additive_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(244);
			muly_expr(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(254);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(252);
					switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
					case 1:
						{
						_localctx = new Additive_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive_expr);
						setState(246);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(247);
						match(PLUS);
						setState(248);
						muly_expr(0);
						}
						break;
					case 2:
						{
						_localctx = new Additive_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_additive_expr);
						setState(249);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(250);
						match(MINUS);
						setState(251);
						muly_expr(0);
						}
						break;
					}
					} 
				}
				setState(256);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,17,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Muly_exprContext extends ParserRuleContext {
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public Muly_exprContext muly_expr() {
			return getRuleContext(Muly_exprContext.class,0);
		}
		public TerminalNode MUL() { return getToken(MogicParser.MUL, 0); }
		public TerminalNode DIV() { return getToken(MogicParser.DIV, 0); }
		public TerminalNode REM() { return getToken(MogicParser.REM, 0); }
		public Muly_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_muly_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterMuly_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitMuly_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitMuly_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Muly_exprContext muly_expr() throws RecognitionException {
		return muly_expr(0);
	}

	private Muly_exprContext muly_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Muly_exprContext _localctx = new Muly_exprContext(_ctx, _parentState);
		Muly_exprContext _prevctx = _localctx;
		int _startState = 38;
		enterRecursionRule(_localctx, 38, RULE_muly_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(258);
			unary_expr();
			}
			_ctx.stop = _input.LT(-1);
			setState(271);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(269);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new Muly_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_muly_expr);
						setState(260);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(261);
						match(MUL);
						setState(262);
						unary_expr();
						}
						break;
					case 2:
						{
						_localctx = new Muly_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_muly_expr);
						setState(263);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(264);
						match(DIV);
						setState(265);
						unary_expr();
						}
						break;
					case 3:
						{
						_localctx = new Muly_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_muly_expr);
						setState(266);
						if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
						setState(267);
						match(REM);
						setState(268);
						unary_expr();
						}
						break;
					}
					} 
				}
				setState(273);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Unary_exprContext extends ParserRuleContext {
		public Postfix_exprContext postfix_expr() {
			return getRuleContext(Postfix_exprContext.class,0);
		}
		public Constructor_callContext constructor_call() {
			return getRuleContext(Constructor_callContext.class,0);
		}
		public TerminalNode DECREMENT() { return getToken(MogicParser.DECREMENT, 0); }
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(MogicParser.INCREMENT, 0); }
		public TerminalNode NOT() { return getToken(MogicParser.NOT, 0); }
		public Unary_operatorContext unary_operator() {
			return getRuleContext(Unary_operatorContext.class,0);
		}
		public Unary_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterUnary_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitUnary_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitUnary_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_exprContext unary_expr() throws RecognitionException {
		Unary_exprContext _localctx = new Unary_exprContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_unary_expr);
		try {
			setState(285);
			switch (_input.LA(1)) {
			case Int_literal:
			case NULL_LITERAL:
			case SIZE:
			case PRINT:
			case PRINTLN:
			case GETSTRING:
			case GETINT:
			case TOSTRING:
			case LENGTH:
			case SUBSTRING:
			case PARSEINT:
			case ORD:
			case TRUE:
			case FALSE:
			case String_literal:
			case OPB_RND:
			case IDEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(274);
				postfix_expr(0);
				}
				break;
			case NEW:
				enterOuterAlt(_localctx, 2);
				{
				setState(275);
				constructor_call();
				}
				break;
			case DECREMENT:
				enterOuterAlt(_localctx, 3);
				{
				setState(276);
				match(DECREMENT);
				setState(277);
				unary_expr();
				}
				break;
			case INCREMENT:
				enterOuterAlt(_localctx, 4);
				{
				setState(278);
				match(INCREMENT);
				setState(279);
				unary_expr();
				}
				break;
			case NOT:
				enterOuterAlt(_localctx, 5);
				{
				setState(280);
				match(NOT);
				setState(281);
				unary_expr();
				}
				break;
			case PLUS:
			case MINUS:
			case Tilde:
				enterOuterAlt(_localctx, 6);
				{
				setState(282);
				unary_operator();
				setState(283);
				unary_expr();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Constructor_callContext extends ParserRuleContext {
		public TerminalNode NEW() { return getToken(MogicParser.NEW, 0); }
		public Primitive_typeContext primitive_type() {
			return getRuleContext(Primitive_typeContext.class,0);
		}
		public Dim_exprContext dim_expr() {
			return getRuleContext(Dim_exprContext.class,0);
		}
		public List<Dim_SQContext> dim_SQ() {
			return getRuleContexts(Dim_SQContext.class);
		}
		public Dim_SQContext dim_SQ(int i) {
			return getRuleContext(Dim_SQContext.class,i);
		}
		public Constructor_callContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructor_call; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterConstructor_call(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitConstructor_call(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitConstructor_call(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Constructor_callContext constructor_call() throws RecognitionException {
		Constructor_callContext _localctx = new Constructor_callContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_constructor_call);
		try {
			int _alt;
			setState(298);
			switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(287);
				match(NEW);
				setState(288);
				primitive_type();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(289);
				match(NEW);
				setState(290);
				primitive_type();
				setState(291);
				dim_expr();
				setState(295);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(292);
						dim_SQ();
						}
						} 
					}
					setState(297);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dim_exprContext extends ParserRuleContext {
		public TerminalNode OPB_SQ() { return getToken(MogicParser.OPB_SQ, 0); }
		public Assignment_exprContext assignment_expr() {
			return getRuleContext(Assignment_exprContext.class,0);
		}
		public TerminalNode CLB_SQ() { return getToken(MogicParser.CLB_SQ, 0); }
		public Dim_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dim_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterDim_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitDim_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitDim_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dim_exprContext dim_expr() throws RecognitionException {
		Dim_exprContext _localctx = new Dim_exprContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_dim_expr);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(300);
			match(OPB_SQ);
			setState(301);
			assignment_expr();
			setState(302);
			match(CLB_SQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Arr_arg_suffixContext extends ParserRuleContext {
		public TerminalNode OPB_SQ() { return getToken(MogicParser.OPB_SQ, 0); }
		public Assignment_exprContext assignment_expr() {
			return getRuleContext(Assignment_exprContext.class,0);
		}
		public TerminalNode CLB_SQ() { return getToken(MogicParser.CLB_SQ, 0); }
		public Arr_arg_suffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arr_arg_suffix; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterArr_arg_suffix(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitArr_arg_suffix(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitArr_arg_suffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Arr_arg_suffixContext arr_arg_suffix() throws RecognitionException {
		Arr_arg_suffixContext _localctx = new Arr_arg_suffixContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_arr_arg_suffix);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(304);
			match(OPB_SQ);
			setState(305);
			assignment_expr();
			setState(306);
			match(CLB_SQ);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Argument_expr_listContext extends ParserRuleContext {
		public List<Assignment_exprContext> assignment_expr() {
			return getRuleContexts(Assignment_exprContext.class);
		}
		public Assignment_exprContext assignment_expr(int i) {
			return getRuleContext(Assignment_exprContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(MogicParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(MogicParser.COMMA, i);
		}
		public Argument_expr_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument_expr_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterArgument_expr_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitArgument_expr_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitArgument_expr_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Argument_expr_listContext argument_expr_list() throws RecognitionException {
		Argument_expr_listContext _localctx = new Argument_expr_listContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_argument_expr_list);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(308);
			assignment_expr();
			setState(313);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==COMMA) {
				{
				{
				setState(309);
				match(COMMA);
				setState(310);
				assignment_expr();
				}
				}
				setState(315);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Assignment_exprContext extends ParserRuleContext {
		public Unary_exprContext unary_expr() {
			return getRuleContext(Unary_exprContext.class,0);
		}
		public TerminalNode ASSIGN() { return getToken(MogicParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Logic_or_exprContext logic_or_expr() {
			return getRuleContext(Logic_or_exprContext.class,0);
		}
		public Assignment_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterAssignment_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitAssignment_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitAssignment_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Assignment_exprContext assignment_expr() throws RecognitionException {
		Assignment_exprContext _localctx = new Assignment_exprContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_assignment_expr);
		try {
			setState(321);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(316);
				unary_expr();
				setState(317);
				match(ASSIGN);
				setState(318);
				expr();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(320);
				logic_or_expr(0);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Postfix_exprContext extends ParserRuleContext {
		public ConstantContext constant() {
			return getRuleContext(ConstantContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode OPB_RND() { return getToken(MogicParser.OPB_RND, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLB_RND() { return getToken(MogicParser.CLB_RND, 0); }
		public Postfix_exprContext postfix_expr() {
			return getRuleContext(Postfix_exprContext.class,0);
		}
		public TerminalNode INCREMENT() { return getToken(MogicParser.INCREMENT, 0); }
		public TerminalNode DECREMENT() { return getToken(MogicParser.DECREMENT, 0); }
		public List<Arr_arg_suffixContext> arr_arg_suffix() {
			return getRuleContexts(Arr_arg_suffixContext.class);
		}
		public Arr_arg_suffixContext arr_arg_suffix(int i) {
			return getRuleContext(Arr_arg_suffixContext.class,i);
		}
		public TerminalNode DOT() { return getToken(MogicParser.DOT, 0); }
		public TerminalNode SIZE() { return getToken(MogicParser.SIZE, 0); }
		public TerminalNode LENGTH() { return getToken(MogicParser.LENGTH, 0); }
		public TerminalNode SUBSTRING() { return getToken(MogicParser.SUBSTRING, 0); }
		public List<Assignment_exprContext> assignment_expr() {
			return getRuleContexts(Assignment_exprContext.class);
		}
		public Assignment_exprContext assignment_expr(int i) {
			return getRuleContext(Assignment_exprContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(MogicParser.COMMA, 0); }
		public TerminalNode PARSEINT() { return getToken(MogicParser.PARSEINT, 0); }
		public TerminalNode ORD() { return getToken(MogicParser.ORD, 0); }
		public Argument_expr_listContext argument_expr_list() {
			return getRuleContext(Argument_expr_listContext.class,0);
		}
		public Postfix_exprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfix_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterPostfix_expr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitPostfix_expr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitPostfix_expr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Postfix_exprContext postfix_expr() throws RecognitionException {
		return postfix_expr(0);
	}

	private Postfix_exprContext postfix_expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		Postfix_exprContext _localctx = new Postfix_exprContext(_ctx, _parentState);
		Postfix_exprContext _prevctx = _localctx;
		int _startState = 52;
		enterRecursionRule(_localctx, 52, RULE_postfix_expr, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(330);
			switch (_input.LA(1)) {
			case Int_literal:
			case NULL_LITERAL:
			case TRUE:
			case FALSE:
			case String_literal:
				{
				setState(324);
				constant();
				}
				break;
			case SIZE:
			case PRINT:
			case PRINTLN:
			case GETSTRING:
			case GETINT:
			case TOSTRING:
			case LENGTH:
			case SUBSTRING:
			case PARSEINT:
			case ORD:
			case IDEN:
				{
				setState(325);
				id();
				}
				break;
			case OPB_RND:
				{
				setState(326);
				match(OPB_RND);
				setState(327);
				expr();
				setState(328);
				match(CLB_RND);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(382);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(380);
					switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
					case 1:
						{
						_localctx = new Postfix_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expr);
						setState(332);
						if (!(precpred(_ctx, 12))) throw new FailedPredicateException(this, "precpred(_ctx, 12)");
						setState(333);
						_la = _input.LA(1);
						if ( !(_la==INCREMENT || _la==DECREMENT) ) {
						_errHandler.recoverInline(this);
						} else {
							consume();
						}
						}
						break;
					case 2:
						{
						_localctx = new Postfix_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expr);
						setState(334);
						if (!(precpred(_ctx, 9))) throw new FailedPredicateException(this, "precpred(_ctx, 9)");
						setState(336); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(335);
								arr_arg_suffix();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(338); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,26,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						}
						break;
					case 3:
						{
						_localctx = new Postfix_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expr);
						setState(340);
						if (!(precpred(_ctx, 8))) throw new FailedPredicateException(this, "precpred(_ctx, 8)");
						setState(341);
						match(DOT);
						setState(342);
						match(SIZE);
						setState(343);
						match(OPB_RND);
						setState(344);
						match(CLB_RND);
						}
						break;
					case 4:
						{
						_localctx = new Postfix_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expr);
						setState(345);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(346);
						match(DOT);
						setState(347);
						match(LENGTH);
						setState(348);
						match(OPB_RND);
						setState(349);
						match(CLB_RND);
						}
						break;
					case 5:
						{
						_localctx = new Postfix_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expr);
						setState(350);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(351);
						match(DOT);
						setState(352);
						match(SUBSTRING);
						setState(353);
						match(OPB_RND);
						setState(354);
						assignment_expr();
						setState(355);
						match(COMMA);
						setState(356);
						assignment_expr();
						setState(357);
						match(CLB_RND);
						}
						break;
					case 6:
						{
						_localctx = new Postfix_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expr);
						setState(359);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(360);
						match(DOT);
						setState(361);
						match(PARSEINT);
						setState(362);
						match(OPB_RND);
						setState(363);
						match(CLB_RND);
						}
						break;
					case 7:
						{
						_localctx = new Postfix_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expr);
						setState(364);
						if (!(precpred(_ctx, 4))) throw new FailedPredicateException(this, "precpred(_ctx, 4)");
						setState(365);
						match(DOT);
						setState(366);
						match(ORD);
						setState(367);
						match(OPB_RND);
						setState(368);
						assignment_expr();
						setState(369);
						match(CLB_RND);
						}
						break;
					case 8:
						{
						_localctx = new Postfix_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expr);
						setState(371);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(372);
						match(OPB_RND);
						setState(374);
						_la = _input.LA(1);
						if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (Int_literal - 1)) | (1L << (NEW - 1)) | (1L << (NULL_LITERAL - 1)) | (1L << (SIZE - 1)) | (1L << (PRINT - 1)) | (1L << (PRINTLN - 1)) | (1L << (GETSTRING - 1)) | (1L << (GETINT - 1)) | (1L << (TOSTRING - 1)) | (1L << (LENGTH - 1)) | (1L << (SUBSTRING - 1)) | (1L << (PARSEINT - 1)) | (1L << (ORD - 1)) | (1L << (TRUE - 1)) | (1L << (FALSE - 1)) | (1L << (String_literal - 1)) | (1L << (INCREMENT - 1)) | (1L << (DECREMENT - 1)) | (1L << (OPB_RND - 1)) | (1L << (PLUS - 1)) | (1L << (MINUS - 1)) | (1L << (Tilde - 1)) | (1L << (NOT - 1)) | (1L << (IDEN - 1)))) != 0)) {
							{
							setState(373);
							argument_expr_list();
							}
						}

						setState(376);
						match(CLB_RND);
						}
						break;
					case 9:
						{
						_localctx = new Postfix_exprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_postfix_expr);
						setState(377);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(378);
						match(DOT);
						setState(379);
						id();
						}
						break;
					}
					} 
				}
				setState(384);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class Unary_operatorContext extends ParserRuleContext {
		public TerminalNode PLUS() { return getToken(MogicParser.PLUS, 0); }
		public TerminalNode MINUS() { return getToken(MogicParser.MINUS, 0); }
		public TerminalNode Tilde() { return getToken(MogicParser.Tilde, 0); }
		public Unary_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unary_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterUnary_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitUnary_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitUnary_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Unary_operatorContext unary_operator() throws RecognitionException {
		Unary_operatorContext _localctx = new Unary_operatorContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_unary_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(385);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << PLUS) | (1L << MINUS) | (1L << Tilde))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ConstantContext extends ParserRuleContext {
		public TerminalNode NULL_LITERAL() { return getToken(MogicParser.NULL_LITERAL, 0); }
		public Bool_literalContext bool_literal() {
			return getRuleContext(Bool_literalContext.class,0);
		}
		public TerminalNode Int_literal() { return getToken(MogicParser.Int_literal, 0); }
		public TerminalNode String_literal() { return getToken(MogicParser.String_literal, 0); }
		public ConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constant; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterConstant(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitConstant(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstantContext constant() throws RecognitionException {
		ConstantContext _localctx = new ConstantContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_constant);
		try {
			setState(391);
			switch (_input.LA(1)) {
			case NULL_LITERAL:
				enterOuterAlt(_localctx, 1);
				{
				setState(387);
				match(NULL_LITERAL);
				}
				break;
			case TRUE:
			case FALSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(388);
				bool_literal();
				}
				break;
			case Int_literal:
				enterOuterAlt(_localctx, 3);
				{
				setState(389);
				match(Int_literal);
				}
				break;
			case String_literal:
				enterOuterAlt(_localctx, 4);
				{
				setState(390);
				match(String_literal);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class StmtContext extends ParserRuleContext {
		public Block_stmtContext block_stmt() {
			return getRuleContext(Block_stmtContext.class,0);
		}
		public Var_decl_stmtContext var_decl_stmt() {
			return getRuleContext(Var_decl_stmtContext.class,0);
		}
		public Expr_stmtContext expr_stmt() {
			return getRuleContext(Expr_stmtContext.class,0);
		}
		public Selection_stmtContext selection_stmt() {
			return getRuleContext(Selection_stmtContext.class,0);
		}
		public Iteration_stmtContext iteration_stmt() {
			return getRuleContext(Iteration_stmtContext.class,0);
		}
		public Jump_stmtContext jump_stmt() {
			return getRuleContext(Jump_stmtContext.class,0);
		}
		public StmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterStmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitStmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitStmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StmtContext stmt() throws RecognitionException {
		StmtContext _localctx = new StmtContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_stmt);
		try {
			setState(399);
			switch ( getInterpreter().adaptivePredict(_input,31,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(393);
				block_stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(394);
				var_decl_stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(395);
				expr_stmt();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(396);
				selection_stmt();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(397);
				iteration_stmt();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(398);
				jump_stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Block_stmtContext extends ParserRuleContext {
		public TerminalNode OPB_FIG() { return getToken(MogicParser.OPB_FIG, 0); }
		public TerminalNode CLB_FIG() { return getToken(MogicParser.CLB_FIG, 0); }
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Block_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterBlock_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitBlock_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitBlock_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Block_stmtContext block_stmt() throws RecognitionException {
		Block_stmtContext _localctx = new Block_stmtContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_block_stmt);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(401);
			match(OPB_FIG);
			setState(403);
			_la = _input.LA(1);
			if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (Int_literal - 1)) | (1L << (IF - 1)) | (1L << (FOR - 1)) | (1L << (WHILE - 1)) | (1L << (CONTINUE - 1)) | (1L << (BREAK - 1)) | (1L << (RETURN - 1)) | (1L << (NEW - 1)) | (1L << (NULL_LITERAL - 1)) | (1L << (SIZE - 1)) | (1L << (PRINT - 1)) | (1L << (PRINTLN - 1)) | (1L << (GETSTRING - 1)) | (1L << (GETINT - 1)) | (1L << (TOSTRING - 1)) | (1L << (LENGTH - 1)) | (1L << (SUBSTRING - 1)) | (1L << (PARSEINT - 1)) | (1L << (ORD - 1)) | (1L << (TRUE - 1)) | (1L << (FALSE - 1)) | (1L << (String_literal - 1)) | (1L << (INCREMENT - 1)) | (1L << (DECREMENT - 1)) | (1L << (SEMICOLON - 1)) | (1L << (OPB_FIG - 1)) | (1L << (OPB_RND - 1)) | (1L << (PLUS - 1)) | (1L << (MINUS - 1)) | (1L << (Tilde - 1)) | (1L << (NOT - 1)) | (1L << (VOID - 1)) | (1L << (STRING - 1)) | (1L << (INT - 1)) | (1L << (BOOL - 1)) | (1L << (IDEN - 1)))) != 0)) {
				{
				setState(402);
				stmt_list();
				}
			}

			setState(405);
			match(CLB_FIG);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Stmt_listContext extends ParserRuleContext {
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public Stmt_listContext stmt_list() {
			return getRuleContext(Stmt_listContext.class,0);
		}
		public Stmt_listContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stmt_list; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterStmt_list(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitStmt_list(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitStmt_list(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Stmt_listContext stmt_list() throws RecognitionException {
		Stmt_listContext _localctx = new Stmt_listContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_stmt_list);
		try {
			setState(411);
			switch ( getInterpreter().adaptivePredict(_input,33,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(407);
				stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(408);
				stmt();
				setState(409);
				stmt_list();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr_stmtContext extends ParserRuleContext {
		public TerminalNode SEMICOLON() { return getToken(MogicParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterExpr_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitExpr_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitExpr_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr_stmtContext expr_stmt() throws RecognitionException {
		Expr_stmtContext _localctx = new Expr_stmtContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_expr_stmt);
		try {
			setState(417);
			switch (_input.LA(1)) {
			case SEMICOLON:
				enterOuterAlt(_localctx, 1);
				{
				setState(413);
				match(SEMICOLON);
				}
				break;
			case Int_literal:
			case NEW:
			case NULL_LITERAL:
			case SIZE:
			case PRINT:
			case PRINTLN:
			case GETSTRING:
			case GETINT:
			case TOSTRING:
			case LENGTH:
			case SUBSTRING:
			case PARSEINT:
			case ORD:
			case TRUE:
			case FALSE:
			case String_literal:
			case INCREMENT:
			case DECREMENT:
			case OPB_RND:
			case PLUS:
			case MINUS:
			case Tilde:
			case NOT:
			case IDEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(414);
				expr();
				setState(415);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Jump_stmtContext extends ParserRuleContext {
		public TerminalNode RETURN() { return getToken(MogicParser.RETURN, 0); }
		public TerminalNode SEMICOLON() { return getToken(MogicParser.SEMICOLON, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode BREAK() { return getToken(MogicParser.BREAK, 0); }
		public TerminalNode CONTINUE() { return getToken(MogicParser.CONTINUE, 0); }
		public Jump_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jump_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterJump_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitJump_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitJump_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Jump_stmtContext jump_stmt() throws RecognitionException {
		Jump_stmtContext _localctx = new Jump_stmtContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_jump_stmt);
		int _la;
		try {
			setState(428);
			switch (_input.LA(1)) {
			case RETURN:
				enterOuterAlt(_localctx, 1);
				{
				setState(419);
				match(RETURN);
				setState(421);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (Int_literal - 1)) | (1L << (NEW - 1)) | (1L << (NULL_LITERAL - 1)) | (1L << (SIZE - 1)) | (1L << (PRINT - 1)) | (1L << (PRINTLN - 1)) | (1L << (GETSTRING - 1)) | (1L << (GETINT - 1)) | (1L << (TOSTRING - 1)) | (1L << (LENGTH - 1)) | (1L << (SUBSTRING - 1)) | (1L << (PARSEINT - 1)) | (1L << (ORD - 1)) | (1L << (TRUE - 1)) | (1L << (FALSE - 1)) | (1L << (String_literal - 1)) | (1L << (INCREMENT - 1)) | (1L << (DECREMENT - 1)) | (1L << (OPB_RND - 1)) | (1L << (PLUS - 1)) | (1L << (MINUS - 1)) | (1L << (Tilde - 1)) | (1L << (NOT - 1)) | (1L << (IDEN - 1)))) != 0)) {
					{
					setState(420);
					expr();
					}
				}

				setState(423);
				match(SEMICOLON);
				}
				break;
			case BREAK:
				enterOuterAlt(_localctx, 2);
				{
				setState(424);
				match(BREAK);
				setState(425);
				match(SEMICOLON);
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(426);
				match(CONTINUE);
				setState(427);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Selection_stmtContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(MogicParser.IF, 0); }
		public TerminalNode OPB_RND() { return getToken(MogicParser.OPB_RND, 0); }
		public List<Expr1Context> expr1() {
			return getRuleContexts(Expr1Context.class);
		}
		public Expr1Context expr1(int i) {
			return getRuleContext(Expr1Context.class,i);
		}
		public List<TerminalNode> AND() { return getTokens(MogicParser.AND); }
		public TerminalNode AND(int i) {
			return getToken(MogicParser.AND, i);
		}
		public TerminalNode CLB_RND() { return getToken(MogicParser.CLB_RND, 0); }
		public List<StmtContext> stmt() {
			return getRuleContexts(StmtContext.class);
		}
		public StmtContext stmt(int i) {
			return getRuleContext(StmtContext.class,i);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(MogicParser.ELSE, 0); }
		public Selection_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_selection_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterSelection_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitSelection_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitSelection_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Selection_stmtContext selection_stmt() throws RecognitionException {
		Selection_stmtContext _localctx = new Selection_stmtContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_selection_stmt);
		try {
			setState(530);
			switch ( getInterpreter().adaptivePredict(_input,37,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(430);
				match(IF);
				setState(431);
				match(OPB_RND);
				setState(432);
				expr1();
				setState(433);
				match(AND);
				setState(434);
				expr1();
				setState(435);
				match(AND);
				setState(436);
				expr1();
				setState(437);
				match(AND);
				setState(438);
				expr1();
				setState(439);
				match(AND);
				setState(440);
				expr1();
				setState(441);
				match(AND);
				setState(442);
				expr1();
				setState(443);
				match(AND);
				setState(444);
				expr1();
				setState(445);
				match(AND);
				setState(446);
				expr1();
				setState(447);
				match(AND);
				setState(448);
				expr1();
				setState(449);
				match(AND);
				setState(450);
				expr1();
				setState(451);
				match(AND);
				setState(452);
				expr1();
				setState(453);
				match(AND);
				setState(454);
				expr1();
				setState(455);
				match(AND);
				setState(456);
				expr1();
				setState(457);
				match(AND);
				setState(458);
				expr1();
				setState(459);
				match(AND);
				setState(460);
				expr1();
				setState(461);
				match(AND);
				setState(462);
				expr1();
				setState(463);
				match(AND);
				setState(464);
				expr1();
				setState(465);
				match(AND);
				setState(466);
				expr1();
				setState(467);
				match(AND);
				setState(468);
				expr1();
				setState(469);
				match(AND);
				setState(470);
				expr1();
				setState(471);
				match(AND);
				setState(472);
				expr1();
				setState(473);
				match(AND);
				setState(474);
				expr1();
				setState(475);
				match(AND);
				setState(476);
				expr1();
				setState(477);
				match(AND);
				setState(478);
				expr1();
				setState(479);
				match(AND);
				setState(480);
				expr1();
				setState(481);
				match(AND);
				setState(482);
				expr1();
				setState(483);
				match(AND);
				setState(484);
				expr1();
				setState(485);
				match(AND);
				setState(486);
				expr1();
				setState(487);
				match(AND);
				setState(488);
				expr1();
				setState(489);
				match(AND);
				setState(490);
				expr1();
				setState(491);
				match(AND);
				setState(492);
				expr1();
				setState(493);
				match(AND);
				setState(494);
				expr1();
				setState(495);
				match(AND);
				setState(496);
				expr1();
				setState(497);
				match(AND);
				setState(498);
				expr1();
				setState(499);
				match(AND);
				setState(500);
				expr1();
				setState(501);
				match(AND);
				setState(502);
				expr1();
				setState(503);
				match(AND);
				setState(504);
				expr1();
				setState(505);
				match(AND);
				setState(506);
				expr1();
				setState(507);
				match(AND);
				setState(508);
				expr1();
				setState(509);
				match(AND);
				setState(510);
				expr1();
				setState(511);
				match(AND);
				setState(512);
				expr1();
				setState(513);
				match(CLB_RND);
				setState(514);
				stmt();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(516);
				match(IF);
				setState(517);
				match(OPB_RND);
				setState(518);
				expr();
				setState(519);
				match(CLB_RND);
				setState(520);
				stmt();
				setState(521);
				match(ELSE);
				setState(522);
				stmt();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(524);
				match(IF);
				setState(525);
				match(OPB_RND);
				setState(526);
				expr();
				setState(527);
				match(CLB_RND);
				setState(528);
				stmt();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Iteration_stmtContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(MogicParser.WHILE, 0); }
		public TerminalNode OPB_RND() { return getToken(MogicParser.OPB_RND, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode CLB_RND() { return getToken(MogicParser.CLB_RND, 0); }
		public StmtContext stmt() {
			return getRuleContext(StmtContext.class,0);
		}
		public TerminalNode FOR() { return getToken(MogicParser.FOR, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(MogicParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(MogicParser.SEMICOLON, i);
		}
		public Expr0Context expr0() {
			return getRuleContext(Expr0Context.class,0);
		}
		public Expr1Context expr1() {
			return getRuleContext(Expr1Context.class,0);
		}
		public Iteration_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_iteration_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterIteration_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitIteration_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitIteration_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Iteration_stmtContext iteration_stmt() throws RecognitionException {
		Iteration_stmtContext _localctx = new Iteration_stmtContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_iteration_stmt);
		int _la;
		try {
			setState(553);
			switch (_input.LA(1)) {
			case WHILE:
				enterOuterAlt(_localctx, 1);
				{
				setState(532);
				match(WHILE);
				setState(533);
				match(OPB_RND);
				setState(534);
				expr();
				setState(535);
				match(CLB_RND);
				setState(536);
				stmt();
				}
				break;
			case FOR:
				enterOuterAlt(_localctx, 2);
				{
				setState(538);
				match(FOR);
				setState(539);
				match(OPB_RND);
				setState(541);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (Int_literal - 1)) | (1L << (NEW - 1)) | (1L << (NULL_LITERAL - 1)) | (1L << (SIZE - 1)) | (1L << (PRINT - 1)) | (1L << (PRINTLN - 1)) | (1L << (GETSTRING - 1)) | (1L << (GETINT - 1)) | (1L << (TOSTRING - 1)) | (1L << (LENGTH - 1)) | (1L << (SUBSTRING - 1)) | (1L << (PARSEINT - 1)) | (1L << (ORD - 1)) | (1L << (TRUE - 1)) | (1L << (FALSE - 1)) | (1L << (String_literal - 1)) | (1L << (INCREMENT - 1)) | (1L << (DECREMENT - 1)) | (1L << (OPB_RND - 1)) | (1L << (PLUS - 1)) | (1L << (MINUS - 1)) | (1L << (Tilde - 1)) | (1L << (NOT - 1)) | (1L << (IDEN - 1)))) != 0)) {
					{
					setState(540);
					expr0();
					}
				}

				setState(543);
				match(SEMICOLON);
				setState(545);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (Int_literal - 1)) | (1L << (NEW - 1)) | (1L << (NULL_LITERAL - 1)) | (1L << (SIZE - 1)) | (1L << (PRINT - 1)) | (1L << (PRINTLN - 1)) | (1L << (GETSTRING - 1)) | (1L << (GETINT - 1)) | (1L << (TOSTRING - 1)) | (1L << (LENGTH - 1)) | (1L << (SUBSTRING - 1)) | (1L << (PARSEINT - 1)) | (1L << (ORD - 1)) | (1L << (TRUE - 1)) | (1L << (FALSE - 1)) | (1L << (String_literal - 1)) | (1L << (INCREMENT - 1)) | (1L << (DECREMENT - 1)) | (1L << (OPB_RND - 1)) | (1L << (PLUS - 1)) | (1L << (MINUS - 1)) | (1L << (Tilde - 1)) | (1L << (NOT - 1)) | (1L << (IDEN - 1)))) != 0)) {
					{
					setState(544);
					expr1();
					}
				}

				setState(547);
				match(SEMICOLON);
				setState(549);
				_la = _input.LA(1);
				if (((((_la - 1)) & ~0x3f) == 0 && ((1L << (_la - 1)) & ((1L << (Int_literal - 1)) | (1L << (NEW - 1)) | (1L << (NULL_LITERAL - 1)) | (1L << (SIZE - 1)) | (1L << (PRINT - 1)) | (1L << (PRINTLN - 1)) | (1L << (GETSTRING - 1)) | (1L << (GETINT - 1)) | (1L << (TOSTRING - 1)) | (1L << (LENGTH - 1)) | (1L << (SUBSTRING - 1)) | (1L << (PARSEINT - 1)) | (1L << (ORD - 1)) | (1L << (TRUE - 1)) | (1L << (FALSE - 1)) | (1L << (String_literal - 1)) | (1L << (INCREMENT - 1)) | (1L << (DECREMENT - 1)) | (1L << (OPB_RND - 1)) | (1L << (PLUS - 1)) | (1L << (MINUS - 1)) | (1L << (Tilde - 1)) | (1L << (NOT - 1)) | (1L << (IDEN - 1)))) != 0)) {
					{
					setState(548);
					expr();
					}
				}

				setState(551);
				match(CLB_RND);
				setState(552);
				stmt();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr0Context extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr0Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr0; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterExpr0(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitExpr0(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitExpr0(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr0Context expr0() throws RecognitionException {
		Expr0Context _localctx = new Expr0Context(_ctx, getState());
		enterRule(_localctx, 72, RULE_expr0);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Expr1Context extends ParserRuleContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Expr1Context(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr1; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterExpr1(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitExpr1(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitExpr1(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Expr1Context expr1() throws RecognitionException {
		Expr1Context _localctx = new Expr1Context(_ctx, getState());
		enterRule(_localctx, 74, RULE_expr1);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(557);
			expr();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Var_decl_stmtContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(MogicParser.SEMICOLON, 0); }
		public TerminalNode ASSIGN() { return getToken(MogicParser.ASSIGN, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public Var_decl_stmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_var_decl_stmt; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterVar_decl_stmt(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitVar_decl_stmt(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitVar_decl_stmt(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Var_decl_stmtContext var_decl_stmt() throws RecognitionException {
		Var_decl_stmtContext _localctx = new Var_decl_stmtContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_var_decl_stmt);
		try {
			setState(569);
			switch ( getInterpreter().adaptivePredict(_input,42,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(559);
				type();
				setState(560);
				id();
				setState(561);
				match(SEMICOLON);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(563);
				type();
				setState(564);
				id();
				setState(565);
				match(ASSIGN);
				setState(566);
				expr();
				setState(567);
				match(SEMICOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Primitive_typeContext extends ParserRuleContext {
		public TerminalNode INT() { return getToken(MogicParser.INT, 0); }
		public TerminalNode STRING() { return getToken(MogicParser.STRING, 0); }
		public IdContext id() {
			return getRuleContext(IdContext.class,0);
		}
		public TerminalNode BOOL() { return getToken(MogicParser.BOOL, 0); }
		public TerminalNode VOID() { return getToken(MogicParser.VOID, 0); }
		public Primitive_typeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primitive_type; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterPrimitive_type(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitPrimitive_type(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitPrimitive_type(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Primitive_typeContext primitive_type() throws RecognitionException {
		Primitive_typeContext _localctx = new Primitive_typeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_primitive_type);
		try {
			setState(576);
			switch (_input.LA(1)) {
			case INT:
				enterOuterAlt(_localctx, 1);
				{
				setState(571);
				match(INT);
				}
				break;
			case STRING:
				enterOuterAlt(_localctx, 2);
				{
				setState(572);
				match(STRING);
				}
				break;
			case SIZE:
			case PRINT:
			case PRINTLN:
			case GETSTRING:
			case GETINT:
			case TOSTRING:
			case LENGTH:
			case SUBSTRING:
			case PARSEINT:
			case ORD:
			case IDEN:
				enterOuterAlt(_localctx, 3);
				{
				setState(573);
				id();
				}
				break;
			case BOOL:
				enterOuterAlt(_localctx, 4);
				{
				setState(574);
				match(BOOL);
				}
				break;
			case VOID:
				enterOuterAlt(_localctx, 5);
				{
				setState(575);
				match(VOID);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bool_literalContext extends ParserRuleContext {
		public TerminalNode TRUE() { return getToken(MogicParser.TRUE, 0); }
		public TerminalNode FALSE() { return getToken(MogicParser.FALSE, 0); }
		public Bool_literalContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bool_literal; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterBool_literal(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitBool_literal(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitBool_literal(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bool_literalContext bool_literal() throws RecognitionException {
		Bool_literalContext _localctx = new Bool_literalContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_bool_literal);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(578);
			_la = _input.LA(1);
			if ( !(_la==TRUE || _la==FALSE) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Equality_operatorContext extends ParserRuleContext {
		public TerminalNode EQ() { return getToken(MogicParser.EQ, 0); }
		public TerminalNode NEQ() { return getToken(MogicParser.NEQ, 0); }
		public Equality_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterEquality_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitEquality_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitEquality_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Equality_operatorContext equality_operator() throws RecognitionException {
		Equality_operatorContext _localctx = new Equality_operatorContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_equality_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(580);
			_la = _input.LA(1);
			if ( !(_la==EQ || _la==NEQ) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Comparsion_operatorContext extends ParserRuleContext {
		public TerminalNode GT() { return getToken(MogicParser.GT, 0); }
		public TerminalNode LT() { return getToken(MogicParser.LT, 0); }
		public TerminalNode GE() { return getToken(MogicParser.GE, 0); }
		public TerminalNode LE() { return getToken(MogicParser.LE, 0); }
		public Comparsion_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparsion_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterComparsion_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitComparsion_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitComparsion_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Comparsion_operatorContext comparsion_operator() throws RecognitionException {
		Comparsion_operatorContext _localctx = new Comparsion_operatorContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_comparsion_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(582);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << GT) | (1L << LT) | (1L << GE) | (1L << LE))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Shift_operatorContext extends ParserRuleContext {
		public TerminalNode LSHIFT() { return getToken(MogicParser.LSHIFT, 0); }
		public TerminalNode RSHIFT() { return getToken(MogicParser.RSHIFT, 0); }
		public Shift_operatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_shift_operator; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterShift_operator(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitShift_operator(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitShift_operator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Shift_operatorContext shift_operator() throws RecognitionException {
		Shift_operatorContext _localctx = new Shift_operatorContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_shift_operator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(584);
			_la = _input.LA(1);
			if ( !(_la==LSHIFT || _la==RSHIFT) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class IdContext extends ParserRuleContext {
		public TerminalNode SIZE() { return getToken(MogicParser.SIZE, 0); }
		public TerminalNode PRINT() { return getToken(MogicParser.PRINT, 0); }
		public TerminalNode PRINTLN() { return getToken(MogicParser.PRINTLN, 0); }
		public TerminalNode GETSTRING() { return getToken(MogicParser.GETSTRING, 0); }
		public TerminalNode GETINT() { return getToken(MogicParser.GETINT, 0); }
		public TerminalNode TOSTRING() { return getToken(MogicParser.TOSTRING, 0); }
		public TerminalNode LENGTH() { return getToken(MogicParser.LENGTH, 0); }
		public TerminalNode SUBSTRING() { return getToken(MogicParser.SUBSTRING, 0); }
		public TerminalNode PARSEINT() { return getToken(MogicParser.PARSEINT, 0); }
		public TerminalNode ORD() { return getToken(MogicParser.ORD, 0); }
		public TerminalNode IDEN() { return getToken(MogicParser.IDEN, 0); }
		public IdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_id; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).enterId(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof MogicListener ) ((MogicListener)listener).exitId(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof MogicVisitor ) return ((MogicVisitor<? extends T>)visitor).visitId(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdContext id() throws RecognitionException {
		IdContext _localctx = new IdContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_id);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(586);
			_la = _input.LA(1);
			if ( !(((((_la - 12)) & ~0x3f) == 0 && ((1L << (_la - 12)) & ((1L << (SIZE - 12)) | (1L << (PRINT - 12)) | (1L << (PRINTLN - 12)) | (1L << (GETSTRING - 12)) | (1L << (GETINT - 12)) | (1L << (TOSTRING - 12)) | (1L << (LENGTH - 12)) | (1L << (SUBSTRING - 12)) | (1L << (PARSEINT - 12)) | (1L << (ORD - 12)) | (1L << (IDEN - 12)))) != 0)) ) {
			_errHandler.recoverInline(this);
			} else {
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 10:
			return logic_or_expr_sempred((Logic_or_exprContext)_localctx, predIndex);
		case 11:
			return logic_and_expr_sempred((Logic_and_exprContext)_localctx, predIndex);
		case 12:
			return inclusive_or_expr_sempred((Inclusive_or_exprContext)_localctx, predIndex);
		case 13:
			return exclusive_or_expr_sempred((Exclusive_or_exprContext)_localctx, predIndex);
		case 14:
			return and_expr_sempred((And_exprContext)_localctx, predIndex);
		case 15:
			return equ_expr_sempred((Equ_exprContext)_localctx, predIndex);
		case 16:
			return relational_expr_sempred((Relational_exprContext)_localctx, predIndex);
		case 17:
			return shift_expr_sempred((Shift_exprContext)_localctx, predIndex);
		case 18:
			return additive_expr_sempred((Additive_exprContext)_localctx, predIndex);
		case 19:
			return muly_expr_sempred((Muly_exprContext)_localctx, predIndex);
		case 26:
			return postfix_expr_sempred((Postfix_exprContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logic_or_expr_sempred(Logic_or_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean logic_and_expr_sempred(Logic_and_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean inclusive_or_expr_sempred(Inclusive_or_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean exclusive_or_expr_sempred(Exclusive_or_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 3:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean and_expr_sempred(And_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean equ_expr_sempred(Equ_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 5:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean relational_expr_sempred(Relational_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean shift_expr_sempred(Shift_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 7:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean additive_expr_sempred(Additive_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 8:
			return precpred(_ctx, 2);
		case 9:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean muly_expr_sempred(Muly_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 10:
			return precpred(_ctx, 3);
		case 11:
			return precpred(_ctx, 2);
		case 12:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean postfix_expr_sempred(Postfix_exprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 13:
			return precpred(_ctx, 12);
		case 14:
			return precpred(_ctx, 9);
		case 15:
			return precpred(_ctx, 8);
		case 16:
			return precpred(_ctx, 7);
		case 17:
			return precpred(_ctx, 6);
		case 18:
			return precpred(_ctx, 5);
		case 19:
			return precpred(_ctx, 4);
		case 20:
			return precpred(_ctx, 3);
		case 21:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\3D\u024f\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\3\2\3\2\3\3\3\3\5\3a\n\3\3\3\3\3\5\3e\n\3\3\3\3\3\5\3"+
		"i\n\3\5\3k\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\5\6\5t\n\5\r\5\16\5u\3\6\3\6"+
		"\3\6\3\6\3\7\3\7\3\7\3\7\5\7\u0080\n\7\3\7\3\7\3\7\3\b\3\b\3\b\3\b\3\b"+
		"\3\b\3\b\3\b\5\b\u008d\n\b\3\t\3\t\7\t\u0091\n\t\f\t\16\t\u0094\13\t\3"+
		"\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\f\7\f\u00a1\n\f\f\f\16\f\u00a4"+
		"\13\f\3\r\3\r\3\r\3\r\3\r\3\r\7\r\u00ac\n\r\f\r\16\r\u00af\13\r\3\16\3"+
		"\16\3\16\3\16\3\16\3\16\7\16\u00b7\n\16\f\16\16\16\u00ba\13\16\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\7\17\u00c2\n\17\f\17\16\17\u00c5\13\17\3\20\3"+
		"\20\3\20\3\20\3\20\3\20\7\20\u00cd\n\20\f\20\16\20\u00d0\13\20\3\21\3"+
		"\21\3\21\3\21\3\21\3\21\3\21\7\21\u00d9\n\21\f\21\16\21\u00dc\13\21\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u00e5\n\22\f\22\16\22\u00e8\13"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\7\23\u00f1\n\23\f\23\16\23\u00f4"+
		"\13\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\7\24\u00ff\n\24\f"+
		"\24\16\24\u0102\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\25\7\25\u0110\n\25\f\25\16\25\u0113\13\25\3\26\3\26\3\26\3\26"+
		"\3\26\3\26\3\26\3\26\3\26\3\26\3\26\5\26\u0120\n\26\3\27\3\27\3\27\3\27"+
		"\3\27\3\27\7\27\u0128\n\27\f\27\16\27\u012b\13\27\5\27\u012d\n\27\3\30"+
		"\3\30\3\30\3\30\3\31\3\31\3\31\3\31\3\32\3\32\3\32\7\32\u013a\n\32\f\32"+
		"\16\32\u013d\13\32\3\33\3\33\3\33\3\33\3\33\5\33\u0144\n\33\3\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\34\5\34\u014d\n\34\3\34\3\34\3\34\3\34\6\34\u0153"+
		"\n\34\r\34\16\34\u0154\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\3\34\5\34\u0179\n\34"+
		"\3\34\3\34\3\34\3\34\7\34\u017f\n\34\f\34\16\34\u0182\13\34\3\35\3\35"+
		"\3\36\3\36\3\36\3\36\5\36\u018a\n\36\3\37\3\37\3\37\3\37\3\37\3\37\5\37"+
		"\u0192\n\37\3 \3 \5 \u0196\n \3 \3 \3!\3!\3!\3!\5!\u019e\n!\3\"\3\"\3"+
		"\"\3\"\5\"\u01a4\n\"\3#\3#\5#\u01a8\n#\3#\3#\3#\3#\3#\5#\u01af\n#\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3$\3"+
		"$\3$\3$\3$\3$\3$\3$\5$\u0215\n$\3%\3%\3%\3%\3%\3%\3%\3%\3%\5%\u0220\n"+
		"%\3%\3%\5%\u0224\n%\3%\3%\5%\u0228\n%\3%\3%\5%\u022c\n%\3&\3&\3\'\3\'"+
		"\3(\3(\3(\3(\3(\3(\3(\3(\3(\3(\5(\u023c\n(\3)\3)\3)\3)\3)\5)\u0243\n)"+
		"\3*\3*\3+\3+\3,\3,\3-\3-\3.\3.\3.\2\r\26\30\32\34\36 \"$&(\66/\2\4\6\b"+
		"\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\64\668:<>@BDFHJLNPRTVX"+
		"Z\2\t\3\2#$\4\2\60\6188\3\2\30\31\3\2\33\34\3\2\35 \3\2!\"\4\2\16\27B"+
		"B\u0266\2\\\3\2\2\2\4j\3\2\2\2\6l\3\2\2\2\bs\3\2\2\2\nw\3\2\2\2\f{\3\2"+
		"\2\2\16\u008c\3\2\2\2\20\u008e\3\2\2\2\22\u0095\3\2\2\2\24\u0098\3\2\2"+
		"\2\26\u009a\3\2\2\2\30\u00a5\3\2\2\2\32\u00b0\3\2\2\2\34\u00bb\3\2\2\2"+
		"\36\u00c6\3\2\2\2 \u00d1\3\2\2\2\"\u00dd\3\2\2\2$\u00e9\3\2\2\2&\u00f5"+
		"\3\2\2\2(\u0103\3\2\2\2*\u011f\3\2\2\2,\u012c\3\2\2\2.\u012e\3\2\2\2\60"+
		"\u0132\3\2\2\2\62\u0136\3\2\2\2\64\u0143\3\2\2\2\66\u014c\3\2\2\28\u0183"+
		"\3\2\2\2:\u0189\3\2\2\2<\u0191\3\2\2\2>\u0193\3\2\2\2@\u019d\3\2\2\2B"+
		"\u01a3\3\2\2\2D\u01ae\3\2\2\2F\u0214\3\2\2\2H\u022b\3\2\2\2J\u022d\3\2"+
		"\2\2L\u022f\3\2\2\2N\u023b\3\2\2\2P\u0242\3\2\2\2R\u0244\3\2\2\2T\u0246"+
		"\3\2\2\2V\u0248\3\2\2\2X\u024a\3\2\2\2Z\u024c\3\2\2\2\\]\5\4\3\2]\3\3"+
		"\2\2\2^`\5\6\4\2_a\5\4\3\2`_\3\2\2\2`a\3\2\2\2ak\3\2\2\2bd\5\f\7\2ce\5"+
		"\4\3\2dc\3\2\2\2de\3\2\2\2ek\3\2\2\2fh\5N(\2gi\5\4\3\2hg\3\2\2\2hi\3\2"+
		"\2\2ik\3\2\2\2j^\3\2\2\2jb\3\2\2\2jf\3\2\2\2k\5\3\2\2\2lm\7\f\2\2mn\5"+
		"Z.\2no\7&\2\2op\5\b\5\2pq\7\'\2\2q\7\3\2\2\2rt\5\n\6\2sr\3\2\2\2tu\3\2"+
		"\2\2us\3\2\2\2uv\3\2\2\2v\t\3\2\2\2wx\5\20\t\2xy\5Z.\2yz\7%\2\2z\13\3"+
		"\2\2\2{|\5\20\t\2|}\5Z.\2}\177\7(\2\2~\u0080\5\16\b\2\177~\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u0082\7)\2\2\u0082\u0083\5> "+
		"\2\u0083\r\3\2\2\2\u0084\u0085\5\20\t\2\u0085\u0086\5Z.\2\u0086\u008d"+
		"\3\2\2\2\u0087\u0088\5\20\t\2\u0088\u0089\5Z.\2\u0089\u008a\7-\2\2\u008a"+
		"\u008b\5\16\b\2\u008b\u008d\3\2\2\2\u008c\u0084\3\2\2\2\u008c\u0087\3"+
		"\2\2\2\u008d\17\3\2\2\2\u008e\u0092\5P)\2\u008f\u0091\5\22\n\2\u0090\u008f"+
		"\3\2\2\2\u0091\u0094\3\2\2\2\u0092\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093"+
		"\21\3\2\2\2\u0094\u0092\3\2\2\2\u0095\u0096\7*\2\2\u0096\u0097\7+\2\2"+
		"\u0097\23\3\2\2\2\u0098\u0099\5\64\33\2\u0099\25\3\2\2\2\u009a\u009b\b"+
		"\f\1\2\u009b\u009c\5\30\r\2\u009c\u00a2\3\2\2\2\u009d\u009e\f\3\2\2\u009e"+
		"\u009f\7:\2\2\u009f\u00a1\5\30\r\2\u00a0\u009d\3\2\2\2\u00a1\u00a4\3\2"+
		"\2\2\u00a2\u00a0\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\27\3\2\2\2\u00a4\u00a2"+
		"\3\2\2\2\u00a5\u00a6\b\r\1\2\u00a6\u00a7\5\32\16\2\u00a7\u00ad\3\2\2\2"+
		"\u00a8\u00a9\f\3\2\2\u00a9\u00aa\79\2\2\u00aa\u00ac\5\32\16\2\u00ab\u00a8"+
		"\3\2\2\2\u00ac\u00af\3\2\2\2\u00ad\u00ab\3\2\2\2\u00ad\u00ae\3\2\2\2\u00ae"+
		"\31\3\2\2\2\u00af\u00ad\3\2\2\2\u00b0\u00b1\b\16\1\2\u00b1\u00b2\5\34"+
		"\17\2\u00b2\u00b8\3\2\2\2\u00b3\u00b4\f\3\2\2\u00b4\u00b5\7\66\2\2\u00b5"+
		"\u00b7\5\34\17\2\u00b6\u00b3\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3"+
		"\2\2\2\u00b8\u00b9\3\2\2\2\u00b9\33\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb"+
		"\u00bc\b\17\1\2\u00bc\u00bd\5\36\20\2\u00bd\u00c3\3\2\2\2\u00be\u00bf"+
		"\f\3\2\2\u00bf\u00c0\7\67\2\2\u00c0\u00c2\5\36\20\2\u00c1\u00be\3\2\2"+
		"\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3\u00c4\3\2\2\2\u00c4\35"+
		"\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\b\20\1\2\u00c7\u00c8\5 \21\2"+
		"\u00c8\u00ce\3\2\2\2\u00c9\u00ca\f\3\2\2\u00ca\u00cb\7\65\2\2\u00cb\u00cd"+
		"\5 \21\2\u00cc\u00c9\3\2\2\2\u00cd\u00d0\3\2\2\2\u00ce\u00cc\3\2\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\37\3\2\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\b\21\1"+
		"\2\u00d2\u00d3\5\"\22\2\u00d3\u00da\3\2\2\2\u00d4\u00d5\f\3\2\2\u00d5"+
		"\u00d6\5T+\2\u00d6\u00d7\5\"\22\2\u00d7\u00d9\3\2\2\2\u00d8\u00d4\3\2"+
		"\2\2\u00d9\u00dc\3\2\2\2\u00da\u00d8\3\2\2\2\u00da\u00db\3\2\2\2\u00db"+
		"!\3\2\2\2\u00dc\u00da\3\2\2\2\u00dd\u00de\b\22\1\2\u00de\u00df\5$\23\2"+
		"\u00df\u00e6\3\2\2\2\u00e0\u00e1\f\3\2\2\u00e1\u00e2\5V,\2\u00e2\u00e3"+
		"\5$\23\2\u00e3\u00e5\3\2\2\2\u00e4\u00e0\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6"+
		"\u00e4\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7#\3\2\2\2\u00e8\u00e6\3\2\2\2"+
		"\u00e9\u00ea\b\23\1\2\u00ea\u00eb\5&\24\2\u00eb\u00f2\3\2\2\2\u00ec\u00ed"+
		"\f\3\2\2\u00ed\u00ee\5X-\2\u00ee\u00ef\5&\24\2\u00ef\u00f1\3\2\2\2\u00f0"+
		"\u00ec\3\2\2\2\u00f1\u00f4\3\2\2\2\u00f2\u00f0\3\2\2\2\u00f2\u00f3\3\2"+
		"\2\2\u00f3%\3\2\2\2\u00f4\u00f2\3\2\2\2\u00f5\u00f6\b\24\1\2\u00f6\u00f7"+
		"\5(\25\2\u00f7\u0100\3\2\2\2\u00f8\u00f9\f\4\2\2\u00f9\u00fa\7\60\2\2"+
		"\u00fa\u00ff\5(\25\2\u00fb\u00fc\f\3\2\2\u00fc\u00fd\7\61\2\2\u00fd\u00ff"+
		"\5(\25\2\u00fe\u00f8\3\2\2\2\u00fe\u00fb\3\2\2\2\u00ff\u0102\3\2\2\2\u0100"+
		"\u00fe\3\2\2\2\u0100\u0101\3\2\2\2\u0101\'\3\2\2\2\u0102\u0100\3\2\2\2"+
		"\u0103\u0104\b\25\1\2\u0104\u0105\5*\26\2\u0105\u0111\3\2\2\2\u0106\u0107"+
		"\f\5\2\2\u0107\u0108\7\62\2\2\u0108\u0110\5*\26\2\u0109\u010a\f\4\2\2"+
		"\u010a\u010b\7\63\2\2\u010b\u0110\5*\26\2\u010c\u010d\f\3\2\2\u010d\u010e"+
		"\7<\2\2\u010e\u0110\5*\26\2\u010f\u0106\3\2\2\2\u010f\u0109\3\2\2\2\u010f"+
		"\u010c\3\2\2\2\u0110\u0113\3\2\2\2\u0111\u010f\3\2\2\2\u0111\u0112\3\2"+
		"\2\2\u0112)\3\2\2\2\u0113\u0111\3\2\2\2\u0114\u0120\5\66\34\2\u0115\u0120"+
		"\5,\27\2\u0116\u0117\7$\2\2\u0117\u0120\5*\26\2\u0118\u0119\7#\2\2\u0119"+
		"\u0120\5*\26\2\u011a\u011b\7=\2\2\u011b\u0120\5*\26\2\u011c\u011d\58\35"+
		"\2\u011d\u011e\5*\26\2\u011e\u0120\3\2\2\2\u011f\u0114\3\2\2\2\u011f\u0115"+
		"\3\2\2\2\u011f\u0116\3\2\2\2\u011f\u0118\3\2\2\2\u011f\u011a\3\2\2\2\u011f"+
		"\u011c\3\2\2\2\u0120+\3\2\2\2\u0121\u0122\7\13\2\2\u0122\u012d\5P)\2\u0123"+
		"\u0124\7\13\2\2\u0124\u0125\5P)\2\u0125\u0129\5.\30\2\u0126\u0128\5\22"+
		"\n\2\u0127\u0126\3\2\2\2\u0128\u012b\3\2\2\2\u0129\u0127\3\2\2\2\u0129"+
		"\u012a\3\2\2\2\u012a\u012d\3\2\2\2\u012b\u0129\3\2\2\2\u012c\u0121\3\2"+
		"\2\2\u012c\u0123\3\2\2\2\u012d-\3\2\2\2\u012e\u012f\7*\2\2\u012f\u0130"+
		"\5\64\33\2\u0130\u0131\7+\2\2\u0131/\3\2\2\2\u0132\u0133\7*\2\2\u0133"+
		"\u0134\5\64\33\2\u0134\u0135\7+\2\2\u0135\61\3\2\2\2\u0136\u013b\5\64"+
		"\33\2\u0137\u0138\7-\2\2\u0138\u013a\5\64\33\2\u0139\u0137\3\2\2\2\u013a"+
		"\u013d\3\2\2\2\u013b\u0139\3\2\2\2\u013b\u013c\3\2\2\2\u013c\63\3\2\2"+
		"\2\u013d\u013b\3\2\2\2\u013e\u013f\5*\26\2\u013f\u0140\7\64\2\2\u0140"+
		"\u0141\5\24\13\2\u0141\u0144\3\2\2\2\u0142\u0144\5\26\f\2\u0143\u013e"+
		"\3\2\2\2\u0143\u0142\3\2\2\2\u0144\65\3\2\2\2\u0145\u0146\b\34\1\2\u0146"+
		"\u014d\5:\36\2\u0147\u014d\5Z.\2\u0148\u0149\7(\2\2\u0149\u014a\5\24\13"+
		"\2\u014a\u014b\7)\2\2\u014b\u014d\3\2\2\2\u014c\u0145\3\2\2\2\u014c\u0147"+
		"\3\2\2\2\u014c\u0148\3\2\2\2\u014d\u0180\3\2\2\2\u014e\u014f\f\16\2\2"+
		"\u014f\u017f\t\2\2\2\u0150\u0152\f\13\2\2\u0151\u0153\5\60\31\2\u0152"+
		"\u0151\3\2\2\2\u0153\u0154\3\2\2\2\u0154\u0152\3\2\2\2\u0154\u0155\3\2"+
		"\2\2\u0155\u017f\3\2\2\2\u0156\u0157\f\n\2\2\u0157\u0158\7.\2\2\u0158"+
		"\u0159\7\16\2\2\u0159\u015a\7(\2\2\u015a\u017f\7)\2\2\u015b\u015c\f\t"+
		"\2\2\u015c\u015d\7.\2\2\u015d\u015e\7\24\2\2\u015e\u015f\7(\2\2\u015f"+
		"\u017f\7)\2\2\u0160\u0161\f\b\2\2\u0161\u0162\7.\2\2\u0162\u0163\7\25"+
		"\2\2\u0163\u0164\7(\2\2\u0164\u0165\5\64\33\2\u0165\u0166\7-\2\2\u0166"+
		"\u0167\5\64\33\2\u0167\u0168\7)\2\2\u0168\u017f\3\2\2\2\u0169\u016a\f"+
		"\7\2\2\u016a\u016b\7.\2\2\u016b\u016c\7\26\2\2\u016c\u016d\7(\2\2\u016d"+
		"\u017f\7)\2\2\u016e\u016f\f\6\2\2\u016f\u0170\7.\2\2\u0170\u0171\7\27"+
		"\2\2\u0171\u0172\7(\2\2\u0172\u0173\5\64\33\2\u0173\u0174\7)\2\2\u0174"+
		"\u017f\3\2\2\2\u0175\u0176\f\5\2\2\u0176\u0178\7(\2\2\u0177\u0179\5\62"+
		"\32\2\u0178\u0177\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a\3\2\2\2\u017a"+
		"\u017f\7)\2\2\u017b\u017c\f\4\2\2\u017c\u017d\7.\2\2\u017d\u017f\5Z.\2"+
		"\u017e\u014e\3\2\2\2\u017e\u0150\3\2\2\2\u017e\u0156\3\2\2\2\u017e\u015b"+
		"\3\2\2\2\u017e\u0160\3\2\2\2\u017e\u0169\3\2\2\2\u017e\u016e\3\2\2\2\u017e"+
		"\u0175\3\2\2\2\u017e\u017b\3\2\2\2\u017f\u0182\3\2\2\2\u0180\u017e\3\2"+
		"\2\2\u0180\u0181\3\2\2\2\u0181\67\3\2\2\2\u0182\u0180\3\2\2\2\u0183\u0184"+
		"\t\3\2\2\u01849\3\2\2\2\u0185\u018a\7\r\2\2\u0186\u018a\5R*\2\u0187\u018a"+
		"\7\3\2\2\u0188\u018a\7\32\2\2\u0189\u0185\3\2\2\2\u0189\u0186\3\2\2\2"+
		"\u0189\u0187\3\2\2\2\u0189\u0188\3\2\2\2\u018a;\3\2\2\2\u018b\u0192\5"+
		"> \2\u018c\u0192\5N(\2\u018d\u0192\5B\"\2\u018e\u0192\5F$\2\u018f\u0192"+
		"\5H%\2\u0190\u0192\5D#\2\u0191\u018b\3\2\2\2\u0191\u018c\3\2\2\2\u0191"+
		"\u018d\3\2\2\2\u0191\u018e\3\2\2\2\u0191\u018f\3\2\2\2\u0191\u0190\3\2"+
		"\2\2\u0192=\3\2\2\2\u0193\u0195\7&\2\2\u0194\u0196\5@!\2\u0195\u0194\3"+
		"\2\2\2\u0195\u0196\3\2\2\2\u0196\u0197\3\2\2\2\u0197\u0198\7\'\2\2\u0198"+
		"?\3\2\2\2\u0199\u019e\5<\37\2\u019a\u019b\5<\37\2\u019b\u019c\5@!\2\u019c"+
		"\u019e\3\2\2\2\u019d\u0199\3\2\2\2\u019d\u019a\3\2\2\2\u019eA\3\2\2\2"+
		"\u019f\u01a4\7%\2\2\u01a0\u01a1\5\24\13\2\u01a1\u01a2\7%\2\2\u01a2\u01a4"+
		"\3\2\2\2\u01a3\u019f\3\2\2\2\u01a3\u01a0\3\2\2\2\u01a4C\3\2\2\2\u01a5"+
		"\u01a7\7\n\2\2\u01a6\u01a8\5\24\13\2\u01a7\u01a6\3\2\2\2\u01a7\u01a8\3"+
		"\2\2\2\u01a8\u01a9\3\2\2\2\u01a9\u01af\7%\2\2\u01aa\u01ab\7\t\2\2\u01ab"+
		"\u01af\7%\2\2\u01ac\u01ad\7\b\2\2\u01ad\u01af\7%\2\2\u01ae\u01a5\3\2\2"+
		"\2\u01ae\u01aa\3\2\2\2\u01ae\u01ac\3\2\2\2\u01afE\3\2\2\2\u01b0\u01b1"+
		"\7\4\2\2\u01b1\u01b2\7(\2\2\u01b2\u01b3\5L\'\2\u01b3\u01b4\79\2\2\u01b4"+
		"\u01b5\5L\'\2\u01b5\u01b6\79\2\2\u01b6\u01b7\5L\'\2\u01b7\u01b8\79\2\2"+
		"\u01b8\u01b9\5L\'\2\u01b9\u01ba\79\2\2\u01ba\u01bb\5L\'\2\u01bb\u01bc"+
		"\79\2\2\u01bc\u01bd\5L\'\2\u01bd\u01be\79\2\2\u01be\u01bf\5L\'\2\u01bf"+
		"\u01c0\79\2\2\u01c0\u01c1\5L\'\2\u01c1\u01c2\79\2\2\u01c2\u01c3\5L\'\2"+
		"\u01c3\u01c4\79\2\2\u01c4\u01c5\5L\'\2\u01c5\u01c6\79\2\2\u01c6\u01c7"+
		"\5L\'\2\u01c7\u01c8\79\2\2\u01c8\u01c9\5L\'\2\u01c9\u01ca\79\2\2\u01ca"+
		"\u01cb\5L\'\2\u01cb\u01cc\79\2\2\u01cc\u01cd\5L\'\2\u01cd\u01ce\79\2\2"+
		"\u01ce\u01cf\5L\'\2\u01cf\u01d0\79\2\2\u01d0\u01d1\5L\'\2\u01d1\u01d2"+
		"\79\2\2\u01d2\u01d3\5L\'\2\u01d3\u01d4\79\2\2\u01d4\u01d5\5L\'\2\u01d5"+
		"\u01d6\79\2\2\u01d6\u01d7\5L\'\2\u01d7\u01d8\79\2\2\u01d8\u01d9\5L\'\2"+
		"\u01d9\u01da\79\2\2\u01da\u01db\5L\'\2\u01db\u01dc\79\2\2\u01dc\u01dd"+
		"\5L\'\2\u01dd\u01de\79\2\2\u01de\u01df\5L\'\2\u01df\u01e0\79\2\2\u01e0"+
		"\u01e1\5L\'\2\u01e1\u01e2\79\2\2\u01e2\u01e3\5L\'\2\u01e3\u01e4\79\2\2"+
		"\u01e4\u01e5\5L\'\2\u01e5\u01e6\79\2\2\u01e6\u01e7\5L\'\2\u01e7\u01e8"+
		"\79\2\2\u01e8\u01e9\5L\'\2\u01e9\u01ea\79\2\2\u01ea\u01eb\5L\'\2\u01eb"+
		"\u01ec\79\2\2\u01ec\u01ed\5L\'\2\u01ed\u01ee\79\2\2\u01ee\u01ef\5L\'\2"+
		"\u01ef\u01f0\79\2\2\u01f0\u01f1\5L\'\2\u01f1\u01f2\79\2\2\u01f2\u01f3"+
		"\5L\'\2\u01f3\u01f4\79\2\2\u01f4\u01f5\5L\'\2\u01f5\u01f6\79\2\2\u01f6"+
		"\u01f7\5L\'\2\u01f7\u01f8\79\2\2\u01f8\u01f9\5L\'\2\u01f9\u01fa\79\2\2"+
		"\u01fa\u01fb\5L\'\2\u01fb\u01fc\79\2\2\u01fc\u01fd\5L\'\2\u01fd\u01fe"+
		"\79\2\2\u01fe\u01ff\5L\'\2\u01ff\u0200\79\2\2\u0200\u0201\5L\'\2\u0201"+
		"\u0202\79\2\2\u0202\u0203\5L\'\2\u0203\u0204\7)\2\2\u0204\u0205\5<\37"+
		"\2\u0205\u0215\3\2\2\2\u0206\u0207\7\4\2\2\u0207\u0208\7(\2\2\u0208\u0209"+
		"\5\24\13\2\u0209\u020a\7)\2\2\u020a\u020b\5<\37\2\u020b\u020c\7\5\2\2"+
		"\u020c\u020d\5<\37\2\u020d\u0215\3\2\2\2\u020e\u020f\7\4\2\2\u020f\u0210"+
		"\7(\2\2\u0210\u0211\5\24\13\2\u0211\u0212\7)\2\2\u0212\u0213\5<\37\2\u0213"+
		"\u0215\3\2\2\2\u0214\u01b0\3\2\2\2\u0214\u0206\3\2\2\2\u0214\u020e\3\2"+
		"\2\2\u0215G\3\2\2\2\u0216\u0217\7\7\2\2\u0217\u0218\7(\2\2\u0218\u0219"+
		"\5\24\13\2\u0219\u021a\7)\2\2\u021a\u021b\5<\37\2\u021b\u022c\3\2\2\2"+
		"\u021c\u021d\7\6\2\2\u021d\u021f\7(\2\2\u021e\u0220\5J&\2\u021f\u021e"+
		"\3\2\2\2\u021f\u0220\3\2\2\2\u0220\u0221\3\2\2\2\u0221\u0223\7%\2\2\u0222"+
		"\u0224\5L\'\2\u0223\u0222\3\2\2\2\u0223\u0224\3\2\2\2\u0224\u0225\3\2"+
		"\2\2\u0225\u0227\7%\2\2\u0226\u0228\5\24\13\2\u0227\u0226\3\2\2\2\u0227"+
		"\u0228\3\2\2\2\u0228\u0229\3\2\2\2\u0229\u022a\7)\2\2\u022a\u022c\5<\37"+
		"\2\u022b\u0216\3\2\2\2\u022b\u021c\3\2\2\2\u022cI\3\2\2\2\u022d\u022e"+
		"\5\24\13\2\u022eK\3\2\2\2\u022f\u0230\5\24\13\2\u0230M\3\2\2\2\u0231\u0232"+
		"\5\20\t\2\u0232\u0233\5Z.\2\u0233\u0234\7%\2\2\u0234\u023c\3\2\2\2\u0235"+
		"\u0236\5\20\t\2\u0236\u0237\5Z.\2\u0237\u0238\7\64\2\2\u0238\u0239\5\24"+
		"\13\2\u0239\u023a\7%\2\2\u023a\u023c\3\2\2\2\u023b\u0231\3\2\2\2\u023b"+
		"\u0235\3\2\2\2\u023cO\3\2\2\2\u023d\u0243\7@\2\2\u023e\u0243\7?\2\2\u023f"+
		"\u0243\5Z.\2\u0240\u0243\7A\2\2\u0241\u0243\7>\2\2\u0242\u023d\3\2\2\2"+
		"\u0242\u023e\3\2\2\2\u0242\u023f\3\2\2\2\u0242\u0240\3\2\2\2\u0242\u0241"+
		"\3\2\2\2\u0243Q\3\2\2\2\u0244\u0245\t\4\2\2\u0245S\3\2\2\2\u0246\u0247"+
		"\t\5\2\2\u0247U\3\2\2\2\u0248\u0249\t\6\2\2\u0249W\3\2\2\2\u024a\u024b"+
		"\t\7\2\2\u024bY\3\2\2\2\u024c\u024d\t\b\2\2\u024d[\3\2\2\2.`dhju\177\u008c"+
		"\u0092\u00a2\u00ad\u00b8\u00c3\u00ce\u00da\u00e6\u00f2\u00fe\u0100\u010f"+
		"\u0111\u011f\u0129\u012c\u013b\u0143\u014c\u0154\u0178\u017e\u0180\u0189"+
		"\u0191\u0195\u019d\u01a3\u01a7\u01ae\u0214\u021f\u0223\u0227\u022b\u023b"+
		"\u0242";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}