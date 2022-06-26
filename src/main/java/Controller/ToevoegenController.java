package Controller;

import code.*;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;

public class ToevoegenController extends Observable {
    private Store s = Store.getInstance();
    private Medewerker m;
    private String prod;
    private Status st;

    @FXML
    private AnchorPane rootPane;
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
    @FXML
    private Label error;


    public ToevoegenController()  throws FileNotFoundException {
    }

    public void initialize() {
        error.setText("InputError");
        error.setVisible(false);
        product.setText(prod);
    }

    public void setStatus(Status st, Medewerker m) {
        this.st = st;
        this.m = m;
        naam.setText(m.getMedcode() + ") " + m.getVoornaam());
    }

    public void setProduct(String p){
        this.prod = p;
        product.setText(p);
        merk.setText("");
        type.setText("");
        gewicht.setText("0");
        lv.setText("0");
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

    public void home(MouseEvent mouseEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Beheer.fxml"));

        AnchorPane p = loader.load();

        BeheerController dc = loader.getController();
        dc.setStatus(st, m);

        rootPane.getChildren().setAll(p);
    }

    public void actie(MouseEvent mouseEvent) throws IOException {
        int g = Integer.parseInt(gewicht.getText());
        int l = Integer.parseInt(lv.getText());
        Product p = null;
        if (!merk.getText().equals("")) {
            switch (this.prod) {
                case ("Boor"):
                    if (!type.getText().equals("")) {
                        p = ProductFactory.BOOR_FACTORY.createProduct(merk.getText(), type.getText(), g, l);
                    }else{
                        error.setVisible(true);
                    }
                    break;
                case ("Auto"):
                    if(g != 0) {
                        p = ProductFactory.AUTO_FACTORY.createProduct(merk.getText(), type.getText(), g, l);
                    } else{
                        error.setVisible(true);
                    }
                    break;
                case ("Vrachtwagen"):
                    if(g != 0 && l != 0) {
                        p = ProductFactory.VRACHTWAGEN_FACTORY.createProduct(merk.getText(), type.getText(), g, l);
                    }else{
                        error.setVisible(true);
                    }
                    break;
            }
        }else{
            error.setVisible(true);
        }
        if (p != null) {
            st.addOb(p);
            p.setOpVerhuurd(false, null, null);
        }
    }
}
