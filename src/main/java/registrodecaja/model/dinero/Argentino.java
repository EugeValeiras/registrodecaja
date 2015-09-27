package registrodecaja.model.dinero;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import registrodecaja.model.Dinero;

@Entity
@DiscriminatorValue(value = "A")
public class Argentino extends Dinero {

	public Argentino() {
		super();
	}

	public Argentino(int cantidad) {
		super(cantidad);
	}

	@Override
	public String toString() {
		return "$ " + this.getCantidad();
	}

	@Override
	public boolean soyArgentino() {
		return true;
	}
}
