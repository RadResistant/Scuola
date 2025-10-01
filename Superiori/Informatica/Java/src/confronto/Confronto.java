package confronto;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Confronto extends Application {
	Label lRisultato = new Label();
	Label lTriangolo = new Label("Triangolo");
	Label lRettangolo = new Label("Rettangolo");
	Label lBase = new Label("Base");
	Label lAltezza = new Label("Altezza");
	TextField tfBaseTriangolo = new TextField();
	TextField tfAltezzaTriangolo = new TextField();
	TextField tfBaseRettangolo = new TextField();
	TextField tfAltezzaRettangolo = new TextField();
	Button bConfronta = new Button("Confronta");

	@Override
	public void start(Stage finestra) throws Exception {
		
		bConfronta.setOnAction(e -> eseguiConfronto());
		
		GridPane principale = new GridPane();
	    principale.add(tfAltezzaTriangolo, 1, 2);
	    principale.add(tfBaseTriangolo, 1, 1);
	    principale.add(tfBaseRettangolo, 2, 1);
	    principale.add(tfAltezzaRettangolo, 2, 2);
	    principale.add(lRettangolo, 2, 0);
	    principale.add(lBase, 0, 1);
	    principale.add(lAltezza, 0, 2);
	    principale.add(lTriangolo, 1, 0);
	    principale.add(bConfronta, 1, 3, 2,1);
	    principale.add(lRisultato, 1, 4, 2, 1);
	    bConfronta.setMaxSize(500,500);
	    Scene scena = new Scene(principale);

		principale.setPadding(new Insets(10, 10, 10, 10));
		principale.setHgap(10); 
		principale.setVgap(10);
		principale.setAlignment(Pos.CENTER);
		
	    finestra.setTitle("Confronta");
	    finestra.setScene(scena);
	    finestra.show();
		
	}
	
	private void eseguiConfronto(){
		double baseR,altezzaR,baseT,altezzaT;
		double risultatoR ,risultatoT;
		String text1,text2,text3,text4;
		text1=tfBaseRettangolo.getText();
		baseR=Double.parseDouble(text1);
		text2=tfAltezzaRettangolo.getText();
		altezzaR=Double.parseDouble(text2);
		text3=tfBaseTriangolo.getText();
		baseT=Double.parseDouble(text3);
		text4=tfAltezzaTriangolo.getText();
		altezzaT=Double.parseDouble(text4);
		risultatoR= baseR*altezzaR;
		risultatoT= (baseT*altezzaT)/2;
		if (risultatoR>risultatoT) {
			lRisultato.setText("Il maggiore è il Rettangolo");
		}
		else{if (risultatoR == risultatoT) {
			lRisultato.setText("Le aree sono uguali");}
			else {lRisultato.setText("Il maggiore è il Triangolo");
			}
		}
	}
	
	public static void main(String[] args) {
	    launch(args);
	}
}