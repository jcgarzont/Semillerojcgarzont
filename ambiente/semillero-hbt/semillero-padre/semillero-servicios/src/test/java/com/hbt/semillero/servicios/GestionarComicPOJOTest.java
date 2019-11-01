/**
 * GestionarComicPOJOTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase para realizar las pruebas unitarias de la clase
 * GestionarComicPOJO <b>Caso de Uso:<b>
 * 
 * @author Juan Camilo
 * @version
 */
public class GestionarComicPOJOTest {

	/**
	 * 
	 * Caso de prueba para verificar los metodos de agregar, modificar y eliminar un
	 * comic de la clase GestionarComicPOJO 
	 * <b>Caso de Uso</b>
	 * @author Juan Camilo
	 *
	 */
	@Test
	public void GestionarComicDTOTest() {
		/**
		 * Se intancia el objeto gestionarComicPOJO, se agrega el primer comic y se
		 * verifica su existencia en la lista
		 */
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		ComicDTO comicDTO = new ComicDTO("1", "Captain America Corps 1-5 USA", "Panini Comics", TematicaEnum.FANTASTICO,
				"Biblioteca Marvel", 128, new BigDecimal(5000), "Phillippe Briones, Roger Stern", Boolean.FALSE,
				LocalDate.now(), EstadoEnum.ACTIVO, 5L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 1);
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
		/**
		 * Se agrega el segundo comic y se verifica que el tamaño de la lista aumente
		 */
		comicDTO = new ComicDTO();
		comicDTO.setId("2");
		comicDTO.setNombre("Dragon Ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garrow Lee");
		comicDTO.setColor(Boolean.FALSE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);
		/**
		 * se agrega el tercer comic y se verifica que el tamaño de la lista aumente
		 */
		comicDTO = new ComicDTO();
		comicDTO.setId("3");
		comicDTO.setNombre("The Spectacular Spider-Man v2 USA");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.FANTASTICO);
		comicDTO.setColeccion("MARVEL COMICS");
		comicDTO.setNumeroPaginas(208);
		comicDTO.setPrecio(new BigDecimal(6225));
		comicDTO.setAutores("Straczynski,Deodato Jr.,Barnes,Eaton");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.INACTIVO);
		comicDTO.setCantidad(0L);
		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);

		/**
		 * Se modifica el nombre del comic con id = 2 y se comprueba que el elemento de
		 * la lista tenga el nuevo nombre
		 */
		gestionarComicPOJO.modificarComicDTO("2", "Dragon Ball Super");
		Assert.assertEquals(gestionarComicPOJO.getListaComics().get(1).getNombre(), "Dragon Ball Super");

		/**
		 * Se elimina el comic con id = 1 y se comprueba que el tamaño de la lista
		 * disminuya
		 */
		gestionarComicPOJO.eliminarComicDTO("1");
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 2);

	}
}
