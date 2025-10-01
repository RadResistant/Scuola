package gioco;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.util.Duration;
public class Gioco extends Application {
	Button bStart = new Button("Start");
	Button bRestart = new Button("Restart");
	Pane pFloor = new Pane();
	Timeline tlDamageS = new Timeline();
	Timeline tlDamageW = new Timeline();
	Timeline tlMovementZ = new Timeline();
	Timeline tlBullet = new Timeline();
	Image iSoldier = new Image(getClass().getResourceAsStream("Soldier.png"));
	ImageView ivSoldier = new ImageView(iSoldier);
	Image iZombie = new Image(getClass().getResourceAsStream("Zombie.png"));
	ImageView ivZombie[] = new ImageView[40];
	Image iWall = new Image(getClass().getResourceAsStream("Wall.png"));
	ImageView ivWall = new ImageView(iWall);
	Image iFullHP = new Image(getClass().getResourceAsStream("MaxHP.png"));
	ImageView ivFullHP = new ImageView(iFullHP);
	Image iAverageHP = new Image(getClass().getResourceAsStream("AverageHP.png"));
	ImageView ivAverageHP = new ImageView(iAverageHP);
	Image iHalfHP = new Image(getClass().getResourceAsStream("HalfHP.png"));
	ImageView ivHalfHP = new ImageView(iHalfHP);
	Image iMinHP = new Image(getClass().getResourceAsStream("MinHP.png"));
	ImageView ivMinHP = new ImageView(iMinHP);
	Image iNoHP = new Image(getClass().getResourceAsStream("NoHP.png"));
	ImageView ivNoHP = new ImageView(iNoHP);
	Image iEmpityHeart1 = new Image(getClass().getResourceAsStream("EmpityHeart.png"));
	ImageView ivEmpityHeart1 = new ImageView(iEmpityHeart1);
	Image iEmpityHeart2 = new Image(getClass().getResourceAsStream("EmpityHeart.png"));
	ImageView ivEmpityHeart2 = new ImageView(iEmpityHeart2);
	Image iEmpityHeart3 = new Image(getClass().getResourceAsStream("EmpityHeart.png"));
	ImageView ivEmpityHeart3 = new ImageView(iEmpityHeart3);
	Image iFullHeart1= new Image(getClass().getResourceAsStream("FullHeart.png"));
	ImageView ivFullHeart1 = new ImageView(iFullHeart1);
	Image iFullHeart2= new Image(getClass().getResourceAsStream("FullHeart.png"));
	ImageView ivFullHeart2 = new ImageView(iFullHeart2);
	Image iFullHeart3= new Image(getClass().getResourceAsStream("FullHeart.png"));
	ImageView ivFullHeart3 = new ImageView(iFullHeart3);
	Image iBullet= new Image(getClass().getResourceAsStream("Bullet.png"));
	ImageView ivBullet[] = new ImageView[40];
	Image iGameOver= new Image(getClass().getResourceAsStream("GameOver.png"));
	ImageView ivGameOver = new ImageView(iGameOver);
	
