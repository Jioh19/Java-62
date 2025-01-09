package com.edutecno.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutecno.api.model.Usuario;
import com.edutecno.api.service.UsuarioService;

@RestController
@RequestMapping("api/v1/usuarios")
public class UsuarioController {

	@Autowired
	UsuarioService servicio;

	@GetMapping("/lista_usuarios")
	public ResponseEntity<List<Usuario>> listar() {
		try {
			List<Usuario> lista = servicio.listar();
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PostMapping("/nuevo_usuario")
	public ResponseEntity<HttpStatus> agregar(@RequestBody Usuario usuario) {
		try {
			servicio.agregar(usuario);
			System.out.println(servicio.listar());
			return new ResponseEntity<>(HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

//	@GetMapping("/lista_usuarios")
//	public String listar(Model model) {
//		{
//			List<Usuario> lista = servicio.listar();
//			model.addAttribute("lista", lista);
//			return "index";
//		}
//	}
	
	@DeleteMapping("delete_usuario/{id}")
	public ResponseEntity<HttpStatus> eliminar(@PathVariable Integer id) {
		try {
			servicio.eliminar(id);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/modificar_usuario")
	public ResponseEntity<HttpStatus> modificar(@RequestBody Usuario usuario) {
		try {
			servicio.modificar(usuario);
			return new ResponseEntity<>(HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
