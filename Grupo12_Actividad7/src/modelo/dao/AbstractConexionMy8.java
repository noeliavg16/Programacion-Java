package modelo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import modelo.conexion.ConexionDaoMy8;

/**
 * Creamos la Clase abtracta conexion para evitar de tener que crear una conexion en cada clase de esta 
 * forma solo tenemos que importar la clase conexion dentro de la clase en question
 * 
 * @author Gerard_Perujo
 *
 */
public class AbstractConexionMy8 {
	
	protected Connection conn;
	protected PreparedStatement ps;
	protected ResultSet rs;
	protected String sql;
	protected int filas;
	
	
	public AbstractConexionMy8() {
		conn = ConexionDaoMy8.conectar();
	}

}
