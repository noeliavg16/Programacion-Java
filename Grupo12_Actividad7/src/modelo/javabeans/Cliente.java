package modelo.javabeans;
import java.util.Objects;
import java.math.BigDecimal;
/**
 * Se crea la clase Cliente con los atributos que tiene la tabla clientes en la BBDD.
 * @author Noelia
 *
 */

public class Cliente {
	
	private String cif; 
	private String nombre; 
	private String apellidos; 
	private String domicilio; 
	private Double facturacionAnual; // BigDecimal se importa de la clase java.math
	private int numeroEmpleados;
	
/**
 *  Constructor sin parámetros. 
 */
	public Cliente() {
		super();
	}

/**
 *  Constructor con parámetros. 
 *  
 *  @param cif hace referencia a 
 *  @param nombre
 *  @param apellidos
 *  @param domicilio
 *  @param facturacion_anual
 *  @param numeroEmpleados
 *  
 */
	public Cliente(String cif, String nombre, String apellidos, String domicilio, double facturacionAnual,
			int numeroEmpleados) {
		super();
		this.cif = cif;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.domicilio = domicilio;
		this.facturacionAnual = facturacionAnual;
		this.numeroEmpleados = numeroEmpleados;
	}

	public String getCif() {
		return cif;
	}

	public void setCif(String cif) {
		this.cif = cif;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public String getDomicilio() {
		return domicilio;
	}

	public void setDomicilio(String domicilio) {
		this.domicilio = domicilio;
	}

	public Double getFacturacionAnual() {
		return facturacionAnual;
	}

	public void setFacturacionAnual(Double facturacionAnual) {
		this.facturacionAnual = facturacionAnual;
	}

	public int getNumeroEmpleados() {
		return numeroEmpleados;
	}

	public void setNumeroEmpleados(int numeroEmpleados) {
		this.numeroEmpleados = numeroEmpleados;
	}

	@Override
	public String toString() {
		return "Cliente [cif=" + cif + ", nombre=" + nombre + ", apellidos=" + apellidos + ", domicilio=" + domicilio
				+ ", facturacion_anual=" + facturacionAnual + ", numeroEmpleados=" + numeroEmpleados + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(cif);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		return Objects.equals(cif, other.cif);
	}

	
	
	
	

	
	
	
	
	
	

}
