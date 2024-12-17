package com.edutecno.banco.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.banco.model.Cliente;
import com.edutecno.banco.model.Cuenta;
import com.edutecno.banco.service.ClienteService;
import com.edutecno.banco.service.CuentaService;

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
		System.out.println(cuentas);
		model.addAttribute("cuentas", cuentas);
		return "cuentas";
	}

	@GetMapping("/signin")
	public String nuevoCliente() {
		return "signinCuentas";
	}

	@PostMapping
	public String procesarNuevoCuenta(
			@RequestParam String id,
			@RequestParam String saldo,
			@RequestParam String cliente,
			Model model) {
		Cuenta cuenta = new Cuenta(Integer.parseInt(id), Integer.parseInt(saldo), clienteService.obtenerPorRut(cliente));
		System.out.println("cuenta");
		cuentaService.agregarCuenta(cuenta);
		model.addAttribute("cuenta", cuenta);
		return "registradoCuenta";

	}
}
