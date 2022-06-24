package Controller;

import code.Klant;
import code.Medewerker;
import code.Product;
import code.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DetailsController {

    Store s = Store.getInstance();
    Medewerker m;
    Product prod;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label naam;

    @FXML
    private Label product;

    @FXML
    private Label opv;

    @FXML
    private TextField klantL;

    @FXML
    private Label klant;

    @FXML
    private Label vzL;

    @FXML
    private CheckBox vz;

    @FXML
    private Label medL;

    @FXML
    private Label med;

    @FXML
    private Label prijsL;

    @FXML
    private Label prijs;

    @FXML
    private Button actie;

    @FXML
    private Button home;

    public DetailsController() throws FileNotFoundException {
    }

    public void initialize() throws FileNotFoundException {
        vzL.setVisible(false);
        vz.setVisible(false);
        medL.setVisible(false);
        med.setVisible(false);
        prijsL.setVisible(false);
        prijs.setVisible(false);
        klantL.setVisible(false);
        klant.setVisible(false);
    }

    public void setProduct(Product p){
        prod = p;
        product.setText(p.getTot());

        if (!p.verhuurd()){
            nietverhuurd(p);
        } else{
            welverhuurd(p);
        }
        opv.setVisible(true);
        klik(p);

    }

    private void nietverhuurd(Product p) {
        opv.setText("AANWEZIG");
        opv.setStyle("-fx-background-color:GREEN");

        medL.setVisible(false);
        med.setVisible(false);
        klant.setVisible(false);

        prijsL.setVisible(true);
        vzL.setVisible(true);
        klantL.setVisible(true);

        String sPrijs = String.format("€%.2f",p.berekenPrijs(vz.isSelected()));
        prijs.setText(sPrijs);
        prijs.setVisible(true);

        vz.setVisible(true);
        vz.setDisable(false);

        actie.setText("Verhuur");
    }

    private void welverhuurd(Product p) {
        opv.setText("NIET AANWEZIG");
        opv.setStyle("-fx-background-color:RED");

        prijsL.setVisible(false);
        prijs.setVisible(false);
        vzL.setVisible(false);
        vz.setVisible(false);
        klantL.setVisible(false);

        medL.setVisible(true);

        med.setText(p.getMedewerker().getVoornaam());
        med.setVisible(true);

        klant.setText(p.getKlant().getAnaam());
        klant.setVisible(true);

        actie.setText("Retour");
    }

    public void klik(Product p) {
        vz.setOnAction((event) -> {
            String sPrijs = String.format("€%.2f",p.berekenPrijs(vz.isSelected()));
            prijs.setText(sPrijs);
        });
    }

    @FXML
    private void actie() throws IOException {
        if(prod.verhuurd()){
            prod.setOpVerhuurd(false, null, null);
        }else {
            String[] klant = new String[2];
            try {
                klant = klantL.getText().split(", ");
            } catch (Exception e) {
                e.printStackTrace();
            }
            if (klant != null && klant.length == 2) {
                prod.setOpVerhuurd(!prod.verhuurd(), m, new Klant(klant[1], klant[0]));
            } else {
                prod.setOpVerhuurd(!prod.verhuurd(), m, new Klant("Voornaam", "Achternaam"));
            }
        }

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/Details.fxml"));

            AnchorPane p = loader.load();

            DetailsController dc = loader.getController();
            dc.setProduct(prod);
            dc.setMedewerker(m);

            rootPane.getChildren().setAll(p);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    void setMedewerker(Medewerker m) {
        this.m = m;
        naam.setText(m.getMedcode() + ") " + m.getVoornaam());
        System.out.println(m);
    }


    @FXML
    private void home() throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Overzicht.fxml"));

        AnchorPane p = loader.load();

        OverzichtController dc = loader.getController();
        dc.setMedewerker(m);

        rootPane.getChildren().setAll(p);

    }
}
