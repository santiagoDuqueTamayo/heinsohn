package com.hbt.semillero.pojo;

public class EjerciciosPOJO {
	
	private static int[] arreglo ={5,222,0};
	public static boolean determinarPrimo(int i) {
		
			 if (arreglo[i]%2==0 && arreglo[i]!=0) {
					return  true;
				}
		
		 return false;
		 
		}
}
