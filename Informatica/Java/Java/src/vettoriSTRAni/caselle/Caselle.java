package it.edu.iisgubbio.caselle;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Caselle extends Application{
	Button pCalcola = new Button(); 
	TextField caselle [] = new TextField [10];
	public void start(Stage finestra) {
		GridPane gP = new GridPane();
		for (int i=0 ; i<caselle.length ; i=i+1) {
		caselle[i] = new TextField();
		gP.add(caselle[i],0,i);
	}
		pCalcola.setText("SCORRI");
		pCalcola.setOnAction(e -> calcola());
		gP.add(pCalcola,0,caselle.length);
		gP.setPadding(new Insets(10, 10, 10, 10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		finestra.setTitle("Caselle");
		finestra.setScene(scena);
		finestra.show();
	}
	public void calcola(){
		for(int x=0;x<caselle.length-1;x=x+1) {
			String testo=caselle[x+1].getText();
			caselle[x].setText(testo);
		}
		caselle[caselle.length-1].setText("");
	}
	public static void main(String[] args) {
	    launch(args);
	}
}