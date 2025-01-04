package com.edutecno.direccionandoRol.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;

import ch.qos.logback.core.model.Model;

@Controller

public class AdminController {
	@GetMapping("admin")
	public String administrador(Model model) {
		return "admin/admin";
	}
	
	@PostMapping("adminLogin")
	public String superLogin(@RequestBody String email, @RequestHeader(name = "X-CSRF-TOKEN") String token) {
		System.out.println("El email es " + " " + email + " " + token);
		return "admin/admin";
	}
}
