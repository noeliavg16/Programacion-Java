package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Proyecto;

public class ProyectoDaoImplMy8 extends AbstractConexionMy8 implements ProyectoDao{

	/*
	 * Se crea la implementacion de ProyectoDao para bases de datos.
	 * Para ello se extiende del abstracto para conseguir conectar con la base de datos
	 * y se emplementa del Dao para obtener los metodos de dicha interface.
	 * Posteriormente se añaden los metodos no implementados y se modifican.
	 *

	    /*
	     * Necesito tener acceso a los datos de Cliente para poder relacionar en cif, 
	     * en ocasiones mediante un getCif y en otras (en los set) a traves de un buscarUno del impl de Clientes.
	    */
	    ClienteDao cli = new ClienteDaoImplList();

	    /*
	     * En primer lugar se añaden los metodos CRUD y el buscarTodos().
	     * Con el metodo de alta, se pueden añadir mas proyectos a la base de datos.
	     */
	    @Override
	    public int altaProyecto(Proyecto proyecto) {
	        sql = "insert into proyectos values (?,?,?,?,?,?,?,?,?,?,?)";
	        filas = 0;
	        try {
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, proyecto.getIdProyecto());
	            ps.setString(2, proyecto.getDescripcion());
	            ps.setDate(3, proyecto.getFechaInicio());
	            ps.setDate(4, proyecto.getFechaFinPrevisto());
	            ps.setDate(5, proyecto.getFechaFinReal());
	            ps.setDouble(6, proyecto.getVentaPrevisto());
	            ps.setDouble(7, proyecto.getCostesPrevisto());
	            ps.setDouble(8, proyecto.getCosteReal());
	            ps.setString(9, proyecto.getEstado());
	            ps.setInt(10, proyecto.getJefeProyecto());
	            ps.setString(11, proyecto.getCliente().getCif());

	            filas = ps.executeUpdate();
	            filas = 1;
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return filas;
	    }
	/*
	     * Para suprimir un proyecto concreto, se añade el campo clave del que se desea eliminar, 
	     * de tal manera que desaparece de la base de datos.
	     */
	    @Override
	    public int eliminarProyecto(String idProyecto) {
	        sql = "delete from proyectos where id_proyecto = ?";
	        filas = 0;
	        try {
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, idProyecto);

	            filas = ps.executeUpdate();
	            filas= 1;
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return filas;
	    }

