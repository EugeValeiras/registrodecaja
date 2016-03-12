package registrodecaja.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name="Dinero")
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class NombreMoneda {

	@Id
	@GeneratedValue
	@Column(name="moneda_id")
	private Integer id;
	
	@Column(name="nombre_moneda")
	private String nombreMoneda;
	
	public NombreMoneda(){
		
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombreMoneda() {
		return nombreMoneda;
	}

	public void setNombreMoneda(String nombreMoneda) {
		this.nombreMoneda = nombreMoneda;
	}
}
