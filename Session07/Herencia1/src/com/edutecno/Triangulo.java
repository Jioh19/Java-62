package com.edutecno;

public class Triangulo extends Rectangulo{

	public Triangulo(int lado, int alto) {
		super(lado, alto);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int calcularPerimetro() {
		// TODO Auto-generated method stub
		return super.calcularPerimetro();
	}

	@Override
	public int calcularArea() {
		return lado * alto / 2;
	}
	
	

}
