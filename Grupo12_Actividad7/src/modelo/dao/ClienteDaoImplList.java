package modelo.dao;
import java.sql.SQLException;
import modelo.javabeans.Cliente;
import java.util.ArrayList;
import java.util.List;


public class ClienteDaoImplList extends AbstractConexionMy8 implements ClienteDao{
	
	
	
	private Cliente cli; 
	
	public ClienteDaoImplList() {
		cli = new Cliente(); 
	}
	
	
	
	@Override
	public int altaCliente(Cliente cliente) {
		
		 sql = "insert into clientes values (?,?,?,?,?,?)";
		
		int filas = 0; 
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getCif());
			ps.setString(2, cliente.getNombre());
			ps.setString(3, cliente.getApellidos());
			ps.setString(4, cliente.getDomicilio());
			ps.setDouble(5, cliente.getFacturacionAnual());
			ps.setInt(6, cliente.getNumeroEmpleados());
			
			filas = ps.executeUpdate(); 
			filas = 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas;
		
	}
	
	
	
	@Override
	public int eliminarCliente(String cif) {
		// TODO Auto-generated method stub
		
		 sql = "delete from clientes where cif = ?"; 
		
		int filas = 0; 
		
		try {
			ps = conn.prepareStatement(sql); 
			ps.setString(1, cif);
			filas = ps.executeUpdate();
			filas = 1; 
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
		e.printStackTrace();
			
		}
		return filas;
	}

	
	
	@Override
	public Cliente buscarUno(String cif) {
		
		 sql = "Select* from clientes where cif = ?";
		
		try {
			
			ps = conn.prepareStatement(sql); 
			ps.setString(1, cif);
			rs = ps.executeQuery();
			
			if (rs.next())
				cli = new Cliente();
				empleados(cli); 
				
		} catch (SQLException e) {
			// TODO Auto-generated method stub
			e.printStackTrace();
			
		}
		
		return cli;
	}
	
	
	
	@Override
	public List<Cliente> buscarTodos() {
		
		 sql = "Select* from clientes"; 
		
		List<Cliente> lista = new ArrayList<>(); 
		
		try {
			ps = conn.prepareStatement(sql); 
			rs = ps.executeQuery(); 
			while (rs.next()) {
				
				Cliente cli = new Cliente(); 
				
				empleados(cli); 
	
				
				lista.add(cli); 
		} 
		
		
	} catch (SQLException e) {
		e.printStackTrace();
	}
		return lista;


}

	@Override
	public int modificarCliente(Cliente cliente) {
		// TODO Auto-generated method stub
		sql = "Update cliente set nombre = ?, apellido = ?, domicilio = ?, facturacion_anual = ?, numero_empleados = ? where cif = ?"; 
		
		filas = 0; 
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, cliente.getNombre());
			ps.setString(2, cliente.getApellidos());
			ps.setString(3, cliente.getDomicilio());
			ps.setDouble(4, cliente.getFacturacionAnual());
			ps.setInt(5, cliente.getNumeroEmpleados());
			ps.setString(6, cliente.getCif()); 
			filas = ps.executeUpdate(); 
			filas = 1;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return filas;
	}
	
	
	
	public void empleados (Cliente cliente) throws SQLException {
		cli.setCif(rs.getString(1));
		cli.setNombre(rs.getString(2));
		cli.setApellidos(rs.getString(3));
		cli.setDomicilio(rs.getString(4));
		cli.setFacturacionAnual(rs.getDouble(5));
		cli.setNumeroEmpleados(rs.getInt(6));
	}
}