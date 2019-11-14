package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.Scanner;

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
	/**
	 * metodo que permite validar fecha de nacimiento
	 */
	public static int validarFecha(LocalDate fechaNacimiento) {
		return fechaNacimiento.getYear();
	}
	
	/**
	 * metodo que permite ingresar elementos
	 */
	public static  int[] registrarElementos() {
		Scanner leerDato= new Scanner(System.in);
		int[] arregloDatos= new int[4];
		for (int i = 0; i < arregloDatos.length; i++) {
			System.out.println("ingrese el numero de la posicion"+i);
			arregloDatos[i]=leerDato.nextInt();
		}
		return arregloDatos;
	}
	
	/**
	 * metodo que permite ordenar arreglo menor a mayor mediante burbuja
	 */
	public void ordenarArreglo(){
		int [] arreglo=registrarElementos();
		

	    for (int i = 0; i < arreglo.length; i++) {
	        for (int j = 0; j < arreglo.length-i-1; j++) {
	            if(arreglo[j] < arreglo[j+1]){
	                int temporal = arreglo[j+1];
	                arreglo[j+1] = arreglo[j];
	                arreglo[j] = temporal;
	            }
	        }
	    }
	}
}
