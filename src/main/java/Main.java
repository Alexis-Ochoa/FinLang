import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jfxtras.styles.jmetro.JMetro;

import java.io.IOException;
import java.util.Objects;
public class Main extends Application {
    @Override
    public void start(Stage primaryStage) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/layout.fxml"));
        VBox root = loader.load();
        Scene scene = new Scene(root);
        scene.getStylesheets().add(Objects.requireNonNull(JMetro.class.getResource("/styles.css")).toExternalForm()); //Modo oscuro, pero la barra de la ventana sigue siendo blanca

        primaryStage.initStyle(StageStyle.UNDECORATED);

        primaryStage.setMaximized(true);

        primaryStage.setTitle("FinLang");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}