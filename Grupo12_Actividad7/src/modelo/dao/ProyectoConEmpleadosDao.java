package modelo.dao;

import java.util.List;

import modelo.javabeans.Proyecto;
import modelo.javabeans.ProyectoConEmpleados;

public interface ProyectoConEmpleadosDao {
	//Se realiza el CRUD y el buscarTodos.
			int altaProyectoConEmpleados (ProyectoConEmpleados proyectoConEmpleados);
			int eliminarProyectoConEmpleados (int numeroOrden);
			int modificarProyecto (ProyectoConEmpleados proyectoConEmpleados);
			ProyectoConEmpleados buscarUno (int numeroOrden);
			List<ProyectoConEmpleados> buscarTodos();
	//Otros metodos que hay que incorporar:
			List<ProyectoConEmpleados> empleadosByProyecto(String codigoProyecto); 
			int asignarEmpleadosAProyecto(List <ProyectoConEmpleados> empelados); 
			int horasAsignadasAProyecto(String codigoProyecto); 
			double costeActualDeProyecto(String idProyecto);  
			double margenActualProyecto(String idProyecto);

}
