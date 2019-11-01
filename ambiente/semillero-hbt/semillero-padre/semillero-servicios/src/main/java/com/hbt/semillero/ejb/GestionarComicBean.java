/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

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
public class GestionarComicBean {
	@PersistenceContext
    private EntityManager em;
	//TODO
	/*
	 * agregar interfaz
	 */
	
	/**
	 * 
	 * Metodo encargado de crear un comic
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 * 
	 * @param comicDTO
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		//Entidad nueva
        Comic comic = new Comic();
        comic.setId(comicDTO.getId());
        //TODO
        /*
         * llenar los demas datos
         */
        
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
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void modificarComic(ComicDTO comicModificar) {
        Comic comic = new Comic();
        comic.setId(comicModificar.getId());
		em.merge(comicModificar);
	}
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
		Comic comic = em.find(Comic.class, id);
		ComicDTO comicDTO = new ComicDTO(comic.getId(),comic.getNombre());
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
    public List<ComicDTO> consultarComic() {
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null;
	}
	
}
