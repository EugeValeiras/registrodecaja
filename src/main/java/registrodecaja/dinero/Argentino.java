package registrodecaja.dinero;

public class Argentino extends Dinero{

	public Argentino(){
		super();
	}
	
	public Argentino(int cantidad){
		super(cantidad);
	}
	
	@Override
	public String toString(){
		return "$ "+this.getCantidad();
	}

	@Override
	public boolean soyArgentino(){
		return true;
	}
}
