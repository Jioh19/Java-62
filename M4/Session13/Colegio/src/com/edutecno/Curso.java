package com.edutecno;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Curso {
	private String nombre;
	private Set<Alumno> alumnos;
	public Curso(String nombre) {
		super();
		this.nombre = nombre;
		this.alumnos = new HashSet<>();
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public Set<Alumno> getAlumnos() {
		return alumnos;
	}
	public void addAlumno(Alumno alumno) {
		this.alumnos.add(alumno);
	}
	
	
	
	
}
