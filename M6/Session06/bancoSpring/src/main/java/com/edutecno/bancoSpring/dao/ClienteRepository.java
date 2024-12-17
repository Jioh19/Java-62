package com.edutecno.bancoSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutecno.bancoSpring.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer>{

	//Encontrar al cliente por el rut
	Cliente findByRut(String rut);
}
