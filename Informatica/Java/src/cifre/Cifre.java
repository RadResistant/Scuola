package cifre;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Cifre  extends Application{
	TextField tInput=new TextField();
	Label lOutput= new Label();
	Button pConverti=new Button(" Converti ");
	public void start(Stage primaryStage){
		GridPane gP = new GridPane();
		gP.add(tInput, 0, 0);
		gP.add(lOutput, 0, 2);
		gP.add(pConverti,0 ,1);
		gP.setPadding(new Insets(10,10,10,10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Converti");
		primaryStage.setScene(scena);
		primaryStage.show();
		pConverti.setOnAction(e -> converti());
	}
	private void converti() {
		char frase[] = tInput.getText().trim().toCharArray();
		String risposta = "";
		if(frase.length==1){
			
			switch (frase[0]) {
			case '1':
			if (frase[1]=='1') {
				
			}
			
					risposta += "Uno";
					break;
			case '2':
				risposta += "Due";
				break;
			case '3':
				risposta += "Tre";
				break;
			case '4':
				risposta += "Quattro";
				break;
			case '5':
				risposta += "Cinque";
				break;
			case '6':
				risposta += "Sei";
				break;
			case '7':
				risposta += "Sette";
				break;
			case '8':
				risposta += "Otto";
				break;
			case '9':
				risposta += "Nove";
				break;
			}
		}
		if(frase.length==2) {
				switch (frase[0]) {
				case '1':
						if (frase[1]=='1') {
							risposta+="Undici";
							break;
						}
						else {
							
							risposta += "Dieci";
							break;
							}
							case '2':
								risposta += "Venti";
								break;
							case '3':
								risposta += "Trenta";
								break;
							case '4':
								risposta += "Quaranta";
								break;
							case '5':
								risposta += "Cinquanta";
								break;
							case '6':
								risposta += "Sessanta";
								break;
							case '7':
								risposta += "Settanta";
								break;
							case '8':
								risposta += "Ottanta";
								break;
							case '9':
								risposta += "Novanta";
								break;
						}
						switch (frase[1]) {
							case '1':
								risposta += "Uno";
								break;
							case '2':
								risposta += "Due";
								break;
							case '3':
								risposta += "Tre";
								break;
							case '4':
								risposta += "Quattro";
								break;
							case '5':
								risposta += "Cinque";
								break;
							case '6':
								risposta += "Sei";
								break;
							case '7':
								risposta += "Sette";
								break;
							case '8':
								risposta += "Otto";
								break;
							case '9':
								risposta += "Nove";
								break;
						}
					}
		if(frase.length==3) { 
			switch (frase[0]) {
				case '1':
					risposta += "Cento";
					break;
				case '2':
					risposta += "Duecento";
					break;
				case '3':
					risposta += "Trecento";
					break;
				case '4':
					risposta += "Quattrocento";
					break;
				case '5':
					risposta += "Cinquecento";
					break;
				case '6':
					risposta += "Seicento";
					break;
				case '7':
					risposta += "Settecento";
					break;
				case '8':
					risposta += "Ottocento";
					break;
				case '9':
					risposta += "Novecento";
					break;

			}
			switch (frase[1]) {
				case '1':
					risposta += "Dieci";
					break;
				case '2':
					risposta += "Venti";
					break;
				case '3':
					risposta += "Trenta";
					break;
				case '4':
					risposta += "Quaranta";
					break;
				case '5':
					risposta += "Cinquanta";
					break;
				case '6':
					risposta += "Sessanta";
					break;
				case '7':
					risposta += "Settanta";
					break;
				case '8':
					risposta += "Ottanta";
					break;
				case '9':
					risposta += "Novanta";
					break;
			}
			switch (frase[2]) {
				case '1':
					risposta += "Uno";
					break;
				case '2':
					risposta += "Due";
					break;
				case '3':
					risposta += "Tre";
					break;
				case '4':
					risposta += "Quattro";
					break;
				case '5':
					risposta += "Cinque";
					break;
				case '6':
					risposta += "Sei";
					break;
				case '7':
					risposta += "Sette";
					break;
				case '8':
					risposta += "Otto";
					break;
				case '9':
					risposta += "Nove";
					break;
			}
		}
		lOutput.setText(risposta);
	}
public static void main(String[] args) {
	launch(args);
}
}
