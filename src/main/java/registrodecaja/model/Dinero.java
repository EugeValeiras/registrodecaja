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
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Dinero {

	@Id
	@GeneratedValue
	@Column(name="dienero_id")
	private int id;
	
	@Column(name = "cantidad")
	private int cantidad;
	
	@JsonProperty(value="tipo", required=true)
	public String getTipo(){
		return this.getClass().getSimpleName();
	}
	
	public Dinero(){
		
	}
	
	public Dinero(int cantidad){
		this.setCantidad(cantidad); 
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public boolean soyArgentino(){
		return false;
	}
	
	public boolean soyUruguayo(){
		return false;
	}
	
	public boolean soyDolar(){
		return false;
	}
}
