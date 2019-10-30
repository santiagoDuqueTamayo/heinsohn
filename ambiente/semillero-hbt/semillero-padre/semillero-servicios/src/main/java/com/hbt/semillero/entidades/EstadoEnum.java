/**
 * EstadoEnum.java
 */
package com.hbt.semillero.entidades;

/**
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author santi
 * @version 
 */
public enum EstadoEnum {
	ACTIVO("enum.estado.activo"),
	INACTIVO("enum.estado.activo");
	/*
	 * atributo que permite asignar un estado a las constantes
	 */
	private String estado;
	
	private EstadoEnum(String estado) {
		this.estado=estado;
	}

	/**
	 * Metodo encargado de retornar el valor del atributo estado
	 * @return El estado asociado a la clase
	 */
	public String getEstado() {
		return estado;
	}

	/**
	 * Metodo encargado de modificar el valor del atributo estado
	 * @param estado El nuevo estado a modificar.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	
}
