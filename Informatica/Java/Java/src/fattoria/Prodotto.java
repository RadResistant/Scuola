package it.fattoria;

public class Prodotto {
	protected String nome;
	protected double prezzo;
	public Prodotto(double x, String n) {
		this.prezzo=x;
		this.nome=n;
	}
	public Prodotto() {
		
	}
	public String toString() {
		return "prodotto"+nome+", "+prezzo+"€/kg";
	}
	public double calcolaPrezzo(double peso) {
		return prezzo*peso;
	}
}
