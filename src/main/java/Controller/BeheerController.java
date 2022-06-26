package Controller;

import code.Medewerker;
import code.Status;
import code.Store;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.*;
import javafx.scene.text.Font;

import java.io.FileNotFoundException;
import java.io.IOException;

public class BeheerController {
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
    private AnchorPane rootPane;
    @FXML
    private ScrollPane scroll;


    public BeheerController() throws FileNotFoundException {

    }

    public void initialize() throws FileNotFoundException {
        setProduct("Boor");
        setProduct("Auto");
        setProduct("Vrachtwagen");
    }

    void setHboxStyle(HBox hBox){
        hBox.setStyle("-fx-border-color: #8181c9;");
        hbox.setAlignment(Pos.CENTER);
        hBox.setMinSize(10, 35);
        //hBox.setMaxSize(280,35);
    }

    void setLabels(String product){
        Label name = new Label(product);
        name.setFont(new Font(16));
        HBox.setMargin(name, new Insets(0, 0, 0, 0));
        hbox.getChildren().add(name);
        name.setOnMouseClicked(mouseEvent -> {
            try {

                FXMLLoader loader = new FXMLLoader();
                loader.setLocation(getClass().getResource("/view/Toevoegen.fxml"));

                AnchorPane p = loader.load();

                ToevoegenController dc = loader.getController();
                dc.setStatus(st, m);
                dc.setProduct(product);


                rootPane.getChildren().setAll(p);

            } catch (IOException exception) {
                exception.printStackTrace();
            }

        });
    }

    void setProduct(String s){
        vBox = new VBox();
        hbox = new HBox();

        setLabels(s);
        setHboxStyle(hbox);
        vBox.getChildren().add(hbox);
        container.getChildren().add(vBox);
    }

    public void setStatus(Status st, Medewerker m) {
        this.st = st;
        this.m = m;
        naam.setText(m.getMedcode() + ") " + m.getVoornaam());
    }

    public void back(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Menu.fxml"));

        AnchorPane p = loader.load();

        MenuController dc = loader.getController();
        dc.setStatus(st, m);

        rootPane.getChildren().setAll(p);
    }
}
