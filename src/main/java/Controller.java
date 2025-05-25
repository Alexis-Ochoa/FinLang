import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller {
    @FXML public Button btnClick;

    @FXML
    private void handleButtonClick() {
        System.out.println("¡Botón presionado!");
    }
}