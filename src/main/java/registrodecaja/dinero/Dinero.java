package registrodecaja.dinero;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class Dinero {
	
	private int cantidad;
	
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
	
	@JsonProperty(value="tipo", required=true)
	public String getTipo(){
		return this.getClass().getSimpleName();
	}
}
