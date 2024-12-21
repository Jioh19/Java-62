package com.edutecno.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.cursos.model.Alumno;

@Repository
public interface AlumnoRepository extends JpaRepository<Alumno, Integer>{

}
