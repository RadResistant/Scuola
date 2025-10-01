package memory;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Memory extends Application{
	GridPane gP=new GridPane();
	Scene scena;
	Button bStart=new Button("Start");
	Button bCaselle[][];
	int iNumeri []= {0,0,1,1,2,2,3,3,4,4,5,5,6,6,7,7,8,8,9,9};
	int mNumeri[][];
	public void start(Stage primaryStage) throws Exception {
		gP.add(bStart, 0, 0);
		gP.setPadding(new Insets(10,10,10,10));
		gP.setHgap(10);
		gP.setVgap(10);
		gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP,193,145);
		primaryStage.setTitle("Memory");
		primaryStage.setScene(scena);
		primaryStage.show();
		bStart.setOnAction(e-> eStart());
	}
	private void eStart() {
		gP.getChildren().remove(bStart);
		int cont=0;
		for(int p=0;p<iNumeri.length;p++) {
			int random=(int)(Math.random()*20);
			cont=iNumeri[p];
			iNumeri[p]=iNumeri[random];
			iNumeri[random]=cont;
		}
		int hiv=20;
		int inc=0;
		mNumeri=new int[4][5];
		for(int r=0;r<4;r++) {
			for(int c=0;c<5;c++) {
				hiv--;
				mNumeri[r][c]=iNumeri[inc];
				inc++;
			}
		}
		bCaselle=new Button[4][5];
		for(int r=0;r<4;r++) {
			for(int c=0;c<5;c++) {
				bCaselle[r][c] = new Button(mNumeri[r][c]+"");
				gP.add(bCaselle[r][c], c, r);
			}
		}	
	}
	public static void main(String[] args) {
		launch(args);
	}
}
