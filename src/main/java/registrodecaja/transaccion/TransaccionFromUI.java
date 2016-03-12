package registrodecaja.transaccion;

import java.sql.Date;

import registrodecaja.model.NombreMoneda;
import registrodecaja.model.TipoTransaccion;
import registrodecaja.model.Transaccion;
import registrodecaja.model.Usuario;

public class TransaccionFromUI {
	
	private int cantidad;
	private String descripcion;
	private String tipoTransaccion;
	private String tipoMoneda;
	private Date fecha;
	private String owner;
	
	public Transaccion asTransaccion(Usuario usuario) throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		@SuppressWarnings("unchecked")
		Class<NombreMoneda> tipoDiner = (Class<NombreMoneda>) Class.forName("registrodecaja.model.dinero."+tipoMoneda);
		NombreMoneda dinero = tipoDiner.newInstance();
		return new Transaccion(dinero, descripcion, TipoTransaccion.valueOf(tipoTransaccion), fecha, usuario);
	}
	
	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getTipoTransaccion() {
		return tipoTransaccion;
	}

	public void setTipoTransaccion(String tipoTransaccion) {
		this.tipoTransaccion = tipoTransaccion;
	}

	public String getTipoMoneda() {
		return tipoMoneda;
	}

	public void setTipoMoneda(String tipoMoneda) {
		this.tipoMoneda = tipoMoneda;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getOwner() {
		return owner;
	}

	public void setOwner(String owner) {
		this.owner = owner;
	}
	
}