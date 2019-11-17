/**
 * 
 */
package com.hbt.semillero.entidades;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * clase que representa un afiliado que puede hacer compras
 * @author admin
 *
 */
@Entity
@Table(name="AFILIADO")
public class Afiliado implements Serializable {

	/**
	 * atributo que representa el id serializable de la clase
	 */
	private static final long serialVersionUID = 7654046393222174989L;
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
	 * atributo que representa el coreo de un afiliado
	 */
	private String correo;
	/**
	 * metodo que representa unconstructor vacio de la clase afiliado
	 */
	public Afiliado() {
		super();
	}
	/**
	 * metodo que rpresenta el constructor de la clase
	 */
	public Afiliado(Long id, String nombre, String pass, String correo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.pass = pass;
		this.correo = correo;
	}
	/**
	 * @return the id
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "AFILIADO_SCID_GENERATOR", sequenceName = "SEQ_AFILIADO")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "AFILIADO_SCID_GENERATOR")
	@Column(name = "SCID")
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
	@Column(name = "SCNOMBRE")
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
	@Column(name="SCPASS")
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
	@Column(name="SCCORREO")
	public String getCorreo() {
		return correo;
	}
	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Afiliado [id=" + id + ", nombre=" + nombre + ", pass=" + pass + ", correo=" + correo + "]";
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correo == null) ? 0 : correo.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Afiliado other = (Afiliado) obj;
		if (correo == null) {
			if (other.correo != null)
				return false;
		} else if (!correo.equals(other.correo))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nombre == null) {
			if (other.nombre != null)
				return false;
		} else if (!nombre.equals(other.nombre))
			return false;
		if (pass == null) {
			if (other.pass != null)
				return false;
		} else if (!pass.equals(other.pass))
			return false;
		return true;
	}
	
	
	
}
