/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author santi
 * @version 
 */
public class GestionarComicPOJO {
	
	/*
	 * atributo que representa una lista de comicsDTO
	 */
	private List<ComicDTO> listaComics = null;
	
	/**
	 * 
	 * Metodo encargado de crear un comicDTO
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	public void crearComicDTO() {
		ComicDTO comicDTO=new ComicDTO(); 
	
		comicDTO.setId("100");
        comicDTO.setNombre("Dragon Ball Yamcha");
        comicDTO.setEditorial("Planeta Cómic");
        comicDTO.setTematicaEnum(TematicaEnum.AVENTURAS);
        comicDTO.setColeccion("Manga Shonen");
        comicDTO.setNumeroPaginas(100);
        comicDTO.setPrecio(new BigDecimal(2100));
        comicDTO.setAutores("Dragon Garow Lee");
        comicDTO.setColor(Boolean.FALSE);
        comicDTO.setFechaVenta(LocalDate.now());
        comicDTO.setEstadoEnum(EstadoEnum.ACTIVO);
        comicDTO.setCantidad(20L);
		if(listaComics==null) {
			listaComics=new ArrayList<>();
		}
		listaComics.add(comicDTO);
	}
	
public void modificarComicDTO(String id, String nombre) {
		
		ComicDTO comicAModificar = null;
		for (int i = 0; i < listaComics.size(); i++) {
			comicAModificar = listaComics.get(i);
			if(comicAModificar.getId().equals(id)) {				
				comicAModificar.setNombre(nombre);	
				return;
			}
		}
	}
	

	/**
	 * Metodo encargado de retornar el valor del atributo listaComics
	 * @return El listaComics asociado a la clase
	 */
	public List<ComicDTO> getListaComics() {
		return listaComics;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo listaComics
	 * @param listaComics El nuevo listaComics a modificar.
	 */
	public void setListaComics(List<ComicDTO> listaComics) {
		this.listaComics = listaComics;
	}
	
	
}
