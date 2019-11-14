package com.hbt.semillero.servicios;

import org.testng.Assert;

import com.hbt.semillero.pojo.EjerciciosPOJO;

public class EjeciciosTest {
	private static EjerciciosPOJO ejercicio= new EjerciciosPOJO();
	
	public static void ejercicioTres() {
		//esto es para saber si 5 es primo, poner el numero 
		Assert.assertEquals(ejercicio.determinarPrimo(), true);
		//esto es para saber si 222 es primo poner el numero 
		Assert.assertEquals(ejercicio.determinarPrimo(), true);
		//esto es para saber si 0 es primoponer el numero 
		Assert.assertEquals(ejercicio.determinarPrimo(), true);
		
	}


		
	
	
}
