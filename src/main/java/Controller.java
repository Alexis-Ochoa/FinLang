import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.stage.Stage;
import java_cup.runtime.ComplexSymbolFactory;

import java.io.StringReader;

public class Controller {
    @FXML public Button btnClick;
    @FXML public Button btnClose;
    @FXML public Button btnMax;
    @FXML public Button btnMin;
    @FXML private TextArea codeEditor;
    @FXML private ListView<String> lineNumbers;
    @FXML private TextArea outputArea;

    private ComplexSymbolFactory symbolFactory = new ComplexSymbolFactory();

    private boolean isMaximized = true;

    @FXML
    private void closeApp() {
        Stage stage = (Stage) btnClose.getScene().getWindow();
        stage.close();
    }

    @FXML
    private void maxApp() {
        Stage stage = (Stage) btnMax.getScene().getWindow();
        isMaximized = !isMaximized;
        stage.setMaximized(isMaximized);
    }

    @FXML
    private void minApp() {
        Stage stage = (Stage) btnMin.getScene().getWindow();
        stage.setIconified(true);
    }

    private String analyzeText(String text) {
        // Aquí puedes modificar el texto como necesites
        return text.toUpperCase(); // Ejemplo: convierte todo a mayúsculas
    }


    @FXML
    private void run() {
        String userInput = codeEditor.getText().trim(); // Obtiene el texto ingresado

        if (userInput.isEmpty()) {
            outputArea.setText("⚠ No hay texto para analizar.");
            return;
        }

        try {
            FinLangLexer lexer = new FinLangLexer(new StringReader(userInput), symbolFactory);
            lexer.yyreset(new StringReader(userInput)); // Asegurar que recibe correctamente la entrada

            Parser parser = new Parser(lexer, symbolFactory);
            Object result = parser.parse().value;
            System.out.println("📌 Resultado final desde el parser: " + result);

            // 🔍 Depuración: Imprimir el resultado en consola antes de enviarlo a outputArea
            System.out.println("Resultado desde el parser: " + result);

            if (result != null) {
                outputArea.setText(result.toString()); // 🔹 Ahora mostrará el resultado en la interfaz
            } else {
                outputArea.setText("⚠ Error: No se pudo calcular un resultado válido.");
            }

        } catch (Exception e) {
            outputArea.setText("❌ Error inesperado: " + e.getMessage());
            e.printStackTrace();
        }
    }

    @FXML
    private void clean () {
        codeEditor.clear();
        outputArea.clear();
    }

    @FXML
    public void initialize() {
        codeEditor.textProperty().addListener((obs, oldText, newText) -> updateLineNumbers());
        codeEditor.setOnKeyPressed(event -> {
            if (event.getCode().equals(KeyCode.ENTER)) {
                updateLineNumbers();
            }
        });
    }

    private void updateLineNumbers() {
        int lines = codeEditor.getParagraphs().size(); // Obtiene la cantidad exacta de líneas visibles

        lineNumbers.getItems().clear();
        for (int i = 1; i <= lines; i++) {
            lineNumbers.getItems().add(String.valueOf(i)); // Agregar número de línea correcto
        }
    }
}