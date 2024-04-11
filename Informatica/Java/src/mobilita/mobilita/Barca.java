package mobilita.mobilita;

public class Barca extends AMuscoli{
	private int numeroDiRemi;
	private boolean singoloRemo;
	public Barca (String nome, double costo,int numeroDiRemi,boolean singoloRemo){
		this.nome=nome;
		this.costo=costo;
		this.numeroDiRemi=numeroDiRemi;
		this.singoloRemo=singoloRemo;
	}
	@Override
	public String toString() {
		if (singoloRemo) {
			return "Barca: "+nome+"con " + numeroDiRemi + " remi";
		}
		else {
			return "Barca: "+nome+"con " + numeroDiRemi + " remi (2 per vogatore)";
		}
	}
	public int getNumeroDiRemi() {
		return numeroDiRemi;
	}
	public boolean isSingoloRemo() {
		return singoloRemo;
	}  
	public int numeroVogatori() {
		if(singoloRemo) {
			return numeroDiRemi;
		} 
		else {
			return numeroDiRemi/2;
		}
	}
}
