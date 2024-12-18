package com.edutecno.bancoSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.bancoSpring.dao.TransferenciaRepository;
import com.edutecno.bancoSpring.model.Cuenta;
import com.edutecno.bancoSpring.model.Transferencia;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class TransferenciaService {

	@Autowired
	TransferenciaRepository transferenciaRepository;
	@Autowired
	CuentaService cuentaService;
	
	public List<Transferencia> obtenerTodo() {
		//return transferenciaRepository.findAll();
		return null;
	}
	

	
	public void ejecutarTransferencia(Transferencia transferencia, Cuenta origen, Cuenta destino) {
//		origen.setSaldo(origen.getSaldo() - transferencia.getMonto());
//		destino.setSaldo(destino.getSaldo() + transferencia.getMonto());
//		
//		transferenciaRepository.save(transferencia);
//		cuentaService.agregarCuenta(origen);
//		cuentaService.agregarCuenta(destino);
	}
}
