package it.edu.iisgubbio.tennis;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface CampoRepository extends JpaRepository<Campo,Integer>{
	@Query(
        value="SELECT * FROM campo,prenotazione WHERE campo.id=prenotazione.campo_id and campi.id=:id and data=:data;",
        nativeQuery=true
    )
    List<Campo> trovaPrenotazioneInData(@Param("id") int id,@Param("data") String data);
}