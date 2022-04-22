package model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// Constructor sin parametros
@NoArgsConstructor
// Constructor con todos los parametros
@AllArgsConstructor
// Setter de todos los atributos
@Setter
// Getter de todos los atributos
@Getter
@Entity
@Table(name = "productos")
public class Tienda {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // GeneratedValue indica que la clave primaria es autogenera
	private int idProducto;
	@Column(name = "nombre", unique = true)
	private String nombre;
	@Column(name = "seccion")
	private String seccion;
	@Column(name = "precio")
	private double precio;
	@Column(name = "stock")
	private int stock;

}
