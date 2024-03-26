package calcolatrice;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Calcolatrice extends Application {
	Label lN1 = new Label();
	Label lN2 = new Label();
	Label lRis = new Label();
	Label lTot = new Label("Risultato");
	Button pSomma = new Button();
	Button pSott = new Button();
	Button pMolt = new Button();
	Button pDiv = new Button();
	TextField tfN1 = new TextField();
	TextField tfN2 = new TextField();

	@Override
	public void start(Stage finestra) throws Exception {
		lN1.setText("Numero 1: ");
		lN2.setText("Numero 2: ");
		lRis.setText("Risultato: ");
		lTot.setText("");
		pSomma.setText("+");
		pSott.setText("-");
		pMolt.setText("*");
		pDiv.setText("/");
		pSomma.setOnAction(e -> eseguiSomma());
		pSott.setOnAction(e -> eseguiSott());
		pMolt.setOnAction(e -> eseguiMolt());
		pDiv.setOnAction(e -> eseguiDiv());
		
		
		
		GridPane principale = new GridPane();
	    principale.add(pSomma, 2, 0);
	    principale.add(pSott, 2, 1);
	    principale.add(pMolt, 2, 2);
	    principale.add(pDiv, 2, 3);
	    principale.add(lN1, 0, 0);
	    principale.add(lN2, 0, 1);
	    principale.add(lRis, 0, 3);
	    principale.add(lTot, 1, 3);
	    principale.add(tfN1, 1, 0);
	    principale.add(tfN2, 1, 1);
	    Scene scena = new Scene(principale);
	    
	    finestra.setTitle("Calcolatrice");
	    finestra.setScene(scena);
	    finestra.show();
		
	}
	
	private void eseguiSomma(){
		int n1,n2;
		int ris;
		String t1, t2;
		t1=tfN1.getText();
		n1=Integer.parseInt(t1);
		t2=tfN2.getText();
		n2=Integer.parseInt(t2);
		ris = n1+n2;
		lTot.setText(""+ris);
	  }
	
	private void eseguiSott(){
		int n1,n2;
		int ris;
		String t1, t2;
		t1=tfN1.getText();
		n1=Integer.parseInt(t1);
		t2=tfN2.getText();
		n2=Integer.parseInt(t2);
		ris = n1-n2;
		lTot.setText(""+ris);
	  }
	
	private void eseguiMolt(){
		int n1,n2;
		int ris;
		String t1, t2;
		t1=tfN1.getText();
		n1=Integer.parseInt(t1);
		t2=tfN2.getText();
		n2=Integer.parseInt(t2);
		ris = n1*n2;
		lTot.setText(""+ris);
	  }
	
	private void eseguiDiv(){
		int n1,n2;
		int ris;
		String t1, t2;
		t1=tfN1.getText();
		n1=Integer.parseInt(t1);
		t2=tfN2.getText();
		n2=Integer.parseInt(t2);
		ris = n1/n2;
		lTot.setText(""+ris);
	  }
	
	public static void main(String[] args) {
	    launch(args);
	}
}
