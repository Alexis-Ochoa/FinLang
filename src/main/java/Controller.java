import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;

public class Controller {
    @FXML public Button btnClick;
    @FXML public Button btnClose;
    @FXML public Button btnMax;
    @FXML public Button btnMin;
    @FXML private TextArea codeEditor;
    @FXML private ListView<String> lineNumbers;
    @FXML private TextArea outputArea;

    private boolean isMaximized = false;

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
    private void run () {
        String userInput = codeEditor.getText(); // Obtiene el texto ingresado
        String processedText = analyzeText(userInput); // Llama a la función de procesamiento
        outputArea.setText(processedText); // Muestra el resultado en el área de salida
    }


    @FXML
    private void clean () {}

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