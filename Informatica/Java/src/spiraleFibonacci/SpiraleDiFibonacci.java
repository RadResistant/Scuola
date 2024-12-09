package spiraleFibonacci;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class SpiraleDiFibonacci extends Application{
	TextField tfFibonacci=new TextField();
	Button bCalcolo=new Button("Calcolo Fibonacci");
	Button bRicorsivo=new Button("Fibonacci Ricorsivo");
	Label lRisultato=new Label();
	public void start(Stage finestra) throws Exception {
		GridPane gP=new GridPane();
		gP.add(tfFibonacci, 0, 0);
		gP.add(bCalcolo, 0, 1);
		gP.add(bRicorsivo, 0, 2);
		gP.add(lRisultato, 0, 3);
		gP.setPadding(new Insets(10,10,10,10));
	        gP.setHgap(10); 
	        gP.setVgap(10);
	        gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		finestra.setTitle("Fibonacci");
		finestra.setScene(scena);
		finestra.show();
		bRicorsivo.setOnAction(e-> riproduzioneRicorsivo());
		bCalcolo.setOnAction(e-> riproduzioneIterativa());
	}
	public int fibonacciRicorsivo(int r) {
		if(r<2){
			if(r==0){
				return 0;
			}
			else{
				return 1;
			}
		}
		else{
			return fibonacciRicorsivo(r-1)+fibonacciRicorsivo(r-2);
		}
	}
	public int fibonacciIterativo(int n) {
		int antenato, precendente, fibonacci = 0;
		if(n<2){
			if(n==0){
				return 0;
			}
			else{
				return 1;
			}
		}
		else{
			antenato = 0;
			precendente = 1;
			for(int c = 2;c<= n;c++) {
				fibonacci = antenato +precendente;
				antenato = precendente;
				precendente = fibonacci;
			}
			return fibonacci;
		}
	}
	private void riproduzioneIterativa() {
		int mese = Integer.parseInt(tfFibonacci.getText());
		int coppieConigli = fibonacciIterativo(mese);
		lRisultato.setText(coppieConigli + "");
	}
	
	private void riproduzioneRicorsivo() {
		int mese = Integer.parseInt(tfFibonacci.getText());
		int coppieConigli = fibonacciRicorsivo(mese);
		lRisultato.setText(coppieConigli + "");
	}
	public static void main(String[] args) {
	    launch(args);
	}
}
