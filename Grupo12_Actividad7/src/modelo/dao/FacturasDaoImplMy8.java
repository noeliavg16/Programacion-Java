package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Facturas;
import modelo.javabeans.ProyectoConEmpleados;

/*
 * Se crea la implementacion de FacturasDao para bases de datos.
 * Para ello se extiende del abstracto para conseguir conectar con la base de datos
 * y se emplementa del Dao para obtener los metodos de dicha interface.
 * Posteriormente se añaden los metodos no implementados y se modifican.
 */
public class FacturasDaoImplMy8 extends AbstractConexionMy8 implements FacturasDao{
	/*
	 * Necesito tener acceso a los datos de Proyecto para poder relacionar en idProyecto, 
	 * en ocasiones mediante un getIdProyecto y en otras (en los set) a traves de un buscarUno del impl de Proyecto.
	 */
	ProyectoDao proy = new ProyectoDaoImplMy8();
	
	//Mediante este metodo de alta, se pueden añadir mas facturas a la base de datos.
	@Override
	public int altaFactura(Facturas facturas) {
		sql = "insert into facturas values (?,?,?)";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, facturas.getIdFactura());
			ps.setString(2, facturas.getDescripcion());
			ps.setString(3, facturas.getProyecto().getIdProyecto());
			
			filas = ps.executeUpdate();
			filas = 1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}
	
	/*
	 * Para suprimir una factura concreta, se añade el campo clave de la que se desea eliminar, 
	 * de tal manera que desaparece de la base de datos.
	 */
	@Override
	public int eliminarFactura(String idFactura) {
		sql = "delete from facturas where id_factura = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idFactura);
			
			filas = ps.executeUpdate();
			filas= 1;	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	//El metodo modificar permite alterar todos los valores de un objeto entero especifico en la base de datos.
	@Override
	public int modificarProyecto(Facturas facturas) {
		sql = "update facturas set descripcion = ?, id_proyecto =? where id_factura = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, facturas.getDescripcion());
			ps.setString(2, facturas.getProyecto().getIdProyecto());
			ps.setString(3, facturas.getIdFactura());
			
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas;
	}
	
	//Mediante buscarUno se pretende encontrar un registro concreto, para lo que es necesario especificar el id.
	@Override
	public Facturas buscarUno(String idFactura) {
		sql = "select * from facturas where id_factura =?";
		Facturas fac = null;{
			try {
				ps= conn.prepareStatement(sql);
				ps.setString(1, idFactura);
				rs= ps.executeQuery();
				if (rs.next()) {
					fac = new Facturas();
					fac.setIdFactura(rs.getString("id_factura"));
					fac.setDescripcion(rs.getString("descripcion"));
					fac.setProyecto(proy.buscarUno(rs.getString("id_proyecto")));
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return fac;
		}
	}
	
	//Este metodo busca en toda la base de datos y devuelve un listado completo de los campos y valores que figuran en facturas.
	@Override
	public List<Facturas> buscarTodos() {
sql = "select * from facturas";
		
		List<Facturas> lista = new ArrayList<>();
		FacturasDao facdao = new FacturasDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				Facturas fa = new Facturas();
				fa.setIdFactura(rs.getString("id_factura"));
				fa.setDescripcion(rs.getString("descripcion"));
				fa.setProyecto(proy.buscarUno(rs.getString("id_proyecto")));
				
				lista.add(fa);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	}


