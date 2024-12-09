package binario;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Binario extends Application{
	TextField tfNumero=new TextField();
	Button bDecimale=new Button("Decimale");
	Button bBinario=new Button("Binario");
	Button bEsadecimale=new Button("Esadecimale");
	Label lRisultato=new Label();
	RadioButton rbDecimale = new RadioButton("Decimale");
	RadioButton rbBinario = new RadioButton("Binario");
	RadioButton rbEsadecimale = new RadioButton("Esadecimale");
	ToggleGroup tgConversione = new ToggleGroup();
	public void start(Stage finestra) throws Exception {
		GridPane gP=new GridPane();
		gP.add(tfNumero, 0, 0,3,1);
		gP.add(bBinario,1,2);
		gP.add(rbDecimale,0,1);
		gP.add(rbBinario,1,1);
		gP.add(rbEsadecimale,2,1);
		gP.add(bDecimale,0,2);
		gP.add(bEsadecimale,2,2);
		gP.add(lRisultato, 0, 3,3,2);
		gP.setPadding(new Insets(10,10,10,10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		finestra.setTitle("Programma");
		finestra.setScene(scena);
		finestra.show();
		rbDecimale.setToggleGroup(tgConversione);
		rbBinario.setToggleGroup(tgConversione);
		rbEsadecimale.setToggleGroup(tgConversione);
		rbDecimale.setSelected(true);
		bBinario.setOnAction(e->eConversioneB());
		bDecimale.setOnAction(e->eConversioneD());
		bEsadecimale.setOnAction(e->eConversioneE());
	}
	private void eConversioneE() {
		double num=Integer.parseInt(tfNumero.getText());
		double resto;
		String numero="",ris="";
		if(rbDecimale.isSelected()) {
			while (num>0) {
				resto=num%16;
				num/=16;
				ris=resto+"";
				if(resto==10) {
					ris="A";
				}
				if(resto==11) {
					ris="B";
				}
				if(resto==12) {
					ris="C";
				}
				if(resto==13) {
					ris="D";
				}
				if(resto==14) {
					ris="E";
				}
				if(resto==15) {
					ris="F";
				}
				numero=ris+numero;
				System.out.print(resto+" ");
			}
			lRisultato.setText(numero);
		}
	}
	private void eConversioneD() {
		char numeri[]=tfNumero.getText().trim().toCharArray();
		int nume=Integer.parseInt(tfNumero.getText());
		int num,potenza=1,ris=0;
		if (rbDecimale.isSelected()) {
			lRisultato.setText(nume+"");
		}
		if(rbBinario.isSelected()) {
			for(int i=numeri.length-1;i>=0;i--) {
			num=Character.getNumericValue(numeri[i]);
			ris+=num*potenza;
			potenza=2*potenza;
			}
			lRisultato.setText(ris+"");
		}
	}
	private void eConversioneB() {
		int num=Integer.parseInt(tfNumero.getText());
		String numero="";
		if (rbBinario.isSelected()) {
			lRisultato.setText(num+"");
		}
		if (rbDecimale.isSelected()) {
			while (num>0) {
				numero=(num%2)+numero;
				num/=2;
			}
			lRisultato.setText(numero);
		}
		if(rbEsadecimale.isSelected()) {
		}
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
