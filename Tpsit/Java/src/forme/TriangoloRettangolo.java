package forme;

public class TriangoloRettangolo {
	double base;
	double altezza;
	TriangoloRettangolo (double base,double altezza) {
		this.base=base;
		this.altezza=altezza;
	}
	double calcolaArea () {
		return (base*altezza)/2;
	}
	double calcolaPerimetro () {
		return base+altezza+this.calcolaIpotenusa();
	}
	double calcolaIpotenusa() {
		return Math.sqrt(Math.pow(base,2)+Math.pow(altezza,2));
	}
}
