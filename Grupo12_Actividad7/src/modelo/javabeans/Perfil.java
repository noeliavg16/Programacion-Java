package modelo.javabeans;

import java.util.Objects;


/**
 * Creamos la classe Perfil con los atributos que tiene la base de datos Perfil
 * 
 * @author Gerard_Perujo
 *
 */
public class Perfil {
	
	private int idPerfil;
	private String nombre;
	private double precio_hora;
	

	public Perfil() {
		super();
	}


	
	/**
	 * Constructor con todo de la clase Perfil
	 * 
	 * @param idPerfil: Es el id de Perfil
	 * @param nombre: Es el nombre del Perfil
	 */
	

	public Perfil(int idPerfil, String nombre, double precio_hora) {
		super();
		this.idPerfil = idPerfil;
		this.nombre = nombre;
		this.precio_hora = precio_hora;
	}

	/**
	 * Creamos los getters and setters
	 * @param i 
	 */
	public int getIdPerfil() {
		return idPerfil;
	}


	public void setIdPerfil(int idPerfil) {
		this.idPerfil = idPerfil;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public double getPrecio_hora() {
		return precio_hora;
	}



	public void setPrecio_hora(double precio_hora) {
		this.precio_hora = precio_hora;
	}



	/**
	 * Creamos el metodo toString con todos los atributos de la clase perfil
	 */
	
	@Override
	public String toString() {
		return "Perfil [idPerfil = " + idPerfil + "]" + ", [nombre = " + nombre + "]"+  ", [precio_hora = " + precio_hora + "]";
	}

	/**
	 * Creamos el hascode con el atributo idPerfil ya que es la PK en la base de
	 * datos y con esto podremos llamar a esta clase desde otra.
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idPerfil);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Perfil other = (Perfil) obj;
		return idPerfil == other.idPerfil;
	}
	
	
	
	
	
	
	
	

}
