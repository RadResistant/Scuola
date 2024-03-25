package persona;

public class ProvaPersone {
	public static void main(String[] args) {
		System.out.println("ciao");	
		Persona mario;
		mario=new Persona("Mario","Rossi",2005);
		System.out.println(mario.eta(2023));
		Studente anna=new Studente("Anna","Bianchi","1I",2009, 2022);
		Voto nuovoVoto= new Voto("matematica",8);
		anna.aggiungiVoto(nuovoVoto);
		anna.aggiungiVoto(new Voto("italiano",9));
		System.out.println(mario.eta(2023));
		System.out.println(anna.eta(2023));
		System.out.print(anna.mediaVoti());
		System.out.print(anna.promosso());
	}
	

}
