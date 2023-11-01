package it.edu.iisgubbio.figuregeometriche;

public class OggettiGeo extends Object{
	public static void main(String[] args) {
	 Rettangolo libro = new Rettangolo(20,30);
     System.out.println(libro);

     Rettangolo tovaglia = new Rettangolo(200,300);
     int pTovaglia = tovaglia.perimetro();
     System.out.println("il perimetro della tvaglia è: "+pTovaglia+"cm");
     int aTovaglia = tovaglia.area()/100/100;
     System.out.println("l'area della tovaglia è: "+aTovaglia+"mq");
	}
}
