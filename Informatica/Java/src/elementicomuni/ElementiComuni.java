package elementicomuni;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ElementiComuni extends Application{
		Button bFiltra=new Button("Filtra");
		Label lOutput=new Label();
	public void start(Stage primaryStage) throws Exception {
		GridPane gP=new GridPane();
		gP.add(lOutput, 0, 1);
		gP.add(bFiltra, 0, 0);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Filtra Numeri");
		primaryStage.setScene(scena);
		primaryStage.show();
		bFiltra.setOnAction(e -> eFiltra());
	}
	private void eFiltra() {
		try(FileReader frFile1 = new FileReader("/Users/classe4I/desktop/FileInformatica/Numeri.txt");
			FileReader frFile2 = new FileReader("/Users/classe4I/desktop/FileInformatica/Numeri.txt");
			BufferedReader brFile1 = new BufferedReader(frFile1);
			BufferedReader brFile2 = new BufferedReader(frFile2);){
				String str1="",str2="",ris="";
				do {
					str1=brFile1.readLine();
					str2=brFile2.readLine();
					if(str1!=null) {
						if(str1.equals(str2)) {
							ris+=str1;
						}
					}
				}while(str1!=null);
				lOutput.setText(ris);
		}
		catch(Exception e) {
			e.printStackTrace();
			System.out.println("ERRORE "+ e.getLocalizedMessage());
		}
	}
	public static void main(String[] args) {
		launch(args);
	}	
}
