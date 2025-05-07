%%
%class Lexer
%unicode
%cup
%public

%%

\s+                         { /* ignorar espacios */ }
[0-9]+(\.[0-9]+)?           { return new Symbol(Sym.NUMBER, Double.parseDouble(yytext())); }
"mostrar"                  { return new Symbol(Sym.SHOW); }
"="                        { return new Symbol(Sym.EQUALS); }
"*"                        { return new Symbol(Sym.TIMES); }
"/"                        { return new Symbol(Sym.DIVIDE); }
"-"                        { return new Symbol(Sym.MINUS); }
"+"                        { return new Symbol(Sym.PLUS); }
[a-zA-Z_][a-zA-Z0-9_]*      { return new Symbol(Sym.ID, yytext()); }
\n                         { return new Symbol(Sym.EOL); }