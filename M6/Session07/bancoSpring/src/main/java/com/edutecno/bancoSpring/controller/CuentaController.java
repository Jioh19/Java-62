package com.edutecno.bancoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.bancoSpring.model.Cuenta;
import com.edutecno.bancoSpring.service.ClienteService;
import com.edutecno.bancoSpring.service.CuentaService;

@Controller
@RequestMapping("/cuenta")
public class CuentaController {

	@Autowired
	CuentaService cuentaService;
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public String obtenerCuentas(Model model) {
		List<Cuenta> cuentas = cuentaService.obtenerTodos();
		model.addAttribute("cuentas", cuentas);
		System.out.println(cuentas);
		return "cuentas";
	}
	
	@GetMapping("/signin")
	public String nuevaCuenta() {
		return "signinCuentas";
	}
	
	@PostMapping
	public String crearCuenta(
			@RequestParam String saldo,
			@RequestParam String cliente,
			Model model) {
		
		Cuenta cuenta = new Cuenta();
		cuenta.setSaldo(Integer.parseInt(saldo));
		cuenta.setCliente(clienteService.encontrarPorRut(cliente));
		cuentaService.agregarCuenta(cuenta);
		model.addAttribute("cuenta", cuenta);
		return "registradoCuenta";
	}
}
