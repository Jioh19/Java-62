package com.edutecno.controlAgricola.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.edutecno.controlAgricola.model.Arbol;

public interface ArbolRepository extends JpaRepository<Arbol, Integer>{

//	List<Arbol> findByTipoArbol(String tipoArbol);
//	
	// TipoArbol => tipo_arbol
	
//	@Query(value = "select * from arbol a where tipo_arbol = ?1",nativeQuery = true)
//	List<Arbol> buscarPorTipoDeArbol(String tipoArbol);
	
	@Query("FROM Arbol WHERE tipoArbol = :tipo_arbol")
	List<Arbol> buscarPorTipoDeArbol(@Param("tipo_arbol") String tipoArbol);
}
