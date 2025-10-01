package teorema;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Pitagora extends Application {
	Label lMaggiore = new Label();
	Label lMinore = new Label();
	Label lIpotenusa = new Label();
	Button bMaggiore = new Button();
	Button bMinore = new Button();
	Button bIpotenusa = new Button();
	TextField tfMaggiore = new TextField();
	TextField tfMinore = new TextField();
	TextField tfIpotenusa = new TextField();
	public void start(Stage finestra) throws Exception {
		lMaggiore.setText("C. Maggiore: ");
		lMinore.setText("C. Minore: ");
		lIpotenusa.setText("Ipotenusa: ");
		bMaggiore.setText("Max");
		bMinore.setText("Min");
		bIpotenusa.setText("Ipo");
		bMaggiore.setOnAction(e -> eseguiMaggiore());
		bMinore.setOnAction(e -> eseguiMinore());
		bIpotenusa.setOnAction(e -> eseguiIpotenusa ());
		GridPane principale = new GridPane();
	    principale.add(bMinore, 2, 0);
	    principale.add(bMaggiore, 2, 1);
	    principale.add(bIpotenusa, 2, 2);
	    principale.add(lMinore, 0, 0);
	    principale.add(lMaggiore, 0, 1);
	    principale.add(lIpotenusa, 0, 2);
	    principale.add(tfMinore, 1, 0);
	    principale.add(tfMaggiore, 1, 1);
	    principale.add(tfIpotenusa, 1, 2);
	    Scene scena = new Scene(principale);
	    finestra.setTitle("Triangolo Rettangolo");
	    finestra.setScene(scena);
	    finestra.show();
		
	}
	
	private void eseguiMaggiore(){
		double n1,n2;
		double ris;
		String t1, t2;
		t1=tfIpotenusa.getText();
		n1=Double.parseDouble(t1);
		t2=tfMinore.getText();
		n2=Double.parseDouble(t2);
		ris = Math.sqrt ( n1*n1 - n2*n2);
		tfMaggiore.setText(""+ris);
	  }
	private void eseguiMinore(){
		double n1,n2;
		double ris;
		String t1, t2;
		t1=tfIpotenusa.getText();
		n1=Double.parseDouble(t1);
		t2=tfMaggiore.getText();
		n2=Double.parseDouble(t2);
		ris = Math.sqrt ( n1*n1 - n2*n2);
		tfMinore.setText(""+ris);
	  }
	private void eseguiIpotenusa(){
		double n1,n2;
		double ris;
		String t1, t2;
		t1=tfMaggiore.getText();
		n1=Double.parseDouble(t1);
		t2=tfMinore.getText();
		n2=Double.parseDouble(t2);
		ris = Math.sqrt ( n1*n1 + n2*n2);
		tfIpotenusa.setText(""+ris);
	  }
	public static void main(String[] args) {
	    launch(args);
	}
}