/**
 * EjerciciosPOJO.java
 */
package com.hbt.semillero.pojo;

import java.time.LocalDate;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
public class EjerciciosPOJO {

	public boolean primos(int numero) {
		int contador = 2;
		boolean primo=true;
		while ((primo) && (contador!=numero)){
			if (numero % contador == 0)
			{
				primo = false;
			    contador++;
			}
			else
			{
				primo = true;
			}
		}
		return primo;
	}
	
	public boolean fecha(int nacimiento, int numeroAños) {
		LocalDate fechaActual = LocalDate.now();
		int añoActual = fechaActual.getYear();
		int diferecia = añoActual - numeroAños ;
		if (diferecia == nacimiento) {
			return true;
		}
		else {
			return false;
		}
	}
}
