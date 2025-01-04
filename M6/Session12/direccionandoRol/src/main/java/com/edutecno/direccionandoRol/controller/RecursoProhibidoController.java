package com.edutecno.direccionandoRol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class RecursoProhibidoController {
	@GetMapping("prohibido")
	public String prohibido(Model model) {
		return "error/403";
	}
}
