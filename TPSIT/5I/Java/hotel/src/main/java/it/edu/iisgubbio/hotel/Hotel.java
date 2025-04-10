package it.edu.iisgubbio.hotel;
import java.util.List;
import jakarta.persistence.Entity;
@Entity
public class Hotel {
	Integer id;
	String nome;
	String telefono;
	String provincia;
	List<Stanza> stanze;
	public Hotel(){
		super();
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
}
