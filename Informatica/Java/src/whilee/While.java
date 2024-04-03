package whilee;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class While extends Application{
	TextField tfNumero=new TextField();
	TextField tfCerca=new TextField();
	Label lRisultato=new Label();
	public void start(Stage finestra) throws Exception {
		GridPane gP=new GridPane();
		gP.add(tfNumero, 0, 0);
		gP.add(tfCerca, 0, 1);
		gP.add(lRisultato, 0, 2);
		gP.setPadding(new Insets(10,10,10,10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		finestra.setTitle("While");
		finestra.setScene(scena);
		finestra.show();
		tfCerca.setOnAction(e-> eCerca());
	}
	private void eCerca() {
		String pezzi[]=tfNumero.getText().split(" ");
		int numeri[]= new int[pezzi.length];
		int inf =0,sup=numeri.length-1,meta;
		int numCerc=Integer.parseInt(tfCerca.getText());
		boolean trovato=false;
		for(int i=0; i<pezzi.length;i++) {
			numeri[i]=Integer.parseInt(pezzi[i]);
		}
		while(inf<=sup && !trovato){
			meta=(inf + sup)/2;
			if(numCerc==numeri[meta]) {
				trovato=true;
			}
			else {
				if(numCerc<numeri[meta]) {
					sup=meta-1;
				}
				else{
					inf=meta+1;
				}
			}
		}
		if(trovato) {
			lRisultato.setText("Trovato");
		}
		else {
			lRisultato.setText("Non Trovato");
		}
	} 
	public static void main(String[] args) {
	    launch(args);
	}
}
