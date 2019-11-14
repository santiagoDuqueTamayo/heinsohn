package com.hbt.semillero.servicios;

import java.util.ArrayList;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPojo;

public class EjeciciosTest {

	private static EjerciciosPojo ejercicio= new EjerciciosPojo();
	@Test
	public  void ejercicioTres() {
		//esto es para saber si 5 es primo, poner el numero 
		Assert.assertEquals(ejercicio.esPrimo(5), true);
		//esto es para saber si 222 es primo poner el numero 
		Assert.assertEquals(ejercicio.esPrimo(222), true);
		//esto es para saber si 0 es primoponer el numero 
		Assert.assertEquals(ejercicio.esPrimo(0), true);
		
	}
	/**
	 * 
	 * Metodo encargado de probar el ordenamiento de un arreglo 50,1,249,-2
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void EjercicioCuatro() {
		int[] arreglo=ejercicio.ordenarArreglo();
		Assert.assertEquals(arreglo[0], -2);
		Assert.assertEquals(arreglo[3], 249);
		Assert.assertEquals(arreglo.length, 4);
		
	}
	/**
	 * 
	 * Metodo encargado de encontrar secuencia, si el assert se cumple es
	 * porque la suma de los chart es igual a la ingresada
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void ejercicioDies() {
		ArrayList<String> secuencia=ejercicio.determinarNumeroSecuencia(10);
		int suma=secuencia.get(5).charAt(0)+secuencia.get(5).charAt(1);
		Assert.assertEquals(suma,5);
	}
	
	/**
	 * 
	 * Metodo encargado de probar el metodo retornarAnio que devuelve la suma de un año a una fecha
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void ejercicioCuatro() {
		;
		Assert.assertEquals(ejercicio.retornarAnio("1994-12-05", 25), 2019);
	}
}
