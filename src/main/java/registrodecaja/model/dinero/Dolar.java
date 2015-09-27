package registrodecaja.model.dinero;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import registrodecaja.model.Dinero;

@Entity
@DiscriminatorValue(value="D")
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
