package com.edutecno.model;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Oh Kim
 * @version 1.01
 * @since 2024-10-25
 */

public class Cliente {
	private String nombre;
	private String apellido;
	private String rut;
	private List<Cuenta> cuentas;
	
	public Cliente(String nombre, String apellido, String rut) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		cuentas = new ArrayList<>();
	}

	/**
	 * 
	 * @return String
	 */
	
	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getRut() {
		return rut;
	}

	public List<Cuenta> getCuentas() {
		return cuentas;
	}

	@Override
	public String toString() {
		return String.format("\nCliente [nombre=%s, apellido=%s, rut=%s, cuentas=%s]", nombre, apellido, rut, cuentas);
	}
	
}
