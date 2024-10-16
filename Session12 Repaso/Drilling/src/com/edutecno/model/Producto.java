package com.edutecno.model;

public class Producto {
	
	private String nombre;
	private String codigo;
	private int precio;
	
	public Producto(String nombre, String codigo, int precio) {
		super();
		this.nombre = nombre;
		this.codigo = codigo;
		this.precio = precio;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getCodigo() {
		return codigo;
	}
	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Producto " + nombre + " " + codigo + " $" + precio;
	}
	
	
}
