package simboli;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Simboli extends Application {
	Label lSimbolo=new Label("Simbolo:");
	Label lContatore=new Label("Contatore:");
	Label lMilli=new Label("Millisecondi");
	Label lPrint=new Label();
	TextField tfSimbolo=new TextField();
	TextField tfContatore=new TextField();
	TextField tfMilli=new TextField();
	Button bVia=new Button ("Via");
	Timeline timer = new Timeline();
	int iTempo,iMax;
	String sSim,sElencoS="";
	public void start(Stage finestra) throws Exception {
		bVia.setOnAction(e->eSimboli());
		GridPane principale = new GridPane();
	    principale.add(lSimbolo,0,0);
	    principale.add(lContatore,0,1);
	    principale.add(lMilli,0,2);
	    principale.add(lPrint,0,3,3,1);
		principale.add(tfSimbolo,1,0);
	    principale.add(tfContatore,1,1);
	    principale.add(tfMilli,1,2);
	    principale.add(bVia,2,0,1,3);
	    Scene scena = new Scene(principale,300,150);
	    finestra.setTitle("Simboli");
	    finestra.setScene(scena);
	    finestra.show();
	    bVia.setMaxSize(500,500);
	    lPrint.setMaxSize(500,500);
	    principale.setAlignment(Pos.CENTER);
	    principale.setPadding(new Insets(10,10,10,10));
	    principale.setHgap(10); 
	    principale.setVgap(10);
	}
	private void eSimboli() {
		iTempo=Integer.parseInt(tfMilli.getText());
		iMax=Integer.parseInt(tfContatore.getText());
		KeyFrame kN = new KeyFrame(Duration.millis(iTempo),e-> eTimer());
		timer = new Timeline(kN);
		timer.setCycleCount(iMax);
		timer.play();
	}
	private void eTimer() {
		sSim=tfSimbolo.getText();
		sElencoS+=sSim;
		lPrint.setText(sElencoS);
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
