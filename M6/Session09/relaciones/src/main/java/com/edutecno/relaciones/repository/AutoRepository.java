package com.edutecno.relaciones.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.edutecno.relaciones.model.Auto;

@Repository
public interface AutoRepository extends CrudRepository<Auto, Long>{

}
