package com.edutecno.bancoSpring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.edutecno.bancoSpring.dao.TransferenciaRepository;
import com.edutecno.bancoSpring.model.Cuenta;
import com.edutecno.bancoSpring.model.Transferencia;

import jakarta.transaction.Transactional;

@Service

public class TransferenciaService {

	@Autowired
	TransferenciaRepository transferenciaRepository;
	@Autowired
	CuentaService cuentaService;
	
	public List<Transferencia> obtenerTodo() {
		return transferenciaRepository.findAll();
	}
	

	@Transactional
	public void ejecutarTransferencia(Transferencia transferencia, Cuenta origen, Cuenta destino) {
		if(origen.getSaldo() < transferencia.getMonto()) {
			throw new RuntimeException("Saldo Insuficiente");
		}
		origen.setSaldo(origen.getSaldo() - transferencia.getMonto());
		destino.setSaldo(destino.getSaldo() + transferencia.getMonto());
		
		transferenciaRepository.save(transferencia);
		cuentaService.actualizarSaldo(origen);
		cuentaService.actualizarSaldo(destino);
	}
}
