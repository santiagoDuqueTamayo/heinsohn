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
	 * Metodo encargado de probar el metodo retornarAnio que devuelve la suma de un año a una fecha
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void ejercicioCuatro() {
		//retorna true si equivale a  2019
		Assert.assertEquals(ejercicio.retornarAnio("1994-12-05", 25), true);
	}
	/**
	 * 
	 * Metodo encargado de probar el ordenamiento de un arreglo 50,1,249,-2
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void ejercicioCinco() {
		int[] arreglo=ejercicio.ordenarArreglo();
		Assert.assertEquals(arreglo[3], -2);
		Assert.assertEquals(arreglo[0], 249);
		Assert.assertEquals(arreglo.length, 4);
		
	}
	/**
	 * 
	 * Metodo encargado de probar metodo ganador partido ejecuta comandos para ingresar jugadores
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void ejercicioSiete(){
	
		Assert.assertEquals(ejercicio.determinarGanadorPartido("Federer", "Dominic"), "Federer");
	}
	/**
	 * 
	 * Metodo encargado de probar el metodo generar devueltas
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void ejercicioOcho() {
		//para 5500
		Integer [] probarDevueltaUno= {5,1,0,0,1};
		Integer[] devueltasGeneradasUno=ejercicio.generarDevueltas(5550);
		Assert.assertEquals(probarDevueltaUno,devueltasGeneradasUno);
		//para 1000
		Integer [] probarDevueltaDos= {1,0,0,0,0};
		Integer[] devueltasGeneradasDos=ejercicio.generarDevueltas(1000);
		Assert.assertEquals(probarDevueltaDos,devueltasGeneradasDos);
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
	
	
}
