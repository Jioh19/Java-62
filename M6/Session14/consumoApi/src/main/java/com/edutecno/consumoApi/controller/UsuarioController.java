package com.edutecno.consumoApi.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.edutecno.consumoApi.dto.Usuario;
import com.edutecno.consumoApi.service.UsuarioService;

@Controller
@RequestMapping("/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService service;
	
	@GetMapping
	public String mostrarPaginaUsuario(Model model) {
		try {
			List<Usuario> usuarios = service.findAll();
			model.addAttribute(usuarios);
			model.addAttribute("usuario", new Usuario());
			return "usuario";
		} catch (Exception e) {
			model.addAttribute("error", "Error al cargar los usuarios");
			return "usuario";
		}
	}
	
	@PostMapping("/crear")
	public String crearUsuario(@ModelAttribute Usuario usuario, RedirectAttributes redirectAttributes ) {
		try {
			service.crearUsuario(usuario);
			return "redirect:/usuarios";
		} catch (Exception e) { 
			redirectAttributes.addFlashAttribute("error", "Errpr al crear el usuario");
			return "redirect:/usuarios";
		}
	}
	
	@GetMapping("/edit/{id}") 
	public String cargarUsuarioParaEdicion(@PathVariable Integer id, Model model){
		try {
			List<Usuario> usuarios = service.findAll();
			Usuario usuarioEditar = (Usuario) usuarios.stream().filter(user -> user.getId().equals(id));
			
			model.addAttribute("usuarios", usuarios);
			model.addAttribute("usuario", usuarioEditar);
			model.addAttribute("modoEdicion", true);
			return "usuario";
		} catch (Exception e) {
			model.addAttribute("error", "Error al cargar el usuario");
			return "usuario";
		}
	}
	
	
}
