package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.hbt.semillero.pojo.EjerciciosPOJO;

import static org.testng.Assert.assertEquals;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class EjeciciosTest {
	private static EjerciciosPOJO ejercicio= new EjerciciosPOJO();
	@Test
	public  void ejercicioTres() {
		//esto es para saber si 5 es primo, poner el numero 
		Assert.assertEquals(ejercicio.determinarPrimo(5), true);
		//esto es para saber si 222 es primo poner el numero 
		Assert.assertEquals(ejercicio.determinarPrimo(222), true);
		//esto es para saber si 0 es primoponer el numero 
		Assert.assertEquals(ejercicio.determinarPrimo(0), true);
		
	}
	/**
	 * 
	 * Metodo encargado de 
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void EjercicioCuatro() {
		int[] arreglo=ejercicio.registrarElementos();
		Assert.assertEquals(arreglo[0], -2);
		Assert.assertEquals(arreglo[3], 249);
		Assert.assertEquals(arreglo.length, 4);
		
	}
	
	@Test
	public void ejercicioDies() {
		Assert.assertEquals(ejercicio.numeroSecuencia(),46);
	}


	
		
	
	
}
