package it.edu.iisgubbio.todo;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity(name = "todo")
public class ToDo {    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer id;
    String lista;
    String cosa;
    Boolean fatto;
    /* il metodi set/get vanno inseriti per esercizio, magari usando Eclipse */
	public String getLista() {
		return lista;
	}
	public void setLista(String lista) {
		this.lista = lista;
	}
	public String getCosa() {
		return cosa;
	}
	public void setCosa(String cosa) {
		this.cosa = cosa;
	}
	public Boolean getFatto() {
		return fatto;
	}
	public void setFatto(Boolean fatto) {
		this.fatto = fatto;
	}
	public Integer getId() {
		return id;
	}
}