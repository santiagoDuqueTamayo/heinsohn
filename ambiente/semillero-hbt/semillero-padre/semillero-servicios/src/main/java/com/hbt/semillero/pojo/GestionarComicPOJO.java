/**
 * GestionarComicPOJO.java
 */
package com.hbt.semillero.pojo;

import java.util.List;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author santi
 * @version 
 */
public class GestionarComicPOJO {
	
	private List<ComicDTO> listaComics = null;
	//TODO continuar llenando el comicDTO para la sesión del jueves
	public void crearComicDTO() {
		ComicDTO comicDTO=new ComicDTO(); 
		
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
