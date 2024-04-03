package mastermind;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class MasterMind extends Application{
	Button bProva=new Button("Prova");
	Button bParola=new Button("Crea parola");
	TextField tfInput=new TextField();
	ListView<String> lwLista = new ListView<>();
	Label lCancella=new Label();
	String parolaIndovina="";
	String risp="";
	public void start(Stage primaryStage){
		GridPane gP = new GridPane();
		gP.add(tfInput, 0, 0);
		gP.add(bProva, 1, 0);
		gP.add(bParola, 1, 1);
		gP.add(lwLista, 0, 1);
		gP.add(lCancella, 3, 0);
		gP.setHgap(10);
		gP.setVgap(10);
		gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Mastermind");
		primaryStage.setScene(scena);
		primaryStage.show();
		bParola.setOnAction(e -> creaParola());	
		bProva.setOnAction(e -> prova());	
	}
	private void creaParola(){
		parolaIndovina="";
		int numeroCasuale=0;
		for(int i=0;i<4;i++) {
			numeroCasuale=(int)(Math.random()*4);
			if(numeroCasuale==0) {
				parolaIndovina+="A";
			}
			if(numeroCasuale==1) {
				parolaIndovina+="B";		
			}
			if(numeroCasuale==2) {
				parolaIndovina+="C";
			}
			if(numeroCasuale==3) {
				parolaIndovina+="D";
			}
		}
		System.out.println(parolaIndovina);
	}
	private void prova() {
		String parolaProva=tfInput.getText();
		risp="";
		int contaX=0;
		char parola[]=parolaProva.trim().toUpperCase().toCharArray();
		char indovina[]=parolaIndovina.trim().toUpperCase().toCharArray();
		for(int i=0; i<indovina.length;i++) {
			if (indovina[i]==parola[i]) {
				risp+="x";
				contaX+=1;
				indovina[i]='S';
				parola[i]='R';
			}
			for(int j=0; j<parola.length;j++) {
				if(indovina[i]==parola[j] && i!=j) {
					risp+="o";
				}
			}
		}
		String risultato="";
		if (contaX==4) {
			risultato=parolaProva+" Vinto";
		}
		else {
			risultato=parolaProva+" "+risp;
		}
		lwLista.getItems().add(risultato);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
