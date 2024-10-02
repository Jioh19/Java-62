package com.edutecno;

public class Circulo extends Figura{

	private double radio;
	
	
	public Circulo(double radio) {
		super();
		this.radio = radio;
	}

	@Override
	public double calcularPerimetro() {
		return Math.PI * 2 * radio;
	}

	@Override
	public double calcularArea() {
		return Math.PI * radio * radio;
	}

}
