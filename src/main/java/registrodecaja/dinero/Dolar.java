package registrodecaja.dinero;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import registrodecaja.model.Dinero;

@Entity
@Table(name="Dinero")
@DiscriminatorValue("D")
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
