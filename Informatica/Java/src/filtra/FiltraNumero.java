package filtra;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class FiltraNumero extends Application {
	TextField tfInputMin=new TextField();
	TextField tfInputMax=new TextField();
	Button bFiltra=new Button("Filtra");
	public void start(Stage primaryStage) throws Exception {
		tfInputMin.setPromptText("Minimo");
		tfInputMax.setPromptText("Massimo");
		GridPane gP=new GridPane();
		gP.add(tfInputMin, 0, 0);
		gP.add(tfInputMax, 0, 1);
		gP.add(bFiltra, 0, 2);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Filtra Numeri");
		primaryStage.setScene(scena);
		primaryStage.show();
		bFiltra.setOnAction(e -> eFiltraNumero());
	}
	private void eFiltraNumero() {
		try(FileReader flussoCaratteri = new FileReader("/Users/classe4I/desktop/FileInformatica/Numeri.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);
			FileWriter scriba=new FileWriter("/Users/classe4I/desktop/FileInformatica/Numeri2.txt")){
			String numero="";
			int num=0;
			int min=Integer.parseInt(tfInputMin.getText()),max=Integer.parseInt(tfInputMax.getText());
			do {
				numero=lettoreDiRighe.readLine();
				if(numero!=null) {
					num=Integer.parseInt(numero);
					if(num<max && num>min) {
						scriba.write(numero+"\n");
					}
				}
			}while(numero!=null);
			lettoreDiRighe.close();
			flussoCaratteri.close();
			scriba.close();
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
