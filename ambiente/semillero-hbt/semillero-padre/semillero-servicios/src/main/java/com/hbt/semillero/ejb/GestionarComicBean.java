/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.entidades.Comic;

/**
 * <b>Descripción:<b> es para hacer la comunicación entre la base de datos y la
 * app <b>Caso de Uso:<b>
 * 
 * @author santi
 * @version
 */
@Stateless
public class GestionarComicBean implements IGestionarComicLocal{
	
	//TODO
	//Agregar comentarios a la clase
	/**
	 * Llenar todos los campos de comic DTO
	 */
	@PersistenceContext
	private EntityManager em;
	// TODO
	// Agregar transaccion 
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#crearComic(com.hbt.semillero.dto.ComicDTO)
	 */
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)//tengo una conversacion activa?, no o si ---yo reo una transaccion nueva
	public void crearComic(ComicDTO comicDTO) {
		// Entidad nueva
		Comic comic = convertirComicDTOToComic(comicDTO);
		em.persist(comic);
	}
	
	

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
		//comic.setId(comicModificar.getId());
		em.merge(comicModificar);
	}
	
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String idComic) {
		Comic comic = em.find(Comic.class, idComic);
		ComicDTO comicDTO = convertirComicToComicDTO(comic);
		return comicDTO;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComic() {
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null; 
	}
	/**
	 * 
	 * @see com.hbt.semillero.ejb.IGestionarComicLocal#modificarComic(java.lang.Long, java.lang.String, com.hbt.semillero.dto.ComicDTO)
	 */
	@Override
	//@TransactionAttribute(TransactionAttributeType.REQUIRED)
	//TODO Cual es el resultado de llamar a modificarComic
	public void modificarComic(Long id, String nombre, ComicDTO comicNuevo) {
		Comic comicModificar;
		if (comicNuevo==null) {
//			manejar la entidad , si esta manejada el entity manager puede manejarla
			comicModificar=em.find(Comic.class, id);
		} else {
			comicModificar=convertirComicDTOToComic(comicNuevo);
		}//TODO validar si comicModificar llego con datos
		comicModificar.setNombre(nombre);
		// si encuentra en la bd actualiza, sino inserta
		em.merge(comicModificar);
	}

	@Override
	public void eliminarComic(Long idComic) {
		// TODO el metodo  eliminar es el primero que debemos hacer para entregar
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComics() {
		// TODO hacer que lista de resultados sea igual a nula y ver que pasa con resultados
		List<ComicDTO> resultadosComicDTO=new ArrayList<ComicDTO>();
		List<Comic> resultados= em.createQuery("select c from Comic c").getResultList();
		for ( Comic comic: resultados) {
			resultadosComicDTO.add(convertirComicToComicDTO(comic));
		}
		return resultadosComicDTO;
	}
	/**
	 * 
	 * Metodo encargado de traspasar informacion de un lado a otro, no incluye manipuilacion de datos
	 * <b>Caso de Uso</b>
	 * @author santi
	 * 
	 * @param comicDTO
	 * @return
	 */
	private Comic convertirComicDTOToComic(ComicDTO comicDTO) {
		Comic comic = new Comic();
        if(comicDTO.getId()!=null) {
            comic.setId(Long.parseLong(comicDTO.getId()));
        }
        comic.setNombre(comicDTO.getNombre());
        comic.setEditorial(comicDTO.getEditorial());
        comic.setTematicaEnum(comicDTO.getTematicaEnum());
        comic.setColeccion(comicDTO.getColeccion());
        comic.setNumeroPaginas(comicDTO.getNumeroPaginas());
        comic.setPrecio(comicDTO.getPrecio());
        comic.setAutores(comicDTO.getAutores());
        comic.setColor(comicDTO.getColor());
        comic.setFechaVenta(comicDTO.getFechaVenta());
        comic.setEstadoEnum(comicDTO.getEstadoEnum());
        comic.setCantidad(comicDTO.getCantidad());
        return comic;
	}  
	
	private ComicDTO convertirComicToComicDTO(Comic comic) {
        ComicDTO comicDTO = new ComicDTO();
        if(comic.getId()!=null) {
         comicDTO.setId(comic.getId().toString());
        }
        comicDTO.setNombre(comic.getNombre());
        comicDTO.setEditorial(comic.getEditorial());
        comicDTO.setTematicaEnum(comic.getTematicaEnum());
        comicDTO.setColeccion(comic.getColeccion());
        comicDTO.setNumeroPaginas(comic.getNumeroPaginas());
        comicDTO.setPrecio(comic.getPrecio());
        comicDTO.setAutores(comic.getAutores());
        comicDTO.setColor(comic.getColor());
        comicDTO.setFechaVenta(comic.getFechaVenta());
        comicDTO.setEstadoEnum(comic.getEstadoEnum());
        comicDTO.setCantidad(comic.getCantidad());
        return comicDTO;
	}
}
