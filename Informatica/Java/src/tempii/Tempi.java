package tempii;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Tempi extends Application {
		TextField tNumero = new TextField();
		TextField tTempo = new TextField();
		TextField tCoach = new TextField();
		TextField tRisultati = new TextField();
		int tempi[];
		int pos;
	   public void start(Stage primaryStage) {
		   GridPane principale = new GridPane();
		   principale.add(tNumero,0,0);
		   principale.add(tTempo,1,0);
		   principale.add(tCoach,0,1);
		   principale.add(tRisultati,1,1);
		   Scene scena = new Scene(principale,300,150);
		   primaryStage.setTitle("Tempi");
		   primaryStage.setScene(scena);
		   primaryStage.show();
		   principale.setAlignment(Pos.CENTER);
		   principale.setPadding(new Insets(10,10,10,10));
		   principale.setHgap(10); 
		   principale.setVgap(10);
		   tNumero.setOnAction(e-> alloca());
		   tTempo.setOnAction(e-> inserisciTempo());
		   tCoach.setOnAction(e-> contaPessimi());
		   tNumero.setPromptText("numero");
		   tTempo.setPromptText("tempo");
		   tCoach.setPromptText("coach");
	   }
	   public void alloca() {
		      tempi = new int[Integer.parseInt(tNumero.getText())];
		   }
	   public void inserisciTempo() {
	      if(pos < tempi.length) {
	         tempi[pos++]=Integer.parseInt(tTempo.getText());
	         tTempo.setText("");
	      }
	   }
	   public void contaPessimi() {
	      int contatore = 0;
	      int coach = Integer.parseInt(tCoach.getText());
	      for(int indice = 0; indice < tempi.length; indice++) {
	         if(tempi[indice] > coach) {
	            contatore++;
	         }
	      }
	      tRisultati.setText("" + contatore);
	   }
	   public static void main(String[] args) {
        launch(args);
	   }
}