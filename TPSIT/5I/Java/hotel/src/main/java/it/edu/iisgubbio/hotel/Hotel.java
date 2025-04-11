package it.edu.iisgubbio.hotel;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Hotel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String nome;
	String telefono;
	String provincia;
	@OneToMany(mappedBy="hotel")
	@JsonManagedReference
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
	public List<Stanza> getStanze() {
		return stanze;
	}
	public void setStanze(List<Stanza> stanze) {
		this.stanze = stanze;
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
