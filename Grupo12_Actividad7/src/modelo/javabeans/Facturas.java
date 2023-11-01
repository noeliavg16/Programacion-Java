package modelo.javabeans;

import java.util.Objects;

public class Facturas {
	/*
	 * Se crean los atributos privados de la clase, incluyendo el objeto completo de Proyecto,
	 * que sera llamado en diversas circunstancias para obtener el idProyecto.
	 */
	
	private String idFactura;
	private String descripcion;
	private Proyecto proyecto;
	
	//Se generan los dos constructores.
	public Facturas() {
		super();
	}
	
	public Facturas(String idFactura, String descripcion, Proyecto proyecto) {
		super();
		this.idFactura = idFactura;
		this.descripcion = descripcion;
		this.proyecto = proyecto;
	}

	//Se añaden los getter and setter.
	public String getIdFactura() {
		return idFactura;
	}
	public void setIdFactura(String idFactura) {
		this.idFactura = idFactura;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Proyecto getProyecto() {
		return proyecto;
	}

	public void setProyecto(Proyecto proyecto) {
		this.proyecto = proyecto;
	}

	//Se redefine Object.
	@Override
	public String toString() {
		return "Facturas [idFactura=" + idFactura + ", descripcion=" + descripcion + ", proyecto=" + proyecto + "]";
	}
	
	//Se incluyen hashCode y equals. Dos facturas son iguales si el idFactura es el mismo.
	@Override
	public int hashCode() {
		return Objects.hash(idFactura);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Facturas other = (Facturas) obj;
		return Objects.equals(idFactura, other.idFactura);
	}
	
	

}
