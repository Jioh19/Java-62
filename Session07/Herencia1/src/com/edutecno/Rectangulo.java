package com.edutecno;

public class Rectangulo extends Cuadrado{
	protected int alto;

	public Rectangulo(int lado, int alto) {
		super(lado);
		this.alto = alto;
	}

	@Override
	public int calcularPerimetro() {
		
		return lado * 2 + alto * 2;
	}

	@Override
	public int calcularArea() {
		return lado * alto;
	}

	@Override
	public String toString() {
		return "Rectangulo [alto=" + alto + ", lado=" + lado + "]";
	}

	
	
	
	

}
