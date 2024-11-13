package com.edutecno;

public class Persona implements Comparable<Persona>{
	private String nombre;
	private String apellido;
	private int edad;
	private String rut;
	public Persona(String nombre, String apellido, int edad, String rut) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.edad = edad;
		this.rut = rut;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public int getEdad() {
		return edad;
	}
	public String getRut() {
		return rut;
	}
	@Override
	public String toString() {
		return "Persona [nombre=" + nombre + ", apellido=" + apellido + ", edad=" + edad + ", rut=" + rut + "]";
	}
	@Override
	public int compareTo(Persona o) {
		if(this.apellido.compareTo(o.getApellido()) == 0) {
			return this.nombre.compareTo(o.getNombre());
		}
		return this.apellido.compareTo(o.getApellido());
	}
	
	
}
