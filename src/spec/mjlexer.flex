package rs.ac.bg.etf.pp1;

import java_cup.runtime.Symbol;

%%

%{

	private Symbol new_symbol(int type) {
		return new Symbol(type, yyline+1, yycolumn);
	}
	
	private Symbol new_symbol(int type, Object value) {
		return new Symbol(type, yyline+1, yycolumn, value);
	}

%}

%cup
%line
%column

%xstate COMMENT

%eofval{
	return new_symbol(sym.EOF);
%eofval}

%%

" " 	{ }
"\b" 	{ }
"\t" 	{ }
"\r\n" 	{ }
"\f" 	{ }

"program"   { return new_symbol(sym.PROGRAM, yytext());}
"break"   { return new_symbol(sym.BREAK, yytext());}
"class"   { return new_symbol(sym.CLASS, yytext());}
"enum"   { return new_symbol(sym.ENUM, yytext());}
"else"   { return new_symbol(sym.ELSE, yytext());}
"const"   { return new_symbol(sym.CONST, yytext());}
"if"   { return new_symbol(sym.IF, yytext());}
"do"   { return new_symbol(sym.DO, yytext());}
"while"   { return new_symbol(sym.WHILE, yytext());}
"new"   { return new_symbol(sym.NEW, yytext());}
"print"   { return new_symbol(sym.PRINT, yytext());}
"read"   { return new_symbol(sym.READ, yytext());}
"return"   { return new_symbol(sym.RETURN, yytext());}
"void"   { return new_symbol(sym.VOID, yytext());}
"extends"   { return new_symbol(sym.EXTENDS, yytext());}
"continue"   { return new_symbol(sym.CONTINUE, yytext());}
"foreach"   { return new_symbol(sym.FOREACH, yytext());}


"+"   { return new_symbol(sym.PLUS, yytext());}
"-"   { return new_symbol(sym.MINUS, yytext());}
"*"   { return new_symbol(sym.MULTIPLY, yytext());}
"/"   { return new_symbol(sym.DIVIDE, yytext());}
"%"   { return new_symbol(sym.MOD, yytext());}
"=="   { return new_symbol(sym.EQUAL_LOGIC, yytext());}
"!="   { return new_symbol(sym.NOT_EQUAL, yytext());}
">"   { return new_symbol(sym.GREATER_THAN, yytext());}
">="   { return new_symbol(sym.GREATER_OR_EQUAL, yytext());}
"<"   { return new_symbol(sym.LESS_THAN, yytext());}
"<="   { return new_symbol(sym.LESS_OR_EQUAL, yytext());}
"&&"   { return new_symbol(sym.AND, yytext());}
"||"   { return new_symbol(sym.OR, yytext());}
"="   { return new_symbol(sym.EQUAL_ASSIGN, yytext());}
"++"   { return new_symbol(sym.INCREMENT, yytext());}
"--"   { return new_symbol(sym.DECREMENT, yytext());}
";"   { return new_symbol(sym.SEMICOLON, yytext());}
":"   { return new_symbol(sym.COLON, yytext());}
","   { return new_symbol(sym.COMMA, yytext());}
"."   { return new_symbol(sym.DOT, yytext());}
"("   { return new_symbol(sym.OPEN_PARENTHESIS, yytext());}
")"   { return new_symbol(sym.CLOSE_PARENTHESIS, yytext());}
"["   { return new_symbol(sym.OPEN_BRACKET, yytext());}
"]"   { return new_symbol(sym.CLOSE_BRACKET, yytext());}
"{"   { return new_symbol(sym.OPEN_BRACE, yytext());}
"}"   { return new_symbol(sym.CLOSE_BRACE, yytext());}
"=>"   { return new_symbol(sym.LAMBDA, yytext());}


"//" {yybegin(COMMENT);}
<COMMENT> . {yybegin(COMMENT);}
<COMMENT> "\r\n" { yybegin(YYINITIAL); }


[0-9]+  { return new_symbol(sym.INT_LITERAL, Integer.valueOf(yytext())); }
('[ -~]')  { return new_symbol(sym.CHAR_LITERAL, Character.valueOf(yytext().charAt(1))); }
("true"|"false")  { return new_symbol(sym.BOOL_LITERAL, Boolean.valueOf(yytext())); }
([a-z]|[A-Z])[a-zA-Z0-9_]* 	{return new_symbol (sym.IDENT, yytext()); }

. { System.err.println("Leksicka greska ("+yytext()+") u liniji "+(yyline+1) + " u koloni " + yycolumn); }










