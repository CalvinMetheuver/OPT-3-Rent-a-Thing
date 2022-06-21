package code;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

import java.util.Observable;
import java.util.Observer;

class EventHandlerToggle implements EventHandler<ActionEvent> {

	private Product product;
	private Status status;

	public EventHandlerToggle (Product p, Status status) {
		this.product = p;
		this.status = status;
	}

	@Override
	public void handle (ActionEvent actionEvent) {
		//this.product.setOpVerhuurd(!this.product.verhuurd());
		this.status.draw ();
	}
}

class EventHandlerClose implements EventHandler<WindowEvent> {

	private Store store;
	private Status status;

	public EventHandlerClose (Store store, Status status) {
		this.store = store;
		this.status = status;
	}

	@Override
	public void handle (WindowEvent windowEvent) {

		for (Product p : store.getProducten()) {
			p.deleteObserver (this.status);
		}
	}
}

public class Status extends Stage implements Observer
{
	private Store store;
	private Pane rootPane;

	public Status (Store store) {

		this.store = store;

		for (Product p : store.getProducten()) {
			p.addObserver (this);
		}

		rootPane = new Pane ();
		setTitle ("Status");
		rootPane.setMinSize (200, 200);
		draw ();
		Scene scene = new Scene (rootPane);
		setScene (scene);
		setOnCloseRequest (new EventHandlerClose (store, this));
		show ();
	}

	public void draw () {

		this.rootPane.getChildren ().clear ();
		VBox vBox = new VBox ();
		this.rootPane.getChildren ().add (vBox);

		for (Product product : store.getProducten())
		{
			HBox hBox = new HBox ();
			vBox.getChildren ().add (hBox);
			hBox.getChildren ().add (new Label ("Lane " + product.getNaam () + "\t"));
			hBox.getChildren ().add (new Label (product.verhuurd() ? "occupied\t" : "free\t"));
			Button button = new Button ("Toggle");
			button.setOnAction (new EventHandlerToggle (product, this));
			hBox.getChildren ().add (button);
		}
	}

	@Override
	public void update (Observable o, Object arg) {
		draw ();
	}


}