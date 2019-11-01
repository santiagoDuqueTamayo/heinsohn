/**
 * GestionarComicBean.java
 */
package com.hbt.semillero.ejb;

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
public class GestionarComicBean {
	
	//TODO
	//Agregar comentarios a la clase
	/**
	 * Llenar todos los campos de comic DTO
	 */
	@PersistenceContext
	private EntityManager em;
	// TODO
	// Agregar transaccion

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void crearComic(ComicDTO comicDTO) {
		// Entidad nueva
		Comic comic = new Comic();
		comic.setId(comicDTO.getId());
		em.persist(comic);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void modificarComic(ComicDTO comicModificar) {
		Comic comic = new Comic();
		comic.setId(comicModificar.getId());
		em.merge(comicModificar);
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public ComicDTO consultarComic(String idComic) {
		Comic comic = em.find(Comic.class, idComic);
		ComicDTO comicDTO = new ComicDTO(comic.getId(), comic.getNombre());

		return comicDTO;
	}

	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<ComicDTO> consultarComic() {
		List<Comic> resultados = (List<Comic>) em.createQuery("select c from Comic").getResultList();
		return null; 
	}
	

}
