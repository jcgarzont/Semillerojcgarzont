/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;


/**
 * <b>Descripción:<b> Clase que determina el EJB para gestionar el comic
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal {
//public class GestionarComicBean {

	@PersistenceContext
    private EntityManager em;

	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void crearComic(ComicDTO comicDTO) {
        Comic comic = convertirComicDTOToComic(comicDTO);
        
        em.persist(comic);
	}
	/**
	 * 
	 * Metodo encargado de modificar un comic
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param comicModificar
	 */
	/*
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public void modificarComic(ComicDTO comicModificar) {
        Comic comic = new Comic();
        //comic.setId(comicModificar.getId());
		em.merge(comicModificar);
	}
	*/
	/**
	 * 
	 * Metodo encargado de consultar un comic
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param id
	 * @return
	 */
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public ComicDTO consultarComic(String id) {
		Comic comic = em.find(Comic.class, Long.parseLong(id));
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}
	
	/**
	 * 
	 * Metodo encargado de consultar un comic en la lista
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @return
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
    public List<ComicDTO> consultarTodos() {
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long, java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	/**
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if (comicNuevo == null) { 
			comicModificar = em.find(Comic.class, id);
		}else {
			comicModificar = convertirComicDTOToComic(comicNuevo);
		}
		comicModificar.setNombre(nombre);
		em.merge(comicModificar);
	}
	*/
	public void modificarComic(ComicDTO comicDTO) {
		Comic comicModificar;
		comicModificar = em.find(Comic.class, Long.valueOf(comicDTO.getId()));
		comicModificar.setNombre(comicDTO.getNombre());
		em.merge(comicModificar);
		//em.merge(comicDTO);
	}
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#eliminarComic(java.lang.Long)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public void eliminarComic(Long idComic) {
		Comic comicEliminar;
		comicEliminar = em.find(Comic.class, idComic);
	    if (comicEliminar != null) {
	    	em.remove(comicEliminar);
	    }
	}
	/** 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#consultarComics()
	 */
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		List<ComicDTO> resultadosComicDTO = new ArrayList<ComicDTO>();
		List<Comic> resultados = em.createQuery("select c from Comic c").getResultList();
		for (Comic comic : resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}
	/**
	 * Metodo encargado de representar un ComicDTO como un Comic
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
        if(comicDTO.getId()!=null) {
            comic.setId(Long.parseLong(comicDTO.getId()));
        }
        comic.setNombre(comicDTO.getNombre());
        comic.setEditorial(comicDTO.getEditorial());
        comic.setTematicaEnum(comicDTO.getTematicaEnum());
        comic.setColeccion(comicDTO.getColeccion());
        comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
        comic.setPrecio(comicDTO.getPrecio());
        comic.setAutores(comicDTO.getAutores());
        comic.setColor(comicDTO.getColor());
        comic.setFechaVenta(comicDTO.getFechaVenta());
        comic.setEstadoEnum(comicDTO.getEstado());
        comic.setCantidad(comicDTO.getCantidad());
        return comic;
	}
	/**
	 * Metodo encargado de representar un Comic como un ComicDTO
	 */
	private ComicDTO convertirComicToComicDTO(Comic comic) {
        ComicDTO comicDTO = new ComicDTO();
        if(comic.getId()!=null) {
         comicDTO.setId(comic.getId().toString());
        }
        comicDTO.setNombre(comic.getNombre());
        comicDTO.setEditorial(comic.getEditorial());
        comicDTO.setTematicaEnum(comic.getTematicaEnum());
        comicDTO.setColeccion(comic.getColeccion());
        comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
        comicDTO.setPrecio(comic.getPrecio());
        comicDTO.setAutores(comic.getAutores());
        comicDTO.setColor(comic.getColor());
        comicDTO.setFechaVenta(comic.getFechaVenta());
        comicDTO.setEstadoEnum(comic.getEstadoEnum());
        comicDTO.setCantidad(comic.getCantidad());
        return comicDTO;
    }
	
}
