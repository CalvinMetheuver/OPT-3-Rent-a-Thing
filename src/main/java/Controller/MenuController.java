package Controller;

import code.Medewerker;
import code.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuController {

    private Store s = Store.getInstance();
    private Medewerker m;


    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label naam;

    @FXML
    private Label titel;

    public MenuController() throws FileNotFoundException {
    }

    public void initialize() throws FileNotFoundException {

    }

    @FXML
    public void overzicht() throws IOException {

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Overzicht.fxml"));

        AnchorPane pane =loader.load();

        OverzichtController mc = loader.getController();
        mc.setMedewerker(m);

        rootPane.getChildren().setAll(pane);
    }

    public void beheer(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Beheer.fxml"));

        AnchorPane pane =loader.load();

        BeheerController mc = loader.getController();
        mc.setMedewerker(m);

        rootPane.getChildren().setAll(pane);
    }

    public void loguit(MouseEvent mouseEvent) {
    }

    public void setMedewerker(Medewerker m) {
        this.m = m;
        naam.setText(m.getMedcode() + ") " + m.getVoornaam());
        titel.setText("Hallo " + m.getVoornaam());
    }
}
