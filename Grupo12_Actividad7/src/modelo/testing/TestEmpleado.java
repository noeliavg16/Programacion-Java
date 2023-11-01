package modelo.testing;


import java.sql.Date;

import modelo.dao.DepartamentosDao;
import modelo.dao.DepartamentosDaoImplMy8;
import modelo.dao.EmpleadoDao;
import modelo.dao.EmpleadoDaoImplMy8;
import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8;
import modelo.javabeans.Departamentos;
import modelo.javabeans.Empleados;
import modelo.javabeans.Perfil;


/**
 * Creamos la clase testEmpleado para probar todos los metodos del EmpleadoDaoImplMy8
 * 
 * @author Gerard_Perujo
 *
 */
public class TestEmpleado {

	public static void main(String[] args) {
		

		PerfilDao perf = new PerfilDaoImplMy8();
		DepartamentosDao depar = new DepartamentosDaoImplMy8();
		EmpleadoDao empleado = new EmpleadoDaoImplMy8();
		
		Date ingreso = new Date(121, 9, 10);
		Date nacimiento = new Date(0, 3, 8);
		Empleados empl = new Empleados(200, "Pepe", "Rodriguez", "H", "prodriguez@tt.com", "pepe", 50000, ingreso, 
				nacimiento ,perf.buscarUno(1), depar.buscarUno(10));
		
	
		System.out.println("-----------------------------------------------------------------------------------");
		
		System.out.println("Usamos el metodo crearEmpleado(), vamos a crear un nuevo empleado en la base de datos"
				+ " si el resultado es 0, no se ha creado nada, y si el resultado es 1, si que se ha creado");
		System.out.println(empleado.crearEmpleado(empl));
		System.out.println(empleado.buscarUno(200));
		System.out.println("====================================================================================");
				
		
		
		System.out.println("Usamos el metodo buscarUno(), vamos a buscar el empleado con id 114");
		System.out.println(empleado.buscarUno(114));
		System.out.println("====================================================================================");
		
		System.out.println("Usamos el metodo modificarEmpleado(), vamos a modificar el empleado con id 200"
				+ "en el caso de que no se modifique saldra 0, si se modifica saldra 1");
		Empleados empl2 = empleado.buscarUno(200);
		empl2.setNombre("Laura");
		empl2.setApellidos("Cruz");
		empl2.setGenero("M");
		empl2.setEmail("lcruz@tt.com");
		empl2.setPassword("laura");
		empl2.setSalario(69200);
		empl2.setFechaIngreso(ingreso);
		empl2.setFechaNacimiento(nacimiento);
		empl2.setPerfil(perf.buscarUno(2));
		empl2.setDepartamentos(depar.buscarUno(30));
		
		System.out.println(empleado.modificarEmpleado(empl2));
		System.out.println(empleado.buscarUno(200));
		System.out.println("====================================================================================");
		
		
		System.out.println("Usamos el metodo eliminarEmpleado() vamos a eliminar el empleado con di 200"
				+ " en caso de que no se elimine saldra 0, si se elimina saldra un 1");
		System.out.println(empleado.eliminarEmpleado(200));
		System.out.println("====================================================================================");
		
		
		System.out.println("Usamos el metodo buscarTodos(), vamos a sacaar la informacion de todos los empleados"
				+ "de la base de datos");
			for(Empleados ele: empleado.buscarTodos())
				System.out.println(ele);
		
		System.out.println("====================================================================================");
		
		
		System.out.println("Usamos el metodo empleadoByDepartamento(), pasamos un id del departamento y nos saca los empleados"
				+ " que tienen ese departamento");
		
			for (Empleados ele: empleado.empleadoByDepartamento(20)) {
				System.out.println(ele);
			}
		System.out.println("====================================================================================");
			
		
		System.out.println("Usamos el metodo empleadosBySexo(), pasamos un caracter y nos saca los empleados que son"
				+ " del mismo sexo");
		for(Empleados ele: empleado.empleadosBySexo('M'))
			System.out.println(ele);
		System.out.println("====================================================================================");
		
		
		
		System.out.println("Usamos el metodo empleadoByApellido() pasamos un apellido y nos saca el empleado o los"
				+ "empleados que tengan ese apellido");
		for (Empleados ele: empleado.empleadosByApellido("koo"))
			System.out.println(ele);
		System.out.println("====================================================================================");
		
		
		
		System.out.println("Usamos el metodo salarioTotal(), y sumamos todos los salarios dentro de la tabla empleados");
		System.out.println(empleado.salarioTotal());
		System.out.println("====================================================================================");
			
		
		System.out.println("Usamos el metodo salarioTotal(int iddepar), vamos a dar un id de un departamento"
				+ " y sumaremos todos los salarios con ese id departamento");
		System.out.println(empleado.salarioTotal(10));
		
	}

}
