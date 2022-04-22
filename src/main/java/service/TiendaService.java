package service;

import java.util.List;

import org.springframework.stereotype.Repository;
import model.Tienda;

@Repository
public interface TiendaService {

	void alta(Tienda t);
	
	void modificarPrecio(String nomProducto, double precio);
	
	void baja(String nomProducto);
	
	List<Tienda> buscar(String seccion);
	
	Tienda buscarPorId(int idProducto);
}
