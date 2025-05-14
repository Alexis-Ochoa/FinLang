import java_cup.Lexer;
import java_cup.parser;

import java.io.FileReader;

public class Main {
    public static void main(String[] args) throws Exception {
        Lexer lexer = new Lexer(new FileReader("ejemplo.fin"));
        parser parser = new parser(lexer);
        parser.parse();
    }
}
