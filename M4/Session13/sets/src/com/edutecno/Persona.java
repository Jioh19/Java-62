package com.edutecno;

import java.util.Objects;

public class Persona {
	private String nombre;
	private String apellido;
	private String rut;
	public Persona(String nombre, String apellido, String rut) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
	}
	@Override
	public String toString() {
		return "\nPersona [nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + "]";
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
		Persona other = (Persona) obj;
		return Objects.equals(rut, other.rut);
	}
	
	//El override tanto de hashcode como de equals son necesarios para poder 
	//comparar exitosamente dos instancias distintas de dos objetos
//	@Override
//	public int hashCode() {
//		return Objects.hash(apellido, nombre, rut);
//	}
//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		Persona other = (Persona) obj;
//		return Objects.equals(apellido, other.apellido) && Objects.equals(nombre, other.nombre)
//				&& Objects.equals(rut, other.rut);
//	}
	
	
}
