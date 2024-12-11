package com.edutecno.banco.controller;

import java.util.HashMap;
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
import com.edutecno.banco.service.ClienteService;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	List<Cliente> clientes;
	@Autowired
	ClienteService clienteService;

	@GetMapping
	public String obtenerClientes(Model model) {
		model.addAttribute("clientes", clientes);
		return "clientes";
	}

	@GetMapping("/signin")
	public String nuevoCliente() {
		return "signin";
	}

	@PostMapping
	public String procesarNuevoCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
		
		Map<String, String> errores = clienteService.validarDatos(cliente);
		if (errores.isEmpty()) {
			clientes.add(cliente);
			model.addAttribute("cliente", cliente);
			return "registrado";
		} else {
			model.addAttribute("errores", errores);
			return "signin";
		}
	}

	@GetMapping("login")
	public String loginFormularioCliente() {
		return "login";
	}

	@PostMapping("login")
	public String loginCliente(
			@RequestParam String username, 
			@RequestParam String password, 
			Model model) {
		Cliente cliente;
		
		for(Cliente cli: clientes) {
			if (cli.getUsername().equals(username) && cli.getPassword().equals(password)) {
				cliente = cli;
				model.addAttribute("cliente", cliente);
				return "logueado";
			}
		}
		return "login";
	}

}
