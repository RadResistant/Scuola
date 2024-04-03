package doppie;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Doppie extends Application {
	Label lRisultato = new Label();
	Label lFrase = new Label("Frase");
	Label lDoppie = new Label("Doppie");
	TextField tfFrase = new TextField();
	Button bConta = new Button("Conta");
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
	    principale.add(lFrase, 0, 0);
	    principale.add(lDoppie, 0, 2);
	    principale.add(lRisultato, 1, 2);
	    principale.add(tfFrase, 1, 0);
	    principale.add(bConta, 1, 1);
	    Scene scena = new Scene(principale);
		principale.setPadding(new Insets(10, 10, 10, 10));
		principale.setHgap(10); 
		principale.setVgap(10);
	    finestra.setTitle("Conta");
	    finestra.setScene(scena);
	    finestra.show();
		bConta.setOnAction(e-> eConta());
	}
	private void eConta() {
		char frase[]=tfFrase.getText().trim().toLowerCase().toCharArray();
		int doppie=0;
		for(int i=0;i<frase.length-1;i++) {
			if(frase[i]==frase[i+1]) {
				doppie++;
			}
		}
		lRisultato.setText(doppie+"");
	}
	public static void main(String[] args) {
	    launch(args);
	}
}