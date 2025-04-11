package it.edu.iisgubbio.hotel;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
@RestController
public class Manager {
	@Autowired
	HotelRepository archivioHotel;
	@Autowired
	StanzaRepository archivioStanze;
	@GetMapping("/hotel")
	public List<Hotel> trovaTutti(){
		return archivioHotel.findAll();
	}
}