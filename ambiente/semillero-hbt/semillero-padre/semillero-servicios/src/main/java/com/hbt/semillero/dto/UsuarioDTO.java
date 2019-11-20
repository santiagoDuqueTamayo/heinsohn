/**
 * 
 */
package com.hbt.semillero.dto;

import java.io.Serializable;
import java.time.LocalDate;

import com.hbt.semillero.entidades.EstadoEnum;

/**
 * clase que repsenta el dto de un usuario 
 * @author admin
 *
 */
public class UsuarioDTO implements Serializable{
	
	/**
	 * atributo que permite asignar id de serializacion
	 */
	private static final long serialVersionUID = 114581170626666513L;
	/**
	 * atributo que repsenta el id de un usuario
	 */
	private String id;
	/**
	 * atributo que representa el nombre de un usuario , debe ser autogenerado
	 */
	private String nombre;
	/**
	 * atributo que repsenta la fecha de creacion de un usuario
	 */
	private LocalDate fecha_creacion;
	/**
	 * atributo que repsenta el estado de un usario true si es activo, 
	 * false de lo contrario
	 */
	private EstadoEnum estado;
	
	/**
	 * atributo que representa una persona 
	 */
	private PersonaDTO personaDTO;
	
	/**
	 * Constructor de la clase Usuario vacio
	 */
	public UsuarioDTO() {
		super();
	}
	/**
	 * constructor de la clase usuario con metodos por defecto
	 * @param nombre
	 * @param fecha_creacion
	 * @param estado
	 */
	public UsuarioDTO(String id, String nombre, LocalDate fecha_creacion, EstadoEnum estado) {
		super();
		this.id=id;
		this.nombre = nombre;
		this.fecha_creacion = fecha_creacion;
		this.estado = estado;
	}
	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}
	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	/**
	 * @return the fecha_creacion
	 */
	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}
	/**
	 * @param fecha_creacion the fecha_creacion to set
	 */
	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}
	/**
	 * @return the estado
	 */
	public EstadoEnum getEstado() {
		return estado;
	}
	/**
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * Metodo encargado de retornar el valor del atributo personaDTO
	 * @return El personaDTO asociado a la clase
	 */
	public PersonaDTO getPersonaDTO() {
		return personaDTO;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo personaDTO
	 * @param personaDTO El nuevo personaDTO a modificar.
	 */
	public void setPersonaDTO(PersonaDTO personaDTO) {
		this.personaDTO = personaDTO;
	}
	
	
}
