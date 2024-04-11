package lineaCheSbatte;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Line;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Linea extends Application{
	Timeline timer = new Timeline();
	Line lLinea=new Line();
	Pane pArea=new Pane();
	int y1=10,y2=10;
	double incrementoX=0.5,incrementoY=1;
	public void start(Stage finestra) throws Exception {
		pArea.setPrefSize(300,300);
		lLinea.setStartX(150);
		lLinea.setStartY(150);
		lLinea.setEndX(160);
		lLinea.setEndY(150);
		lLinea.setFill(Color.BLACK);
		pArea.getChildren().add(lLinea);
		Scene scena = new Scene(pArea,310,310);
	    finestra.setTitle("Area di gioco");
	    finestra.setScene(scena);
	    finestra.show();
	    KeyFrame kN = new KeyFrame(Duration.seconds(0.01),e-> eTimer());
		timer = new Timeline(kN);
		timer.setCycleCount(Timeline.INDEFINITE);
		timer.play();
	}
	private void eTimer() {
		double xS=lLinea.getStartX();
		double yS=lLinea.getStartY();
		double xE=lLinea.getEndX();
		double yE=lLinea.getEndY();
		if(xS>=300) {
			incrementoX=-1;
		}
		if(yS>=300) {
			incrementoY=-1;
		}
		if(xS<=0) {
			incrementoX=1;
		}
		if(yS<=0) {
			incrementoY=1;
		}
		if(xE>=300) {
			incrementoX=-1;
		}
		if(yE>=300) {
			incrementoY=-1;
		}
		if(xE<=0) {
			incrementoX=1;
		}
		if(yE<=0) {
			incrementoY=1;
		}
		xS+=incrementoX;
		yS+=incrementoY;
		xE+=incrementoX;
		yE+=incrementoY;
		lLinea.setStartX(xS);
		lLinea.setStartY(yS);
		lLinea.setEndX(xE);
		lLinea.setEndY(yE);
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
