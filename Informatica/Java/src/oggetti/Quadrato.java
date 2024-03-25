package oggetti;

public class Quadrato {
	private int lato;
	Quadrato (int x) {
		lato=x;
	}
	int area () {
		int superficie=lato*lato;
		return superficie;
	}
	int perimetro () {
		return lato*4;
	}
	public int getLato() {
		return lato;
	}
	public void setLato(int lato) {
		this.lato = lato;
	}
	
}