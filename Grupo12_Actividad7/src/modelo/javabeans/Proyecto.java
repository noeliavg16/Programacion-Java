package modelo.javabeans;


import java.sql.Date;
import java.util.Objects;

public class Proyecto {
	//Añadimos los datos privados de la clase Proyecto.
	private String idProyecto, descripcion; 
	private Date fechaInicio, fechaFinPrevisto, fechaFinReal;
	private double ventaPrevisto, costesPrevisto, costeReal;
	private String estado;
	private int jefeProyecto;
	private Cliente cliente;
	
	//Incluimos el contructor con todos los parametros y el constructor sin nada.
	
	public Proyecto(String idProyecto, String descripcion, Date fechaInicio, Date fechaFinPrevisto, Date fechaFinReal,
			double ventaPrevisto, double costesPrevisto, double costeReal, String estado, int jefeProyecto,
			Cliente cliente) {
		super();
		this.idProyecto = idProyecto;
		this.descripcion = descripcion;
		this.fechaInicio = fechaInicio;
		this.fechaFinPrevisto = fechaFinPrevisto;
		this.fechaFinReal = fechaFinReal;
		this.ventaPrevisto = ventaPrevisto;
		this.costesPrevisto = costesPrevisto;
		this.costeReal = costeReal;
		this.estado = estado;
		this.jefeProyecto = jefeProyecto;
		this.cliente = cliente;
	}
	
	public Proyecto() {
		super();
	}

	

	//Se generan los getter and setter.
	public String getIdProyecto() {
		return idProyecto;
	}
	public void setIdProyecto(String idProyecto) {
		this.idProyecto = idProyecto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getEstado() {
		return estado;
	}
	public void setEstado(String estado) {
		this.estado = estado;
	}

	public Date getFechaInicio() {
		return fechaInicio;
	}
	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}
	public Date getFechaFinPrevisto() {
		return fechaFinPrevisto;
	}
	public void setFechaFinPrevisto(Date fechaFinPrevisto) {
		this.fechaFinPrevisto = fechaFinPrevisto;
	}
	public Date getFechaFinReal() {
		return fechaFinReal;
	}
	public void setFechaFinReal(Date fechaFinReal) {
		this.fechaFinReal = fechaFinReal;
	}
	public double getVentaPrevisto() {
		return ventaPrevisto;
	}
	public void setVentaPrevisto(double ventaPrevisto) {
		this.ventaPrevisto = ventaPrevisto;
	}
	public double getCostesPrevisto() {
		return costesPrevisto;
	}
	public void setCostesPrevisto(double costesPrevisto) {
		this.costesPrevisto = costesPrevisto;
	}
	public double getCosteReal() {
		return costeReal;
	}
	public void setCosteReal(double costeReal) {
		this.costeReal = costeReal;
	}
	public int getJefeProyecto() {
		return jefeProyecto;
	}
	public void setJefeProyecto(int jefeProyecto) {
		this.jefeProyecto = jefeProyecto;
	}
	
	
	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	//Tambien se genera el toString con todo.
	
	@Override
	public String toString() {
		return "Proyecto [idProyecto=" + idProyecto + ", descripcion=" + descripcion + ", fechaInicio=" + fechaInicio
				+ ", fechaFinPrevisto=" + fechaFinPrevisto + ", fechaFinReal=" + fechaFinReal + ", ventaPrevisto="
				+ ventaPrevisto + ", costesPrevisto=" + costesPrevisto + ", costeReal=" + costeReal + ", estado="
				+ estado + ", jefeProyecto=" + jefeProyecto + ", cliente=" + cliente + "]";
	}
	
	//A continuacion, se generan el hashCode y el equals, teniendo en cuenta que 2 proyectos son iguales si su idProyecto es el mismo.
	@Override
	public int hashCode() {
		return Objects.hash(idProyecto);
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Proyecto other = (Proyecto) obj;
		return Objects.equals(idProyecto, other.idProyecto);
	}
	
	/*
     * Se crean los siguientes metodos propios de la clase:
     * margenPrevisto():double. Importe de venta – coste previsto
        margenReal(): double Importe de venta – gastos reales
        diferenciaGastos(): double. Gasto real – gasto previsto
        diferenciaFinPrevistoReal(): int . Días entre fin previsto y fin real

        Para los 3 primeros se realiza una resta normal entre los importes aportados.
    */

    public double margenPrevisto() {
        return ventaPrevisto - costesPrevisto;
    }

    public double margenReal() {
        return ventaPrevisto - costeReal;
    }

    public double diferenciaGastos() {
        return costeReal - costesPrevisto;
    }

    /*
     * Para este ultimo metodo vamos a obtener la diferencia de las fechas respecto al 1 de enero de 1970,
     * para lo que se usa getTime. Como esto devuelve un long y queremos que el metodo devuelva un entero,
     * se realiza un casting para ambas fechas.
     */
    
    public int diferenciaFinPrevistoReal() {
        return (int)fechaFinPrevisto.getTime() - (int)fechaFinReal.getTime();
    }

	
	
	
	
	
	
	
}
