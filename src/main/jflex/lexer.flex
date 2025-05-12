import java_cup.runtime.Symbol;
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

/*Expresiones regulares y comandos */
%%
"suma"           { return symbol(sym.COMANDO, "suma"); }
"restar"           { return symbol(sym.COMANDO, "restar"); }
"multiplicar"            { return symbol(sym.COMANDO, "multiplicar"); }
"dividir"            { return symbol(sym.COMANDO, "dividir"); }
"interes"            { return symbol(sym.COMANDO, "interes"); }
"margen de ganancia" { return symbol(sym.COMANDO, "mostrar_inventario"); }
"porcentaje" { return symbol(sym.COMANDO, "porcentaje"); }
"impuestos" { return symbol(sym.COMANDO, "impuestos"); }

\"[^\"]*\"          { return symbol(sym.TEXTO, yytext().replace("\"", "")); }  // Texto entre comillas
[0-9]+              { return symbol(sym.NUMERO, Integer.parseInt(yytext())); }  // Números enteros

[ \t\r\n\f]+        { /* Ignorar espacios en blanco */ }
. {
    System.err.println("Error léxico: Carácter no reconocido '" + yytext() + "' en línea " + yyline + ", columna " + yycolumn);
    return symbol(sym.error); // Retorna token especial de error
}