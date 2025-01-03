package com.edutecno.miPrimerSpringSecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class InicioController {
	
	@GetMapping
	public String home(Model model) {
		return "index.html";
	}
}
