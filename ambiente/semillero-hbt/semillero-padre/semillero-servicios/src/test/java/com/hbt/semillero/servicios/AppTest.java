package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

public class AppTest {

	public void shouldAnswerWithTrue() {

	}
	
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L; 
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);	

	}
	@Test
	public void inverticCadenaPU() {
		
		String cadena = "Juan Camilo";
		//System.out.println(cadena);
		String cadenaInvertida = invertirCadena(cadena);
		//System.out.println(cadenaInvertida);
		
		Assert.assertNotNull(cadena);
		Assert.assertNotNull(cadenaInvertida);

		for (int x = 0; x < cadena.length(); x++) 
		{
			Assert.assertEquals(cadena.charAt(x), cadenaInvertida.charAt(cadena.length()-1-x));
		}
	}
	
	
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
			}
		return cadenaInvertida;
	}
}
