package com.edutecno.cursos.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.cursos.model.Curso;

@Repository
public interface CursoRepository extends JpaRepository<Curso, Integer>{

}
