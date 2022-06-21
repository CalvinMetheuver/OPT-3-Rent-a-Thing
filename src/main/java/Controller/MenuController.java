package Controller;

import code.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuController {

    private Store s = Store.getInstance();

    @FXML
    private AnchorPane rootPane;

    public MenuController() throws FileNotFoundException {
    }

    @FXML
    public void overzicht() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Overzicht.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void beheer(MouseEvent mouseEvent) throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Beheer.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    public void loguit(MouseEvent mouseEvent) {
    }
}
