/**
 * 
 */
package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * @author admin
 *
 */
public class PersonaDTO implements Serializable{
	
	//esta clas eno la necesito de mmento porque persisto en cascada desde usuario
	//la cree por si decido hacer un cambio a futuro
	
	/**
	 * atributo que repsenta el id de la serializacion
	 */
	private static final long serialVersionUID = 5292690678919956811L;
	/**
	 * atributo que representa el id unico de una eprsona
	 */
	private String id;
	/**
	 * atributo que representa el nombre de una persona
	 */
	private String nombre;
	/**
	 * atributo que representa la cedula de una persona 
	 */
	private String cedula;
	
	
	/**
	 * constructor vacio que genera una personaDTO
	 */
	public PersonaDTO() {
		super();
	}


	/**
	 * constructor con atributos de la clase personaDTO
	 * @param id
	 * @param nombre
	 * @param cedula
	 */
	public PersonaDTO(String id, String nombre, String cedula) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cedula = cedula;
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
	 * @return the cedula
	 */
	public String getCedula() {
		return cedula;
	}


	/**
	 * @param cedula the cedula to set
	 */
	public void setCedula(String cedula) {
		this.cedula = cedula;
	}
	
	
	
}
