package modelo.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import modelo.javabeans.Empleados;
import modelo.javabeans.Proyecto;
import modelo.javabeans.ProyectoConEmpleados;

/*
 * Se crea la implementacion de ProyectoConEmpleadosDao para bases de datos.
 * Para ello se extiende del abstracto para conseguir conectar con la base de datos
 * y se emplementa del Dao para obtener los metodos de dicha interface.
 * Posteriormente se añaden los metodos no implementados y se modifican.
 */
public class ProyectoConEmpleadosDaoImplMy8 extends AbstractConexionMy8 implements ProyectoConEmpleadosDao{
	/*
	 * Necesito tener acceso a los datos de Proyecto y Empleados para poder relacionar en idProyecto e idEmpl, 
	 * en ocasiones mediante un getIdProyecto o getIdEmpl
	 * y en otras (en los set) a traves de un buscarUno del impl de Proyecto o de Empleados.
	 */
	ProyectoConEmpleados empl = new ProyectoConEmpleados();
	ProyectoDao proy = new ProyectoDaoImplMy8();
	EmpleadoDao edao = new EmpleadoDaoImplMy8();
	
	//Mediante este metodo de alta, se pueden añadir mas proyectos con empleados a la base de datos.
	@Override
	public int altaProyectoConEmpleados(ProyectoConEmpleados proyectoConEmpleados) {
		sql = "insert into proyecto_con_empleados values (?,?,?,?,?)";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, proyectoConEmpleados.getNumeroOrden());
			ps.setString(2,proyectoConEmpleados.getProyecto().getIdProyecto());
			ps.setInt(3, proyectoConEmpleados.getEmpleados().getIdEmpl());
			ps.setInt(4, proyectoConEmpleados.getHorasAsignadas());
			ps.setDate(5, proyectoConEmpleados.getFechaIncorporacion());
			
