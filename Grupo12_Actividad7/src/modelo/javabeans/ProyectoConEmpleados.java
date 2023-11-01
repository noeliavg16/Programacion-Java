package modelo.javabeans;

import java.sql.Date;
import java.util.Objects;

public class ProyectoConEmpleados {
	
	Perfil perf = new Perfil();
	/*
	 * Se crean los atributos privados de la clase.
	 * Hay que tener en cuenta que los atributos idProyecto e idEmpl proceden de las clases Proyecto y Empleados, respectivamente.
	 */
	private int numeroOrden;
	private Proyecto proyecto;
	private Empleados empleados;
	private int horasAsignadas;
	private Date fechaIncorporacion;
	
	//Se generan los dos constructores.
	public ProyectoConEmpleados() {
		super();
	}

	public ProyectoConEmpleados(int numeroOrden, Proyecto proyecto, Empleados empleados, int horasAsignadas,
			Date fechaIncorporacion) {
		super();
		this.numeroOrden = numeroOrden;
		this.proyecto = proyecto;
		this.empleados = empleados;
		this.horasAsignadas = horasAsignadas;
		this.fechaIncorporacion = fechaIncorporacion;
	}


	//Se crean los getter and setter de la clase.
	
	public int getNumeroOrden() {
		return numeroOrden;
	}
	public void setNumeroOrden(int numeroOrden) {
		this.numeroOrden = numeroOrden;
	}
	public Proyecto getProyecto() {
		return proyecto;
	}
	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}
	public Empleados getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Empleados empleados) {
		this.empleados = empleados;
	}
	public int getHorasAsignadas() {
		return horasAsignadas;
	}
	public void setHorasAsignadas(int horasAsignadas) {
		this.horasAsignadas = horasAsignadas;
	}
	public Date getFechaIncorporacion() {
		return fechaIncorporacion;
	}
	public void setFechaIncorporacion(Date fechaIncorporacion) {
		this.fechaIncorporacion = fechaIncorporacion;
	}
	
	
	//Se redefine con toString.
	@Override
	public String toString() {
		return "ProyectoConEmpleados [numeroOrden=" + numeroOrden + ", proyecto=" + proyecto + ", empleados="
				+ empleados + ", horasAsignadas=" + horasAsignadas + ", fechaIncorporacion=" + fechaIncorporacion + "]";
	}

	//Se generan el equals y el hashCode. Dos proyectos con empleados son iguales si su numero de orden es la misma.
	@Override
	public int hashCode() {
		return Objects.hash(numeroOrden);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProyectoConEmpleados other = (ProyectoConEmpleados) obj;
		return numeroOrden == other.numeroOrden;
	}
	
	//Finalmente  se crea el metodo de la clase -> costeHorasAsignadas(): double . Horas * precio/hora
	public double costeHorasAsignadas () {
		double costeTotal = 0;
		costeTotal = horasAsignadas * perf.getPrecio_hora();
		return costeTotal;
	}
	

	
	
	
	
	
}
