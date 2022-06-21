
import code.Store;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXApp extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start (Stage primaryStage) throws IOException {

        Parent rootPane = FXMLLoader.load(getClass().getResource("/view/LoginScreen.fxml"));
        Scene startScene = new Scene(rootPane);

        primaryStage.setScene(startScene);
        primaryStage.setTitle("Bowling lanes");
        primaryStage.show();
    /*
    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));

        primaryStage.setScene(new Scene(root));
        primaryStage.setTitle("Rent-a-Thing");
        primaryStage.show();
    }
     */
    }}
