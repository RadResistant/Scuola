package mobilita.mobilita;

public class Skateboard extends AMuscoli{
	private int lunghezza;
	public Skateboard(String nome,double costo) {
		this.nome=nome;
		this.costo=costo;
	}
	public Skateboard(String nome,double costo,int lunghezza) {
		this.nome=nome;
		this.costo=costo;
		this.lunghezza=lunghezza;
	}
	@Override
	public String toString() {
		if (longboard()) {
			return "Skateboard longboard: lungo " + lunghezza + "cm costa: " + costo + "€";
		}
		else {
			return "Skateboard: lungo " + lunghezza + "cm costa: " + costo + "€";
		}
	}
	public boolean longboard() {
		return lunghezza>80;
	}
	public int getLunghezza() {
		return lunghezza;
	}
	public void setLunghezza(int lunghezza) {
		this.lunghezza = lunghezza;
	}
}
