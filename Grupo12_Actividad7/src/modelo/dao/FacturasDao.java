package modelo.dao;

import java.util.List;

import modelo.javabeans.Facturas;
import modelo.javabeans.Proyecto;

public interface FacturasDao {
	//Se crean el CRUD y el metodo buscarTodos
	int altaFactura (Facturas facturas);
	int eliminarFactura (String idFactura);
	int modificarProyecto (Facturas facturas);
	Facturas buscarUno (String idFactura);
	List<Facturas> buscarTodos();

}
