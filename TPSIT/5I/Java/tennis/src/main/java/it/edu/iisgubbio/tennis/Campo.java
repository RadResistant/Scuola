package it.edu.iisgubbio.tennis;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
@Entity
public class Campo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	Integer apertura;
	Integer chiusura;
	String nome;
	Integer riscaldato;
	@OneToMany(mappedBy="campo_id")
	@JsonManagedReference
	List<Prenotazione> prenotazione;
	public Campo(){
		super();
	}
	public Integer getId(){
		return id;
	}
	public void setId(Integer id){
		this.id = id;
	}
	public Integer getApertura(){
		return apertura;
	}
	public void setApertura(Integer apertura){
		this.apertura = apertura;
	}
	public Integer getChiusura(){
		return chiusura;
	}
	public void setChiusura(Integer chiusura){
		this.chiusura = chiusura;
	}
	public String getNome(){
		return nome;
	}
	public void setNome(String nome){
		this.nome = nome;
	}
	public Integer getRiscaldato(){
		return riscaldato;
	}
	public void setRiscaldato(Integer riscaldato){
		this.riscaldato = riscaldato;
	}
}