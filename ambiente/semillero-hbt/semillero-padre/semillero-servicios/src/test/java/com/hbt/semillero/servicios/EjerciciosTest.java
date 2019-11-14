/**
 * EjerciciosTest.java
 */
package com.hbt.semillero.servicios;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.Test;
import com.hbt.semillero.pojo.EjerciciosPOJO;;

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
	//@Test (enabled=false)
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
	private static String brand;
	private static Boolean empty;
	
	public static void ejercicio2() {
		//WaterBottle wb = new WaterBottle();
		System.out.print("Empty =" + empty);
		System.out.print(", Brand =" + brand);
		// Se espera que contengan Null al no estar inicializados
		Assert.assertNull(empty);
		Assert.assertNull(brand);
	}
	
	//@Test
	public void ejercicio3() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		boolean test;
		test = ejerciciosPOJO.primos(5);
		//Assert.assertTrue(test);
		test = ejerciciosPOJO.primos(222);
		//Assert.assertTrue(test);
		test = ejerciciosPOJO.primos(0);
		//Assert.assertTrue(test);		
	}
	
	/**
	 * 
	 * Metodo encargado probar el ejercicio 4
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 *
	 */
	//@Test
	public void ejercicio4() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		boolean test;
		test = ejerciciosPOJO.fecha(1998, 21);
		//Verifica que el resultado sea true
		Assert.assertTrue(test);
		test = ejerciciosPOJO.fecha(1998, 99);
		//Verifica que el resultado sea false
		Assert.assertFalse(test);
	}
	//@Test
	public void ejercicio5() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		ejerciciosPOJO.ingresarValores(50);
		ejerciciosPOJO.ingresarValores(1);
		ejerciciosPOJO.ingresarValores(249);
		ejerciciosPOJO.ingresarValores(-2);
		List<Integer> lista = new ArrayList<>();
		lista = ejerciciosPOJO.ordenar();
	}
	
	//@Test
	public void ejercicio7() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		//ejerciciosPOJO.tenis();
	}
	/**
	 * 
	 * Metodo encargado probar el metodo cambio de la clase EjerciciosPOJO
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 *
	 */
	//@Test
	public void ejercicio8() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		Integer[] monedas = ejerciciosPOJO.cambio(1000);
		
		//Se verifica que esten 1 monedas de 1000, las demas en 0
		Assert.assertEquals((int)monedas[0], 1);
		Assert.assertEquals((int)monedas[1], 0);
		Assert.assertEquals((int)monedas[2], 0);
		Assert.assertEquals((int)monedas[3], 0);
		Assert.assertEquals((int)monedas[4], 0);
		Assert.assertEquals((int)monedas[5], 0);
		
		monedas = ejerciciosPOJO.cambio(5550);
		
		//Se verifica que esten 5 monedas de 1000, 1 de 500, y 1 de 50, las demas en 0
		Assert.assertEquals((int)monedas[0], 5);
		Assert.assertEquals((int)monedas[1], 1);
		Assert.assertEquals((int)monedas[2], 0);
		Assert.assertEquals((int)monedas[3], 0);
		Assert.assertEquals((int)monedas[4], 0);
		Assert.assertEquals((int)monedas[5], 1);
	}
	@Test
	public void ejercicio11() {
		EjerciciosPOJO ejerciciosPOJO = new EjerciciosPOJO();
		Boolean Secuencia;
		Secuencia = ejerciciosPOJO.secuencia(46);
		Assert.assertTrue(Secuencia);
		Secuencia = ejerciciosPOJO.secuencia(64);
		Assert.assertTrue(Secuencia);
		
	}
	
}
