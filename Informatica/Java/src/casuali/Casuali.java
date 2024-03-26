package casuali;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Casuali  extends Application {
		Label lPari = new Label("Pari");
		Label lDispari = new Label("Dispari");
		Label lNumeroPari = new Label();
		Label lNumeroDispari = new Label();
		Label lSommaPari = new Label("Somma");
		Label lSommaDispari = new Label("Somma");
		Label lRisultatoPari = new Label();
		Label lRisultatoDispari = new Label();
		Label lMaggPari = new Label("Maggiore pari");
		Label lMaggDispari = new Label("Maggiore dispari");
		Label lMaggNPari = new Label();
		Label lMaggNDispari = new Label();
		Label lMinPari = new Label("Minore pari");
		Label lMinDispari = new Label("Minore dispari");
		Label lMinNPari = new Label();
		Label lMinNDispari = new Label();
		Button bProva = new Button("Calcola");
	public void start(Stage finestra) throws Exception {
			bProva.setOnAction(e -> eseguiCal());		
			GridPane principale = new GridPane();
			principale.add(lPari, 0,0);
			principale.add(lDispari, 1,0);
			principale.add(lNumeroPari, 0,1);
			principale.add(lNumeroDispari, 1,1);
			principale.add(lSommaPari, 0,2);
			principale.add(lSommaDispari, 1,2);
			principale.add(lRisultatoPari, 0,3);
			principale.add(lRisultatoDispari, 1,3);
			principale.add(bProva, 0,6,2,1);
			principale.add(lMinPari, 0,4);
			principale.add(lMinNPari, 0,5);
			principale.add(lMinDispari, 1,4);
			principale.add(lMinNDispari, 1,5);
			Scene scena = new Scene(principale,400,300);
			principale.setPadding(new Insets(10, 10, 10, 10));
			principale.setHgap(10); 
			principale.setVgap(10);
			principale.setAlignment(Pos.CENTER);
			bProva.setMaxSize(500,500);
		    finestra.setTitle("10 Casuali");
		    finestra.setScene(scena);
		    finestra.show();
		}	
		private void eseguiCal(){
			int pari=0,dispari=0,minoreP=1000,minoreD=1001;
			String elencoPari="",elencoDispari="";
			for(int i=1;i<=10; i++){
				int estratto = (int)(Math.random()*100)+1;
				if(estratto%2==0) {
					pari+=estratto;
					elencoPari+=" "+estratto;
					if (minoreP>estratto) {
						minoreP=estratto;
						
					}
				}
				else {
					dispari+=estratto;
					elencoDispari+=" "+estratto;
					if (minoreD>estratto) {
						minoreD=estratto;
					}	
				}	
			}
			lNumeroPari.setText(elencoPari);
			lNumeroDispari.setText(elencoDispari);
			lRisultatoPari.setText(""+pari);
			lRisultatoDispari.setText(""+dispari);
			lMinNPari.setText(""+minoreP);
			lMinNDispari.setText(""+minoreD);	
		}		
		public static void main(String[] args) {
		    launch(args);
	}

}
