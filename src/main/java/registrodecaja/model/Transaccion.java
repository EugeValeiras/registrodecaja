package registrodecaja.model;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import registrodecaja.transaccion.TipoTransaccion;

@Entity
@Table(name = "Transaccion")
public class Transaccion {

	@Id
	@GeneratedValue
	@Column(name = "id", unique = true)
	private int id;
	
	@NotNull
	@JoinColumn( name = "dinero_id" )
	@OneToOne
	@Cascade({CascadeType.SAVE_UPDATE})
	private Dinero dinero;

	@Column(name = "descipcion")
	private String descripcion;

	@Column(name = "tipo_transaccion")
	private TipoTransaccion tipoTransaccion;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@Column(name = "usuario")
	private String usuario;
	
	@Column(name = "owner")
	private String owner;
	
	public Transaccion(){
	
	}

	public Transaccion(Dinero dinero, String descripcion, TipoTransaccion tipoTransaccion, Date fecha, String usuario, String owner) {
		super();
		this.dinero = dinero;
		this.descripcion = descripcion;
		this.tipoTransaccion = tipoTransaccion;
		this.fecha = fecha;
		this.usuario = usuario;
		this.owner = owner;
	}

	public Dinero getDinero() {
		return dinero;
	}

	public void setDinero(Dinero dinero) {
		this.dinero = dinero;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public TipoTransaccion getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(TipoTransaccion tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}
