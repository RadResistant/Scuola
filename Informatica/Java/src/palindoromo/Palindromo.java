package palindoromo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Palindromo extends Application{
	TextField tfParola=new TextField();
	Label lRisultato=new Label();
	Button bPali= new Button("palindromo");
	public void start(Stage finestra) throws Exception {
		GridPane gP=new GridPane();
		gP.add(tfParola, 0, 1);
		gP.add(bPali, 0, 2);
		gP.add(lRisultato, 0, 3);
		gP.setPadding(new Insets(10,10,10,10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		finestra.setTitle("Palindromo");
		finestra.setScene(scena);
		finestra.show();
		bPali.setOnAction(e-> epPali());
		tfParola.setOnAction(e-> ePalindromo());
	}
	private void epPali() {
		char vetParola[] = tfParola.getText().trim().toCharArray();
	}
	private void ePalindromo() {
		String parole=tfParola.getText();
		char vetParola[] = parole.toCharArray();
        char vetParolaInvert[];
        vetParolaInvert = new char [vetParola.length];
       
        int menoC = vetParola.length-1;
        for(int c=0; c<vetParola.length; c++) {
            vetParolaInvert[c] = vetParola[menoC];
            menoC--;
        }
       
        String parolaFinale = new String(vetParolaInvert);
        if(parole.equals(parolaFinale)) {
           
            lRisultato.setText(parolaFinale+"..." +"è palindromo");
          
        }else {
           
        	 lRisultato.setText(parolaFinale+"..." +"non è palindromo");
           
        }
	}
	public static void main(String[] args) {
	    launch(args);
	}
}