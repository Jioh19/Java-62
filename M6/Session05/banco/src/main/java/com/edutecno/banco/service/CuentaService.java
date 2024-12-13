package com.edutecno.banco.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.banco.model.Cuenta;
import com.edutecno.banco.repository.CuentaRepository;

@Service
public class CuentaService {

	@Autowired
	CuentaRepository cuentaRepository;
	
	public List<Cuenta> obtenerTodos() {
		return cuentaRepository.getAll();
	}
	
	public void agregarCuenta(Cuenta cuenta) {
		cuentaRepository.save(cuenta);
	}
}
