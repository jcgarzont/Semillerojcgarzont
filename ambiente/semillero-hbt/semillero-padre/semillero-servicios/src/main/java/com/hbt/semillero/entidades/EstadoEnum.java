/**
 * EstadoEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Enum que determina el estado del comic
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
public enum EstadoEnum {
	ACTIVO("enum.estado.activo"), 
	INACTIVO("enum.estado.inactivo");
	
	private String codigoMensaje;

	/**
	 * Constructor de la clase.
	 * @param codigoMensaje
	 */
	private EstadoEnum(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo codigoMensaje
	 * @return El codigoMensaje asociado a la clase
	 */
	public String getCodigoMensaje() {
		return codigoMensaje;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo codigoMensaje
	 * @param codigoMensaje El nuevo codigoMensaje a modificar.
	 */
	public void setCodigoMensaje(String codigoMensaje) {
		this.codigoMensaje = codigoMensaje;
	}
	
	

}
