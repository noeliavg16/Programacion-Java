package modelo.principales;

import java.util.Scanner;

import modelo.javabeans.Cliente;
import modelo.dao.ClienteDaoImplList;

/**
 *  Esta clase Test la creamos para ir probando los métodos creados de la clas Cliente.
 *  @author Noelia
 */

	
public class GestionClientes {
	
	private static Scanner leer;
	static { 
		leer = new Scanner(System.in);
	}
	private static int opcion; 

	public static void main(String[] args) {
		

		ClienteDaoImplList cliente1 = new ClienteDaoImplList(); 
		
		Cliente cli = new Cliente("05728723k", "noelia", "garcia", "santisimo", 1221222, 1);
		
		while(opcion != 6) {
			
			opcion = pintarMenu();
			
			switch (opcion) {
			case 1:
				System.out.println("Alta cliente");
				System.out.println(cliente1.altaCliente(cli));
				System.out.println(cliente1.buscarUno("05728723k"));
			break; 
			case 2:
				System.out.println("Buscar un cliente");
				System.out.println(cliente1.buscarUno("A22222222"));
			break;
			case 3: 
				System.out.println("Mostrar todos los clientes");
				for (Cliente ele: cliente1.buscarTodos()) 
					System.out.println(ele);
			case 4: 
				System.out.println("Modificar un cliente");
				Cliente cliente2 = cliente1.buscarUno("05728723k"); 
				cliente2.setNombre("Elena");
				cliente2.setApellidos("Rodrigo");
				cliente2.setDomicilio("Aulagueros");
				cliente2.setFacturacionAnual(1.25);
				cliente2.setNumeroEmpleados(2);
				
				System.out.println(cliente1.buscarUno("05728723k"));
			break;
			case 5: 
				System.out.println("Eliminar un cliente");
				System.out.println(cliente1.eliminarCliente("05728723k"));
				System.out.println("Si sale el numero 1: cliente eliminado" + " - " + " Si sale el numero 0: cliente NO eliminado");
			
			}
		
		}
		System.out.println("FIN DE PROGRAMA");
				
	
}
public static int pintarMenu() {
		

		int opcion = 0; 
		
		System.out.println("1. - Alta del Cliente");
		System.out.println("2. - Buscar un cliente");
		System.out.println("3. - Mostrar todos los clientes");
		System.out.println("4. - Modificar un cliente");
		System.out.println("5. - Eliminar un cliente");
		System.out.println("6. - SALIR");
		
		System.out.println("Teclea una opcion del 1 al 6, siendo 6 la opción de salir");
		opcion = leer.nextInt(); 
		
		while(opcion < 1 || opcion > 6) {
			System.out.println("Opciones del 1 al 6");
			opcion = leer.nextInt(); 
	
			
}
		return opcion;
}
}