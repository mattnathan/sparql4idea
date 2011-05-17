package com.mn.plug.idea.sparql4idea.lang.lexer;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.mn.plug.idea.sparql4idea.lang.lexer.SparqlTokenTypes.*;

%%

%class _SparqlLexer
%implements FlexLexer
%unicode
%pack

%function advance
%type IElementType


IRI_REF = "<"([^\<\>\"\{\}\|\^\`\\\x00-\x20])*">"
PNAME_NS = {PN_PREFIX}? ":"
PNAME_LN = {PNAME_NS} {PN_LOCAL}
BLANK_NODE_LABEL = "_:" {PN_LOCAL}

VAR1 = "?" {VARNAME}
VAR2 = "$" {VARNAME}
LANGTAG = "@" [a-zA-Z]+ ("-" [a-zA-Z0-9]+)*

// numbers
INTEGER = [0-9]+
DECIMAL = ([0-9]+ "." [0-9]*) | ("." [0-9]+)
DOUBLE = ([0-9]+ "." [0-9]* {EXPONENT}) | ("." ([0-9])+ {EXPONENT}) | (([0-9])+ {EXPONENT})

INTEGER_POSITIVE = "+"{INTEGER}
DECIMAL_POSITIVE = "+"{DECIMAL}
DOUBLE_POSITIVE = "+"{DOUBLE}
INTEGER_NEGATIVE = "-"{INTEGER}
DECIMAL_NEGATIVE = "-"{DECIMAL}
DOUBLE_NEGATIVE = "-"{DOUBLE}

EXPONENT = [eE] [+-]? [0-9]+

// strings
STRING_LITERAL1 = "'" ( ([^\x27\x5C\x0A\x0D]) | {ECHAR} )* "'"
STRING_LITERAL2 = "\"" ( ([^\x22\x5C\x0A\x0D]) | {ECHAR} )* "\""
STRING_LITERAL_LONG1 = "'''" ( ( "'" | "''" )? ( [^'\\] | {ECHAR} ) )* "'''"
STRING_LITERAL_LONG2 = "\"\"\"" ( ( "\"" | "\"\"" )? ( [^\"\\] | {ECHAR} ) )* "\"\"\""
ECHAR = [\\][tbnrf\\\"\']

// character sets etc
NIL = "("{WS}*")"
WS = [\x20\x09\x0D\x0A]
ANON = "["{WS}*"]"

PN_CHARS_BASE = [A-Za-z\x00c0-\x00D6\x00DB-\x00F6\x00f8-\x02FF\x0370-\x037D\x037F-\x1FFF\x200C-\x200D\x2070-\x218F\x2C00-\x2FEF\x3001-\xD7FF\xF900-\xFDCF\xFDF0-\xFFFD\x10000-\xEFFFF]
PN_CHARS_U = {PN_CHARS_BASE}|"_"
VARNAME = ( {PN_CHARS_U} | [0-9] ) ( {PN_CHARS_U} | [0-9\x00B7\x0300-\x036F\x203F-\x2040] )*
PN_CHARS = {PN_CHARS_U} | [\-0-9\x00B7\x0300-\x036F\x203F-\x2040]
PN_PREFIX = {PN_CHARS_BASE} (({PN_CHARS}|".")* {PN_CHARS})?
PN_LOCAL = ( {PN_CHARS_U} | [0-9] ) (({PN_CHARS}|".")* {PN_CHARS})?

%%

<YYINITIAL> {
  [bB][aA][sS][eE] { return KW_BASE; }
  [pP][rR][eE][fF][iI][xX] { return KW_PREFIX; }
  [sS][eE][lL][eE][cC][tT] { return KW_SELECT; }
  [cC][oO][nN][sS][tT][rR][uU][cC][tT] { return KW_CONSTRUCT; }
  [dD][eE][sS][cC][rR][iI][bB][eE] { return KW_DESCRIBE; }
  [aA][sS][kK] { return KW_ASK; }
  [oO][rR][dD][eE][rR] { return KW_ORDER; }
  [bB][yY] { return KW_BY; }
  [lL][iI][mM][iI][tT] { return KW_LIMIT; }
  [oO][fF][fF][sS][eE][tT] { return KW_OFFSET; }
  [dD][iI][sS][tT][iI][nN][cC][tT] { return KW_DISTINCT; }
  [rR][eE][dD][uU][cC][eE][dD] { return KW_REDUCED; }
  [fF][rR][dO][mM] { return KW_FROM; }
  [nN][aA][mM][eE][dD] { return KW_NAMED; }
  [wW][hH][eE][rR][eE] { return KW_WHERE; }
  [gG][rR][aA][pP][hH] { return KW_GRAPH; }
  [oO][pP][tT][iI][oO][nN][aA][lL] { return KW_OPTIONAL; }
  [uU][nN][iI][oO][nN] { return KW_UNION; }
  [fF][iI][lL][tT][eE][rR] { return KW_FILTER; }
  "a" { return KW_A; }
  [sS][tT][rR] { return KW_STR; }
  [lL][aA][nN][gG] { return KW_LANG; }
  [lL][aA][nN][gG][mM][sA][tT][cC][hH][eE][sS] { return KW_LANGMATCHES; }
  [dD][aA][tT][aA][tT][yY][pP][eE] { return KW_DATATYPE; }
  [bB][oO][uU][nN][dD] { return KW_BOUND; }
  [sS][aA][mM][eE][tT][eE][rR][mM] { return KW_SAME_TERM; }
  [iI][sS][uU][rR][iI] { return KW_IS_URI; }
  [iI][sS][iI][rR][iI] { return KW_IS_IRI; }
  [iI][sS][lL][iI][tT][eE][rR][aA][lL] { return KW_IS_LITERAL; }
  [rR][eE][gG][eE][xX] { return KW_REGEX; }

  [tT][rR][uU][eE] { return LIT_TRUE; }
  [fF][aA][lL][sS][eE] { return LIT_FALSE; }

  {INTEGER} { return LIT_INTEGER; }
  {DECIMAL} { return LIT_DECIMAL; }
  {DOUBLE} { return LIT_DOUBLE; }
  {INTEGER_POSITIVE} { return LIT_INTEGER; }
  {INTEGER_NEGATIVE} { return LIT_INTEGER; }
  {DECIMAL_POSITIVE} { return LIT_DECIMAL; }
  {DECIMAL_NEGATIVE} { return LIT_DECIMAL; }
  {DOUBLE_POSITIVE} { return LIT_DOUBLE; }
  {DOUBLE_NEGATIVE} { return LIT_DOUBLE; }

  "(" { return OP_LROUND; }
  ")" { return OP_RROUND; }
  "{" { return OP_LCURLY; }
  "}" { return OP_RCURLY; }
  "[" { return OP_LSQUARE; }
  "]" { return OP_RSQUARE; }
  
  "." { return OP_DOT; }
  ";" { return OP_SEMI; }
  "," { return OP_COMMA; }
  "||" { return OP_PIPEPIPE; }
  "&&" { return OP_ANDAND; }
  "=" { return OP_EQ; }
  "!=" { return OP_NE; }
  "<" { return OP_LT; }
  ">" { return OP_RT; }
  "<=" { return OP_LE; }
  ">=" { return OP_GE; }
  "+" { return OP_PLUS; }
  "-" { return OP_MINUS; }
  "*" { return OP_MULT; }
  "/" { return OP_DIV; }
  "!" { return OP_NOT; }
  "^^" { return OP_HATHAT; }

  {IRI_REF} { return LIT_IRI; }
  {PNAME_LN}|{PNAME_NS} { return LIT_PNAME; }
  {BLANK_NODE_LABEL} { return LIT_BLANK_NODE; }
  {ANON} { return LIT_ANON; }
  {NIL} { return LIT_NIL; }
  {LANGTAG} { return LANGTAG; }

  {VAR1}|{VAR2} { return VAR; }
  {STRING_LITERAL1}|{STRING_LITERAL2}|{STRING_LITERAL_LONG1}|{STRING_LITERAL_LONG2} { return LIT_STRING; }

  "#".* { return COMMENT; }
}

{WS} { return WHITE_SPACE; }
[a-zA-Z]+ { return UNKNOWN; }
[^] { return BAD_CHARACTER; }
