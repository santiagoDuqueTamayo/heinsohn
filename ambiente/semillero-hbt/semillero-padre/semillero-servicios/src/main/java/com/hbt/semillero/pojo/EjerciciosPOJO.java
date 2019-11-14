package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
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
	
	
	public void determinarGanador() {
		Map<Integer, String> arregloDatos=ingresarResultados ();
		for (int i = 0; i < array.length; i++) {
			
		}
	}
	public static Map<Integer, String> ingresarResultados (){
		Scanner leerDato= new Scanner(System.in);
		String jugador1="federeer";
		String jugador2="dominic";
		Integer resultadoFederer;
		Integer resultadoDominic;
		
		Map<Integer, String> arregloDatos = new HashMap<Integer, String>();
		for (int i = 0; i < 2; i++) {
			System.out.println("marque la opcion del ganador"+"\n"+"1. Gano federer"+"\n"+"2.Gano Dominic");
			if(leerDato.nextInt()==1) {
				System.out.println("ingrese el marcador del ganador");
				arregloDatos.put(leerDato.nextInt(), jugador1);
			}else if(leerDato.nextInt()==2){
				System.out.println("ingrese el marcador del ganador");
				arregloDatos.put(leerDato.nextInt(), jugador2);
			}
			
		}
		return arregloDatos;
	}
	
	/**
	 * metodo que permite validar devueltas de maquina
	 */
	public int[] devolver(Integer devuelta) {
		int monedas[]={1000,500,200,100,50};
		int cantidadMonedas[]={0,0,0,0,0};
		cantidadMonedas[0]=devuelta;
		for(int i=0;i<5;i++){
		    cantidadMonedas[i]=devuelta/monedas[i];
		    while(cantidadMonedas[i]>0 && cantidadMonedas[i]!=devuelta-1){
		        int resultado=devuelta-(monedas[i]*cantidadMonedas[i]);
		        for(int j=0;j<5;j++){
		            if(j>i){
		                cantidadMonedas[j]=resultado/monedas[j];
		                resultado-=monedas[j]*cantidadMonedas[j];
		            }
		            System.out.println(cantidadMonedas[j]+" monedas de "+monedas[j]);
		        }
		  
		        cantidadMonedas[i]--;
		    }
		}
		return cantidadMonedas;
	}
	

	public int numeroSecuencia() {
		String[] arregloNumero= {"23","33","25","80","36"};
		int composicionNumero1=arregloNumero[arregloNumero.length-1].charAt(0);
		int composicionNumero2=arregloNumero[arregloNumero.length-1].charAt(1);
		int resultado=composicionNumero1+composicionNumero2;
		arregloNumero[arregloNumero.length]=resultado+"";
		return resultado;
		
	}
}
