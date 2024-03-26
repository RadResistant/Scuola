package cilcoFor;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Ciclofor extends Application {
		Label lUno = new Label("Numero: ");
		Label lRis = new Label();
		TextField tfNum = new TextField();
		Button bPremimi = new Button("Premimi");	
	public void start(Stage finestra) throws Exception {
			bPremimi.setOnAction(e -> eseguiTabellina());
		    bPremimi.setMaxSize(500,500);
			GridPane principale = new GridPane();
			principale.add(lUno, 0,0);
			principale.add(lRis, 0,1,2,1);
			principale.add(tfNum, 1,0);
			principale.add(bPremimi, 2,0,1,2);
		    Scene scena = new Scene(principale);
		    scena.getStylesheets().add("cilcoFor/Ciclofor.css");
			principale.setAlignment(Pos.CENTER);    
		    finestra.setTitle("Ciclofor");
		    finestra.setScene(scena);
		    finestra.show();
			principale.getStyleClass().add("principale");
		}
		private void eseguiTabellina(){
			int numero ;
			String l="";
			numero=Integer.parseInt(tfNum.getText());
			for(int i=numero;i<=(numero*10);i+=numero) {
				l=l+" "+i;
			}
			lRis.setText(l+"");
		}
		public static void main(String[] args) {
	    launch(args);
		}	 
}