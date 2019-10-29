package com.hbt.semillero.servicios;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;


public class AppTest {

	public final static String INVERTIRCADENA_DATA_PROVIDER = "invertirCadenaDataProvider";
	public void shouldAnswerWithTrue() {

	}
	
	 @DataProvider(name= INVERTIRCADENA_DATA_PROVIDER)
	    public static Object[][] invertirCadenaProovedor() {
	        return new Object[][]{
	                new Object[]{"santiago","ogaitnas" },
	                new Object[]{"pedro", "carlos"},
	                new Object[]{12345, "54321"}
	        };
	    }
	@Test
	public void primeraPU() {
		Long resultadoEsperado=150L;
		Long sumando1=100L;
		Long sumando2=50L;
		Long resultado=sumando1+sumando2;
		Assert.assertEquals(resultado, resultadoEsperado);
		resultadoEsperado=200L;
		Assert.assertNotEquals(resultado, resultadoEsperado);
	}
	
	private String invertirCadena(String cadena) {

        String cadenaInvertida = "";

        for (int x = cadena.length() - 1; x >= 0; x--) {

                      cadenaInvertida = cadenaInvertida + cadena.charAt(x);

        }

        return cadenaInvertida;
		}
	
	@Test (dataProvider = INVERTIRCADENA_DATA_PROVIDER)
	public void invertirCadenaPU(String cadena) {
		Assert.assertEquals(cadena, invertirCadena(cadena));
	}
}
