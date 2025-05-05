package it.edu.iisgubbio.tennis;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PrenotazioneRepository extends JpaRepository<Campo,Integer>{
	@Query(
        value="SELECT * FROM prenotazione WHERE prenotazione.campo_id=:id and prenotazione.data=:data;",
        nativeQuery=true
    )
    List<Prenotazione> trovaPrenotazioneInData(@Param("id") Integer id,@Param("data") String data);
}