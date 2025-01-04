package com.edutecno.direccionandoRol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import ch.qos.logback.core.model.Model;

@Controller
public class ClientController {
	@GetMapping("/client")
	public String cliente(Model model) {
		return "client/client";
	}
}
