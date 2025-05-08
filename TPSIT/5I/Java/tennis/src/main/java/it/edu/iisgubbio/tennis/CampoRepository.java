package it.edu.iisgubbio.tennis;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface CampoRepository extends JpaRepository<Campo,Integer>{
    @Query(value="SELECT * FROM campo WHERE apertura=:ora",nativeQuery=true)
    List<Campo> trovaPerOra(@Param("ora") Integer ora);
}