package com.edutecno;

import java.util.Arrays;
import java.util.Scanner;

public class Arreglo {

	public static void main(String[] args) {
		int[] arregloInts = {24, 13, 17, 21, 69}; //Me gusta mas este
//		int numero = null;
		
//		System.out.println(numero);
		int arregloInts2[];
		arregloInts2 = new int[10];
		
		
//		Scanner scanner = new Scanner(System.in);
//		System.out.println("Ingrese el largo del arreglo");
//		int largo = scanner.nextInt();
//		int[] arregloInts4 = new int[largo];
//		System.out.println("El largo del arreglo es " + arregloInts4.length);
		
		int[] arregloInts3;
		arregloInts3 = new int[] {123, 13, 17, 21, 34};
		cambiar(arregloInts3);
		Arrays.sort(arregloInts3);
		System.out.println(Arrays.toString(arregloInts3));
		
		int numero = 5;
		numero = cambiarInt(numero);
		System.out.println("El numero vale " + numero);
 	}

	public static void cambiar(int[] arr) {
		arr[0] = 420;
	}
	
	public static int cambiarInt(int num) {
		num = 100;
		return num;
	}
}