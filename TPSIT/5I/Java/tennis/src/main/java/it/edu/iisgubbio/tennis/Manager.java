package it.edu.iisgubbio.tennis;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
@CrossOrigin
@RestController
public class Manager{
	@Autowired
	CampoRepository archivioCampi;
	@Autowired
	GiocatoreRepository archivioGiocatori;
	@Autowired
	PrenotazioneRepository archivioPrenotazioni;
	@GetMapping("/campi")
	public List<Campo> trovaCampiTutti(@RequestParam Integer ora){
		if(ora==null){
			return archivioCampi.findAll();
		}
		else{
			return archivioCampi.trovaPerOra(ora);
		}
	}
	@GetMapping("/campo/{id}/prenotazioni")
	public List<Prenotazione> trovaPerData(@PathVariable Integer id,@RequestParam (required=true) String data, @RequestParam String oraInizio, @RequestParam String oraFine){
		if(oraInizio==null){
			oraInizio="00";
		}
		if(oraFine==null){
			oraFine="23";
		}
		return archivioPrenotazioni.trovaPrenotazioneInData(id,data,oraInizio,oraFine);
	}
	@GetMapping("/giocatore")
	public List<Giocatore> trovaPerAnagrafica(@RequestParam (required=false) String nome, @RequestParam (required=false) String cognome){
		if(nome!=null && cognome==null){
			return archivioGiocatori.trovaPerNome(nome);
		}
		else{
			if(nome==null && cognome!=null){
				return archivioGiocatori.trovaPerCognome(cognome);
			}
			else{
				return archivioGiocatori.findAll();
			}
		}
	}
	@PostMapping("/giocatore")
	public void inserisciGiocatore(@RequestBody Giocatore giocatore) {
		archivioGiocatori.save(giocatore);
	}
	@PostMapping("/campo/{id}/prenotazione")
	public void inserisciPrenotazione(@PathVariable Integer id, @RequestBody Prenotazione prenotazione){
		Campo campo=archivioCampi.findById(id).orElseThrow(() -> new RuntimeException("Campo non trovato"));;
		if(campo==null){
			return;
		}
		Prenotazione nuovaPrenotazione=new Prenotazione();
		nuovaPrenotazione.setCampo_id(campo.getId());
        archivioPrenotazioni.inserisciPrenotazione(prenotazione);
    }
}