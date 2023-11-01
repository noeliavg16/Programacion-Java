package modelo.dao;

import java.util.List;

import modelo.javabeans.Empleados;

public interface EmpleadoDao {
	
	
	int crearEmpleado(Empleados empleado);
	Empleados buscarUno(int idEmpl);
	int modificarEmpleado(Empleados empleado);
	int eliminarEmpleado(int idEmpl);
	List<Empleados> buscarTodos();
	List<Empleados> empleadoByDepartamento(int idDepar);
	List<Empleados> empleadosBySexo(char sexo);
	List<Empleados> empleadosByApellido(String subcadena);
	double salarioTotal();
	double salarioTotal(int idDepar);

}
