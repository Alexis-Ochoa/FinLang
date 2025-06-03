import java_cup.runtime.Symbol;
import java_cup.runtime.ComplexSymbolFactory;
import java_cup.runtime.ComplexSymbolFactory.Location;
import java_cup.sym;

%%
%class FinLangLexer
%extends java_cup.runtime.Scanner
%cup
%unicode
%line
%column
%cup
%eofval{
    return symbol(sym.EOF);
%eofval}


%{

private ComplexSymbolFactory symbolFactory;

public FinLangLexer(java.io.Reader r, ComplexSymbolFactory csf) {
    super(r);  // llama al constructor base con Reader
    this.symbolFactory = csf;
}

private Symbol symbol(int type) {
    return symbolFactory.newSymbol(sym.terminalNames[type], type,
        new Location(yyline+1, yycolumn+1),
        new Location(yyline+1, yycolumn+yylength()));
}

private Symbol symbol(int type, Object value) {
    return symbolFactory.newSymbol(sym.terminalNames[type], type,
        new Location(yyline+1, yycolumn+1),
        new Location(yyline+1, yycolumn+yylength()), value);
}

// No declares next_token(), JFlex lo genera con %cup

%}

WhiteSpace = [ \t\r\n\f]

%%

/* Comandos - ahora permitimos espacios después del comando */
"sumar"{WhiteSpace}*    { return symbol(sym.COMANDO, "sumar"); }
"restar"{WhiteSpace}*   { return symbol(sym.COMANDO, "restar"); }
"multiplicar"{WhiteSpace}* { return symbol(sym.COMANDO, "multiplicar"); }
"dividir"{WhiteSpace}*  { return symbol(sym.COMANDO, "dividir"); }
"IVA"{WhiteSpace}*      { return symbol(sym.COMANDO, "IVA"); }
"ISR"{WhiteSpace}*      { return symbol(sym.COMANDO, "ISR"); }
"ISAN"{WhiteSpace}*     { return symbol(sym.COMANDO, "ISAN"); }
"ISN"{WhiteSpace}*      { return symbol(sym.COMANDO, "ISN"); }
"ISH"{WhiteSpace}*      { return symbol(sym.COMANDO, "ISH"); }
"ISAI"{WhiteSpace}*     { return symbol(sym.COMANDO, "ISAI"); }
"margen_ganancia"{WhiteSpace}* { return symbol(sym.COMANDO, "margen_ganancia"); }
"porcentaje"{WhiteSpace}* { return symbol(sym.COMANDO, "porcentaje"); }

/* Símbolos */
"("               { return symbol(sym.LBRACKET); }
")"               { return symbol(sym.RBRACKET); }
","               { return symbol(sym.COMA); }
";"               { return symbol(sym.SEMIC); }

/* Números */
"-"?[0-9]+("."[0-9]+)? { return symbol(sym.NUMERO, Double.parseDouble(yytext())); }

{WhiteSpace}      { /* ignorar espacios en blanco */ }

/* Error - cualquier otro carácter */
.                 { return symbol(sym.error); }