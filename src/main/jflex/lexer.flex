import java_cup.runtime.Symbol;
import java_cup.sym;

%%
%class FinLangLexer
%unicode
%cup  // Tokens compatibles con CUP
/* Declaración de patrones regulares */
%{
    // Método auxiliar para devolver tokens
    private Symbol symbol(int type) {
        return new Symbol(type, yyline, yycolumn);
    }

    private Symbol symbol(int type, Object value) {
        return new Symbol(type, yyline, yycolumn, value);
    }
%}

/*Expresiones regulares y comandos*/
%%
"sumar"           { return symbol(sym.COMANDO, "sumar"); }
"restar"           { return symbol(sym.COMANDO, "restar"); }
"multiplicar"            { return symbol(sym.COMANDO, "multiplicar"); }
"dividir"            { return symbol(sym.COMANDO, "dividir"); }
"IVA"            { return symbol(sym.COMANDO, "IVA"); }
"ISR"            { return symbol(sym.COMANDO, "ISR"); }
"ISAN"            { return symbol(sym.COMANDO, "ISAN"); }
"ISN"            { return symbol(sym.COMANDO, "ISN"); }
"ISH"            { return symbol(sym.COMANDO, "ISH"); }
"ISAI"            { return symbol(sym.COMANDO, "ISAI"); }
"margen_ganancia" { return symbol(sym.COMANDO, "margen_ganancia"); }
"porcentaje" { return symbol(sym.COMANDO, "porcentaje"); }

/*Simbolos*/
","         {return symbol(sym.COMA);}
"("         {return symbol(sym.LBRACKET);}
")"         {return symbol(sym.RBRACKET);}
";"         {return symbol(sym.SEMIC);}

//Numeros que acepta
[0-9]+(\.[0-9]+)?   { return symbol(sym.NUMERO, Double.parseDouble(yytext())); }  // Números decimales

[ \t\r\n\f]+        { /* Ignorar espacios en blanco */ }
. {return symbol(sym.error);} // Retorna token especial de error}