package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;
/**
 * 
 * <b>Descripción:<b> Clase para realizar las pruebas unitarias
 * <b>Caso de Uso:<b> 
 * @author Juan Camilo
 * @version
 */
public class AppTest {

	public void shouldAnswerWithTrue() {

	}
	/**
	 * Metodo encargado de probar la suma de dos numeros
	 */
	public void primeraPU() {
		Long resultadoEsperado = 150L;
		Long sumando1 = 100L; 
		Long sumando2 = 50L;
		Long resultado = sumando1 + sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado = 200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);	
	}
	/**
	 *  Metodo encargado de probar el metodo invertir cadena
	 */
	public void invertirCadenaPU() {
		
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
	/** 
	 * Metodo para invertir una cadena 
	 */
	
	private String invertirCadena(String cadena) {
		String cadenaInvertida = "";
		for (int x = cadena.length() - 1; x >= 0; x--) {
			cadenaInvertida = cadenaInvertida + cadena.charAt(x);
			}
		return cadenaInvertida;
	}
	/**
	 * 
	 * Metodo encargado de probar la clase EstadoEnum
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 *
	 */
	
	@Test (enabled=false)

	public void estadoEnumPU() {
		
		/**
		 * Se instancian dos objetos de tipo EstadoEnum
		 */
		EstadoEnum activo = EstadoEnum.ACTIVO;     
		EstadoEnum inactivo = EstadoEnum.INACTIVO;	

		/**
		 * Se accede al nombre y se verifica que sea el esperado
		 */
		String nombreActivo = activo.name();
		Assert.assertEquals(nombreActivo, "ACTIVO");
		String nombreInactivo = inactivo.name();
		Assert.assertEquals(nombreInactivo, "INACTIVO");
		
		/**
		 * Se usa el metodo toString y se verifica la cadena que retorna
		 */
		String stringActivo = activo.toString();
		Assert.assertEquals(stringActivo, "ACTIVO");
		String stringInactivo = inactivo.toString();
		Assert.assertEquals(stringInactivo, "INACTIVO");
		
		/**
		 * Se obtiene el entero con la posicion del enum y se verifica que sea el esperado
		 */
		Integer posActivo = activo.ordinal();
		Assert.assertEquals(posActivo.intValue(),  0);
		Integer posInactivo = inactivo.ordinal();
		Assert.assertEquals(posInactivo.intValue(),  1);

		/**
		 * Se comparan el enum con el parámetro según el orden en el que están 
		 * declaradas las constantes
		 */
		Integer activoToInactivo = activo.compareTo(inactivo);
		Assert.assertEquals(activoToInactivo.intValue(),  -1);
		Integer activoToActivo = activo.compareTo(activo);
		Assert.assertEquals(activoToActivo.intValue(),  0);

		/**
		 * Se obtine un todos los enum, se verifica que no este vacio y que indice sea correcto
		 */
		EstadoEnum all[] = EstadoEnum.values();
		Assert.assertNotNull(all);
		Assert.assertEquals(all[0].toString(),  "ACTIVO");
		Assert.assertEquals(all[1].toString(),  "INACTIVO");
	}
	/**
	 * Método que verifica al método toString de la entidad COMIC
	 */
	@Test (enabled=false)
	
	public void ComictoStringPU() {
		Comic comic = new Comic();
		comic.setId("1");
		comic.setNombre("Captain America Corps 1-5 USA");
		comic.setEditorial("Panini Comics");
		comic.setTematicaEnum(TematicaEnum.FANTASTICO);
		comic.setColeccion("Biblioteca Marvel");
		comic.setNumeroPaginas(128);
		comic.setPrecio(BigDecimal.valueOf(12.93));
		comic.setAutores("Phillippe Briones, Roger Stern");
		comic.setColor(false);
		comic.setFechaVenta(LocalDate.now());
		comic.setEstadoEnum(EstadoEnum.ACTIVO);
		comic.setCantidad(5L);
		
		String InfoComic = comic.toString();
		Assert.assertNotNull(InfoComic);
		//System.out.println(InfoComic);
	}
	/**
	 * 
	 * Metodo encargado de probar la creacion estatica de un comic
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 *
	 */
	@Test (enabled=false)
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()!=0);
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
	}
	
}
