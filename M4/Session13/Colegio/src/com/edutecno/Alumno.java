package com.edutecno;

import java.util.Objects;

public class Alumno {
	private String nombre;
	private String apellido;
	private String rut;
	public Alumno(String nombre, String apellido, String rut) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
	}
	@Override
	public String toString() {
		return "\nAlumno [nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(rut);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Alumno other = (Alumno) obj;
		return Objects.equals(rut, other.rut);
	}
	
}
