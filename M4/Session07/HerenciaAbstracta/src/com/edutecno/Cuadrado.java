package com.edutecno;

public class Cuadrado extends Figura implements Variable{
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

	@Override
	public void modificar(double porcentaje) {
		lado *= porcentaje; // 1 = 100%
	}

}
