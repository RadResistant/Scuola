package panini;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Panini extends Application {
	Label lTotale = new Label();
	Label lSconto = new Label("Sconto");
	Label lNPanini = new Label("Numero Panini");
	Label lCPanini = new Label("Costo Panini");
	TextField tfNPanini = new TextField();
	TextField tfCPanini = new TextField();
	Button bTotale = new Button("Totale");
	RadioButton rb0 = new RadioButton("0%");
	RadioButton rb10 = new RadioButton("10%");
	RadioButton rb25 = new RadioButton("25%");
	ToggleGroup tgSconto = new ToggleGroup();

	@Override
	public void start(Stage finestra) throws Exception {
		
		bTotale.setOnAction(e -> eseguiTotale());
		rb0.setToggleGroup(tgSconto);
		rb10.setToggleGroup(tgSconto);
		rb25.setToggleGroup(tgSconto);
		rb0.setSelected(true);
		
		GridPane principale = new GridPane();
	    principale.add(tfCPanini, 1, 1, 3, 1);
	    principale.add(tfNPanini, 1, 0, 3, 1);
	    principale.add(lTotale, 1, 3);
	    principale.add(lNPanini, 0, 0);
	    principale.add(lCPanini, 0, 1);
	    principale.add(lSconto, 0, 2);
	    principale.add(bTotale, 0, 3);
	    principale.add(rb0, 1, 2);
	    principale.add(rb10, 2, 2);
	    principale.add(rb25, 3, 2);
	    Scene scena = new Scene(principale);

		principale.setPadding(new Insets(10, 10, 10, 10));
		principale.setHgap(10); 
		principale.setVgap(10);
	    
	    finestra.setTitle("Panini dal Sapo");
	    finestra.setScene(scena);
	    finestra.show();
		
	}
	
	private void eseguiTotale(){
		double numeroPanini,numeroCosto;
		double risultato ,sconto;
		numeroPanini=Double.parseDouble(tfNPanini.getText());
		numeroCosto=Double.parseDouble(tfCPanini.getText());
		risultato= numeroPanini*numeroCosto;
		if (rb10.isSelected()) {
			sconto= risultato *10/100;
			risultato -=sconto;
		}
		if (rb25.isSelected()) {
			sconto= risultato *25/100;
			risultato -=sconto;
		}
		lTotale.setText(""+risultato);
	}
	
	public static void main(String[] args) {
	    launch(args);
	}
}
