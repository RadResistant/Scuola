package tryCatch;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class AreaQuadrato extends Application {
	Label lLato = new Label(" Lato");
	Label lArea = new Label("Area");
	Label lAreaRisultato = new Label();
	TextField tLato = new TextField();
	Button bCalcolaArea = new Button("Calcola Area");
	public void start(Stage primaryStage) throws Exception {
		GridPane griglia = new GridPane();
		griglia.add(lLato, 0, 0);
		griglia.add(tLato, 1, 0);
		griglia.add(bCalcolaArea, 1, 1);
		griglia.add(lArea, 0, 2);
		griglia.add(lAreaRisultato, 1, 2);

		Scene scena = new Scene(griglia, 300, 250);

		primaryStage.setTitle("Area Quadrato");
		primaryStage.setScene(scena);
		primaryStage.show();
		bCalcolaArea.setOnAction(e -> esegui());
	}

	private void esegui() {
		try {
			int lato = Integer.parseInt(tLato.getText());
			int area = lato * lato;
			lAreaRisultato.setText(" " + area);
		} catch (NumberFormatException e) {
			lAreaRisultato.setText(tLato.getText() + " Non è un numero ");
		}

	}

	public static void main(String[] args) {
		launch(args);
	}
}
