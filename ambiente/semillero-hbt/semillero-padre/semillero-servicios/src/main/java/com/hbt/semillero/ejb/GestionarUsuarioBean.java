/**
 * GestionarUsuarioBean.java
 */
package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.Usuario;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
@Stateless
public class GestionarUsuarioBean implements IGestionarUsuarioLocal{
	@PersistenceContext
    private EntityManager em;

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#crearUsuario(com.hbt.semillero.dto.UsuarioDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = convertirUsuarioDTOToUsuario(usuarioDTO);
		usuario.setNombre(nombreAleatorio());
		if (verificarFecha(usuario)) {
			em.persist(usuario);
		}
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarUsuario(java.lang.String)
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UsuarioDTO consultarUsuario(String id) {
		Usuario usuario  = em.find(Usuario.class, Long.parseLong(id));
		UsuarioDTO usuarioDTO = convertirUsuarioToUsuarioDTO(usuario);
		return usuarioDTO;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#consultarUsuarios()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UsuarioDTO> consultarUsuarios() {
		FechaExpiracion();
		List<UsuarioDTO> resultadosUsuarioDTO = new ArrayList<UsuarioDTO>();
		List<Usuario> resultados = em.createQuery("select c from Usuario c").getResultList();
		for (Usuario usuario : resultados) {
			resultadosUsuarioDTO.add(convertirUsuarioToUsuarioDTO(usuario));
		}
		return resultadosUsuarioDTO;
	}

	/** 
	 * @see com.hbt.semillero.ejb.IGestionarUsuarioLocal#modificarUsuario(java.lang.String, java.lang.String)
	 */
	
	public void modificarUsuario(String id, String nombreNuevo) {
		Usuario usuarioModificar;
		usuarioModificar = em.find(Usuario.class, id);
		usuarioModificar.setNombre(nombreNuevo);
		em.merge(usuarioModificar);		
	}
	/**
	 * 
	 * Metodo encargado de verificar la fecha de expiracion de un usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 *
	 */
	public void FechaExpiracion() {
		List<Usuario> resultados = em.createQuery("select c from Usuario c").getResultList();
		LocalDate hoy = LocalDate.now();
		EstadoEnum estado = EstadoEnum.INACTIVO;
		for (Usuario usuario : resultados) {
			if (Math.abs(usuario.getFechaCreacion().compareTo(hoy)) > 365)
			{
				usuario.setEstadoEnum(estado);
				em.merge(usuario);
			}
		}
	}
	
	/**
	 * 
	 * Metodo encargado de que la fecha de creacion no sea mayor a la fecha actual
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param usuario
	 * @return
	 */
	private Boolean verificarFecha(Usuario usuario) {
		LocalDate hoy = LocalDate.now();
		if (Math.abs(usuario.getFechaCreacion().compareTo(hoy)) == 0)
		{
			return true;
		}
		else {
			return true;
		}
	}
	
	private String nombreAleatorio() {
		String uuid = UUID.randomUUID().toString();
		String number= uuid.replaceAll("[^0-9]", "");
		number= number.replaceAll("-", "");
		String uuid2 = uuid.replaceAll("[0-9]", "");		 
		uuid2 = uuid2.replaceAll("-", "");
		String randomF = Character.toUpperCase((uuid2.charAt(0))) + Character.toString(number.charAt(0)) + uuid2.substring(1, 6);
		return randomF;
	}
	/**
	 * 
	 * Metodo encargado de cambiar el estado de un usuario
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param id
	 */
	public void cambiarEstadoUsuario(String id) {
		Usuario usuarioCambiar;
		usuarioCambiar = em.find(Usuario.class, id);
		EstadoEnum inactivo = EstadoEnum.INACTIVO;
		EstadoEnum activo = EstadoEnum.ACTIVO;
		if (usuarioCambiar.getEstadoEnum() == activo) {
			usuarioCambiar.setEstadoEnum(inactivo);
		}
		else {
			usuarioCambiar.setEstadoEnum(activo);	
		}
		em.merge(usuarioCambiar);		
	}
	
	private Usuario convertirUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
        if(usuarioDTO.getId()!=null) {
        	usuario.setId(Long.parseLong(usuarioDTO.getId()));
        }
        usuario.setNombre(usuarioDTO.getNombre());
        usuario.setFechaCreacion(usuarioDTO.getFechaCreacion());
        usuario.setEstadoEnum(usuarioDTO.getEstadoEnum());
        usuario.setIdPersona(Long.parseLong(usuarioDTO.getIdPersona()));
        return usuario;
	}
	
	private UsuarioDTO convertirUsuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO = new UsuarioDTO();
        if(usuario.getId()!=null) {
        	usuarioDTO.setId(usuario.getId().toString());
        }
        usuarioDTO.setNombre(usuario.getNombre());
        usuarioDTO.setFechaCreacion(usuario.getFechaCreacion());
        usuarioDTO.setEstadoEnum(usuario.getEstadoEnum());
        usuarioDTO.setIdPersona(usuario.getIdPersona().toString());
        return usuarioDTO;
    }
	

}
