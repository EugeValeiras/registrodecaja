package registrodecaja.dinero;

public class Dolar extends Dinero{

	public Dolar(){
		super();
	}
	
	public Dolar(int cantidad){
		super(cantidad);
	}

	@Override
	public String toString(){
		return "U$D "+this.getCantidad();
	}
	
	@Override
	public boolean soyDolar(){
		return true;
	}
}
