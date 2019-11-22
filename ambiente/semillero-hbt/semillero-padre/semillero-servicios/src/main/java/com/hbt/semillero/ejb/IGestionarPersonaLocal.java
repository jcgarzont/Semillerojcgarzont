/**
 * IGestionarPersonaLocal.java
 */
package com.hbt.semillero.ejb;

import java.util.List;

import javax.ejb.Local;

import com.hbt.semillero.dto.PersonaDTO;

/**
 * <b>Descripción:<b> Interfaz para gestionar personas
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
@Local
public interface IGestionarPersonaLocal {
	
	/**
	 * 
	 * Metodo encargado de crear una persona
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param personaDTO
	 */
	public void crearPersona(PersonaDTO personaDTO);
	
	/**
	 * 
	 * Metodo encargado de consultar una persona
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param id
	 * @return
	 */
	public PersonaDTO consultarPersona(String id);
	
	/**
	 * 
	 * Metodo encargado de consultar todas las personas
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @return
	 */
	public List<PersonaDTO> consultarPersonas();
}
