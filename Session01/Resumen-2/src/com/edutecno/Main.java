package com.edutecno;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		String textBlock = """
				Hola como estas
				este es un text block
				sirve para literalmente meter parrafos.
				""";
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la altura del rectangulo");
		int altura = sc.nextInt();
		System.out.println("Ingrese la base del rectangulo");
		int base = sc.nextInt();
		rectangulo(base, altura);
		
		System.out.println("Ingrese el radio del círculo");
		int radio = sc.nextInt();
		circulo(radio);
		
		System.out.println("El área del triángulo es: " + 
		areaTriangulo(Math.random()*10, Math.random()*10) + " metros cuadrados");
		
		sc.close();
	}
	
	public static void rectangulo(int base, int altura) {
		int perimetro = 2*(altura + base);
		int area = base*altura;
		System.out.println("El área del rectangulo es: " + area +" metros cuadrados");
		System.out.printf("El perímetro del rectangulo es: %d metros\n", perimetro);
	}
	
	public static void circulo(int radio) {
		Double areaC = radio*radio*Math.PI;
		double perimetroC = Math.PI*radio*2;
		System.out.println("El área del círculo es: " + areaC + " metros cuadrados");
		System.out.printf("El perímetro del círculo es: %.2f metros\n", perimetroC);
	}
	
	public static double areaTriangulo(double base, double altura) {
		double area = base * altura / 2;
		return area;
	}
	
}
