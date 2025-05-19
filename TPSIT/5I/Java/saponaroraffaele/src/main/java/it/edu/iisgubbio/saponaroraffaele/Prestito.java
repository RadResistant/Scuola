package it.edu.iisgubbio.saponaroraffaele;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Prestito {
    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    Integer id;
    String cf;
    String dataPrestito;
    String dataRestituzione;
	@ManyToOne
	@JoinColumn(name="libroId")
	@JsonBackReference("libro-prestito")
    Libro libroId;
    public Integer getId() {
        return id;
    }
    public void setId(Integer id) {
        this.id = id;
    }
    public String getCf() {
        return cf;
    }
    public void setCf(String cf) {
        this.cf = cf;
    }
    public String getDataPrestito() {
        return dataPrestito;
    }
    public void setDataPrestito(String dataPrestito) {
        this.dataPrestito = dataPrestito;
    }
    public String getDataRestituzione() {
        return dataRestituzione;
    }
    public void setDataRestituzione(String dataRestituzione) {
        this.dataRestituzione = dataRestituzione;
    }
    public Libro getLibroId() {
        return libroId;
    }
    public void setLibroId(Libro libroId) {
        this.libroId = libroId;
    }
}