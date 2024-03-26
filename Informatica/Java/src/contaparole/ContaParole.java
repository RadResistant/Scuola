package contaparole;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ContaParole extends Application{
	TextField tfInput=new TextField();
	Button bContaParole=new Button("conta parole");
	Label lOutput=new Label();
	String parola;
	public void start(Stage finestra) throws Exception {
			GridPane gP=new GridPane();	
			gP.add(tfInput, 0, 0);
			gP.add(bContaParole, 0, 1);
			gP.add(lOutput, 0, 2);
			gP.setPadding(new Insets(10,10,10,10));
		    gP.setHgap(10); 
		    gP.setVgap(10);
		    gP.setAlignment(Pos.CENTER);
			Scene scena = new Scene(gP);
			finestra.setTitle("Parole");
			finestra.setScene(scena);
			finestra.show();
			bContaParole.setOnAction(e-> eContaParole());
			
	}
	
	private void eContaParole() {
		String parola=tfInput.getText();
		String frase[]=parola.split(" ");
		lOutput.setText(frase.length+"");
	}

	public static void main(String[] args) {
	    launch(args);
	}

}
