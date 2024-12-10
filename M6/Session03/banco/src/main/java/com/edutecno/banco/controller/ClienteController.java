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
import org.springframework.web.bind.annotation.RestController;

import com.edutecno.banco.model.Cliente;
import com.edutecno.springThymeleaf.model.Usuario;

@Controller
@RequestMapping("/cliente")
public class ClienteController {

	@Autowired
	List<Cliente> clientes;

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
		Map<String, String> errores = new HashMap<>();

		if (cliente.getRut() == null || cliente.getRut().trim() == "") {
			errores.put("rut", "Ingrese un rut válido");
		} else if (cliente.getRut().trim().length() < 8) {
			errores.put("rut", "El rut debe tener al menos 9 carácteres");
		}

		if (cliente.getNombre() == null || cliente.getNombre().trim() == "") {
			errores.put("nombre", "Ingrese un nombre válido");
		} else if (cliente.getNombre().trim().length() < 2) {
			errores.put("nombre", "El nombre debe tener al menos 3 carácteres");
		}

		if (cliente.getApellido() == null || cliente.getApellido().trim() == "") {
			errores.put("apellido", "Ingrese un apellido válido");
		} else if (cliente.getApellido().trim().length() < 1) {
			errores.put("apellido", "El apellido debe tener al menos 3 carácteres");
		}

		if (cliente.getUsername() == null || cliente.getUsername().trim() == "") {
			errores.put("username", "Ingrese un username válido");
		}

		if (cliente.getPassword() == null || cliente.getPassword().trim() == "") {
			errores.put("password", "Ingrese un password válido");
		}
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
