package classe3I;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class CiaoMondo extends Application {
  Button pSaluto = new Button(); 
  Button pPluto = new Button();
  Button p3i = new Button();
  Button pInfo = new Button();
  Label l3I4 = new Label();
  Label lCiao = new Label();
  public void start(Stage finestra) {
    pSaluto.setText("Saluta!");
    pPluto.setText("Pluto");
    p3i.setText("3i");
    pInfo.setText("Info");
    l3I4.setText("314");
    lCiao.setText("Ciao");
    pSaluto.setOnAction(e -> esegui());
    pPluto.setOnAction(e -> eseguip());
    p3i.setOnAction(e -> eseguic());
    pInfo.setOnAction(e -> eseguii());
    GridPane principale = new GridPane();
    principale.add(pSaluto, 0, 0);
    principale.add(pPluto, 1, 1);
    principale.add(p3i, 2, 0);
    principale.add(pInfo, 2, 1);
    principale.add(l3I4, 1, 0);
    principale.add(lCiao, 0, 1);
    Scene scena = new Scene(principale, 300, 250);
    finestra.setTitle("Hello World!");
    finestra.setScene(scena);
    finestra.show();
  }
  private void esegui(){
    pSaluto.setText("Ciao Mondo!");
  }
  private void eseguip(){
	pPluto.setText("Pippo");
  }
  private void eseguic(){
	p3i.setText("Informatico");
  }
  private void eseguii(){
	pInfo.setText("rmatico");
  }
  public static void main(String[] args) {
    launch(args);
  }
}