			filas = ps.executeUpdate();
			filas = 1;
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
		
	}

	/*
	 * Para suprimir un proyecto con empleados concreto, se añade el campo clave del que se desea eliminar, 
	 * de tal manera que desaparece de la base de datos.
	 */
	@Override
	public int eliminarProyectoConEmpleados(int numeroOrden) {
		sql = "delete from proyecto_con_empleados where numero_orden = ?";
		filas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, numeroOrden);
			
			filas = ps.executeUpdate();
			filas= 1;	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return filas;
	}

	//El metodo modificar permite alterar todos los valores de un objeto entero especifico en la base de datos.
	@Override
	public int modificarProyecto(ProyectoConEmpleados proyectoConEmpleados) {
		sql = "update proyecto_con_empleados set id_proyecto = ?, id_empl = ?, horas_asignadas=?, fecha_incorporacion =? where numero_orden = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, proyectoConEmpleados.getProyecto().getIdProyecto());
			ps.setInt(2, proyectoConEmpleados.getEmpleados().getIdEmpl());
			ps.setInt(3, proyectoConEmpleados.getHorasAsignadas());
			ps.setDate(4, proyectoConEmpleados.getFechaIncorporacion());
			ps.setInt(5, proyectoConEmpleados.getNumeroOrden());
			
			filas = ps.executeUpdate();
			filas = 1;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return filas;
	}

	//Mediante buscarUno se pretende encontrar un registro concreto, para lo que es necesario especificar el campo clave.
	@Override
	public ProyectoConEmpleados buscarUno(int numeroOrden) {
		sql = "select * from proyecto_con_empleados where numero_orden =?";
		ProyectoConEmpleados pce = null;{
			try {
				ps= conn.prepareStatement(sql);
				ps.setInt(1, numeroOrden);
				rs= ps.executeQuery();
				if (rs.next()) {
					pce = new ProyectoConEmpleados();
					pce.setNumeroOrden(rs.getInt("numero_orden"));
					pce.setProyecto(proy.buscarUno(rs.getString("id_proyecto")));
					pce.setEmpleados(edao.buscarUno(rs.getInt("id_empl")));
					pce.setHorasAsignadas(rs.getInt("horas_asignadas"));
					pce.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
				}
				
			}catch (SQLException e) {
				e.printStackTrace();
			}
			return pce;
		}
	}

	//Este metodo busca en toda la base de datos y devuelve un listado completo de los campos y valores que figuran en ProyectosConEmpleados.
	@Override
	public List<ProyectoConEmpleados> buscarTodos() {
	sql = "select * from proyecto_con_empleados";
		
		List<ProyectoConEmpleados> lista = new ArrayList<>();
		ProyectoConEmpleadosDao prodao = new ProyectoConEmpleadosDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while (rs.next()) {
				ProyectoConEmpleados proc = new ProyectoConEmpleados();
				proc.setNumeroOrden(rs.getInt("numero_orden"));
				proc.setProyecto(proy.buscarUno(rs.getString("id_proyecto")));
				proc.setEmpleados(edao.buscarUno(rs.getInt("id_empl")));
				proc.setHorasAsignadas(rs.getInt("horas_asignadas"));
				proc.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
				
				lista.add(proc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}
	
	/*
	 * Con este metodo se pretende buscar empleados por proyecto. Especifico el codigo de proyecto
	 * y se devuelve un listado completo con los empleados que forman parte de ese proyecto.
	 */
	@Override
	public List<ProyectoConEmpleados> empleadosByProyecto(String codigoProyecto) {
		sql = "select * from proyecto_con_empleados where numero_orden = ?";
		
		List<ProyectoConEmpleados> lista = new ArrayList<>();
		ProyectoConEmpleadosDao pced = new ProyectoConEmpleadosDaoImplMy8();
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, codigoProyecto);
			rs = ps.executeQuery();
			while (rs.next()) {
				ProyectoConEmpleados proc = new ProyectoConEmpleados();
				proc.setNumeroOrden(rs.getInt("numero_orden"));
				proc.setProyecto(proy.buscarUno(rs.getString("id_proyecto")));
				proc.setEmpleados(edao.buscarUno(rs.getInt("id_empl")));
				proc.setHorasAsignadas(rs.getInt("horas_asignadas"));
				proc.setFechaIncorporacion(rs.getDate("fecha_incorporacion"));
				
				lista.add(proc);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	/*
	 * En este metodo, se añade un listado con los empleados que se quieren asignar a un proyecto
	 * y devuelve un entero con el numero de empleados que hay en un proyecto
	 */
	
	
	
	
	/*
	 * Con este metodo, especificamos el proyecto del que queremos saber el sumatorio de las horas
	 * y nos devuelve un entero con las horas totales asignadas a los empleados en ese proyecto.
	 */
	@Override
	public int horasAsignadasAProyecto(String codigoProyecto) {
		sql = "  select sum(horas_asignadas) from proyecto_con_empleados where id_proyecto = ?";
		int horas = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, codigoProyecto);
			rs = ps.executeQuery();
			if(rs.next()) {
				horas = rs.getInt(1);
			}	
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return horas;
	}

	/*
	 * Pasamos el codigo del proyecto del que queremos saber el coste del proyecto
	 * y el metodo devuelve un double con dicho coste tras multiplicar las horas asignadas con el coste de cada una de cada empleado.
	 */
	@Override
	public double costeActualDeProyecto(String codigoProyecto) {
		sql = "select proyecto_con_empleados.horas_asignadas * perfiles.precio_hora"
				+ " from proyecto_con_empleados, empleados, perfiles"
				+ " where proyecto_con_empleados.id_empl = empleados.id_empl AND empleados.id_perfil = perfiles.id_perfil"
				+ " AND proyecto_con_empleados.id_proyecto = ?";
		double coste = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, codigoProyecto);
			rs = ps.executeQuery();
			if(rs.next()) {
				coste = rs.getDouble(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return coste;
	}
	
	/*
	 * Finalmente, se obtiene un double, resultado de restar el importe de las ventas con el coste del proyecto.
	 * Par ello, primero hay que especificar el codigo del proyecto del que se desea obtener dicho resultado.
	 */
	@Override
	public double margenActualProyecto(String idProyecto) {
		sql = "select proyectos.venta_previsto - proyectos.coste_real"
				+ " from proyectos Left join proyecto_con_empleados"
				+ " on proyectos.id_proyecto = proyecto_con_empleados.numero_orden"
				+ " WHERE proyectos.id_proyecto = ?";
		double margen = 0;
		try {
			ps = conn.prepareStatement(sql);
			ps.setString(1, idProyecto);
			rs = ps.executeQuery();
			if(rs.next()) {
				margen = rs.getDouble(1);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return margen;
	}

	@Override
	public int asignarEmpleadosAProyecto(List<ProyectoConEmpleados> empelados) {
		// TODO Auto-generated method stub
		return 0;
	}

	
	
public void crearEmpledoConProyecto(ProyectoConEmpleados proyectoConEmpleados) throws SQLException{
		
		proyectoConEmpleados.setNumeroOrden(rs.getInt(1));
		proyectoConEmpleados.setProyecto(proy.buscarUno(rs.getString(2)));;
		proyectoConEmpleados.setEmpleados(edao.buscarUno(rs.getInt(3)));
		proyectoConEmpleados.setHorasAsignadas(rs.getInt(4));
		proyectoConEmpleados.setFechaIncorporacion(rs.getDate(5));
		
	}
	}


