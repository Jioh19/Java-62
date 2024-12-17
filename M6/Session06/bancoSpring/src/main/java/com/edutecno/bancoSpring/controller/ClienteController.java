package com.edutecno.bancoSpring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edutecno.bancoSpring.model.Cliente;
import com.edutecno.bancoSpring.service.ClienteService;


@Controller
@RequestMapping("/cliente")
public class ClienteController {
	
	@Autowired
	ClienteService clienteService;
	
	@GetMapping
	public String obtenerClientes(Model model) {
		List<Cliente> clientes = clienteService.obtenerTodos();
		model.addAttribute("clientes", clientes);
		return "clientes";
	}
	
	@GetMapping("/signin")
	public String nuevoCliente() {
		return "signin";
	}
	
	@PostMapping
	public String crearCliente(@ModelAttribute("cliente") Cliente cliente, Model model) {
		
		clienteService.agregarCliente(cliente);
		return "registrado";
	}
}
