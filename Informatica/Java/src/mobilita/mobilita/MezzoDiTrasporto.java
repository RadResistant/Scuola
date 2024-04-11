package mobilita.mobilita;

public class MezzoDiTrasporto {
	protected double costo;
	protected String nome;
	public MezzoDiTrasporto() {
	}
	public MezzoDiTrasporto(String nome, double costo) {
		this.costo = costo;
		this.nome = nome;
	}
	public String toString() {
		return "Mezzo Di Trasporto: "+nome+", costa: "+costo+"€";
	}
	public double getCosto() {
		return costo;
	}
	public void setCosto(double costo) {
		this.costo = costo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public double importoRata(int numerorate) {
		return costo/numerorate;
	}
}