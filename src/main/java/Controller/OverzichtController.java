package Controller;

import code.Medewerker;
import code.Product;
import code.Status;
import code.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverzichtController {
    private Store s = Store.getInstance();
    private Medewerker m;
    private Status st;

    private HBox hbox;

    private VBox vBox;

    @FXML
    private Label naam;
    @FXML
    private VBox container;
    @FXML
    private VBox opVoorraad;
    @FXML
    private AnchorPane rootPane;
    @FXML
    private ScrollPane scroll;


    public OverzichtController() throws FileNotFoundException {

    }

    public void initialize() throws FileNotFoundException {
       loopProduct();
    }

    void setHboxStyle(HBox hBox){
        hBox.setStyle("-fx-border-color: #8181c9;");
        hbox.setAlignment(Pos.CENTER);
        hBox.setMinSize(10, 35);
    }

    void setLabels(Product product){
        Label name = new Label(product.getTot());
        name.setFont(new Font(16));
        HBox.setMargin(name, new Insets(0, 0, 0, 0));
        hbox.getChildren().add(name);
        name.setOnMouseClicked(mouseEvent -> {
            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/Details.fxml"));

                AnchorPane p = loader.load();

                DetailsController dc = loader.getController();
                dc.setProduct(product);
                dc.setStatus(st, m);

                rootPane.getChildren().setAll(p);

            } catch (IOException exception) {
                exception.printStackTrace();
            }

        });
    }

    void loopProduct(){
        for(Product p:s.producten){
            setProduct(p);
            setAanwezig(p);
        }
    }

    void setProduct(Product p){
        vBox = new VBox();
        hbox = new HBox();

        setLabels(p);
        setHboxStyle(hbox);
        vBox.getChildren().add(hbox);
        container.getChildren().add(vBox);
    }

    void setAanwezig(Product p){

        vBox = new VBox();
        hbox = new HBox();

        if(p.verhuurd()){
            vBox.setStyle("-fx-background-color:RED");
        }else{
            vBox.setStyle("-fx-background-color:GREEN");
        }

        CheckBox x = new CheckBox();
        x.setSelected(!p.verhuurd());
        x.setDisable(true);
        hbox.getChildren().add(x);

        setHboxStyle(hbox);
        vBox.getChildren().add(hbox);
        opVoorraad.getChildren().add(vBox);
    }

    public void setStatus(Status st, Medewerker m) {
        this.st = st;
        this.m = m;
        naam.setText(m.getMedcode() + ") " + m.getVoornaam());
    }

    @FXML
    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Menu.fxml"));

        AnchorPane p = loader.load();

        MenuController dc = loader.getController();
        dc.setStatus(st, m);

        rootPane.getChildren().setAll(p);
    }
}
