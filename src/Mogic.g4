grammar Mogic;

mogic_pro : program ;

program
		:   class_decl program?
		|   func_decl program?
		|   var_decl_stmt program?
		;

class_decl
		:	CLASS id OPB_FIG member_decl_list CLB_FIG
		;

member_decl_list
		:	(member_decl)+;

member_decl
        :   type id SEMICOLON;

func_decl
		:	type id OPB_RND (parameter_list)? CLB_RND block_stmt//void joined?
		;

parameter_list
		:	type id
		|	type id COMMA parameter_list
		;

type
		:	primitive_type (dim_SQ)*;

dim_SQ
		:	OPB_SQ CLB_SQ;

//expression
expr
		:   assignment_expr
		;

logic_or_expr
		: 	logic_and_expr
		|   logic_or_expr OR logic_and_expr
		;

logic_and_expr
		: 	inclusive_or_expr
		|   logic_and_expr AND inclusive_or_expr
		;

inclusive_or_expr
		: 	exclusive_or_expr
		|   inclusive_or_expr BIT_OR exclusive_or_expr
		;

exclusive_or_expr
		: 	and_expr
		|   exclusive_or_expr BIT_XOR and_expr
		;

and_expr
		: 	equ_expr
		|   and_expr BIT_AND equ_expr
		;

equ_expr
		: 	relational_expr
		|   equ_expr equality_operator relational_expr
		;

relational_expr
		: 	shift_expr
		|   relational_expr comparsion_operator shift_expr
		;

shift_expr
		: 	additive_expr
		|   shift_expr shift_operator additive_expr
		;

additive_expr
		: 	muly_expr
		|   additive_expr PLUS muly_expr
		|   additive_expr MINUS muly_expr
		;

muly_expr
		: 	unary_expr
		|   muly_expr MUL unary_expr
		|   muly_expr DIV unary_expr
		|   muly_expr REM unary_expr
		;

unary_expr
		:   postfix_expr
		|	constructor_call
        |   DECREMENT unary_expr
        |   INCREMENT unary_expr
        |   NOT unary_expr
        |   unary_operator unary_expr
		;

constructor_call
        :   NEW primitive_type
        |   NEW primitive_type dim_expr (dim_SQ)*
        ;

dim_expr
		:	OPB_SQ assignment_expr CLB_SQ;

arr_arg_suffix
		: 	OPB_SQ assignment_expr CLB_SQ
		;

argument_expr_list//
		:   assignment_expr (COMMA assignment_expr)*
		;

assignment_expr
		: 	unary_expr ASSIGN expr
		| 	logic_or_expr
		;

postfix_expr//han shu diao yong A()() xi jie hua
		:   postfix_expr (INCREMENT | DECREMENT)
		|   constant
        |   id
        |   postfix_expr arr_arg_suffix+//a[][]
		|   postfix_expr DOT SIZE OPB_RND CLB_RND
        |   postfix_expr DOT LENGTH OPB_RND CLB_RND
        |   postfix_expr DOT SUBSTRING OPB_RND assignment_expr COMMA assignment_expr CLB_RND
        |   postfix_expr DOT PARSEINT OPB_RND CLB_RND
        |   postfix_expr DOT ORD OPB_RND assignment_expr CLB_RND
        |   postfix_expr OPB_RND argument_expr_list? CLB_RND//func
        |   postfix_expr DOT id
        |   OPB_RND expr CLB_RND
		;

unary_operator
		: 	PLUS
		| 	MINUS
		| 	Tilde
		;

constant
		:	NULL_LITERAL
		|	bool_literal
		| 	Int_literal
		|	String_literal
		;








//statement

stmt
		:	block_stmt
		| 	var_decl_stmt
		| 	expr_stmt
		| 	selection_stmt
		| 	iteration_stmt
		| 	jump_stmt
		;

//compound
block_stmt
		:	OPB_FIG stmt_list? CLB_FIG //bu wei kong
		;
stmt_list
        :	stmt
		| 	stmt stmt_list
		;
//expr_stmt
expr_stmt
		:	SEMICOLON
		|	expr SEMICOLON
		;

//jump
jump_stmt
		:	RETURN (expr)? SEMICOLON
		|	BREAK SEMICOLON
		| 	CONTINUE SEMICOLON
		;

