package com.edutecno;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figura cuad = new Cuadrado(6);
		Figura circ = new Circulo(8);
		
		System.out.println(cuad.calcularPerimetro() + " " + cuad.calcularArea());
		System.out.println(circ.calcularPerimetro() + " " + circ.calcularArea());
	}

}
