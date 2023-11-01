package cercanome;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class CercaNome extends Application{
	TextField tfNome=new TextField();
	Button bCerca=new Button("Cerca");
	Label lOutput=new Label();
	ArrayList<String> nomi=new ArrayList<String>();
	String rigaletta;
	public void start(Stage primaryStage) throws Exception {
		tfNome.setPromptText("Inserisci nome");
		GridPane gP=new GridPane();
		gP.add(tfNome, 0, 0);
		gP.add(bCerca, 0, 1);
		gP.add(lOutput, 0, 3);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Cerca Nomi");
		primaryStage.setScene(scena);
		primaryStage.show();
		bCerca.setOnAction(e -> eCerca());
		tfNome.setOnAction(e -> eCerca());
		try {
			FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/FileInformatica/nomi.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			do{
				rigaletta=lettoreDiRighe.readLine();
				if(rigaletta!=null) {
					nomi.add(rigaletta);
				}
			}while(rigaletta!=null);
			lettoreDiRighe.close();
			flussoCaratteri.close();
			System.out.println(nomi);
		} 
		catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}
	private void eCerca() {
		boolean presente=false;
		int c=0;
		do{
			if(tfNome.getText().equals(nomi.get(c))) {
				presente=true;
				c++;
			}
		}while(nomi!=null);
		if(presente) {
			lOutput.setText("C'E");
		}
		else {
			lOutput.setText("NC'E");	
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}