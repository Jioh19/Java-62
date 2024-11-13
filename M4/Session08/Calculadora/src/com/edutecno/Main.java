package com.edutecno;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Calculadora calcu = new Calculadora();
		Calculadora calcuChina = new CalculadoraChina();
		Scanner lector = new Scanner(System.in);
		System.out.println("Ingrese el primer numero");
		double num1 = lector.nextDouble();
		System.out.println("Ingrese el segundo numero");
		double num2 = lector.nextDouble();
		double resultado = calcu.sumar(num1, num2);
		System.out.println("El resultado es de " + resultado);
		lector.close();
		
		System.out.println("La trisuma es de : " + calcu.sumar(123.5, 45.54 ,45.4));
		int[] arr = {456465, 4,465,1 ,15456,465,465 ,132};
		
		System.out.println("La suma del arreglo es de: " + calcu.sumar(54,543,543,654,654,532,432));
		System.out.println("La suma del arreglo es de: " + calcuChina.sumar(54,543,543,654,654,532,432));
	}
}
