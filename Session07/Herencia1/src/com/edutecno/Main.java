package com.edutecno;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Cuadrado cuad = new Cuadrado(5);
		Rectangulo rect = new Rectangulo(5, 7);
		Triangulo tri = new Triangulo(10, 8);
		Cuadrado circ = new Circulo(7);
		
		System.out.println("El perímetro del cuadrado es de " + cuad.calcularPerimetro());
		System.out.println("El área del cuadrado es de " + cuad.calcularArea());
		
		System.out.println("El perímetro del rectángulo es de " + rect.calcularPerimetro());
		System.out.println("El área del rectángulo es de " + rect.calcularArea());
		
		System.out.println("El área del triángulo es de " + tri.calcularArea());
		
		System.out.println("El perímetro del círculo es de " + circ.calcularPerimetro());
		System.out.println("El área del círculo es de " + circ.calcularArea());
	}

}
