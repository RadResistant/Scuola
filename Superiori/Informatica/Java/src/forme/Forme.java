package forme;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Forme extends Application{
	Timeline timer = new Timeline();
//	int posizioneX=50;
	Circle cSfera=new Circle(20);
	int i=1;
	public void start(Stage finestra) throws Exception {
		Pane pArea=new Pane();
		pArea.setPrefSize(300,300);
		cSfera.setCenterX(/*posizioneX*/50);
		cSfera.setCenterY(50);
		cSfera.setFill(Color.BLACK);
		pArea.getChildren().add(cSfera);
		Scene scena = new Scene(pArea,300,150);
	    finestra.setTitle("Area di gioco");
	    finestra.setScene(scena);
	    finestra.show();
	    KeyFrame kN = new KeyFrame(Duration.seconds(0.01),e-> eTimer());
		timer = new Timeline(kN);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}
	private void eTimer() {
//		posizioneX+=1;
//		cSfera.setCenterX(posizioneX);
		double x=cSfera.getCenterX();
		if(x>=300) {
			i=-1;
		}
		if(x<=50) {
			i=1;
		}
		x+=i;
		cSfera.setCenterX(x);
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
