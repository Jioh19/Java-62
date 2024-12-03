package com.edutecno.model;

/*
 * 
 * 
 * 
 * CREATE TABLE categorias(
id_categoria NUMBER GENERATED BY DEFAULT AS IDENTITY,
nombre varchar2(50) NOT NULL,
PRIMARY KEY (id_categoria)
);

CREATE TABLE productos(
id_producto NUMBER GENERATED BY default AS IDENTITY,
nombre varchar(50) NOT NULL, 
id_categoria NUMBER REFERENCES categorias (id_categoria)
);

 */

public class Categoria {
	private int idCategoria;
	private String nombre;
	public Categoria(int idCategoria, String nombre) {
		super();
		this.idCategoria = idCategoria;
		this.nombre = nombre;
	}
	public Categoria() {
		super();
	}
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Categoria [idCategoria=" + idCategoria + ", nombre=" + nombre + "]";
	}
	
	
}
