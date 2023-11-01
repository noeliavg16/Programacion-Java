package modelo.dao;

import java.util.List;

import modelo.javabeans.Proyecto;

public interface ProyectoDao {
	//Se realiza el CRUD y el buscarTodos.
		int altaProyecto (Proyecto proyecto);
		int eliminarProyecto (String idProyecto);
		int modificarProyecto (Proyecto proyecto);
		Proyecto buscarUno (String idProyecto);
		List<Proyecto> buscarTodos();
		
	//Otros metodos que hay que incorporar:
		List<Proyecto> proyectosByEstado(String estado);
		List<Proyecto> proyectosByCliente(String cif);
		List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado);
		double importesVentaProyectosTerminados();
		double  margenBrutoProyectosTerminados(); 
		int diasATerminoProyectoActivo(String codigoProyecto); 
		
		
		
}
