package sferaebbasta;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Sfera_ebbasta extends Application {
	Label lRaggio = new Label();
	Label lRisultato = new Label();
	Button bVolume = new Button();
	Button bSuperficie = new Button();
	Button bDiametro = new Button();
	TextField tfRaggio = new TextField();
	TextField tfRisultato = new TextField();

	@Override
	public void start(Stage finestra) throws Exception {
		lRaggio.setText("Raggio: ");
		bVolume.setText("Vol");
		bSuperficie.setText("Sup");
		bDiametro.setText("Dia");
		bVolume.setPrefWidth(60);
		bSuperficie.setPrefWidth(60);
		bDiametro.setPrefWidth(60);
		bVolume.setOnAction(e -> eseguiVol());
		bSuperficie.setOnAction(e -> eseguiSup());
		bDiametro.setOnAction(e -> eseguiDia());
		
		
		
		GridPane principale = new GridPane();
	    principale.add(bVolume, 1, 1);
	    principale.add(bSuperficie, 2, 1);
	    principale.add(bDiametro, 3, 1);
	    principale.add(lRaggio, 0, 0);
	    principale.add(lRisultato, 0, 2);
	    principale.add(tfRaggio, 1, 0,3,1);
	    principale.add(tfRisultato, 1, 2,3,1);
	    Scene scena = new Scene(principale);
	    
	    finestra.setTitle("Sfera Ebbasta");
	    finestra.setScene(scena);
	    finestra.show();
		
	}
	
	private void eseguiVol(){
		double numero1;
		double risultato;
		String text1;
		lRisultato.setText("Volume:");
		text1=tfRaggio.getText();
		numero1=Double.parseDouble(text1);
		risultato= (4.0/3.0)*3.14*(numero1*numero1*numero1);
		tfRisultato.setText(""+risultato);
	  }
	
	private void eseguiSup(){
		double numero1;
		double risultato;
		String text1;
		lRisultato.setText("Superficie:");
		text1=tfRaggio.getText();
		numero1=Double.parseDouble(text1);
		risultato= (numero1*numero1)*3.14;
		numero1=Double.parseDouble(text1);
		
		tfRisultato.setText(""+risultato);
	  }
	
	private void eseguiDia(){
		double numero1;
		double risultato;
		String text1;
		lRisultato.setText("Diametro:");
		text1=tfRaggio.getText();
		numero1=Double.parseDouble(text1);
		risultato= numero1*2;
		tfRisultato.setText(""+risultato);
	  }
	
	public static void main(String[] args) {
	    launch(args);
	}
}
