package com.edutecno.model;

public class Product {
	private String nombre;
	private int idProduccto;
	private String condicion;
	private String tipo;
	
	public Product crearAviso(String nombre, int idProdcuto, String condicion, String tipo) {
		Product product = new Product();
		product.setNombre(nombre);
		product.setIdProduccto(idProdcuto);
		product.setCondicion(condicion);
		product.setTipo(tipo);
		return product;
	}
	
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public int getIdProduccto() {
		return idProduccto;
	}
	public void setIdProduccto(int idProduccto) {
		this.idProduccto = idProduccto;
	}
	public String getCondicion() {
		return condicion;
	}
	public void setCondicion(String condicion) {
		this.condicion = condicion;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
}
