package verifica;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class SaponaroRaffaele extends Application {
	TextField tfInput=new TextField();
	Button bMaterie=new Button("Cerca Materie");
	Button bProfessori=new Button("Cerca Prof");
	Label lOutput=new Label();
	ListView<String> lLista = new ListView<>();
	GridPane gP=new GridPane();
	public void start(Stage primaryStage) throws Exception {
		tfInput.setPromptText("Inserire materie o nomi");
		tfInput.setPrefWidth(300);
		bMaterie.setPrefWidth(150);
		bProfessori.setPrefWidth(150);
		lOutput.setPrefWidth(300);
		gP.add(tfInput, 0, 0,2,1);
		gP.add(bMaterie, 0,1);
		gP.add(bProfessori, 1,1);
		gP.add(lOutput, 0, 2,2,1);
		gP.add(lLista, 0, 3,2,1);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Cerca orario");
		primaryStage.setScene(scena);
		primaryStage.show();
		bMaterie.setOnAction(e-> eMaterie());
		bProfessori.setOnAction(e-> eProfessori());
	}
	private void eMaterie() {
		String materia=tfInput.getText(),rigaletta="";
		int c=0;
		String[] riga;
		try(FileInputStream fisFileOpener = new FileInputStream("/Users/classe4I/Desktop/FileInformatica/elencoAttivita.csv");
			InputStreamReader isrFileReader = new InputStreamReader(fisFileOpener,"UTF-8");
			BufferedReader brLineReader = new BufferedReader(isrFileReader);){
			do{
				rigaletta=brLineReader.readLine();
				materia.toUpperCase();
				riga=rigaletta.split(",");
				if(rigaletta!=null) {
					if(riga[1].equals(("\"")+materia+("\""))) {
						c++;
					}
				}
			}while(rigaletta!=null);
		}
		catch(Exception e){
			lOutput.setText("ERRORE"+ e.getLocalizedMessage());
		}
		lOutput.setText("La materia è presente "+c+" volte");
	}
	private void eProfessori() {
		String prof=tfInput.getText(),rigaletta="";
		String[] riga;
		try(FileInputStream fisFileOpener = new FileInputStream("/Users/classe4I/Desktop/FileInformatica/elencoAttivita.csv");
			InputStreamReader isrFileReader = new InputStreamReader(fisFileOpener,"UTF-8");
			BufferedReader brLineReader = new BufferedReader(isrFileReader);){
				do{
					rigaletta=brLineReader.readLine();
					riga=rigaletta.split(",");
					if(rigaletta!=null) {
						if(riga[2].equals(("\"")+prof+("\""))) {
							lLista.getItems().add(riga[0]);
						}
					}
				}while(rigaletta!=null);
			}
			catch(Exception e){
				lOutput.setText("ERRORE"+ e.getLocalizedMessage());
			}
	}
	public static void main(String[] args) {
		launch(args);
	}
}