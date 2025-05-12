package it.edu.iisgubbio.tennis;
import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
public interface PrenotazioneRepository extends JpaRepository<Prenotazione,Integer>{
	@Query(
        value="SELECT * FROM prenotazione WHERE prenotazione.campo_id=:id AND prenotazione.data=:data AND ora_inizo=:oraInizio AND ora_fine=:oraFine;",
        nativeQuery=true
    )
    List<Prenotazione> trovaPrenotazioneInData(@Param("id") Integer id,@Param("data") String data, @Param("oraInizio") String oraInizio, @Param("oraFine") String oraFine);
    // @Query(value="INSERT INTO prenotazione(campo_id,giocatore_id,data,ora_inizio,ora_fine) VALUES (:idCampo,:idGiocatore,:data,:oraInizio,:oraFine)", nativeQuery=true)
}