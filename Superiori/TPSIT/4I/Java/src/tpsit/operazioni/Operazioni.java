package tpsit.operazioni;

public class Operazioni{
	int n1,n2;
	public Operazioni(int x, int y){
		n1=x;
		n2=y;
	}
	public int somma() {
		return n1+n2;
	}
	public int differenza() {
		return n1-n2;
	}
	public int prodotto() {
		return n1*n2;
	}
	public int divisione() {
		return n1/n2;
	}
	public void Main(){
		Operazioni op=new Operazioni(3,4);
		System.out.print(op.somma());
		System.out.print(op.differenza());
		System.out.print(op.prodotto());
		System.out.print(op.divisione());
	}
}