/**
 * 
 */
package com.hbt.semillero.dto;

import java.io.Serializable;

/**
 * @author admin
 *
 */
public class AfiliadoDTO implements Serializable {

	/**
	 * atributo que representa la proeiedad serializable de la clase
	 */
	private static final long serialVersionUID = -6877186250629195883L;
	/**
	 * atributo que representa el id de un afiliado
	 */
	private Long id;
	/**
	 * atributo que representa el nombre de un afiliado
	 */
	private String nombre;
	/**
	 * atributo que representa la contrasena de un afiliado
	 */
	private String pass;
	/**
	 * aatributo que representa el correo de un agiliado
	 */
	private String correo;
	
	/**
	 * constructor vacio de la clase afiliadoDRO
	 */
	public AfiliadoDTO() {
		super();
	}

	/**
	 * constructor con los parametros del afiliado
	 * @param id
	 * @param nombre
	 * @param pass
	 * @param correo
	 */
	public AfiliadoDTO(Long id, String nombre, String pass, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
		this.correo = correo;
	}

	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
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
	 * @return the pass
	 */
	public String getPass() {
		return pass;
	}

	/**
	 * @param pass the pass to set
	 */
	public void setPass(String pass) {
		this.pass = pass;
	}

	/**
	 * @return the correo
	 */
	public String getCorreo() {
		return correo;
	}

	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}

	/**
	 * @return the serialversionuid
	 */
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	
	
}
