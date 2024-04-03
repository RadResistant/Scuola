package canvaP;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Pallina extends Application {	
	Timeline timer = new Timeline();
	Canvas cSfondo = new Canvas(400, 400);
    GraphicsContext gcPallina = cSfondo.getGraphicsContext2D();
    double posizioneX=50;
	public void start(Stage finestra) throws Exception {
	    gcPallina.setLineWidth(1);
	    gcPallina.setFill(Color.RED);
	    gcPallina.fillOval(posizioneX, 50, 20, 20);
	    
		GridPane principale = new GridPane();
		principale.add(cSfondo, 0, 0);
		Scene scena = new Scene(principale,400,400);
//			principale.setPadding(new Insets(10, 10, 10, 10));
//			principale.setHgap(10); 
//			principale.setVgap(10);
	    
	    finestra.setTitle("Pallina");
	    finestra.setScene(scena);
	    finestra.show();
		
		KeyFrame kf = new KeyFrame(Duration.millis(0.1), e-> avanti());
		timer = new Timeline(kf);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
		
	}
		
	private void avanti(){
		gcPallina.setLineWidth(0);
		gcPallina.setFill(Color.WHITE);
	    gcPallina.fillOval(posizioneX-1, 50-1, 22, 22);
		posizioneX+=0.01;
		gcPallina.setLineWidth(1);
	    gcPallina.setFill(Color.RED);
	    gcPallina.fillOval(posizioneX, 50, 20, 20);
	    if (posizioneX>340) {
	    	timer.stop();
	    }
	}	

	public static void main(String[] args) {
	    launch(args);
	}

}