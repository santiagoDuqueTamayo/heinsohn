/**
 * 
 */
package com.hbt.semillero.entidades;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * entidad que representa la tabla TC_USUARIO de la bd
 * @author admin
 *
 */
@Entity
@Table(name="TC_USUARIO")
public class Usuario {
	
	/**
	 * atributo que representa el id de un usuario
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
	 * atributo que repsenta la relacion de un usuario con una persona
	 */
	@OneToOne(mappedBy="usuario", fetch=FetchType.LAZY)
	@JoinColumn(name="SUIDPERSONA")
	private Persona persona;
	
	
	/**
	 * constructor vacío de la clase usuario
	 */
	public Usuario() {
		super();
	}


	/**
	 * constructor de la clase usuario con sus parametros por defecto
	 * @param id
	 * @param nombre
	 * @param fecha_creacion
	 * @param estado
	 * @param persona
	 */
	public Usuario(String id, String nombre, LocalDate fecha_creacion, EstadoEnum estado) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.fecha_creacion = fecha_creacion;
		this.estado = estado;
	}

	// GENERAR LOS SEQUENCE EN EL LADO DE LA BASE DE DATOS PARA ID Y NOMBRE
	/**
	 * atributo que eprmite obtener el id de un usuario
	 * @return the id
	 */
	@Id
	@SequenceGenerator(allocationSize = 1, name = "USUARIO_SUID_GENERATOR", sequenceName = "SEQ_USUARIOSUID")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARUIO_SUID_GENERATOR")
	@Column(name = "SUID")
	public String getId() {
		return id;
	}


	/**
	 * metodo que permite cambiar el id de un usuario
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}


	/**
	 * metodo QUE PERMITE OBTENER EL NOMBRE DE UN USUARIO
	 * @return the nombre
	 */
	@SequenceGenerator(allocationSize = 1, name = "USUARIO_SUNOMBRE_GENERATOR", sequenceName = "SEQ_USUARIOSUNOMBRE")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "USUARUIO_SUNOMBRE_GENERATOR")
	@Column(name = "SUNOMBRE")
	public String getNombre() {
		return nombre;
	}


	/**
	 * metodo que permite cambiar el nombre de un usuarui
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * metodo que permite obtener la fecha de creacion de un usuario
	 * @return the fecha_creacion
	 */
	@Column(name = "SCFECHA_CREACION")
	public LocalDate getFecha_creacion() {
		return fecha_creacion;
	}


	/**
	 * METODO QUE PERMITE EDITAR LA FECHA DE CREACION DE UN USARIO
	 * @param fecha_creacion the fecha_creacion to set
	 */
	public void setFecha_creacion(LocalDate fecha_creacion) {
		this.fecha_creacion = fecha_creacion;
	}


	/**
	 * METODO QUE PERMITE OBTENER EL ESTADO DE UNA PERSONA
	 * @return the estado
	 */
	public EstadoEnum getEstado() {
		return estado;
	}


	/**
	 * METODO QUE PERMITE MODIFICR EL ESTADO DE UNA PERSONA
	 * @param estado the estado to set
	 */
	public void setEstado(EstadoEnum estado) {
		this.estado = estado;
	}


	/**
	 * @return the persona
	 */
	public Persona getPersona() {
		return persona;
	}


	/**
	 * @param persona the persona to set
	 */
	public void setPersona(Persona persona) {
		this.persona = persona;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((estado == null) ? 0 : estado.hashCode());
		result = prime * result + ((fecha_creacion == null) ? 0 : fecha_creacion.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nombre == null) ? 0 : nombre.hashCode());
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
		Usuario other = (Usuario) obj;
		if (estado != other.estado)
			return false;
		if (fecha_creacion == null) {
			if (other.fecha_creacion != null)
				return false;
		} else if (!fecha_creacion.equals(other.fecha_creacion))
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
		return true;
	}


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", fecha_creacion=" + fecha_creacion + ", estado=" + estado
				+ ", persona=" + persona + "]";
	}
	
	

}
