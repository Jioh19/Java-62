package com.edutecno;

public class Cliente {
	private String nombre;
	private String rut;
	public Cliente(String nombre, String rut) {
		super();
		this.nombre = nombre;
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getRut() {
		return rut;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	@Override
	public String toString() {
		return "\nCliente [nombre=" + nombre + ", rut=" + rut + "]\n";
	}
	
	
}
