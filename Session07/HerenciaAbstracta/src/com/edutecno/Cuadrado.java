package com.edutecno;

public class Cuadrado extends Figura{
	private double lado;
	
	public Cuadrado(double lado) {
		super();
		this.lado = lado;
	}

	@Override
	public double calcularPerimetro() {
		return lado * 4;
	}

	@Override
	public double calcularArea() {
		return lado * lado;
	}

}
