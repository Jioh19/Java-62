package com.edutecno.springService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.edutecno.springService.service.IFormaService;

@Controller
public class Controlador {
	
	@Autowired
	IFormaService formaServicio; 
	
	@RequestMapping("/")
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView("inicio");
		return modelAndView;
	}
	
//	@GetMapping
//	public String home(Model model) {
//		return "inicio";
//	}
	@RequestMapping("/ingresarforma")
	public ModelAndView ingresarUnaForma(
			@RequestParam("numero") int numero, 
			@RequestParam("nombre") String nombre ) { // String nombre = request.getParameter("nombre)
			 ModelAndView modelAndView = new ModelAndView("inicio");
			 boolean resultado = formaServicio.almacenarForma(numero, nombre);
			 modelAndView.addObject("ingresado", resultado);
			 return modelAndView;
			}
}
