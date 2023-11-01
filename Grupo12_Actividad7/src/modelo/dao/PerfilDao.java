package modelo.dao;

import modelo.javabeans.Empleados;
import modelo.javabeans.Perfil;


/**
 * Creo la interface de Perfiles con el CRUD
 * 
 * @author Gerard_Perujo
 *
 */
public interface PerfilDao {

	int crearPerfil(Perfil perfil);
	Perfil buscarUno(int idPerfil);
	int modificarPerfil(Perfil perfil);
	int eliminarPerfil(int idPerfil);
}
