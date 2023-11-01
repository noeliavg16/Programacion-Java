package modelo.testing;

import modelo.dao.DepartamentosDao;
import modelo.dao.DepartamentosDaoImplMy8;
import modelo.javabeans.Departamentos;


/**
 * Creamos una clase Test para probar todos los metodos de la Clase DepartamoentosDao
 * 
 * @autor Gerard_Perujo
 */

public class TestDepartamentos {

	public static void main(String[] args) {
		
		DepartamentosDao depart = new DepartamentosDaoImplMy8();
		
		Departamentos depart1 = new Departamentos(60, "Mantenimiento", "Gerona");
		
		System.out.println("************************");
		
		System.out.println("Usamos el metodos crearDepartamento(), vamos a agregar un nuevo departamento"
				 + "en la base de datos, en caso de que no se cree saldra 0, y si se ha creado saldra 1");
		System.out.println(depart.crearDepartamento(depart1));
		System.out.println("============================================================================");
		
		
		System.out.println("Usamos el metodo buscarUno(), vamos a buscar el departamento id 20, en la base"
				+ " de datos");
		System.out.println(depart.buscarUno(20));
		System.out.println("============================================================================");
		
		
		System.out.println("Usamos el metodo modificarDepartamento() vamos a modificar los valores"
				+ "del departamento id 60");
		Departamentos depart2 = depart.buscarUno(60);
		depart2.setNombre("Limpieza");
		depart2.setDireccion("Barcelona");
		System.out.println(depart.modificarDepartamento(depart2));
		System.out.println(depart.buscarUno(60));
		System.out.println("============================================================================");
		
		
		System.out.println("Usamos el metodo eliminarDepartamento(), vamos a eliminar el departamento con "
				+ "id 60, en caso de que no se elimine saldra 0, y si se elimina saldra 1");
		System.out.println(depart.eliminarDepartamento(60));
		System.out.println("============================================================================");
	}

}
