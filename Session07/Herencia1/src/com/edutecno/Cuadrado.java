package com.edutecno;

public class Cuadrado {
	protected int lado;

	public Cuadrado(int lado) {
		super();
		this.lado = lado;
	}
	
	public int calcularPerimetro() {
		return lado * 4; 
	}
	
	public int calcularArea() {
		return lado * lado;
	}

	@Override
	public String toString() {
		return "Cuadrado [lado=" + lado + "]";
	}
	
	
}
