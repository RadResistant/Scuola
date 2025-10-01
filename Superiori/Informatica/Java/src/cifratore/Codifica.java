package cifratore;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Codifica extends Application{
	Button bCodifica=new Button("Codifica");
	Button bDecodifica=new Button("Decodifica");
	TextField tfMessaggio=new TextField();
	TextField tfChiave=new TextField();
	Label lMsg=new Label("Msg");
	Label lChiave=new Label("Chiave");
	Label lCodificata=new Label();
	String sLettere[]=new String[26];
	String sChiave="efghijklmnopqrstuvwxyzabcd";
	String sAlfabeto="abcdefghijklmnopqrstuvWxyz";
	public void start(Stage primaryStage) throws Exception {
		tfChiave.setText(sChiave);
		GridPane gP = new GridPane();
		gP.add(lMsg, 0, 0);
		gP.add(lChiave, 0, 1);
		gP.add(tfMessaggio,1, 0);
		gP.add(tfChiave, 1, 1);
		gP.add(bCodifica, 1, 2);
		gP.add(bDecodifica, 1, 3);
		gP.add(lCodificata,1, 4);
		gP.setPadding(new Insets(10,10,10,10));
		gP.setHgap(10);
		gP.setVgap(10);
		gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Codifica");
		primaryStage.setScene(scena);
		primaryStage.show();
		bCodifica.setOnAction(e->eCodifica());
		bDecodifica.setOnAction(e->eDecodifica());
	}
	private void  eDecodifica() {
		char cChiave[]=tfChiave.getText().toLowerCase().toCharArray();
		char cMessaggio[]=tfMessaggio.getText().toLowerCase().toCharArray();
		char cAlfabeto[]=sAlfabeto.toLowerCase().toCharArray();
		for(int z=0;z<cMessaggio.length;z++) {
			for(int k=0;k<cAlfabeto.length;k++) {
				if(cMessaggio[z]==cChiave[k]){
					cMessaggio[z]=cAlfabeto[k];
				}
			}
		}
		String codiFica = new String(cMessaggio);
		lCodificata.setText(codiFica);
	}
	private void eCodifica() {
		char cChiave[]=tfChiave.getText().toLowerCase().toCharArray();
		char cMessaggio[]=tfMessaggio.getText().toLowerCase().toCharArray();
		boolean ripetuto=false,speciali=false;
		boolean corta=false,lunga=false ;
		boolean vabene=true;
		if(cChiave.length>26) {
			lunga=true;
			vabene=false;
		}
		if(cChiave.length<26) {
			corta=true;
			vabene=false;
		}
		for(int i=0;i<cChiave.length;i++) {
			if(cChiave[i]<'a' && cChiave[i]>'z') {
				speciali=true;
				vabene=false;
			}
			for(int y=0;y<cChiave.length;y++) {
				if(cChiave[i]==cChiave[y]&& y!=i) {
					ripetuto=true;
					vabene=false;
				}
			}
		}
		if(corta) {
			lCodificata.setText("Chiave troppo corta");
		}
		if(lunga) {
			lCodificata.setText("Chiave troppo lunga");
		}
		if(speciali) {
			lCodificata.setText("contiene caratteri speciali");
		}
		if(ripetuto) {
			lCodificata.setText("Nella chiave ci sono ripetizioni");
		}
		if(vabene) {
			for(int z=0;z<cMessaggio.length;z++) {
				if(cMessaggio[z]>='a' && cMessaggio[z]<='z') {
					cMessaggio[z]=cChiave[cMessaggio[z]-'a'];
				}
			}
			String codiFica = new String(cMessaggio);
			lCodificata.setText(codiFica);
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
