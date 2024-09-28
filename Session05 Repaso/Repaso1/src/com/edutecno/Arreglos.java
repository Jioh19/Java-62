package com.edutecno;

public class Arreglos {
	public static void main(String[] args) {
		Integer[] numeros;
		Integer numeros2[] = {45, 123, 45, 45, 12};
		numeros = new Integer[10];
		
		numeros[0] = 10;
		numeros[1] = 15;
		
		for(int i = 0; i < numeros.length; i++) {
			System.out.println(numeros[i]);	
		}
		
		for(Integer num: numeros2) {
			System.out.println(num);
		}
	}
}
