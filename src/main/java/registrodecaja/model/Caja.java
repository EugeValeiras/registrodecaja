package registrodecaja.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Caja {

	@Id
	@GeneratedValue
	@Column(name = "caja_id", unique = true)
	protected Integer id;
	
	@Column(name = "nombre_caja")
	protected String nombre;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade={CascadeType.ALL})
	@JoinTable(
			name = "transacciones_x_caja",
			joinColumns = @JoinColumn(name = "caja_id"),
			inverseJoinColumns = @JoinColumn(name = "transaccion_id")
	)
	protected List<Transaccion> transacciones = new ArrayList<>();
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public List<Transaccion> getTransacciones() {
		return transacciones;
	}

	public void setTransacciones(List<Transaccion> transacciones) {
		this.transacciones = transacciones;
	}
	
	public void addTransaccion(Transaccion transaccion){
		transacciones.add(transaccion);
	}
	
	public void removeTransaccion(Transaccion transaccion){
		transacciones.remove(transaccion);
	}
}
