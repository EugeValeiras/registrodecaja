package registrodecaja.transaccion;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import registrodecaja.dinero.Argentino;
import registrodecaja.dinero.Dinero;

public class Transaccion {

	private Dinero dinero;
	private String descripcion;
	private TipoTransaccion tipoTransaccion;
	private Date fecha;
	private String usuario;
	
	private static List<Transaccion> listaInventada = new ArrayList<Transaccion>();
	public static void initTransacciones(){
//		Transaccion.listaInventada.add(new Transaccion(new Argentino(222), "Chino", TipoTransaccion.EGRESO, new Date(2015, 10, 10), "Gurkita"));
	}
	public static List<Transaccion> getAllTransacciones(){
		return listaInventada;
	}
	public static void addTransaccion(Transaccion trans){
		listaInventada.add(trans);
	}
	public static void removeTransaccion(Transaccion trans){
		listaInventada.remove(trans);
	}
	public static Dinero getMontoTransaccionDeTipo(String tipoMoneda) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Class<Dinero> tipoDiner = (Class<Dinero>) Class.forName("registrodecaja.dinero."+tipoMoneda);
		Dinero dinero = tipoDiner.newInstance();
		dinero.setCantidad(0);
		
		for(Transaccion transaccion : listaInventada){
			if(transaccion.getDinero().getClass().getSimpleName().equals(tipoMoneda)){
				if(transaccion.tipoTransaccion.equals(TipoTransaccion.INGRESO)){
					dinero.setCantidad(dinero.getCantidad() + transaccion.getDinero().getCantidad()); 
				} else {
					dinero.setCantidad(dinero.getCantidad() - transaccion.getDinero().getCantidad()); 
				}
			}
		}
		return dinero;
	}
	
	public Transaccion(){
	
	}

	public Transaccion(Dinero dinero, String descripcion, TipoTransaccion tipoTransaccion, Date fecha, String usuario) {
		super();
		this.dinero = dinero;
		this.descripcion = descripcion;
		this.tipoTransaccion = tipoTransaccion;
		this.fecha = fecha;
		this.usuario = usuario;
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
}
