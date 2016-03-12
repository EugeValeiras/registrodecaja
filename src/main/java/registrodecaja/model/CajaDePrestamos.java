package registrodecaja.model;

import java.sql.Date;
import java.util.Calendar;

import javax.persistence.Entity;

@Entity
public class CajaDePrestamos extends Caja{
	
	public void saldarPrestamo(Integer transactionID){
		Transaccion[] transaccionesConEseID = transacciones.stream().filter((trans) -> trans.getId().equals(transactionID)).toArray(Transaccion[]::new);
		Transaccion transaccion = transaccionesConEseID.length > 0 ? transaccionesConEseID[0] : null;
		saldar(transaccion);
	}

	public void saldar(Transaccion transaccion){
		Transaccion nuevaTransaccion = new Transaccion(transaccion.getNombreDeMoneda(), 
				"Pago de: " + transaccion.getDescripcion(), 
				transaccion.getTipoTransaccion().getOther(), 
				new Date(Calendar.getInstance().getTime().getTime()), 
				transaccion.getUsuario());
		addTransaccion(nuevaTransaccion);
	}
	
}
