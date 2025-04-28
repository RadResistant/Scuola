package it.edu.iisgubbio.tennis;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class Manager{
	@Autowired
	CampoRepository archivioCampi;
	@Autowired
	GiocatoreRepository archivioGiocatori;
	@Autowired
	PrenotazioneRepository archivioPrenotazioni;
	@GetMapping("/tennis/campi")
	public List<Campo> trovaCampiTutti(){
		return archivioCampi.findAll();
	}
	@GetMapping("/tennis/campo/{id}/prenotazioni")
	public List<Campo> trovaperdata(@PathVariable Integer id,@RequestParam (required=true) String data){
		return archivioCampi.trovaPrenotazioneInData(id,data);
	}
}