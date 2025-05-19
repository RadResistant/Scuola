package it.edu.iisgubbio.saponaroraffaele;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface LibroRepository extends JpaRepository<Libro,Integer>{
    // @Query(
    //     value="SELECT * FROM libro WHERE libro.titolo :titolo AND libro.autore :autore AND libro.prestabile :prestabile;",
    //     nativeQuery=true
    // )
    // List<Libro> trovaTuttiLibri(@Param("titolo") String titolo,@Param("autore") String autore, @Param("prestabile") String prestabile);
}