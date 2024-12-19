package com.edutecno.bancoSpring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.bancoSpring.model.Cuenta;
import com.edutecno.bancoSpring.model.Transferencia;
import com.edutecno.bancoSpring.service.CuentaService;
import com.edutecno.bancoSpring.service.TransferenciaService;

@Controller
@RequestMapping("/transferencia")
public class TransferenciaController {
	
	@Autowired
	TransferenciaService transferenciaService;
	@Autowired
	CuentaService cuentaService;
	
	@GetMapping
	public String getTransferencia() {
		return "crearTransferencia";
	}
	
	@PostMapping
	public String crearTransferencia(
			@RequestParam String monto,
			@RequestParam String origen,
			@RequestParam String destino,
			Model model) {
		
		Transferencia transferencia = new Transferencia();
		Cuenta cuentaOrigen = cuentaService.buscarPorId(Integer.parseInt(origen));
		Cuenta cuentaDestino = cuentaService.buscarPorId(Integer.parseInt(destino));
		transferencia.setMonto(Integer.parseInt(monto));
		transferencia.setOrigen(cuentaOrigen);
		transferencia.setDestino(cuentaDestino);
		transferenciaService.ejecutarTransferencia(transferencia, cuentaOrigen, cuentaDestino);
		model.addAttribute(cuentaDestino);
		return "registradoCuenta";
	}
}
