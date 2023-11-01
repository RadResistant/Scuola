package bisestile;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Bisestile  extends Application {
		Label lRisultato = new Label();
		Label lAnno = new Label("Anno:");
		TextField tfAnno = new TextField();
		Button bProva = new Button("Bisestile?");
	public void start(Stage finestra) throws Exception {
			bProva.setOnAction(e -> eseguiBis());		
			GridPane principale = new GridPane();
			principale.setId("pane");
			principale.add(lAnno, 0,0);
			principale.add(lRisultato, 0,1,3,1);
			principale.add(tfAnno, 1,0);
			principale.add(bProva, 2,0,1,2);
			Scene scena = new Scene(principale);
			principale.setId("pane");
			principale.setPadding(new Insets(10, 10, 10, 10));
			principale.setHgap(10); 
			principale.setVgap(10);
			principale.setAlignment(Pos.CENTER);
		    finestra.setTitle("Bisestile");
		    finestra.setScene(scena);
		    finestra.show();
			scena.getStylesheets().add("bisestile/Bisestile.css");
		}
		private void eseguiBis(){
			int anno;
			anno=Integer.parseInt(tfAnno.getText());
			if(anno%4==0 && anno%100!=0 || anno%400==0) { 
				lRisultato.setText("è bisestile");
			}
			else {
				lRisultato.setText("Non è bisestile");
			}	
		}
		public static void main(String[] args) {
		    launch(args);
	}
}