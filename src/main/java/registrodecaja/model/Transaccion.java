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

@Entity
@Table(name = "Transaccion")
public class Transaccion {

	@Id
	@GeneratedValue
	@Column(name = "transaccion_id", unique = true)
	private Integer id;
	
	@NotNull
	@JoinColumn( name = "moneda_id" )
	@OneToOne
	@Cascade({CascadeType.SAVE_UPDATE})
	private NombreMoneda nombreDeMoneda;

	@Column(name = "descipcion")
	private String descripcion;

	@Column(name = "tipo_transaccion")
	private TipoTransaccion tipoTransaccion;
	
	@Column(name = "fecha")
	private Date fecha;
	
	@OneToOne
	@Cascade({CascadeType.ALL})
	@JoinColumn(name = "usuario_id")
	private Usuario usuario;
	
	public Transaccion(){ }

	public Transaccion(NombreMoneda dinero, String descripcion, TipoTransaccion tipoTransaccion, Date fecha, Usuario usuario) {
		super();
		this.nombreDeMoneda = dinero;
		this.descripcion = descripcion;
		this.tipoTransaccion = tipoTransaccion;
		this.fecha = fecha;
		this.usuario = usuario;
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public Integer getId() {
		return id;
	}
	
	public void setId(Integer id) {
		this.id = id;
	}

	public NombreMoneda getNombreDeMoneda() {
		return nombreDeMoneda;
	}

	public void setNombreDeMoneda(NombreMoneda nombreDeMoneda) {
		this.nombreDeMoneda = nombreDeMoneda;
	}
}
