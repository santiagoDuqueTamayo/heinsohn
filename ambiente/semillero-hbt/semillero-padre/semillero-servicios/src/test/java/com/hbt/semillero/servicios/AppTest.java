package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.EstadoEnum;


public class AppTest {

	public final static String INVERTIRCADENA_DATA_PROVIDER = "invertirCadenaDataProvider";
	
	EstadoEnum estadoEnumActivo;
	EstadoEnum estadoEnumInactivo;
	@BeforeTest
	public void beforeTest() {
		estadoEnumActivo=EstadoEnum.ACTIVO;
		estadoEnumInactivo=EstadoEnum.INACTIVO;
	}
	
	 @DataProvider(name= INVERTIRCADENA_DATA_PROVIDER)
	    public static Object[][] invertirCadenaProovedor() {
	        return new Object[][]{
	                new Object[]{"santiago","ogaitnas"},
	                new Object[]{"pedro","hector"},
	                new Object[]{"12345","54321"},
	                new Object[]{12345,"54321"}
	        };
	    }
//	@Test
//	public void primeraPU() {
//		Long resultadoEsperado=150L;
//		Long sumando1=100L;
//		Long sumando2=50L;
//		Long resultado=sumando1+sumando2;
//		Assert.assertEquals(resultado, resultadoEsperado);
//		resultadoEsperado=200L;
//		Assert.assertNotEquals(resultado, resultadoEsperado);
//	}
//	
	private String invertirCadena(String cadena) {

        String cadenaInvertida = "";

        for (int x = cadena.length() - 1; x >= 0; x--) {

                      cadenaInvertida = cadenaInvertida + cadena.charAt(x);

        }

        return cadenaInvertida;
		}
	
	@Test (dataProvider = INVERTIRCADENA_DATA_PROVIDER)
	public void invertirCadenaPU(String cadenaEntrante, String cadenaSalida ) {
		Assert.assertEquals(invertirCadena(cadenaEntrante),cadenaSalida);
	}
	//TODO
	/**
	 * Pediente hacer un método que use el método ToString de la entidad COMIC
	 */
	@Test
	public void estadoEnumNombrePU() {
		Assert.assertEquals(estadoEnumActivo.name(), "ACTIVO");
		
	}
	
	@Test
	public void estadoEnumPosicionPU(){
		Assert.assertEquals(estadoEnumActivo.ordinal(), 0);
	}
	//TODO Averiguar por qué bota -1
	@Test
	public void estadoEnumComprarPosicionPU(){
		Assert.assertEquals(estadoEnumActivo.compareTo(estadoEnumInactivo), -1);
	}
}
