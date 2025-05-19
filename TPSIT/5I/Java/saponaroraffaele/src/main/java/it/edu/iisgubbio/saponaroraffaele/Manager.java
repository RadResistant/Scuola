package it.edu.iisgubbio.saponaroraffaele;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin
@RestController
public class Manager {
	@Autowired
    LibroRepository archivioLibri;
    @Autowired
    PrestitoRepository archivioPrestiti;
    @GetMapping("/libri")
    public List<Libro> trovaTutti(
        // @RequestParam (required=false) String titolo, @RequestParam (required=false) String autore, @RequestParam (required=false) String prestabile
        ){
        return archivioLibri.findAll();
    }
    @GetMapping("/libri/{id}")
    public Optional<Libro> trovaPerId(@PathVariable Integer id){
        return archivioLibri.findById(id);
    }
    @PostMapping("/libri")
    public void inserisciLibro(@RequestBody Libro libro){
        archivioLibri.save(libro);
    }
    @GetMapping("/prestiti")
    public List<Prestito> trovaPerCF(@RequestParam String cf){
        return archivioPrestiti.findByCF(cf);
    }
    @PostMapping("/libri/{id}/prestito")
    public void inserisciPrestito(@PathVariable Integer id, @RequestBody Prestito prestito){
        Libro libro=archivioLibri.findById(id).orElseThrow(() -> new RuntimeException("Libro non trovato"));
        if(libro.getPrestabile()==1){
            prestito.setLibroId(libro);
            archivioPrestiti.save(prestito);
        }
        else{
            new RuntimeException("Libro non trovato");
        }
    }
}