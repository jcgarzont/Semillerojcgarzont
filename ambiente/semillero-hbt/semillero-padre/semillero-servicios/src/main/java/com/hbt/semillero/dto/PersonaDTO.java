/**
 * PersonaDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * <b>Descripción:<b> Clase que determina la representacion de un dato persona
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
public class PersonaDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = -4742014270524193118L;
	
	/**
	 * identificador de la persona
	 */
	private String id;
	/**
	 * nombre de la persona
	 */
	private String nombre;
	/**
	 * numero de identificacion de la persona
	 */
	private Long numeroIdentificacion;
	/**
	 * Constructor de la clase.
	 */
	public PersonaDTO() {
		super();
	}
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param numeroIdentificacion
	 */
	public PersonaDTO(String id, String nombre, Long numeroIdentificacion) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.numeroIdentificacion = numeroIdentificacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo id
	 * @return El id asociado a la clase
	 */
	public String getId() {
		return id;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo id
	 * @param id El nuevo id a modificar.
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo nombre
	 * @return El nombre asociado a la clase
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo nombre
	 * @param nombre El nuevo nombre a modificar.
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo NumeroIdentificacion
	 * @return El numeroIdentificacion asociado a la clase
	 */
	public Long getNumeroIdentificacion() {
		return this.numeroIdentificacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo NumeroIdentificacion
	 * @param numeroIdentificacion El nuevo numeroIdentificacion a modificar.
	 */
	public void setNumeroIdentificacion(Long numeroIdentificacion) {
		this.numeroIdentificacion = numeroIdentificacion;
	}
	
	
}
