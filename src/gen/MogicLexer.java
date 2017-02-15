// Generated from C:/Users/xsc/IdeaProjects/compiler2016/src\Mogic.g4 by ANTLR 4.5.1
package gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class MogicLexer extends Lexer {
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
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"Int_literal", "IF", "ELSE", "FOR", "WHILE", "CONTINUE", "BREAK", "RETURN", 
		"NEW", "CLASS", "NULL_LITERAL", "SIZE", "PRINT", "PRINTLN", "GETSTRING", 
		"GETINT", "TOSTRING", "LENGTH", "SUBSTRING", "PARSEINT", "ORD", "TRUE", 
		"FALSE", "String_literal", "SChar", "EscapeSequence", "SimpleEscapeSequence", 
		"OctalEscapeSequence", "HexadecimalEscapeSequence", "UniversalCharacterName", 
		"HexQuad", "HexadecimalDigit", "OctalDigit", "EQ", "NEQ", "GT", "LT", 
		"GE", "LE", "LSHIFT", "RSHIFT", "INCREMENT", "DECREMENT", "SEMICOLON", 
		"OPB_FIG", "CLB_FIG", "OPB_RND", "CLB_RND", "OPB_SQ", "CLB_SQ", "DOUBLE_DOT", 
		"COMMA", "DOT", "ETC", "PLUS", "MINUS", "MUL", "DIV", "ASSIGN", "BIT_AND", 
		"BIT_OR", "BIT_XOR", "Tilde", "AND", "OR", "QUESTION", "REM", "NOT", "VOID", 
		"STRING", "INT", "BOOL", "IDEN", "Letter", "Digit", "WS", "COMMENT"
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


	public MogicLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Mogic.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2D\u01fe\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\4;\t;\4<\t<\4=\t="+
		"\4>\t>\4?\t?\4@\t@\4A\tA\4B\tB\4C\tC\4D\tD\4E\tE\4F\tF\4G\tG\4H\tH\4I"+
		"\tI\4J\tJ\4K\tK\4L\tL\4M\tM\4N\tN\3\2\3\2\7\2\u00a0\n\2\f\2\16\2\u00a3"+
		"\13\2\3\2\5\2\u00a6\n\2\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\5\3"+
		"\5\3\6\3\6\3\6\3\6\3\6\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\b\3\b\3\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\n\3\n\3\n\3\n\3\13\3\13"+
		"\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25"+
		"\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\27\3\27"+
		"\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30\3\30\3\31\3\31\7\31\u0137\n\31"+
		"\f\31\16\31\u013a\13\31\3\31\3\31\3\32\3\32\5\32\u0140\n\32\3\33\3\33"+
		"\3\33\3\33\5\33\u0146\n\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35"+
		"\3\35\3\35\3\35\3\35\3\35\5\35\u0156\n\35\3\36\3\36\3\36\3\36\6\36\u015c"+
		"\n\36\r\36\16\36\u015d\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		"\37\5\37\u016a\n\37\3 \3 \3 \3 \3 \3!\3!\3\"\3\"\3#\3#\3#\3$\3$\3$\3%"+
		"\3%\3&\3&\3\'\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3*\3+\3+\3+\3,\3,\3,\3-"+
		"\3-\3.\3.\3/\3/\3\60\3\60\3\61\3\61\3\62\3\62\3\63\3\63\3\64\3\64\3\65"+
		"\3\65\3\66\3\66\3\67\3\67\3\67\3\67\38\38\39\39\3:\3:\3;\3;\3<\3<\3=\3"+
		"=\3>\3>\3?\3?\3@\3@\3A\3A\3A\3B\3B\3B\3C\3C\3D\3D\3E\3E\3F\3F\3F\3F\3"+
		"F\3G\3G\3G\3G\3G\3G\3G\3H\3H\3H\3H\3I\3I\3I\3I\3I\3I\3I\3I\3J\3J\3J\7"+
		"J\u01e2\nJ\fJ\16J\u01e5\13J\3K\3K\3L\3L\3M\3M\3M\3M\3N\3N\3N\3N\7N\u01f3"+
		"\nN\fN\16N\u01f6\13N\3N\5N\u01f9\nN\3N\3N\3N\3N\2\2O\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\2\65\2\67\29\2;\2=\2?\2A\2C\2E\33G\34I\35"+
		"K\36M\37O Q!S\"U#W$Y%[&]\'_(a)c*e+g,i-k.m/o\60q\61s\62u\63w\64y\65{\66"+
		"}\67\1778\u00819\u0083:\u0085;\u0087<\u0089=\u008b>\u008d?\u008f@\u0091"+
		"A\u0093B\u0095\2\u0097\2\u0099C\u009bD\3\2\13\3\2\63;\6\2\f\f\17\17$$"+
		"^^\f\2$$))AA^^cdhhppttvvxx\5\2\62;CHch\3\2\629\5\2C\\aac|\3\2\62;\5\2"+
		"\13\f\17\17\"\"\4\2\f\f\17\17\u0201\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2"+
		"\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23"+
		"\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2"+
		"\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2"+
		"\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2E\3\2\2\2\2G\3\2\2"+
		"\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S\3\2\2\2\2"+
		"U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2\2\2\2a\3"+
		"\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2\2m\3\2\2"+
		"\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\2u\3\2\2\2\2w\3\2\2\2\2y\3\2\2\2\2"+
		"{\3\2\2\2\2}\3\2\2\2\2\177\3\2\2\2\2\u0081\3\2\2\2\2\u0083\3\2\2\2\2\u0085"+
		"\3\2\2\2\2\u0087\3\2\2\2\2\u0089\3\2\2\2\2\u008b\3\2\2\2\2\u008d\3\2\2"+
		"\2\2\u008f\3\2\2\2\2\u0091\3\2\2\2\2\u0093\3\2\2\2\2\u0099\3\2\2\2\2\u009b"+
		"\3\2\2\2\3\u00a5\3\2\2\2\5\u00a7\3\2\2\2\7\u00aa\3\2\2\2\t\u00af\3\2\2"+
		"\2\13\u00b3\3\2\2\2\r\u00b9\3\2\2\2\17\u00c2\3\2\2\2\21\u00c8\3\2\2\2"+
		"\23\u00cf\3\2\2\2\25\u00d3\3\2\2\2\27\u00d9\3\2\2\2\31\u00de\3\2\2\2\33"+
		"\u00e3\3\2\2\2\35\u00e9\3\2\2\2\37\u00f1\3\2\2\2!\u00fb\3\2\2\2#\u0102"+
		"\3\2\2\2%\u010b\3\2\2\2\'\u0112\3\2\2\2)\u011c\3\2\2\2+\u0125\3\2\2\2"+
		"-\u0129\3\2\2\2/\u012e\3\2\2\2\61\u0134\3\2\2\2\63\u013f\3\2\2\2\65\u0145"+
		"\3\2\2\2\67\u0147\3\2\2\29\u0155\3\2\2\2;\u0157\3\2\2\2=\u0169\3\2\2\2"+
		"?\u016b\3\2\2\2A\u0170\3\2\2\2C\u0172\3\2\2\2E\u0174\3\2\2\2G\u0177\3"+
		"\2\2\2I\u017a\3\2\2\2K\u017c\3\2\2\2M\u017e\3\2\2\2O\u0181\3\2\2\2Q\u0184"+
		"\3\2\2\2S\u0187\3\2\2\2U\u018a\3\2\2\2W\u018d\3\2\2\2Y\u0190\3\2\2\2["+
		"\u0192\3\2\2\2]\u0194\3\2\2\2_\u0196\3\2\2\2a\u0198\3\2\2\2c\u019a\3\2"+
		"\2\2e\u019c\3\2\2\2g\u019e\3\2\2\2i\u01a0\3\2\2\2k\u01a2\3\2\2\2m\u01a4"+
		"\3\2\2\2o\u01a8\3\2\2\2q\u01aa\3\2\2\2s\u01ac\3\2\2\2u\u01ae\3\2\2\2w"+
		"\u01b0\3\2\2\2y\u01b2\3\2\2\2{\u01b4\3\2\2\2}\u01b6\3\2\2\2\177\u01b8"+
		"\3\2\2\2\u0081\u01ba\3\2\2\2\u0083\u01bd\3\2\2\2\u0085\u01c0\3\2\2\2\u0087"+
		"\u01c2\3\2\2\2\u0089\u01c4\3\2\2\2\u008b\u01c6\3\2\2\2\u008d\u01cb\3\2"+
		"\2\2\u008f\u01d2\3\2\2\2\u0091\u01d6\3\2\2\2\u0093\u01de\3\2\2\2\u0095"+
		"\u01e6\3\2\2\2\u0097\u01e8\3\2\2\2\u0099\u01ea\3\2\2\2\u009b\u01ee\3\2"+
		"\2\2\u009d\u00a1\t\2\2\2\u009e\u00a0\5\u0097L\2\u009f\u009e\3\2\2\2\u00a0"+
		"\u00a3\3\2\2\2\u00a1\u009f\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a6\3\2"+
		"\2\2\u00a3\u00a1\3\2\2\2\u00a4\u00a6\7\62\2\2\u00a5\u009d\3\2\2\2\u00a5"+
		"\u00a4\3\2\2\2\u00a6\4\3\2\2\2\u00a7\u00a8\7k\2\2\u00a8\u00a9\7h\2\2\u00a9"+
		"\6\3\2\2\2\u00aa\u00ab\7g\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad\7u\2\2\u00ad"+
		"\u00ae\7g\2\2\u00ae\b\3\2\2\2\u00af\u00b0\7h\2\2\u00b0\u00b1\7q\2\2\u00b1"+
		"\u00b2\7t\2\2\u00b2\n\3\2\2\2\u00b3\u00b4\7y\2\2\u00b4\u00b5\7j\2\2\u00b5"+
		"\u00b6\7k\2\2\u00b6\u00b7\7n\2\2\u00b7\u00b8\7g\2\2\u00b8\f\3\2\2\2\u00b9"+
		"\u00ba\7e\2\2\u00ba\u00bb\7q\2\2\u00bb\u00bc\7p\2\2\u00bc\u00bd\7v\2\2"+
		"\u00bd\u00be\7k\2\2\u00be\u00bf\7p\2\2\u00bf\u00c0\7w\2\2\u00c0\u00c1"+
		"\7g\2\2\u00c1\16\3\2\2\2\u00c2\u00c3\7d\2\2\u00c3\u00c4\7t\2\2\u00c4\u00c5"+
		"\7g\2\2\u00c5\u00c6\7c\2\2\u00c6\u00c7\7m\2\2\u00c7\20\3\2\2\2\u00c8\u00c9"+
		"\7t\2\2\u00c9\u00ca\7g\2\2\u00ca\u00cb\7v\2\2\u00cb\u00cc\7w\2\2\u00cc"+
		"\u00cd\7t\2\2\u00cd\u00ce\7p\2\2\u00ce\22\3\2\2\2\u00cf\u00d0\7p\2\2\u00d0"+
		"\u00d1\7g\2\2\u00d1\u00d2\7y\2\2\u00d2\24\3\2\2\2\u00d3\u00d4\7e\2\2\u00d4"+
		"\u00d5\7n\2\2\u00d5\u00d6\7c\2\2\u00d6\u00d7\7u\2\2\u00d7\u00d8\7u\2\2"+
		"\u00d8\26\3\2\2\2\u00d9\u00da\7p\2\2\u00da\u00db\7w\2\2\u00db\u00dc\7"+
		"n\2\2\u00dc\u00dd\7n\2\2\u00dd\30\3\2\2\2\u00de\u00df\7u\2\2\u00df\u00e0"+
		"\7k\2\2\u00e0\u00e1\7|\2\2\u00e1\u00e2\7g\2\2\u00e2\32\3\2\2\2\u00e3\u00e4"+
		"\7r\2\2\u00e4\u00e5\7t\2\2\u00e5\u00e6\7k\2\2\u00e6\u00e7\7p\2\2\u00e7"+
		"\u00e8\7v\2\2\u00e8\34\3\2\2\2\u00e9\u00ea\7r\2\2\u00ea\u00eb\7t\2\2\u00eb"+
		"\u00ec\7k\2\2\u00ec\u00ed\7p\2\2\u00ed\u00ee\7v\2\2\u00ee\u00ef\7n\2\2"+
		"\u00ef\u00f0\7p\2\2\u00f0\36\3\2\2\2\u00f1\u00f2\7i\2\2\u00f2\u00f3\7"+
		"g\2\2\u00f3\u00f4\7v\2\2\u00f4\u00f5\7U\2\2\u00f5\u00f6\7v\2\2\u00f6\u00f7"+
		"\7t\2\2\u00f7\u00f8\7k\2\2\u00f8\u00f9\7p\2\2\u00f9\u00fa\7i\2\2\u00fa"+
		" \3\2\2\2\u00fb\u00fc\7i\2\2\u00fc\u00fd\7g\2\2\u00fd\u00fe\7v\2\2\u00fe"+
		"\u00ff\7K\2\2\u00ff\u0100\7p\2\2\u0100\u0101\7v\2\2\u0101\"\3\2\2\2\u0102"+
		"\u0103\7v\2\2\u0103\u0104\7q\2\2\u0104\u0105\7U\2\2\u0105\u0106\7v\2\2"+
		"\u0106\u0107\7t\2\2\u0107\u0108\7k\2\2\u0108\u0109\7p\2\2\u0109\u010a"+
		"\7i\2\2\u010a$\3\2\2\2\u010b\u010c\7n\2\2\u010c\u010d\7g\2\2\u010d\u010e"+
		"\7p\2\2\u010e\u010f\7i\2\2\u010f\u0110\7v\2\2\u0110\u0111\7j\2\2\u0111"+
		"&\3\2\2\2\u0112\u0113\7u\2\2\u0113\u0114\7w\2\2\u0114\u0115\7d\2\2\u0115"+
		"\u0116\7u\2\2\u0116\u0117\7v\2\2\u0117\u0118\7t\2\2\u0118\u0119\7k\2\2"+
		"\u0119\u011a\7p\2\2\u011a\u011b\7i\2\2\u011b(\3\2\2\2\u011c\u011d\7r\2"+
		"\2\u011d\u011e\7c\2\2\u011e\u011f\7t\2\2\u011f\u0120\7u\2\2\u0120\u0121"+
		"\7g\2\2\u0121\u0122\7K\2\2\u0122\u0123\7p\2\2\u0123\u0124\7v\2\2\u0124"+
		"*\3\2\2\2\u0125\u0126\7q\2\2\u0126\u0127\7t\2\2\u0127\u0128\7f\2\2\u0128"+
		",\3\2\2\2\u0129\u012a\7v\2\2\u012a\u012b\7t\2\2\u012b\u012c\7w\2\2\u012c"+
		"\u012d\7g\2\2\u012d.\3\2\2\2\u012e\u012f\7h\2\2\u012f\u0130\7c\2\2\u0130"+
		"\u0131\7n\2\2\u0131\u0132\7u\2\2\u0132\u0133\7g\2\2\u0133\60\3\2\2\2\u0134"+
		"\u0138\7$\2\2\u0135\u0137\5\63\32\2\u0136\u0135\3\2\2\2\u0137\u013a\3"+
		"\2\2\2\u0138\u0136\3\2\2\2\u0138\u0139\3\2\2\2\u0139\u013b\3\2\2\2\u013a"+
		"\u0138\3\2\2\2\u013b\u013c\7$\2\2\u013c\62\3\2\2\2\u013d\u0140\n\3\2\2"+
		"\u013e\u0140\5\65\33\2\u013f\u013d\3\2\2\2\u013f\u013e\3\2\2\2\u0140\64"+
		"\3\2\2\2\u0141\u0146\5\67\34\2\u0142\u0146\59\35\2\u0143\u0146\5;\36\2"+
		"\u0144\u0146\5=\37\2\u0145\u0141\3\2\2\2\u0145\u0142\3\2\2\2\u0145\u0143"+
		"\3\2\2\2\u0145\u0144\3\2\2\2\u0146\66\3\2\2\2\u0147\u0148\7^\2\2\u0148"+
		"\u0149\t\4\2\2\u01498\3\2\2\2\u014a\u014b\7^\2\2\u014b\u0156\5C\"\2\u014c"+
		"\u014d\7^\2\2\u014d\u014e\5C\"\2\u014e\u014f\5C\"\2\u014f\u0156\3\2\2"+
		"\2\u0150\u0151\7^\2\2\u0151\u0152\5C\"\2\u0152\u0153\5C\"\2\u0153\u0154"+
		"\5C\"\2\u0154\u0156\3\2\2\2\u0155\u014a\3\2\2\2\u0155\u014c\3\2\2\2\u0155"+
		"\u0150\3\2\2\2\u0156:\3\2\2\2\u0157\u0158\7^\2\2\u0158\u0159\7z\2\2\u0159"+
		"\u015b\3\2\2\2\u015a\u015c\5A!\2\u015b\u015a\3\2\2\2\u015c\u015d\3\2\2"+
		"\2\u015d\u015b\3\2\2\2\u015d\u015e\3\2\2\2\u015e<\3\2\2\2\u015f\u0160"+
		"\7^\2\2\u0160\u0161\7w\2\2\u0161\u0162\3\2\2\2\u0162\u016a\5? \2\u0163"+
		"\u0164\7^\2\2\u0164\u0165\7W\2\2\u0165\u0166\3\2\2\2\u0166\u0167\5? \2"+
		"\u0167\u0168\5? \2\u0168\u016a\3\2\2\2\u0169\u015f\3\2\2\2\u0169\u0163"+
		"\3\2\2\2\u016a>\3\2\2\2\u016b\u016c\5A!\2\u016c\u016d\5A!\2\u016d\u016e"+
		"\5A!\2\u016e\u016f\5A!\2\u016f@\3\2\2\2\u0170\u0171\t\5\2\2\u0171B\3\2"+
		"\2\2\u0172\u0173\t\6\2\2\u0173D\3\2\2\2\u0174\u0175\7?\2\2\u0175\u0176"+
		"\7?\2\2\u0176F\3\2\2\2\u0177\u0178\7#\2\2\u0178\u0179\7?\2\2\u0179H\3"+
		"\2\2\2\u017a\u017b\7@\2\2\u017bJ\3\2\2\2\u017c\u017d\7>\2\2\u017dL\3\2"+
		"\2\2\u017e\u017f\7@\2\2\u017f\u0180\7?\2\2\u0180N\3\2\2\2\u0181\u0182"+
		"\7>\2\2\u0182\u0183\7?\2\2\u0183P\3\2\2\2\u0184\u0185\7>\2\2\u0185\u0186"+
		"\7>\2\2\u0186R\3\2\2\2\u0187\u0188\7@\2\2\u0188\u0189\7@\2\2\u0189T\3"+
		"\2\2\2\u018a\u018b\7-\2\2\u018b\u018c\7-\2\2\u018cV\3\2\2\2\u018d\u018e"+
		"\7/\2\2\u018e\u018f\7/\2\2\u018fX\3\2\2\2\u0190\u0191\7=\2\2\u0191Z\3"+
		"\2\2\2\u0192\u0193\7}\2\2\u0193\\\3\2\2\2\u0194\u0195\7\177\2\2\u0195"+
		"^\3\2\2\2\u0196\u0197\7*\2\2\u0197`\3\2\2\2\u0198\u0199\7+\2\2\u0199b"+
		"\3\2\2\2\u019a\u019b\7]\2\2\u019bd\3\2\2\2\u019c\u019d\7_\2\2\u019df\3"+
		"\2\2\2\u019e\u019f\7<\2\2\u019fh\3\2\2\2\u01a0\u01a1\7.\2\2\u01a1j\3\2"+
		"\2\2\u01a2\u01a3\7\60\2\2\u01a3l\3\2\2\2\u01a4\u01a5\7\60\2\2\u01a5\u01a6"+
		"\7\60\2\2\u01a6\u01a7\7\60\2\2\u01a7n\3\2\2\2\u01a8\u01a9\7-\2\2\u01a9"+
		"p\3\2\2\2\u01aa\u01ab\7/\2\2\u01abr\3\2\2\2\u01ac\u01ad\7,\2\2\u01adt"+
		"\3\2\2\2\u01ae\u01af\7\61\2\2\u01afv\3\2\2\2\u01b0\u01b1\7?\2\2\u01b1"+
		"x\3\2\2\2\u01b2\u01b3\7(\2\2\u01b3z\3\2\2\2\u01b4\u01b5\7~\2\2\u01b5|"+
		"\3\2\2\2\u01b6\u01b7\7`\2\2\u01b7~\3\2\2\2\u01b8\u01b9\7\u0080\2\2\u01b9"+
		"\u0080\3\2\2\2\u01ba\u01bb\7(\2\2\u01bb\u01bc\7(\2\2\u01bc\u0082\3\2\2"+
		"\2\u01bd\u01be\7~\2\2\u01be\u01bf\7~\2\2\u01bf\u0084\3\2\2\2\u01c0\u01c1"+
		"\7A\2\2\u01c1\u0086\3\2\2\2\u01c2\u01c3\7\'\2\2\u01c3\u0088\3\2\2\2\u01c4"+
		"\u01c5\7#\2\2\u01c5\u008a\3\2\2\2\u01c6\u01c7\7x\2\2\u01c7\u01c8\7q\2"+
		"\2\u01c8\u01c9\7k\2\2\u01c9\u01ca\7f\2\2\u01ca\u008c\3\2\2\2\u01cb\u01cc"+
		"\7u\2\2\u01cc\u01cd\7v\2\2\u01cd\u01ce\7t\2\2\u01ce\u01cf\7k\2\2\u01cf"+
		"\u01d0\7p\2\2\u01d0\u01d1\7i\2\2\u01d1\u008e\3\2\2\2\u01d2\u01d3\7k\2"+
		"\2\u01d3\u01d4\7p\2\2\u01d4\u01d5\7v\2\2\u01d5\u0090\3\2\2\2\u01d6\u01d7"+
		"\7d\2\2\u01d7\u01d8\7q\2\2\u01d8\u01d9\7q\2\2\u01d9\u01da\7n\2\2\u01da"+
		"\u01db\7g\2\2\u01db\u01dc\7c\2\2\u01dc\u01dd\7p\2\2\u01dd\u0092\3\2\2"+
		"\2\u01de\u01e3\5\u0095K\2\u01df\u01e2\5\u0095K\2\u01e0\u01e2\5\u0097L"+
		"\2\u01e1\u01df\3\2\2\2\u01e1\u01e0\3\2\2\2\u01e2\u01e5\3\2\2\2\u01e3\u01e1"+
		"\3\2\2\2\u01e3\u01e4\3\2\2\2\u01e4\u0094\3\2\2\2\u01e5\u01e3\3\2\2\2\u01e6"+
		"\u01e7\t\7\2\2\u01e7\u0096\3\2\2\2\u01e8\u01e9\t\b\2\2\u01e9\u0098\3\2"+
		"\2\2\u01ea\u01eb\t\t\2\2\u01eb\u01ec\3\2\2\2\u01ec\u01ed\bM\2\2\u01ed"+
		"\u009a\3\2\2\2\u01ee\u01ef\7\61\2\2\u01ef\u01f0\7\61\2\2\u01f0\u01f4\3"+
		"\2\2\2\u01f1\u01f3\n\n\2\2\u01f2\u01f1\3\2\2\2\u01f3\u01f6\3\2\2\2\u01f4"+
		"\u01f2\3\2\2\2\u01f4\u01f5\3\2\2\2\u01f5\u01f8\3\2\2\2\u01f6\u01f4\3\2"+
		"\2\2\u01f7\u01f9\7\17\2\2\u01f8\u01f7\3\2\2\2\u01f8\u01f9\3\2\2\2\u01f9"+
		"\u01fa\3\2\2\2\u01fa\u01fb\7\f\2\2\u01fb\u01fc\3\2\2\2\u01fc\u01fd\bN"+
		"\2\2\u01fd\u009c\3\2\2\2\17\2\u00a1\u00a5\u0138\u013f\u0145\u0155\u015d"+
		"\u0169\u01e1\u01e3\u01f4\u01f8\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}