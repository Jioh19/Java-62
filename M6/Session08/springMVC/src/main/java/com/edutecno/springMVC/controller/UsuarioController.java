package com.edutecno.springMVC.controller;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.edutecno.springMVC.model.Usuario;
import com.edutecno.springMVC.service.UsuarioService;

@Controller
public class UsuarioController {
	@Autowired
	UsuarioService us;

	@GetMapping({ "/", "/home" })
	public String home(Model model) {
		Usuario usuario = new Usuario();
		Optional<Usuario> op = us.findById(1l);
		if(op.isPresent()) {
			usuario = op.get();
			System.out.println(usuario);
		} else {
			System.out.println("no existe el usuario");
		}
		model.addAttribute(usuario);
		return "home";
	}

	@PostMapping("/add")
	public String add(Model model, @ModelAttribute Usuario usuario) {
		usuario.setId(1l);
		usuario.setEmail(usuario.getEmail());
		usuario.setPassword(usuario.getPassword());
		usuario.setUsername(usuario.getUsername());
		us.save(usuario);
		ArrayList<Usuario> listaUsuario = new ArrayList<Usuario>();
		listaUsuario.add(us.findAll().get(0));
		Usuario newUser = listaUsuario.get(0);
		model.addAttribute("usuario", newUser);
		return "exito";
	}
}