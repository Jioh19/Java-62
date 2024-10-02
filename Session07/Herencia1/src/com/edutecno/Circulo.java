package com.edutecno;

public class Circulo extends Cuadrado{

	public Circulo(int lado) {
		super(lado);
	}

	@Override
	public int calcularPerimetro() {
		// TODO Auto-generated method stub
		return (int) (2 * Math.PI * lado);
	}

	@Override
	public int calcularArea() {
		// TODO Auto-generated method stub
		return (int) (Math.PI * lado * lado);
	}
	
	
}
