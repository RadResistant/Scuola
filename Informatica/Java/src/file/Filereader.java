package file;
import java.io.FileReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Filereader extends Application{
	TextField tfInput=new TextField();
	Button bLeggi=new Button("Leggi");
	Label lRis=new Label();
	public void start(Stage primaryStage) throws Exception {
		tfInput.setPromptText("Posizione");
		GridPane gP=new GridPane();
		gP.add(tfInput, 0, 0);
		gP.add(bLeggi, 0, 1);
		gP.add(lRis, 0, 2);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Posizione");
		primaryStage.setScene(scena);
		primaryStage.show();
		bLeggi.setOnAction(e -> esegui());
		tfInput.setOnAction(e-> esegui());
	}
	private void esegui() {
		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/desktop/Informazioni.txt");
			char caratteri[] = new char[1000];
			int posto=Integer.parseInt(tfInput.getText());
			flussoCaratteri.read(caratteri);
			lRis.setText(""+caratteri[posto]);
			flussoCaratteri.close();
		}
		catch (Exception e) {
			lRis.setText("ERRORE "+ e.getLocalizedMessage());
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
