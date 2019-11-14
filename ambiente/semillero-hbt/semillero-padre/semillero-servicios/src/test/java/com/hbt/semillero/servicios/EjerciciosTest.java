/**
 * EjerciciosTest.java
 */
package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version 
 */
public class EjerciciosTest {
	
	/**
	 * 
	 * Metodo encargado de probar los identificadores de java validos
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 *
	 */
	@Test (enabled=false)
	public void ejercicio1() {
		// Valido
		String A$B = "valido?";
		Assert.assertNotNull(A$B);
		// Valido
		String _helloworld = "valido?";
		Assert.assertNotNull(_helloworld);
		// Invalido
		//String true = "valido?";
		//Assert.assertNotNull(true);
		//Invalido
		//String java.lang = "valido?";
		//Assert.assertNotNull(java.lang);
		//Invalido
		//String Public = "valido?";
		//Assert.assertNotNull(Public);
		//Invalido
		//String 1980_s = "valido?";
		//Assert.assertNotNull(1980_s);	
	}
	private String brand;
	private Boolean empty;
	public static void ejercicio2() {
		//WaterBottle wb = new WaterBottle();
		System.out.print("Empty =" + empty);
		System.out.print(", Brand =" + brand);
		
	}

}
