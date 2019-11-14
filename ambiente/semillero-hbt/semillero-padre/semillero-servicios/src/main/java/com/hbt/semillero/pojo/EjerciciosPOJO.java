package com.hbt.semillero.pojo;

public class EjerciciosPOJO {
	
	/**
	 * 	 * me permite ver si un numero es primo
	 * <b>Caso de Uso</b>
	 * @author santi
	 * 
	 * @param numero
	 * @return
	 */
	public static boolean determinarPrimo(int numero) {
		
			 if (numero%2==0 && numero!=0) {
					return  true;
				}
		
		 return false;
		 
		}
}
