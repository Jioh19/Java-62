package com.edutecno.springSec.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.edutecno.springSec.dto.UsuarioLoginDto;
import com.edutecno.springSec.dto.UsuarioRegisterDto;
import com.edutecno.springSec.model.Usuario;
import com.edutecno.springSec.service.AuthService;

import jakarta.validation.Valid;

@Controller
public class LoginController {

	@Autowired
	private AuthService authService;

//	@PostMapping("/auth/login")
//	public ResponseEntity<?> login(@Valid @RequestBody UsuarioLoginDto loginDTO) {
//		try {
//			System.out.println("ENTRAMOS!!!!");
//			Usuario usuario = authService.autenticar(loginDTO);
//			// Aquí podrías generar un token JWT si lo necesitas
//			return ResponseEntity.ok(usuario);
//		} catch (BadCredentialsException e) {
//			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
//		}
//	}

	@PostMapping("/registro")
	public ResponseEntity<?> registro(@Valid @RequestBody UsuarioRegisterDto registroDTO) {
		try {
			Usuario usuario = authService.registrar(registroDTO);
			return ResponseEntity.ok(usuario);
		} catch (RuntimeException e) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
		}
	}

	@GetMapping("/login")
	public String login(Model model) {
		model.addAttribute("usuarioDto", new Usuario());
		return "login";
	}

}
