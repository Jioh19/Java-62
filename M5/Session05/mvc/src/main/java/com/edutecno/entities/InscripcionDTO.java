package com.edutecno.entities;

public class InscripcionDTO {
	private int idInscripcion;
	private String nombre;
	private String telefono;
	private int idCurso;
	private int idFormaPago;
	public InscripcionDTO(int idInscripcion, String nombre, String telefono, int idCurso, int idFormaPago) {
		super();
		this.idInscripcion = idInscripcion;
		this.nombre = nombre;
		this.telefono = telefono;
		this.idCurso = idCurso;
		this.idFormaPago = idFormaPago;
	}
	public InscripcionDTO() {
		super();
	}
	public int getIdInscripcion() {
		return idInscripcion;
	}
	public void setIdInscripcion(int idInscripcion) {
		this.idInscripcion = idInscripcion;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public int getIdCurso() {
		return idCurso;
	}
	public void setIdCurso(int idCurso) {
		this.idCurso = idCurso;
	}
	public int getIdFormaPago() {
		return idFormaPago;
	}
	public void setIdFormaPago(int idFormaPago) {
		this.idFormaPago = idFormaPago;
	}
	@Override
	public String toString() {
		return "Inscripcion [idInscripcion=" + idInscripcion + ", nombre=" + nombre + ", telefono=" + telefono
				+ ", idCurso=" + idCurso + ", idFormaPago=" + idFormaPago + "]";
	}
	
	
}
