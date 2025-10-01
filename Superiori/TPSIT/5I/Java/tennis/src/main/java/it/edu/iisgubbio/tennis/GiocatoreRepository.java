package it.edu.iisgubbio.tennis;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface GiocatoreRepository extends JpaRepository<Giocatore,Integer>{
	@Query(value="SELECT * FROM giocatore WHERE nome=:nome",nativeQuery=true)
    List<Giocatore> trovaPerNome(@Param("nome") String nome);
	@Query(value="SELECT * FROM giocatore WHERE cognome=:cognome",nativeQuery=true)
    List<Giocatore> trovaPerCognome(@Param("cognome") String nome);
}