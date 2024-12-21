package com.edutecno.relaciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.relaciones.model.Persona;

@Repository
public interface PersonaRepository extends CrudRepository<Persona, Long>{

}
