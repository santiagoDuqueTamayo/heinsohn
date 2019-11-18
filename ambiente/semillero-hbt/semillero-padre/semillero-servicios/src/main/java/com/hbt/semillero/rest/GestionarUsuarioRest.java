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

import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.ejb.IGestionarUsuarioBean;
import com.hbt.semillero.ejb.IGestionarUsuarioBean;

/**
 * @author admin
 *
 */
@Path("/GestionarUsuario")
public class GestionarUsuarioRest {

	
	/**
	 * atributo que permite gestionar un Usuario
	 */
	@EJB
	IGestionarUsuarioBean gestionarUsuarioEJB;
	
	
	/**
	 * 
	 * Metodo encargado de traer la informacion de un comic determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComics
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarUsuarios")
	@Produces(MediaType.APPLICATION_JSON)
	public List<UsuarioDTO> consultarUsuarios() {
		return gestionarUsuarioEJB.consultarUsuarios();

	}

	/**
	 * 
	 * Metodo encargado de traer la informacion de un Usuario determiando
	 * http://localhost:8085/semillero-servicios/rest/GestionarComic/consultarComic?idComic=1
	 * 
	 * @param idUsuario
	 * @return
	 */
	@GET
	@Path("/consultaruUsario")
	@Produces(MediaType.APPLICATION_JSON)
	public UsuarioDTO consultarUsuario(@QueryParam("idUsuario") String idUsuario) {
		if (idUsuario != null) {
			UsuarioDTO usuarioDTO = gestionarUsuarioEJB.consultarUsuario(idUsuario);
			return usuarioDTO;
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
	public ResultadoDTO crearUsuario(UsuarioDTO UsuarioDTO) {
		return gestionarUsuarioEJB.crearUsuario(UsuarioDTO);
		
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
	public ResultadoDTO modificarAfiiado(@QueryParam("idUsuario") String idUsuario, @QueryParam("nombre") String nombre) {
		//Long.parseLong(idComic)
		return gestionarUsuarioEJB.modificarUsuario(idUsuario, nombre, null);
	}

	/**
	 * 
	 * Metodo encargado de eliminar un comic dado el id
	 * 
	 * @param idComic identificador del comic
	 */
	@POST
	@Path("/eliminar")
	public void eliminarComic(@QueryParam("idUsuario") String idUsuario) {
		if (idUsuario != null) {
			gestionarUsuarioEJB.ponerUsuarioInactivo(idUsuario);

		}
	}
}
