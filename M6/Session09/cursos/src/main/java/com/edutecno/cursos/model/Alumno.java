package com.edutecno.cursos.model;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Alumno {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nombre;
	private String email;
	
	@ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinTable(
			name = "alumno_curso",
			joinColumns = @JoinColumn( name = "alumno_id"),
			inverseJoinColumns = @JoinColumn(name = "curso_id")
			)
	private Set<Curso> cursos = new HashSet<>();
	
	// Métodos Helper para manejar las relaciones
	public void agregarCurso(Curso curso) {
		this.cursos.add(curso);
		curso.getAlumnos().add(this);
	}
	
	public void eliminarCurso(Curso curso) {
		this.cursos.remove(curso);
		curso.getAlumnos().remove(this);
	}
}
