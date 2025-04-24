package it.edu.iisgubbio.tennis;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
public class Prenotazione {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	Integer ora_inizio;
	Integer ora_fine;
	String data;
	Integer campo_id;
	Integer giocatore;
}