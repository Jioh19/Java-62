package com.edutecno.consumoApi.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edutecno.consumoApi.service.UsuarioService;

@Controller
public class IndexController {

	@Autowired
	UsuarioService service;
	
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("totalUsuarios", service.findAll().size());
		model.addAttribute("usuariosActivos", service.findAll());
		model.addAttribute("ultimoAcceso", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm")));
		model.addAttribute("version", "1.0.0");
		return "index";
	}
}
