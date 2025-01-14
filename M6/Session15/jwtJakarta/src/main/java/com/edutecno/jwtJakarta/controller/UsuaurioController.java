package com.edutecno.jwtJakarta.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.edutecno.jwtJakarta.dto.UsuarioDto;
import com.edutecno.jwtJakarta.repository.UsuarioRepository;

@RestController
@RequestMapping("/api/usuarios")
public class UsuaurioController {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@GetMapping
	public ResponseEntity<List<UsuarioDto>> getAllUsuarios() {
		List<UsuarioDto> usuarios = usuarioRepository.findAll()
				.stream().map(UsuarioDto::new)
				.collect(Collectors.toList());
		return ResponseEntity.ok(usuarios);
	}
}
