package com.edutecno.cliente;

import java.util.Arrays;

import com.edutecno.cuenta.Cuenta;

public class Cliente {
	private String nombre;
	private String apellido;
	private String rut;
	private Cuenta[] cuentas;
	private Nivel nivel;
	
	
	public Cliente(String nombre, String apellido, String rut, Nivel nivel) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.nivel = nivel;
		this.cuentas = new Cuenta[5];
	}

	public boolean addCuenta(Cuenta newCuenta) {
		for(int i = 0; i < cuentas.length; i++) {
			if(cuentas[i] == null) {
				cuentas[i] = newCuenta;
				return true;
			}
		}
		return false;
	}

	@Override
	public String toString() {
		return "\nCliente [nombre=" + nombre + ", apellido=" + apellido + ", rut=" + rut + 
				"\ncuentas=" + Arrays.toString(cuentas) + ", nivel=" + nivel + "]";
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
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

	public Nivel getNivel() {
		return nivel;
	}

	public void setNivel(Nivel nivel) {
		this.nivel = nivel;
	}
	
	
}
