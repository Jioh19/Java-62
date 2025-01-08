package com.edutecno.springApi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.edutecno.springApi.service.DigimonService;


@Controller
public class DigimonController {

	@Autowired
	DigimonService service;
	
	@GetMapping
	public String listar(Model model) {
		model.addAttribute("lista", service.findAll());
		return "index";
	}
}
