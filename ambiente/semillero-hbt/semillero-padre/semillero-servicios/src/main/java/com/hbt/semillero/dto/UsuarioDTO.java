/**
 * UsuarioDTO.java
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoEnum;

/**
 * <b>Descripción:<b> Clase que determina la representacion de un usuario
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
public class UsuarioDTO implements Serializable{

	/**
	 * Atributo que determina  
	 */
	private static final long serialVersionUID = 8671491754930043967L;
	
	/**
	 * identificador de un usuario
	 */
	private String id;
	/**
	 * nombre de usuario
	 */
	private String nombre;
	/**
	 * fecha de creacion
	 */
	private LocalDate fechaCreacion;
	/**
	 * estado del usuario
	 */
	private EstadoEnum estadoEnum;
	/**
	 * identificador de la persona a la que pertenece el usuario
	 */
	private String idPersona;
	/**
	 * Constructor de la clase.
	 */
	public UsuarioDTO() {
		super();
	}
	/**
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param fechaCreacion
	 * @param estadoEnum
	 * @param idPersona
	 */
	public UsuarioDTO(String id, String nombre, LocalDate fechaCreacion, EstadoEnum estadoEnum, String idPersona) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
		this.estadoEnum = estadoEnum;
		this.idPersona = idPersona;
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
	 * Metodo encargado de retornar el valor del atributo fechaCreacion
	 * @return El fechaCreacion asociado a la clase
	 */
	public LocalDate getFechaCreacion() {
		return fechaCreacion;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo fechaCreacion
	 * @param fechaCreacion El nuevo fechaCreacion a modificar.
	 */
	public void setFechaCreacion(LocalDate fechaCreacion) {
		this.fechaCreacion = fechaCreacion;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo estadoEnum
	 * @return El estadoEnum asociado a la clase
	 */
	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo estadoEnum
	 * @param estadoEnum El nuevo estadoEnum a modificar.
	 */
	public void setEstadoEnum(EstadoEnum estadoEnum) {
		this.estadoEnum = estadoEnum;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo idPersona
	 * @return El idPersona asociado a la clase
	 */
	public String getIdPersona() {
		return idPersona;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo idPersona
	 * @param idPersona El nuevo idPersona a modificar.
	 */
	public void setIdPersona(String idPersona) {
		this.idPersona = idPersona;
	}
	
	
	
}

