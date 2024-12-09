package spelling;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Spelling extends Application{
	TextField tfParola=new TextField();
	Label lRisultato=new Label();
	public void start(Stage finestra) throws Exception {
		GridPane gP=new GridPane();
		gP.add(tfParola, 0, 1);
		gP.add(lRisultato, 0, 2);
		gP.setPadding(new Insets(10,10,10,10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		finestra.setTitle("Programma");
		finestra.setScene(scena);
		finestra.show();
		tfParola.setOnAction(e-> eEsegui());
	}
	private void eEsegui() {
		char cFrase[]=tfParola.getText().trim().toCharArray();
		String testo="";
		for(int i=0; i<cFrase.length;i++) {
			char x=cFrase[i];
			switch(x) {
				case ('A'):
				case ('a'):
					testo+="A";
					break;
				case ('B'):
				case ('b'):
					testo+="Bi";
					break;
				case ('C'):
				case ('c'):
					testo+="Ci";
					break;
				case ('D'):
				case ('d'):
					testo+="Di";
					break;
				case ('E'):
				case ('e'):
					testo+="E";
					break;
				case ('F'):
				case ('f'):
					testo+="Effe";
					break;
				case ('G'):
				case ('g'):
					testo+="Gi";
					break;
				case ('H'):
				case ('h'):
					testo+="Acca";
					break;
				case ('I'):
				case ('i'):
					testo+="I";
					break;
				case ('J'):
				case ('j'):
					testo+="Jay";
					break;
				case ('K'):
				case ('k'):
					testo+="Cappa";
					break;
				case ('L'):
				case ('l'):
					testo+="Elle";
					break;
				case ('M'):
				case ('m'):
					testo+="Emme";
					break;
				case ('N'):
				case ('n'):
					testo+="Enne";
					break;
				case ('O'):
				case ('o'):
					testo+="O";
					break;
				case ('P'):
				case ('p'):
					testo+="Pi";
					break;
				case ('Q'):
				case ('q'):
					testo+="Cu";
					break;
				case ('R'):
				case ('r'):
					testo+="Erre";
					break;
				case ('S'):
				case ('s'):
					testo+="Esse";
					break;
				case ('T'):
				case ('t'):
					testo+="Ti";
					break;
				case ('U'):
				case ('u'):
					testo+="U";
					break;
				case ('V'):
				case ('v'):
					testo+="Vu";
					break;
				case ('W'):
				case ('w'):
					testo+="Doppia vu";
					break;
				case ('X'):
				case ('x'):
					testo+="Ics";
					break;
				case ('Y'):
				case ('y'):
					testo+="Ispilon";
					break;
				case ('Z'):
				case ('z'):
					testo+="Zeta";
					break;
			}
		}
		lRisultato.setText(testo);
	}
	public static void main(String[] args) {
	    launch(args);
	}

}