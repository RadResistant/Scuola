package it.edu.iisgubbio.hotel;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import jakarta.persistence.NamedQuery;
@CrossOrigin
@RestController
public class Manager {
	@Autowired
	HotelRepository archivioHotel;
	@Autowired
	StanzaRepository archivioStanze;
	@GetMapping("/hotel")
	public List<Hotel> trovaTuttiHotel(){
		return archivioHotel.findAll();
	}
	@GetMapping("/stanze")
	public List<Stanza> trovaTuttiStanze(){
		return archivioStanze.findAll();
	}
	@GetMapping("/hotel/{id}")
	public Optional<Hotel> trovaHotelId(@PathVariable int id ) {
		return archivioHotel.findById(id);
	}
	@GetMapping("/stanze/{id}")
	public Optional<Stanza> trovaStanzeId(@PathVariable int id ) {
		return archivioStanze.findById(id);
	}
	@GetMapping("/stanza")
	public List<Stanza> trovaPerNome(@RequestParam (required=true) String nome){
		Stanza stanza=new Stanza();
		stanza.setNome(nome);
		Example<Stanza> ese=Example.of(stanza);
		return archivioStanze.findAll(ese);
	}
	@GetMapping("/prezzi")
	public List<Stanza> trovaPrezzo(@RequestParam double min,@RequestParam double max){
		return archivioStanze.trovaPerPrezzi(min,max);		
	}
	@PostMapping("/hotel")
    public void inserisciHotel(@RequestBody Hotel hotel) {
        archivioHotel.save(hotel);
    }
	@PostMapping("/stanze")
    public void inserisciStanza(@RequestBody Stanza stanza) {
        archivioStanze.save(stanza);
    }
	@PutMapping("hotel/{id}")
    public void modificaStanze( @PathVariable int id, @RequestBody Hotel hotelDato ) {
        Optional<Hotel> hotelTrovato = archivioHotel.findById(id);
        if(hotelTrovato.isPresent()) {
            Hotel hotel = hotelTrovato.get();
            hotel.setNome(hotelDato.getNome());
            hotel.setTelefono(hotelDato.getTelefono());
            hotel.setProvincia(hotelDato.getProvincia());
            hotel.setStanze(hotelDato.getStanze());
            archivioHotel.save(hotel);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
	@PutMapping("stanze/{id}")
    public void modificaStanza( @PathVariable int id, @RequestBody Stanza stanzaData ) {
        Optional<Stanza> stanzaTrovata = archivioStanze.findById(id);
        if(stanzaTrovata.isPresent()) {
            Stanza stanza = stanzaTrovata.get();
            stanza.setNome(stanzaData.getNome());
            stanza.setPrezzo(stanzaData.getPrezzo());
            stanza.setHotel(stanzaData.getHotel());
            archivioStanze.save(stanza);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
	@DeleteMapping("hotel/{id}")
	public void cancellaHotel(@PathVariable int id) {
		archivioHotel.deleteById(id);
	}
	@DeleteMapping("stanze/{id}")
	public void cancellaStanza(@PathVariable int id) {
		archivioStanze.deleteById(id);
	}	
}