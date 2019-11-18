/**
 * 
 */
package com.hbt.semillero.ejb;

import java.time.LocalDate;
import java.util.List;

import javax.ejb.Local;
import javax.persistence.EntityExistsException;

import com.hbt.semillero.dto.ResultadoDTO;
import com.hbt.semillero.dto.UsuarioDTO;

/**
 * interface que me permite realizar los metodos que implementara el bean
 * @author admin
 *
 */
@Local
public interface IGestionarUsuarioBean {

	
	/**
	 * 
	 * Metodo encargado de crear un usuario  y persistirlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicNuevo informacion nueva a crear
	 */
	public ResultadoDTO crearUsuario(UsuarioDTO UsuarioDTO)throws EntityExistsException, IllegalArgumentException;

	/**
	 * 
	 * Metodo encargado de consultar un usuari o modificar su nombre y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicModificar informacion nueva a modificar
	 */
	public ResultadoDTO modificarUsuario(String id, String nombre, UsuarioDTO usuarioDTO)throws  IllegalArgumentException;

	/**
	 * 
	 * Metodo encargado de eliminar un afiliado modificarlo y guardarlo
	 * 
	 * @author ccastano
	 * 
	 * @param comicEliminar informacion a eliminar
	 */
	public void ponerUsuarioInactivo(String idUsuario);

	/**
	 * 
	 * Metodo encargado de retornar la informacion de un usuario
	 * 
	 * @param idUsuario identificador del usuarioo a ser consultado
	 * @return usuario Resultado de la consulta
	 * @throws Exception si no se recibe idComic
	 */
	public UsuarioDTO consultarUsuario(String idAfiliado);

	/**
	 * 
	 * Metodo encargado de retornar una lista de usuarios
	 * 
	 * @return
	 */
	public List<UsuarioDTO> consultarUsuarios();
	
	/**
	 * metodo encargado de validar fecha de ingreso
	 * @param fechaIngresada
	 * @return true si es una fecha valida, flase de lo contrario
	 */
	public Boolean validarFecha(LocalDate fechaIngresada);
	
	/**
	 * metodo encargado de validar si un usuario esta activo
	 * @param idUsuario
	 * @return true si el usuario esta activo , false de lo contrario
	 */
	public Boolean validarUsuarioActivo(String idUsuario);
	
	
}
