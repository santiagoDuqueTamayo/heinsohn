/**
 * GestionarComicTest.java
 */
package com.hbt.semillero.servicios;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;
import com.hbt.semillero.pojo.GestionarComicPOJO;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author santi
 * @version 
 */
public class GestionarComicPOJOTest {
	
	ComicDTO comicDTO=null;
	GestionarComicPOJO gestionarComicPOJO=null;
	List<ComicDTO> listaComic=null;
	@BeforeTest
	public void before() {
		gestionarComicPOJO= new GestionarComicPOJO();
		comicDTO = gestionarComicPOJO.crearComicDTO("1", "Flash", "DC",
				TematicaEnum.CIENCIA_FICCION, "BIBLIOTECA MARVEL", 128, new BigDecimal(2345),
				" Roger Stern", Boolean.TRUE, LocalDate.now(), EstadoEnum.ACTIVO, 6L);
	}
	
	@Test(enabled = false)
	public void crearComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();
		gestionarComicPOJO.crearComicDTO();
		Assert.assertNotNull(gestionarComicPOJO.getListaComics());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() != 0);
		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
	}

	@Test
	public void creartComicDTOTest() {
		GestionarComicPOJO gestionarComicPOJO = new GestionarComicPOJO();

		ComicDTO comicDTO = gestionarComicPOJO.crearComicDTO("101", "Captain America Corps 1-5 USA", "Panini Comics",
				TematicaEnum.FANTASTICO, "BIBLIOTECA MARVEL", 128, new BigDecimal(5000),
				"Phillippe Briones, Roger Stern", Boolean.FALSE, LocalDate.now(), EstadoEnum.ACTIVO, 5L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);


		Assert.assertTrue(!gestionarComicPOJO.getListaComics().isEmpty());
		Assert.assertTrue(gestionarComicPOJO.getListaComics().size()==1);

		comicDTO = new ComicDTO();

		comicDTO.setId("100");
		comicDTO.setNombre("Dragon ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() > 1);

		comicDTO = new ComicDTO();

		comicDTO.setId("100");
		comicDTO.setNombre("Dragon ball Yamcha");
		comicDTO.setEditorial("Planeta Cómic");
		comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
		comicDTO.setColeccion("Manga Shonen");
		comicDTO.setNumeroPaginas(100);
		comicDTO.setPrecio(new BigDecimal(2100));
		comicDTO.setAutores("Dragon Garow Lee");
		comicDTO.setColor(Boolean.TRUE);
		comicDTO.setFechaVenta(LocalDate.now());
		comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
		comicDTO.setCantidad(20L);

		gestionarComicPOJO.agregarComicDTOLista(comicDTO);

		Assert.assertTrue(gestionarComicPOJO.getListaComics().size() == 3);
	}

	
		
//	
//	@Test
//	public void agregarComicDTOLista() {
//
//	}
}
