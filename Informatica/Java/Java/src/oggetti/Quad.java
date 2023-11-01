package it.edu.iisgubbio.figuregeometriche;

public class Quad {	
	public static void main(String[] args) {
		System.out.println("ciao");
		Quadrato tavolo;
		tavolo = new Quadrato(70);
		Quadrato mattonella = new Quadrato(25);
		System.out.println(tavolo.getLato());
		System.out.println(mattonella.getLato());
		tavolo.setLato(100);
		System.out.println(tavolo.getLato());
		int sTavolo= tavolo.area();
		int pTavolo = tavolo.perimetro();
		int pMattonella = mattonella.perimetro();
		System.out.println(sTavolo);
		System.out.println(pTavolo);
		System.out.println(pMattonella);
		}
}