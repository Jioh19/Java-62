package com.edutecno;

public class Triangulo implements Figuras{
	private String nombre;
	private double lado;
	private double alto;
	
	
	public Triangulo(String nombre, double lado, double alto) {
		super();
		this.nombre = nombre;
		this.lado = lado;
		this.alto = alto;
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return lado*alto/2;
	}

	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}

	@Override
	public String toString() {
		return "Triangulo [getArea()=" + getArea() + ", getNombre()=" + getNombre() + "]";
	}

	
}
