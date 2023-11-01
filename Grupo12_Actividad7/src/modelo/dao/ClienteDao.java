package modelo.dao;

import java.util.List;

import modelo.javabeans.Cliente;


public interface ClienteDao {

	int altaCliente (Cliente cliente); 			  // ALTA CLIENTE
	int eliminarCliente(String cif);  				 // ELIMINAR CLIENTE
	Cliente buscarUno(String cif); 	            // BUSCAR UN CLIENTE
	List<Cliente>buscarTodos(); 		   // MOSTRAR TODOS LOS CLIENTES 
	int modificarCliente(Cliente cliente); 
	

}
