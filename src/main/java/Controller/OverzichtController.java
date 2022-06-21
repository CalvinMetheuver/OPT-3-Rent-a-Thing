package Controller;

import code.Product;
import code.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OverzichtController {
    Store s = Store.getInstance();

    private HBox hbox;

    private VBox vBox;

    @FXML
    private GridPane grid;
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

    public void toggle(){

    }

    void setHboxStyle(HBox hBox){
        hBox.setStyle("-fx-border-color: #8181c9;");
        hbox.setAlignment(Pos.CENTER);
        hBox.setMinSize(10, 35);
        //hBox.setMaxSize(280,35);
    }

    void setLabels(Product product){
        Label name = new Label(product.getTot());
        name.setFont(new Font(16));
        HBox.setMargin(name, new Insets(0, 0, 0, 0));
        hbox.getChildren().add(name);
        name.setOnMouseClicked(mouseEvent -> {
            System.out.println(product);
            try {
                Stage stage = new Stage();
                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/Details.fxml"));

                AnchorPane m = loader.load();

                DetailsController dc = loader.getController();
                dc.setProduct(product);

                stage.setTitle("Details");
                stage.setScene(new Scene(m));
                stage.show();

            } catch (IOException exception) {
                exception.printStackTrace();
            }

        });
    }




    void loopProduct(){
        System.out.println(s.producten.size());
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

}
