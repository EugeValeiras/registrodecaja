package registrodecaja.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;

@Entity
@Table(name = "Usuario")
public class Usuario {

	@Id
	@GeneratedValue
	@Column(name = "usuario_id", unique = true)
	private Integer id;
	
	@Column(name = "username", unique = true)
	private String username;

	@Column(name = "password", unique = true)
	private String password;
	
	@LazyCollection(LazyCollectionOption.FALSE)
	@OneToMany(cascade={CascadeType.ALL})
	@JoinTable(
			name = "cajas_x_usuario",
			joinColumns = @JoinColumn(name = "usuario_id"),
			inverseJoinColumns = @JoinColumn(name = "caja_id")
	)
	private List<Caja> cajas = new ArrayList<Caja>();
	
	public Usuario(String username, String password) {
		this.username = username;
		this.password = password;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public List<Caja> getCajas() {
		return cajas;
	}
	public void setCajas(List<Caja> cajas) {
		this.cajas = cajas;
	}
	public void addCaja(Caja caja){
		cajas.add(caja);
	}
	public void removeCaja(Caja caja){
		cajas.remove(caja);
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Caja findCaja(String nombreCaja){
		Caja[] cajasWithThisName = cajas.stream()
			.filter((caja) -> caja.getNombre().equals(nombreCaja))
			.toArray(Caja[]::new);
		return cajasWithThisName.length > 0 ? cajasWithThisName[0] : null;
	}

	public void agregarDinero(String nombreCaja, Transaccion transaccion){
		Caja caja = findCaja(nombreCaja);
		caja.addTransaccion(transaccion);
	}

	public void borrarDinero(String nombreCaja, Transaccion transaccion){
		Caja caja = findCaja(nombreCaja);
		caja.removeTransaccion(transaccion);
	}
}