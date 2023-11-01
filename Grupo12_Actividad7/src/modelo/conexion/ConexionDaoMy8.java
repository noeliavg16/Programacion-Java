package modelo.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


/**
 * Creamos la clase conexion para podernos conectar con la base de datos
 * de Clientes Proyectos empleados 2023
 * 
 * @author Gerard_Perujo
 *
 */

public class ConexionDaoMy8 {
	
	/**
	 * Creamos unas variables de conexion y de url usuario y pasword que haran referencia a la
	 * direccion de la base de datos, el usuario y la contraseña de la base de datos
	 */
	private static Connection conn;
	private static String url, user, pasword;
	
	public ConexionDaoMy8() {
		
		url = "jdbc:mysql://localhost:3307/clientes_proyectos_empleados_2023?serverTimezone=UTC";
		user = "root";
		pasword = "root";
		
		try {
			conn = DriverManager.getConnection(url, user, pasword);
			System.out.println("Conexion Establecida");
		} catch (SQLException e) {
			System.out.println("Conexion no Establecida");
			e.printStackTrace();
		}
			
			
		
	}

	/**
	 * Creamos el metodo conectar cada vez que haya una nueva conexion se conectara
	 * en caso de que el programa ya se haya conectado no se volvera a conectar
	 * de esta forma el programa mejora en redimiento ya que no tiene que realizar una
	 * conexion en cada consulta
	 * 
	 */
	public static Connection conectar() {
		if ( conn == null)
			new ConexionDaoMy8();
		return conn;
	}
	
}
