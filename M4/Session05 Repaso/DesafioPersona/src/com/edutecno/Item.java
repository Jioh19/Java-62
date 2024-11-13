package com.edutecno;

public class Item {
	private String nombre;
	private double peso;
	private double volumen;

	public Item(String nombre, double peso, double volumen) {
		super();
		this.nombre = nombre;
		this.peso = peso;
		this.volumen = volumen;
	}

	public String getNombre() {
		return nombre;
	}

	public double getPeso() {
		return peso;
	}

	public double getVolumen() {
		return volumen;
	}

	@Override
	public String toString() {
		return "\nItem [nombre=" + nombre + ", peso=" + peso + ", volumen=" + volumen + "]";
	}

	
}
