package com.edutecno.springSec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutecno.springSec.model.Producto;

public interface ProductoRepository extends JpaRepository<Producto, Integer>{

}
