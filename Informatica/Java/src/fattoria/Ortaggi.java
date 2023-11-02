package fattoria;

public class Ortaggi extends Prodotto{
	protected boolean bio;

	@Override
	public String toString() {
		return "Ortaggi [bio=" + bio + ", nome=" + nome + ", prezzo=" + prezzo + "]";
	}
	public Ortaggi(String nome,double prezzo,boolean bio) {
		super(prezzo,nome);
		this.bio=bio;
	}
}
