package trovanumero;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class TrovaNumero extends Application {
	TextField tfInput=new TextField();
	Label lOutput=new Label();
	public void start(Stage primaryStage) throws Exception {
		tfInput.setPromptText("Numero");
		GridPane gP=new GridPane();
		gP.add(tfInput, 0, 0);
		gP.add(lOutput, 0, 1);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Trova Numeri");
		primaryStage.setScene(scena);
		primaryStage.show();
		tfInput.setOnAction(e -> etrovaNumero());
	}
	private void etrovaNumero() {
		try(FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/Numeri.txt");
				BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);){
			String testo="",numero=tfInput.getText();
			int c=0,tot=0;
			do {
				testo=lettoreDiRighe.readLine();
				if(numero.equals(testo)) {
					c++;
				}
				tot++;
			}while(testo!=null);
			lettoreDiRighe.close();
			flussoCaratteri.close();
			if(c>0) {
				lOutput.setText("Il numero "+numero+" è presente "+c+" volte su "+tot);
			}
			else {
				lOutput.setText("Il numero non è presente");
			}
		}
		catch(Exception e) {
			System.out.println("ERRORE "+ e.getLocalizedMessage());
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}