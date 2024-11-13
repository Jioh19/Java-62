package com.edutecno;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		//Para numeros enteros
		Integer numeroEntero = 123456;
		//Para numeros de punto flotante
		Double numeroFlotante = 123.456;
		//Para texto
		String texto = "Hola como estas";

		//Imprimir en pantalla
		System.out.println("Hola mundo " + texto);
		
		//Leer, escanear, inicializacion
		Scanner sc = new Scanner(System.in);
		//leer 1 linea
		String linea = sc.nextLine();
		//leer una palabra
		String palabra = sc.next();
		//leer un entero
		Integer entero = sc.nextInt();
		
		//Imprimir en pantalla
		System.out.println("La linea es " + linea);
		
		 
		
	}

}
