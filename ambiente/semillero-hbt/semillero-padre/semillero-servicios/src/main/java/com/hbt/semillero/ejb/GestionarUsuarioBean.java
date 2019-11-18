/**
 * 
 */
package com.hbt.semillero.ejb;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityExistsException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.hbt.semillero.dto.AfiliadoDTO;
import com.hbt.semillero.dto.ComicDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.UsuarioDTO;
import com.hbt.semillero.entidades.Afiliado;
import com.hbt.semillero.entidades.Comic;
import com.hbt.semillero.entidades.Usuario;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.Usuario;

/**
 * @author admin
 *
 */
@Stateless
public class GestionarUsuarioBean implements IGestionarUsuarioBean{

		/**
		 * atributo que me permite gestionar la persistencia
		 */
	@PersistenceContext
	private EntityManager em;
	/**
	 * metodo que me permite persistir un usuaruo segun el usuario ingresado por el cliente
	 * @param el usuario ingresaro por el cliente
	 * @return mensaje al intentar crear el usuario
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
	public ResultadoDTO crearUsuario(UsuarioDTO usuarioDTO) throws EntityExistsException, IllegalArgumentException {
		LocalDate fechaIngresada=usuarioDTO.getFecha_creacion();
		String idUsuario =usuarioDTO.getId();
		ResultadoDTO resultadoDTO= new ResultadoDTO();
		if (validarFecha(fechaIngresada)==true&&validarUsuarioActivo(idUsuario)==true) {
			Usuario usuario;
			
			try {
				usuario=(convertirUsuarioDTOToUsuario(usuarioDTO));
				em.persist(usuario);
				resultadoDTO.setExitoso(true);
				resultadoDTO.setMensajeEjecucion("se ha creado el usuario correctamente");
				return resultadoDTO;
			} catch (EntityExistsException e) {
				// TODO: handle exception
				resultadoDTO.setExitoso(false);
				resultadoDTO.setMensajeEjecucion("error al intentar crear el usuario"+e);
			}catch (IllegalArgumentException e) {
				// TODO: handle exception
				resultadoDTO.setExitoso(false);
				resultadoDTO.setMensajeEjecucion("error al intentar crear el usuario"+e);
			}
				
			// TODO Auto-generated method stub
		} else {
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("error al intentar crear el usuario, verifique que la fecha "
					+ "insertada es menor que la fecha de hoy o que el usuario este activo");
		}
		return resultadoDTO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public ResultadoDTO modificarUsuario(String id, String nombre, UsuarioDTO usuarioDTO)
			throws IllegalArgumentException {
		ResultadoDTO resultadoDTO= new ResultadoDTO();
		Usuario usuarioModificar;
		try {
			if (usuarioDTO==null) {
				//UsuarioDTO UsuarioDTO= new UsuarioDTO("6", nombre, editorial, tematica, coleccion, numeroPaginas, precio, color, autores, fechaVenta, estado, cantidad)
//				manejar la entidad , si esta manejada el entity manager puede manejarla
				usuarioModificar=em.find(Usuario.class, Long.parseLong(id));
			} else {
				usuarioModificar=convertirUsuarioDTOToUsuario(usuarioDTO);
			}//TODO validar si UsuarioModificar llego con datos
			usuarioModificar.setNombre(nombre);
			// si encuentra en la bd actualiza, sino inserta
			em.merge(usuarioModificar);
			resultadoDTO.setExitoso(true);
			resultadoDTO.setMensajeEjecucion("usuario modificado con exito");
		}catch (IllegalArgumentException e) {
			// TODO: handle exception
			resultadoDTO.setExitoso(false);
			resultadoDTO.setMensajeEjecucion("error al intentar modificar el afiliado"+e);
			
		}
		return resultadoDTO;
	}
	/**
	 * metodo que permite actualizar ele stado de un usuario a inactivo
	 */
	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void ponerUsuarioInactivo(String idUsuario) {
		// TODO Auto-generated method stub
		Usuario usuario=convertirUsuarioDTOToUsuario(consultarUsuario(idUsuario));
		usuario.setEstado(EstadoEnum.INACTIVO);
			em.merge(usuario);
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public UsuarioDTO consultarUsuario(String idUsuario) {
		Usuario Usuario = em.find(Usuario.class, Long.parseLong(idUsuario));
		UsuarioDTO UsuarioDTO = convertirUsuarioToUsuarioDTO(Usuario);
		return UsuarioDTO;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
	public List<UsuarioDTO> consultarUsuarios() {
		// TODO Auto-generated method stub
		List<UsuarioDTO> resultadosComicDTO=new ArrayList<UsuarioDTO>();
		List<Usuario> resultados= em.createQuery("select u from Tc_usuario u").getResultList();
		for ( Usuario usuario: resultados) {
			resultadosComicDTO.add(convertirUsuarioToUsuarioDTO(usuario));
		}
		return resultadosComicDTO;
		
	}

	@Override
	public Boolean validarFecha(LocalDate fechaIngresada) {
		// TODO Auto-generated method stub
		Boolean resultado=false;
		if (fechaIngresada!=null) {
			LocalDate fechaActual=LocalDate.now();
			if (fechaIngresada.isBefore(fechaActual)) {
				resultado=true;
			}
		}
		return resultado;
		
		  
	
		
	}
	/**
	 * metodo que me permite validar si un usuario esta activo
	 * si es activo retorna true , delo contrario false
	 * @param idUsuario id del usuario a analizar
	 * @return true si el usuario esta activo
	 */
	@Override
	public Boolean validarUsuarioActivo(String idUsuario) {
		// TODO Auto-generated method stub
		LocalDate fechaActual=LocalDate.now();
		Usuario usuario;
		usuario= em.find(Usuario.class, Long.parseLong(idUsuario));
		if (usuario.getFecha_creacion().lengthOfYear()<365) {
			return true;
		}else {
			return false;
		}
		
		
	}
	
	/**
	 * metodo qu permite convertir un  usuario a un usuarioDTO
	 * @param ususarioafiliado
	 * @return
	 */
	private UsuarioDTO convertirUsuarioToUsuarioDTO(Usuario usuario) {
		UsuarioDTO usuarioDTO= new UsuarioDTO();
		try {
			if (usuario.getId()!=null) {
				usuarioDTO.setId(usuario.getId());
				usuarioDTO.setNombre(usuario.getNombre());
				usuarioDTO.setFecha_creacion(usuario.getFecha_creacion());
				usuarioDTO.setEstado(usuario.getEstado());
				
			} else {
				return null;
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
		return usuarioDTO;
	}
	/**
	 * metodo que permite conviertir un usuarioDTO a un usuario
	 * @param usuarioDTO
	 * @return
	 */
	private Usuario convertirUsuarioDTOToUsuario(UsuarioDTO usuarioDTO) {
		Usuario usuario = new Usuario();
		try {
			if (usuarioDTO.getId()!=null) {
				usuario.setId(usuarioDTO.getId());
			
			}
			usuario.setNombre(usuarioDTO.getNombre());
			usuario.setFecha_creacion(usuarioDTO.getFecha_creacion());
			usuario.setEstado(usuarioDTO.getEstado());
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
			
		} 
		return usuario;
		
	}

}
