package saluta;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.control.Label;
import javafx.stage.Stage;
public class Generale extends Application {
    TextField tfTextField = new TextField();
    Button bButton = new Button("button");
    public void start(Stage primaryStage) {
        Label lLabel = new Label("Label");
        Button eseguiSaluto = new Button("Button");
        tfTextField.setPromptText("Disattivata");
        tfTextField.setDisable(true);
        eseguiSaluto.setOnAction(e -> saluta() );
        GridPane griglia = new GridPane();
        griglia.add(lLabel, 0, 0);
        griglia.add(tfTextField, 1, 0);
        griglia.add(eseguiSaluto, 1, 1);
        Scene scene = new Scene(griglia, 500, 250);
        primaryStage.setTitle("Generale");
        primaryStage.setScene(scene);
        primaryStage.show();
        griglia.setAlignment(Pos.CENTER);
        griglia.setPadding(new Insets(10,10,10,10));
	    griglia.setHgap(10); 
	    griglia.setVgap(10);
    }
    public void saluta() {
        String utente;
        utente = tfTextField.getText();
    }
    public static void main(String[] args) {
        launch(args);
    }
}