	Label lSoldierHP=new Label("SOLDIER HP");
	Label lWallHP=new Label("WALL HP");
	Label lScoreTXT=new Label("SCORE:");
	Label lScore=new Label();
	int yS=348, yZ=(int)(Math.random()*696)+1;
	int incrementoUp=-10,incrementoDown=10;
	int Heart = 0, HP=0,score=0, DMGW=0,DMGS=0;
	boolean intersectionHeart = false,intersectionWall = false;
	double x[]= new double[40],xB=81;
	public void start(Stage finestra) throws Exception {
		lScore.setText(score+"");
		ivFullHP.setId("hp");
		ivAverageHP.setId("hp");
		ivHalfHP.setId("hp");
		ivMinHP.setId("hp");
		ivNoHP.setId("hp");
		lSoldierHP.setId("Point");
		lWallHP.setId("Point");
		lScore.setId("Score");
		lScoreTXT.setId("Score");
		bStart.setLayoutX(633);
		bStart.setLayoutY(328);
		bRestart.setLayoutX(633);
		bRestart.setLayoutY(328);
		ivSoldier.setX(81);
		ivSoldier.setY(yS);
		ivSoldier.setFitHeight(80);
		ivSoldier.setFitWidth(80);
		ivWall.setFitHeight(697);
		ivWall.setFitWidth(80);
		lWallHP.setLayoutX(150);
		lWallHP.setLayoutY(42);
		lSoldierHP.setLayoutX(100);
		lSoldierHP.setLayoutY(637);
		lScoreTXT.setLayoutX(440);
		lScore.setLayoutX(484);
		ivFullHP.setX(81);
		ivFullHP.setY(0);
		ivFullHP.setFitHeight(40);
		ivFullHP.setFitWidth(170);
		ivAverageHP.setX(81);
		ivAverageHP.setY(0);
		ivAverageHP.setFitHeight(40);
		ivAverageHP.setFitWidth(170);
		ivHalfHP.setX(81);
		ivHalfHP.setY(0);
		ivHalfHP.setFitHeight(40);
		ivHalfHP.setFitWidth(170);
		ivMinHP.setX(81);
		ivMinHP.setY(0);
		ivMinHP.setFitHeight(40);
		ivMinHP.setFitWidth(170);
		ivNoHP.setX(81);
		ivNoHP.setY(0);
		ivNoHP.setFitHeight(40);
		ivNoHP.setFitWidth(170);
		ivFullHeart1.setX(81);
		ivFullHeart1.setY(657);
		ivFullHeart1.setFitHeight(40);
		ivFullHeart1.setFitWidth(40);
		ivFullHeart2.setX(121);
		ivFullHeart2.setY(657);
		ivFullHeart2.setFitHeight(40);
		ivFullHeart2.setFitWidth(40);
		ivFullHeart3.setX(161);
		ivFullHeart3.setY(657);
		ivFullHeart3.setFitHeight(40);
		ivFullHeart3.setFitWidth(40);
		ivEmpityHeart1.setX(81);
		ivEmpityHeart1.setY(657);
		ivEmpityHeart1.setFitHeight(40);
		ivEmpityHeart1.setFitWidth(40);
		ivEmpityHeart2.setX(121);
		ivEmpityHeart2.setY(657);
		ivEmpityHeart2.setFitHeight(40);
		ivEmpityHeart2.setFitWidth(40);
		ivEmpityHeart3.setX(161);
		ivEmpityHeart3.setY(657);
		ivEmpityHeart3.setFitHeight(40);
		ivEmpityHeart3.setFitWidth(40);
		ivGameOver.setX(283);
		ivGameOver.setY(148);
		ivGameOver.setFitHeight(400);
		ivGameOver.setFitWidth(800);
		pFloor.getChildren().add(bStart);
		pFloor.getChildren().add(ivWall);
		pFloor.getChildren().add(lScoreTXT);
		pFloor.getChildren().add(lScore);
		pFloor.setPrefSize(1366, 697);
		Scene scena = new Scene(pFloor);
		scena.getStylesheets().add("gioco/Gioco.css");
		finestra.setTitle("Apocalypse Z");
		finestra.setScene(scena);
		finestra.show();
		pFloor.setId("pane");
		bStart.setOnAction(e -> eStart());
		bRestart.setOnAction(e -> eRestart());
		KeyFrame kfMovementZ = new KeyFrame(Duration.millis(1), e -> eZombie());
		tlMovementZ = new Timeline(kfMovementZ);
		tlMovementZ.setCycleCount(Timeline.INDEFINITE);
		KeyFrame kfDamageS = new KeyFrame(Duration.millis(1), e -> eDamageS());
		tlDamageS = new Timeline(kfDamageS);
		tlDamageS.setCycleCount(Timeline.INDEFINITE);
		KeyFrame kfDamageW = new KeyFrame(Duration.millis(1), e -> eDamageW());
		tlDamageW = new Timeline(kfDamageW);
		tlDamageW.setCycleCount(Timeline.INDEFINITE);
		scena.setOnKeyPressed(e->eMovimento(e));
		scena.addEventHandler(MouseEvent.MOUSE_CLICKED, e -> eBullet(e));
	}
	private void eZombie() {
		for (int i=0;i<=ivZombie.length-1;i++) {
			x[i]=x[i]-0.05;
			ivZombie[i].setX(x[i]);
		}
	}
	private void eStart() {
		pFloor.getChildren().remove(bStart);
		pFloor.getChildren().add(ivSoldier);
		pFloor.getChildren().add(ivFullHP);
		pFloor.getChildren().add(lWallHP);
		pFloor.getChildren().add(ivFullHeart1);
		pFloor.getChildren().add(ivFullHeart2);
		pFloor.getChildren().add(ivFullHeart3);
		pFloor.getChildren().add(lSoldierHP);
		tlMovementZ.play();
		tlDamageS.play();
		tlDamageW.play();
		for(int i=0;i<=ivZombie.length-1;i++) {
			ivZombie[i]=new ImageView(iZombie);
			ivZombie[i].setY(yZ-60);
			ivZombie[i].setFitHeight(60);
			ivZombie[i].setFitWidth(60);
			x[i]=(int)(Math.random()*500)+866;
			ivZombie[i].setX(x[i]);
			yZ=(int)(Math.random()*696)+1;
			ivZombie[i].setY(yZ-60);
			pFloor.getChildren().add(ivZombie[i]);
		}
		for(int i=0;i<=ivBullet.length-1;i++) {
			ivBullet[i]=new ImageView(iBullet);
			ivBullet[i].setFitWidth(10);
			ivBullet[i].setPreserveRatio(true);
			ivBullet[i].setY(yS);
			ivBullet[i].setX(xB);
			ivBullet[i].getBoundsInParent();
			pFloor.getChildren().add(ivBullet[i]);
		}
	}
	private void eBullet(MouseEvent e) {
		if(e.getButton().equals(MouseButton.SECONDARY)) {
			for(int i=0;i<=ivBullet.length-1;i++) {
				xB+=0.1;
				ivBullet[i].setX(xB);
			}
		}
	}
	private void eMovimento(KeyEvent e) {
		
		if(e.getText().equals("w")){
			yS+=incrementoUp;
		}
		if(e.getText().equals("s")){
			yS+=incrementoDown;
		}
		if(yS<1) {
			incrementoUp=0;
		}
		else {
			incrementoUp=-10;
		}
		if(yS>616) {
			incrementoDown=0;
		}
		else {
			incrementoDown=10;
		}
		ivSoldier.setY(yS);
		for(int i=0;i<=ivBullet.length-1;i++) {
			ivBullet[i].setY(yS);
		}
	}
	private void eDamageS() {
		for(int i=0;i<=ivZombie.length-1;i++) {
			if (ivSoldier.getBoundsInParent().intersects(ivZombie[i].getBoundsInParent())) {
				if (!intersectionHeart) {
					x[i]=(int)(Math.random()*500)+866;
					ivZombie[i].setX(x[i]);
					yZ=(int)(Math.random()*696)+1;
					ivZombie[i].setY(yZ-60);
					Heart++;
					intersectionHeart = true;
				}
			} 
			else {
				intersectionHeart = false;
			}
		}
		if(DMGS<=0 && DMGS<1) {
			if (Heart == 1) {
				pFloor.getChildren().remove(ivFullHeart1);
				pFloor.getChildren().add(ivEmpityHeart1);
				DMGS++;
			} 
		}
		if(DMGS<=1 && DMGS<2) {
			if (Heart == 2) {
				pFloor.getChildren().remove(ivFullHeart2);
				pFloor.getChildren().add(ivEmpityHeart2);
				DMGS++;
			} 
		}
		if(DMGS<=2 && DMGS<3) {
			if (Heart == 3) {
				pFloor.getChildren().remove(ivFullHeart3);
				pFloor.getChildren().add(ivEmpityHeart3);
				pFloor.getChildren().add(ivGameOver);
				pFloor.getChildren().add(bRestart);
				tlDamageS.stop();
				tlMovementZ.stop();
			}
		}
	}
	private void eDamageW() {
		for(int i=0;i<=ivZombie.length-1;i++) {
			if (ivWall.getBoundsInParent().intersects(ivZombie[i].getBoundsInParent())) {
				x[i]=(int)(Math.random()*500)+866;
				ivZombie[i].setX(x[i]);
				if (!intersectionWall) {
					x[i]=1326;
					yZ=(int)(Math.random()*696)+1;
					ivZombie[i].setY(yZ-60);
					HP++;
					intersectionWall = true;
				}
				else {
					intersectionWall = false;
				}
			}
			
		}

		if(DMGW<=0 && DMGW<1) {
			if (HP == 1) {
				pFloor.getChildren().remove(ivFullHP);
				pFloor.getChildren().add(ivAverageHP);
				DMGW++;
			} 
		}
		if(DMGW<=1 && DMGW<2) {
			if (HP == 2) {
				pFloor.getChildren().remove(ivAverageHP);
				pFloor.getChildren().add(ivHalfHP);
				DMGW++;
			} 
		}

		if(DMGW<=2 && DMGW<3) {
			if (HP == 3) {
				pFloor.getChildren().remove(ivHalfHP);
				pFloor.getChildren().add(ivMinHP);
				DMGW++;
			}
		}

		if(DMGW<=3 && DMGW<4) {
			if (HP == 4) {
				pFloor.getChildren().remove(ivMinHP);
				pFloor.getChildren().add(ivNoHP);
				pFloor.getChildren().add(ivGameOver);
				tlDamageW.stop();
				tlMovementZ.stop();
				pFloor.getChildren().add(bRestart);
			}
		}	
	}
	private void eRestart() {
		pFloor.getChildren().remove(bRestart);
		pFloor.getChildren().remove(ivGameOver);
		if(Heart==0) {}
		else {
			if (Heart==1) {
				pFloor.getChildren().remove(ivEmpityHeart1);
				pFloor.getChildren().add(ivFullHeart1);
			}
			else {
				if(Heart==2) {
					pFloor.getChildren().remove(ivEmpityHeart1);
					pFloor.getChildren().add(ivFullHeart1);
					pFloor.getChildren().remove(ivEmpityHeart2);
					pFloor.getChildren().add(ivFullHeart2);
				}
				else {
					pFloor.getChildren().remove(ivEmpityHeart1);
					pFloor.getChildren().add(ivFullHeart1);
					pFloor.getChildren().remove(ivEmpityHeart2);
					pFloor.getChildren().add(ivFullHeart2);
					pFloor.getChildren().remove(ivEmpityHeart3);
					pFloor.getChildren().add(ivFullHeart3);
				}
			}
		}
		if(HP==0) {}
		else {
			if (HP==1) {
				pFloor.getChildren().remove(ivAverageHP);
				pFloor.getChildren().add(ivFullHP);
			}
			else {
				if(HP==2) {
					pFloor.getChildren().remove(ivHalfHP);
					pFloor.getChildren().add(ivFullHP);
				}
				else {
					if(HP==3) {
						pFloor.getChildren().remove(ivMinHP);
						pFloor.getChildren().add(ivFullHP);
					}
					else {
						pFloor.getChildren().remove(ivNoHP);
						pFloor.getChildren().add(ivFullHP);
					}
				}
			}
		}
		HP=0;
		Heart=0;
		DMGW=0;
		DMGS=0;
		intersectionHeart=false;
		intersectionWall=false;
		for(int i=0;i<=ivZombie.length-1;i++) {
			x[i]=(int)(Math.random()*500)+866;
			ivZombie[i].setX(x[i]);
		}
		score=0;
		tlMovementZ.play();
		tlDamageS.play();
		tlDamageW.play();
	}
	public static void main(String[] args) {
		launch(args);
	}
}
