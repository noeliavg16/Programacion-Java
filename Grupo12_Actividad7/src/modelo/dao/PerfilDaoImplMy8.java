package modelo.dao;

import java.sql.SQLException;

import modelo.javabeans.Perfil;

/**
 * Creo la clase Perfil dao impl i implemento los metodos de la interface y tambien
 * agrego la conexion para que se pueda conectar a la base de datos
 * 
 * @author Gerard_Perujo
 *
 */

public class PerfilDaoImplMy8 extends AbstractConexionMy8 implements PerfilDao{
	
	
	/**
	 * creo una variable de tipo perfil y creo un objeto perfil para evitar tener
	 * que crear un objeto todas las veces
	 */
	private Perfil perf;
	
	public PerfilDaoImplMy8() {
		perf = new Perfil();
	}

	
	/**
	 * Crea un Perfil nuevo dentro de la base de datos
	 */
	@Override
	public int crearPerfil(Perfil perfil) {
		sql = "insert into perfiles values (?,?,?)";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, perfil.getIdPerfil());
			ps.setString(2, perfil.getNombre());
			ps.setDouble(3, perfil.getPrecio_hora());
			
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	/**
	 * Busca un perfil con el id_perfil que le pases
	 */
	@Override
	public Perfil buscarUno(int idPerfil) {
		sql = "select* from perfiles where id_perfil = ?";
		
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idPerfil);
			rs = ps.executeQuery();
			if (rs.next())
				perf = new Perfil();
				crearPerfiles(perf);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return perf;
	}

	/**
	 * modifica un perfil entero agregandole todos los valores
	 */
	@Override
	public int modificarPerfil(Perfil perfil) {
		sql = "update perfiles set nombre = ?, precio_hora = ? "
				+ "where id_perfil = ?";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, perf.getNombre());
			ps.setDouble(2, perf.getPrecio_hora());
			ps.setInt(3, perf.getIdPerfil());
			
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	/**
	 * Elimina un perfil en la base de datos pasandole el id del perfil
	 */
	@Override
	public int eliminarPerfil(int idPerfil) {
		sql = "delete from perfiles where id_perfil = ?";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idPerfil);
			filas = ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}
	
	
	/**
	 * Creo el metodo crear perfil para no tener
	 * que crear en cada metodo un objeto perfil nuevo
	 * 
	 */
	public void crearPerfiles(Perfil perfil) throws SQLException{
		
		perfil.setIdPerfil(rs.getInt(1));
		perfil.setNombre(rs.getString(2));
		perfil.setPrecio_hora(rs.getDouble(3));
		
		
		
		
	}

}
