package it.edu.iisgubbio.figuregeometriche;

public class Rettangolo {
	private int base;
	private int altezza;
	Rettangolo (int x,int y) {
		base=x;
		altezza=y;
	}
	public String toString() {
		return "ciao";
	}
	int area () {
		int superficie=base*altezza;
		return superficie;
	}
	int perimetro () {
		return base+altezza*2;
	}
}