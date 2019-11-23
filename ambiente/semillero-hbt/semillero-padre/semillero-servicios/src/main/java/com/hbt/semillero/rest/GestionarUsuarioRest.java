/**
 * GestionarUsuarioRest.java
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

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.ejb.IGestionarUsuarioLocal;
import com.hbt.semillero.entidades.Usuario;

/**
 * <b>Descripción:<b> Clase que determina el servicio rest que permite gestionar los usuarios
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
@Path("/GestionarUsuario")
public class GestionarUsuarioRest {
	
	@EJB
	private IGestionarUsuarioLocal gestionarUsuarioEJB;
	
	/**
	 * 
	 * Metodo encargado de crear un usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param usuarioDTO
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
	public ResultadoDTO crearPersona(UsuarioDTO usuarioDTO) {
		gestionarUsuarioEJB.crearUsuario(usuarioDTO);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Comic creado exitosamente");
		return resultadoDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de consultar un usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param id
	 * @return
	 */
	@POST
	@Path("/consultarUsuario")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO consultarUsuario(Long id) {
		if (id != null) {
			UsuarioDTO usuarioDTO = gestionarUsuarioEJB.consultarUsuario(id.toString());
			return usuarioDTO;
		}
		return null;
	}
	/**
	 * 
	 * Metodo encargado de consultar todos los usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @return
	 */
	@GET
	@Path("/consultarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> consultarComic() {
		return gestionarUsuarioEJB.consultarUsuarios();
	}
	
	/**
	 * 
	 * Metodo encargado de modificar el nombre de un usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param id
	 * @param nombre
	 * @return
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarComic(String id, String nombre) {
		gestionarUsuarioEJB.modificarUsuario(id,nombre);
		ResultadoDTO resultadoDTO = new ResultadoDTO(Boolean.TRUE, "Comic modificado exitosamente");
		return resultadoDTO;	
	}

}
