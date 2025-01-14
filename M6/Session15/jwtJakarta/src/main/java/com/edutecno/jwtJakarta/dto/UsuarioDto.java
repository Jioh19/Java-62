package com.edutecno.jwtJakarta.dto;

import com.edutecno.jwtJakarta.model.Roles;
import com.edutecno.jwtJakarta.model.Usuario;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {
	private Long id;
	private String username;
	private String email;
	private Roles rol;
	
	public UsuarioDto(Usuario usuario) {
		this.id = usuario.getId();
		this.username = usuario.getUsername();
		this.email = usuario.getEmail();
		this.rol = usuario.getRol();
	}
}
