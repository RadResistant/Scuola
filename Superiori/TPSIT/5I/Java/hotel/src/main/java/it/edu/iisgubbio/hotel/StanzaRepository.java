package it.edu.iisgubbio.hotel;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface StanzaRepository extends JpaRepository<Stanza,Integer>{
	@Query(value="SELECT * FROM stanza WHERE prezzo>:min AND prezzo<:max;", 
       nativeQuery=true)
    List<Stanza> trovaPerPrezzi(@Param("min") Double min,@Param("max") Double max);
}