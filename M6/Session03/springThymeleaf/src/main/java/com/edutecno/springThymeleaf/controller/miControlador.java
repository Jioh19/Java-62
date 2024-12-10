package com.edutecno.springThymeleaf.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.edutecno.springThymeleaf.model.Usuario;


@Controller //Es un @Componente, pero que devuelve a vistas y templates
@RequestMapping("/controlador")
public class miControlador {
	
	@Autowired
	private List<Usuario> usuarios;
//	@RequestMapping("/hola")
//	public ModelAndView hola() {
//		System.out.println("Hola desde la consola");
//		ModelAndView modelAndView = new ModelAndView("miPrimeraPagina");
//		Usuario usuario = new Usuario("Juan", "jioh", "123456");
//		System.out.println(usuario);
//		modelAndView.addObject("user", usuario);
//		return modelAndView;
//	}
	
	@RequestMapping("/form")
	public ModelAndView hola() {
		ModelAndView modelAndView = new ModelAndView("formulario");
		return modelAndView;
	}
	
//	@RequestMapping(value="/registrar", method=RequestMethod.POST)
//	public ModelAndView registrarUsuario(@ModelAttribute("usuario") Usuario user) {
//		ModelAndView modelAndView = new ModelAndView("registrado");
//		usuarios.add(user);
//		modelAndView.addObject("usuario", user);
//		return modelAndView;
//	}
	
//	@GetMapping("/hola")
//	public String hola(Model model) {
//		System.out.println("Hola desde la consola");
//		Usuario usuario = new Usuario("Juan", "jioh", "123456");
//		model.addAttribute("user", usuario);
//		return "miPrimeraPagina";
//	}
//	
	
	@PostMapping("/registrar")
	public String registrarUsuario(@ModelAttribute("usuario") Usuario user, Model model) {
		usuarios.add(user);
		model.addAttribute("usuario", user);
		return "registrado";
	}
	
	@GetMapping("/mostrarUsuarios/")
	public String mostrarUsuarios(Model model) {
		model.addAttribute("usuarios", usuarios);
		return "listarUsuarios";
	}

}
