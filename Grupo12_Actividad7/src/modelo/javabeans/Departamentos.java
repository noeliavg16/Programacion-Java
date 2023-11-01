package modelo.javabeans;

import java.util.Objects;

/**
 * Creo la clase Departamentos que tendra unos atributos que hacen referencia al Departamento en la base de datos
 *
 * @author Gerard_Perujo
 *
 */
public class Departamentos {
	
	private  int idDepar;
	private String nombre;
	private String direccion;
	
	
	public Departamentos() {
		super();
	}




	/**
	 * Contructor con todos los atributos de la Clase departamento
	 * 
	 * @param idDepar: Es el id del Departamento
	 * @param nombre: Es el nombre del Departamento
	 * @param direccion: Es la direccion donde se encuentra el Departamento
	 */
	public Departamentos(int idDepar, String nombre, String direccion) {
		super();
		this.idDepar = idDepar;
		this.nombre = nombre;
		this.direccion = direccion;
	}


	/**
	 * Creamos los getters and setters
	 */
	public int getIdDepar() {
		return idDepar;
	}


	public void setIdDepar(int idDepar) {
		this.idDepar = idDepar;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	public String getDireccion() {
		return direccion;
	}


	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}


	/**
	 * Creamos el metodo toString de Departamentos
	 */
	@Override
	public String toString() {
		return "Departamentos [idDepar = " + idDepar + "]" + " [nombre = " + nombre + "]" + " [direccion = " + direccion + "]";
	}




	/**
	 * Creamos el hascode de Departamento cogiendo el idDepar ya que es el
	 * atributo que hace referencia a la PK en la base de datos, y con el hascode 
	 * podremos llamar a esta clase desde otra
	 */
	@Override
	public int hashCode() {
		return Objects.hash(idDepar);
	}




	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Departamentos other = (Departamentos) obj;
		return idDepar == other.idDepar;
	}
	
	
	
	
	
	
	
	

}
