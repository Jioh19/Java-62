package com.edutecno.modelos;

public class Producto {
	private String codigo;
	private String nombre;
	private Categoria categoria;
	private Talla talla;
	private double precio;
	private int stock;

	public Producto() {
		super();
	}

	public Producto(String codigo, String nombre, Categoria categoria, Talla talla, double precio, int stock) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.categoria = categoria;
		this.talla = talla;
		this.precio = precio;
		this.stock = stock;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public Talla getTalla() {
		return talla;
	}

	public void setTalla(Talla talla) {
		this.talla = talla;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return "codigo=" + codigo + ", nombre=" + nombre + ", categoria=" + categoria + ", talla=" + talla + ", precio="
				+ precio + ", stock=" + stock;
	}

}
