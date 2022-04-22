package service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import model.Tienda;

@Service
public class TiendaServiceImpl implements TiendaService {

	@PersistenceContext
	EntityManager em;

	@Transactional
	@Override
	public void alta(Tienda t) {
		em.persist(t);
	}

	@Transactional
	@Override
	public void modificarPrecio(String nomProducto, double precio) {
		String jpa = "update Tienda p set p.precio = ?1 WHERE p.nombre = ?2";
		Query query = em.createQuery(jpa);
		query.setParameter(1, precio);
		query.setParameter(2, nomProducto);
		query.executeUpdate();
	}

	@Transactional
	@Override
	public void baja(String nomProducto) {
		String jpa = "delete from Tienda p where p.nombre = ?1";
		Query query = em.createQuery(jpa);
		query.setParameter(1, nomProducto);
		query.executeUpdate();
	}

	// Usamos query para listas
	// No se modifica la base de datos con el metodo buscar, por tanto no se pone
	// @Transactional
	@Override
	public List<Tienda> buscar(String seccion) {
		String jpa = "select p from Tienda p where p.seccion = ?1";
		Query query = em.createQuery(jpa);
		query.setParameter(1, seccion);
		List<Tienda> lista_Productos = query.getResultList();
		return lista_Productos;
	}

	// Para objetos (Tienda), usamos
	@Transactional
	@Override
	public Tienda buscarPorId(int idProducto) {
		return em.find(Tienda.class, idProducto);
	}

}
