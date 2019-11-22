/**
 * IGestionarUsuarioLocal.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.UsuarioDTO;


/**
 * <b>Descripción:<b> Interfaz para gestionar usuarios
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
@Local
public interface IGestionarUsuarioLocal {
	
	/**
	 * 
	 * Metodo encargado de crear un usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param usuarioDTO
	 */
	public void crearUsuario(UsuarioDTO usuarioDTO);
	
	/**
	 * 
	 * Metodo encargado de consultar un usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param id
	 * @return
	 */
	public UsuarioDTO consultarUsuario(String id);
	
	/**
	 * 
	 * Metodo encargado de  consultar todos los usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuarios();
	
	/**
	 * 
	 * Metodo encargado de modificar un usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param id
	 * @param nombreNuevo
	 */
	public void modificarUsuario(String id, String nombreNuevo);
}
