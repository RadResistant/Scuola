package lettere;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Parole extends Application{
	TextField tfInput=new TextField();
	Button bContaVocali=new Button("Conta Vocali");
	Button bContaMaiuscole=new Button("Conta Maiuscole");
	Button bContaPunto=new Button("Conta Punto");
	Button bContaInterne=new Button("Conta Interne");
	Button bTogliSpazi=new Button("Togli Spazi");
	Label lOutput=new Label();
	String parola;
	public void start(Stage finestra) throws Exception {
			GridPane gP=new GridPane();	
			gP.add(tfInput, 0, 0,2,1);
			gP.add(bContaVocali, 0, 1);
			gP.add(bContaMaiuscole, 1, 1);
			gP.add(bContaPunto, 0, 2);
			gP.add(bContaInterne, 1, 2);
			gP.add(bTogliSpazi,0,3,2,1);
			gP.add(lOutput,0,4,2,1);
			gP.setPadding(new Insets(10,10,10,10));
		    gP.setHgap(10); 
		    gP.setVgap(10);
		    gP.setAlignment(Pos.CENTER);
			Scene scena = new Scene(gP);
			finestra.setTitle("Lettere");
			finestra.setScene(scena);
			finestra.show();
			bContaVocali.setOnAction(e-> eContaVocali());
			bContaMaiuscole.setOnAction(e-> eContaMaiuscole());
			bContaPunto.setOnAction(e-> eContaPunto());
			bContaInterne.setOnAction(e-> eContaInterne());
			bTogliSpazi.setOnAction(e-> eTogliSpazi());
			
	}
	
	private void eTogliSpazi() {
		String testo;
		char frase[]=tfInput.getText().trim().toCharArray();
		for(int i=0;i<frase.length;i++) {
			if(frase[i]==' ') {
			}
		}
		testo= new String(frase);
		lOutput.setText(testo);
	}

	private void eContaInterne() {
		boolean interne=true;
		char frase[]=tfInput.getText().trim().toCharArray();
		for(int i=1;i<frase.length;i++) {
			if(Character.isUpperCase(frase[i])){
				if(frase[i-1]!=' ') {
					interne=false;
				}
			}
		}
		if (interne) {
			lOutput.setText("Vabene");
		}
		else {
			lOutput.setText("Non va bene");
		}
	}

	private void eContaPunto() {
		boolean iniziale=true;
		char frase[]=tfInput.getText().trim().toCharArray();
		if(Character.isLowerCase(frase[0])){
			iniziale=false;
		}
		for(int i=0;i<frase.length-2;i++) {
			if(frase[i]==('.')){
				if(Character.isLowerCase(frase[i+2])){
					iniziale=false;
				}
			}
		}
		if (iniziale) {
			lOutput.setText("Vabene");
		}
		else {
			lOutput.setText("Non va bene");
		}
	}

	private void eContaMaiuscole() {
		int maiuscole=0;
		char frase[]=tfInput.getText().trim().toCharArray();
		for(int i=0;i<=frase.length-1;i++) {
			if(Character.isUpperCase(frase[i])){
				maiuscole++;
			}
		}
		System.out.print(maiuscole);
		lOutput.setText(maiuscole+"");
	}

	private void eContaVocali() {
		int vocali=0;
		char frase[]=tfInput.getText().trim().toCharArray();
		for(int i=0;i<=frase.length-1;i++) {
			if(frase[i]==('a')||frase[i]==('e')||frase[i]==('i')||frase[i]==('o')||frase[i]==('u')||frase[i]==('y')) {
				vocali++;
			}
		}
		lOutput.setText(vocali+"");
	}

	public static void main(String[] args) {
	    launch(args);
	}

}
