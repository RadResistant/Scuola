package it.edu.iisgubbio.tpsit.processi;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
public class ProvaProcessi extends Application{
	Label lInizio=new Label("Insert all values separeted by comma(,)");
	Label lProcesses=new Label("Processes name:");
	TextField tfProcesses=new TextField();
	Label lArrivalTime=new Label("Arrival Time:");
	TextField tfArrivaltime=new TextField();
	Label lExecutionTime=new Label("Execution Time:");
	TextField tfExecutionTime=new TextField();
	Button bFcfs=new Button("Fcfs");
	Button bSjf=new Button("Sjf");
	Button bRR=new Button("Round Robin");
	Label lProcessesOrder=new Label();
	Label lServiceTime=new Label();
	public void start(Stage primaryStage) throws Exception {
		lArrivalTime.setMaxWidth(Double.MAX_VALUE);
		lExecutionTime.setMaxWidth(Double.MAX_VALUE);
		lInizio.setMaxWidth(Double.MAX_VALUE);
		lProcesses.setMaxWidth(Double.MAX_VALUE);
		lProcessesOrder.setMaxWidth(Double.MAX_VALUE);
		lServiceTime.setMaxWidth(Double.MAX_VALUE);
		bFcfs.setMaxWidth(Double.MAX_VALUE);
		bSjf.setMaxWidth(Double.MAX_VALUE);
		bRR.setMaxWidth(Double.MAX_VALUE);
		GridPane gP=new GridPane();
		gP.add(lInizio,0,0,2,1);
		gP.add(lProcesses, 0, 1);
		gP.add(tfProcesses, 1, 1);
		gP.add(lArrivalTime, 0, 2);
		gP.add(tfArrivaltime, 1, 2);
		gP.add(lExecutionTime, 0, 3);
		gP.add(tfExecutionTime, 1, 3);
		gP.add(bFcfs, 0, 4);
		gP.add(bSjf, 1, 4);
		gP.add(bRR, 0, 5);
		gP.add(lProcessesOrder, 0, 6,2,1);
		gP.add(lServiceTime, 0, 7,2,1);
		Scene scena = new Scene(gP);
		primaryStage.setTitle("Processi");
		primaryStage.setScene(scena);
		primaryStage.show();
		bFcfs.setOnAction(e-> eFcfs());
		bSjf.setOnAction(e-> eSjf());
		bRR.setOnAction(e-> eRR());
	}
	private void eFcfs() {
	}
	private void eSjf() {
	}
	private void eRR() {
	}
	public static void main(String[] args) {
		launch(args);
	}
}