	    //El metodo modificar permite alterar todos los valores de un objeto entero especifico en la base de datos.
	    @Override
	    public int modificarProyecto(Proyecto proyecto) {
	        sql = "update proyectos set Descripcion =?,Fecha_Inicio=?,Fecha_Fin_Previsto=?,Fecha_Fin_Real=?,Venta_Previsto=?,Costes_Previsto=?,Coste_Real=?,Estado=?,Jefe_Proyecto=?,Cif=? where id_proyecto =?";
	        try {
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, proyecto.getDescripcion());
	            ps.setDate(2, proyecto.getFechaInicio());
	            ps.setDate(3, proyecto.getFechaFinPrevisto());
	            ps.setDate(4, proyecto.getFechaFinReal());
	            ps.setDouble(5, proyecto.getVentaPrevisto());
	            ps.setDouble(6, proyecto.getCostesPrevisto());
	            ps.setDouble(7, proyecto.getCosteReal());
	            ps.setString(8, proyecto.getEstado());
	            ps.setInt(9, proyecto.getJefeProyecto());
	            ps.setString(10, proyecto.getCliente().getCif());
	            ps.setString(11, proyecto.getIdProyecto());

	            filas = ps.executeUpdate();
	            filas = 1;
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return filas;
	    }
	//Mediante buscarUno se pretende encontrar un registro concreto, para lo que es necesario especificar el id.
	    @Override
	    public Proyecto buscarUno(String idProyecto) {
	        sql = "select * from proyectos where id_proyecto =?";
	        Proyecto pro = null;{
	            try {
	                ps= conn.prepareStatement(sql);
	                ps.setString(1, idProyecto);
	                rs= ps.executeQuery();
	                if (rs.next()) {
	                    pro = new Proyecto();
	                    pro.setIdProyecto(rs.getString("id_proyecto"));
	                    pro.setDescripcion(rs.getString("Descripcion"));
	                    pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
	                    pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
	                    pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
	                    pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
	                    pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
	                    pro.setCosteReal(rs.getDouble("Coste_Real"));
	                    pro.setEstado(rs.getString("Estado"));
	                    pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
	                    pro.setCliente(cli.buscarUno(rs.getString(11)));

	                }

	            }catch (SQLException e) {
	                e.printStackTrace();
	            }
	            return pro;
	        }
	    }
	//Este metodo busca en toda la base de datos y devuelve un listado completo de los campos y valores que figuran en proyectos.
	    @Override
	    public List<Proyecto> buscarTodos() {
	        sql = "select * from proyectos";

	        List<Proyecto> lista = new ArrayList<>();
	        ProyectoDao podao = new ProyectoDaoImplMy8();
	        try {
	            ps = conn.prepareStatement(sql);
	            rs=ps.executeQuery();
	            while (rs.next()) {
	                Proyecto pro = new Proyecto();
	                pro.setIdProyecto(rs.getString("id_proyecto"));
	                pro.setDescripcion(rs.getString("Descripcion"));
	                pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
	                pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
	                pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
	                pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
	                pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
	                pro.setCosteReal(rs.getDouble("Coste_Real"));
	                pro.setEstado(rs.getString("Estado"));
	                pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
	                pro.setCliente(cli.buscarUno(rs.getString(11)));;

	                lista.add(pro);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }
	/*
	     * Una vez definidos los metodos del CRUD y el buscarTodos se van a alterar el resto de metodos añadidos.
	     * Para el metodo proyectosByEstado, se especifica el estado que queremos buscar 
	     * y nos devuelve un listado completo con todos los registros cuyo estado coincide con nuestra busqueda.
	     */
	    @Override
	    public List<Proyecto> proyectosByEstado(String estado) {
	        sql = "select* from proyectos where estado = ?";

	        List<Proyecto> lista = new ArrayList<>();
	        ProyectoDao podao = new ProyectoDaoImplMy8();
	        try {
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, estado);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                Proyecto pro = new Proyecto();
	                pro.setIdProyecto(rs.getString("id_proyecto"));
	                pro.setDescripcion(rs.getString("Descripcion"));
	                pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
	                pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
	                pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
	                pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
	                pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
	                pro.setCosteReal(rs.getDouble("Coste_Real"));
	                pro.setEstado(rs.getString("Estado"));
	                pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
	                pro.setCliente(cli.buscarUno(rs.getString(11)));
	                lista.add(pro);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }
	    
	    /*
	     * Para este metodo, se especifica el cliente que se desea buscar mediante el cif
	     * y nos devuelve un listado completo de los proyecto del cliente con dicho cif.
	    */
	    
	    @Override
	    public List<Proyecto> proyectosByCliente(String cif) {
	sql = "select* from proyectos where cif = ?";

	        List<Proyecto> lista = new ArrayList<>();
	        ProyectoDao podao = new ProyectoDaoImplMy8();
	        try {
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, cif);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                Proyecto pro = new Proyecto();
	                pro.setIdProyecto(rs.getString("id_proyecto"));
	                pro.setDescripcion(rs.getString("Descripcion"));
	                pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
	                pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
	                pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
	                pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
	                pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
	                pro.setCosteReal(rs.getDouble("Coste_Real"));
	                pro.setEstado(rs.getString("Estado"));
	                pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
	                pro.setCliente(cli.buscarUno(rs.getString(11)));
	                lista.add(pro);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }
	   /*
	     * En esta ocasion hay que especificar dos parametros, de tal manera que el metodo devuelve
	     * un listado completo de los proyectos cuyo jefe de proyecto y estado coincidan ambos con los valores introducidos en la busqueda.
	    */
	    @Override
	    public List<Proyecto> proyectosByJefeProyectoAndByEstado(int jefeProyecto, String estado) {
	        sql = "select* from proyectos where jefe_proyecto = ? and estado=?";

	        List<Proyecto> lista = new ArrayList<>();
	        ProyectoDao podao = new ProyectoDaoImplMy8();
	        try {
	            ps = conn.prepareStatement(sql);
	            ps.setInt(1, jefeProyecto);
	            ps.setString(2, estado);
	            rs = ps.executeQuery();
	            while (rs.next()) {
	                Proyecto pro = new Proyecto();
	                pro.setIdProyecto(rs.getString("id_proyecto"));
	                pro.setDescripcion(rs.getString("Descripcion"));
	                pro.setFechaInicio(rs.getDate("Fecha_Inicio"));
	                pro.setFechaFinPrevisto(rs.getDate("Fecha_Fin_Previsto"));
	                pro.setFechaFinReal(rs.getDate("Fecha_Fin_Real"));
	                pro.setVentaPrevisto(rs.getDouble("Venta_Previsto"));
	                pro.setCostesPrevisto(rs.getDouble("Costes_Previsto"));
	                pro.setCosteReal(rs.getDouble("Coste_Real"));
	                pro.setEstado(rs.getString("Estado"));
	                pro.setJefeProyecto(rs.getInt("Jefe_Proyecto"));
	                pro.setCliente(cli.buscarUno(rs.getString(11)));
	                lista.add(pro);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return lista;
	    }
	  /*
	     * Este metodo devuelve el resultado del sumatorio de todas las ventas previstas.
	     * No hay que pasarle nada porque obtiene los sumandos desde la propia base de datos.
	     */
	    @Override
	    public double importesVentaProyectosTerminados() {
	        sql = "select sum(venta_previsto) as importes from proyectos";
	        double importes = 0;
	        try {
	            ps = conn.prepareStatement(sql);
	            rs = ps.executeQuery();
	            if(rs.next()) {
	                importes = rs.getDouble("importes");
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return importes;
	    }
	/*
	     * Este metodo devuelve la diferencia entre el sumatorio de los importes de venta y el sumatorio de los gastos reales.
	     * Al igual que en el caso anterior, no hay que añadir ningun parametro.
	     */
	    @Override
	    public double margenBrutoProyectosTerminados() {
	        sql = "select sum(venta_previsto) - sum(coste_real) as margen from proyectos";
	        double margen = 0;
	        try {
	            ps = conn.prepareStatement(sql);
	            rs = ps.executeQuery();
	            if(rs.next()) {
	                margen = rs.getDouble("margen");
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return margen;
	    }

	    /*
	     * Finalmente, en este ultimo metodo, hay que averiguar cuantos días quedan para terminar el proyecto.
	     * Esto se obtiene de la diferencia entre fecha_fin_previsto y la fecha de hoy.
	     */
	    @Override
	    public int diasATerminoProyectoActivo(String codigoProyecto) {
	        sql = "select datediff (Fecha_Fin_Previsto, current_date())  from proyectos where id_proyecto =?";
	        int dias = 0;
	        try {
	            ps = conn.prepareStatement(sql);
	            ps.setString(1, codigoProyecto);
	            rs = ps.executeQuery();
	            if(rs.next()) {
	                dias = rs.getInt(1);
	            }
	        }catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return dias;
	    }
}