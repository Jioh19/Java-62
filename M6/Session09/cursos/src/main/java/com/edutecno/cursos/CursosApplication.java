package com.edutecno.cursos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.edutecno.cursos.model.Alumno;
import com.edutecno.cursos.model.Curso;
import com.edutecno.cursos.repository.AlumnoRepository;
import com.edutecno.cursos.repository.CursoRepository;

@SpringBootApplication
public class CursosApplication implements ApplicationRunner{

	public static void main(String[] args) {
		SpringApplication.run(CursosApplication.class, args);
	}

	@Autowired
	AlumnoRepository alumnoRepository;
	@Autowired
	CursoRepository cursoRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		Alumno alumno = new Alumno();
		alumno.setNombre("Juan");
		alumno.setEmail("jioh@mail.com");
		
		Curso curso = new Curso();
		curso.setNombre("Java Fullstack");
		curso.setCodigo("JAV123");
		
		alumno.agregarCurso(curso);
		alumnoRepository.save(alumno);
	}

}
