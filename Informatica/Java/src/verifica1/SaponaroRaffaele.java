package verifica1;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class SaponaroRaffaele extends Application {
	TextField tfN=new TextField();
	TextField tfM=new TextField();
	TextField tfD=new TextField();
	Button bEs1=new Button("Es 1");
	Button bEs2=new Button("Es 2");
	Button bEs3=new Button("Es 3");
	Label lOptput=new Label();
	int n=0,m=0,d=0;
	public void start(Stage finestra) throws Exception {
		tfN.setPromptText("N");
		tfM.setPromptText("M");
		tfD.setPromptText("D");
		bEs1.setMaxSize(5000,5000);
		bEs2.setMaxSize(5000,5000);
		bEs3.setMaxSize(5000,5000);
		GridPane gP=new GridPane();
		gP.add(tfN,0,0);
		gP.add(tfM,1,0);
		gP.add(tfD,2,0);
		gP.add(bEs1,0,1);
		gP.add(bEs2,1,1);
		gP.add(bEs3,2,1);
		gP.add(lOptput,0,2,3,1);
		gP.setPadding(new Insets(10, 10, 10, 10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena=new Scene(gP);
		finestra.setTitle("Verifica");
	    finestra.setScene(scena);
	    finestra.show();
	    bEs1.setOnAction(e -> eEs1());
	    bEs2.setOnAction(e -> eEs2());
	    bEs3.setOnAction(e -> eEs3());
	}
	private void eEs1() {
		n=Integer.parseInt(tfN.getText());
		m=Integer.parseInt(tfM.getText());
		int k=0;
		d=m-n+1;
		for (int i=0;i<d;i++){
			k=k+n;
			n++;
		}
		lOptput.setText(k+"");
	}
	private void eEs2() {
		n=Integer.parseInt(tfN.getText());
		m=Integer.parseInt(tfM.getText());
		d=m-n+1;
		int k=0,y=2;
		for (int i=0;i<d;i++){
			if(n%y==0) {
				k++;
			}
			n++;
		}
		lOptput.setText(k+"");
	}
	private void eEs3() {
		n=Integer.parseInt(tfN.getText());
		m=Integer.parseInt(tfM.getText());
		d=Integer.parseInt(tfD.getText());
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
