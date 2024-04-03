package forme;

public class Quadrato {
		double lato;
		Quadrato (int lato) {
			this.lato=lato;
		}
		double calcolaArea () {
			return lato*lato;
		}
		double calcolaPerimetro () {
			return lato*4;
		}
}