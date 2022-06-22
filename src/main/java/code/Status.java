package code;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

class EvHToggle implements EventHandler<ActionEvent>{

    private Status status;
    private Product p;

    EvHToggle(Product p, Status status) throws FileNotFoundException {
        this.p = p;
        this.status = status;
    }

    @Override
    public void handle(ActionEvent actionEvent) {
        this.p.setOpVerhuurd(!p.verhuurd(), new Medewerker("c", "b", 8, "j"), new Klant("n", "m"));
        try {
            this.status.draw();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class  EvHClose implements EventHandler<WindowEvent>{

    private Store s = Store.getInstance();
    private Status status;
    private Medewerker m;

    public EvHClose (Status status, Medewerker m) throws FileNotFoundException {
        this.m = m;
        this.status = status;
    }

    @Override
    public void handle(WindowEvent windowEvent) {
        for(Product p: s.getVerhuurd()){
            p.deleteObserver(this.status);
        }
        m.actief = false;

    }
}

public class Status extends Stage implements Observer {
    private Store s = Store.getInstance();
    AnchorPane pane = new AnchorPane();

    public Status(Medewerker m) throws IOException {
        for (Product p: s.producten){
            p.addObserver(this);
        }
        Stage stage = new Stage();
        draw();
        pane = FXMLLoader.load(getClass().getResource("/view/Menu.fxml"));
        stage.setTitle("Rent-A-Thing");
        stage.setScene(new Scene(pane));
        stage.setOnCloseRequest(new EvHClose(this, m));
        stage.show();
    }

    public void draw() throws IOException {
        this.pane.getChildren ().clear ();
        this.pane.getChildren().add(FXMLLoader.load(getClass().getResource("/view/Overzicht.fxml")));
    }

    @Override
    public void update(Observable o, Object arg) {
        try {
            draw();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
