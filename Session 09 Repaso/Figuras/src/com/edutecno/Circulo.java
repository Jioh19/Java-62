package com.edutecno;

public class Circulo implements Figuras{
	private String nombre;
	private double radio;
	public Circulo(String nombre, double radio) {
		super();
		this.nombre = nombre;
		this.radio = radio;
	}
	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return Math.PI * radio * radio;
	}
	@Override
	public String getNombre() {
		// TODO Auto-generated method stub
		return nombre;
	}
	@Override
	public String toString() {
		return "Circulo [getArea()=" + getArea() + ", getNombre()=" + getNombre() + "]";
	}
	
	
	
}
