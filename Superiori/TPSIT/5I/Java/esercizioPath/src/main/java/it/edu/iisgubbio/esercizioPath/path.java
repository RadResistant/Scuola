package it.edu.iisgubbio.esercizioPath;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class path {
	@GetMapping("scuola")
	public String scuola() {
		return "IIS Cassata-Gattapone";
	}
	@GetMapping("indirizzo")
	public String indirizzo(@RequestParam String comune,@RequestParam String regione) {
		return "Il comune di "+comune+" è in "+regione;
	}
	@GetMapping("/animale/{id}")
	public String animale(@PathVariable int id) {
		String[] animali={"Gatto","Cane","Pollo","Serpente"};
		return animali[id];	
	}
	@GetMapping("insetto")
	public String insetto(@RequestParam(required=false, defaultValue="6") int zampe) {
		return "L'insetto ha "+zampe+" zampe";
	}
}