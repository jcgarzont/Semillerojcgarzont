/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;

/**
 * <b>Descripción:<b> Clase que permite implementar los servicios REST
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
@Path("/GestionarComic")
public class GestionarComicRest {
	@EJB

	private IGestionarComicLocal gestionarComicEJB;
	/**
	 * 
	 * Metodo encargado de mostrar un hola mundo en la ruta especificada
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @return
	 */
	@GET
	@Path("/saludo")
	@Produces
	//@Produces(MediaType.APPLICATION_JSON)
	public String primerRest() {
		return "hola mundo"; 
	}
	/**
	 * 
	 * Metodo encargado de mostrar la consulta de un comic en la ruta especificada
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
    @Path("/consultarComic")
    @Produces(MediaType.APPLICATION_JSON)
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic) {
		if (idComic != null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}
}
