package it.edu.iisgubbio.todo;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
@RestController
public class ToDoManager {
    @Autowired
    ToDoRepository repoToDo;
    @GetMapping("/esempio1")
    public List<ToDo> elenco() {
        List<ToDo> k = repoToDo.findAll();
        return k;
    }
    @GetMapping("/todos")
    public List<ToDo> cerca(
        @RequestParam(required = false) String lista,
        @RequestParam(required = false) Boolean fatto
    ) {
        ToDo t = new ToDo();
        t.setLista(lista);
        t.setFatto(fatto);
        Example<ToDo> example = Example.of(t);
        return repoToDo.findAll( example );
    }
    @GetMapping("/esempio2")
    public List<ToDo> cercaParte( @RequestParam String cosa){
        return repoToDo.cerca("%"+cosa+"%");
    }
    @GetMapping("todo/{id}")
    public Optional<ToDo> prendiPerChiave( @PathVariable int id ) {
        return repoToDo.findById(id);
    }
    @PostMapping("/todo")
    public void inserisci(@RequestBody ToDo td) {
        repoToDo.save( td );
    }
    @DeleteMapping("todo/{id}")
    public void cancellaPerChiave( @PathVariable int id ) {
        repoToDo.deleteById(id);
    }
    @PutMapping("todo/{id}")
    public void modifica( @PathVariable int id, @RequestBody ToDo td ) {
        Optional<ToDo> k = repoToDo.findById(id);
        if(k.isPresent()) {
            ToDo t = k.get();
            t.setLista(td.getLista());
            t.setFatto(td.getFatto());
            t.setCosa(td.getCosa());
            repoToDo.save(t);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }
}