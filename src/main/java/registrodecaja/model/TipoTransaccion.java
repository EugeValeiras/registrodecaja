package registrodecaja.model;

import java.util.spi.TimeZoneNameProvider;

public enum TipoTransaccion {

	INGRESO(),EGRESO();
	
	public TipoTransaccion getOther(){
		if(this.equals(INGRESO)){
			return EGRESO;
		} else {
			return INGRESO;
		}
	}
	
}
