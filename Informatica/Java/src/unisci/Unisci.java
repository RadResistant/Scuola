package unisci;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Unisci extends Application{
	TextField tfInsieme1=new TextField();
	TextField tfInsieme2=new TextField();
	Button bUnisci=new Button("Unisci");
	Label lRis=new Label();
	public void start(Stage primaryStage) throws Exception {
		tfInsieme1.setPromptText("Insieme 1");
		tfInsieme2.setPromptText("Insieme 2");
		GridPane gP = new GridPane();
		gP.add(tfInsieme1, 0, 0);
		gP.add(tfInsieme2,0, 1);
		gP.add(bUnisci,0, 2);
		gP.add(lRis, 0, 3);
		gP.setPadding(new Insets(10,10,10,10));
		gP.setHgap(10);
		gP.setVgap(10);
		gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Unisci");
		primaryStage.setScene(scena);
		primaryStage.show();
		bUnisci.setOnAction(e-> eUnisci());
	}
	private void eUnisci() {
		String sIns1[]=tfInsieme1.getText().trim().split(" ");
		String sIns2[]=tfInsieme2.getText().trim().split(" ");
		int iIns1[]=new int[sIns1.length];
		int iIns2[]=new int[sIns2.length];
		int uni[]=new int[sIns1.length+sIns2.length];
		for (int o=0;o<sIns1.length;o++) {
			iIns1[o]=Integer.parseInt(sIns1[o]);
		}
		for (int u=0;u<sIns2.length;u++) {
			iIns2[u]=Integer.parseInt(sIns2[u]);
		}
		for(int i=0;i<iIns1.length;i++) {
			uni[i]=iIns1[i];
		}
		for(int i=0;i<iIns2.length;i++) {
			uni[i+iIns1.length]=iIns2[i];
		}
		
		for(int v=0;v<uni.length;v++) {
			for(int z=0;z<uni.length;z++) {
				if(uni[v]==uni[z] && z!=v) {
					uni[z]=0;
				}
			}
		}
		String resp="";
		for(int p=0;p<uni.length;p++) {
			if(uni[p]!=0){
				resp+=uni[p]+" ";
			}
		}
		lRis.setText(resp);
	}
	public static void main(String[] args) {
		launch(args);
	}
}
