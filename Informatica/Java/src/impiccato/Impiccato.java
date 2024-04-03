package impiccato;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Impiccato extends Application{
	TextField tfParola=new TextField();
	TextField tfLettera=new TextField();
	Button bInizia=new Button("Inizia");
	Button bLettera=new Button("Lettera");
	Label lOutput=new Label();
	String parola=new String();
	String lettera=new String();
	char mascherato[],frase[];
	public void start(Stage finestra) throws Exception {
			GridPane gP=new GridPane();
			gP.add(tfParola,0,0);
			gP.add(tfLettera,0,1);
			gP.add(bInizia,1,0);
			gP.add(bLettera,1,1);
			gP.add(lOutput,2,0,2,1);
			gP.setPadding(new Insets(10,10,10,10));
		    gP.setHgap(10); 
		    gP.setVgap(10);
		    gP.setAlignment(Pos.CENTER);
			Scene scena = new Scene(gP);
			finestra.setTitle("Lettere");
			finestra.setScene(scena);
			finestra.show();
			bInizia.setOnAction(e-> eInizia());
			bLettera.setOnAction(e-> eLettera());
			}
	private void eInizia() {
		char frase[]=tfParola.getText().toCharArray();
		char mascherato[]=tfParola.getText().toCharArray();
		String testo;
		for(int i=0;i<frase.length;i++) {
			if(i>0 && i<mascherato.length-1) {
				mascherato[i]='_';
			}
			System.out.print(mascherato[i]);
		}
		testo= new String(mascherato);
		tfParola.setText(testo);
	}
	private void eLettera() {
		lettera=tfLettera.getText();
		char risposta=lettera.charAt(0);
		String testo;
		for(int i=0;i<mascherato.length;i++) {			
			if(risposta==frase[i]) {
				mascherato[i]=risposta;
			}
			System.out.print(mascherato[i]);
		}
		testo= new String(mascherato);
		tfParola.setText(testo);
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
