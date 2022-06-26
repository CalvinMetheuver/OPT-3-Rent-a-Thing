package code;

import Controller.MenuController;
import Controller.OverzichtController;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

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
        m.setActief(false);
    }
}

public class Status extends Stage implements Observer {
    private Store s = Store.getInstance();
    AnchorPane pane = new AnchorPane();
    Medewerker m;

    public Status(Medewerker m) throws IOException {
        this.m = m;
        Stage stage = new Stage();
        draw();

        for (Product p: s.producten){
            p.addObserver(this);
        }
        s.actief.add(this);

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Menu.fxml"));

        pane=loader.load();

        MenuController mc = loader.getController();
        mc.setStatus(this, m);

        stage.setTitle("Rent-A-Thing");
        stage.setScene(new Scene(pane));

        stage.setOnCloseRequest(new EvHClose(this, m));
        stage.show();

    }

    public void draw() throws IOException {
        this.pane.getChildren ().clear ();
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/view/Overzicht.fxml"));

        AnchorPane p = loader.load();

        OverzichtController dc = loader.getController();
        dc.setStatus(this, m);

        this.pane.getChildren().setAll(p);
    }

    public void addOb(Product p) throws IOException {
        for(Status x: s.actief) {
            p.addObserver(x);
        }
    }

    public void close(){
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
