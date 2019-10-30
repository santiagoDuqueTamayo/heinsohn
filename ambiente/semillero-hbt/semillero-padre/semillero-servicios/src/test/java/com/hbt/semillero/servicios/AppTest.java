package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.hbt.semillero.entidades.EstadoEnum;


public class AppTest {

	public final static String INVERTIRCADENA_DATA_PROVIDER = "invertirCadenaDataProvider";
	/*
	 * declaración de atributo que representa el estado activo
	 */
	EstadoEnum estadoEnumActivo;
	/*
	 * declaración de atributo que representa el estado inactivo
	 */
	EstadoEnum estadoEnumInactivo;
	
	/*
	 * Método que permite inicializar los atributos, para reutilizarlos en toda
	 * la clase
	 */
	@BeforeTest
	public void beforeTest() {
		estadoEnumActivo=EstadoEnum.ACTIVO;
		estadoEnumInactivo=EstadoEnum.INACTIVO;
	
	}
	
	/*
	 * Metodo que permite crear un arreglo de objetos para automatizar
	 * las pruebas
	 */
	
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
	 /**
	  * 
	  * Metodo encargado de invertir una cadena
	  * <b>Caso de Uso</b>
	  * @author santi
	  * 
	  * @param cadena
	  * @return String invertido
	  */
	private String invertirCadena(String cadena) {

        String cadenaInvertida = "";

        for (int x = cadena.length() - 1; x >= 0; x--) {

                      cadenaInvertida = cadenaInvertida + cadena.charAt(x);

        }

        return cadenaInvertida;
		}
	/**
	 * 
	 * Metodo encargado de validar el metodo invertirCadena
	 * <b>Caso de Uso</b>
	 * @author santi
	 * 
	 * @param cadenaEntrante tomado del dataProvider
	 * @param cadenaSalida tomado del dataProvider
	 */
	@Test (dataProvider = INVERTIRCADENA_DATA_PROVIDER)
	public void invertirCadenaPU(String cadenaEntrante, String cadenaSalida ) {
		Assert.assertEquals(invertirCadena(cadenaEntrante),cadenaSalida);
	}
	//TODO
	/**
	 * Pediente hacer un método que use el método ToString de la entidad COMIC
	 */
	/**
	 * 
	 * Metodo encargado de  probar el metodo name de la clase enum
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void estadoEnumNombrePU() {
		Assert.assertEquals(estadoEnumActivo.name(), "ACTIVO");
		
	}
	
	/**
	 * 
	 * Metodo encargado de  probar el metodo ordinar de la clase enum
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void estadoEnumPosicionPU(){
		Assert.assertEquals(estadoEnumActivo.ordinal(), 0);
	}
	//TODO Averiguar por qué bota -1
	
	/**
	 * 
	 * Metodo encargado de  probar el metodo compareTo de la clase enum
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test
	public void estadoEnumComprarPosicionPU(){
		Assert.assertEquals(estadoEnumActivo.compareTo(estadoEnumInactivo), -1);
	}
	
	/**
	 * 
	 * Metodo encargado de  probar el metodo enum.values de la clase enum
	 * <b>Caso de Uso</b>
	 * @author santi
	 *
	 */
	@Test 
	public void estadoEnumArrayPU(){
		
		Assert.assertEquals(EstadoEnum.values(),"ACTIVO");
		Assert.assertEquals(EstadoEnum.values(),"INACTIVO");
	}
}
