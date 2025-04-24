package it.edu.iisgubbio.tennis;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
@Entity
public class Campo {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	Integer id;
	Integer apertura;
	Integer chiusura;
	String nome;
	Integer riscaldato;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getApertura() {
		return apertura;
	}
	public void setApertura(Integer apertura) {
		this.apertura = apertura;
	}
	public Integer getChiusura() {
		return chiusura;
	}
	public void setChiusura(Integer chiusura) {
		this.chiusura = chiusura;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getRiscaldato() {
		return riscaldato;
	}
	public void setRiscaldato(Integer riscaldato) {
		this.riscaldato = riscaldato;
	}
}