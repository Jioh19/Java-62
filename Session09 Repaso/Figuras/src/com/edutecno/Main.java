package com.edutecno;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Figuras circ = new Circulo("Circulo", 1);
		Figuras tri = new Triangulo("Punta", 2, 2);
		Figuras rectLargo = new Rectangulo("Largo", 6, 2);
		Figuras cuad = new Rectangulo("Chimenea", 2, 2);
		
		Figuras[] figuras = {circ, circ, tri, rectLargo, cuad};
		Figuras tren = new FiguraCompuesta("Tren", figuras);
		System.out.println(tren);
	}

}
