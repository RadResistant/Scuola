package mobilita.proveMobilita;
import mobilita.mobilita.Barca;
import mobilita.mobilita.Bicicletta;
import mobilita.mobilita.MezzoDiTrasporto;
import mobilita.mobilita.Skateboard;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class Rimessa extends Application{
	TextField tfNome=new TextField();
	TextField tfCosto=new TextField();
	TextField tfVarie=new TextField();
	Button bBarca=new Button("Barca");
	Button bMT=new Button("MT");
	Button bBici=new Button("Bici");
	Button bSkate=new Button("Skate");
	Label lPrint=new Label();
	RadioButton rbSi=new RadioButton("Si (solo per Barche)");
	RadioButton rbNo =new RadioButton("No");
	ToggleGroup tgBarca=new ToggleGroup();
	boolean remi=true;
	String nomeBarca="",nomeSkate="",nomeBici="",nomeMT="";
	double costoBarca=0,costoSkate=0,costoBici=0,costoMT=0;
	int numRap=0,numeroRemi=0,lunghezza=0;
	double peso=0;
	Barca baBarca=new Barca(nomeBarca,costoBarca,numeroRemi,remi);
	MezzoDiTrasporto mtMacchina=new MezzoDiTrasporto(nomeMT,costoMT);
	Bicicletta bcBici=new Bicicletta(numRap,peso,costoMT);
	Skateboard sSkate=new Skateboard(nomeSkate,costoSkate,lunghezza);
	public void start(Stage primaryStage) throws Exception {
		rbNo.setToggleGroup(tgBarca);
		rbSi.setToggleGroup(tgBarca);
		rbSi.setSelected(true);
		tfNome.setPromptText("Nome");
		tfCosto.setPromptText("Costo");
		tfVarie.setPromptText("Varie");
		GridPane gP=new GridPane();
		gP.add(tfNome, 0, 0,2,1);
		gP.add(tfCosto, 0, 1,2,1);
		gP.add(tfVarie, 0, 2,2,1);
		gP.add(bBarca, 0, 3);
		gP.add(bBici, 1, 3);
		gP.add(bMT, 0, 4);
		gP.add(bSkate, 1, 4);
		gP.add(rbSi, 0,5);
		gP.add(rbNo, 1,5);
		gP.add(lPrint, 0, 6,2,1);
		gP.setPadding(new Insets(10,10,10,10));
		gP.setHgap(10);
		gP.setVgap(10);
		gP.setAlignment(Pos.CENTER);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Garage");
		primaryStage.setScene(scena);
		primaryStage.show();
		bBarca.setOnAction(e-> eBarca());
		bBici.setOnAction(e-> eBici());
		bSkate.setOnAction(e-> eSkate());
		bMT.setOnAction(e-> eMT());
	}
	private void eMT() {
		nomeMT=tfNome.getText();
		costoMT=Integer.parseInt(tfCosto.getText());
	}
	private void eSkate() {
		nomeSkate=tfNome.getText();
		costoSkate=Integer.parseInt(tfCosto.getText());
		lunghezza=Integer.parseInt(tfVarie.getText());
	}
	private void eBici() {
		peso=Integer.parseInt(tfNome.getText());
		costoBici=Integer.parseInt(tfCosto.getText());
		numRap=Integer.parseInt(tfVarie.getText());
	}
	private void eBarca() {
		nomeBarca=tfNome.getText();
		costoBarca=Integer.parseInt(tfCosto.getText());
		numeroRemi=Integer.parseInt(tfVarie.getText());
		if(rbSi.isSelected()) {
			remi=true;
		}
		else {
			remi=false;
		}
	}
	public static void main(String[] args) {
		launch(args);
	}
}
