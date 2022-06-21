package Controller;

import code.Product;
import code.Store;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.FileNotFoundException;
import java.io.IOException;

public class OvController {

    Store s = Store.getInstance();

    @FXML
    private AnchorPane rootPane;

    @FXML
    private Label prijs;

    @FXML
    private Label opv;

    @FXML
    private CheckBox vz;

    @FXML
    private ChoiceBox<String> choice;

    @FXML
    private Button vh;

    @FXML
    private Button home;

    public OvController() throws FileNotFoundException {

    }

    public void initialize() throws FileNotFoundException {
        loopProduct();
        opv.setVisible(false);
        klik();
    }

    private void loopProduct() {
        for (Product p : s.getProducten()){
            choice.getItems().add(p.getTot());
        }
    }

    public void klik() {
        choice.setOnAction((event) -> {
            try {
                bp(choice.getSelectionModel().getSelectedIndex());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });

        vz.setOnAction((event) -> {
            try {
                bp(choice.getSelectionModel().getSelectedIndex());
            } catch (IOException exception) {
                exception.printStackTrace();
            }
        });
    }

    private void bp(int i) throws IOException {
        String p = String.format("€%.2f", s.producten.get(i).berekenPrijs(vz.isSelected()));
        prijs.setText(p);
        opv.setVisible(true);
        if (s.producten.get(i).verhuurd()){
            opv.setText("AANWEZIG");
            opv.setStyle("-fx-background-color:GREEN");
        } else{
            opv.setText("NIET AANWEZIG");
            opv.setStyle("-fx-background-color:RED");
        }

        Stage stage = new Stage();
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Details.fxml"));
        stage.setTitle("Details");
        stage.setScene(new Scene(pane));
        stage.show();

    }

    @FXML
    private void vh() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/View/Details.fxml"));
        rootPane.getChildren().setAll(pane);
    }

    @FXML
    private void home() throws IOException {
        AnchorPane pane = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
        rootPane.getChildren().setAll(pane);
    }
}
