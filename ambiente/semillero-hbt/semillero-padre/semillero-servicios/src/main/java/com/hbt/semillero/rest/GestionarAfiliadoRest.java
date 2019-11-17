/**
 * 
 */
package com.hbt.semillero.rest;

import java.util.List;

import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.AfiliadoDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.ejb.IGestionarAfiliadoBean;

/**
 * Clase encargada de gestionar un afiliado a través del servicio rest
 * @author admin
 *
 */
@Path("/gestionarAfiliado")
public class GestionarAfiliadoRest {
	
	/**
	 * atributo que permite gestionar un afiliado
	 */
	@EJB
	IGestionarAfiliadoBean gestionarAfiliadoEJB;
	
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComics")
	@Produces(MediaType.APPLICATION_JSON)
	public List<AfiliadoDTO> consultarComic() {
		return gestionarAfiliadoEJB.consultarAfiliados();

	}

	/**
	 * 
	 * Metodo encargado de traer la informacion de un afiliado determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComic?idComic=1
	 * 
	 * @param idAfiliado
	 * @return
	 */
	@GET
	@Path("/consultarAfiliado")
	@Produces(MediaType.APPLICATION_JSON)
	public AfiliadoDTO consultarComic(@QueryParam("idAfiliado") Long idAfiliado) {
		if (idAfiliado != null) {
			AfiliadoDTO afiliadoDTO = gestionarAfiliadoEJB.consultarAfiliado(idAfiliado);
			return afiliadoDTO;
		}
		return null;
	}

	/**
	 * Crea las personas en sus diferentes roles dentro del sistema.
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/crear
	 * @param persona
	 * @return
	 */
	@POST
	@Path("/crear")
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	public ResultadoDTO crearAfiliado(AfiliadoDTO afiliadoDTO) {
		return gestionarAfiliadoEJB.crearAfiliado(afiliadoDTO);
		
	}

	/**
	 * 
	 * Metodo encargado de modificar el nombre de un comic
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/modificar?idComic=1&nombre=nuevonombre
	 * @param idComic identificador del comic a buscar
	 * @param nombre nombre nuevo del comic8
	 */
	@POST
	@Path("/modificar")
	@Produces(MediaType.APPLICATION_JSON)
	public ResultadoDTO modificarAfiiado(@QueryParam("idAfiliado") Long idAfiliado, @QueryParam("nombre") String nombre) {
		//Long.parseLong(idComic)
		return gestionarAfiliadoEJB.modificarAfiliado(idAfiliado, nombre, null);
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic dado el id
	 * 
	 * @param idComic identificador del comic
	 */
	@POST
	@Path("/eliminar")
	public void eliminarComic(@QueryParam("idAfiliado") Long idAfiliado) {
		if (idAfiliado != null) {
			gestionarAfiliadoEJB.eliminarAfiliado(idAfiliado);

		}
	}
}
