package com.edutecno.gutenDex.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edutecno.gutenDex.model.Autor;

public interface AutorRepository extends JpaRepository<Autor, String>{
	
	
	Autor findByName(String name);
}
