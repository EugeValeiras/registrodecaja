package registrodecaja.controller;

import java.util.List;

import javax.inject.Inject;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import registrodecaja.model.Dinero;
import registrodecaja.model.Transaccion;
import registrodecaja.model.dinero.Argentino;
import registrodecaja.transaccion.TransaccionDao;
import registrodecaja.transaccion.TransaccionFromUI;

@Controller
@Scope("session")
public class AppController {
	
	private final TransaccionDao transaccionDao;

	@Inject
	public AppController(TransaccionDao transaccionDao) {
		this.transaccionDao = transaccionDao;
	}
	
	@RequestMapping(value = "/" ,method = RequestMethod.GET)
	public ModelAndView root(){
		ModelAndView model = new ModelAndView();
		model.setViewName("programa");
		return model;
	}
	
	@RequestMapping(value = "/getAllTransaccion" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Transaccion> getAllTransacciones() {
		return transaccionDao.getAllTransacciones();
	}
	
	@RequestMapping(value = "/crearTransaccion" ,method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void crearTransaccion(@RequestBody TransaccionFromUI transaccionFromUI) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		transaccionDao.addTransaccion(transaccionFromUI.asTransaccion());
	}
	
	@RequestMapping(value = "/borrarTransaccion/{id}" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void borrarTransaccion(@PathVariable("id") int id) {
		
	}
	
	@RequestMapping(value = "/getCantidad/{tipoMoneda}" ,method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String getCantidad(@PathVariable("tipoMoneda") String tipoMoneda) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Dinero dinero = transaccionDao.getMontoTransaccionDeTipo(tipoMoneda);
		return dinero.toString();
	}
	
	@RequestMapping(value = "/evaluarDolar" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String evaluarDolar() {
		return null;
	}
	
}
