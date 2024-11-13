package com.edutecno;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Main {
	public static void main(String[] args) {
		Set<Curso> cursos = new HashSet<Curso>();
		Set<Alumno> alumnos = new HashSet<>();
		List<Alumno> listaAlumnos = new ArrayList<>();
		cursos.add(new Curso("Calculo I"));
		cursos.add(new Curso("Geometría"));
		
		//Procedemos a usar un set para verificar si el alumno esta repetido antes de 
		//agregar a este a la lista de alumnos
		Alumno alumno = new Alumno("Juan", "Oh", "123456");
		if(alumnos.add(alumno)) {
			listaAlumnos.add(alumno);
		}
		alumno = new Alumno("Marcelo", "Toro", "987654");
		if(alumnos.add(alumno)) {
			listaAlumnos.add(alumno);
		}
		alumno = new Alumno("Sebastian", "Sandoval", "564123");
		if(alumnos.add(alumno)) {
			listaAlumnos.add(alumno);
		}
		alumno = new Alumno("Sebastian", "Sandoval", "564123");
		if(alumnos.add(alumno)) {
			listaAlumnos.add(alumno);
		}
		alumno = new Alumno("Fernando", "Donoso", "151021");
		if(alumnos.add(alumno)) {
			listaAlumnos.add(alumno);
		}
		alumno = new Alumno("Nicolas", "Alvarado", "478411");
		if(alumnos.add(alumno)) {
			listaAlumnos.add(alumno);
		}
		alumno = new Alumno("Rodolfo", "Descazeaux", "1234567");
		
		//No se pueden hacer un simple en el caso de usar un SET. Se debe iterar
		//hasta encontrar la instancia requerida.
		Curso calculo = null;
		Curso geometria = null;
		for(Curso curso : cursos) {
			if(curso.getNombre().equals("Calculo I")) {
				calculo = curso;
			}
			if(curso.getNombre().equals("Geometría")) {
				geometria = curso;
			}
		}
		
		//Verificamos si algun curso no fue encontrado
		if(calculo == null || geometria == null) {
			return;
		}
		
		//Ingresamos a los alumnos de manera alternada a los cursos de calculo y geometria
		int index = 0;
		for(Alumno alum: alumnos) {
			if(index %2 == 0) {
				calculo.addAlumno(alum);
			} else {
				geometria.addAlumno(alum);
			}
			index++;
		}
		System.out.println("Alumnos en calculo " + calculo.getAlumnos());
		System.out.println("Alumnos en geometria " + calculo.getAlumnos());
		//System.out.println(alumnos);	
		System.out.println(listaAlumnos);
	}
}
