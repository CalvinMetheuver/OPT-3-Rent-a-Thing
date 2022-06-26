package Controller;

import code.Medewerker;
import code.Product;
import code.Status;
import code.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class MenuController {

    private Store s = Store.getInstance();
    private Medewerker m;
    private Status st;


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
        mc.setStatus(st, m);

        rootPane.getChildren().setAll(pane);
    }

    public void beheer(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Beheer.fxml"));

        AnchorPane pane =loader.load();

        BeheerController mc = loader.getController();
        mc.setStatus(st, m);

        rootPane.getChildren().setAll(pane);
    }

    public void loguit(MouseEvent mouseEvent) {

        for(Product p: s.getVerhuurd()){
            p.deleteObserver(st);
        }
        m.setActief(false);

        Stage stage = (Stage) rootPane.getScene().getWindow();
        stage.close();
    }

    public void setStatus(Status st, Medewerker m) {
        this.st = st;
        this.m = m;
        naam.setText(m.getMedcode() + ") " + m.getVoornaam());
        titel.setText("Hallo " + m.getVoornaam());
    }
}
