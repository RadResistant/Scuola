package vettoriSTRAni;
// import java.util.Iterator;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class VettoriStrani extends Application {
	Label lTempi=new Label("Tempi");
	Label lLimite=new Label("Limite");
	Label lTempiRis=new Label("Superiori");
	Label lTempiRisScrivi=new Label();
	TextField tfTempi=new TextField();
	TextField tfLimite=new TextField();
	Button bCalcola=new Button("Calcola");
	public void start(Stage finestra) throws Exception {
		GridPane gP=new GridPane();
		gP.add(lTempi, 0, 0);
		gP.add(lLimite, 0, 1);
		gP.add(lTempiRis, 0, 2);
		gP.add(tfTempi, 1, 0,2,1);
		gP.add(tfLimite, 1, 1);
		gP.add(lTempiRisScrivi,1,2,2,1);
		gP.add(bCalcola, 2, 1);
	    gP.setPadding(new Insets(10, 10, 10, 10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena=new Scene(gP);
		finestra.setTitle("Area di gioco");
	    finestra.setScene(scena);
	    finestra.show();
	    bCalcola.setOnAction(e-> eCalcola());
	}
	private void eCalcola() {
		String elencoTempi=tfTempi.getText();
		int limite=Integer.parseInt(tfLimite.getText());
		String testiTempi[]=elencoTempi.split(" ");
		int tempi[]=new int[testiTempi.length];
		int contatore=0;
		for (int y=0; y<testiTempi.length;y++) {
			tempi[y]=Integer.parseInt(testiTempi[y]);
		}
		
		for(int indice = 0; indice < tempi.length; indice++) {
	         if(tempi[indice]>limite) {
	            contatore++;
         	 }
    	}
		lTempiRisScrivi.setText(""+contatore);
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
