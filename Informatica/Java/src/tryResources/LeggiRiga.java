package tryResources;
import java.io.BufferedReader;
import java.io.FileReader;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class LeggiRiga extends Application{
	Label test = new Label(""); 
	TextField input=new TextField("");
	Button leggi=new Button("Leggi");
	public void start(Stage finestra) {
		leggi.setOnAction(e-> leggi());
		GridPane principale = new GridPane();
		principale.add(leggi, 0, 1);
		principale.add(test,0,2);
		principale.add(input,0,0);
		leggi.setMaxWidth(500);
		principale.setPadding(new Insets(6, 6, 6, 6));
		principale.setHgap(5); 
		principale.setVgap(5);
		Scene scena = new Scene(principale);
		finestra.setTitle("Area");
		finestra.setScene(scena);
		finestra.show();
	}
	private void leggi() {
		try (FileReader flussoCaratteri = new FileReader("/Users/classe4I/Desktop/tanteRighe.txt");
			BufferedReader lettoreDiRighe = new BufferedReader(flussoCaratteri);)
			{
			String testo="";
			int stop=Integer.parseInt(input.getText());
			for(int i=1;i<=stop;i++) {
				testo=lettoreDiRighe.readLine();
				if(testo!=null ) {
					test.setText(testo);
				}else {
					test.setText("Non esitente");
				}
			}
		} catch(Exception  e) {
			test.setText(e.getLocalizedMessage());
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}

