package com.edutecno.modelo;

public class Departamento {
	private int numDepto;
	private String nombreDepto;
	private String ubicacionDepto;

	public Departamento(int numDepto, String nombreDepto, String ubicacionDepto) {
		super();
		this.numDepto = numDepto;
		this.nombreDepto = nombreDepto;
		this.ubicacionDepto = ubicacionDepto;
	}

	public Departamento() {
		super();
	}

	public int getNumDepto() {
		return numDepto;
	}

	public void setNumDepto(int numDepto) {
		this.numDepto = numDepto;
	}

	public String getNombreDepto() {
		return nombreDepto;
	}

	public void setNombreDepto(String nombreDepto) {
		this.nombreDepto = nombreDepto;
	}

	public String getUbicacionDepto() {
		return ubicacionDepto;
	}

	public void setUbicacionDepto(String ubicacionDepto) {
		this.ubicacionDepto = ubicacionDepto;
	}

	@Override
	public String toString() {
		return "Departamento [numDepto=" + numDepto + ", nombreDepto=" + nombreDepto + ", ubicacionDepto="
				+ ubicacionDepto + "]";
	}
	
	

}
