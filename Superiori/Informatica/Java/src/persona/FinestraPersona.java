package persona;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class FinestraPersona extends Application{
	TextField tfNome=new TextField();
	TextField tfCognome=new TextField();
	TextField tfAnnoN=new TextField();
	TextField tfClasse=new TextField();
	TextField tfAnnoI=new TextField();
	Button bPersona=new Button("Persona");
	Button bStudente=new Button("Studente");
	ListView<String> lwLista = new ListView<>();
	public void start(Stage primaryStage) throws Exception {
		tfNome.setPromptText("Nome");
		tfCognome.setPromptText("Cognome");
		tfAnnoN.setPromptText("Anno di nascita");
		tfClasse.setPromptText("Classe");
		tfAnnoI.setPromptText("Anno di nascita");
		GridPane gP=new GridPane();
		gP.add(lwLista, 0, 0,1,6);
		gP.add(tfNome, 1, 0);
		gP.add(tfCognome, 1, 1);
		gP.add(tfAnnoN, 1, 2);
		gP.add(tfClasse, 1, 3);
		gP.add(tfAnnoI, 1, 4);
		gP.add(bPersona, 2, 2);
		gP.add(bStudente, 2, 4);
		gP.setPadding(new Insets(10,10,10,10));
		gP.setHgap(10);
		gP.setVgap(10);
		gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Codifica");
		primaryStage.setScene(scena);
		primaryStage.show();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
