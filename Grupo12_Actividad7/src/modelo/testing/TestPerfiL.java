package modelo.testing;

import modelo.dao.PerfilDao;
import modelo.dao.PerfilDaoImplMy8;
import modelo.javabeans.Perfil;

/**
 * Creamos un Test para probar todos los metodos de la Clase Perfil y que funcionen correctamente
 * 
 * @author Gerard_Perujo
 *
 */
public class TestPerfiL {

	public static void main(String[] args) {
		
		PerfilDao perfil = new PerfilDaoImplMy8();
		
		Perfil perf = new Perfil( 5, "Director", 60);
		
		System.out.println("************************");
		
		
		System.out.println("Usamos el metodo crerPerfil(), vamos a crear un nuevo perfil a la base de datos");
		System.out.println("En caso de que no este creado como resultado salra 1, si esta creado el resultado,"
				+ " sera 0");
		System.out.println(perfil.crearPerfil(perf));
		System.out.println(perfil.buscarUno(5));
		System.out.println("========================================================================");
		
		System.out.println("Usamos el metodo buscarUno(), vamos a buscar el perfil con id_perfil = 2");
		System.out.println(perfil.buscarUno(2));
		System.out.println("========================================================================");
		
		System.out.println("Usamos el metodo modificarPerfil(), vamos a modificar los parametos del perfil 5");
		Perfil perfil2 = perfil.buscarUno(5);
		perfil2.setNombre("Director General");
		perfil2.setPrecio_hora(90);
		System.out.println(perfil.modificarPerfil(perfil2));
		System.out.println(perfil.buscarUno(5));
		System.out.println("========================================================================");
		
		System.out.println("Usamos el metodo eliminarPerfil(), vamos a eliminar el perfil id 5"
				+ "en caso de que no se elimine saldra 0, y si se elimina saldra 1");
		System.out.println(perfil.eliminarPerfil(5));
		System.out.println("========================================================================");
		

	}

}
