package modelo.testing;

import java.sql.Date;

import modelo.dao.ClienteDao;
import modelo.dao.ClienteDaoImplList;
import modelo.dao.ProyectoDao;
import modelo.dao.ProyectoDaoImplMy8;
import modelo.javabeans.Proyecto;

public class TestProyecto {

	public static void main(String[] args) {
		//Se crea un nuevo objeto de la clase Proyecto.
        ProyectoDao podao = new ProyectoDaoImplMy8();

        //Tambien se crea un objeto de la clase Clientes para obtener el cif cuando sea necesario.
        ClienteDao clidao = new ClienteDaoImplList();

        /*
         * Vamos a añadir un nuevo proyecto. 
         * Las fechas se crean aparte con un metodo Date deprecado que sera invocado en el new.
         * Para asegurarnos de que ha creado el proyecto se incluye un 1.
         * Posteriormente buscamos ese proyecto para mostrarlo por consola.
         */
        System.out.println("Creamos nuevo proyecto");
        Date inicio = new Date(122, 9, 1);
        Date previsto = new Date(124, 5, 1);
        Date real = new Date(124, 3, 30);
        Proyecto proyecto = new Proyecto("FOR2022003", "Formacion de auxiliares de proyecto",inicio , previsto
                ,real, 50000.00, 30000.00, 315000.00, "Activo", 114, clidao.buscarUno("A22222222"));
        System.out.println(podao.altaProyecto(proyecto));
        System.out.println(podao.buscarUno("FOR2022003"));
        System.out.println(" ");
        
        //Se va a modificar el proyecto creado. Nos devolvera un 1 si se ha modificado y un 0 si no ha sido asi.
        System.out.println("Se modifica el proyecto creado");
        proyecto.setIdProyecto("FOR2022003");
        proyecto.setDescripcion("Formacion de obreros");
        proyecto.setFechaInicio(inicio);
        proyecto.setFechaFinPrevisto(previsto);
        proyecto.setFechaFinReal(real);
        proyecto.setVentaPrevisto(100000);
        proyecto.setCostesPrevisto(40000);
        proyecto.setCosteReal(400000);
        proyecto.setEstado("ACTIVO");
        proyecto.setJefeProyecto(114);
        proyecto.setCliente(clidao.buscarUno("A22222222"));

        System.out.println(podao.modificarProyecto(proyecto));
        System.out.println("Utilizo el metodo buscarUno para buscar ese proyecto");
        System.out.println(podao.buscarUno("FOR2022003"));
        System.out.println(" ");



        //Ahora se elimina ese mismo proyecto. Si se ha eliminado efectivamente nos devuelve un 1, 0 en caso de no ser suprimido.
        System.out.println("Eliminamos el proyecto que se habia creado");
        System.out.println(podao.eliminarProyecto("FOR2022003"));
        System.out.println(" ");
        //Buscamos uno de los proyectos existentes.
        Proyecto p22 = podao.buscarUno("FOR2021002");
        System.out.println("Buscamos uno");
        System.out.println(p22);
        System.out.println(" ");


        //Buscamos todos.
        System.out.println("Buscamos todos los proyectos. Al mismo tiempo comprobamos que el proyecto nuevo ya fue efectivamente eliminado");
        for (Proyecto ele: podao.buscarTodos())
            System.out.println(ele);
        System.out.println(" ");



        //Buscamos proyectos por estado, concretamente aquellos cuyo estado sea terminado.
        System.out.println("Buscamos proyectos por estado");
        for (Proyecto ele: podao.proyectosByEstado("TERMINADO"))
            System.out.println(ele);
        System.out.println(" ");
        
      //Buscamos proyecto por cliente. Apareceran todos los resultados porque el cif siempre es el mismo.
        System.out.println("Buscamos proyectos por cliente");
        for (Proyecto ele: podao.proyectosByCliente("A22222222"))
            System.out.println(ele);
        System.out.println(" ");


        //Buscamos proyecto por jefe y estado. Concretamente, el jefe sera el 114 y el estado terminado.
        System.out.println("Proyectos por jefe y estado");
        for (Proyecto ele: podao.proyectosByJefeProyectoAndByEstado(114, "TERMINADO"))
            System.out.println(ele);
        System.out.println(" ");


        //Sumamos los importes de las ventas.
        System.out.println("Sumamos importes");
        System.out.println(podao.importesVentaProyectosTerminados());
        System.out.println(" ");


        //Ahora encontramos el margen bruto.
        System.out.println("Margen bruto");
        System.out.println(podao.margenBrutoProyectosTerminados());
        System.out.println(" ");


        //Finalmente, vamos a ver la diferencia de dias entre la fecha prevista y el dia de hoy.
        System.out.println("Diferencia de dias");
        System.out.println(podao.diasATerminoProyectoActivo("FOR2021002"));

        System.out.println("FIN DE PRUEBAS");
}

}


