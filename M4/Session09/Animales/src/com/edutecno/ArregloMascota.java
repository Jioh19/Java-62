package com.edutecno;

import java.util.Arrays;

public class ArregloMascota<T> {
	private T[] mascotas;

	public ArregloMascota() {
		super();
		this.mascotas = (T[]) new Object[10];
	}

	public T[] getMascotas() {
		return mascotas;
	}

	public void setMascotas(T[] mascotas) {
		this.mascotas = mascotas;
	}

	@Override
	public String toString() {
		return "ArregloMascota [mascotas=" + Arrays.toString(mascotas) + "]";
	}
	
	
	
}
