package it.edu.iisgubbio;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
public class InsovinaS extends Application {
	Label lPunti=new Label("Punti:");
	Label lNPunti=new Label();
	Label lPiu=new Label("+");
	Label lUguale=new Label("=");
	TextField tfN1=new TextField();
	TextField tfN2=new TextField();
	TextField tfSomma=new TextField();
	Timeline timer = new Timeline();
	int n1,n2,pPL=50;
	public void start(Stage finestra) throws Exception {
		n1=(int)(Math.random()*90)+10;
		n2=(int)(Math.random()*90)+10;
		tfN1=new TextField(""+n1);
		tfN2=new TextField(""+n2);
		GridPane principale = new GridPane();
		principale.add(tfN1, 0, 0);
	    principale.add(lPiu, 1, 0);
	    principale.add(tfN2, 2, 0);
	    principale.add(lUguale, 3, 0);
	    principale.add(tfSomma, 4, 0);
	    principale.add(lPunti, 0, 1);
	    principale.add(lNPunti, 1, 1,3,1);
	    Scene scena = new Scene(principale,550,100);
	    finestra.setTitle("Somma");
	    finestra.setScene(scena);
	    finestra.show();
	    principale.setAlignment(Pos.CENTER);
	    principale.setPadding(new Insets(10,10,10,10));
	    principale.setHgap(10); 
	    principale.setVgap(10);
	    KeyFrame kN = new KeyFrame(Duration.seconds(1),e->ePunti());
		timer = new Timeline(kN);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
		tfN1.setDisable(true);
		tfN2.setDisable(true);
		tfSomma.setOnAction(e->eSomma());
	}
	private void ePunti() {
		pPL-=1;
		if(pPL==0) {
			timer.stop();
			lPunti.setText("Troppo tardi");
			tfSomma.setDisable(true);
		}
	}
	private void eSomma(){
		int ris;
		ris=Integer.parseInt(tfSomma.getText());
		if(ris==n1+n2) {
			lNPunti.setText("Giusto +"+pPL+" punti");
		}
	  }
	public static void main(String[] args) {
	    launch(args);
	}
}
