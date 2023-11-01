package modelo.dao;

import java.sql.SQLException;

import modelo.javabeans.Departamentos;

/**
 * Creo la clase departamentos impl e importo los metodos de la interface y tambien agrego la 
 * clase conexion para que se pueda conectar en la base de datos
 * 
 * @author Gerard_Perujo
 *
 */

public class DepartamentosDaoImplMy8 extends AbstractConexionMy8 implements DepartamentosDao {
	
	private Departamentos depar;
	
	public DepartamentosDaoImplMy8() {
		depar = new Departamentos();
	}

	/**
	 * Creamos un departamento nuevo dentro de la base de datos
	 */
	@Override
	public int crearDepartamento(Departamentos departamento) {
		sql = "insert into departamentos values (?,?,?)";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, departamento.getIdDepar());
			ps.setString(2, departamento.getNombre());
			ps.setString(3, departamento.getDireccion());
			
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas;
	}

	/**
	 * Con este metodo le pasamos un id departamento y nos busca
	 * el departamento en question en la base de datos
	 */
	@Override
	public Departamentos buscarUno(int idDepar) {
		sql = "select* from departamentos where id_depar = ?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			rs = ps.executeQuery();
			if (rs.next())
				depar = new Departamentos();
				crearDepartamentos(depar);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return depar;
	}

	/**
	 * Con este metodo podemos modificar un departamento entero pasandole
	 * todos los valores de cada campo
	 */
	@Override
	public int modificarDepartamento(Departamentos departamento) {
		sql = "update departamentos set nombre = ?, direccion = ? "
				+ " where id_depar = ?";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			
			ps.setString(1, departamento.getNombre());
			ps.setString(2, departamento.getDireccion());
			ps.setInt(3, departamento.getIdDepar());
			
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas;
	}

	/**
	 * Con este metodo le pasas una id de departamento y te elimina el departamento
	 * de la base de datos que le has pasado
	 */
	@Override
	public int eliminarDepartamento(int idDepar) {
		sql = "delete from departamentos where id_depar = ?";
		
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, idDepar);
			filas = ps.executeUpdate();
			filas = 1;
			} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return filas;
	}

	/**
	 * Creo un metodo crear departamentos para poder crear un objeto departamentio
	 * y evitar crear un objeto dentro de cada metodo
	 */
	public void crearDepartamentos(Departamentos departamento) throws SQLException {
		departamento.setIdDepar(rs.getInt(1));
		departamento.setNombre(rs.getString(2));
		departamento.setDireccion(rs.getString(3));
	}
}
