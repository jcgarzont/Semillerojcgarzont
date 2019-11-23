/**
 * GestionarPersonaRest.java
 */
package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.PersonaDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarPersonaLocal;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar las personas
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
@Path("/GestionarPersona")
public class GestionarPersonaRest {
	@EJB
	private IGestionarPersonaLocal gestionarPersonaEJB;
	
	/**
	 * 
	 * Metodo encargado de crear una persona
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param personaDTO
	 * @return
	 */
	
	@GET
	@Path("/saludo")
	@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "Prueba inicial servicios rest en el semillero java hbt";
	}
	
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearPersona(PersonaDTO personaDTO) {
		gestionarPersonaEJB.crearPersona(personaDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Comic creado exitosamente");
		return resultadoDTO;
	}
	/**
	 * 
	 * Metodo encargado de consultar una persona 
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param id
	 * @return
	 */
	@GET
	@Path("/consultarPersona")
	@Produces(MediaType.APPLICATION_JSON)
	public PersonaDTO consultarComic(@QueryParam("id") Long id) {
		if (id != null) {
			PersonaDTO personaDTO = gestionarPersonaEJB.consultarPersona(id.toString());
			return personaDTO;
		}
		return null;
	}
	/**
	 * 
	 * Metodo encargado de consultar todas las personas
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarPersonas")
	@Produces(MediaType.APPLICATION_JSON)
	public List<PersonaDTO> consultarComic() {
		return gestionarPersonaEJB.consultarPersonas();
	}
}
