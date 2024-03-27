package divisori;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Divisori extends Application{
	Label lNumero=new Label("Numero");
	Label lDivisori=new Label();
	Button bDivisori=new Button("Divisori");
	TextField tfNumero=new TextField();
	int n;
	String elencoN;
	public void start(Stage dc) throws Exception {
		lDivisori.setMaxSize(500,500);
	    bDivisori.setMaxSize(500,500);
		GridPane dg = new GridPane();
		dg.add(lNumero,0,0);
		dg.add(lDivisori,0,2,2,1);
		dg.add(bDivisori,0,1,2,1);
		dg.add(tfNumero,1,0);
		Scene scena = new Scene(dg,300,150);
		dc.setTitle("Pallina");
	    dc.setScene(scena);
	    dc.show();
	    dg.setAlignment(Pos.CENTER);
		dg.setPadding(new Insets(10, 10, 10, 10));
		dg.setHgap(10); 
		dg.setVgap(10);
		bDivisori.setOnAction(e -> eseguiDiv());	
	}
	private void eseguiDiv() {
		n=Integer.parseInt(tfNumero.getText());
		for(int i=1;i<=100; i++){
			if(n%i==0) {
				elencoN+=" "+n;
			}
		}
		lDivisori.setText(elencoN);
	}
	public static void main(String[] args) {
	    launch(args);
	}
}