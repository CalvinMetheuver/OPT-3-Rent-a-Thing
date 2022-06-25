package Controller;

import code.Boor;
import code.Medewerker;
import code.Product;
import code.Store;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.util.List;

public class ToevoegenController {
    private Store s = Store.getInstance();
    private Medewerker m;
    private String prod;

    
    @FXML
    private Label naam;
    @FXML
    private Label product;
    @FXML
    private Label typeL;
    @FXML
    private Label gewL;
    @FXML
    private Label lvL;
    @FXML
    private TextField merk;
    @FXML
    private TextField type;
    @FXML
    private TextField gewicht;
    @FXML
    private TextField lv;


    public ToevoegenController() throws FileNotFoundException {
    }

    public void initialize() {
        product.setText(prod);
    }

    public void setMedewerker(Medewerker m) {
        this.m = m;
        naam.setText(m.getMedcode() + ") " + m.getVoornaam());
    }

    public void setProduct(String p){
        product.setText(p);
        switch(p) {
            case ("Boor"):
                typeL.setVisible(true);
                type.setVisible(true);

                gewicht.setVisible(false);
                gewL.setVisible(false);

                lv.setVisible(false);
                lvL.setVisible(false);
                break;
            case ("Auto"):
                typeL.setVisible(false);
                type.setVisible(false);

                gewicht.setVisible(true);
                gewL.setVisible(true);

                lv.setVisible(false);
                lvL.setVisible(false);
                break;
            case ("Vrachtwagen"):
                typeL.setVisible(false);
                type.setVisible(false);

                gewicht.setVisible(true);
                gewL.setVisible(true);

                lv.setVisible(true);
                lvL.setVisible(true);
                break;
        }
    }

    public void home(MouseEvent mouseEvent) {
    }

    public void actie(MouseEvent mouseEvent) {
        //Hier te werk met ISwitchable ABSTRACT FACTORY
    }
}
