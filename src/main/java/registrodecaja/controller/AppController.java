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

import registrodecaja.form.LoginForm;
import registrodecaja.model.NombreMoneda;
import registrodecaja.model.Transaccion;
import registrodecaja.model.Usuario;
import registrodecaja.transaccion.TransaccionDao;
import registrodecaja.transaccion.TransaccionFromUI;

@Controller
@Scope("session")
public class AppController {
	
	Usuario logAcc = null;
	
	private final TransaccionDao transaccionDao;

	@Inject
	public AppController(TransaccionDao transaccionDao) {
		this.transaccionDao = transaccionDao;
	}
	
	@RequestMapping(value = "/" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	public String rootPath() throws Exception{

		if(logAcc != null){
			return "/account/"+logAcc;
		} else {
			return "redirect:/login";
		}
	}
	
	@RequestMapping(value = "/login" ,method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String login(@RequestBody LoginForm form) throws Exception{

		return "{\"status\" : 200, \"username\" : \"evaleiras\"}";
		
	}

	@RequestMapping(value = {"/login"} ,method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}

	@RequestMapping(value = {"/logout"} ,method = RequestMethod.GET)
	public ModelAndView logout(){
		logAcc = null;
		ModelAndView model = new ModelAndView();
		model.setViewName("login");
		return model;
	}
	
	@RequestMapping(value = {"/evaleiras", "/rgonzalez", "/oficina", "/merobaron"} ,method = RequestMethod.GET)
	public ModelAndView root(){
		ModelAndView model = new ModelAndView();
		if(logAcc != null){
			model.setViewName("programa");
			return model;
		} else {
			model.setViewName("login");
			return model;
		}
	}
	
	@RequestMapping(value = "/getAllTransaccion" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Transaccion> getAllTransacciones() {
		return transaccionDao.getAllTransacciones(null);
	}
	
	@RequestMapping(value = "/getAllTransaccion/{owner}" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public List<Transaccion> getAllTransacciones(@PathVariable("owner") String owner) {
		return transaccionDao.getAllTransacciones(owner);
	}
	
	@RequestMapping(value = "/crearTransaccion" ,method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void crearTransaccion(@RequestBody TransaccionFromUI transaccionFromUI) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		transaccionDao.addTransaccion(transaccionFromUI.asTransaccion(logAcc));
	}
	
	@RequestMapping(value = "/crearTransaccion/{owner}" ,method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void crearTransaccion(@PathVariable("owner") String owner,@RequestBody TransaccionFromUI transaccionFromUI) throws InstantiationException, IllegalAccessException, ClassNotFoundException {
		Usuario usuario = null; //Search Owner
		transaccionDao.addTransaccion(transaccionFromUI.asTransaccion(usuario));
	}
	
	@RequestMapping(value = "/borrarTransaccion/{id}" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public void borrarTransaccion(@PathVariable("id") int id) {
		
	}
	
	@RequestMapping(value = "/getCantidad/{username}/{tipoMoneda}" ,method = RequestMethod.GET, produces = "text/plain; charset=utf-8")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String getCantidad(@PathVariable("tipoMoneda") String tipoMoneda, @PathVariable("username") String username) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		NombreMoneda dinero = transaccionDao.getMontoTransaccionDeTipo(tipoMoneda, username);
		return dinero.toString();
	}
	
	@RequestMapping(value = "/evaluarDolar" ,method = RequestMethod.GET)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public String evaluarDolar() {
		return null;
	}
}
