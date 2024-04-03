package ricercheVettori;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class RicercheVettore extends Application {
	Label lRisultati=new Label();
	Label lValore=new Label("Valore");
	TextField tfInput=new TextField();
	TextField tfValore=new TextField();
	Button bMassimo=new Button("Massimo");
	Button bMinimo=new Button("Minimo");
	Button bEsiste=new Button("Esiste");
	Button bPosizione=new Button("Posizione");
	int max=0,min=Integer.MAX_VALUE;
	public void start(Stage finestra) throws Exception {
		GridPane gP=new GridPane();
		gP.add(lRisultati, 0, 3,4,1);
		gP.add(tfInput, 0, 0,4,1);
		gP.add(lValore, 0, 1,2,1);
		gP.add(tfValore, 2, 1,2,1);
		gP.add(bEsiste, 2, 2);
		gP.add(bMassimo, 0, 2);
		gP.add(bMinimo, 1, 2);
		gP.add(bPosizione, 3, 2);
	    gP.setPadding(new Insets(10, 10, 10, 10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena=new Scene(gP);
		finestra.setTitle("Area di gioco");
	    finestra.setScene(scena);
	    finestra.show();
	    bMassimo.setOnAction(e-> eMassimo());
	    bMinimo.setOnAction(e-> eMinimo());
	    bEsiste.setOnAction(e-> eEsiste());
	    bPosizione.setOnAction(e-> ePosizione());
	}
	private void eMassimo(){
		for(int i=0;;i++) {
			
		}
	}
	private void eMinimo(){
	}
	private void eEsiste(){
	}
	private void ePosizione(){
	}
	public static void main(String[] args) {
	    launch(args);
	}
}

