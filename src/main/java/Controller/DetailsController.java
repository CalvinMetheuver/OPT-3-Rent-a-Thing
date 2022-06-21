package Controller;

import code.Klant;
import code.Product;
import code.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.IOException;

public class DetailsController {

    Store s = Store.getInstance();
    Product prod;

    @FXML
    private Label product;

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label prijs;

    @FXML
    private Label opv;

    @FXML
    private CheckBox vz;

    @FXML
    private Label med;

    @FXML
    private Label klant;

    @FXML
    private Button vh;

    @FXML
    private Button home;

    public DetailsController() throws FileNotFoundException {

    }

    public void initialize() throws FileNotFoundException {

    }

    public void setProduct(Product p){
        prod = p;

        product.setText(p.getTot());
        String sPrijs = String.format("€%.2f",p.berekenPrijs(vz.isSelected()));
        prijs.setText(sPrijs);
        opv.setVisible(true);
        if (!p.verhuurd()){
            opv.setText("AANWEZIG");
            opv.setStyle("-fx-background-color:GREEN");

            prijs.setVisible(false);
            vz.setVisible(false);

            med.setVisible(true);


        } else{
            opv.setText("NIET AANWEZIG");
            opv.setStyle("-fx-background-color:RED");
        }

    }

    @FXML
    private void vh() throws IOException {

        prod.setOpVerhuurd(!prod.verhuurd(), s.medewerkers.get(0), new Klant("Kees", "vdSpek"));

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/Details.fxml"));

            AnchorPane m = loader.load();

            DetailsController dc = loader.getController();
            dc.setProduct(prod);

            rootPane.getChildren().setAll(m);

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    @FXML
    private void home() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
