/**
 * 
 */
package com.hbt.semillero.ejb;

import java.util.List;

import com.hbt.semillero.dto.AfiliadoDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;

/**
 *  Expone los métodos del EJB GestionarAfiliado Las interfaces determinan una
 * especie de contrato donde se define las firmas de los metodos, define que se
 * necesita implementar pero no el como eso lo realiza la clase que la
 * implementa Palabras claves interface e implements
 * @author admin
 *
 */
public interface IGestionarAfiliadoBean {

	/**
	 * 
	 * Metodo encargado de crear un afiliadocomic y persistirlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicNuevo informacion nueva a crear
	 */
	public ResultadoDTO crearAfiliado(AfiliadoDTO afiliadoDTO);

	/**
	 * 
	 * Metodo encargado de consultar un afiliado modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicModificar informacion nueva a modificar
	 */
	public ResultadoDTO modificarAfiliado(Long id, String nombre, AfiliadoDTO afiliadoDTO);

	/**
	 * 
	 * Metodo encargado de eliminar un afiliado modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicEliminar informacion a eliminar
	 */
	public void eliminarAfiliado(Long idAfiliado);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un afiliado
	 * 
	 * @param idAfiliado identificador del afiliado a ser consultado
	 * @return afiliado Resultado de la consulta
	 * @throws Exception si no se recibe idComic
	 */
	public AfiliadoDTO consultarAfiliado(Long idAfiliado);

	/**
	 * 
	 * Metodo encargado de retornar una lista de comics
	 * 
	 * @return
	 */
	public List<AfiliadoDTO> consultarAfiliados();
}
