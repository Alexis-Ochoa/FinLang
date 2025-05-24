import java_cup.runtime.*;
import java.io.StringReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

        System.out.println("Calculadora Financiera");
        System.out.println("Escribe 'exit' para terminar");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("exit")) {
                break;
            }

            if (entrada.isEmpty()) {
                continue;
            }

            try {
                FinLangLexer lexer = new FinLangLexer(new StringReader(entrada), symbolFactory);
                lexer.yyreset(new StringReader(entrada)); // setea el input

                Parser parser = new Parser(lexer, symbolFactory);

                Object result = parser.parse().value;
                if (result != null) {
                    System.out.println(result);
                }
            } catch (ClassCastException cce) {
                System.out.println("❌ Error interno: tipo de dato no esperado.");
            } catch (Exception e) {
                System.out.println("❌ Error: Comando con formato inválido.");
            }
        }

        scanner.close();
        System.out.println("¡Hasta luego!");
    }
}
