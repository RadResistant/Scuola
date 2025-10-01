package it.edu.iisgubbio.tennis;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Prenotazione {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	Integer ora_inizio;
	Integer ora_fine;
	String data;
	@ManyToOne
	@JoinColumn(name="campo_id")
	@JsonBackReference("campo-prenotazione")
	Campo campo_id;
	@ManyToOne
	@JoinColumn(name="giocatore_id")
	@JsonBackReference("giocatore-prenotazione")
	Giocatore giocatore_id;
	public Prenotazione(){
		super();
	}
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id=id;
	}
	public Integer getOra_inizio(){
		return ora_inizio;
	}
	public void setOra_inizio(Integer ora_inizio){
		this.ora_inizio=ora_inizio;
	}
	public Campo getCampo_id() {
		return campo_id;
	}
	public void setCampo_id(Campo campo_id) {
		this.campo_id = campo_id;
	}
	public Giocatore getGiocatore_id() {
		return giocatore_id;
	}
	public void setGiocatore_id(Giocatore giocatore_id) {
		this.giocatore_id = giocatore_id;
	}
	public Integer getOra_fine(){
		return ora_fine;
	}
	public void setOra_fine(Integer ora_fine){
		this.ora_fine=ora_fine;
	}
	public String getData(){
		return data;
	}
	public void setData(String data){
		this.data=data;
	}
}