//select
selection_stmt
		:	IF OPB_RND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1
                          AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1
                          AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1
                          AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1
                          AND expr1 AND expr1 AND expr1 AND expr1 AND expr1
                          AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 AND expr1 CLB_RND stmt
		|   IF OPB_RND expr CLB_RND stmt ELSE stmt
		|	IF OPB_RND expr CLB_RND stmt
		;

//iteration
iteration_stmt
		:	WHILE OPB_RND expr CLB_RND stmt
		| 	FOR OPB_RND (expr0)? SEMICOLON (expr1)? SEMICOLON (expr)? CLB_RND stmt
		;
expr0
        :   expr;

expr1
        :   expr;
//var_decl
var_decl_stmt
		:	type id SEMICOLON
		| 	type id ASSIGN expr SEMICOLON
		;

primitive_type
		:	INT | STRING| id | BOOL | VOID;

Int_literal
		:	[1-9] (Digit)*
		|	'0'
		;

IF: 'if';
ELSE: 'else';
FOR: 'for';
WHILE: 'while';
CONTINUE: 'continue';
BREAK: 'break';
RETURN: 'return';
NEW : 'new';
CLASS : 'class';
NULL_LITERAL : 'null';

SIZE: 'size';
PRINT: 'print';
PRINTLN: 'println';
GETSTRING: 'getString';
GETINT: 'getInt';
TOSTRING: 'toString';
LENGTH: 'length';
SUBSTRING: 'substring';
PARSEINT: 'parseInt';
ORD: 'ord';

bool_literal : TRUE | FALSE;
TRUE : 'true';
FALSE : 'false';

String_literal:  '"' SChar* '"';

fragment
SChar
    :   ~["\\\r\n]
    |   EscapeSequence
    ;

fragment
EscapeSequence
    :   SimpleEscapeSequence
    |   OctalEscapeSequence
    |   HexadecimalEscapeSequence
    |   UniversalCharacterName
    ;

fragment
SimpleEscapeSequence
    :   '\\' ['"?abfnrtv\\]
    ;

fragment
OctalEscapeSequence
    :   '\\' OctalDigit
    |   '\\' OctalDigit OctalDigit
    |   '\\' OctalDigit OctalDigit OctalDigit
    ;

fragment
HexadecimalEscapeSequence
    :   '\\x' HexadecimalDigit+
    ;

fragment
UniversalCharacterName
    :   '\\u' HexQuad
    |   '\\U' HexQuad HexQuad
    ;

fragment
HexQuad
    :   HexadecimalDigit HexadecimalDigit HexadecimalDigit HexadecimalDigit
    ;

fragment
HexadecimalDigit
    :   [0-9a-fA-F]
    ;

fragment
OctalDigit
    :   [0-7]
    ;

equality_operator: (EQ|NEQ);
EQ: '==';
NEQ: '!=';

comparsion_operator: (GT|LT|GE|LE);

GT: '>';
LT: '<';
GE: '>=';
LE: '<=';

shift_operator: (LSHIFT|RSHIFT);
LSHIFT: '<<';
RSHIFT: '>>';

INCREMENT: '++';
DECREMENT: '--';

SEMICOLON: ';';
OPB_FIG: '{';
CLB_FIG: '}';
OPB_RND: '(';
CLB_RND: ')';
OPB_SQ: '[';
CLB_SQ: ']';
DOUBLE_DOT: ':';
COMMA: ',';
DOT: '.';
ETC: '...';
PLUS: '+';
MINUS: '-';
MUL: '*';
DIV: '/';
ASSIGN: '=';
BIT_AND: '&';
BIT_OR: '|';
BIT_XOR: '^';
Tilde : '~';
AND: '&&';
OR: '||';
QUESTION: '?';
REM: '%';
NOT: '!';

VOID: 'void';
STRING: 'string';
INT: 'int';
BOOL: 'boolean';

id
		:	SIZE
		|	PRINT
		|	PRINTLN
		|	GETSTRING
		|	GETINT
		|	TOSTRING
		|	LENGTH
		|	SUBSTRING
		|	PARSEINT
		|	ORD
		|	IDEN
		;

IDEN: 	Letter (Letter | Digit)*;

fragment Letter: [a-zA-Z_];
fragment Digit: [0-9];

WS
		:   (' '|'\r'|'\t'|'\n') -> skip
		;

COMMENT
		:   ('//' ~('\n'|'\r')* '\r'? '\n') -> skip
		;
//ce shi duo chong kuo hao pi pei
