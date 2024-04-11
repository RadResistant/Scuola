package frazioni;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
public class Frazioni extends Application{
	Canvas cFrazione=new Canvas(100,10);
	Button bSemplifica=new Button("Semplifica");
	TextField tfNumeratore=new TextField();
	TextField tfDenominatore=new TextField();
	GraphicsContext gcFrazione = cFrazione.getGraphicsContext2D();
	public void start(Stage dc) throws Exception {
		gcFrazione.setStroke(Color.BLACK);
	    gcFrazione.setLineWidth(4);
	    gcFrazione.strokeLine(0,0,500,0);
	    bSemplifica.setMaxSize(500,500);
	    tfNumeratore.setMaxSize(100,500);
	    tfDenominatore.setMaxSize(100,500);
		GridPane dg = new GridPane();
		dg.add(bSemplifica,1,0,2,3);
		dg.add(tfNumeratore,0,0);
		dg.add(cFrazione,0,1);
		dg.add(tfDenominatore,0,2);
		Scene scena = new Scene(dg,200,150);
		dc.setTitle("Frazioni");
	    dc.setScene(scena);
	    dc.show();
	    dg.setAlignment(Pos.CENTER);
		dg.setPadding(new Insets(10, 10, 10, 10));
		dg.setHgap(10); 
		dg.setVgap(10);
		bSemplifica.setOnAction(e -> eseguiSemplifica());
	}
	private void eseguiSemplifica() {
		int num,den,pic;
		num=Integer.parseInt(tfNumeratore.getText());
		den=Integer.parseInt(tfDenominatore.getText());
		if(num<den) {
			pic=num;
		}
		else {
			pic=den;
		}
		for(int y=10;y>0;y--) {
			if(num%pic==0 && den%pic==0) {
				num/=pic;
				den/=pic;
			}
			else {
				num/=y;
				den/=y;
			}
		}
	}
	public static void main(String[] args) {
	    launch(args);
	}
}