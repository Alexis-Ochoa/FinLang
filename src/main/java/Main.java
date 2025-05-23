import java_cup.runtime.*;
import java.io.StringReader;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

        System.out.println("Calculadora Financiera");
        System.out.println("Escribe 'salir' para terminar");
        System.out.println("Formato: comando(numero1,numero2);");

        while (true) {
            System.out.print("> ");
            String entrada = scanner.nextLine().trim();

            if (entrada.equalsIgnoreCase("salir")) {
                break;
            }

            if (entrada.isEmpty()) {
                continue;
            }

            try {
                FinLangLexer lexer = new FinLangLexer(new StringReader(entrada + "\n"));
                Parser parser = new Parser(lexer, symbolFactory);
                parser.parse(); // Analizar sin esperar resultado
            } catch (Exception e) {
                if (!e.getMessage().contains("EOF")) {
                    System.err.println("Error: Formato incorrecto. Use: comando(num1,num2);");
                }
            }
        }
        scanner.close();
        System.out.println("¡Hasta luego!");
    }
}