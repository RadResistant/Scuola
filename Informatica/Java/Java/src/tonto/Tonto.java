package it.sapo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Tonto extends Application {
	Label lDom = new Label();
	Label lRis = new Label();
	CheckBox cbSi = new CheckBox("Si");
	CheckBox cbNo = new CheckBox("No");

	@Override
	public void start(Stage finestra) throws Exception {
		
		
		GridPane principale = new GridPane();
	    principale.add(bVolume, 1, 1);
	    principale.add(cbNo, 2, 1);
	    principale.add(cbSi, 3, 1);
	    principale.add(lDom, 0, 0);
	    scena = new Scene(principale);
	    
	    finestra.setTitle("Sfera Ebbasta");
	    finestra.setScene(scena);
	    finestra.show();
		
	}
