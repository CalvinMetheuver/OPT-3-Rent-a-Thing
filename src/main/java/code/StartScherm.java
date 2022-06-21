package code;

import javafx.animation.Animation;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.ObjectInputFilter;

import java.util.ArrayList;
import java.util.List;
public class StartScherm {

    class EventHandlerNewStatus implements EventHandler<ActionEvent>{

        private Store store;

        public EventHandlerNewStatus (Store store) {
            this.store = store;
        }

        @Override
        public void handle (ActionEvent actionEvent) {
            new Status(this.store);
        }
    }


    public class Startscherm extends Application {
        private Store s;
        public Startscherm() throws FileNotFoundException {
            this.s = Store.getInstance();
        }

        @Override
        public void start (Stage primaryStage) {

            Pane rootPane = new Pane ();
            rootPane.setMinSize (400, 200);
            Scene startScene = new Scene (rootPane);

            Button button = new Button ("Open new status window");
            button.setOnAction (new EventHandlerNewStatus (s));
            rootPane.getChildren ().add (button);

            primaryStage.setScene (startScene);
            primaryStage.setTitle ("Bowling lanes");
            primaryStage.show ();
        }
    }
}
