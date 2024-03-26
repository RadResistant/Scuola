package colori;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class Colori extends Application{
	Button bPavimento=new Button ("Pavimento");
    Button bPareti=new Button ("Pareti");
    Button bCosto=new Button ("Costo");   
    Label lLarghezza=new Label("Larghezza");
    Label lProfondità=new Label("Profondità");
    Label lAltezza=new Label("Altezza");
    TextField tLarghezza=new TextField();
    TextField tProfondità=new TextField();
    TextField tAltezza=new TextField();	
	@Override
	public void start(Stage primaryStage) throws Exception {
	    GridPane griglia=new GridPane();
	    griglia.add(bPavimento, 0, 0);
		griglia.add(lLarghezza, 0, 1);
		griglia.add(tLarghezza, 0, 2);
		griglia.add(bPareti, 1, 0);
		griglia.add(lProfondità, 1, 1);
		griglia.add(tProfondità, 1, 2);
		griglia.add(bCosto, 2, 0);
		griglia.add(lAltezza, 2, 1);
		griglia.add(tAltezza, 2, 2);
		Scene scene = new Scene(griglia);
		scene.getStylesheets().add("nomeCartella/nomeFile.css");
		primaryStage.setScene(scene);
	    primaryStage.setTitle("Colori");
	    primaryStage.show();
	}
	
	public static void main(String[] args) {
	    launch(args);
	}
}
