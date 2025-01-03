package com.edutecno.springValidation.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.edutecno.springValidation.model.Usuario;
import com.edutecno.springValidation.service.UsuarioServiceImpl;

import jakarta.validation.Valid;

@Controller
public class usuarioController {

	
	@Autowired
	UsuarioServiceImpl usuarioService;
	
	@GetMapping({"/", "goHome"})
	public String gethome(Model model) {
		model.addAttribute(new Usuario());
		return "home";
	}
	
	@PostMapping("/add")
	public String add(
			Model model, 
			@Valid Usuario usuario, 
			Errors errors) {
		System.out.println(usuario);
		if(errors.hasErrors()) {
			System.out.println(errors);
			return "home";
		}
		Usuario creado = usuarioService.save(usuario);
		model.addAttribute("usuario", creado);
		
		ArrayList<Usuario> listaUsuario = new ArrayList<>();
		listaUsuario.add(creado);
		
		System.out.println(creado);
		return "exito";
	}
}
