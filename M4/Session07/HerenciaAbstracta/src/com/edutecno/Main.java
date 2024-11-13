package com.edutecno;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Figura cuad = new Cuadrado(6);
		Variable cuad = new Cuadrado(6);
		//Figura circ = new Circulo(8);
		Circulo circ = new Circulo(8);
		
		
		cuad.modificar(1.5);
		circ.modificar(1.5);
		
		System.out.println( ((Cuadrado) cuad).calcularPerimetro() + " " + ((Figura) cuad).calcularArea());
		System.out.printf("%.2f %.2f",circ.calcularPerimetro(), circ.calcularArea());
	}

}
