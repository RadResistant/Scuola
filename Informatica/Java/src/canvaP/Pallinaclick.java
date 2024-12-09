package canvaP;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Pallinaclick extends Application {
	Canvas cSfondo = new Canvas(400, 400);
    GraphicsContext gcPallina = cSfondo.getGraphicsContext2D();
		
	public void start(Stage finestra) throws Exception {
			
		
	    
		GridPane principale = new GridPane();
		principale.add(cSfondo, 0, 0);
		Scene scena = new Scene(principale,400,400);
	    
	    finestra.setTitle("Pallina");
	    finestra.setScene(scena);
	    finestra.show();
		cSfondo.addEventHandler(MouseEvent.MOUSE_DRAGGED, e -> pallina(e));
		
	}
		
	private void pallina(MouseEvent e){
		gcPallina.fillOval(e.getX()-5,e.getY()-5,10,10);
		
		if(e.isAltDown()) {
		    gcPallina.setFill(Color.RED);
		}
		else{
			if(e.isControlDown()) {
				gcPallina.setFill(Color.YELLOW);
			}
			else {
				if(e.isShiftDown()) {
					gcPallina.setFill(Color.PINK);
				}
				else {
					if(e.getButton()==MouseButton.PRIMARY) {
						gcPallina.setFill(Color.BLACK);
					}
					else {
						if(e.getButton()==MouseButton.SECONDARY) {
							gcPallina.setFill(Color.WHITE);
							gcPallina.fillOval(e.getX()-5,e.getY()-5,20,20);
						}
					}
				}
			}
		}
		if(e.isAltDown() && e.isControlDown()) {
			gcPallina.setFill(Color.BLUE);
		}
		if(e.isControlDown() && e.isShiftDown()) {
			gcPallina.setFill(Color.GREEN);
		}
		if(e.isAltDown() && e.isControlDown() && e.isShiftDown()) {
			gcPallina.setFill(Color.PURPLE);
		}
	}
		

	public static void main(String[] args) {
	    launch(args);
	}

}