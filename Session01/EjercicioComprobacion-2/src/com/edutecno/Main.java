package com.edutecno;

import java.util.Scanner;

public class Main {
	


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Ingrese la altura del rectangulo");
		int altura = sc.nextInt();
		System.out.println("Ingrese la base del rectangulo");
		int base = sc.nextInt();
		int perimetro = 2*(altura + base);
		int area = base*altura;
		System.out.println("El área del rectangulo es: " + area +" metros cuadrados");
		System.out.printf("El perímetro del rectangulo es: %d metros\n", perimetro);
		
		System.out.println("Ingrese el radio del círculo");
		int radio = sc.nextInt();
		Double areaC = radio*radio*Math.PI;
		double perimetroC = Math.PI*radio*2;
		System.out.println("El área del círculo es: " + areaC + " metros cuadrados");
		System.out.printf("El perímetro del círculo es: %.2f metros\n", perimetroC);
		
		System.out.println("El área del triángulo es: " + 
		areaTriangulo(Math.random()*10, Math.random()*10) + " metros cuadrados");
	}
	
	public static double areaTriangulo(double base, double altura) {
		double area = base * altura / 2;
		return area;
	}

}
