package it.edu.iisgubbio.tennis;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Giocatore {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	String nome;
	String cognome;
	String email;
	String telefono;
	String data_nascita;
	@OneToMany(mappedBy="giocatore_id")
	@JsonManagedReference
	List<Prenotazione> prenotazione;
	public Giocatore(){
		super();
	}
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome=nome;
	}
	public String getCognome(){
		return cognome;
	}
	public void setCognome(String cognome){
		this.cognome=cognome;
	}
	public String getEmail(){
		return email;
	}
	public void setEmail(String email){
		this.email=email;
	}
	public String getTelefono(){
		return telefono;
	}
	public void setTelefono(String telefono){
		this.telefono=telefono;
	}
	public String getData_nascita(){
		return data_nascita;
	}
	public void setData_nascita(String data_nascita){
		this.data_nascita=data_nascita;
	}
}