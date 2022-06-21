import code.StartScherm;
import code.Status;
import code.Store;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;

public class JavaFXApp extends Application {

    class EventHandlerNewStatus implements EventHandler<ActionEvent> {
        private Store s;

        public EventHandlerNewStatus (Store store) {
            this.s = store;
        }

        @Override
        public void handle (ActionEvent actionEvent) {
            new Status(this.s);
        }
    }



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
