package com.edutecno;

public class Fruta {
	private String nombre;
	private double peso;
	public Madurez madurez;
	public Fruta(String nombre, double peso) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.madurez = Madurez.INMADURA;
	}
	@Override
	public String toString() {
		return "Fruta [nombre=" + nombre + ", peso=" + peso + ", madurez=" + madurez + "]";
	}
	
	
}

