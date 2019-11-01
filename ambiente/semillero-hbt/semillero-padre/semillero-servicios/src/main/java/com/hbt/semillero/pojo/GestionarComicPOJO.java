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
	 * Metodo encargado de  crear un comicDto a través de parametros
	 * <b>Caso de Uso</b>
	 * @author santi
	 * 
	 * @param string
	 * @param string2
	 * @param string3
	 * @param fantastico
	 * @param string4
	 * @param i
	 * @param bigDecimal
	 * @param string5
	 * @param false1
	 * @param now
	 * @param string6
	 * @param l
	 */
	public ComicDTO crearComicDTO(String id, String nombre, String editorial,
			TematicaEnum tematica, String coleccion, int numPaginas, BigDecimal precio, String autores, Boolean color,
			LocalDate fechaDeVenta, EstadoEnum estado, long cantidad) {
		// TODO Auto-generated method stub
		ComicDTO comicDTO=new ComicDTO(id,nombre,editorial,tematica,coleccion,numPaginas,precio,color,autores,fechaDeVenta,estado,cantidad);
		
		return comicDTO;
	}
	
	public void agregarComicDTOLista(ComicDTO comicDTO) {
		if (listaComics!=null) {
			listaComics.add(comicDTO); 
		}
	}
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
	
	/**
	 * 
	 * Metodo encargado de modificar el nombre de un elementos
	 * <b>Caso de Uso</b>
	 * @author santi
	 * 
	 * @param id
	 * @param nombre
	 */
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
 * 
 * Metodo encargado de eliminar un elemento por su id
 * <b>Caso de Uso</b>
 * @author santi
 * 
 * @param id
 */
public void eliminarComic(String id) {
	listaComics.remove(buscarElemento(id));
}
/**
 * 
 * Metodo encargado de buscar un elemento por su id
 * <b>Caso de Uso</b>
 * @author santi
 * 
 * @param id
 * @return
 */
public int buscarElemento(String id) {
	
		ComicDTO comicDTO=new ComicDTO(); 
		boolean comicEncontrado=false;
		int i=0;
		while (i<=listaComics.size()&&comicEncontrado==false) {
			if (listaComics.get(i).getId().equals(id)) {
				comicEncontrado=true;
				return i;
			}
			i++;
		} 
		return -1;
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
