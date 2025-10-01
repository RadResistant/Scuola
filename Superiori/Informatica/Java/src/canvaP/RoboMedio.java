package canvaP;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class RoboMedio extends Application{

	Canvas c = new Canvas(400, 400);
	
	public void start(Stage dc) throws Exception {
		
		GridPane dg = new GridPane();
		dg.add(c, 0, 0);
		Scene scena = new Scene(dg,400,400);
		dc.setTitle("Pallina");
	    dc.setScene(scena);
	    dc.show();
	}

	public static void main(String[] args) {
	    launch(args);
	}
	
}
