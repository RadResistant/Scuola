package it.edu.iisgubbio.todo;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface ToDoRepository extends JpaRepository<ToDo, Integer>{
    @Query(value="SELECT todo.* "+
            "FROM todo "+
            "WHERE todo.cosa ILIKE :parte", 
       nativeQuery=true)
    List<ToDo> cerca(@Param("parte") String parteDelCosa);
}