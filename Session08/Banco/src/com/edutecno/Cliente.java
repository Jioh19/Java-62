package com.edutecno;

import java.util.Arrays;

public class Cliente {
	private String nombre;
	private String rut;
	private Cuenta[] cuentas;
	
	public Cliente(String nombre, String rut) {
		super();
		this.nombre = nombre;
		this.rut = rut;
		this.cuentas = new Cuenta[5];
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
	
	public Cuenta[] getCuentas() {
		return cuentas;
	}
	public void setCuentas(Cuenta[] cuentas) {
		this.cuentas = cuentas;
	}
	
	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", rut=" + rut + "\ncuentas=" + Arrays.toString(cuentas) + "]";
	}
}
