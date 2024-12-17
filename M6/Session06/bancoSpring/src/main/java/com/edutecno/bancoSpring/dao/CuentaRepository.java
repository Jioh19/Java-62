package com.edutecno.bancoSpring.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutecno.bancoSpring.model.Cuenta;

public interface CuentaRepository extends JpaRepository<Cuenta, Integer>{
	
}
