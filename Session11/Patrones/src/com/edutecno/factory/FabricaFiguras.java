package com.edutecno.factory;

//Clase fábrica. Es la encargada de crear objetos a partir de los parámetros ingresados
public class FabricaFiguras {
	public static Figura crearFigura(int lados) {
	
		switch(lados) {
		case 3:
			return new Triangulo();
		case 4:
			return new Cuadrado();
		case 5: 
			return new Pentagono();
		default:
			System.out.println("Ingrese un valor válido");
		}
		return null;
	}
}
