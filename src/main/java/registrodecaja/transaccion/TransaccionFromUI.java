package registrodecaja.transaccion;

import java.sql.Date;

import registrodecaja.model.Dinero;
import registrodecaja.model.Transaccion;

public class TransaccionFromUI {
	
	private int cantidad;
	private String descripcion;
	private String tipoTransaccion;
	private String usuario;
	private String tipoMoneda;
	private Date fecha;
	private String owner;
	
	public Transaccion asTransaccion() throws InstantiationException, IllegalAccessException, ClassNotFoundException{
		@SuppressWarnings("unchecked")
		Class<Dinero> tipoDiner = (Class<Dinero>) Class.forName("registrodecaja.model.dinero."+tipoMoneda);
		Dinero dinero = tipoDiner.newInstance();
		dinero.setCantidad(cantidad);
		return new Transaccion(dinero, descripcion, TipoTransaccion.valueOf(tipoTransaccion), fecha, usuario, owner);
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

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
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