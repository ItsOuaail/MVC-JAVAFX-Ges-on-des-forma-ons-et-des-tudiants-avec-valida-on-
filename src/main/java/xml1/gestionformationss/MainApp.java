package xml1.gestionformationss;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Load the FXML file
        FXMLLoader loader = new FXMLLoader(getClass().getResource("main.fxml"));

        // Create the scene and attach the stylesheet
        Scene scene = new Scene(loader.load());
        scene.getStylesheets().add(getClass().getResource("style.css").toExternalForm());

        // Set up the stage
        primaryStage.setScene(scene);
        primaryStage.setTitle("Gestion des formations et des étudiants");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
