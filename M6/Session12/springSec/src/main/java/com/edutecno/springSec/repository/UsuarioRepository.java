package com.edutecno.springSec.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutecno.springSec.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByUsername(String username);
	boolean existsByUsername(String username);
}
