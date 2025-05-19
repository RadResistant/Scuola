package it.edu.iisgubbio.saponaroraffaele;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface PrestitoRepository extends JpaRepository<Prestito,Integer>{
    @Query(value="SELECT * FROM prestito WHERE prestito.cf=:cf;", nativeQuery=true)
    List<Prestito> findByCF(@Param("cf") String cf);
}