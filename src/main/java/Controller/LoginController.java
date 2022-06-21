package Controller;

import code.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;


public class LoginController extends Stage {
    private Store s;
    private Pane rpane;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label ErrorField;

    @FXML
    void loginButtonPressed() throws IOException{
        System.out.println("Pressed");
        if(true) {
            Stage stage = new Stage();
            AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
            stage.setTitle("Menu");
            stage.setScene(new Scene(pane));
            stage.show();
        } else{
            ErrorField.setTextFill(Color.FIREBRICK);
            ErrorField.setText("Wrong password or username...");
        }
    }
}
