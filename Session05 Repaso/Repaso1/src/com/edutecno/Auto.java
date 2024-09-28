package com.edutecno;

public class Auto {
	private double bateria;
	private double bateriaMetro;
	private double odometro;
	private String nombre;
	
	public Auto(double bateriaMetro, String nombre) {
		super();
		this.bateria = 0;
		this.bateriaMetro = bateriaMetro;
		this.odometro = 0;
		this.nombre = nombre;
	}
	
	public void cargar(double carga) {
		if(carga > 0) {
			bateria += carga;	
			if(bateria > 100) {
				bateria = 100;
			}
		}
	}
	
	public void avanzar(double carga) {
		if(bateria < carga) {
			odometro += bateria * bateriaMetro;
			bateria = 0;
		} else {
			odometro += carga * bateriaMetro;
			bateria -= carga;
		}
	}
	
	public double maxDist() {
		return bateria * bateriaMetro;
	}

	public double getBateria() {
		return bateria;
	}

	public double getBateriaMetro() {
		return bateriaMetro;
	}

	public double getOdometro() {
		return odometro;
	}

	@Override
	public String toString() {
		return "Auto [bateria=" + bateria + ", bateriaMetro=" + bateriaMetro + ", odometro=" + odometro + ", marca=" + nombre + "]";
	}
	
	
}
