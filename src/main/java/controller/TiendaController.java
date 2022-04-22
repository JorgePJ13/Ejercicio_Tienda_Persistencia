package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import model.Tienda;
import service.TiendaService;

@CrossOrigin("*")
@Controller
public class TiendaController {

	@Autowired
	TiendaService tiendaS;

	@GetMapping(value = "Buscador", produces = MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody List<Tienda> buscar(@RequestParam("seccion") String seccion) {
		return tiendaS.buscar(seccion);
		// @ResponseBody le dice a Spring que lo que estamos devolviendo va directamente
		// en el cuerpo de la respuesta
		// Cuando se le incluye en el body, esta formateado con JSON gracias a
		// MediaType.APPLICATION
	}
	
//	@GetMapping(value = "Buscador", produces = MediaType.APPLICATION_JSON_VALUE)
//	public @ResponseBody Tienda buscarId(@RequestParam("idProducto") int idProduct) {
//		return tiendaS.buscarPorId(idProduct);
//		// @ResponseBody le dice a Spring que lo que estamos devolviendo va directamente
//		// en el cuerpo de la respuesta
//		// Cuando se le incluye en el body, esta formateado con JSON gracias a
//		// MediaType.APPLICATION
//	}

	@PostMapping("Alta")
	public String alta(@ModelAttribute Tienda t) {
		tiendaS.alta(t);
		return "alta";
	}

	@GetMapping("Modificar")
	public String modificar(@RequestParam("nombre") String nomProducto, @RequestParam("precio") double precio,
			HttpServletRequest request) {
		tiendaS.modificarPrecio(nomProducto, precio);
		return "inicio";
	}

	@GetMapping("Eliminar")
	public String eliminar(@RequestParam("nombre") String nomProducto) {
		tiendaS.baja(nomProducto);
		return "inicio";
	}
}
