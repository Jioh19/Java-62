package com.edutecno.springSec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.edutecno.springSec.model.Producto;
import com.edutecno.springSec.service.ProductoService;

@Controller
@RequestMapping("/clientes")
public class ClientController {

	@Autowired
	ProductoService servicio;

	Producto product;

	@GetMapping("/listado_productos")
	public String listar(Model model) {
		model.addAttribute("listado", servicio.findAll());
		return "cliente";
	}
}
