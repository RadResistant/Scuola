package pong;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.geometry.Bounds;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Pong extends Application{
	Timeline timer = new Timeline();
	Circle cSfera=new Circle(10);
	Rectangle rRettangolo1=new Rectangle(10,70);
	Rectangle rRettangolo2=new Rectangle(10,70);
	Button bStart=new Button("Start");
	Button bRestart=new Button("Restart");
	Label lP1=new Label();
	Label lP2=new Label();
	Label lFine=new Label("FINE");
	Pane pArea=new Pane();
	int y1=10,y2=10,p1=0,p2=0;
	double incrementoX=0.5,incrementoY=0.5;
	public void start(Stage finestra) throws Exception {
		bStart.setLayoutX(135);
		bStart.setLayoutY(135);
		bRestart.setLayoutX(120);
		bRestart.setLayoutY(165);
		pArea.getChildren().add(bStart);
		lP1.setLayoutX(50);
		pArea.getChildren().add(lP1);
		lP2.setLayoutX(250);
		pArea.getChildren().add(lP2);
		lFine.setLayoutX(135);
		lFine.setLayoutY(125);
		rRettangolo1.setX(10);
        rRettangolo1.setY(y1);
        rRettangolo1.setFill(Color.RED);
        rRettangolo2.setX(290);
        rRettangolo2.setY(y2);
        rRettangolo2.setFill(Color.RED);
		pArea.setPrefSize(300,300);
		cSfera.setCenterX(150);
		cSfera.setCenterY(150);
		cSfera.setFill(Color.BLACK);
		Scene scena = new Scene(pArea,310,310);
	    finestra.setTitle("Area di gioco");
	    finestra.setScene(scena);
	    finestra.show();
	    KeyFrame kN = new KeyFrame(Duration.seconds(0.01),e-> eTimer());
		timer = new Timeline(kN);
		timer.setCycleCount(Timeline.INDEFINITE);
		bStart.setOnAction(e -> eRacchette());
		bRestart.setOnAction(e -> eRestart());
		scena.setOnKeyPressed(e->eMovimento(e));
		
	}
	private void eRestart() {
		p1=0;
		p2=0;
		timer.play();
		pArea.getChildren().remove(bRestart);
		pArea.getChildren().remove(lFine);
	}
	private void eMovimento(KeyEvent e) {
		if(e.getText().equals("w")){
			y1-=15;
		}
		if(e.getText().equals("s")){
			y1+=15;
		}
		if(e.getCode().equals(KeyCode.UP)){
			y2-=15;
		}
		if(e.getCode().equals(KeyCode.DOWN)){
			y2+=15;
		}
		rRettangolo1.setY(y1);
		rRettangolo2.setY(y2);
	}
	private void eRacchette() {
        pArea.getChildren().add(rRettangolo1);
        pArea.getChildren().add(rRettangolo2);
		pArea.getChildren().add(cSfera);
		pArea.getChildren().remove(bStart);
		timer.play();
	}
	private void eTimer() {
		double x=cSfera.getCenterX();
		double y=cSfera.getCenterY();
		if(x>=300) {
			p1+=1;
			x=150;
			y=150;
		}
		if(y>=300) {
			incrementoY=-1;
		}
		if(x<=0) {
			p2+=1;
			x=150;
			y=150;
		}
		if(y<=0) {
			incrementoY=1;
		}
		if(p1==10||p2==10){
			timer.stop();
			pArea.getChildren().add(lFine);
			pArea.getChildren().add(bRestart);
		}
		x+=incrementoX;
		y+=incrementoY;
		cSfera.setCenterX(x);
		cSfera.setCenterY(y);
		lP1.setText(""+p1);
		lP2.setText(""+p2);
		Bounds bSfera = cSfera.getBoundsInParent();
		Bounds bRettangolo1 = rRettangolo1.getBoundsInParent();
		Bounds bRettangolo2 = rRettangolo2.getBoundsInParent();
		if(bRettangolo1.intersects(bSfera))
			incrementoX=+1;
		if(bRettangolo2.intersects(bSfera))
			incrementoX=-1;
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
