package cclick;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Countdown extends Application {
	Label lN = new Label ("???");
	int numero = 10;
	Timeline timer = new Timeline();
	public void start(Stage finestra) throws Exception {
		GridPane principale = new GridPane();
		principale.add(lN, 1,1);
		Scene scena = new Scene(principale,200,200);
		principale.setId("piero");
	    scena.getStylesheets().add("it/iisgubbio/timer/Timer.css");
		principale.setAlignment(Pos.CENTER);
		principale.setPadding(new Insets(10, 10, 10, 10));
		principale.setHgap(10); 
		principale.setVgap(10);
	    finestra.setTitle("Countdown");
	    finestra.setScene(scena);
	    finestra.show();
		KeyFrame kN = new KeyFrame(Duration.seconds(1), e-> indietro());
		timer = new Timeline(kN);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}
	private void indietro() {
    	lN.setText(""+numero);
		numero--;
    	if (numero==0) {
    		timer.stop();
    		lN.setText("Fine");
    	}
    }
	public static void main(String[] args) {
	    launch(args);
	}
}