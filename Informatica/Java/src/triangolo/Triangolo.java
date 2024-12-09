package triangolo;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Triangolo extends Application {
		Label lLato1 = new Label("Lato 1:");
		Label lLato2 = new Label("Lato 2:");
		Label lLato3 = new Label("Lato 3:");
		Label lTipo = new Label();
		TextField tfLato1 = new TextField();
		TextField tfLato2 = new TextField();
		TextField tfLato3 = new TextField();
		Button bTipo = new Button("Tipo Triangolo");
		
	public void start(Stage finestra) throws Exception {
			
			bTipo.setOnAction(e -> eseguiTriangolo());
			lTipo.setMaxSize(500,500);
		    bTipo.setMaxSize(500,500);
			GridPane principale = new GridPane();

			principale.add(lTipo, 0,4,2,1);
			principale.add(lLato1, 0,0);
			principale.add(lLato2, 0,1);
			principale.add(lLato3, 0,2);
			principale.add(tfLato1, 1,0);
			principale.add(tfLato2, 1,1);
			principale.add(tfLato3, 1,2);
			principale.add(bTipo, 0,3,2,1);
		    Scene scena = new Scene(principale);
		    scena.getStylesheets().add("it/edu/iisgubbio/triangolo/Triangolo.css");
			principale.setAlignment(Pos.CENTER);
			principale.setPadding(new Insets(10, 10, 10, 10));
			principale.setHgap(10); 
			principale.setVgap(10);
		    
		    finestra.setTitle("É n triangolo?");
		    finestra.setScene(scena);
		    finestra.show();

			principale.getStyleClass().add("principale");
			
		}
	
	
		private void eseguiTriangolo(){
			int l1,l2, l3;
			l1=Integer.parseInt(tfLato1.getText());
			l2=Integer.parseInt(tfLato2.getText());
			l3=Integer.parseInt(tfLato3.getText());
			if(l1+l2<l3 || l1+l3<l2 || l3+l3<l1 ) { 
				lTipo.setText("Non è un triangolo");
				}
			else {
				if(l1==l2 && l3==l2) { 
				lTipo.setText("Triangolo equilatero");
				
				}
				else {
						if(l1==l2 && l1!=l3|| l1==l3&& l1!=l2 || l2==l3 && l2!=l1) {
							if(l1*l1 + l2*l2==l3*l3 || l1*l1 + l3*l3==l2*l2 || l3*l3 + l2*l2==l1*l1) {
								lTipo.setText("Triangolo rettangolo isoscele");
							}
							else {
								lTipo.setText("Triangolo isoscele");
							}
						}
						else {
							if(l1*l1 + l2*l2==l3*l3 || l1*l1 + l3*l3==l2*l2 || l3*l3 + l2*l2==l1*l1 ) {
								lTipo.setText("Triangolo rettangolo scaleno");
							}
							else {
								lTipo.setText("Triangolo scaleno");
							}
						}
					}
				}
			}
		
		public static void main(String[] args) {
		    launch(args);
	}

}
