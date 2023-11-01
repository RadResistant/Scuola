package it.edu;


public class Studente extends Persona {
	String classe;
	int annoIscrizione;
	Voto voti[];
	int postoVoto=0;
	public Studente(String nome, String cognome, String classe, int anno, int annoIsc) {
		super(nome, cognome, anno);
		this.classe = classe;
		annoIscrizione = annoIsc;
		voti= new Voto[100];
	
	}
	public void aggiungiVoto(Voto k) {
		voti[postoVoto]=k;
		postoVoto++;
	}

	public double mediaVoti() {
		double media=0;
		for(int y=0; y<postoVoto;y++) {
			media=media+voti[y].punteggio;
		}
		media/=postoVoto-1;
		return media;
	}
	public boolean promosso() {
//		boolean promosso=true;
//		for (int i=0;i>postoVoto;i++) {
//			if (voti[i].punteggio<6) {
//				promosso=false;
//			}
//		}
//		return promosso;
//		if(mediaVoti()<6) {
//			return false;
//		}
//		else {
//			return true;
//		}
		return mediaVoti()>=6;
	}
}
