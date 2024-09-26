package com.edutecno;

public class Auto {
	private String marca;
	private String modelo; 
	private String color;
	private double velocidadMaxima;
	private boolean encendido;
	public Auto(String marca, String modelo, String color, double velocidadMaxima) {
		super();
		this.marca = marca;
		this.modelo = modelo;
		this.color = color;
		this.velocidadMaxima = velocidadMaxima;
		this.encendido = false;
	}
	
	public boolean encender() {
		if(encendido) {
			System.out.println("No se puede volver a encender");
			return false;
		} else {
			encendido = true;
			return true;
		}
	}
	
	public boolean apagar() {
		if(encendido) {
			encendido = false;
			return true;
		} else {
			System.out.println("El auto ya esta apagado");
			return false;
		}
	}
	
	public boolean acelerar() {
		if(encendido) {
			System.out.println("Broom broom!");
			return true;
		} else {
			return false;
		}
	}

	@Override
	public String toString() {
		return "Auto [marca=" + marca + ", modelo=" + modelo + ", color=" + color + ", velocidadMaxima="
				+ velocidadMaxima + ", encendido=" + encendido + "]";
	}
 	
	
}
