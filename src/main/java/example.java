import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import jfxtras.styles.jmetro.JMetro;
import jfxtras.styles.jmetro.Style;

import java.util.Objects;

public class example extends Application {
    @Override
    public void start(Stage primaryStage) {
        Button btnClick = new Button("Haz clic");
        btnClick.setOnAction(event -> System.out.println("¡Botón presionado!"));

        StackPane root = new StackPane(btnClick);
        Scene scene = new Scene(root);
        JMetro jMetro = new JMetro(Style.DARK);
        jMetro.setScene(scene);
        scene.getStylesheets().add(Objects.requireNonNull(JMetro.class.getResource("/styles.css")).toExternalForm()); //Modo oscuro, pero la barra de la ventana sigue siendo blanca


        primaryStage.setMaximized(true);

        primaryStage.setTitle("Botón en JavaFX");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}