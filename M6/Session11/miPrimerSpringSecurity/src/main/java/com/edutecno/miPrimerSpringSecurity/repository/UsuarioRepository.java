package com.edutecno.miPrimerSpringSecurity.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutecno.miPrimerSpringSecurity.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer>{

	Usuario findByNombre(String nombre);
}
