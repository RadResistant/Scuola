package rettangolo;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Rettangolo extends Application {
	Label lBase = new Label();
	Label lArea = new Label();
	Label lRisultato = new Label();
	Button pArea = new Button();
	Button pPerimetro = new Button();
	TextField tfBase = new TextField();
	TextField tfArea = new TextField();

	@Override
	public void start(Stage finestra) throws Exception {
		lBase.setText("Base: ");
		lArea.setText("Altezza: ");
		pArea.setText("Area");
		pPerimetro.setText("Perimetro");
		pArea.setOnAction(e -> eseguiArea());
		pPerimetro.setOnAction(e -> eseguiPerim());
		
		
		
		GridPane principale = new GridPane();
	    principale.add(pArea, 2, 0);
	    principale.add(pPerimetro, 2, 1);
	    principale.add(lBase, 0, 0);
	    principale.add(lArea, 0, 1);
	    principale.add(lRisultato, 1, 3);
	    principale.add(tfArea, 1, 0);
	    principale.add(tfBase, 1, 1);
	    Scene scena = new Scene(principale, 300, 250);
	    
	    finestra.setTitle("Rettangolo");
	    finestra.setScene(scena);
	    finestra.show();
		
	}
	
	private void eseguiArea(){
		int n1,n2;
		int ris;
		n1=Integer.parseInt(tfBase.getText());
		n2=Integer.parseInt(tfArea.getText());
		ris = n1*n2;
		lRisultato.setText(""+ris);
	  }
	
	private void eseguiPerim(){
		int n1,n2;
		int ris;
		String t1, t2;
		t1=tfBase.getText();
		n1=Integer.parseInt(t1);
		t2=tfArea.getText();
		n2=Integer.parseInt(t2);
		ris = (n1+n2)*2;
		lRisultato.setText(""+ris);
	  }
	
	public static void main(String[] args) {
	    launch(args);
	}
}
