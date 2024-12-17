package com.edutecno.bancoSpring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/transferencia")
public class TransferenciaController {
	
	@GetMapping
	public String getTransferencia() {
		return "crearTransferencia";
	}
}
