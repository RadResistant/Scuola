package file;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class FileRW extends Application {
	TextField tfIO=new TextField();
	Button bLeggi=new Button("Leggi");
	Button bScrivi=new Button("Scrivi");
	public void start(Stage primaryStage) throws Exception {
		bLeggi.setMaxWidth(500);
		bScrivi.setMaxWidth(500);
		tfIO.setPromptText("Posizione");
		GridPane gP=new GridPane();
		gP.add(tfIO, 0, 1);
		gP.add(bLeggi, 0, 0);
		gP.add(bScrivi, 0, 2);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("R/W riga");
		primaryStage.setScene(scena);
		primaryStage.show();
		bLeggi.setOnAction(e -> eseguiL());
		tfIO.setOnAction(e-> eseguiS());
		bScrivi.setOnAction(e -> eseguiS());
	}
	private void eseguiL() {
		try {
			
		}
		catch (Exception e) {
			System.out.println("ERRORE "+ e.getLocalizedMessage());
		}
	}
	private void eseguiS() {
		try {
			
		}
		catch (Exception e) {
			System.out.println("ERRORE "+ e.getLocalizedMessage());
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}