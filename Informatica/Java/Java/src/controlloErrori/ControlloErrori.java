package controlloErrori;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ControlloErrori extends Application{
	TextField tfInput=new TextField();
	Button bTest=new Button("Test");
	Label lRis=new Label();
	public void start(Stage primaryStage) throws Exception {
		tfInput.setPromptText("inserisci:forma geo,lato,area");
		GridPane gP=new GridPane();
		gP.add(tfInput, 0, 0);
		gP.add(bTest, 0, 1);
		gP.add(lRis, 0, 2);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Controllo Errori");
		primaryStage.setScene(scena);
		primaryStage.show();
		bTest.setOnAction(e -> esegui());
		tfInput.setOnAction(e-> esegui());
	}
	private void esegui() {
		String[] str=tfInput.getText().split(",");
		String forma;
		forma=str[0].toLowerCase();
		try {
			switch (forma) {
				case "quadrato": {
					double lato=Double.parseDouble(str[1]);
					double area=Double.parseDouble(str[2]);
					if(area==lato*lato) {
						lRis.setText("Ok");
					}
					else {
						lRis.setText("No");
					}
					break;
				}
				case "rettangolo":{
					double base=Double.parseDouble(str[1]);
					double altezza=Double.parseDouble(str[2]);
					double area=Double.parseDouble(str[3]);
					if(area==base*altezza) {
						lRis.setText("Ok");
					}
					else {
						lRis.setText("No");
					}
					break;
				}
				case "triangolo":{
					double base=Double.parseDouble(str[1]);
					double altezza=Double.parseDouble(str[2]);
					double area=Double.parseDouble(str[3]);
					if(area==(base*altezza)/2) {
						lRis.setText("Ok");
					}
					else {
						lRis.setText("No");
					}
					break;
				}
				case "cerchio":{
					double raggio=Double.parseDouble(str[1]);
					double area=Double.parseDouble(str[2]);
					double tolleranza=(5*area)/100;
					if((raggio*raggio)*Math.PI>area-tolleranza && (raggio*raggio)*Math.PI<area+tolleranza) {
						lRis.setText("Ok "+"Area esatta "+(raggio*raggio)*Math.PI);
					}
					else {
						lRis.setText("No");
					}
					break;
				}
				default:{
					lRis.setText("Forma sbagliata");
				}
			}
		}
		catch (ArrayIndexOutOfBoundsException e) {
			lRis.setText("Numero di dati sbagliato");
		}
		catch (NumberFormatException e) {
			lRis.setText("Solo numeri");
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
