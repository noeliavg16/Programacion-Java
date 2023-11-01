package modelo.dao;

import modelo.javabeans.Departamentos;
import modelo.javabeans.Perfil;

/**
 * Creo la interface de departamentos creado los metodos CRUD
 * 
 * @author Gerard_Perujo
 *
 */
public interface DepartamentosDao {
	
	int crearDepartamento(Departamentos departamento);
	Departamentos buscarUno(int idDepar);
	int modificarDepartamento(Departamentos departamento);
	int eliminarDepartamento(int idDepar);
}


