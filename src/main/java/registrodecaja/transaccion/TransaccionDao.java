package registrodecaja.transaccion;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.FetchMode;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import registrodecaja.model.NombreMoneda;
import registrodecaja.model.TipoTransaccion;
import registrodecaja.model.Transaccion;

@Repository
@Transactional
public class TransaccionDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private Session openSession() {
		return sessionFactory.getCurrentSession();
	}
	
	public List<Transaccion> getAllTransacciones(){
		return openSession().createCriteria(Transaccion.class).list();
	}

	public List<Transaccion> getAllTransacciones(String owner){
		return openSession().createCriteria(Transaccion.class).add(Restrictions.eq("owner", owner)).list();
	}
	
	public void addTransaccion(Transaccion trans){
		openSession().save(trans);
	}
	
	public void removeTransaccion(Transaccion trans){
		openSession().delete(trans);
	}
	
	public void removeTransaccionByID(int id){
		Transaccion trans = new Transaccion();
		trans.setId(id);
		openSession().delete(trans);
	} 
	
	
	//TODO MEJORAR ESTE METODO QUE NO ESTA BIEN HECHO
	public NombreMoneda getMontoTransaccionDeTipo(String tipoMoneda, String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		@SuppressWarnings("unchecked")
		Class<NombreMoneda> tipoDiner = (Class<NombreMoneda>) Class.forName("registrodecaja.model.dinero."+tipoMoneda);
		NombreMoneda dinero = tipoDiner.newInstance();
		
		Criteria criteria = openSession().createCriteria(Transaccion.class, "trans").add(Restrictions.eq("owner", username));
		List<Transaccion> list = criteria.list();
				
		for(Transaccion transaccion : list){
			if(transaccion.getNombreDeMoneda().getClass().equals(tipoDiner)){
				if(transaccion.getTipoTransaccion().equals(TipoTransaccion.INGRESO)){
//					dinero.setCantidad(dinero.getCantidad() + transaccion.getDinero().getCantidad()); 
				} else {
//					dinero.setCantidad(dinero.getCantidad() - transaccion.getDinero().getCantidad()); 
				}
			}
		}
		return dinero;
	}
	
	
}
