package modelo.testing;

import java.sql.Date;
import modelo.dao.FacturasDao;
import modelo.dao.FacturasDaoImplMy8;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8;
import modelo.javabeans.Facturas;


public class TestFacturas {

	public static void main(String[] args) {
		/*
		 * Se crean varios objetos de distintas clases del ejercicio.
		 * Los que no pertenecen al ambito de facturas son necesarios llamarlos en circunstancias de relaciones entre clases.
		 */
		FacturasDao fac = new FacturasDaoImplMy8();
		
		ProyectoDao proye = new ProyectoDaoImplMy8();

		
		/*
		 * Si se consigue dar de alta la factura devuelve un 1.
		 * En caso contrario se devuelve un 0.
		 */
		System.out.println("Damos de alta una nueva factura y luego la buscamos");
		Facturas facturas = new Facturas("F2020002", "Formacion a cliente 2", proye.buscarUno("FOR2020001"));
		System.out.println(fac.altaFactura(facturas));
		System.out.println(fac.buscarUno("F2020002"));
		System.out.println(" ");
		
		/*
		 * Al igual que en el caso anterior, si la operacion de modificar es satisfactoria retorna 1.
		 * Si no se ha modificado devuelve 0.
		 */
		System.out.println("Modificamos la factura y posteriormente se busca para verificar la modificacion");
		Facturas factura2 = fac.buscarUno("F2020002");
		factura2.setIdFactura("F2020002");
		factura2.setDescripcion("Informacion a cliente 2");
		factura2.setProyecto(proye.buscarUno("FOR2020001"));
		System.out.println(fac.modificarProyecto(factura2));
		System.out.println(fac.buscarUno("F2020002"));
		System.out.println(" ");
		
		/*
		 * Para eliminar la factura tambien se devolvera 1 si realmente ha sido eliminada, 0 en caso contrario.
		 */
		System.out.println("Eliminamos la factura creada");
		System.out.println(fac.eliminarFactura("F2020002"));
		System.out.println(" ");
		
		/*
		 * Se va a buscar la unica factura que figura en la base de datos.
		 */
		System.out.println("Ahora vamos a buscar una factura");
		System.out.println(fac.buscarUno("F2020001"));
		System.out.println(" ");
		
		/*
		 * En listado que se va a buscar contiene la misma fila que en el caso anterior porque solo hay un registro.
		 */
		System.out.println("Finalmente buscamos todas las facturas");
		for(Facturas ele: fac.buscarTodos())
			System.out.println(ele);
		
		System.out.println("FIN DE PRUEBAS");
	}
	

}
