package vettoriSTRAni.mescolaVettori;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class MescolaVettori extends Application {
	TextField tfInput=new TextField();
	Label lOutput=new Label();
	Button bPari = new Button("Pari"); 
	Button bBubble = new Button("Bubble");
	Button b1 = new Button(); 
	Button b2 = new Button();
	public void start(Stage finestra) throws Exception {
		tfInput.setPromptText("Input");
		lOutput.setText("Output");
		bPari.setMaxSize(500,500);
		bBubble.setMaxSize(500,500);
		b1.setMaxSize(500,500);
		b2.setMaxSize(500,500);
		tfInput.setMaxSize(500,500);
		lOutput.setMaxSize(500,500);
		GridPane gP=new GridPane();
		gP.add(tfInput,0,0,4,1);
		gP.add(bPari,0,1);
		gP.add(bBubble,1,1);
		gP.add(b1,2,1);
		gP.add(b2,3,1);
		gP.add(lOutput,0,2,4,1);
		gP.setPadding(new Insets(10,10,10,10));
	    gP.setHgap(10); 
	    gP.setVgap(10);
	    gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		finestra.setTitle("Vettori");
		finestra.setScene(scena);
		finestra.show();
		bPari.setOnAction(e-> ePari());
		bBubble.setOnAction(e-> eBubble());
	}
	int[] y(String t) {
		String numeri=t;
		String tuttiNumeri[]=numeri.split(" ");
		int listaNumeri[]=new int[tuttiNumeri.length];
		for(int i=0;i<tuttiNumeri.length;i++) {
			listaNumeri[i]=Integer.parseInt(tuttiNumeri[i]);
			}
		return listaNumeri;
	}
	private void ePari() {
		String input=tfInput.getText();
		int x[]=y(input);
		String out="";
		for(int i=0; i<x.length;i++) {
			if(x[i]%2!=0) {
				x[i]=0;
			}
		}
		for(int i=0; i<x.length;i++) {
			out+=" "+x[i];
		}
		lOutput.setText(out);
	}
	private void eBubble() {
		String input=tfInput.getText();
		int x[]=y(input),appoggio=0;
		String out="";
		for(int i=0; i<=(x.length-1)-1;i++) {
			for(int y=(x.length-1)-1; y>=x.length;y++) {
				if(x[y]>x[y+1]) {
					appoggio=x[y];
					x[y]=x[y+1];
					x[y+1]=appoggio;
				}
			}
		}
		for(int i=0; i<x.length;i++) {
			out+=" "+x[i];
		}
		lOutput.setText(out);
	}
	public static void main(String[] args) {
	    launch(args);
	}
}