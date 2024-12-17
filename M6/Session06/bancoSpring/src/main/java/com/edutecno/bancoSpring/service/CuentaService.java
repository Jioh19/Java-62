package com.edutecno.bancoSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.bancoSpring.dao.CuentaRepository;
import com.edutecno.bancoSpring.model.Cuenta;

@Service
public class CuentaService {
	
	@Autowired
	CuentaRepository cuentaRepository;
	
	public List<Cuenta> obtenerTodos() {
		return cuentaRepository.findAll();
	}
	
	public void agregarCuenta(Cuenta cuenta) {
		cuentaRepository.save(cuenta);
	}
}
