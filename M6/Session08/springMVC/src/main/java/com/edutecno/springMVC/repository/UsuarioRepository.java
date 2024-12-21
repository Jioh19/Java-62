package com.edutecno.springMVC.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.edutecno.springMVC.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long>{

}
