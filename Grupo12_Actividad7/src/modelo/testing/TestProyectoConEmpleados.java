package modelo.testing;

import java.sql.Date;

import modelo.dao.EmpleadoDaoImplMy8;
import modelo.dao.ProyectoConEmpleadosDao;
import modelo.dao.ProyectoConEmpleadosDaoImplMy8;
import modelo.dao.ProyectoDaoImplMy8;
import modelo.javabeans.Empleados;
import modelo.javabeans.Facturas;
import modelo.javabeans.Proyecto;
import modelo.javabeans.ProyectoConEmpleados;

public class TestProyectoConEmpleados {

	public static void main(String[] args) {
		/*
		 * Creo un objeto de la clase ProyectoConEmpleadosDao.
		 * Tambien incorporo objetos de las clases Empleado y Proyecto, ya que van a ser necesarios para
		 * utilizar el idEmpl o el idProyecto cuando sea necesario.
		 */
		ProyectoConEmpleadosDao pced = new ProyectoConEmpleadosDaoImplMy8();
		EmpleadoDaoImplMy8 employee = new EmpleadoDaoImplMy8();
		ProyectoDaoImplMy8 proye = new ProyectoDaoImplMy8();
		
		/*
		 * Si se consigue dar de alta el proyecto con empleados devuelve un 1.
		 * En caso contrario se devuelve un 0.
		 */
		System.out.println("Creamos nuevo proyecto con empleados");
		Date incorporacion = new Date(120, 3, 8);
		ProyectoConEmpleados pce = new ProyectoConEmpleados(5, proye.buscarUno("FOR2020001"), employee.buscarUno(100), 50, incorporacion);
		System.out.println(pced.altaProyectoConEmpleados(pce));
		System.out.println("Buscamos el nuevo proyecto");
		System.out.println(pced.buscarUno(5));
		System.out.println(" ");
		
		/*
		 * Al igual que en el caso anterior, si la operacion de modificar es satisfactoria retorna 1.
		 * Si no se ha modificado devuelve 0.
		 */
		System.out.println("Modificamos el nuevo proyecto con empleados, concretamente las horas asignadas");
		ProyectoConEmpleados con = pced.buscarUno(5);
		con.setHorasAsignadas(74);
		System.out.println(pced.modificarProyecto(con));
		//Buscamos ese mismo proyecto para verificar que se ha modificado
		System.out.println(pced.buscarUno(5));
		System.out.println(" ");
		
		/*
		 * Para eliminar el proyecto con empleados tambien se devolvera 1 si realmente ha sido eliminado, 0 en caso contrario.
		 */
		System.out.println("Eliminamos el proyecto con empleados creado");
		System.out.println(pced.eliminarProyectoConEmpleados(5));
		System.out.println(" ");
		
		/*
		 * Se va a buscar el proyecto con empleados que figura en la base de datos con el numero de orden 1.
		 */
		System.out.println("Ahora vamos a buscar un proyecto con empleados");
		System.out.println(pced.buscarUno(1));
		System.out.println(" ");
		
		/*
		 * Se va a buscar el listado completo con todos los proyectos con empleados.
		 */
		System.out.println("Buscamos todos los proyectos con empleados");
		for(ProyectoConEmpleados ele: pced.buscarTodos())
			System.out.println(ele);
		System.out.println(" ");
		
		System.out.println("Ahora se probaran otros metodos pedidos");
		
		//Buscamos los empleados por proyecto
		System.out.println("Buscamos empleados por proyecto cuya clave es FOR2020001");
		for (ProyectoConEmpleados ele: pced.empleadosByProyecto("FOR2020001"))
			System.out.println(ele);
		System.out.println(" ");
		
		//Asignamos empleados a proyectos
		System.out.println(" ");
		
		//Queremos conocer las horas asignadas a un proyecto
		System.out.println("Hallamos las horas asignadas al proyecto FOR2021001");
		System.out.println(pced.horasAsignadasAProyecto("FOR2021001"));
		System.out.println(" ");
		
		//Averiguamos el coste de un proyecto
		System.out.println("Queremos saber el coste del proyecto FOR2020001");
		System.out.println(pced.costeActualDeProyecto("FOR2020001"));
	
		System.out.println(" ");
		
		//Finalmente queremos saber el margen de un determinado proyecto
		System.out.println("Descubrimos el margen del proyecto FOR2020001");
		System.out.println(pced.margenActualProyecto("FOR2020001"));
		
		System.out.println("FIN DE PRUEBAS");
	}

}
