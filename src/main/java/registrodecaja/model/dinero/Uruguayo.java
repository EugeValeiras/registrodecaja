package registrodecaja.model.dinero;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import registrodecaja.model.Dinero;

@Entity
@DiscriminatorValue(value = "U")
public class Uruguayo extends Dinero {

	public Uruguayo() {
		super();
	}

	public Uruguayo(int cantidad) {
		super(cantidad);
	}

	@Override
	public String toString() {
		return "$UY " + this.getCantidad();
	}

	@Override
	public boolean soyUruguayo() {
		return true;
	}
}
