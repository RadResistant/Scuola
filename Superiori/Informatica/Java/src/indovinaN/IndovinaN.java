package indovinaN;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
// import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class IndovinaN extends Application {
		Label lNumero = new Label("Numero:");
		Label lRisultato = new Label();
		TextField tfNInserito = new TextField();
		Button bProva = new Button("Prova");
		int numeroEstratto;
		int numeroTentaitivi;
		// RadioButton rb100 = new RadioButton("0,100");
		// RadioButton rb1000 = new RadioButton("0,1000");
		// RadioButton rb10000 = new RadioButton("0,10000");
		// ToggleGroup tgProva = new ToggleGroup();
		
	public void start(Stage finestra) throws Exception {
			
			numeroEstratto= (int)(Math.random()*100)+1;
			bProva.setOnAction(e -> eseguiProva());
//			rb100.setToggleGroup(tgProva);
//			rb1000.setToggleGroup(tgProva);
//			rb10000.setToggleGroup(tgProva);
//			rb100.setSelected(true);
			
			GridPane principale = new GridPane();

			principale.add(lRisultato, 1, 2);
			principale.add(lNumero, 0, 0);
			principale.add(tfNInserito, 1,0);
			principale.add(bProva, 2,0);
//		    principale.add(rb100, 0, 1);
//		    principale.add(rb1000, 0, 2);
//		    principale.add(rb10000, 0, 3);
		    Scene scena = new Scene(principale);
	
			principale.setPadding(new Insets(10, 10, 10, 10));
			principale.setHgap(10); 
			principale.setVgap(10);
			principale.setAlignment(Pos.CENTER);
		    
		    finestra.setTitle("Chiappece Remake Javafx Edition");
		    finestra.setScene(scena);
		    finestra.show();

			scena.getStylesheets().add("it/edu/iisgubbio/indovina/IndovinaN.css");
			principale.getStyleClass().add("principale");
			
		}
	
	
		private void eseguiProva(){
			int numeroInserito;
			String text1;
			text1=tfNInserito.getText();
			numeroInserito=Integer.parseInt(text1);
//			if (rb100.isSelected()) {
//				
//			}
//			if (rb1000.isSelected()) {
//				
//			}
//			if (rb1000.isSelected()) {
//				
//			}
			if(numeroInserito>numeroEstratto) {

				lRisultato.setText("Maggiore del numero estratto");
				numeroTentaitivi+=1;
			}
			else {
				if(numeroInserito<numeroEstratto) {

					lRisultato.setText("Minore del numero estratto");
					numeroTentaitivi+=1;
				}
				else {
					lRisultato.setText("C'hai chiappato in "+ numeroTentaitivi +" tentativi");
				}
			}
			
		}
		
		public static void main(String[] args) {
		    launch(args);
	}

}
