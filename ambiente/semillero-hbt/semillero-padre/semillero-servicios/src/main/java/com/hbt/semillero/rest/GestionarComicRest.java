/**
 * GestionarComicRest.java
 */
package com.hbt.semillero.rest;

import java.math.BigDecimal;
import java.time.LocalDate;

import javax.ejb.EJB;
import javax.ws.rs.GET;
import javax.ws.rs.PATCH;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.ejb.IGestionarComicLocal;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * <b>Descripción:<b> utilizamos gestionarComicBean con el mundo exterior
 * <b>Caso de Uso:<b> 
 * @author santi
 * @version 
 */
@Path("/GestionarComic")
public class GestionarComicRest  {
	@EJB
	private IGestionarComicLocal gestionarComicEJB;
	
	@GET //tipo de envio
	@Path("/saludo") //ruta de acceso publica
	@Produces //define el tipo de reurso que se va a producir
	public String primerRest() {
		return "hola mundo, esto es un cambio";
	}
	/**
	 * 
	 * Metodo encargado de consultar un comic en la base de datos y enviarlo como un Json
	 * <b>Caso de Uso</b>
	 * @author santi
	 * 
	 * @param idComic
	 * @return
	 */
	@GET
	@Path("/consultarComic")
	@Produces(MediaType.APPLICATION_JSON)//convierte el mensaje a JSON
	public ComicDTO consultarComic(@QueryParam("idComic") Long idComic)  {
		if (idComic!=null) {
			return gestionarComicEJB.consultarComic(idComic.toString());
		}
		return null;
	}

	@GET
	@Path("/eliminarComic")
	@Produces(MediaType.APPLICATION_JSON)//convierte el mensaje a JSON
	public void eliminarComic(@QueryParam("idComic") Long idComic)  {
		if (idComic!=null) {
			gestionarComicEJB.eliminarComic(idComic);
		}
	}
	
	@GET
	@Path("/crearComic")
	@Produces
	public String crearComic(@QueryParam("idComic") String idComic, @QueryParam("nombre") String nombre,@QueryParam("editorial") String editorial,
			@QueryParam("tematica")TematicaEnum tematica,@QueryParam("estado") EstadoEnum estado, @QueryParam("coleccion")String coleccion,@QueryParam("numeroPaginas") Integer numeroPaginas, 
			@QueryParam("precio") BigDecimal precio, @QueryParam("color")boolean color,@QueryParam("autores") String autores,@QueryParam("fecha")String fecha,@QueryParam("cantidad") Long cantidad ) {
			
		LocalDate localDate;
		ComicDTO comicDTO= new ComicDTO(idComic, nombre, editorial, tematica, coleccion, numeroPaginas, precio, color, autores,localDate = LocalDate.parse(fecha), estado, cantidad);
			gestionarComicEJB.crearComic(comicDTO);
		return "se creo el elemento en la bd";
	}
	@GET
	@Path("/modificarComic")
	@Produces(MediaType.APPLICATION_JSON)//convierte el mensaje a JSON
	public void modificarComic(@QueryParam("idComic") String idComic, @QueryParam("nombre") String nombre,
			@QueryParam("editorial") String editorial,
			@QueryParam("tematica")TematicaEnum tematica,@QueryParam("estado") EstadoEnum estado, 
			@QueryParam("coleccion")String coleccion,@QueryParam("numeroPaginas") Integer numeroPaginas, 
			@QueryParam("precio") BigDecimal precio, @QueryParam("color")boolean color,
			@QueryParam("autores") String autores,@QueryParam("fecha")String fecha,
			@QueryParam("cantidad") Long cantidad)  {
		
		if (idComic!=null) {
			LocalDate localDate;
			ComicDTO comicDTO= new ComicDTO(idComic, nombre, editorial, tematica, coleccion, numeroPaginas, precio, color, autores,localDate = LocalDate.parse(fecha), estado, cantidad);
			gestionarComicEJB.modificarComic(Long.parseLong(idComic), nombre, comicDTO);
	}
	}
}
