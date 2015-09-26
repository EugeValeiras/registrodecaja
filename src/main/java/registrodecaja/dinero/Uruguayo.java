package registrodecaja.dinero;

public class Uruguayo extends Dinero{

	public Uruguayo(){
		super();
	}
	
	public Uruguayo(int cantidad){
		super(cantidad);
	}
	
	@Override
	public String toString(){
		return "$UY "+this.getCantidad();
	}
	@Override
	public boolean soyUruguayo(){
		return true;
	}
}
