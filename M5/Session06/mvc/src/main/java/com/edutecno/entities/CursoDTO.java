package com.edutecno.entities;

public class CursoDTO {
	private int idCurso; //id_curso
	private String descripcion;
	private int precio;
	
	public CursoDTO(int idCurso, String descripcion, int precio) {
		super();
		this.idCurso = idCurso;
		this.descripcion = descripcion;
		this.precio = precio;
	}
	public CursoDTO() {
		super();
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "CursoDTO [idCurso=" + idCurso + ", descripcion=" + descripcion + ", precio=" + precio + "]";
	}
	
	

}
