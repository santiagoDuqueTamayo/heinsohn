package com.hbt.semillero.pojo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class EjerciciosPojo {

	/**
	 * metodo que nos permite saber si un número ingresado es primo
	 * tiempo de desarrollo 7 minutos
	 * @return
	 */
	public static  boolean esPrimo(Integer numero){
		if (numero%2==0&&numero!=0) {
			return true;
		}
		return false;
	}
	
	/**
	 * metodo que me permite establecer si al sumar un numero a una fecha coincide 
	 * con el año actual.
	 * Tiempo para realizar el ejercicio 15 minutos
	 * @param fecha
	 * @param añosSumar
	 * @return
	 */
	public static boolean retornarAnio(String fecha, Integer añosSumar){
		LocalDate fechaConvertida = LocalDate.parse(fecha);
		LocalDate nuevaFecha = fechaConvertida.plusYears(añosSumar);
		Integer añoActual=LocalDate.now().getYear();
		if (nuevaFecha.getYear()==añoActual) {
			return true;
		}
		return false;
	}
	/**
	 * metodo que permite gestionar las devueltas de una maquina de dulces
	 * tiempo de desarrollo 27 minutos
	 * @param devuelta
	 * @return
	 */
	public static Integer[] generarDevueltas(Integer devuelta){
		Integer[] monedas={1000,500,200,100,50};
		Integer[] cantidadMonedas={0,0,0,0,0};
		int i=0;
		Integer cantidadPorMoneda;
		while(devuelta!=0){
			cantidadPorMoneda=devuelta/monedas[i];
			cantidadMonedas[i]=cantidadPorMoneda;
			devuelta-=(monedas[i]*cantidadPorMoneda);
			i++;
		}
		return cantidadMonedas;
	}
	
	/**
	 * Estructura de la excepcion con throw
	 * @throws Exception
	 */
	public void ohNo()throws Exception{
		
		throw new Exception();
	}
	/**
	 * metodo que me permite encontrar secuencia donde cada item represente
	 * la suma de cada valor eje: 10,11-->secuencia 1,2
	 * tiempo de desarrollo 35 minutos
	 * @param tamanoSecuencia
	 * @return
	 */
	public static ArrayList<String> determinarNumeroSecuencia(int tamanoSecuencia){
		
		ArrayList<String> secuencia=new ArrayList<String>();
		secuencia.add("10");
		for (int i = 2; i < tamanoSecuencia; i++) {
			secuencia.add(encontrarSumaNumero(i));
		}
		return secuencia;
	}
	/**
	 * metodo encargado de determinar que numero cumple la condicion de la suma
	 * @param numero
	 * @return
	 */
	public static String encontrarSumaNumero(int numero){
		int numeroUno=0,numeroDos=0;
		String numeroString="";
		Boolean continuarCiclo=true;
		while(continuarCiclo){
			numeroUno=(int)(Math.random()*10);
			numeroDos=(int)(Math.random()*10);
			if ((numeroUno+numeroDos)==numero) {
				continuarCiclo=false;
				numeroString+=""+numeroUno+""+numeroDos;

			}
		}
		return numeroString;
	}
	
	/**
	 * metodo que permite registrar los elementos para probar arreglo
	 * tiempo de desarrollo 18 minutos
	 * @return
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
	public static int[] ordenarArreglo(){
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
	    return arreglo;
	}
	/**
	 * metodo que permite determinar el ganador deun partido de tennis
	 * tiempo de desarrollo 40 minutos
	 * @param jugadorUno
	 * @param jugadorDos
	 * @return
	 */
	public static String determinarGanadorPartido(String jugadorUno, String jugadorDos){
		Scanner leerDatos= new Scanner(System.in);
		Boolean hayGanador=false;
		int conJugUno=0,conJugDos=0;
		int conSets=1;
		Integer resSetJugadorUno=0;
		Integer resSetJugadorDos=0;
		while(!hayGanador){
			System.out.println("Set numero: "+conSets);
			conSets++;
			System.out.println("Ingrese los resultados del jugador " +jugadorUno);
			resSetJugadorUno=leerDatos.nextInt();
			System.out.println("Ingrese los resultados del jugador "+jugadorDos);
			resSetJugadorDos=leerDatos.nextInt();
			System.out.println(determinarGanadorSet(resSetJugadorUno, resSetJugadorDos));
			if (determinarGanadorSet(resSetJugadorUno, resSetJugadorDos).equals(jugadorUno)) {
				conJugUno++;
				if (conJugUno==2&&conJugDos<2) {
					hayGanador=true;
					return jugadorUno;
				}
			}else {
				conJugDos++;
				if (conJugDos==2&&conJugUno<2) {
					hayGanador=true;
					return jugadorUno;
				}
			}
		}
		return null;
	}
	/**
	 * metodo qu permite retornar el jugador ganador deun set
	 */
	public static String determinarGanadorSet(int resUno, int resDos){
		String jugador1="Federer";
		String jugador2= "Dominic";
		if (resUno==6) {
			return jugador1;
		}else {
			return jugador2;
		}
	}
}
