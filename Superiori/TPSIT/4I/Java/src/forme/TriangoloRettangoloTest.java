package forme;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TriangoloRettangoloTest {
	TriangoloRettangolo nomeOggetto=new TriangoloRettangolo(1,1);
	@Test
	void testArea() {
		assertEquals(0.5, nomeOggetto.calcolaArea(),"Area");
	}
	@Test
	void testIpotenusa() {
		assertEquals(1.4142135623730951, nomeOggetto.calcolaIpotenusa(),"Ipotenusa");
	}
	@Test
	void testPerimetro() {
		assertEquals(3.4142135623730951, nomeOggetto.calcolaPerimetro(),"Perimetro");
	}
}