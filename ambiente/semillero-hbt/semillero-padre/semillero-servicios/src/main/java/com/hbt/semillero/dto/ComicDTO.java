package com.hbt.semillero.dto;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

import com.fasterxml.jackson.databind.ser.std.StaticListSerializerBase;
import com.hbt.semillero.entidades.EstadoEnum;
import com.hbt.semillero.entidades.TematicaEnum;

/**
 * 
 * <b>Descripción:<b> Clase que determina
 * <b>Caso de Uso:<b> 
 * @author santi
 * @version
 */
public class ComicDTO implements Serializable{
	/**
	 * Atributo que determina  la version del serializable id
	 */
	private static final long serialVersionUID = -3771509992508374504L;

	/**
	 * Este id representa el identificador del comic
	 */
	private String id;
	
	/**
	 * Este atributo representa el nombre de un comic
	 */
	private String nombre;
	
	private String editorial;
	
	
	private TematicaEnum tematicaEnum;
	
	private String coleccion; 
	
	private Integer numeroPaginas;
	
	private BigDecimal precio;
	
	private Boolean color;
	

	private String autores;
	
	private LocalDate fechaVenta;
	
	//TODO
	private EstadoEnum estadoEnum;
	
	private Long cantidad;

	/**
	 * 
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 * @param editorial
	 * @param tematica
	 * @param coleccion
	 * @param numeroPaginas
	 * @param precio
	 * @param color
	 * @param autores
	 * @param fechaVenta
	 * @param estado
	 * @param cantidad
	 */
	public ComicDTO(String id, String nombre, String editorial, TematicaEnum tematica, String coleccion,
			Integer numeroPaginas, BigDecimal precio, boolean color, String autores, LocalDate fechaVenta,
			EstadoEnum estado, Long cantidad) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.editorial = editorial;
		this.tematicaEnum = tematica;
		this.coleccion = coleccion;
		this.numeroPaginas = numeroPaginas;
		this.precio = precio;
		this.color = color;
		this.autores = autores;
		this.fechaVenta = fechaVenta;
		this.estadoEnum = estado;
		this.cantidad = cantidad;
	}
	public ComicDTO() {
		
	}

	/**
	 * 
	 * Constructor de la clase.
	 * @param id
	 * @param nombre
	 */
	public ComicDTO(String id, String nombre) {
		super();
		this.id = id;
		this.nombre = nombre;
	}


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEditorial() {
		return editorial;
	}

	public void setEditorial(String editorial) {
		this.editorial = editorial;
	}
	
	public TematicaEnum getTematicaEnum() {
		return tematicaEnum;
	}

	public void setTematicaEnum(TematicaEnum tematicaEnum) {
		this.tematicaEnum = tematicaEnum;
	}

	public String getColeccion() {
		return coleccion;
	}

	public void setColeccion(String coleccion) {
		this.coleccion = coleccion;
	}

	public Integer getNumeroPaginas() {
		return numeroPaginas;
	}

	public void setNumeroPaginas(Integer numeroPaginas) {
		this.numeroPaginas = numeroPaginas;
	}

	public BigDecimal getPrecio() {
		return precio;
	}

	public void setPrecio(BigDecimal precio) {
		this.precio = precio;
	}

	public boolean isColor() {
		return color;
	}

	public void setColor(boolean color) {
		this.color = color;
	}

	public String getAutores() {
		return autores;
	}

	public void setAutores(String autores) {
		this.autores = autores;
	}

	public LocalDate getFechaVenta() {
		return fechaVenta;
	}
	
	/**
	 * Metodo encargado de retornar el valor del atributo color
	 * @return El color asociado a la clase
	 */
	public Boolean getColor() {
		return color;
	}
	/**
	 * Metodo encargado de modificar el valor del atributo color
	 * @param color El nuevo color a modificar.
	 */
	public void setColor(Boolean color) {
		this.color = color;
	}

	public void setFechaVenta(LocalDate fechaVenta) {
		this.fechaVenta = fechaVenta;
	}

	public EstadoEnum getEstadoEnum() {
		return estadoEnum;
	}

	public void setEstadoEnum(EstadoEnum estado) {
		this.estadoEnum = estado;
	}

	public Long getCantidad() {
		return cantidad;
	}

	public void setCantidad(Long cantidad) {
		this.cantidad = cantidad;
	}
		
}
