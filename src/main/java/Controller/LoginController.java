package Controller;

import code.*;
import javafx.event.EventHandler;
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
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.io.IOException;


public class LoginController extends Stage {
    private Store s = Store.getInstance();
    private Pane rpane;
    private Medewerker m;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label ErrorField;

    public LoginController() throws FileNotFoundException {
    }

    @FXML
    void loginButtonPressed() throws IOException {
        m = null;
        try {
            int medcode = Integer.parseInt(usernameField.getText());
            String ww = passwordField.getText();
            m = s.login(medcode, ww);
        } catch (NumberFormatException numberFormatException) {

        }
        if (m != null) {
            new Status(m);
            ErrorField.setVisible(false);
        } else {
            ErrorField.setVisible(true);
            ErrorField.setTextFill(Color.FIREBRICK);
            ErrorField.setText("Error...");
        }

        usernameField.clear();
        passwordField.clear();
    }

}
