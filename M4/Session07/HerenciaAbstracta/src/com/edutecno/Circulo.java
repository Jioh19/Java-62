package com.edutecno;

public class Circulo extends Figura implements Variable{

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

	@Override
	public void modificar(double porcentaje) {
		radio *= porcentaje;
		
	}

}
