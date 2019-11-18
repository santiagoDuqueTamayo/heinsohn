/**
 * 
 */
package com.hbt.semillero.entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * esta clase representa una persona del modelo de datos
 * @author admin
 *
 */
@Entity
@Table(name="TC_PERSONA")
public class Persona {
	
	
	//TODO generar los has,tostring despupes de que defina todos los parametros
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
		 * constructor sin parametros de la clase persona
		 */
		public Persona() {
			super();
		}
		/**
		 * constructor con los parametros por defecto de la clase persona
		 * @param id
		 * @param nombre
		 * @param cedula
		 */
		public Persona(String id, String nombre, String cedula) {
			super();
			this.id = id;
			this.nombre = nombre;
			this.cedula = cedula;
		}
		/**
		 * metodo que permite obtener el id de una persona
		 * @return the id
		 */
		@Id
		//TODO crear la secuencia para el id en el sql
		@SequenceGenerator(allocationSize = 1, name = "PERSONA_SPID_GENERATOR", sequenceName = "SEQ_PERSONA")
		@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PERSONA_SPID_GENERATOR")
		@Column(name = "SPID")
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
		 * @return the cedula
		 */
		@Column(name = "SCNUMIDENTIFICACION")
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
