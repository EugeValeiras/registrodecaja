package registrodecaja.controller;

import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
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

import registrodecaja.dinero.Dinero;
import registrodecaja.transaccion.Transaccion;
import registrodecaja.transaccion.TransaccionFromUI;

@Controller
@EnableAutoConfiguration
@Scope("session")
@RequestMapping("/")
public class AppController {

	public static void main(String[] args) throws Exception {
		Transaccion.initTransacciones();
		SpringApplication.run(AppController.class, args);
	}
	
	@RequestMapping(value = "/" ,method = RequestMethod.GET)
	public ModelAndView root(){
		ModelAndView model = new ModelAndView();
		model.setViewName("programa.html");
		return model;
	}
	
	@RequestMapping(value = "/getAllTransaccion" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Transaccion> getAllTransacciones() {
		return Transaccion.getAllTransacciones();
	}
	
	@RequestMapping(value = "/crearTransaccion" ,method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void crearTransaccion(@RequestBody TransaccionFromUI transaccionFromUI) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Transaccion.addTransaccion(transaccionFromUI.asTransaccion());
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
		Dinero dinero = Transaccion.getMontoTransaccionDeTipo(tipoMoneda);
		return dinero.toString();
	}
	
	@RequestMapping(value = "/evaluarDolar" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String evaluarDolar() {
		return null;
	}
	
}
