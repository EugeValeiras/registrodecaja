package registrodecaja.dinero;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

import registrodecaja.model.Dinero;

@Entity
@Table(name="Dinero")
@DiscriminatorValue("A")
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
