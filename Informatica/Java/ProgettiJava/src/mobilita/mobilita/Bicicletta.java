package mobilita.mobilita;

public class Bicicletta extends AMuscoli {
	private int numeroDiRapporti;
	private double peso;
	public Bicicletta(int x,double y,double c) {
		this.peso=y;
		this.numeroDiRapporti=x;
		this.costo=c;
	}
	@Override
	public String toString() {
		if(peso<10) {
			return "Bicicletta: pesa"+ peso + "kg (leggera) costa"+ costo +" (ha "+ numeroDiRapporti +" rapporti)";
		}
		else {
			return "Bicicletta: pesa"+ peso + "kg (pesante) costa"+ costo +" (ha "+ numeroDiRapporti +" rapporti)";
		}
		
	}
	public boolean leggera() {
		return peso<20;
	}
	public int getNumeroDiRapporti() {
		return numeroDiRapporti;
	}
	public void setNumeroDiRapporti(int numeroDiRapporti) {
		this.numeroDiRapporti = numeroDiRapporti;
	}
	public double getPeso() {
		return peso;
	}
	public void setPeso(double peso) {
		this.peso = peso;
	}
	
}
