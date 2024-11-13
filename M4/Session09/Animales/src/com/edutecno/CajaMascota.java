package com.edutecno;

public class CajaMascota<T> {
	private T mascota;

	public T getMascota() {
		return mascota;
	}

	public void setMascota(T mascota) {
		this.mascota = mascota;
	}

	@Override
	public String toString() {
		return "CajaMascota [mascota=" + mascota + "]";
	}
	
	
}
